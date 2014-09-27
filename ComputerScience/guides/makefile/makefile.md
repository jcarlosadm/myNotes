Contruindo Makefiles

fonte: http://mrbook.org/tutorials/make/.

[TOC]

#Um simples makefile

##Na teoria

Um makefile serve para agilizar o processo de compilação. Ele só irá compilar os arquivos fontes que foram modificados. Assim, nem tudo é necessário compilar. O porém é que configurar um makefile não é tão simples assim...

Em primeiro lugar, um makefile não tem extensão. Em segundo lugar, você pode dar qualquer nome a um makefile, mas o ideal é manter o nome padrão "Makefile" para algumas IDEs (como o eclipse).

Você executa um makefile de nome "Makefile" com o comando:

```
make -f Makefile
```

Isso irá executar os comandos no makefile. Em geral, embora não seja obrigatório, arquivos serão gerados. Você pode realizar uma *faxina* desses arquivos executando o comando `clean`:

```
make clean
```

Porém é necessário ter regra para `clean`.

Tenha cuidado ao executar um makefile (e seu comando `clean`). Ele tem o poder de eliminar os seus arquivos fontes se os comandos indicarem isso. Abra o makefile e entenda o seu conteúdo antes de executá-lo.

##Na prática

Bom, em primeiro lugar, um makefile executa comandos como se estivesse no terminal. A sintaxe básica é:

```
alvo: dependencias
[tab] comando do sistema
```

Por exemplo, se quisermos executar uma compilação simples, fazemos:

```
all:
	g++ main.cpp hello.cpp factorial.cpp -o hello
```

A tabulação é importante na linha do comando. Não use espaços, use tabulação. O código acima funciona, mas não é muito útil, uma vez que o projeto vai ser recompilado totalmente a cada execução. O ideal é compilar apenas aquilo que foi alterado. Para isso você tem que entender como funciona as dependências de um makefile. Vejamos um exemplo:

```
all: hello

hello: main.o factorial.o hello.o
	g++ main.o factorial.o hello.o -o hello

main.o: main.cpp
	g++ -c main.cpp

factorial.o: factorial.cpp
	g++ -c factorial.cpp

hello.o: hello.cpp
	g++ -c hello.cpp

clean:
	rm -rf *.o hello
```

Primeiro começamos com `hello`. Esse comando depende dos arquivos *main.o*, *factorial.o*, *hello.o*. Antes de executar o comando, se verifica se esses arquivos existem e se as dependências não foram modificadas. Por exemplo, em *main.o* passa-se a linha correspondente, verifica-se se *main.o* existe e se *main.cpp* foi modificado. Em qualquer uma dessas hipóteses, a linha de comando de *main.o* é executada. Isso irá gerar um arquivo *main.o* correspodente ao arquivo *main.cpp*.

Depois de executar todas as dependências, a linha de comando de `hello` é finalmente executada, gerando o binário do programa. O comando `clean` não é executado. Ele serve para quando desejarmos limpar o resultado do makefile, ou limpar só os objetos, ou qualquer outro tipo de limpeza desejada. No exemplo acima, ele remove todos os arquivos terminados em **.o** e o binário *hello*.

Antes de continuar, tenha certeza do que esses arquivos terminados em **.o** significam. Se não conseguir entender isso, pode ser difícil entender o resto.

##Adicionando variáveis e comentários

Comentários em um makefile é feito com `#`. Tenha certeza de comentar pelo menos as variáveis, que veremos mais adiante.

Em um makefile podem existir comandos com trechos repetitivos. Se você modificar um desses trechos em um comando, deverá modificar todos os outros comandos que contém o mesmo trecho. Para evitar isso, usamos variáveis:

```
CC= g++
CFLAGS= -c -Wall
```

E usando essas variáveis:

```
main.o: main.cpp
	$(CC) $(CFLAGS) main.cpp
```

Esse é um exemplo de um makefile mais completo:

```
# I am a comment, and I want to say that the variable CC will be
# the compiler to use.
CC=g++
# Hey!, I am comment number 2. I want to say that CFLAGS will be the
# options I'll pass to the compiler.
CFLAGS=-c -Wall

all: hello

hello: main.o factorial.o hello.o
	$(CC) main.o factorial.o hello.o -o hello

main.o: main.cpp
	$(CC) $(CFLAGS) main.cpp

factorial.o: factorial.cpp
	$(CC) $(CFLAGS) factorial.cpp

hello.o: hello.cpp
	$(CC) $(CFLAGS) hello.cpp

clean:
	rm -rf *o hello
```

#Makefile mais complicado:

Ok. Dá para fazer coisas interessantes com o que foi mostrado até agora. Mas é possível fazer um makefile com o mínimo de configurações. Digamos que o seu projeto é muito grande, e você precisará adicionar arquivos no seu makefile a medida que o seu projeto crescer. Isso significa adicionar mais dependências no alvo principal, extender o comando principal e gerar mais linhas para o novo objeto. Não soa tão desafiador assim, mas imagine que o alvo principal tenha uns 15 objetos. Fica um pouco difícil de ler não?

Primeiro, makefiles podem ter listas. Os itens da lista são separados por espaços:

```
SOURCES= main.cpp hello.cpp factorial.cpp
```

Segundo, você pode fazer uma série de operações com essas listas. Por exemplo, da lista *SOURCES* podemos gerar uma lista *OBJECTS*:

```
# substituindo .cpp por .o na lista SOURCES
OBJECTS=$(SOURCES:.cpp=.o)
```

Isso evita que você precise escrever mais uma lista.

Agora você pode usar macros para gerar comandos para todos os objetos e dependências. Por exemplo, para gerar o binário podemos escrever:

```
CC=g++
CFLAGS=-c -Wall
LDFLAGS=
SOURCES=main.cpp hello.cpp factorial.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=hello

all: $(SOURCES) $(EXECUTABLE)

# $@ quer dizer o alvo
$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

# $^ quer dizer todas as dependências
%.o:%.cpp
	$(CC) $(CFLAGS) $^ -o $@
```

##Exemplo usando diretórios

O exemplo a seguir gera diretórios separados para o binário e os objetos do programa:

```
############ início da configuração ############################

# diretórios dos objetos e do binário
OBJ_DIR= objects
BIN_DIR= bin

# coloque aqui a lista de objetos do programa
_OBJ= main.o hello.o factorial.o

# as flags e opções usadas
CC= g++
CFLAGS= -c -Wall
CXXFLAGS= -std=c++0x

# nome do binário gerado
BIN_NAME= main

############ fim da configuração ###############################

# gera lista de objetos com caminhos relativos na pasta de objetos
OBJ= $(patsubst %,$(OBJ_DIR)/%,$(_OBJ))

# comando para criar diretórios
MK_DIR= mkdir -p

.PHONY: makedir_objects
.PHONY: makedir_bin

all: makedir_objects makedir_bin $(BIN_NAME)

makedir_objects:
	$(MK_DIR) $(OBJ_DIR)

makedir_bin:
	$(MK_DIR) $(BIN_DIR)

$(BIN_NAME): $(OBJ)
	$(CC) -o $(BIN_DIR)/$@ $^

$(OBJ_DIR)/%.o: %.cpp
	$(CC) $(CFLAGS) $^ -o $@ $(CXXFLAGS)

.PHONY: clean
clean:
	rm -rf $(OBJ_DIR)/*.o $(BIN_DIR)/$(BIN_NAME)
```

# Projeto com subdiretórios compiláveis

Pode acontecer de precisar desenvolver um projeto que compile um ou vários subdiretórios. Neste caso, basta criar uma lista, usar a macro `MAKE` e percorrer essa lista com `foreach`. Vejamos um exemplo:

```
############ início da configuração ############################

# adicione a lista de subdiretórios compiláveis aqui
PROJECTS_LIST= subproject1 subproject2

############ fim da configuração ###############################

.PHONY: compile_subdir
compile_subdir:
	$(foreach var,$(PROJECTS_LIST),$(MAKE) -C $(var);)

.PHONY: clean
clean:
	$(foreach var,$(PROJECTS_LIST),$(MAKE) -C $(var) clean;)
```
