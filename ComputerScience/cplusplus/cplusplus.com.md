Tutorial do site cplusplus.com

[TOC]

----------

#**Structure of a program**


http://www.cplusplus.com/doc/tutorial/program_structure/ 
 
**compilação (linux) **
```
g++ program.cpp -o program 
```
**execução (linux) **
```
./program 
```
**c++ e c **

Primeiro, as bibliotecas são diferentes. Você indica as bibliotecas em c++ *sem extensão*. A biblioteca de entrada padrão em c++ é a *iostream*. Segundo que você precisa usa **std** mais o operador de escopo **::** para usar os dispositivos de entrada e saída padrão (**cout** e **cin**). Você pode evitar isso usando **using namespace std;** no início, antes de **main()**.


----------


#**Variables**

http://www.cplusplus.com/doc/tutorial/variables/ 
 
c++ possui os mesmos tipos de c, e mais alguns. Um deles é **bool**, o tipo booleano, que possui valor *true* ou *false*. 
 
Para usar o tipo string, você deve incluir a biblioteca padrão *string*. É possível mudar o conteúdo da variável do tipo string a qualquer momento com o operador de atribuição (um processo mais complicado em C). 

-----------------------------------------------
#**Constants** 

http://www.cplusplus.com/doc/tutorial/constants/ 
 
Você pode definir constantes com a palavra reservada **const**. Essa palavra impede mudanças na variável definida. 
 
Outra maneira de definir constantes em c++ é usando **#define**, da mesma forma que em C. 

-----------------------------------------------
#**Operators**

http://www.cplusplus.com/doc/tutorial/operators/ 
 
O operador ternário permite, em uma única linha, escrever uma expressão condicional. 
 
Existe o operador de cast, que é uma forma explícita de definição de um valor. Por exemplo, se você quiser que o número 3 seja tratado como float você deve fazer: 
```cpp
(float) 3; 
```
O que fará com que 3 seja tratado como float. O cast é bastante usado em operações com ponteiros, quando alocamos memória por meio de **malloc**.
 
Você pode usar o **sizeof()** para descobrir o tamanho em bytes de uma variável, da mesma forma que em C. 

----------------------------------------------
#**Basic IO** 

http://www.cplusplus.com/doc/tutorial/basic_io/ 
 
A saída padrão do c++ é **cout**. Você ainda pode usar **printf**, principalmente por que é mais fácil de formatar números com ponto flutuante, mas dá para fazer isso com **cout** também, através da função **setprecision(number)**, por meio da biblioteca *iomanip*. Porém é realmente melhor formatar com **printf**.
 
O **cout** permite alternar entre strings e variáveis, o que torna o seu uso prático. Ele não dará quebra de linha; para isso use **"\n"** ou **endl** no final de cout.
 
**cout** usa o operador **<<** para cada string ou variável a ser mostrada no dispositivo de saída. 
 
A entrada padrão é **cin**. **cin** usa o operador **>>** para cada variável a ser preenchida com a entrada do usuário. 
 
**cin** irá capturar os caracteres digitados até encontrar o primeiro espaço. Para pegar strings com espaços, use **getline(cin, *variable*)**, onde *variable* é uma variável do tipo string. 
 
Por meio da biblioteca *sstream*, você pode converter uma string em valor numérico, e vice-e-versa. Para mais detalhes, veja a biblioteca no site [cplusplus](http://www.cplusplus.com).

--------------------------------------------------
#**Control** 

http://www.cplusplus.com/doc/tutorial/control/ 
 
No loop **for**, você pode usar vírgula para inicializar mais de uma variável, assim como incrementar/decrementar mais de uma variável no final de cada loop (na verdade, você pode fazer mais de uma expressão). Em c++, ao contrário de C, você pode criar a variável de controle e inicializá-la dentro do **for**. 

------------------------------------------------
#**Functions** 

http://www.cplusplus.com/doc/tutorial/functions/ 
 
Funções em c++ são como funções em c, mas você pode fazer outras coisas em c++. 
 
Sabemos como passar variáveis por referência em C. Em c++, essa passagem pode ser facilitada, pois o trabalho de fazer a referência é feito nos parâmetros da função. 
```cpp
int funcao (int &x) 
{ 
    // 
} 
```
Ou seja, as variáveis são passadas normalmente na implementação: 
```cpp
funcao(variavel); 
```
 
Passar argumentos por referência custa menos em termos de memória do que passar por valor. Se você deseja passar uma variável por referência mas não quer que a mesma seja modificada, use a palavra reservada **const** antes do tipo do parâmetro. 
 
Ao contrário de C, em c++ podemos definir parâmetros opcionais, que são colocados por último na ordem de parâmetros. Um parâmetro opcional possui um valor padrão, definido com o sinal de atribuição e um valor. 

------------------------------------------------
#**Functions 2** 

http://www.cplusplus.com/doc/tutorial/functions2/ 
 
Em c++, duas funções podem ter o mesmo nome se tiverem parâmetros diferentes (basta um diferente, mesmo que seja o tipo). Isso se chama sobrecarregamento de funções (*overload*). O que determina qual função é chamada depende dos parâmetros usados. 
 
Se você tem uma função sobrecarregada onde só se muda o tipo de retorno e/ou os tipos dos argumentos (não precisa ser todos os argumentos, pode ser apenas um), mas o corpo da função é exatamente o mesmo para cada versão da função, talvez seja melhor usar um modelo de função (*function template*). Veja o código [aqui](http://www.cplusplus.com/doc/tutorial/functions2/) para ter uma ideia.
```cpp
template <class SomeType>
SomeType sum (SomeType a, SomeType b)
{
  return a+b;
}
```
 
Ao invés de um tipo, um modelo de função pode receber um valor.
```cpp
template <class T, int N>
T fixed_multiply (T val)
{
  return val * N;
}

int main() {
  std::cout << fixed_multiply<int,2>(10) << '\n';
  std::cout << fixed_multiply<int,3>(10) << '\n';
  return 0;
}
```

----------------------------------------------
#**Namespaces** 

http://www.cplusplus.com/doc/tutorial/namespaces/ 
 
Escopo é a visibilidade de uma entidade (variável, função ou tipos compostos). Uma entidade declarada fora de qualquer bloco é de escopo global, pois pode ser vista em qualquer lugar. Já uma entidade dentro de algum bloco é de escopo local. 
 
Você pode declarar uma dada variável com o mesmo nome em um bloco mais interno, tornando o nome desta variável local naquele bloco. Fora do bloco mais interno, a variável perde o seu valor local, voltando ao escopo que tinha anteriormente. 
 
Você pode ainda alternar entre o escopo local e global (apenas global) de variáveis de mesmo nome com o operador de escopo **::**. 
 
*namespaces*, ou espaço de nomes, é um escopo em que você define entidades para usar em seu programa. A sintaxe de namespaces é simples, basta digitar *namespace* mais o seu *identificador*, e definir as entidades membros entre chaves.
```cpp
namespace meuNameSpace{
    int xPlus;
}
```
Para acessar um membro do namespace, basta digitar identificar::membro.
```cpp
int main()
{
    cout<<meuNameSpace::xPlus<<endl;
    return 0;
}
```
Uma vez declarados, namespaces podem ser extendidos posteriormente, ou seja, você pode "redeclarar" o namespace com novos membros, e eles serão adicionados com os membros anteriores.
```cpp
// adicionando o membro yPlus em meuNameSpace
namespace meuNameSpace{
    int yPlus;
}
``` 
Você ainda pode usar a palavra reservada **using** para importar um membro de um *namespace* para um bloco, e usar esse membro normalmente, sem a necessidade do operador de escopo.
```cpp
int main()
{
    using myNameSpace::xPlus;
    cout<<xPlus<<endl;
    return 0;
}
```
Ou ainda pode usar **using namespace** para importar todos os membros de um *namespace*.
```cpp
int main()
{
    using namespace myNameSpace;
    cout<<xPlus<<endl;
    return 0;
}
```
Nós fazemos isso para importar **cout** e **cin** do *namespace* **std**. Quando você sai do escopo, a importação de membros usando **using** não é mais válida. 
 
namespaces podem ser renomeados: 
```cpp
namespace new_name = currentname;
```
 
Variáveis globais e de namespaces são alocadas para toda a duração do programa. Isso é conhecido como *armazenamento estático*. As variáveis locais possuem *armazenamento automático*. Variáveis com armazenamento estático não inicilizadas começam com valor zero. Já variáveis com armazenamento automático não inicializadas começam com lixo. 

---------------------------------------------
#**Arrays** 

http://www.cplusplus.com/doc/tutorial/arrays/ 
 
Você pode inicializar um array usando chaves: 
```cpp
int myarray[5] = {1,2,3,4,5}; 
```
Mas você não precisa definir todos os valores. De fato, os valores que você não definiu são inicializados com zero. você pode iniciliza com zero todas as posições de um array com: 
```cpp
int myarray[5] = {}; 
```
Um array também pode ser declarado sem definir um tamanho inicial, apenas por atribuição: 
```cpp
int myarray[] = {1,2,3,4,5}; 
```
Após a inicialização, o array terá o seu tamanho definido (neste caso, 5). 
 
Na inicialização de um array, você não precisa usar o sinal de igualdade. 
```cpp
// talvez você precise usar uma opção no momento da compilação
int myarray[]{1,2,3,4,5}; 
```
Na passagem de um array para uma função, você pode usar ***array*[]**, onde o tamanho é definido quando você passa o array. Quando você desejar passar arrays multidimensionais como parâmetro, deverá definir a segunda ou enésima dimensão depois da primeira, como ***array*[][2][3]**. 
 
Existe uma biblioteca, array, com funções membros diversas. veja [aqui](http://www.cplusplus.com/reference/array/array/) para mais detalhes.

----------------------------------------------
#**Character sequences** 

http://www.cplusplus.com/doc/tutorial/ntcs/ 
 
Strings são sequencias de caracteres, ou seja, uma string é um array do tipo *char*. Porém, é necessário, dentro do array, usar um espaço para determinar o fim da string. O fim da sequencia é determinado pelo caractere nulo **'\0'**.
 
Você pode inicializar uma string de diversas formas: 
```cpp
char myName[] = {'c','a','r','l','o','s','\0'}; 
char myName[] = "carlos"; 
```
No segundo caso, o caractere nulo é inserido automaticamente. Porém, essas operações só são possíveis durante a inicialização. Depois de inicializadas as variáveis, você não pode mais usar o operador de atribuição, devendo recorrer a biblioteca *cstring* para fazer operações atribuição. 
 
Usar o tipo *String* (para usar esse tipo, inclua a biblioteca *string*) permite ter strings com tamanho dinâmico.

----------------------------------------------
#**Pointer** 

http://www.cplusplus.com/doc/tutorial/pointers/ 
 
O **&** é um operador de referência. Você pode usar antes de uma variável para retornar o seu endereço na memória. **&** pode ser traduzido como "endereço de". Uma variável que guarda o endereço de outra variável é denominada ponteiro. 
 
O **\*** é denominado operador de ponteiro (claro, você já usa o mesmo para realizar multiplicações, mas esse é outro uso). Você pode ler esse operador como "valor do ponteiro que aponta para". Se usar o **\*** antes de um ponteiro, o valor do local apontado que é retornado, não o endereço. 
 
Para declarar um ponteiro, você declara um tipo o operador **\*** e o nome do ponteiro: 
```cpp
int * my_pointer; 
```
 
Para usar um ponteiro, você o iguala ao endereço da variável para o qual deseja apontar: 
```cpp
my_pointer = &my_var; 
```
Agora você pode mudar o conteúdo da variável onde o ponteiro aponta: 
```cpp
*my_pointer = 10; 
``` 
Sempre ajuda desenhar diagramas quando se lida com operações complicadas de ponteiros (quem já vem de C, os ponteiros são exatamente da mesma forma). 
 
Arrays são ponteiros que apontam para o seu primeiro elemento. Logo, a seguinte operação é válida: 
```cpp
my_pointer = my_array; 
``` 
Você pode fazer uma aritmética de ponteiros num array. As duas linhas abaixo são equivalentes: 
```cpp
my_array[5]=0; 
*(my_array + 5) = 0; 
```
 
Aliás, as seguintes linhas demostram um exemplo de uso de aritmética de ponteiro: 
```cpp
char *mychar; 
short *myshort; 
long *mylong; 
++mychar; 
++myshort; 
++mylong; 
```
Nas três últimas linhas, *mychar* incrementa o seu endereço em 1 byte (tipo *char*), *myshort* incrementa 2 bytes (tipo *short*) e *mylong* incrementa 4 bytes (tipo *long*). usar os operadores **++** e **- -** na aritmética de ponteiro pode causar alguma confusão, então tome alguns cuidados: 
```cpp
*p++ // mesmo que *(p++) 
*++p // mesmo que *(++p) 
++*p // mesmo que ++(*p) 
(*p)++ 
``` 
Um ponteiro pode ser constante, com **const** antes do tipo, o que impedirá de mudar o valor para onde ele aponta. Mas é possível um ponteiro constante apontar para uma variável não-contante! Essa é uma característica importante pois permite usar ponteiros somente leitura como parâmetros de funções; lembre-se que usar ponteiros como parâmetros de funções sempre é melhor que passar uma variável, pois quando passamos uma variável, uma memória é alocada para todos aqueles dados, enquanto que no caso de ponteiros passamos apenas a referência. 
 
String literals são ponteiros que apontam para o início de uma string: 
```cpp
const char * foo = "hello"; 
``` 
C++ permite o uso de ponteiros para ponteiros, simbolizado por ******: 
```cpp
char a; 
char *b; 
char **c; 
a = 'z'; 
b = &a; 
c = &b; 
```
Neste caso, *c* é do tipo *char\*\** e possui o endereço de *b*, *\*c* é do tipo *char\** e possui o endereço de *a* (b possui o endereço de a), e *\*\*c* é do tipo *char\*\** e possui o valor *'z'*. 
 
Você pode usar ponteiros que apontam para nulo quando uma função pode receber mais de um tipo de ponteiro para um mesmo parâmetro. Porém, você deverá usar *cast* para converter o ponteiro para o tipo apropriado na função. 
 
Uma coisa que você deve ter o cuidado é de inicializar um ponteiro. Se não houver como inicializar um ponteiro, atribua a ele o valor nulo, ou seja, **NULL**, ou **nullptr**. Isso é necessário, pois senão o ponteiro pode apontar para qualquer lugar da memória. 
 
Existe ainda ponteiros para funções. É exatamente da mesma forma que em C. São importantes, pois permitem passar funções como argumentos de outras funções. 

--------------------------------------------------
#**Dynamic memory** 

http://www.cplusplus.com/doc/tutorial/dynamic/ 
 
Em C, para alocar memória usamos **malloc**, **calloc** e **realloc**, e **free** para liberar. Em c++ podemos continuar a usar essas funções, mas existe outra alternativa: **new** e **delete**. Esses dois operadores podem ser usados por meio da biblioteca *new*, e permitem a alocação dinâmica de memória. 
 
O operador **new** permite alocar um bloco de memória. Você usa a palavra **new** mais o *tipo* para alocar um só bloco, ou adiciona colchetes com um valor inteiro maior que 1 para alocar mais de um bloco. 
```cpp
int *p = nullptr; 
p = new int[3]; 
```
Ou então: 
```cpp
p = new int; 
```
 
Após a memória ser utilizada, você precisa liberar a mesma. Neste caso, use o operador **delete** mais o *ponteiro*, ou **delete** mais colchetes vazio mais *ponteiro*. O colchetes vazio indica que você estará deletando todo o bloco. se não colocar o colchetes, você só estará deletando um único elemento, e o restante continuará alocado (o que pode gerar memory leak). 
```cpp
delete[] pointer; 
``` 
Para tratamento de excessões, quando a alocação de memória não é bem sucedida, você pode usar **nothrow**, e então verificar se o ponteiro é nulo:
```cpp
int *p = NULL;
p = new (nothrow) int[5]; 
if(p==nullptr)cout<<"memoria nao alocada"<<endl; 
```

----------------------------------------------------
#**Structures** 

http://www.cplusplus.com/doc/tutorial/structures/ 
 
Estruturas em C podem ter o uso facilitado por meio de **typedef**. Em c++, não é necessário usar **typedef**: 
```cpp
struct movie { 
    string name; 
    int rating; 
}; 

movie jango; 
jango.name.assign("Jango"); 
jango.rating = 5; 
``` 
Você pode ainda definir objetos que usam a estrutura definida após a segunda chaves (separe os objetos com o uso de vírgulas): 
```cpp
struct movie { 
    string name; 
    int rating; 
}jango; 

jango.name.assign("Jango"); 
jango.rating = 5; 
```
Você também pode usar ponteiros para estruturas. Isso é importante pois permite que se passe estruturas para funções sem novas alocações de memória.
 
As duas linhas seguintes são equivalentes: 
```cpp
// Acessa o valor de title da estrutura que o ponteiro aponta
pmovie->title; 
// equivalente
(*pmovie).title; 
```
 
Estruturas também podem contem outras estruturas. Isso é importante quando desejamos estruturas mais complexas e podemos dividir em diversas estruturas, facilitando a tarefa. 
 
Também podemos ter ponteiros dentro de uma estrutura. Se usar alocação dinâmica com esses ponteiros, tenha o cuidado de desalocar a memória depois. 

---------------------------------------------------
#**Other data types** 

http://www.cplusplus.com/doc/tutorial/other_data_types/ 
 
Usando **typedef** você pode definir um novo tipo com base em um tipo antigo:
```cpp
typedef int inteiro; 
```
Ou então você pode usar **using**: 
```cpp
using inteiro = int; 
``` 
Em C e em c++ existe o **union**, que parece e é declarado da mesma forma que uma estrutura. A diferença é que **union** aloca memória do maior tipo encontrado nela. Isso quer dizer que você só pode usar um membro por vez. Quando usar um membro diferente, um membro anterior será "apagado". Qual a vantagem de usar unions? imagine o caso de membros parecidos, mas com características de armazenamento diferentes: 
```cpp
union coin{ 
    float dolar; 
    int yen; 
}; 
```
A vantagem de usar **union** neste caso é simplesmente poder usar dolar ou yen, dependendo da situação, ou seja, você não pode usar ambos ao mesmo tempo. 
 
Unions podem ter declarações anônimas.
```cpp
struct {
  char title[50];
  char author[50];
  union {
    float dollars;
    int yen;
  };
} book;

book.dollars
book.yen
``` 
Ou:
```cpp
struct {
  char title[50];
  char author[50];
  union {
    float dollars;
    int yen;
  } price;
} book;

book.price.dollars
book.price.yen
```
Existe um tipo que enumera variáveis automaticamente: **enum**. você pode declarar **enum** como um tipo e como um objeto. Os seus membros são enumerados automaticamente a partir do zero (mas você pode usar o operador de atribuição para mudar a enumeração dos membros da maneira que desejar). Por exemplo: 
```cpp
enum colors{red=2, blue, black, yellow=100} my_color; 
```
é um enumerador em que eu posso declarar uma variável do tipo *colors* para receber *red*, *blue*, *black* ou *yellow* (não pode ser outra coisa senão os membros do **enum**). Ou então posso usar o objeto *my_colors* para receber esses valores (não é necessário declarar). De qualquer forma, *red* é igual a 2, *blue* é igual a 3, *black* é igual a 4 e *yellow* é igual a 100. 
 
**enum** é útil quando queremos evitar atribuir índices sem significado no contexto do programa, facilitando a execução de grandes projetos. 

----------------------------------------------------
#**Classes (I)**

http://www.cplusplus.com/doc/tutorial/classes/ 
 
Classes são como estruturas, mas elas também podem comportar funções membros.
 
*(uma observação: sim, dá para fazer isso com estruturas, bastando usar ponteiros para funções, mas acontece que classes possuem outras funcionalidades, como por exemplo herança; veremos isso mais adiante)*
 
Na declaração de uma classe, você pode declarar o tipo da classe e um ou mais objetos: 
```cpp
class class_name{ 
    access1: 
    member1; 
 
    access2: 
    member2; 
}object1; 
```
Veja que o tipo é *class_name* e o objeto é *object1* (embora isso seja possível, o melhor é criar os objetos com o nome da classe). O *access1* e *access2* são os acessos possíveis dos membros que vem depois (*member1* tem acesso de *access1*, e *member2* tem o acesso de *access2*). c++ permite os seguintes acessos: 
 
- **public:** o membro pode ser acessado em qualquer lugar onde o objeto é visível. 
- **private:** o membro só pode ser acessado dentro da classe (todos os membros de classe são privados por padrão). Procure deixar as variáveis de instância privadas (um processo conhecido como *encapsulamento*), e crie métodos públicos *setter* e *getter* de acesso.
- **protected:** o membro só pode ser acessado dentro da própria classe ou de classes derivadas dela. Se uma variável de instância puder ser acessada por classes derivadas, mas você quer manter longe do acesso público, então configure-as como *protected*.
 
Com uma classe é possível instanciar diversos objetos. 
 
Um construtor é uma função padrão que automaticamente é chamada quando um novo objeto é criado. Em geral, a utilidade de um construtor é configurar as propriedades iniciais do objeto. 
 
A declaração de um construtor é feita da mesma forma que qualquer outra função de classe, exceto que um construtor tem o mesmo nome que sua classe, e não tem tipo de retorno, nem mesmo *void*. O construtor deve ser público. 
```cpp
class myClass {
    
    // acesso público
    public:

    // construtor
    myClass(/* parâmetros */){
        // código
    }
};
``` 
Construtores não são chamados explicitamente como outras funções. eles são "disparados" quando um novo objeto é criado, e então não são chamados novamente para o mesmo objeto.

Você pode ter dois construtores. Um, o primeiro, será o construtor padrão, sem argumentos, e o outro será o construtor com argumentos. Se criar um objeto sem parênteses de argumentos, o construtor padrão é disparado. Porém, se for dado algum argumento, ou parênteses vazio, o último construtor será o executado.
```cpp
class Rectangle {
    int width, height;
  public:
    Rectangle ();
    Rectangle (int,int);
    int area (void) {return (width*height);}
};

Rectangle::Rectangle () {
  width = 5;
  height = 5;
}

Rectangle::Rectangle (int a, int b) {
  width = a;
  height = b;
}
```
Você também pode ter ponteiros que apontam para classes, da mesma forma que um ponteiro que aponta para uma estrutura (inclusive para o caso de alocação dinâmica).

-----------------------------------------------------
#**Classes (II)**

http://www.cplusplus.com/doc/tutorial/templates

##this

Em c++ existe a palavra reservada **this**, que é um ponteiro para o objeto em que uma função membro está sendo executada. Essa palavra é usada em uma função membro de classe para se referir ao próprio objeto.

Um dos usos é checar se um argumento passado para uma função membro é o próprio objeto. Também pode ser usado para retornar uma referência para o próprio objeto. Ademais, não se tem muito uso de this, uma vez que em c++ as variáveis membros de uma classe sempre se referem aos objetos instanciados.

##static members

Em c++ temos ainda os membros estáticos, ou *static members*, de uma classe. São comumente denominados *"variáveis de classe"*, pois o seu valor é compartilhado por todos os objetos da mesma classe. Variáveis *static* são bastante usadas para contar a quantidade de objetos da mesma classe (neste caso são incrementadas nos construtores e decrementadas nos destrutores):
```cpp
static int n;
```
É necessário inicializar a variável static uma vez, fora da classe:
```cpp
int ClassName::n = 0;
```
Para acessar a variável, digite o nome da classe, o operador de escopo e o nome da variável:
```cpp
ClassName::n;
```
c++ também pode ter funções *static*.

##Const member functions

Você pode ter objetos constantes:
```cpp
const MyClass myobject;
```
Neste caso, o acesso aos seus membros fora da classe é somente leitura, como se suas variáveis de instância fossem constantes.

Para ter acesso aos métodos de objeto constante, você deverá adicionar a palavra **const** antes das chaves e depois dos argumentos do método:

```cpp
int getX() const{
    return x;
}
```

Você pode usar usar essa informação para passar objetos para funções, e impedir que sejam modificados nela. Melhor, também use ponteiros para evitar alocação desnecessária de memória:
```cpp
// const objects
#include <iostream>
using namespace std;

class MyClass {
    int x;
  public:
    MyClass(int val) : x(val) {}
    const int& get() const {return x;}
};

void print (const MyClass& arg) {
  cout << arg.get() << '\n';
}

int main() {
  MyClass foo (10);
  print(foo);

  return 0;
}
```

Observe que, neste caso, é bom nomear os métodos que não modificam as variáveis de instância como **const**, para permitir essa passagem para funções.

O tipo de returno de um método membro de uma classe também pode ser constante (como no exemplo acima), mas não é necessário, a menos que esse seja o propósito do método.

##Class templates

Você também pode usar *templates* em classes:

```cpp
template <class T>
class mypair {
    T values [2];
  public:
    mypair (T first, T second)
    {
      values[0]=first; values[1]=second;
    }
};
```
O uso é bem simples:
```cpp
mypair<int> myobject (115, 36);
```

Para definir um método fora da classe (como a função abaixo retorna **T**, esse retorno aparece primeiro abaixo):
```cpp
template <class T>
T mypair<T>::getmax ()
{
  T retval;
  retval = a>b? a : b;
  return retval;
}
```
##Template Specialization

Você pode definir uma classe modelo, mas também pode definir uma especialização da classe modelo já definida. Uma especialização é uma definição específica para um tipo específico do modelo:
```cpp
// template specialization
#include <iostream>
using namespace std;

// class template:
template <class T>
class mycontainer {
    T element;
  public:
    mycontainer (T arg) {element=arg;}
    T increase () {return ++element;}
};

// class template specialization:
template <>
class mycontainer <char> {
    char element;
  public:
    mycontainer (char arg) {element=arg;}
    char uppercase ()
    {
      if ((element>='a')&&(element<='z'))
      element+='A'-'a';
      return element;
    }
};

int main () {
  mycontainer<int> myint (7);
  mycontainer<char> mychar ('j');
  cout << myint.increase() << endl;
  cout << mychar.uppercase() << endl;
  return 0;
}
```
Uma observação: não há herança aqui! Todos os membros precisam ser definidos na especialização.

------------------------------------------------

#**Special Members**

http://www.cplusplus.com/doc/tutorial/classes2/

Funções membros especiais são funções implicitamente definidas como membros de classes sob certas circunstâncias.

##Construtor padrão

Quando não você define um construtor, um é definido de forma implícita. Porém, se você definir um construtor com argumentos, e instancializar um objeto sem parânteses (quando não há argumentos; colocar argumentos provoca erro), nenhum construtor padrão é usado; é necessário definí-lo de forma explícita.

##Destructor

Um destrutor é chamado quando um objeto deixa de existir. Definir um destrutor é semelhante a definir um construtor, exceto pelo sinal de til **("~")** como primeiro caractere do destrutor.
```cpp
~Square(){}; // destrutor da classe Square
```
Quando você não define um destrutor, é usado um destrutor padrão. Qual a importância de um destrutor? Várias, entre elas manipular variáveis **static** e liberar memória alocada; ou seja, você pode realizar processos de alocação e liberação de memória dentro da classe!

```cpp
// destructors
#include <iostream>
#include <string>
using namespace std;

class Example4 {
    string* ptr;
  public:
    // constructors:
    Example4() : ptr(new string) {}
    Example4 (const string& str) : ptr(new string(str)) {}
    // destructor:
    ~Example4 () {delete ptr;}
    // access content:
    const string& content() const {return *ptr;}
};

int main () {
  Example4 foo;
  Example4 bar ("Example");

  cout << "bar's content: " << bar.content() << '\n';
  return 0;
}
```

##Copy constructor

Se um objeto é declarado como sendo igual a outro objeto, um construtor de cópia é invocado, criando um novo objeto com os estados de um outro objeto. Isso **NÃO** é o mesmo que um ponteiro que guarda a referência para um objeto já existente, pois na prática ainda teríamos umm objeto. Um construtor de cópia cria um novo objeto.
```cpp
// copy constructor: deep copy
#include <iostream>
#include <string>
using namespace std;

class Example5 {
    string* ptr;
  public:
    Example5 (const string& str) : ptr(new string(str)) {}
    ~Example5 () {delete ptr;}
    // copy constructor:
    Example5 (const Example5& x) : ptr(new string(x.content())) {}
    // access content:
    const string& content() const {return *ptr;}
};

int main () {
  Example5 foo ("Example");
  Example5 bar = foo;

  cout << "bar's content: " << bar.content() << '\n';
  return 0;
}
```
O construtor de cópia acima (retirado do site cplusplus) poderia ser definido da seguinte forma:
```cpp
// deixando o construtor de cópia mais legível
Example5(const Example5 &x){
    ptr = new string;
    (*ptr).assign(x.content());
}
```
Você não precisa declarar um construtor de cópia, a menos que queira que ele faça mais do que apenas copiar (como alocar memória, ou manipular variáveis **static**).

##Copy assignment

Nós sabemos inicializar um objeto como cópia de outro objeto. Mas e se você quiser fazer com que um objeto já inicializado seja igual a outro objeto? Não é a mesma coisa?

Não. A atribuição de objetos, com o sinal de igualdade, é uma operação diferente do construtor de cópia. É denominada atribuição de cópia.
```cpp
MyClass& operator=(const MyClass&);
```
Exemplo:
```cpp
Example5& operator= (const Example5& x) {
  delete ptr;                      // delete currently pointed string
  ptr = new string (x.content());  // allocate space for new string, and copy
  return *this;
}
```

Ou:

```cpp
Example5& operator= (const Example5& x) {
  *ptr = x.content();
  return *this;
}
```
A declaração da atribuição de cópia deve ser explícita.

##Tópicos adicionais

Dê uma olhada no link fornecido no início desta seção.

-----------------------------------------------------

#**Friendship and inheritance**

http://www.cplusplus.com/doc/tutorial/inheritance/

##Friend functions

A princípio, membros protegidos ou privados não podem ser acessados fora da classe. Essa regra não se aplica às "*friends*".

*Friends* são funções ou classes declaradas com a palavra chave **friend**.

Uma função não-membro pode acessar membros protegidos ou privados de uma classe se for uma função *friend* da mesma.
```cpp
// friend functions
#include <iostream>
using namespace std;

class Rectangle {
    int width, height;
  public:
    Rectangle() {}
    Rectangle (int x, int y) : width(x), height(y) {}
    int area() {return width * height;}
    friend Rectangle duplicate (const Rectangle&);
};

Rectangle duplicate (const Rectangle& param)
{
  Rectangle res;
  res.width = param.width*2;
  res.height = param.height*2;
  return res;
}

int main () {
  Rectangle foo;
  Rectangle bar (2,3);
  foo = duplicate (bar);
  cout << foo.area() << '\n';
  return 0;
}
```
Observe que dentro da classe *Retangle* definimos que a função *Retangle duplicate* é friend dela.

##Friend classes

De maneira similar, classes podem ser *friends* de outras classes.

A transitividade entre *friends* não existe! A *friend* de uma *friend* não é considerada *friend*, a menos que declarada explicitamente.

##Inheritance between classes

Como toda linguagem orientada a objetos, c++ permite herança entre classes. A herança ocorre quando passamos as caracteríticas de uma *classe base* para outra *classe derivada*. A *classe derivada* herda os membros da *classe base*, mas também possui seus próprios membros.

Somente membros **public** e **protected** da classe base são herdados. Membros **private** não são herdados.

A sintaxe:
```cpp
class derived_class_name : public basic_class_name
{/*...*/};
```

A palavra **public** acima define o nível mais acessível dos membros herdados. Neste caso, o nível mais acessível é **public**, então os membros herdados são repassados com os seus respectivos níveis de restrição sem qualquer alteração. Se for informado **protected**, por exemplo, então o nível mais acessível é **protected**, o que quer dizer que todos os membros herdados de nível **public** são herdados como **protected** (membros **protected** continuam **protected**). Se usarmos **private**, então os membros **public** e **protected** são herdados como **private**. Essas regras não se aplicam aos membros próprios da classe, sobre aos membros herdados.

Exemplo (do site cpluplus.com):
```cpp
// derived classes
#include <iostream>
using namespace std;

class Polygon {
  protected:
    int width, height;
  public:
    void set_values (int a, int b)
      { width=a; height=b;}
 };

class Rectangle: public Polygon {
  public:
    int area ()
      { return width * height; }
 };

class Triangle: public Polygon {
  public:
    int area ()
      { return width * height / 2; }
  };
  
int main () {
  Rectangle rect;
  Triangle trgl;
  rect.set_values (4,5);
  trgl.set_values (4,5);
  cout << rect.area() << '\n';
  cout << trgl.area() << '\n';
  return 0;
}
```

Se nenhum nível de acesso é especificado na herança, o compilador assume como **private** para classes e **public** para *structs*.

##What is inherited from the base class?

Uma *classe derivada* herda todos os membros da classe base exceto:

- O seu contrutor e destrutor
- Os seus membros de operação de igualdade (operator=)
- Os seus amigos

Mesmo que os contrutores e destrutores da *classe base* não sejam herdados pela *classe derivada*, eles ainda são chamados no construtor da *classe derivada*. Quando não especificado, o construtor chamado é o padrão, sem argumentos (que deve existir). Quando especificado, o construtor da *classe base* é chamado da seguinte forma:
```cpp
Daughter (int a) // construtor padrão da classe base é chamado
{ cout << "Daughter: int parameter\n\n"; }

Son (int a) : Mother (a) // construtor específico é chamado
{ cout << "Son: int parameter\n\n"; }
```

Se não for especificado um construtor e a classe base não tiver um construtor padrão, o código não será compilado.

##Multiple inheritance

Uma classe pode herdar de mais de uma classe, separadas por vírgulas.

```cpp
class Rectangle: public Polygon, public Output;
class Triangle: public Polygon, public Output;
```

-----------------------------------------------

#**Polymorphism**

http://www.cplusplus.com/doc/tutorial/polymorphism/

##Pointers to base class

Uma das características chave de herança de classe é que um ponteiro para a classe derivada possui tipo compatível com um ponteiro para a sua classe base.

Exemplo (retirado do site cplusplus):
```cpp
// pointers to base class
#include <iostream>
using namespace std;

class Polygon {
  protected:
    int width, height;
  public:
    void set_values (int a, int b)
      { width=a; height=b; }
};

class Rectangle: public Polygon {
  public:
    int area()
      { return width*height; }
};

class Triangle: public Polygon {
  public:
    int area()
      { return width*height/2; }
};

int main () {
  Rectangle rect;
  Triangle trgl;
  Polygon * ppoly1 = &rect;
  Polygon * ppoly2 = &trgl;
  ppoly1->set_values (4,5);
  ppoly2->set_values (4,5);
  cout << rect.area() << '\n';
  cout << trgl.area() << '\n';
  return 0;
}
```

Qual a utilidade disso? Digamos que você tenha uma função que recebe um ponteiro para um objeto. Só que a função só se preocupa que o objeto deve ser da classe *Animal*. Você tem um objeto da classe *Dog* e outro da classe *Cat*. Como ambos derivam da classe *Animal*, você pode passá-los para a função!

Como o ponteiro é da *classe base*, você só pode acessar membros dessa classe. Membros da classe derivada não podem ser acessados dessa forma.

##Virtual members

Membros virtuais são membros que podem ser redefinidos na classe derivada. Membros virtuais são declarados na *classe base* por meio da palavra **virtual**.

Exemplo (do site cplusplus):

```cpp
// virtual members
#include <iostream>
using namespace std;

class Polygon {
  protected:
    int width, height;
  public:
    void set_values (int a, int b)
      { width=a; height=b; }
    virtual int area ()
      { return 0; }
};

class Rectangle: public Polygon {
  public:
    int area ()
      { return width * height; }
};

class Triangle: public Polygon {
  public:
    int area ()
      { return (width * height / 2); }
};

int main () {
  Rectangle rect;
  Triangle trgl;
  Polygon poly;
  Polygon * ppoly1 = &rect;
  Polygon * ppoly2 = &trgl;
  Polygon * ppoly3 = &poly;
  ppoly1->set_values (4,5);
  ppoly2->set_values (4,5);
  ppoly3->set_values (4,5);
  cout << ppoly1->area() << '\n';
  cout << ppoly2->area() << '\n';
  cout << ppoly3->area() << '\n';
  return 0;
}
```

Membros virtuais são importantes pois permitem que ponteiros para a *classe base* possam acessar "*membros específicos*" da *classe derivada*. Esses membros são algo como: *"ei, eu não sei o que farei com isso agora, mas você verá a sua implementação na classe derivada"*.

Claro, como no exemplo acima, a classe base pode ter a sua própria implementação da função membro virtual.

Uma classe que declara ou herda funções virtuais é chamada de *classe polifórmica*.

##*Abstract base classes*

*Classes base abstratas* diferem das classes polifórmicas no sentido em que são usadas somente como classe base, e também permitem funções membro virtuais sem definição (conhecidas como *funções virtuais puras*).

No exemplo abaixo (retirado do site cplusplus), temos uma função virtual pura, indicada por "=0" após os parâmetros da função:

```cpp
// abstract class CPolygon
class Polygon {
  protected:
    int width, height;
  public:
    void set_values (int a, int b)
      { width=a; height=b; }
    virtual int area () =0; // função virtual pura
};
```

Classes com pelo menos uma função virtual pura são conhecidas como *classes base abstrata*.

Classes base abstrata não podem ser usadas para instanciar objetos. Mas a sua vantagem está no poliformismo. Exemplo (retirado do site cplusplus):

```cpp
// abstract base class
#include <iostream>
using namespace std;

class Polygon {
  protected:
    int width, height;
  public:
    void set_values (int a, int b)
      { width=a; height=b; }
    virtual int area (void) =0;
};

class Rectangle: public Polygon {
  public:
    int area (void)
      { return (width * height); }
};

class Triangle: public Polygon {
  public:
    int area (void)
      { return (width * height / 2); }
};

int main () {
  Rectangle rect;
  Triangle trgl;
  Polygon * ppoly1 = &rect;
  Polygon * ppoly2 = &trgl;
  ppoly1->set_values (4,5);
  ppoly2->set_values (4,5);
  cout << ppoly1->area() << '\n';
  cout << ppoly2->area() << '\n';
  return 0;
}
```

--------------------------------------------------

#**Type conversions**

http://www.cplusplus.com/doc/tutorial/typecasting/

##Implicit conversion

A convesão implícita é executada automaticamente quando um valor é copiado para um tipo comptatível. Por exemplo:
```cpp
short a = 20;
int b;
b = a;
```

Temos acima o que chamamos de uma *conversão padrão*, que é uma conversão sem a necessidade de qualquer operador explícito. Conversões padrão afetam os tipos fundamentais de dados, e permitem a conversão entre tipos numéricos (*short* para *int*, *int* para *float*, *double* para *int*...), para/de booleano, a algumas conersões de ponteiros.

Converter para *int* de algum tipo inteiro menor, ou para *double* de float é conhecido como *promoção*, e o valor é repassado sem perdas. Outras conversões podem gerar valores diferentes no destino:

- Como o tipo *unsigned* não possui valor negativo (sua representação não possui o sinal), uma conversão para *unsigned* trata os valores negativos como os maiores valores para o seu tipo.
- A conversão de/para *bool* considera *false* equivalente a zero (para tipos numéricos) e para ponteiro *NULL* (para tipos ponteiros); *true* é convertido para 1.
- Se a conversão é de um tipo de ponto flutuante para um tipo inteiro, a parte decimal é removida. Se o resultado estiver fora do limite definido por seu tipo, a conversão causa *undefined behavior*.
- De outro modo, se a conversão é entre tipos numéricos da mesma categoria (inteiro-para-inteiro, por exemplo), a conversão é *específica da implementação*, e pode não ser portável.

Algumas dessas conversões podem causar perda de precisão. Isso pode ser evitado com uma conversão explícita.

Para tipos não fundamentais, arrays e funções convertem implicitamente para ponteiros, e ponteiros em geral seguem a seguinte conversão:

- *Ponteiros Nulos* podem ser convertidos para ponteiros de qualquer tipo.
- Ponteiros de qualquer tipo podem ser convertidos para ponteiros do tipo *void*
- Ponteiro *upcast*: ponteiros para uma classe derivada podem ser convertidos para um ponteiro para uma classe base *acessível* e *sem ambiguidade*, sem modificar sua qualificação *const* ou *volatile*.

##Implicit conversions with classes

Nas classes, as conversões implícitas podem ser controladas por meio de três funções membros:

- **Contrutores de um único argumento**: permite conversão implícita de um tipo particular para inicializar um objeto.
- **Operador de atribuição**: permite conversão implícita de um tipo particular nas atribuições.
- **Operador de Type-cast**: permite conversão implícita para um tipo particular.

Por exemplo (retirado do site cplusplus):

```cpp
// implicit conversion of classes:
#include <iostream>
using namespace std;

class A {};

class B {
public:
  // conversion from A (constructor):
  B (const A& x) {}
  // conversion from A (assignment):
  B& operator= (const A& x) {return *this;}
  // conversion to A (type-cast operator)
  operator A() {return A();}
};

int main ()
{
  A foo;
  B bar = foo;    // calls constructor
  bar = foo;      // calls assignment
  foo = bar;      // calls type-cast operator
  return 0;
}
```

##Keyword explicit

A palavra chave **explicit** impede conversão implícita. Veja o código abaixo (retirado do site cplusplus):

```cpp
// explicit:
#include <iostream>
using namespace std;

class A {};

class B {
public:
  explicit B (const A& x) {}
  B& operator= (const A& x) {return *this;}
  operator A() {return A();}
};

void fn (B x) {}

int main ()
{
  A foo;
  B bar (foo);
  bar = foo;
  foo = bar;
  
//  fn (foo);  // not allowed for explicit ctor.
  fn (bar);  

  return 0;
}
```

O que temos acima é que o argumento da função *fn* é do tipo *B*. O tipo *A* poderia ser usado por conversão implícita, mas definimos explicitamente essa conversão, então isso deve ser feito explícitamente.

Qual a utilidade? Há casos específicos em que precisamos ter o cuidado de declarar um argumento corretamente, e evitar que um argumento errado seja convertido automaticamente, passando pelo compilador.

##Type casting

O type casting é uma maneira de declarar explicitamente o tipo do valor declarado. Por exemplo:

```cpp
float x = 10/3;
```

Sabemos que 10 e 3 são inteiros. O resultado da divisão deverá dar inteiro, então as partes decimais são perdidas. No final, o resultado será 3, que será convertido para *float*. Se você colocar o type cast antes, a divisão ocorrerá corretamente:

```cpp
float x = (float) 10/3;
```

Ou pode fazer:

```cpp
float x = float(10)/3;
```

Podemos também declarar ponteiros explicitamente desta maneira (exemplo retirado do site cplusplus):

```cpp
// class type-casting
#include <iostream>
using namespace std;

class Dummy {
    double i,j;
};

class Addition {
    int x,y;
  public:
    Addition (int a, int b) { x=a; y=b; }
    int result() { return x+y;}
};

int main () {
  Dummy d;
  Addition * padd;
  padd = (Addition*) &d;
  cout << padd->result();
  return 0;
}
```

O *type cast* evita erros comuns advindos de conversões implícitas inesperadas. Mas você pode querer usar a conversão implícita, então tenha o cuidado de não usar *type cast* sem pensar um pouco.

##dynamic_cast

Quando você tem um ponteiro de um tipo de uma classe base e deseja converter para um tipo derivado dela, pode usar *dynamic_cast* para isso.

*(Um lembrete da parte sobre poliformismo: um ponteiro para a base pode guardar a referência para um objeto de classe derivada dessa base. Mas ainda será um ponteiro para a base, ou seja, não poderá acessar o conteúdo exclusivo da classe derivada. O dynamic_cast permite converter o ponteiro para o tipo derivado, e assim acessar o conteúdo exclusivo)*

Vejamos um exemplo (retirado do site cplusplus):

```cpp
// dynamic_cast
#include <iostream>
#include <exception>
using namespace std;

class Base { virtual void dummy() {} };
class Derived: public Base { int a; };

int main () {
  try {
    Base * pba = new Derived;
    Base * pbb = new Base;
    Derived * pd;

    pd = dynamic_cast<Derived*>(pba);
    if (pd==0) cout << "Null pointer on first type-cast.\n";

    pd = dynamic_cast<Derived*>(pbb);
    if (pd==0) cout << "Null pointer on second type-cast.\n";

  } catch (exception& e) {cout << "Exception: " << e.what();}
  return 0;
}
```

Os ponteiros **pba** e **pbb** são ponteiros para a classe **Base**, o primeiro apontando para um espaço alocado para **Derived**, e o segundo apontando para um espaço alocado para **Base**.

Depois vemos uma declaração do ponteiro **pd** do tipo derivado.

O primeiro uso do **dynamic_cast** é bem sucedido, pois **pba** aponta para **Derived**, e tentamos converter exatamente para esse tipo. Porém, no segundo uso de **dynamic_cast**, o ponteiro **pbb** aponta para **Base**, o que é diferente do tipo que queremos converter, resultando em falha (o ponteiro **pd** recebe 0).

O **dynamic_cast** permite *downcast*, ou seja, a conversão de um ponteiro base para um ponteiro derivado.

##static_cast

O **static_cast** permite não somente conversões *upcast* (de ponteiros-para-derivada para ponteiro-para-base) como conversões *downcast* (o contrário). Por exemplo (retirado do site cplusplus):
```cpp
class Base {};
class Derived: public Base {};
Base * a = new Base;
Derived * b = static_cast<Derived*>(a);
```

Embora a conversão acima seja possível, o ponteiro *b* pode gerar erros de execução se tentar acessar membros exclusivos de *Devided* (pois *b* aponta para um objeto incompleto da classe *Derived*).

Embora o efeito descrito no parágrafo anterior não seja desejável, *static_cast* pode ter inúmeras aplicações, como converter valores da classe *enum* em inteiros ou números de pontos flutuantes, ou ainda converter qualquer tipo para *void*.

##reinterpret_cast

Isso converte qualquer tipo de ponteiro para qualquer outro tipo de ponteiro, mesmo entre classes não relacionadas. Vejamos um exemplo (retirado do site cplusplus):

```cpp
class A { /* ... */ };
class B { /* ... */ };
A * a = new A;
B * b = reinterpret_cast<B*>(a);
```

Para mais detalhes, pesquise no site cplusplus.

##const_cast

O **const_cast** permite manipular a característica *constante* de um objeto, permitindo que o mesmo fique constante ou não, dependendo da necessidade. Por exemplo (retirado do site cplusplus):

```cpp
// const_cast
#include <iostream>
using namespace std;

void print (char * str)
{
  cout << str << '\n';
}

int main () {
  const char * c = "sample text";
  print ( const_cast<char *> (c) );
  return 0;
}
```

##typeid

O **typeid** checa o tipo de uma expressão:

```cpp
typeid(10);
```

Você deve usar o header `<typeinfo>` para usar **typeid()**. Existe um método **name()** que retorna a string do tipo verificado. Porém a coisa não é tão óbvia quando tratamos de classes base e derivadas (exemplo tirado do site cplusplus):

```cpp
// typeid, polymorphic class
#include <iostream>
#include <typeinfo>
#include <exception>
using namespace std;

class Base { virtual void f(){} };
class Derived : public Base {};

int main () {
  try {
    Base* a = new Base;
    Base* b = new Derived;
    cout << "a is: " << typeid(a).name() << '\n';
    cout << "b is: " << typeid(b).name() << '\n';
    cout << "*a is: " << typeid(*a).name() << '\n';
    cout << "*b is: " << typeid(*b).name() << '\n';
  } catch (exception& e) { cout << "Exception: " << e.what() << '\n'; }
  return 0;
}
```

No exemplo acima, *a* e *b* são ponteiros do tipo *Base*, mas *\*a* é do tipo *Base* e *\*b* é do tipo *Derived*.

-----------------------------------------------------

#**Exceptions**

http://www.cplusplus.com/doc/tutorial/exceptions/

*Exceptions* é uma maneira de reagir a casos particulares, como erros de execução, transferindo o controle a funções especiais denominadas *handlers*.

O código normal de execução aparece em um bloco **try** e a excessão é escrita em um bloco **catch**, que pode (ou não) receber um argumento.

```cpp
// exceptions
#include <iostream>
using namespace std;

int main () {
  try
  {
    throw 20;
  }
  catch (int e)
  {
    cout << "An exception occurred. Exception Nr. " << e << '\n';
  }
  return 0;
}
```

A palavra **throw** acima pega um valor e passa para a função que controla a excessão. Você pode ter vários **catch**, cada um com um argumento de tipo distinto, pois o tipo enviando para o *handler* deve conicindir com o tipo esperado (no caso acima se espera um inteiro).

```cpp
try {
  // code here
}
catch (int param) { cout << "int exception"; }
catch (char param) { cout << "char exception"; }
catch (...) { cout << "default exception"; }
```

No exemplo acima, o último *handler* será disparado caso o valor recebido seja de um tipo diferente de *int* ou *char*.

##Standard exceptions

Usando o header `<exception>`, você pode usar as *exceptions* padrão de c++. São elas:

- **bad_alloc**: quando uma alocação falha.
- **bad_cast**: quando um **dynamic_cast** falha.
- entre outros...

Para usar, basta fazer como no exemplo abaixo:

```cpp
// bad_alloc standard exception
#include <iostream>
#include <exception>
using namespace std;

int main () {
  try
  {
    int* myarray= new int[1000];
  }
  catch (exception& e)
  {
    cout << "Standard exception: " << e.what() << endl;
  }
  return 0;
}
```

-------------------------------------------------

#**Preprocessor directives**

http://www.cplusplus.com/doc/tutorial/preprocessor/

As diretivas de pré-processamento são linhas precedidas com o símbolo de *hash* (*\#*). Estas linhas são diretivas para o pré-processamento. O preprocessador examina todo o código antes da compilação e resolve todas essas diretivas.

Cada diretiva ocupa somente uma linha de código, sem ponto e vírgula no final. Você pode usar um *backslash* (\\) para extender uma diretiva para mais de uma linha.

##Macros definitions (#define, #undef)

As macros são usadas para substituir porções do código por valores. Muito usados para substituir números por palavras que fazem mais sentido, deixando o cargo de trocar essas palavra por números para o pré-processador.

A sintaxe é:

```cpp
#define TABLE_SIZE 100
```

Logo, onde usar **TABLE_SIZE** no código, será substituído por 100 pelo pré-processamento. Isso fornece uma manuntenção de código mais direta (se eu desejar alterar o tamanho da tabela, basta mudar 100 por outro valor) além de deixar claro o que 100 quer dizer (neste caso, tamanho da tabela).

Você também pode usar funções macros que aceitam parâmetros:

```cpp
// function macro
#include <iostream>
using namespace std;

#define getmax(a,b) ((a)>(b)?(a):(b))

int main()
{
  int x=5, y;
  y= getmax(x,2);
  cout << y << endl;
  cout << getmax(7,x) << endl;
  return 0;
}
```

*(Porém, considere isso mais como teoria que como aplicação. criar funções assim pode dificultar a manuntenção do código.)*

Você pode definir blocos com a palavra **define** em conjunto com **undef**:

```cpp
#define TABLE_SIZE 100
int table1[TABLE_SIZE];
#undef TABLE_SIZE
#define TABLE_SIZE 200
int table2[TABLE_SIZE];
```

O **define** tem dois operadores especiais: # e ##. Vejamos o primeiro exemplo:

```cpp
#define str(x) #x
cout << str(test);
```

Que é o mesmo que:
```cpp
cout << "test";
```

O segundo exemplo:

```cpp
#define glue(a,b) a ## b
glue(c,out) << "test";
```

Que é o mesmo que:

```cpp
cout << "test";
```

##Conditional inclusions (#ifdef, #ifndef, #if, #endif, #else and #elif)

Essas diretivas incluem ou descartam parte do código de um programa se certas condições forem satisfeitas.

A diretiva **ifdef** permite que seu bloco de código seja executado somente se a macro especificada foi previamente definida. Isto é:

```cpp
#ifdef TABLE_SIZE
int table[TABLE_SIZE];
#endif
```

A diretiva **ifndef** é o contrário. O seu bloco só será executado se a macro não foi definida.

```cpp
#ifndef TABLE_SIZE
#define TABLE_SIZE 100
#endif
int table[TABLE_SIZE];
```

Você ainda pode usar as diretivas *if*, *else* e *elif* para especificar condições de valores de macros:

```cpp
#if TABLE_SIZE>200
#undef TABLE_SIZE
#define TABLE_SIZE 200
 
#elif TABLE_SIZE<50
#undef TABLE_SIZE
#define TABLE_SIZE 50
 
#else
#undef TABLE_SIZE
#define TABLE_SIZE 100
#endif
 
int table[TABLE_SIZE];
```

Em geral usamos essas diretivas quando criamos módulos em arquivos separados, para evitar que sobreposição ou acúmulo de informação já previamente definida.

##Line control (#line)

Permite que você controle a linha e o nome do arquivo em que ocorre um erro. Por exemplo:

```cpp
#line 20 "assigning variable"
int a?;
```

##Error directive (#error)

Essa diretiva aborta a compilação se for executada, gerando um erro de compilação.

```cpp
#ifndef __cplusplus
#error A C++ compiler is required!
#endif
```

##Source file inclusion (#include)

Essa diretiva, usada constantemente por todos que programam em c ou c++, substitui essa parte do código por um cabeçalho ou arquivo especificado.

##Pragma directive (#pragma)

Você pode especificar diversas opções para o compilador usando essa diretiva. Cada compilador usa **pragma** de uma maneira diferente.

##Predefined macro names

Todas as macros predefinidas começam e terminam com *underlines* duplos, como **\_\_DATE\_\_** (que é substituída por uma string literal na forma "Mmmm dd yyyy" contendo a data em que o processo de compilação começou).

para uma lista de exemplos, viste o site [cplusplus](http://www.cplusplus.com/doc/tutorial/preprocessor/).

---------------------------------------------------

#**Input/output with files**

http://www.cplusplus.com/doc/tutorial/files/


c++ fornece as seguintes classes para manipular arquivos:

- **ofstream**: classe para escrever em arquivos.
- **ifstream**: classe para ler arquivos.
- **fstream**: classe para ler e escrever em arquivos.

Elas são derivadas direta ou indiretamente das classes **istream** e **ostream**. **cin** e **cout** são objetos das classes **istream** e **ostream**, respectivamente. Da mesma forma, você pode fazer um arquivo ser objeto das classes de manipulação de arquivos, e usá-lo como se estivesse usando **cin** ou **cout**. O código abaixo cria um arquivo de texto e coloca uma string neste arquivo.

```cpp
// basic file operations
#include <iostream>
#include <fstream>
using namespace std;

int main () {
  ofstream myfile;
  myfile.open ("example.txt");
  myfile << "Writing this to a file.\n";
  myfile.close();
  return 0;
}
```

##Open a file

Um arquivo aberto é representado em um programa por um *stream* (isto é, um objeto de uma dessas classes), e qualquer operação de entrada ou saída executada neste *stream* será aplicada no arquivo físico associado.

*(uma informação importante: in, ou entrada, é usado aqui no sentido de leitura, enquanto que out, ou saída, é usado aqui no sentido de escrita. Pense em in como entrada do arquivo no programa e out como saída do programa para o arquivo)*

Para abrir um arquivo, usamos a função membro **open(*filename*, *mode*)**, onde *filename* é o nome do arquivo e o *mode* é um de vários tipos(veja [aqui](http://www.cplusplus.com/doc/tutorial/files/) para mais detalhes).

- **ios::in**: abre para operações de leitura.
- **ios::out**: abre para operações de escrita.
- **ios::binary**: abre em modo binário.
- **ios::ate**: configura a posição inicial no final do arquivo. Se não usado, a posição inicial é no início do arquivo.
- **ios::app**: todas as operações de escrita são executas no final do arquivo, aumentando o conteúdo atual do arquivo.
- **ios::trunc**: se o arquivo é aberto para operações de escrita e ele já existir, o seu conteúdo anterior é deletado e substituído pelo anterior.

Você pode combinar vários modos com o operador **|**. Cada classe possui um modo padrão. Mesmo que você especifique o modo de abertura para as classes **ofstream** e **ifstream**, eles usarão o modo **ios::out** e **ios::in**, respectivamente. Já a classe **fstream** possui os dois modos como padrão, mas serão sobrescritos caso se defina algum modo em **open**.

Arquivos abertos em modo binário executam operações de entrada e saída sem quaisquer tipos de formatação. Arquivos não binários são conhecidos com arquivos de texto, e algumas *traduções* poderão ocorrer para formatação de alguns caracteres especiais (como *newlines*).

Você pode usar o método **open** automaticamente ao criar o objeto:

```cpp
ofstream myfile ("example.bin", ios::out | ios::app | ios::binary);
if (myfile.is_open()) { /* ok, proceed with output */ }
```

A segunda linha verifica se o arquivo foi aberto com sucesso.

##Closing a file

Após executar todas as operações pretendidas, deve-se fechar o arquivo. O objeto *stream* pode abrir outro arquivo após fechar o anterior.

```cpp
myfile.close();
```

No caso em que o objeto é destruido antes de fechar o arquivo associado, o destrutor chama o método **close()** automaticamente.

##Text files

*Streams* de arquivos de texto são definidos quando não é usado o modo **ios::binary** no método **open()**.

Operações de escrita em arquivos de texto são feitos da mesma forma de **cout**:

```cpp
// writing on a text file
#include <iostream>
#include <fstream>
using namespace std;

int main () {
  ofstream myfile ("example.txt");
  if (myfile.is_open())
  {
    myfile << "This is a line.\n";
    myfile << "This is another line.\n";
    myfile.close();
  }
  else cout << "Unable to open file";
  return 0;
}
```

A leitura de um arquivo de texto é feita da mesma forma que em **cin**:

```cpp
// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main () {
  string line;
  ifstream myfile ("example.txt");
  if (myfile.is_open())
  {
    while ( getline (myfile,line) )
    {
      cout << line << '\n';
    }
    myfile.close();
  }

  else cout << "Unable to open file"; 

  return 0;
}
```

##Checking state flags

Existem algumas funções membros que verificam estados específicos de um *stream* (todos retornam valores booleanos):

- **bad()**: retorna *true* se a operação de leitura ou escrita falha.
- **fail()**: o mesmo que **bad()**, mas também no caso de erro de formatação, quando, por exemplo, tentamos ler um número mas um caractere alfabético é extraído.
- **eof()**: retorna *true* se um arquivo aberto para leitura chegar ao final.
- **good()**: isso retorna *false* onde qualquer uma das funções anteriores retornaria *true*.

##get and put stream positioning

Todos os objetos *stream* possuem pelo menos uma posição interna:

- *ifstream* possui uma *posição de aquisição* interna com a localização do elemento a ser lido na próxima operação de entrada.
- *ofstream* possui uma *posição de inserção* interna com a localização do próximo elemento a ser escrito.
- *fstream* mantém as duas posições.

Essas posições podem ser conhecidas e modificadas com as seguintes funções membros:

- **tellg()** e **tellp()**: essas duas funções membros sem parâmetros retornam um valor do tipo membro *streampos*, onde o tipo representa a posição atual de aquisição ou inserção.
- **seekg()** e **seekp()**: essas funções mudam a localização da posição de aquisição ou inserção. A primeira forma é:

```cpp
seekg(position);
seegp(position);
```

Onde *position* é um valor absoluto, contando a partir do início do arquivo. Ou pode usar a seguinte forma:

```cpp
seekg(offset, direction);
seekp(offset, direction);
```

Usando essa forma, a posição é configurada para um valor *offset* em relação a um ponto específico no parâmetro *direction*. Os valores desse último parâmetro podem ser:

- **ios::beg**: *offset* contado a partir do começo da *stream*.
- **ios::cur**: *offset* contado a partir da posição atual.
- **ios::end**: *offset* contado a partir do final da *stream*.

Exemplo:

```cpp
// obtaining file size
#include <iostream>
#include <fstream>
using namespace std;

int main () {
  streampos begin,end;
  ifstream myfile ("example.bin", ios::binary);
  begin = myfile.tellg();
  myfile.seekg (0, ios::end);
  end = myfile.tellg();
  myfile.close();
  cout << "size is: " << (end-begin) << " bytes.\n";
  return 0;
}
```

##Binary files

Para arquivos binários, ler e escrever dados com os operadores de extração ou inserção (**<<** e **>>**) e funções como **getline()** não é algo eficiente, uma vez que não precisamos gravar ou ler dados formatados.

Arquivos *streams* possuem duas funções membros feitas especialmente para ler e escrever dados binários sequeciais: **write** e **read**. Os seus protótipos são:

```cpp
write(memory_block, size);
read(memory_block, size);
```

Onde *memory_block* é do tipo *char \** (ponteiro para *char*). Exemplo:

```cpp
// reading an entire binary file
#include <iostream>
#include <fstream>
using namespace std;

int main () {
  streampos size;
  char * memblock;

  ifstream file ("example.bin", ios::in|ios::binary|ios::ate);
  if (file.is_open())
  {
    size = file.tellg();
    memblock = new char [size];
    file.seekg (0, ios::beg);
    file.read (memblock, size);
    file.close();

    cout << "the entire file content is in memory";

    delete[] memblock;
  }
  else cout << "Unable to open file";
  return 0;
}
```

