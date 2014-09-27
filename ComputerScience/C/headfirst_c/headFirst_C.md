Anotações do livro Head First C
>Uma observação: só fiz anotações de assuntos que antes não conhecia, ou de informações que achei interessante anotar. Não use-as como guia para aprender C. Procure o livro.

[TOC]

#**1 - Getting started with C**

##Saída

Em **C** podemos usar uma saída formatada ou não formatada. Para saída formatada, usamos `printf()`, e para saída não formatada usamos `puts()`.

Há diversos caracteres especiais no uso de `printf()` que nos permite formatar a saída como desejado. Veja o site http://www.cplusplus.com para mais detalhes.

##Executando o seu programa depois de compilado

Você pode executar o seu programa logo após a compilação, usando o caractere especial *&&*. Por exemplo:

```
gcc zork.c -o zork && ./zork
```

Procure usar a flag `-Wall` para compilar com avisos.

##Funções *void* e retornos vazios

Você pode, numa função com retorno **void** usar **return**, apenas para controlar o fluxo da função. Por exemplo:

```c
void printDivision(float a, float b){
    if(b!=0){
        printf("%f.2 \n",(float)a/b);
        // apenas para finalizar a função
        return;
    }
    else{
        printf("denominador zero!\n");
    }
}
```

#**2 - Memory and pointers**

Como **C** para por argumentos por valor para funções, o uso de ponteiros é necessário para que os argumentos possam ser alterados no destino.

##Aritmética de ponteiros

Você pode usar uma aritmética de ponteiros para percorrer um array:

```c
int drinks[]={4,2,3};
printf("3rd order: %i drinks\n",drinks[2] );
// esse printf produz o mesmo resultado do printf acima
printf("3rd order: %i drinks\n", *(drinks + 2));
```

##Tenha cuidado com *scanf*

Ao usar `scanf()` para receber caracteres, procure limitar a quantidade de caracteres que irá receber. Por exemplo:

```c
char name[40];

scan("%39s",name);
```

Informamos que esperamos até 39 caracteres mais "\0". Sem essa informação, a quantidade de caracteres informada pelo usuário pode ultrapassar o limite do array, invandindo memória alheia, algo que chamamos de *buffer overflow*, o que pode gerar problemas de segurança.

Ao invés de `scanf()`, você pode usar `fgets()`. Essa função recebe o ponteiro para o *buffer*, que pode ser uma variável do tipo **char**, depois o tamanho máximo da *string*, e por último o local de onde estão vindo os dados (em geral usamos `stdin` para o terceiro argumento).

```c
fgets(food, sizeof(food),stdin);
```

No código acima, `fgets()` usa `sizeof()` para obter o tamanho do *array*. Porém, se usássemos um ponteiro no lugar de um *array*, a função `sizeof()` retornaria o tamanho do ponteiro, e não do seu conteúdo!

Também é uma boa idéia usar `fgets()` para capturar espaços digitados pelo usuário. No caso de `scanf()`, ela recebe todos os caracteres digitados dentro do limite até o primeiro caractere de espaço, onde ela para de receber.

Antes de `fgets()` tínhamos `gets()`, uma função que não se usa mais devido a problemas de segurança, pois não é possível definir um limite de caracteres a receber.

##*Strings literals*

Uma variável que aponta para uma *string literal* não pode ser usada para mudar o conteúdo da *string*.

```c
char *cards = "JQR";
```

Mas você pode alterar uma *string literal* se esta for guardada em um *array*:

```c
char cards[] = "JQR";
```

###*String Theory*

Para gerar um array de *strings*, você precisa de um *array* bidimensional:

```c
char tracks[][80] = {
    "I left my heart in Havard Med School",
    "Newark, Newark - a wonderfull town"
};

// mostra a segunda sentença
puts(tracks[1]);
// mostra a letra "I"
puts(tracks[0][0]);
```

Para manipulação de `Strings` existe uma biblioteca chamada `string.h`, que permite coisas como comparação de strings, cópia de strings e outros tipos de manipulação.

#**7 - Advanced Functions**

Você pode criar ponteiros para funções:

```c
// declara um ponteiro para função que retorna um int e recebe um int
int (*warp_fn)(int);
// o ponteiro recebe o endereço da função go_to_warp_speed
warp_fn = go_to_warp_speed;
// usa o ponteiro como se usasse a função original
(warp_fn)(4);
```

Também pode criar array de ponteiros para função:

```c
void(*p[])(void)={do_,re_,mi_};
int i=0;
for(i=0;i<3;i++)
    (p[i])();
```

#**8 - Static and dynamic libraries**

No arquivo fonte do projeto, você pode indicar *headers files* entre os sinais **<** e **>**. O compilador sempre procura esses arquivos na pasta padrão do sistema para *header files* (que no linux costuma ser */usr/include* e */usr/local/include*, esse segundo local geralmente para *headers* de terceiros).

A opção `-I` diz ao compilador qual a pasta onde se encontram os *headers files* padrão. Para indicar a pasta atual onde o arquivo fonte se encontra, use essa opção com um ponto: `-I.`. Para indicar uma pasta na pasta raiz com o nome *myHeaderFiles*, use: `-I/myHeaderFiles`.

Ao invés de usar diversos *object files* na compilação, você pode usar um *archive file*. Um *archive file* contém diversos *object files*. Criar um é fácil, basta usar o comando `ar`:

```
ar -rcs libmyarchivefile.a object1.o object2.o
```

O comando acima cria um arquivo *libmyarchivefile.a* a partir dos arquivos objetos *object1.o* e *object2.o*. A opção `r` significa que o arquivo `.a` será atualizado se ele já existir. A opção `c` significa que o arquivo será criado sem qualquer feedback, e a opção `s` significa que será criado um índice no início do arquivo.

É importante que o *archive file* comece seu nome com *lib*. A explicação é que todos os *archive files* são *static libraries*. Além disso, ao usar esse arquivo, você informará somente a parte do nome após o *lib*; o compilador juntará *lib* com o que você informar.

Você precisa colocar esse *archive file* em algum lugar. Pode ser um lugar padrão, que varia dependendo do seu sistema operacional (no *linux* costuma ser */usr/local/lib*), ou pode usar uma opção do compilador para indicar onde seu *archive file* se encontra. Neste segundo caso, usamos a opção `-L` para indicar esse diretório, da mesma forma que a opção `-I`.

Usar um *archive file* é simples. Basta usar a opção `-l`, seguido do nome do arquivo (esse nome pode conter o caminho até o arquivo). Por exemplo:

```
gcc test.c -L/myLibs -lmyarchivefile -o test
```

O código acima indica que os *archive files* se encontram no diretório *myLibs*. Além disso, a opção `-l` diz ao compilador para procurar pelo arquivo *libmyarchivefile.a*. Veja que omitimos as partes *lib* e *.a* do nome do arquivo.

>Obs: Isso nos permite baixar (ou compilar) qualquer biblioteca e usar no diretório do projeto, sem a necessidade de instalar no diretório padrão do sistema. Isso vale para *header files* e *archive files*

Após compilar o programa, não há como esse programa ser alterado. Isso por que as bibliotecas usadas são estáticas. Para alterar um programa, é necessário recompilá-lo.

##Dynamic Liking

Ao invés de gerar um executável com bibliotecas estáticas, você pode gerar bibliotecas dinâmicas. Essas bibliotecas dinâmicas são *linkadas* em tempo de execução quando forem necessárias, o que significa que podem ser compiladas em separado sem a necessidade de recompilar o programa principal.

Gerar uma biblioteca dinâmica é um pouco mais trabalhoso, mas não tão difícil. Siga os seguintes passos:

1.Em primeiro lugar, gere um *object file* com a opção `-fPIC`. Isso cria um código de posição independente, que será carregado no tempo de execução. Alguns sistemas operacionais emitirão um alerta informando que essa opção não é necessária.

```
gcc -fPIC -c myFile.c -o myFile.o
```

2.Crie a biblioteca dinâmica com a opção `-shared`. Lembre-se que a biblioteca deve começar com a palavra `lib`. A terminação dessa biblioteca depende do sistema operacional que você está programando. No *Windows* será *.dll* (*dynamic link libraries*) para *MinGW* e *.dll.a* para *Cygwin*. *Linux* ou *Unix* usam *.so* (*shared object files*). No *Mac* será *.dylib* (*dynamic libraries*). Exemplo no *Linux*:

```
gcc -shared myFile.o -o libmyFile.so
```

3.Compile o seu programa usando a biblioteca dinâmica. O código abaixo primeiro gera um *object file* a partir do arquivo *main.c*, depois gera o programa *main* usando a biblioteca *libmyFile.so* (informar uma biblioteca dinâmica é feito do mesmo modo que uma biblioteca estática). A opção `L.` indica que a biblioteca se encontra no mesmo diretório do projeto.

```
gcc -c main.c -o main.o
gcc main.o -L. -lmyFile -o main
```

Se a biblioteca estiver em um local padrão para bibliotecas, o programa pode ser executado normalmente. Se não, é necessário informar onde se encontra a biblioteca antes. Isso é feito da seguinte forma no *Linux*:

```
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/libs
```

Isso irá fazer com que o compilador procure a biblioteca na pasta *libs* a partir da raiz do projeto. Após isso, o programa irá executar sem problemas.

Tá, digamos que seja necessário alterar o arquivo *myFile.c*. Sem problemas. Execute os passos 1 e 2 da compilação, ou seja, não compile *main* de novo. Basta gerar o arquivo *libmyFile.so* que *main* receberá o conteúdo da biblioteca sem problema nenhum!

#**9 - Processes and system calls**

*System calls* são apenas funções que vivem dentro do *kernel* do sistema operacional. A maior parte do código da biblioteca padrão de *C* depende dos *System calls*. Um exemplo é a função `system()`. Ela simplesmente manda uma *string* para a linha de comando.

```C
// imprime "hi!" no terminal
system("echo 'hi!'");
```

Você pode usar a função `system()` para iniciar outros programas em seu código.

A função `system()` pega uma *string* e manda para o sistema executar algum processo ou comando. Porém, se houver alguma ambiguidade nessa *string*, o sistema não conseguirá interpretar a mensagem. Existe uma função mais direta: `exec()`. O que essa função faz é substituir um processo por outro. Um processo é um programa sendo executado na memória. Todo processo possui um *PID*, uma identificação. Você pode usar o comando `ps -ef` para listar esses processos e seus respectivos *PIDs*.

Existem diversas funções `exec()`, cada qual com um nome um pouco diferente dos demais e com o seu próprio conjunto de parâmetros. Mas é opssível agrupar essas funções em dois grupos básicos: as funções de lista e as funções de *array*. Todas as funções `exec()` se encontram em *unistd.h*

##As funções de lista: `execl()`, `execlp()`, `execle()`

As funções de lista aceitam argumentos de linha de comando como uma lista de parâmetros, como isso:

- O programa: o caminho completo até o programa (no caso de `execl()` ou `execle()`) ou o nome do programa (no caso de `execlp()`).
- O argumentos de linha de comando: você precisa fornecer a lista de argumentos de linha de comando para o programa. O primeiro argumento deverá ser o nome do programa (isso quer dizer que o nome do programa aparecerá duas vezes).
- NULL: isso indicará quando termina a lista de argumentos de linha de comando.
- Variáveis de ambiente: se a função `exec()` termina o seu nome com a letra **e** (como `execle()`), então você poderá, se desejar, passar um *array* de variáveis de ambiente.

Exemplos:
```c
execl("/home/flynn/clu","/home/flynn/clu","paranoids","contract",NULL);
```

```c
execlp("clu", "clu", "paranoids", "contract", NULL);
```

```c
execle("/home/flynn/clu","/home/flynn/clu", "paranoids", "contract", NULL, env_vars);
```

##As funções de array: `execv()`, `execvp()`, `execve()`

Se você tiver um *array* de strings com os argumentos, então será mais fácil de passar esses argumentos.

```c
execv("/home/flynn/clu",my_args);
```

```c
execvp("clu",my_args);
```

###Passando variáveis de ambiente

Todo processo possui um conjunto de variáveis de ambiente. Esses são valores que você observa com os comandos `set` ou `env` no terminal. Eles normalmente nos passam informações úteis como a localização da pasta *home* ou onde encontrar os comandos. Programas C podem ler variáveis de ambiente com a função *getenv()* (da biblioteca *stdlib*).

##Controlando erros de chamadas do sistema

As funções *system calls* podem gerar algum erro. Por meio da biblioteca *errno*, é possível capturar esse erro e mostrar alguma mensagem amigável na tela. Esse erro ficará guardado na variável global *errno*. A função *strerro()* (da biblioteca *string*) pega a variável de erro e retorna uma *string* sobre o significado do erro.

```c
if(execle("./diner_info","./diner_info","4",NULL,my_env)==-1){
    puts(strerror(errno));
    return -1;
}
```

(p. 416)









