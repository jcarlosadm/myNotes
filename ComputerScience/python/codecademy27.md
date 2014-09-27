Anotações do tutorial online do codecademy usando python 2.7

[TOC]

--------------------------------------------------------------
#**Sintaxe Básica**

##Variáveis e Tipos de Dados

Em primeiro lugar, você deve saber onde guardar dados para depois utilizá-los certo? Bom, é para isso que existem variáveis. Para declarar uma variável em Python, basta definir o seu nome, um sinal *"="* e depois o seu valor:
```python
var_1 = 10 
```
Acontece que existem três tipos básicos de variáveis em Python: inteiro, real e booleano. O tipo real usa ponto (**.**) como separador decimal, e o tipo booleano aceita somente *True*("verdadeiro") ou *False*("falso"). 
```python
inteiro = 25 
real = 3.44 
booleano = True 
```
##Indentação

Python usa indentação ao invés de chaves para demarcar blocos. Se a indentação não for feita, em alguns casos o programa não irá funcionar. Por exemplo: 
```python
def mensagem(): 
saldo = 200.2 
return saldo 
print mensagem() 
```
O código acima não irá funcionar, pois a instrução **def** define uma função, e tudo dentro dela é um bloco. As duas linhas seguintes precisam estar indentadas: 
```python
def mensagem(): 
    saldo = 200.2 
    return saldo 
print mensagem() 
```
##Comentários

Em Python, comentários de uma linha são feitos com o sinal "**#**": 
```python
# Esse é um comentario 
```
Para comentarios com mais de uma linha, use três aspas para iniciar e três aspas para finalizar: 
```python
""" Esse e um 
comentario de 
varias linhas """ 
```
##Operações Matemáticas

As operações básicas podem ser exemplificadas juntamente com variáveis: 
```python
soma = 2 + 3 
diferença = 4 - 3 
multiplicacao = 3 * 10 
divisao = 4 / 2 
exponenciacao = 3**2 # equivale a 3 ao quadrado 
modulo = 7 % 3 # dá igual a 1, que e o resto da divisao de dois inteiros (7 e 3)
```

--------------------------------------------------------
#**Strings**


##Strings
 
Strings são caracteres literais que você define colocando-os entre aspas simples ou duplas. Se iniciar uma sequência de caracteres com aspas simples, não termine com aspas duplas! Isso quer dizer que você deverá sempre usar o mesmo tipo de aspas para iniciar e finalizar uma string. 
```python
minha_string = "Eu sei como criar strings" 
```
O código acima cria uma string e a coloca em uma variável chamada *minha_string*.

Caso você tenha iniciado uma string com aspas duplas e precisar usar aspas duplas dentro dela, para indicar uma citação por exemplo, use o símbolo de barra invertida (**"\\"**) antes da aspa dupla, caso contrário você fechará a string naquele ponto. Faça o mesmo com a aspa simples caso a tenha usado para iniciar uma string. Acontece que a barra invertida é usada para indicar caracteres especiais. 
```python
minha_string = "Ele disse \"Droga!\", e entao todo mundo se foi" 
```
Se no final da string você colocar um valor inteiro maior ou igual a zero entre colchetes, então o código retornará um caractere da sequência, contando a partir de zero (o primeiro caractere). Espaços também contam como caracteres! 
```python
minha_string = "Eu sou demais!"[4] 
```
O código acima armazena o caractere "o" na variável *minha_string* (lembre-se que a contagem começa de zero). Você pode também pegar um trecho da string colocando entre colchetes o valor inicial (a partir de zero) e o final (a partir de 0) separados por dois pontos, ou seja: 
```python 
print "Eu sou demais!"[3:5] # Vai retornar "so" 
```
Não deveria retornar "sou"? Acontece que o intervalo considera o primeiro da sequência, mas não o último. Logo, começa a partir de "s" mas não inclui "u", ficando somente "so". 
 
##Métodos de Strings
 
Existem diversos métodos que possibilitam manipular strings. Vamos começar por **len()**.
```python
minha_string = "Essa e minha string" 
variavel = len(minha_string)
```
O código acima armazena uma string na variável *minha_string* e depois usa **len()** para contar a quantidade de caracteres (ou "largura") da string armazenada em *minha_string*, armazenando essa quantidade em *variavel*. É isso que a função **len()** faz. Conta a quantidade de caracteres. Ela vem de *length*, que quer dizer largura.

O método **lower()** permite deixar todos os caracteres de uma sequência minúsculos, enquanto que **upper()** deixa maiúsculos. Você deve usar esses métodos após a string, com o ponto entre ela e o método. Essa maneira de usar o método é diferente de **len()**, pois **lower()** e **upper()** são métodos que funcionam somente com strings. O método **len()** funciona com outros tipos de dados. 
```python
print "Uma String".upper() # tudo aparece maiusculo 
minha_string = "Uma String" 
print minha_string.lower() # tudo aparece minusculo 
```
O método **str()** permite declarar uma sequência em string. Ele converte em string. Mais adiante vamos ver a importância dele na saída de dados. Por enquanto, saiba que ele pode ser usado com outros tipos de dados que não são strings, e por esse motivo é usado da mesma forma que **len()**: 
```python
print str(4) # imprime o valor inteiro 4 como string 
``` 
##Saída de Dados 
 
Para imprimir dados na tela, você usa a função **print**. Você já observou o seu uso em diversos códigos, então já deve estar familiarizado com ela.

Você pode concatenar (juntar) strings (somente strings) usando o sinal de positivo, como o código abaixo:
```python
print "Essa e "+"uma sequencia"+" de strings."
```
E se desejar concatenar números? Bom, neste caso você irá usar o método **str()**. Isso irá converter qualquer tipo de dado para string, o que permitirá a concatenação.
```python
print str(5)+" + "+str(2)+" = "+str(7) # 5 + 2 = 7
```
Outra maneira de inserir informações e variáveis em uma sequência de caracteres é usar o símbolo de percentagem ("**%**"). Dentro da string você usa "**%s**" para cada string (ou variável com string). Após a sequência de strings você usa "**%**" e depois, entre parênteses, indica as strings a serem utilizadas. 
```python
"""Outra maneira de usar 
strings para imprimir dados""" 
minha_string = "strings" 
print "Essa é %s sequencia de %s"%("uma",minha_string) 
```
Para outros tipos de dados, você pode trocar "**%s**" por: "**%d**" (inteiros; "**%3d**" permite reservar 3 espaços, "**%03d**" permite colocar até 3 zeros no lugar dos espaços não utilizados), "**%f**" (reais com zeros decimais a direita; "**%.2f**" arredonda para duas casas decimais, e "**%3.2f**" dá três espaços e arredonda para duas casas decimais) ou "**%g**" (reais sem zeros decimais a direita; mesma formatação de "**%f**").
 
##Entrada de Dados 
 
Em python, se lê a entrada de um usuário com **raw_input()**. Entre parênteses, você coloca a mensagem que irá aparecer na tela. A entrada é recebida como string. Para converter para número, use a função **int()**, e para converter para real use **float()**. 
```python
minha_string = raw_input("Digite uma string: ") 
inteiro = raw_input("Digite um valor inteiro: ") 
real = raw_input("Digite um valor real com parte decimal: ") 
inteiro = int(inteiro) 
real = float(real) 
print minha_string 
print inteiro 
print real 
```
Para não perder essa entrada, é interessante usar uma variável para armazená-la.

---------------------------------------------------------------------
#**Condicionais e Fluxo de Controle**

##Condicionais 
 
Existem seis tipos básicos de condicionais que comparam duas expressões e retornam um dentre dois valores: *True* ou *False*. São elas: **==** (igual), **!=** (diferente), **<** (menor), **>** (maior), **<=** (menor ou igual) ou **>=** (maior ou igual). Veja que o sinal **=** é de atribuição, ou seja, é usado para atribuir um valor a uma variável, enquanto que o sinal **==** é de comparação, para ver se um valor é igual a outro. 
```python 
2 + 3 == 5 
``` 
A comparação acima retorna *True*, pois 2 + 3 é igual a 5. 
```python 
-3 > -2 
``` 
A comparação acima retorna *False*, uma vez que -3 não é maior que -2. 
 
##Operadores Booleanos 
 
Operadores booleanos são operadores lógicos que trabalham em cima dos valores *True* e *False*. São três: **and**, **or** e **not**. 
 
O operador **and** só retorna *True* quando compara dois valores verdadeiros:
```python 
True and True 
``` 
Caso contrário só retorna *False*. Os dois precisam ser verdadeiros. 
 
O operador **or** só retorna *False* se os dois valores forem falsos: 
```python 
False or False 
``` 
Caso contrário só retorna *True*. Qualquer um dos dois valores pode ser *True* para retornar *True*. 
 
O operador *not* muda um valor *True* para *False* e um *False* para *True*. 
 
Como usar operadores booleanos? Veja o exemplo abaixo: 
```python 
(5 + 3*2 >= 10) and (3**2 == 9) 
``` 
Como a primeira comparação é verdadeira e a segunda também, *True and True* retorna *True*. Você pode fazer combinações com mais de um operador booleano, mas saiba que **not** é executado primeiro, **and** depois e **or** por último. Você pode mudar isso colocando parênteses nas expressões. 
 
##Se... Então... 
 
Ok. Agora podemos falar de uma estrutura condicional muito utilizada, não só em Python mas também em qualquer linguagem. 
```python 
if condicao: 
    codigo 
elif condicao2: 
    codigo2 
else: 
    codigo3 
``` 
Lembram que algumas estruturas em Python delimitam o código em seu poder através de um bloco? A instrução **if** é uma delas. O código abaixo de **if** precisa estar indentado, assim como o código abaixo de **elif** e abaixo de **else**. E após a condição, você precisa colocar dois pontos para abrir o bloco na próxima linha. 
 
**if** é a condição inicial. Você usa condições (com ou sem operadores booleanos) para **if**, e se a condição for verdadeira, o código é executado. Caso seja falso, o código não é executado, e passa para **elif** (uma abreviação de *else if*), que tem outra condição. Você pode ter mais de um **elif** no código. Caso nem **if** e nem um único **elif** seja executado, então **else** será executado. De qualquer forma, **elif** e **else** são opcionais. 
 
Você pode aninhar outros **if**'s dentro de **if**, **elif** ou **else**.
 
##Um Exemplo 
 
Esse exemplo ilustra uma validação de entrada do usuário. Pede-se para digitar um valor entre 0 e 10. Caso contrário, retorna um erro. Por enquanto não é possível pedir para digitar novamente com o que foi visto até agora (isso necessitaria do conhecimento sobre loops ou funções): 
```python 
entrada = raw_input ("Digite um valor inteiro entre 0 e 10: ") 
if entrada: # verifica se a entrada está vazia 
    entrada = int(entrada) # converte a entrada para inteiro 
    if (entrada>=0) and (entrada<=10): 
        print "O valor digitado e igual a "+str(entrada) 
    else: 
        print "O valor digitado nao esta entre 0 e 10" 
else: 
    print "Voce nao digitou um valor." 
``` 
Esse código retornará um erro caso o usuário não digite um número, e caso ele não digite um número inteiro. Tratamento de erro é um assunto para outra aula. 
 
*Observação: um método de string que poderia ser utilizado é **isdigit()** para verificar se a string digitada é composta somente de caracteres numéricos, ou **isalpha()** para verificar se são só letras.*

----------------------------------------------------------------
#**Funções**

##Sintaxe de uma Função 
 
Uma função em python começa com um cabeçalho, que inclui a palavra reservada **def**, o nome da função, qualquer parâmetro necessário entre parênteses e dois pontos. Abaixo do cabeçalho, normalmente temos um comentário opcional explicitando para que serve a função. E por último temos o corpo (indentado), com as linhas de código da função. 
```python 
def soma(n1,n2): 
    return n1+n2 
``` 
O código acima, por exemplo, retorna a soma de *n1* e *n2*. A palavra reservada **return** retorna o valor da soma para a função. Se algum parâmetro tiver algum valor padrão que será usado se o respectivo argumento (explicaremos abaixo a diferença entre argumento e parâmetro) não for fornecido, é possível defini-lo com um sinal de igualdade e o valor padrão, por exemplo: 
```python 
def soma(n1=0,n2=0): 
    return n1+n2 
``` 
Como usamos uma função? Basta escrever o seu nome com os argumentos entre parênteses (deixe os parênteses vazios se não houverem argumentos). 
```python 
soma(3,4) 
``` 
Podemos usar funções predefinidas como **print** dentro da função criada. Aliás, você pode chamar uma função dentro de outra função, o que já fornece um tipo de controle mais amplo. 
 
Quando definimos a função, os nomes entre parênteses são os parâmetros, e se você definiu algum, então deve usá-los no corpo da função. Quando chamamos a função, os valores entre parênteses são os argumentos que usamos para preencher os parâmetros necessários. Por exemplo, na função *soma* acima, *n1* e *n2* são parâmetros e *3* e *4* são argumentos. 
 
Se, ao chamar uma função, mais de um argumento é definido para um mesmo parâmetro, você deve usar um asteriscos antes do nome do parâmetro (mas não precisa usar este asterisco no corpo da função). Por exemplo, se uma função mostra as cores favoritas do usuário, poderia ser definida desta forma: 
```python 
def cores(*cor): 
    print cor 
cor(amarelo,azul,verde) 
``` 
Na última linha acima, a função é chamada com três argumentos, todos pertencentes ao mesmo parâmetro. 
 
##Importando Módulos 
 
Um módulo é um arquivo com funções e variáveis. Você pode usar esse arquivo em seu programa. Basta importá-lo. Por exemplo, para importar o módulo *math*, com diversas funções matemáticas, use: 
```ython 
import math 
``` 
Para chamar uma função deste módulo, basta digitar o nome do módulo (*math*), um ponto e o nome da função. Por exemplo, a função **sqrt()** calcula a raiz quadrada de um número, então para usa-la basta digitar: 
```python 
math.sqrt(25) # que dará igual a 5 
``` 
Você pode ainda importar somente uma função do módulo desejado. Basta usar **from**, nome do módulo, **import** e nome da função. Neste caso, para importar somente **sqrt()** do módulo *math*, faça: 
```python 
from math import sqrt 
``` 
No caso importação acima, basta escrever **sqrt()** quando for usar no corpo da função, ao invés de **math** com ponto antes. Isso equivale a criar uma mesmíssima função daquele módulo em seu programa, então tenha o cuidado de não criar funções com o mesmo nome em seu programa. 
 
Para importar todas as funções de um módulo, use um asteriscos no lugar do nome da função: 
```python 
from math import * 
``` 
Mais uma vez cuidado. Se houver, em seu programa, qualquer função com nome igual ao do módulo, haverá conflito. 
 
##Funções Disponíveis 
 
Acontece que em python temos um monte de funções já predefinidas, sem a necessidade de importação de módulo. A função **max()**, por exemplo, retorna o valor máximo de uma lista de valores inteiros e/ou reais (**max(5,3)** retorna 5, por exemplo). A função **min()** retorna o valor mínimo. A função **abs()** retorna o valor absoluto de um número (sempre positivo). Por último, a função **type()** retorna o tipo de um valor indicado, que pode ser *int* (inteiro), *float* (real) ou *unicode* (string). Os tipos *dict* e *tuple* serão explicados futuramente, não se preocupe com eles ainda. 
 
###Exemplo 
 
Ok. A função abaixo pede para o usuário digitar um valor numérico. Se ele não digitar somente caracteres numéricos, a função começa novamente. A função também não irá aceitar números com ponto decimal (o ponto não é um caractere numérico). 
```python 
def digitar(): 
    entrada = raw_input("Digite um valor numerico: ") 
    if entrada: #verifica se contem valor 
        if entrada.isdigit(): #verifica se foram digitados somente numeros 
            print entrada 
        else: 
            print "digite um numero" 
            digitar() 
    else: 
        print "Digite algum valor" 
        digitar() 
digitar()
```
--------------------------------------------------------------------
#**Listas e Dicionários**

##Listas - básico 
 
Você já conhece diversos tipos de dados, como *string*, *float* ou *int*. Acontece que uma lista (ou *list*, em inglês) é outro tipo de dado que armazena peças de informação. Por exemplo, se em uma gaveta você tem um pente, uma escova e um espelho, você pode criar uma lista com esses itens: 
```python 
gaveta = ["pente","escova","espelho"] 
``` 
Uma lista é definida entre colchetes. Você pode criar listas de quaisquer tipos de dados, mas o ideal é criar com dados do mesmo tipo. Além disso, sempre procure criar listas com itens que possuem algo em comum. 
 
Cada item em uma lista possui um índice numérico e inteiro, a começar pelo 0 (zero). Por exemplo, "*pente*", no exemplo acima, possui o índice 0 (zero). "*espelho*" possui o índice 2. Para acessar um valor da lista, basta escrever o nome da lista com o índice entre colchetes. Por exemplo, o código abaixo retorna "*escova*": 
```python 
gaveta[1] 
``` 
É possível substituir um valor na lista. Basta atribuir um valor a um índice específico. Por exemplo, o código abaixo substitui "*escova*" por "*caneta*":
```python 
gaveta[1] = "caneta" 
``` 
Você ainda pode definir uma lista dentro de outra, criando uma matriz de valores. Para selecionar um valor de uma lista dentro de outra lista, basta escrever algo como: 
```python 
lista[1][2] # seleciona o índice 1 e depois o índice 2 da lista mais profunda
```
 
##Listas - Adicionando e Manipulando Valores 
 
Você pode adicionar valores em uma lista com a função **append(*item*)** após o nome da lista e um ponto: 
```python 
gaveta.append("oculos") # adiciona o item oculos na lista gaveta 
``` 
Lembra da função **len()**? Ela também conta a quantidade de itens numa lista. 
 
Você pode acessar apenas alguns dos valores da lista. Basta escrever o nome da lista, abrir cochetes, digitar o índice inicial, dois pontos, digitar o índice final (que não é usado) e fechar os colchetes. Por exemplo: 
```python 
gaveta[1:3] # irá retornar os itens caneta e espelho. Não retorna oculos, pois o 3º índice não é mostrado. 
``` 
Se você usar apenas número e dois pontos (como em "*4:*"), o programa irá retornar daquele índice por diante. Se você usar dois pontos e um número (como em "*:4*"), o programa irá retornar do começo até o índice anterior ao mostrado (no caso, até o terceiro índice). Como strings também são listas, você pode usar essa técnica com elas também. Só tenha em mente que strings não podem ser modificadas como listas. 
 
Outra maneira de inserir valores em determinado índice é com a função **insert(*índice,valor*)**. O código abaixo insere o item "*perfume*" no índice 1, sem excluir os outros índices (os itens com índice 1 por diante recebem +1 em seus índices): 
```python 
gaveta.insert(1,"perfume") 
``` 
Você pode fazer o programa descobrir o índice de um item específico (ou o primeiro item da lista, se ele se repetir). Basta usar a função **index()**: 
```python 
gaveta.index("oculos") # retorna o índice do item óculos 
``` 
Você ainda pode ordenar os valores da lista com o a função **sort()**. Por exemplo, podemos ordenar os itens da lista gaveta da seguinte forma: 
```python 
gaveta.sort() 
``` 
##Loop for 
 
Através do loop **for** você pode usar uma estrutura que se repete uma vez para cada valor em uma lista. Por exemplo, para imprimir o nome de cada item na lista gaveta, faça: 
```python 
for i in gaveta: 
    print i 
``` 
No código acima, a variável *i* representa cada item na lista, mas poderia ser qualquer nome. 
 
Na verdade, o loop **for** não precisa de uma lista para ser usado. Se você usar a função **range(*min,max*)**, **for** irá repetir começando por *min* e terminando antes de *max* (ambos devem ser inteiros). Por exemplo: 
```python 
for i in range(1,5): 
    print i # irá imprimir os números de 1 a 4 
``` 
##Dicionários 
 
Enquanto que uma lista representa uma lista de valores, cada qual com o seu índice, um dicionário é composto por uma lista de pares, onde o primeiro valor do par é a chave. Dessa forma, você personaliza o índice de cada valor em um dicionário. Por exemplo, digamos que um personagem possui um inventário de armas chamado weapons, e cada arma nesse inventário possui um dano relacionado. Logo, podemos definir um dicionário para esse inventário: 
```python 
weapons = {"pistola":10,"espingarda":15,"canhao":20} 
``` 
Veja que um dicionário é definido entre chaves. Chamar um valor específico de um dicionário é bastante simples. Basta escrever o nome do dicionário, e colocar a chave desejada entre colchetes: 
```python 
weapons["espingarda"] # retorna o dano da espingarda 
``` 
No lugar do valor de um dicionário, você pode definir uma lista. Por exemplo, se desejarmos relacionar cada arma ao seu dano e o preço, então podemos escrever: 
```python 
weapons ={ 
"pistola":[10,120], 
"espingarda":[15,300], 
"canhao":[20,1000]} 
``` 
Acessar esses valores é bem simples: 
```python 
print weapons["pistola"][0] # retorna o dano da pistola 
print weapons["pistola"][1] # retorna o preço da pistola 
``` 
Ainda é possível definir um dicionário dentro de outro! Veja o código abaixo:
```python 
weapons ={ 
"pistola":{"preco":120,"dano":10}, 
"espingarda":{"preco":300,"dano":15}, 
"canhao":{"preco":1000,"dano":20}} 
print weapons["pistola"]["preco"] # retorna o preço da pistola 
print weapons["pistola"]["dano"] # retorna o dano da pistola 
``` 
Adicionar novos valores a um dicionário é simples. Basta escrever o nome do dicionário com a chave entre colchetes e atribuir um valor. Se a chave já existir no dicionário, o valor correspondente será reescrito. 
```python 
weapons["laser"] = 17 # atribui dano 17 a chave "laser" 
``` 
O comando **del** pode deletar um valor através de sua respectiva chave em um dicionário (você também pode usar **del** em listas): 
```python 
del weapons["laser"] 
``` 
Ao invés de deletar pela chave, você pode deletar pelo valor através da função **remove()**. Ela irá remover o primeiro par que contiver o valor: 
```python 
weapons.remove(17) 
``` 
E por fim, você pode usar o loop **for** em um dicionário. Mas cada execução do loop retornará uma chave de cada par. Assim, para acessar o valor de cada par: 
```python 
for i in weapons: 
    print weapons[i]
    
```
--------------------------------------------------------------------
#**Listas e Funções**

##Listas 
 
Na hora de inserir elementos em listas, use **append()**. Vejamos algumas técnicas com **append()**: 
```python 
n=[] 
n.append("R"*3) # gerará um elemento com RRR 
n=[] # apenas deixa a lista vazia novamente 
n.append(["R"*3]*2) # gerará uma lista dentro de n com dois elementos, cada qual "RRR" 
n = n[0] # aproveitando a linha anterior, faz n ter o valor da lista gerada 
``` 
Você já sabe como adicionar elementos em listas. Agora vamos aprender como removê-los. Mesmo que a premissa do python seja "apenas uma maneira de fazer determinada coisa", neste ponto você tem mais de uma opção. Você pode usar **pop()**, **remove()** ou **del()**. 
 
Usar **pop()** remove o item do índice que você especificar, retornando esse item. Isso pode ser útil para verificação (o item é o correto?) e para imprimir na tela. 
```python 
n=[2,5,7] 
n.pop(1) # remove o item do índice 1 e o retorna. 
``` 
Usar **remove()** retira o 1º item especificado que aparecer na tela, e não o retorna. No código abaixo, existem mais do que um número 2, logo só o primeiro 2 é removido: 
```python 
n=[3,2,5,2,6,7,2] 
n.remove(2) # remove só o primeiro número 2 que aparece na lista. 
``` 
Usar **del()** remove um item de um índice especificado de uma lista, e não o retorna para o programa. Ele é usado de uma forma um pouco diferente das outras funções. 
```python 
n=[4,3,7,2] 
del(n[1]) # remove o valor 3 da lista n, que corresponde ao índice 1 
``` 
Você pode juntar duas listas criando uma função para isso. Veja uma definição válida para essa função abaixo: 
```python 
def juntar(lista1,lista2): 
     for i in lista2: # cria um for para cada elemento da lista2 
         lista1.append(i) # adiciona cada elemento da lista2 na lista1 
     return lista1 # retorna a lista1 como uma junção entre as duas  
``` 
Também é possível juntar um número arbitrário de listas: 
```python 
def join_lists(*x): # indica que pode receber mais de uma lista 
    lista=[] 
    for i in x: 
        for j in i: # como x é uma lista de listas, é necessário selecionar cada lista 
            lista.append(j) 
    return lista 
``` 
E para inserir espaço entre dois elementos, para imprimir de uma forma mais limpa? A função **join()** retorna uma lista formatada. Comece com os caracteres que deseja colocar entre os espaços (coloque esses caracteres entre aspas), depois um ponto, depois **join** e entre parenteses a lista propriamente dita. **join()** só funciona com lista de strings. 
```python 
n = ["2","4","6"] 
print " ".join(n) # imprime 2 4 6 
``` 
##Números Aleatórios 
 
Os números aleatórios são bastante importantes em jogos. As funções aleatórias se encontram no módulo *random*. Existe uma função em particular, a **randint(*min,max*)**, que retorna um valor inteiro aleatório entre *min* e *max* (incluindo ambos). 
```python 
from random import randint # importa a função randint() 
print randint(1,20) # retorna um valor aleatório entre 1 e 20. 
``` 
lembre-se de importar a função **randint** (ou todo o módulo *random*, mas neste caso você escreverá **random.randint()** para usar a função) no topo do seu script. 
 
##Break, Continue e Range 
 
Já que você conhece o loop **for**, conheça também alguns comandos que trabalham bem com esse loop (e outros que mostraremos na próxima aula). 
 
O comando **break** interrompe o loop atual, saindo dele imediatamente. Já o comando **continue** interrompe o estágio atual do loop, começando o próximo (o loop continua). Você pode criar condições dentro do loop que ativem esses comandos, criando novas formas de controle. 
 
Outra coisa importante para o loop **for** é a função **range()**. Ela cria uma lista com valores que começam de zero até um valor inteiro anterior ao indicado na função. Ela pode ter de um até 3 argumentos. Se usado com um argumento, ele indicará o comprimento da lista criada: 
```python 
range(3) # cria uma lista igual a [0,1,2] 
``` 
Se usada com dois argumentos, a lista criada inicia com o primeiro número e termina com número imediatamente inferior ao segundo número: 
```python 
range(2,5) # cria uma lista igual a [2,3,4] 
``` 
Se usada com três argumentos, a lista começa com o primeiro argumento, é incrementada a cada vez com o terceiro argumento e termina em um valor imediatamente inferior ao segundo argumento: 
```python 
range(2,8,3) # gera uma lista igual a [2,5]
```
-------------------------------------------------------------------
#**Tupples**

http://py.franciscosouza.net/capitulo_09.html 
 
*Tupples* são como listas imutáveis. Você pode definir um tupple com uma lista de valores separados por vírgula: 
```python 
a = 'a','b','c' 
``` 
ou então com parênteses: 
```python 
a = ('a','b','c') 
``` 
Uma tupla com somente um valor deve ter uma vírgula no final. 
 
Mesmo que sejam imutáveis, uma tupple pode ser atribuída  a outra. 


----------------------------------------------------------------------
#**While e for**

##While 
 
Esse loop continua sua execução enquanto uma condição continuar sendo verdadeira. Vejamos um exemplo: 
```python 
a=True 
while valor: 
    print "Agora ele e falso" 
    a=False 
``` 
O código acima executa **while** apenas uma vez, pois o código muda o valor da variável *a* para *False*, e, na próxima verificação, o loop será interrompido. Outro exemplo: 
```python 
a=0 
while a<=10: 
    print a 
    a+=1 
``` 
O loop do código acima será executado imprimindo a variável *a* a cada vez. Essa variável é incrementada do valor 1 a cada execução, e o loop continuará enquanto a for menor ou igual a 10. Quando for maior que 10, ele será interrompido. É muito importante ter alguma forma de controle, senão o loop será infinito, e nunca terminará. 
 
Você pode usar os comandos **break** e **continue** em um loop **while**. 
 
Um loop **while** pode ter um **else**, que será executado quando **while** terminar. Se você usar **break** para interromper o loop, o **else** não será executado. 
 
##For 
 
Você já conhece esse loop das aulas anteriores. Ele é usado com uma lista, mas também pode ser usado com a função **range()**, que cria uma lista. Uma maneira diferente de usar esse loop: 
```python 
a=["zz","ww"] 
for x,y in enumerate(a): # associa um índice (x), a partir de zero, a cada valor (y).  
    print x,y # imprime o índice (x) e o valor (y) lado-a-lado em cada linha.
```
 
No código acima, você pode usar **enumerate()** para associar um índice a cada valor de uma lista. O uso de vírgula em **print** permite imprimir o próximo código na mesma linha. 
 
A função **zip()** lhe permite criar pares de duas listas passadas como argumentos para a função. O tamanho da lista criada será igual ao tamanho da lista menor. Você pode passar quaisquer quantidades de listas como argumentos para **zip()**. 
```python 
a=["s","r","e"] 
b=["y","w"] 
zip(a,b) # cria a lista [("s","y"),("r","w")] 
``` 
O loop **for** também pode ter um **else**, que será executado no final do loop. Se usar um comando **break**, o **else** não será executado.

------------------------------------------------------------------------
#**Tópicos Avançados**

##Interadores e Dicionários 
 
Ao criar um dicionário, você pode retornar os pares chave/valor do mesmo usando **items()** após um ponto: 
```python 
a = {"valor1":1,"valor2":2} 
a.items() 
``` 
Observe que a função retorna uma lista não ordenada. Use **sort()** para retornar uma lista ordenada. 
 
Ao invés de **items()**, você pode usar **keys()** para retornar uma lista de chaves do dicionário, e **values()** retorna uma lista dos valores. 
 
##List Comprehension 
 
"*Compresão de lista*" é uma técnica que permite criar listas usando algumas regras simples. Mas primeiro vamos recordar como criar listas com a função **range()**: 
```python 
lista = range(50) 
``` 
O código acima cria uma lista de 0 (zero) até 49. 
 
A sintaxe básica para uma *list comprehension* é a seguinte: 
```python 
lista = [x for x in range(1,6)] 
``` 
O código acima cria uma lista que começa em 1 e termina em 5. Já o código abaixo cria uma lista do dobro dos números de 1 a 5: 
```python 
lista = [x*2 for x in range(1,6)] 
``` 
Podemos ainda adicionar uma condicional **if** para somente aceitar valores que atendam certos critérios. 
```python 
lista = [x*2 for x in range(1,6) if x%2==0] 
``` 
O código acima retorna uma lista do dobro dos números pares. 
 
##List Slicing 
 
Agora iremos acessar apenas alguns valores de uma lista. Isso é fácil, é só usar a sintaxe: 
```python 
[inicio:fim:espaço] 
``` 
O intervalor selecionado da lista começa com início, e termina antes de fim. O espaço é o espaçamento de um índice para outro. 
 
Você pode usar somente um ou dois deste valores para criar intervalos personalizados. Por exemplo, ter somente início quer dizer que a nova lista começará de um determinado índice por diante. 
 
Um espaço negativo retorna uma lista da direita para esquerda, ou seja, ao contrário. 
 
##Lambdas 
 
*Lambdas* são funções descritas de uma forma mais simples, numa só linha. São totalmente opcionais. Exemplo: 
```python 
lambda x:x**2 # antes dos dois pontos é o valor recebido, e depois é o retorno 
``` 
A função acima é o mesmo que a função abaixo: 
```python 
def f(x): 
	return x**2 
``` 
A diferença entre usar lambda e definir uma função, é que lambda é uma função *anônima*. Não dá para definir uma lambda e depois chamá-la; ela deve ser usada no momento de sua criação. 
 
Uma função que pode ser usada em conjunto com lambda é **filter()**. Você primeiro define uma função lambda que retorne um valor *True* ou *False*, e depois uma lista, e a função **filter()** irá retornar somente os valores que atendam a exigência de lambda: 
```python 
my_list = range(16) 
print filter(lambda x: x % 3 == 0, my_list) 
``` 
O código acima irá retornar uma lista dos valores de 0 (zero)a 15 que sejam divisíveis por 3 (ou seja, os múltiplos de 3).

------------------------------------------------------------
#**Classes**

Python é uma linguagem orientada a objetos, que são estruturas de dados com propriedades (atributos em python) e métodos. 
 
Para criar um objeto usamos classes, que são estruturas com atributos e métodos comuns a um determinado tipo de objeto. A sintaxe de uma classe é bastante simples: 
```python 
class Fruit(object): 
"""A class that makes various tasty fruits.""" 
	def __init__(self, name, color, flavor, poisonous): 
		self.name = name 
		self.color = color 
		self.flavor = flavor 
		self.poisonous = poisonous 
 
	def description(self): 
		print "I'm a %s %s and I taste %s." % (self.color, self.name, self.flavor) 
 
	def is_edible(self): 
		if not self.poisonous: 
			print "Yep! I'm edible." 
		else: 
			print "Don't eat me! I am super poisonous." 
``` 
Veja que usamos a palavra reservada **class**, e que usamos **object** no parênteses. O método **__init__** será o primeiro chamado quando criado o objeto, e é onde definimos  os atributos iniciais, e quais valores passamos como parâmetros. Em todos os métodos de uma classe, sempre usamos **self** como primeiro parâmetro, pois assim indicamos que se trata de um método do objeto criado com esta classe. Para indicar atributos do objeto criado com a classe, usamos **self.atributo** 
 
Para criar um objeto desta classe, é só fazer o como segue: 
```python 
lemon = Fruit("lemon", "yellow", "sour", False) 
``` 
Para acessar os métodos deste objeto, basta usar a notação de ponto: 
```python 
lemon.description() 
lemon.is_edible() 
``` 
O mesmo fazemos para acessar seus atributos. A variável *is_alive* a seguir é variável membro, enquanto que as outras variáveis são de instância, ou seja, particulares de cada objeto: 
```python 
class Animal(object): 
"""Makes cute animals.""" 
	is_alive = True 
	def __init__(self, name, age): 
		self.name = name 
		self.age = age 
``` 
As classes em python também possuem o conceito de herança. Veja que *ReturningCustomer* herda de *Customer* a seguir: 
```python 
class Customer(object): 
    """Produces objects that represent customers.""" 
    def __init__(self, customer_id): 
        self.customer_id = customer_id 
 
    def display_cart(self): 
        print "I'm a string that stands in for the contents of your shopping cart!" 
 
class ReturningCustomer(Customer): 
    """For customers of the repeat variety.""" 
    def display_order_history(self): 
        print "I'm a string that stands in for your order history!" 
 
monty_python = ReturningCustomer("ID: 12345") 
monty_python.display_cart() 
monty_python.display_order_history() 
``` 
Os métodos podem ser redefinidos na classe que herda de outra. Você ainda pode usar **super()** para chamar métodos e atributos da classe primária ao invés de redefiní-la totalmente. Por exemplo: 
```python 
class A(object): # In Python 3, you can just do class A: 
    def routine(self): 
        print "A.routine()" 
 
class B(A): 
    def routine(self): 
        print "B.routine()" 
        super(B, self).routine() 
``` 
O método routine de um objeto instaciado da classe *B* irá apresentar a seguinte saída: 

*B.routine()*
*A.routine()*

O método **super()** é bastante útil para expandir o método **__init__** de uma classe que herda de outra, sem a necessidade de redefinir tudo, apenas alguns pontos importantes, ou quem sabe adicionar mais código.

