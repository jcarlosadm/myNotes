Anotações do livro Use a Cabeça Java - Tradução da 2ª ed norte americana

[TOC]

------------------------------------------------------------------
#**1 - Dê um mergulho rápido**

Aplicativo hello world (o nome do arquivo deve ser *HelloWorld.java*):
```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.print("Hello World!");
    }
}
```
Para a saída, como usamos **print**, o cursor será mantido na mesma linha. Se quiséssemos que pulasse de linha, teríamos de usar **println**. De qualquer forma, **print** e **println** são métodos de **System.out**.

------------------------------------------------------------------
#**2 - Classes e objetos**

As coisas que o objeto conhece sobre si mesmo são *variáveis de instância*, e as coisas que um objeto pode fazer se chamam *métodos*.

Uma classe é um projeto de objeto. Ela nos informa o que o objeto a daquela classe faz e conhece.

------------------------------------------------------------------
#**3 - Variáveis primitivas e de referência**

Java exige que você defina o tipo de uma variável, objeto ou métodos na declaração. Existem dois tipos de variáveis: *primitivas* e de *referência de objeto*. As primitivas são os tipos básicos: *int*, *boolean*, *char*, *float*, *double*...

Não existe variável de objeto, e sim de *referência de objeto*. Logo, para a declaração de uma variável de referência de objeto, escrevemos a classe do objeto + variável + atribuição + **new** + nome da classe + parênteses com ou sem parâmetros. O que vem depois do sinal de atribuição é a referência ao objeto, que será guardada na variável de referência de objeto antes do sinal de atribuição:
```java
Dog d = new Dog();
```
Para se referir a uma propriedade ou método de uma variável de referência de objeto, usamos o ponto:
```java
d.bark();
```
Se a referência a um objeto for perdida, o mesmo será um forte candidato a coleta de lixo automática do java (ou *GB*, *Garbage Collection*).
```java
d = null;
```
Para declarar uma matriz (ou array) usamos a seguinte notação:
```java
int[] num = new int[7];
```
Essa notação é usada pois uma matriz é um objeto. Todo elemento de uma matriz é uma variável. Assim, temos:
```java
num[0] = 5;
```
Que atribui o valor 5 à primeira posição da matriz, uma variável. Como cada posição de uma matriz é uma variável, essa variável pode ser do tipo primário ou de referência de objeto. Assim, temos:
```java
Dog[] pets = new Dog[7];
pets[0] = new Dog;
```

----------------------------------------------------------------
#**4 - Os métodos usam variáveis de instância**

A classe é um projeto de objeto. Isso quer dizer que todo objeto de uma mesma classe compartilham os mesmos métodos. Então, o que faz de um objeto diferente de outro, quando falamos da mesma classe? As variáveis de instância. Sem as variáveis de instância, esses objetos se comportariam da mesma maneira.

Você pode passar argumentos para os métodos de um objeto. Quando definimos o método da classe, chamamos os valores que podem ser passados a esse método de parâmetros. Quando usamos o método, chamamos os valores passados a esse método de argumentos. Java não possui argumentos *default*, mas você pode usar sobrecarga de métodos, ou seja, definir métodos com o mesmo nome e tipo de retorno, mas com parâmetros diferentes. Você define o código em um método com todos os argumentos, e os outros métodos apenas configuram os argumentos faltantes e chamam o método "principal"; isso evita ter que mudar todos os métodos toda vez que houver uma alteração do método "principal".

Um método do tipo *void* não tem retorno de valores. Mas podemos criar métodos que retornem alguma coisa. Neste caso, usamos outro tipo para o método que não *void*. Use a palavra **return** para retornar algo dentro do método.

Encapsulamento é quando você usa métodos para acessar e alterar variáveis de instância, mantendo as mesmas privadas. Para tornar as variáveis de instância privadas, use a palavra **private** (você também pode tornar métodos privados). Encapsular variáveis é uma boa prática pois lhe dá mais controle do que pode e como é alterado.

Variáveis de instância não inicializadas começam com um valor padrão, que depende de seu tipo. Uma variável de referência começa com **null** (assim como string), e números começam com 0. Variáveis booleanas começam com *false*.

As variáveis em uma classe que estiverem fora de qualquer método são chamadas de variáveis de instância. Já as que estiverem dentro de algum método, são denominadas variáveis locais. As variáveis locais não inicializadas não recebem um valor padrão, ou seja, se você tentar usar uma variável local sem inicilizá-la primeiro, o código não será compilado. Os parâmetros dos métodos são como variáveis locais.

----------------------------------------------------------------
#**5 - Escrevendo um programa**

Para criar um programa, podemos seguir diversos caminhos. Um deles é seguir três passos simples: código preparatório (ou pseudo-código), código de teste e código real. O código de teste é apenas uma preparação para o código real e não precisa ser executado.

Em java, você pode usar o loop **for** normalmente, mas também pode usar o loop **for** melhorado:
```java
for(int num : intArray){
	//
}
```
No código acima, *num* é uma variável que irá guardar um elemento de *intArray* a cada loop.

--------------------------------------------------------------
#**6 - Conheça o API Java**

O array (ou matriz) comum de Java é fixo: você não pode diminuí-lo ou aumentá-lo. Porém, existe uma classe chamada *ArrayList* que permite criar um array dinâmico.
```java
// Criando a lista
ArrayList<Item> myList = new ArrayList<Item>();

// Para inserir:
Item s = new Item();
myList.add(s);

// Para saber quantos itens estão nele:
System.out.println(myList.size());

// Saber se ele contém alguma coisa:
System.out.println(myList.contains(s));

// Saber em que índice está algo:
System.out.println(myList.indefOf(s));

// Saber se a lista está vazia:
System.out.println(myList.isEmpty());

// Remover algo informando o índice (ou poderia ser o objeto):
myList.remove(0);

// Retornar algo informando o índice:
myList.get(0);
```
Porém, *ArrayList* não armazena tipos primitivos diretamente, você deve encapsula em uma classe antes. Isso será visto mais adiante, em outro capítulo, mas basta saber que a partir do Java 5 esse encapsulamento é automático.

##Operadores booleanos

O operador `&&` irá parar a checagem se o lado esquerdo for falso. O operador `||` irá parar a checagem se o lado esquerdo for verdadeiro. Os operadores `&` e `|` funcionam de forma similar, exceto que eles forçam a checagem dos dois lados.

#**7 - Herança e Poliformismo**

Uma classe *"pai"* pode ser chamada de *superclasse*, e as classes *"filhos"* são *subclassses*. As subclasses herdam os métodos da superclasse. Esse relacionamento é chamado de herança.

Uma subclasse pode sobrescrever qualquer método da superclasse que estiver relacionada, definindo, assim, comportamentos singulares.

Em java, se diz que *a subclasse estende a superclasse*. Não somente os métodos são herdados, mas também as variáveis de instância (essas não podem ser sobrepostas). A superclasse descreve um estado mais abstrato, enquanto que a subclasse descreve algo mais específico.

Eis um exemplo de herança em java:

```java
public class Doctor{
	boolean worksAtHospital;
	
	void treatPatient(){
		// faz um checkup
	}
}

public class FamilyDoctor extends Doctor{
	boolean makeHouseCalls;
	
	void giveAdvice(){
		// dá conselhos
	}
}

public class Surgeon extends Doctor{
	void treatPatient(){
		// faz cirurgia
	}
	
	void makeIncision(){
		// faz incisão
	}
}
```

Há um teste conceitual simples que pode ser aplicado para considerações de herança:

- Quando uma classe **x** herda de outra classe **y**, dizemos que *x é do tipo y*. Logo, *x **É UM** y*.
- Quando uma classe **x** tem uma classe **y**, dizemos que *x contém y*. Logo, *x **TEM UM** y*.

No primeiro caso, já sabemos o que é uma herança. E no segundo caso? Esse segundo caso é quando temos um objeto numa classe, como uma banheira num banheiro; e esse objeto é uma variável de instância.

Você não precisa sobrescrever totalmente o método da superclasse. Se quiser, pode apenas adicionar algo mais ao código já existente, por exemplo:

```java
public void roam(){
	super.roam(); // comportamento da superclasse
	// comportamento adicional
}
```

Em java temos quatro níveis de acesso: *private*, *default*, *protected* e *public*. Os membros privados não são herdados, mas os membros públicos são.

> Uma observação: o livro não explica de imediato os níveis *default* e *protected*. O nível *default* (que é usado quando você não define um nível) cria uma restrição de pacote, ou seja, a classe, variável ou método só é visível dentro do pacote, mesmo que seja importado. O nível *protected* funciona como *default*, mas permite acesso fora do pacote por meio de herança.
>
>Quanto a uma classe não herdar membros privados, na verdade ela herda, mas não possui acesso direto. Você pode acessar o membro privado herdado por meio de outros métodos públicos herdados.
>
> Para criar um pacote, use a palavra `package`, e defina um nome para o pacote. Todos os arquivos de um pacote devem ser colocados numa pasta que contém o mesmo nome do pacote. Para importar um pacote, use a palavra chave `import` e o nome do pacote mais ponto mais asteriscos, como `import pckt.*`. O asteriscos fará a importação de todos os arquivos de classe existentes no pacote (você pode importar arquivos específicos substituindo o asteriscos por um nome de classe).
> 
> A compilação de cada pacote deve ser feita separadamente.

Poliformismo é declarar um subtipo onde um supertipo relacionado é esperado. Ou seja, você cria uma referência para um supertipo e faz essa referência apontar para um subtipo criado. Isso permite uma flexibilidade maior na criação de objetos de classes que possuem heranças comuns.

Um exemplo de poliformismo:

```java
Animal mydog = new Dog();
```

Você pode ainda usar o supertipo como parâmetro de um método, e passar um subtipo como argumento.

Uma classe com o marcador **final** não pode gerar subclasses nem ter seus métodos sobrepostos. Um método com esse marcador significa que não pode ser sobreposto.

Para que um método seja sobreposto, você deverá obedecer o *contrato* do método original. Isto é, o tipo de retorno e os parâmetros. Se qualquer um desses for diferente, você só está criando uma nova versão do método, e não sobrepondo o mesmo. Outra coisa: o nível de acesso também deve ser o mesmo ou mais acessível.

Quando você cria uma nova versão de um método, na verdade você está sobrecarregando o mesmo. Sobrecarregar um método é usar o mesmo nome, mas com argumentos diferentes. Se você alterar o retorno, terá que alterar os argumentos também, ou o compilador presumirá que você está tentando sobrescrever o método, e lançará um erro. Um método sobrecarregado também pode ter o seu nível de acesso alterado sem qualquer restrição.

#**8 - Poliformismo Real**

Uma classe abstrata não pode ser *instanciada*, ou seja, usada para criar objetos. Pense na classe *Animal* e nas subclasses *Wolf* e *Dog*. Faz sentido criar objetos do tipo *Wolf* e *Dog*, mas do tipo *Animal*, que serve apenas como superclasse de outras classes e para usar poliformismo. Assim, *Animal* é uma classe abstrata.

Você marca uma classe como abstrata com a palavra **abstract**:

```java
abstract class Animal {
	// variáveis e métodos
}
```

Desse modo, o compilador não permitirá que você instancie um objeto da classe *Animal*. Mas você pode continuar a usar poliformismo normalmente.

>Uma observação: como menciona o livro, uma classe abstrata pode possuir membros static. Mais detalhes sobre isso no capítulo 10.

Uma classe não abstrata é denominada concreta.

Você pode ter métodos abstratos. Um método abstrato deve ser sobreposto. Isso é útil quando não conhecemos o que um método faz até que ele seja definido em uma classe mais específica. Um método abstrato termina com um ponto-e-vírgula:

```java
public abstract void eat();
```

Um método abstrato só pode existir em uma classe abstrata. Uma classe abstrata pode ter tanto métodos abstratos como não abstratos.

Métodos abstratos devem ser implementados na primeira classe concreta da árvore de herança. Eles só existem por causa do poliformismo. Lembre-se que classes abstratas podem conter tanto métodos abstratos como concretos, então é possível implementar parte dos métodos abstratos na próxima classe abstrata na árvore de herança, diminuindo a quantidade de implementações que a próxima classe concreta precisa fazer.

Em java, a superclasse de todas as classes é a classe *Object*. A classe *Object* possui métodos que permitem diversas operações genéricas com objetos, como:

- descobrir se um objeto é igual ao outro (método `equals(Object o)`).
- Descobrir a classe real de um objeto (método `getClass()`).

Existe um inconveniente no poliformismo: a referência da superclasse que contém uma instância de uma subclasse só executará métodos da subclasse que estejam presentes na superclasse, mesmo que só de forma abstrata. Se um método só existe na subclasse, ele não poderá ser chamado.

O parágrafo anterior justifica o motivo de não poder usar uma referência do tipo *Object* para apontar para instâncias de alguma outra classe. A classe *Object* não conheceria os métodos dessa outra classe!

Ok, tem como contornar isso. Na verdade, você pode converter uma referência de superclasse para subclasse, permitindo que use métodos que só existem na subclasse. Caso você não tenha certeza que a referência aponta para uma instância da subclasse pretendida, use o método `instanceof` para verificar, ou um erro ocorrerá em tempo de execução.

```java
SuperClasse subRef = new SubClasse();
SuperClasse sp = subRef;
SubClasse sb = (SubClasse) sp;
```

##Interface

Bom, em java você não pode ter herança múltipla, pois pode acabar tendo o problema do diamante mortal (pesquise para saber o que é; em inglês é *deadly diamond of dead*).

>Uma observação: em c++, esse problema pode ser contornado usando a palavra chave **virtual** no momento da herança. Isso torna todos os métodos herdados como virtuais. O java usa uma solução semelhante.

Mesmo que java não permita herança múltipla, você pode usar *interfaces* para implementar métodos extras para as suas classes. Em primeiro lugar: todos os métodos de uma interface são abstratos e públicos. Ou seja, você deve implementar na classe que recebe essa interface. Todos os métodos recebem as palavras **public** e **abstract** implicitamente, de modo que não é necessário digitá-los.

A interface usa a palavra **interface** ao invés de **class**:

```java
public interface Pet{
	public abstract void beFriendly();
	void play(); // também será public abstract
}
```

Segundo: a classe que recebe a interface usa a palavra **implements**:

```java
public class Dog extends Canine implements Pet {
	// implementa os métodos da interface
	public void beFriendly(){}
	public void play(){}

	// métodos exclusivos de dog
	public void roam();
	public void eat();
}
```

Terceiro: uma classe pode receber mais de uma interface (separe-as por meio da vírgula). Além disso, as interfaces não estão presas a uma árvore de herança.

```java
public class Dog extends Animal implements Pet, Saveable, Paintable{}
```

>Aqui cabe uma discussão: se todos os métodos de uma interface são abstratos, então qual a utilidade em termos de reutilização de código? Bom, a interface foi projetada para atender necessidades da forma mais genérica possível. Pense na interface *Pet* acima. Se você implementar essa interface em *Cat*, a implementação seria o mesmo que *Dog*? Provavelmente não.
>
>Então como usar a reutilização de código em conjunto com as interfaces? Na verdade, *Dog* ainda é algo genérico. Todos os cachorros são domésticos (alguns mais que outros, mas vamos supor que todos são igualmente domésticos). Então faz sentido implementar *Pet* em *Dog*. Depois basta uma raça específica de cachorro herdar *Dog*, e também estaremos herdando a implementação da interface.

#**9 - Construtores e Coleta de Lixo**

Um construtor é um código que é executado quando você usa a palavra **new** para instanciar um objeto. Se você não definir um construtor, o java definirá um construtor padrão.

```java
public Duck (){
	// código do construtor
}
```

Um construtor não é um método, mas uma maneira de executar algo antes do objeto ser criado. Construtores também podem ter parâmetros.

Na verdade, você pode ter mais de um construtor, de modo que é uma boa ideia ter um construtor padrão, sem parâmetros.

Quando um construtor de uma classe é acionado, os construtores das superclasses até o topo da árvore de herança também são acionados, até mesmo de superclasses abstratas.

>Observação: o livro fala que membros privados não são herdados. Mas agora explica que um objeto criado pode ter diversas camadas, uma para a classe que o originou e mais uma para cada superclasse da árvore de herança. Logo, essas camadas podem ter variáveis privadas dessas superclasses, que podem ser acessíveis por meio de métodos públicos. Como essas camadas são geradas? O parágrafo anterior explica: pela chamada dos construtores das superclasses.

Para chamar o construtor da superclasse, basta usar a palavra **super()**. Isso deve ser feito *primeiro*, caso contrário não será compilado.

```java
public class Duck extends Animal {
	int size;

	public Duck(int newSize){
		super(); // ok, primeiro super()
		size = newSize;
	}
}
```

Se houver argumentos, **super()** pode receber os mesmos sem problemas.

Digamos que você tenha um construtor principal, e outros construtores sobrecarregados opcionais que precisam chamar esse construtor principal e executar algo mais. Para isso você pode usar **this()** (também aceita argumentos), que se refere ao próprio objeto, e chamará um construtor de acordo com a lista de argumentos que for passada.

A palavra **this()** deve ser a primeira instrução a ser executada, então você não pode usar **super()** no mesmo construtor.

Quando um objeto é criado, é alocado um espaço na memória para ele. Quando não precisar mais deste objeto, você precisa garantir que ele esteja qualificável para a coleta de lixo. O que isso significa? Que quando você precisar de memória, a coleta de lixo verificará e eliminará qualquer objeto qualificável. Como tornar um objeto qualificável para a coleta de lixo? Elimine a referência para esse objeto. Isso pode acontecer de diversas maneiras:

- A referência sai do escopo.

```java
public void go(){
	Life z = new Life();
} // fim do escopo! a referência se perde!
```

- A referência é atribuída a outro objeto.

```java
Life z = new Life();
z = new Life(); // não aponta mais para o objeto anterior!
```

- A referência é declarada explicitamente como nula.

```java
Life z = new Life();
z = null; // a referência é perdida!
```

#**10 - Números e elementos estáticos**

Java permite declarar métodos estáticos em uma classe para que você possa usar um método sem a necessidade de instanciar um objeto dessa classe. Fazemos isso usando a palavra **static** no método. Um método estático não depende de variáveis de instância, apenas da classe.

A classe *Math*, por exemplo, possui diversos métodos estáticos. Você não pode instanciar a classe *Math*, mas seus métodos não dependem disso, pois métodos estáticos não dependem de variáveis de instância.

Você pode impedir que alguém possa instanciar uma classe tornando o seu construtor privado.

Para invocar um método estático, usa-se o nome da classe mais ponto mais o nome do método:

```java
Math.min(20,30);
```

Um método estático não pode chamar um método não estático ou variável não estática.

Uma variável estática é uma variável que é compartilhada com todas as instâncias da classe. Ou seja, todas as instâncias compartilharão o mesmo valor dessa variável.

```java
public class Duck {
	private int size;
	private static int duckCount = 0;

	public Duck(){
		duckCount++;
	}
}
```

Uma variável estática não inicializada recebe o valor padrão de seu tipo, da mesma forma que as variáveis de instância.

Uma variável estática marcada como **final** é conhecida como *constante*. Isso quer dizer que ela nunca pode ser alterada. Há uma convenção de nomeação que ajuda a identificar uma variável estática: use apenas letras maiúsculas.

```java
public static final double PI = 3.14159265;
```

Para inicializar uma variável estática (final ou não), você pode usar um inicializador estático, que é executado antes de qualquer outro código dentro da classe. É uma ótima maneira de inicializar constantes.

```java
public class Foo{
	public final static int x;
	static{
		x = 42;
	}
}
```

A palavra **final** pode ser usada quando uma variável (mesmo não estática) não puder ser alterada.

##Métodos de Math

###Math.random()

Retorna um double entre 0,0 (mas não inclusive) e 1,0.

```java
double r1 = Math.random();
int r2 = (int) (Math.random()*5);
```

###Math.abs()

Retorna o valor absoluto (sem sinal) do argumento. Funciona com int ou double.

###Math.round()

Retorna um inteiro ou longo (dependendo se você passou um float ou double como argumento) arredondado para o inteiro mais próximo.

###Math.min()

Retorna o menor entre dois valores.

###Math.max()

Retorna o maior entre dois valores.

##Empacotando tipos primitivos

Antes do java 5.0, era necessário empacotar um tipo primitivo (como **int**) para usar em uma ArrayList, por exemplo.

Empacotar um tipo primitivo é simples. Há diversos empacotadores, um para cada tipo primitivo:

- Boolean
- Character
- Byte
- Short
- Integer
- Long
- Float
- Double

Exemplo de uso:

```java
int i = 288;
Integer iWrap = new Integer(i);
```

Para desempacotar:

```java
int unWrapped = iWarp.intValue();
```

A partir do java 5.0, podemos usar o ArrayList da seguinte forma:

```java
ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

listOfNumbers.add(3);

int num = listOfNumbers.get(0);
```

Os empacotadores possui métodos estáticos de conversão. Para converter uma *string* para um inteiro ou *double*, use:

```java
String s = "2";
int a = Integer.parseInt(s);
double b = Double.parseDouble(s);
```

Uma conversão pode falhar, se a *string* fornecida não for um número. Isso será tratado no capítulo de excessões.

Para passar um *double* para *string* (passar inteiro para *string* é parecido):

```java
double d = 42.4;
String doublestring = ""+d;

String doublestring2 = Double.toString(d);
```

##Formatando números

A partir do java 5.0 você pode usar o método **String.format()** para formatar números inteiros ou com pontos flutuantes. Por exemplo, a seguinte instrução dará "100.000.000" como saída:

```java
String s = String.format("%,d",100000000);
System.out.println(s);
```

Essa formatação é bem parecida com o que usamos em **C**. Vejamos alguns códigos usados:

- %,d : o sistema numérico norte-americano usa vírgula como separador de milhar. Essa formatação insere uma vírgula ou ponto como separador de milhar, dependendo do sistema de representação usado. O valor *d* aqui é usado para representar um inteiro.
- %.2f : formata um valor de ponto flutuante para duas casas decimais.
- %,.2f : formata um valor de ponto flutuante para duas casas decimais, além de usar o separador de milhar do sistema.

Entre o percentual (**%**) e o indicador de tipo (**d** ou **f**), temos as instruções de formatação:

>%[número do argumento][flags][tamanho][.precisão]tipo

- número do argumento: informa qual argumento é usado, se houver mais de um.
- flags: as opções especiais de formatação, como inserção de pontos, colocar números negativos entre parênteses ou fazer com que os números sejam alinhados à esquerda.
- tamanho: define a quantidade mínima de caracteres que serão usados. Se a quantidade de caracteres for menor, zeros serão colocados para preencher a quantidade mínima.
- .precisão: configura a quantidade de casas decimais.
- tipo: o tipo é obrigatório. Pode ser **d** para inteiro ou **f** para número com ponto flutuante.

##Datas

Para formatar datas, usamos a classe *java.util.Date* e passamos como tipo uma *string* que começa com **t**. Exemplos:

```java
// A data e hora completas
// "Sun Nov 28 14:52:41 MST 2004"
String s = String.format("%tc", new Date());

// Apenas a hora
// "03:01:47 PM"
String s2 = String.format("%tr", new Date());

// Dia da semana, mês e o dia do mês
// "Sunday, November 28"
Date today = new Date();
String s3 = String.format("%tA, %tB %td",today,today,today);

// o anterior mas sem repetir today
String s3 = String.format("%tA, %<tB %<td",today);
```

Para operações mais específicas com datas, recomenda-se dar uma olhada na classe *java.util.Calendar*. A classe *Calendar* é abstrata, logo não é possível instanciá-la. Mas essa classe possui diversas classes concretas, que representam diversos calendários diferentes. Para instancializar um calendário corretamente, faça:

```java
Calendar cal = Calendar.getInstance();
```

Isso irá retornar uma instância de uma subclasse concreta de *Calendar* (no nosso caso, será *java.util.GregorianCalendar*).

O que podemos fazer com essa classe? Bom, basicamente você pode manipular uma data de diversas formas, como adicionar dias, verificar quantas horas até outra data, mudar a data etc. Vejamos um exemplo:

```java
Calendar c = Calendar.getInstance();

// 7 de janeiro de 2004, 15:40
// o mês começa em zero
c.set(2004,0,7,15,40);

// converte para milissegundos
long day1 = c.getTimeInMillis();

// adiciona uma hora
day1 += 1000*60*60;

// atualiza a data
c.setTimeInMillis(day1);

// imprime a nova hora
System.out.println("new hour " + c.get(c.HOUR_OF_DAY));

// adiciona 35 dias
c.add(c.DATE, 35);

// adiciona 35 dias sem mudar o mês
c.roll(c.DATE, 35);

// imprime data
System.out.println(c.getTime());

// configura dia
c.set(c.DATE, 1);
```

##Importações estáticas

Você pode escrever **abs()** ao invés de **Math.abs()**:

```java
import static java.lang.Math.abs;
// ou import static java.lang.Math.*;

class TestClass {
	int a = abs(-12);
}
```

Tenha cuidado com as importações estáticas. Quase sempre temos métodos com nomes iguais, ou parecidos, que são diferenciados pelo uso do nome da classe a que pertencem. Também não tem muito sentido em usar importação estática se um método estático é pouco usado.

#**11 - Manipulação de Exceções**

Existem métodos em java que podem gerar um resultado inesperado. Por exemplo, se você tentar converter uma *string* para número, essa tentativa pode falhar se a *string* não representar exatamente um número (com a *string* "três" ao invés de "3").

Existem métodos que exigem que você use um manipulador de exceções para tratar possíveis falhas. Um manipulador de exceções é um bloco **try/catch**.

```java
try{
	Sequencer sequencer = MidiSystem.getSequencer();
	System.out.println("ok");
}catch(MidiUnavailableException ex){
	System.out.println("Something wrong");
}
```

Como toda exceção é do tipo **Exception** (ou seja, herdam dela), você só precisa lembrar dessa classe (exceto quando quiser tratar o erro de forma mais acurada).

```java
try{
	// tenta algo
}catch(Exception ex){
	// faz outra coisa se der errado
}
```

Esse é um exemplo de método que pode lançar uma exceção:

```java
public void takeRisk() throws BadException {
	if(abandonAllHope){
		throw new BadException();
	}
}
```

No seu código, você escreve:

```java
try{
	anObject.takeRisk();
}catch(BadException ex){
	System.out.println("error");
	ex.printStackTrace();
}
```

O compilador verifica todas as exceções, exceto **RuntimeException**, que é checada somente em tempo de execução.

Além do bloco **try/catch**, você pode inserir um bloco **finally**, que é lançado sempre, sendo bem sucedido ou não.

Um método pode lançar mais de uma exceção (separe as classes por meio de vírgula após **throws**, ou lance a superclasse em comum). Para tratar as exceções em seu código, cada exceção terá um **catch** próprio.  É importante que os **catch**'s mais específicos venham primeiro e depois os mais gerais, senão os mais específicos nunca serão chamados.

Você pode se desviar de uma exceção da seguinte forma:

```java
public void foo() throws ReallyBadException {
	// chama o método sem um bloco try/catch
}
```

O que o código acima faz é deixar o tratamento da exceção para outro método. Esse outro método pode fazer o mesmo, de modo que o processo pode continuar até que **main** se desvie também, e nenhum tratamento será feito para o erro. Dependendo do erro, pode ser um opção, mas não é muito recomendável, pois o seu código pode precisar de algo que não existe por causa de um erro, por exemplo.

#**12 - Usando a gui**

Um *JFrame* é um objeto que reprsenta uma janela na tela. Pode ter uma barra de menu, e pode conter botões, caixas de seleção, campos de texto e assim por diante.

A classe Swing possui diversos componentes que você pode adicionar na janela, como *JButton*, *JRadioButton*, *JCheckBox*, *JLabel*, *JList*, *JScrollPane*, *JSlider*, *JTextArea*, *JTextField* e *JTable*.

Em primeiro lugar você deve criar um *frame*. Depois crie os componentes necessários da aplicação e coloque no *frame*.

```java
import javax.swing.*;

public class SimpleGui {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
}
```

##Eventos

Os componentes do *swing* precisam de eventos para responder a uma ação do usuário. Você declara não o objeto de evento, mas uma *interface de escuta* junto ao componente do *swing*, que irá gerar um objeto de evento caso algum evento ocorra. A sua interface de escuta saberá que o evento foi criado, então você poderá manipular o mesmo.

Em geral cada objeto de evento possui diversos métodos de implementação. Por exemplo, `MouseEvent` possui métodos de implementação como `mousePressed()` e `mouseReleased()`.

Exemplo:

```java
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
	JButton button;
	
	public static void main(String[] args){
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		button = new JButton("Click me");
		
		button.addActionListener(this);
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		button.setText("I've been clicked!");
	}
}
```

##Layout de uma GUI

Uma moldura possui cinco regiões onde os elementos podem ser posicionados: *north*, *west*, *center*, *east*, *south*. Cada região pode ser subdividida, e cada subdivisão pode ser subdividida novamente.

Para adicionar um elemento a uma região, use o método **add()** com dois argumentos após **getContentPane()**:

```java
// adiciona button no centro
frame.getContentPane().add(BorderLayout.CENTER, button);
```

Você pode redesenhar a moldura. Use o método `repaint()` de `JFrame` para que todos os métodos `paintComponent()` sejam chamados novamente.

##Dois eventos

Quando você precisa acionar eventos em dois elementos distintos, você pode registrar o mesmo ouvinte nos dois elementos, e usar `event.getSource()` em `actionPerformed` para saber quem ativou o evento:

```java
public class MyGui implements ActionListener{
	// declara variáveis de instância

	public void go(){
		// constrói a gui
		colorbutton = new JButton();
		labelbutton = new JButton();
		colorbutton.addActionListener(this);
		labelbutton.addActionListener(this);
		// mais código
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == colorbutton){
			frame.repaint();
		}else{
			label.setText("new text");
		}
	}
}
```

Funciona, mas não é uma boa prática de **OO** e dificulta a manutenção.

A melhor maneira é ter duas classes **internas**, capazes de acessar os dados da classe em que estão contidas.

Uma classe interna pode acessar todas as variáveis de instância e métodos da classe externa, inclusive os privados. Essa classe interna pode usar essas variáveis e métodos como se tivessem sido declarados dentro dela.

Uma instância da classe interna é vinculada a uma instância da classe externa, e não *qualquer* instância dessa classe.

Agora podemos fazer o código com os dois botões:

```java
public class TwoButtons{
	Jframe frame;
	JLabel label;
	
	public static void main(String[] args){
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("change label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("change circle");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			label.setText("new text");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
		}
	}
}
```

Usar uma classe interna também pode ser útil quando a classe interna e externa estão em árvores de herança diferentes.

#**13 - Usando o Swing**

Todos os componentes de uma *GUI* (botões, caixas de texto, listas roláveis etc) estendem *javax.swing.JComponent*. Por isso que o termo *componente* é um bom nome.

Quase todos os componentes podem conter outros componentes. Porém, você provavelmente usará componentes de planos de fundo para conter outros componentes.

Um *gerenciador de layout* é um objeto Java associado a um componente específico (em geral um componente de pano de fundo). Cada componente de plano de fundo pode ter o seu próprio gerenciador de layout, com suas próprias regras. Se você conhecer essas regras, pode dominar o layout de seu programa.

##Tipos de gerenciadores de layout

###BorderLayout

Este é o gerenciador padrão para uma moldura. Ele divide o componente de plano de fundo em cinco regiões, e cada região só pode ter um elemento. Em geral não respeita as medidas dos componentes.

Um componente *JFrame* usar um gerenciador *BorderLayout*.

```java
JFrame frame = new JFrame();

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton button = new JButton("Click like you mean it");

frame.getContentPane().add(BorderLayout.NORTH, button);
frame.setSize(500,500);
frame.setVisible(true);
```

###FlowLayout

Os componentes são adicionados com os seus tamanhos predefinidos, e eles são dispostos da esquerda para a direita na ordem em que são adicionados, com mudança automática de linha. Este é o gerenciador padrão para um painel.

O componente *JPanel* usa um gerenciador *FlowLayout*.

```java
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();
panel.setBackground(Color.darkGray);
        
frame.getContentPane().add(BorderLayout.EAST, panel);
frame.setSize(200,200);
frame.setVisible(true);
```

###BoxLayout

Ele é como o *FlowLayout*, mas os componentes podem ser empilhados verticalmente (ou horizontalmente, mas a diferença do *FlowLayout* seria mínima).

```java
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();
panel.setBackground(Color.darkGray);

panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

JButton button = new JButton("shock me");
JButton button2 = new JButton("bliss");
JButton button3 = new JButton("bliss dfdfdfdfdf");

panel.add(button);
panel.add(button2);
panel.add(button3);
        
frame.getContentPane().add(BorderLayout.EAST, panel);
frame.setSize(250,200);
frame.setVisible(true);
```

##Alguns dos componentes do Swing

###JTextField

Este é um campo de texto, como aquele que usamos para inserir o nome. O construtor do *JTextField* pode receber um número (quantidade de colunas que desejamos para o campo) ou uma string (texto padrão), ou uma string e um número.

Você pode capturar o texto em um campo *JTextField* com o método `getText()`, ou inserir um texto com `setText()`. Para selecionar todo o texto do campo, use o método `selectAll()`, e para posicionar o cursor no campo, para começar a digitar, use `requestFocus()`.

###JTextArea

Um componente *JTextArea* captura grande quantidade de texto. O seu construtor recebe a quantidade de linhas e de colunas.

Para que esse componente possua uma barra de rolagem vertical, um componente do tipo *JScrollPane* deve ser criado, inserindo o componente *JTextArea* dentro dele.

```java
// cria o componente JTextArea
JTextArea text = new JTextArea(10,20);
// cria o componente JScrollPane
JScrollPane scroller = new ScrollPane(text);
// consfigura text para dar quebra de linha
text.setLineWrap(true);
// Configura rolagem vertical
scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
// Configura rolagem horizontal
scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
// adiciona scroller ao painel
panel.add(scroller);
```

Esse componente possui diversos métodos semelhantes a *JTextField*.

###JCheckBox

O construtor recebe uma *string* que representa o texto que aparece ao lado da caixa de seleção.

Você pode verificar se a caixa de seleção está selecionada com o método `isSelected()`. Também pode configurar um valor para a caixa de seleção com `setSelected()`, que pode receber *true* ou *false*.

###JList

O construtor de um componente *JList* recebe uma matriz de qualquer tipo de objeto.

```java
String[] myListStrings = {"hello","hi"};
JList myList = new JList(myListStrings);
```

Da mesma forma que *JTextArea*, você pode criar e configurar um objeto *JScrollPane* para receber o objeto *JList*. A diferença é que o objeto *JList* possui um método que configura a quantidade de linhas visíveis: `setVisibleRowCount()`, que recebe um valor inteiro.

Para restringir a seleção de somente uma linha, use `setSelectionMode(ListSelectionModel.SINGLE_SELECTION)`.

Para registrar a escuta de eventos da lista use: `addListSelectionListener()`, que recebe um objeto.

Para descobrir o que foi selecionado na lista, use:

```java
public void valueChanged(ListSelectionEvent ev){
	// para evitar capturar o evento duas vezes
	if(!ev.getValueIsAdjusting()){
		String selection = (String) list.getSelectedValue();
		System.out.println(selection);
	}
}
```

#**14 - Serialização e E/S de arquivo**

Para salvar seus dados você pode usar serialização ou salvar esses dados em um arquivo de texto simples. Use texto simples apenas se os dados precisarem ser lidos por outros programas. Caso contrário, use serialização para salvar seus objetos. Claro, essas não são as únicas opções disponíveis.

Etapas para serializar um arquivo:

1.Crie um objeto `FileOutputStream` (fluxo de conexão)

```java
FileOutputStream fileStream = new FileOutputStream("myGame.ser");
```

2.Crie um `ObjectOutputStream` (fluxo de cadeia)

```java
ObjectOutputStream os = new ObjectOutputStream(fileStream);
```

3.Grave o objeto

```java
os.writeObject(characterOne);
os.writeObject(characterTwo);
os.writeObject(characterThree);
```

4.Feche `ObjectOutputStream`

```java
os.close();
```

Na serialização, todas os objetos instancializados no objeto serializado também são eles próprios serializados, automaticamente.

Para que uma classe possa ser serializada, esta deverá implementar `Serializable`. Essa é uma interface *marcadora* ou de *tag*, o que significa que ela só informa que objetos dessa classe podem ser serializados. Se uma superclasse for serializável, todas as suas subclasses também podem ser serializadas (mesmo sem declaração explícita).

```java
// necessário para serialização
import java.io.*;

public class Box implements Serializable {
   
    private int width;
    private int height;

    public void setWidth(int w){
        width = w;
    }
    
    public void setHeight(int h){
        height = h;
    }
    
    public static void main(String[] args){
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);
        
        try{
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
```

Se o objeto a ser serializado tiver alguma instância de uma classe que não possa ser serializada, então o processo não poderá ser feito. Se faz necessário que a classe a que pertence o objeto e todas as classes dos objetos dentro dele possam ser serializados.

Se você desejar que uma variável de instância seja ignorada pelo processo de serialização, use a palavra `transient`.

```java
transient int number;
```

##Desserialização

Processo de desserialização:

1.Crie um FileInputStream (fluxo de conexão)

```java
// se o arquivo não existir, irá capturar uma exceção
FileInputStream fileStream = new FileInputStream("MyGame.ser");
```

2.Crie um ObjectInputStream (fluxo de cadeia)

```java
ObjectInputStream os = new ObjectInputStream(fileStream);
```

3.Leia os objetos

```java
Object one = os.readObject();
Object two = os.readObject();
Object three = os.readObject();
```

4.Converta os objetos

```java
GameChar elf = (GameChar) one;
GameChar troll = (GameChar) two;
GameChar mage = (GameChar) three;
```

5.Feche ObjectInputStream

```java
os.close();
```

Nesse processo, o JVM criará um novo objeto com as mesmas informações do objeto original, exceto pela variáveis *transientes*, que são reconstituídas com nulo (se objeto) ou primitivo padrão.

Se alguma superclasse não puder ser serializada, na desserialização o construtor dessa superclasse será chamado (se houver uma superclasse acima desta que puder ser serializada, mesmo assim o seu construtor é chamado).

Variáveis estáticas não são serializadas, pois temos uma por classe, e não por objeto. Quando um objeto é reconstituído, ele terá a variável estática com o valor usado atualmente.

##Escrevendo em arquivos de texto simples

Algumas vezes você terá de escrever em arquivos de texto simples. Para isso, basta usar a classe `FileWriter` para abrir um arquivo de texto e escrever nele, usando o método `write(String)`.

```java
import java.io.*;

public class example {
    public static void main(String[] args){
        
        try{
            // se não houver o arquivo, ele será criado
            FileWriter file = new FileWriter("myText.txt");
            // escreve algo
            file.write("olá");
            // dá uma quebra de linha e escreve algo
            file.write("\naté logo");
            // fecha o arquivo
            file.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
}
```

##*A classe java.io.File*

A classe *java.io.File* representa um arquivo em disco, mas não o conteúdo do arquivo (não possui métodos de leitura e gravação). Ao invés de fornecer o nome do arquivo em formato de *String* para uma classe que abre arquivos (como *FileWriter* ou *FileInputStream*), você pode fornecer um objeto *File* no lugar. Você pode, por exemplo, verificar se o caminho para o arquivo é válido antes de fornecer *File* para *FileWriter*.

Coisas que podem ser feitas com um objeto *File*:

1.Crie um objeto *File* que representa um arquivo existente

```java
File f = new File("MyCode.txt");
```

2.Crie um novo diretório

```java
File dir = new File("chapter 7");
dir.mkdir();
```

3.Liste o conteúdo de um diretório

```java
if(dir.isDirectory()){
    String[] dirContents = dir.list();
    for(int i = 0 ; i < dirContents.length ; i++){
        System.out.println(dirContents[i]);
    }
}
```

4.Capture o caminho absoluto de um arquivo ou diretório.

```java
System.out.println(dir.getAbsolutePath());
```

5.Exclua um arquivo ou diretório (retornará verdadeiro se for bem-sucedido)

```java
boolean isDelected = f.delete();
```

##Usando buffers

Quando se usa *FileWriter*, todas as vezes que você escrever usando o método *write()*, será gravado algo no arquivo de destino. Ok, atinge o objetivo, mas a um custo de recursos. Afinal, não é tão fácil escrever em arquivos em disco. Neste caso a solução é usar um *buffer*.

O *buffer* é um local temporário em que você armazena dados. Esses dados só são gravados em arquivo quando o *buffer* estiver cheio, ou no momento de fechar o arquivo. Você também pode pedir para o *buffer* gravar tudo o que estiver armazenando no momento com o método *flush()*. A classe *BufferedWriter* fornece um método de escrita usando um *buffer*.

##Lendo um arquivo usando buffer

Um exemplo:

```java
import java.io.*;

public class ReadAFile {
    public static void main(String[] args){
        try{
            File myFile = new File("myText.txt");
            // usamos FileReader para ler o arquivo de texto
            FileReader fileReader = new FileReader(myFile);
            // só acessa novamente o arquivo quando o buffer estiver vazio
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
```

##Problemas na serialização

Um objeto serializado não poderá ser desserializado se a sua classe (e as classes de suas variáveis de instância que representam referências para objetos) for modificada desde a sua última serialização.

Quase todo tipo de modificação dá algum problema (inclusive alterar algo na árvore de herança da classe). Vejamos as modificações que não oferecem problemas:

1. Adicionar variáveis de instância.
2. Adicionar classes à árvore de herança.
3. Remover classes da árvore de herança.
4. Alterar o nível de acesso de uma variável de instância.
5. Alterar uma variável de instância *transiente* para *não-transiente*.

###Usando *serialVersionUID*

Sempre que um objeto é serializado, o mesmo recebe a versão da classe usada. A versão é representada pelo *serialVersionUID*, e é calculada com base na estrutura da classe. Se no momento da desserialização, o *serialVersionUID* for diferente, o processo irá falhar. É possível ter algum controle sobre isso.

Você pode informar um *serialVersionUID* na classe. Assim, durante o processo de desserialização, esse valor continuará sendo o mesmo, não importa que modificações foram feitas. Mas tenha cuidado: tenha certeza que as alterações na classe são aquelas que não causam problemas na desserialização.

1.Use a ferramenta de linha de comando `serialver` para obter o *serialVersionUID* de uma classe

```
serialver Dog
```

2.Cole a saída em sua classe

```java
public class Dog implements Serializable {
    static final long serialVersionUID = -6849393434383848483L;
}
```

#**15 - Rede e Segmentos**

Como funciona a interação cliente-servidor:

1. O cliente se conecta com o servidor.
2. O servidor cria uma conexão e adiciona o cliente à lista de participantes.
3. Outro cliente se conecta.
4. O cliente *A* envia uma mensagem ao serviço.
5. O servidor faz algo, como enviar uma mensagem a todos aqueles que estiverem conectados.

Quando um cliente se conecta a um servidor, ele estabelece uma conexão de soquete. Um soquete (*java.net.Socket*) é um objeto que representa uma conexão de rede entre duas máquinas. Com a conexão criada, ele pode enviar e receber mensagens.

Para se conectar, é necessário saber duas coisas: o endereço IP e o número da porta **TCP**.

```java
Socket chatSocket = new Socket("196.164.1.103",5000);
```

A porta é um aplicativo específico sendo executado no servidor. Quando se cria um servidor, só é possível selecionar uma porta entre 1024 e 65535, pois as portas entre 0 e 1023 são reservadas a outros serviços.

##Lendo dados em um soquete

Para ler dados de um servidor, você pode criar um fluxo de conexão, tratando o servidor como se fosse um arquivo, ou seja, você informa um soquete ao fluxo de conexão, não um *File*,

1.Crie o soquete.
```java
Socket chatSocket = new Socket("127.0.0.1",5000);
```
2.crie um `InputStreamReader` encadeado ao fluxo de nível inferior do soquete.
```java
InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
```
3.crie um `BufferedReader` e leia.
```java
BufferedReader reader = new BufferedReader(stream);
String message = reader.readLine();
```

O número de IP "127.0.0.1" é o seu *localhost*, ou sua máquina. Use-o quando estiver testando uma aplicação.

##Gravando dados em um soquete.

Para gravar dados em um soquete use `PrintWriter`. Você poderia usar `BufferedWriter`, mas se estiver gravando uma *string* por vez, a melhor escolha é `PrintWriter`. Este possui dois métodos chaves: `print` e `println`.

1.Crie uma conexão de soquete.
```java
Socket chatSocket = new Socket("127.0.0.1",5000);
```
2.Crie um `PrintWriter` encadeado ao fluxo de saída de nível inferior do soquete.
```java
PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
```
3.Grave algo.
```java
writer.println("message to send.");
writer.print("another message");
```

##Criando um servidor simples

Mas um chat precisa de dois sockets, no mínimo. Um será um objeto `ServerSocket`, criado pelo servidor, e outro será o objeto `Socket` criado pelo cliente.

1.O aplicativo do servidor cria um `ServerSocket`, em uma porta específica.
```java
ServerSocket serverSocket = new ServerSocket(4242);
```
2.O cliente cria uma conexão de soquete direcionada ao aplicativo do servidor,
```java
Socket sock = new Socket("127.0.0.1",4242);
```
3.O servidor cria um novo objeto `Socket` para se comunicar com esse cliente.
```java
Socket sock = serverSocket.accept();
```

O método `accept()` espera por uma solicitação do cliente. Quando a solicitação chega, ele cria um objeto `Socket` para se comunicar com esse cliente. Sem o uso de segmentos (veremos mais adiante), esse processo só atende a um cliente por vez.

##Segmentos

Criando um novo segmento de execução:

```java
Thread t = new Thread();
t.start();
```

A classe `Thread` é do pacote `java.lang.`, ou seja, do pacote padrão. Um segmento (ou *thread*) é uma pilha de chamadas, e ter vários segmentos é ter várias pilhas.

Todo aplicativo java tem um segmento principal. A *JVM* é responsável por iniciar o segmento principal (e outros se necessário, como a coleta de lixo).

Na classe `Thread`, temos métodos para inicialização do segmento, vinculação de segmentos e suspensão do segmento. Existem outros métodos, mas esses são os principais.

Quando um segmento é criado, o *JVM* temporariamente interrompe o segmento principal para iniciar o novo segmento. Depois de inicializado o novo segmento, o *JVM* irá alternar entre este e o segmento principal até que ambos sejam concluídos.

###Iniciando um novo segmento:

1.Crie um objeto `Runnable` (a tarefa):
```java
Runnable threadJob = new MyRunnable()
```
Neste caso, **threadJob** é do tipo `Runnable`, uma interface. E **MyRunnable** é uma classe que implementa `Runnable`. Veremos como fazer isso mais adiante.
2.Crie um objeto `Thread` (o executor) e forneça a tarefa:
```java
Thread myThread = new Thread(threadJob);
```
3.Inicie o objeto `Thread`:
```java
myThread.start();
```

###Implemente *Runnable*

A interface `Runnable` só possui um método: `run()`. Você deve implementar esse método para fornecer a tarefa que será executada no *thread*.

```java
public class MyRunnable implements Runnable {
    public void run(){
        go();
    }
    
    public void go(){
        doMore();
    }
    
    public void doMore(){
        System.out.println("Hello!");
    }
}

class ThreadTester {
    public static void main(String[] args){
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        System.out.println("back in main");
    }
}
```

Quando se inicia um segmento, ele passa a ser executável. A partir daí ele pode se alterar para os estados *executável*, *em execução* e *temporariamente não executável* (ou *bloqueado*). Em geral, temos apenas os estados *executável* e *em execução*, porém o *JVM* pode bloquear um segmento, tornando-o *temporariamente não executável*, por diversas razões, como o segmento esperar por um dado indisponível no momento (como o fluxo de entrada de um soquete). Ou então o código que estiver sendo executado pode solicitar ao segmento que entre em suspensão (`sleep()`). Ou ainda o segmento tentou chamar um método em um objeto *bloqueado*.

Quem toma essas decisões de mudança de estado dos segmentos é o *agendador de thread*. Existe uma maneira de controlar a não execução de um segmento com o método estático `sleep()` (de `Thread`), onde você informa o tempo, em milissegundos, em que ficará suspenso. Esse método deverá estar em um bloco **try/catch**.

```java
public class MyRunnable implements Runnable {
    public void run(){
        go();
    }
    
    public void go(){
        
        // usando sleep
        try{
            Thread.sleep(2000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        doMore();
    }
    
    public void doMore(){
        System.out.println("Hello!");
    }
}

class ThreadTester {
    public static void main(String[] args){
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        System.out.println("back in main");
    }
}
```

###Dois segmentos

Você pode definir um nome para um segmento através do método `setName()`. Assim, pode diferenciá-los na execução. O exemplo a seguir usa essa característica para que possamos visualizar melhor como os *threads* funcionam (execute mais de uma vez e compare os resultados):

```java
public class MultipleThread{
    public static void main(String[] args){
        Runnable oneR = new MyRunnable();
        Runnable twoR = new MyRunnable();
        Thread one = new Thread(oneR);
        Thread two = new Thread(twoR);
        one.setName("I'm one!");
        two.setName("I'm two!");
        one.start();
        two.start();
    }
}

class MyRunnable implements Runnable{
    public void run(){
        for(int i=0; i<45; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
```

Você pode ver que às vezes o primeiro *thread* é executado por último. E às vezes há alternância entre os dois loops. Ou seja, nem sempre um *thread* irá esperar que outro termine.

###O problema com *threads*: concorrência

Pode ocorrer de dois ou mais segmentos precisarem manipular um mesmo objeto. O problema é que entre a verificação de algo e a alteração desse objeto por um segmento, outro segmento pode altera-lo também. Ou seja, o segmento **A** verifica se pode alterar o objeto (suponhamos que só possa ser alterado uma vez), então o segmento **B** entra em execução e faz a mesma verificação **e altera o objeto**; o segmento **A** volta a ser executado, e como, em sua pilha de chamadas, ele já verificou se o objeto pode ser alterado, ele o altera. Mas o objeto já foi alterado, e algo inesperado pode acontecer.

Isso pode ser evitado em java usando a palavra `synchronized` em um método que manipula o objeto supracitado. Essa palavra fará com que o método só possa ser usado por um segmento por vez, ou seja, será bloqueado enquanto estiver em uso. O que acontece é que todo objeto tem um cadeado, mas quase sempre esse cadeado está aberto. Quando um segmento utiliza um método sicronizado, o objeto é bloqueado e **nenhum outro segmento poderá entrar em qualquer um dos métodos sicronizados do objeto (qualquer um deles)**. Pelo menos até que o segmento atual termine de usar o método sicronizado.

Porém, sicronizar métodos pode gerar uma certa sobrecarga e deve ser evitado. Ou minimizado. Por exemplo, você pode sicronizar apenas certos trechos de um método, ao invés do método inteiro.

```java
synchronized(this){
    // code
}
```

Ou ainda tentar projetar para que apenas o segmento principal possa fazer alterações no objeto. Isso nos leva a uma questão importante: você precisa mesmo usar *thread* para o problema que está tentando resolver? A interação *usuário-servidor* é um caso do uso necessário de *threads*, mas é preciso justificar o seu uso em outras situações.

Existe ainda o problema do *impasse de segmentos*. Um segmento **A** pode ficar esperando a chave que está em posse do segmento **B**, que por sua vez espera por outra chave que está em posse do segmento **A**. Os dois segmentos ficarão parados. É preciso ter cuidado com isso no projeto. Comece a prestar atenção quando tiver que manipular dois ou mais objetos com métodos sicronizáveis.

>Uma possível solução: identifique o objeto principal, e outros objetos só poderão ser acessados caso esse objeto não esteja bloqueado.

#**16 - Conjuntos e tipos genéticos**

Já sabemos da existência da classe *ArrayList*. Ela é como um *array*, só que maleável. Mas e se você precisar ordenar os seus elementos? Essa classe não possui um método de ordenação, pois a ordenação não entra em seu conceito.

Bom, há outras classes, que serão examinadas mais adiante: *TreeSet* (mantém os elementos classificados e não permite duplicatas), *HashMap* (armazena e acessa elementos por meio do par *nome/valor*), *LinkedList* (melhor desempenho quando insere ou exclui elementos do meio do conjunto), *HashSet* (não permite duplicatas), *LinkedHashMap* (como *HashMap*, exceto por lembrar a ordem em que os elementos foram inseridos, e por poder ser configurado para lembrar a ordem em que os elementos foram acessados da última vez).

Não examinaremos essas classes agora. Por enquanto existe uma classe chamada *Collections* (de *java.util.Collections*) que possui diversos métodos estáticos. Entre eles temos *sort()*. Esse método recebe um objeto do tipo *List*. E como *ArrayList* herda *List*, então podemos usar *ArrayList* como argumento. O que *sort()* faz é ordenar os elementos da lista.

##Tipos genéricos

Em *Java* podemos ter tipos genéricos na declaração de uma classe. Isso quer dizer que é possível escolher um tipo no momento do uso da classe. Por exemplo, *ArrayList* é uma classe que usa tipo genérico. Você pode ter uma lista de *Strings* ou *Dog*, ou qualquer outro tipo desejado. A declaração de uma *ArrayList* é algo como:

```java
public class ArrayList<E> extends AbstractList<E> implements List<E> ... {
    
    
    public boolean add(E o){
        // mais código
    }
}
```

No código acima, apenas substitua `E` por qualquer tipo.

Além de classes com tipos genéricos, você pode ter métodos com tipos genéricos.

```java
public <T extends Animal> void takeThing(ArrayList<T> list){
    
}
```
Na declaração acima, primeiro definimos que `T` pode ser *Animal* ou qualquer tipo derivado de *Animal*. Depois usamos no parâmetro. Ao usar o método *takeThing()*, podemos substituir `T` por qualquer tipo derivado de *Animal*, ou o próprio *Animal*.

Olhando a documentação do método *sort()* da classe *Collections*, observamos que esse método usa tipo genérico. Neste caso, `T` precisa ser do tipo *Comparable*. Na verdade, *Comparable* é uma interface (em tipos genéricos, a palavra *extends* significa tanto *extends* como *implements*), então o tipo da lista que você está tentando ordenar precisa implementar *Comparable*.

```java
class Song implements Comparable<Song> {
    
    // code
    
    // método a ser implementado
    // retorna 0 se igual, menor que 0 se o objeto recebido for maior, e positivo se o objeto recebido for menor
    // s é o objeto recebido para comparação
    public int compareTo(Song s){
        // compara o título, que é uma String e possui o método compareTo, com o título de s
        return title.compareTo(s.getTitle());
    }
}
```

##Ordenando por diferentes critérios

O método *sort()* (de *Collections*) possui um método sobrecarregado que usa um objeto *Comparator* como critério de ordenação. *Comparator* é uma interface, e você pode criar quantas classes deste tipo quantas forem necessárias. E lembre-se: essas classes podem ser classes internas da classe que você estiver tratndo no momento.

Por exemplo:

```java
class ArtistCompare implements Comparator<Song>{
    public int compare(Song one, Song two){
        return one.getArtist().compareTo(two.getArtist());
    }
}
```

Usando essa classe:

```java
ArtistCompare artistCompare = new ArtistCompare();
Collections.sort(songList, artistCompare);
```

##Quando a exclusividade é importante

Na *API* *Collection* temos três interfaces principais: *List*, *Set* e *Map*. Usamos *List* quando a sequência é importante, e é possível que duas ou mais referências apontem para o mesmo objeto. A interface *Set* é para quando a exclusividade é importante (cada referência aponta para um objeto diferente). Já a interface *Map* usa o par *chave/valor* para guarda e resgatar os objetos.

Então, *ArrayList* não se preocupa com exclusividade. Há diversas opções para filtrar referências para o mesmo objeto, entre elas *HashSet*. O porém é que *HashSet* não se preocupará se dois objetos são parecidos o suficiente para serem tratados como iguais. Ele só verifica o *hashCode* de cada objeto e, se os *hashCode*s forem iguais, ele usa o método *equals()*. Se você quer que dois objetos suficientemente parecidos sejam tratados como iguais, precisa sobrepor os métodos *equals()* e *hashCode()* da classe *Object*.

```java
class Song {
    
    //....
    
    public boolean equals(Object aSong){
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }
    
    public int hashCode(){
        return title.hashCode();
    }
    
    //.....
}
```

E para classificar podemos usar *TreeSet*. Essa classe evita duplicatas e faz uma classificação. Se você não passar argumentos para *TreeSet*, ela usará o método implementado *compareTo*. Ou então você pode passar um objeto *Comparator* no construtor para uma classificação personalizada.

##Objetos *Map*

A classe *Map* não implementa *Collection*. Usamos *Map* quando precisamos de um objeto composto pelo par *chave/valor*. Em geral a chave é uma String, mas pode ser qualquer tipo de objeto, assim como o valor. A única restrição: não podem haver chaves duplicadas.

##Poliformismo e tipos genéricos

Imagine que *Dog* estende de *Animal* .Devido ao poliformismo, você pode passar uma matriz do tipo *Dog* como argumento para um método que espera uma matriz do tipo *Animal*. Mas não pode passar uma lista do tipo *Dog* para um método que espera uma lista do tipo *Animal*.

A razão é que alguém pode querer inserir, dentro do método, um elemento de outra classe que estende *Animal* na lista. E se o método receber uma lista do tipo *Dog* e alguém inserir um objeto *Cat* (que estende *Animal*)?

A situação acima pode acontecer no caso de uma matriz, mas ocorrerá um erro em tempo de execução. No caso da lista, os erros são tratados em tempo de compilação.

Mas há uma maneira de fazer isso com uma lista. Basta usar um **curinga**:

```java
public void takeAnimal(ArrayList<? extends Animal> animals){
    // code
}
```

Dessa maneira, a lista *animals* pode ser de qualquer tipo que estende *Animal* (inclusive o próprio *Animal*). E mais uma coisa: usar esse recurso impedirá que a lista seja alterada. Você não poderá adicionar ou retirar coisas da lista.

A seguinte forma também é válida:

```java
public <T extends Animal> void takeThing(ArrayList<T> list){
    
}
```

#**17 - Pacote, arquivos jar e implantação**

Na implantação, um aplicativo *Java* pode ser totalmente local, parte local e parte remoto, ou ainda ser totalmente remoto.

A primeira coisa a fazer antes de pensar em distribuir o aplicativo, é organizar os arquivos do projeto. Tenha uma pasta *source* para os arquivos de código fonte, e uma pasta *classes* para os arquivos de classe. Então entre na pasta *source* use a opção `-d` do compilador para informar onde irá colocar os arquivos de classe.

```
cd source/
javac -d ../classes *.java
```

Para executar o programa, basta entrar no diretório de classes.

##Criando um arquivo **JAR**

Um arquivo *JAR* contém todos os arquivos de classe necessários para a execução do aplicativo. O cliente não precisará se preocupar em extrair nenhum arquivo nem seguir qualquer instrução; ele só precisa executar o arquivo *JAR*, que em geral se resume a dar um clique duplo.

Um arquivo *JAR* precisa de uma *declaração*, um documento com informações importantes acerca do aplicativo. Veremos como criar uma declaração.

Vejamos os passos de como criar um arquivo *JAR*:

1.Certifique-se de que todos os arquivos estejam no diretório de classes.

2.Crie um arquivo *manifest.txt*, no diretório de classes, que indique qual a classe que possui o método *main()*. Esse arquivo deve ter uma linha (digite *ENTER* após essa linha, ou pode ocorrer um erro):

```
Main-Class: MyApp

```

3.Entre no diretório de classes e use a ferramenta *jar* para criar um arquivo *JAR* que contenha tudo o que é necessário.

```
cd classes
jar -cvmf manifest.txt appl.jar *.class
```

O comando acima adiciona todos os arquivos terminados em *class* no pacote. Se for necessário adicionar outro arquivo, deve listá-lo também (apesar de, em geral, não ser necessário).

Para executar um arquivo *JAR*, basta usar a *flag* `-jar` quando usar o comando *java*. Essa flag informará ao *JVM* que você está tentando executar um arquivo *JAR* ao invés de uma classe.

##Criando pacotes

Os pacotes são a solução para conflitos de nomes em *Java*. Pode acontecer de haver classes com nomes iguais no programa. O que vai evitar problemas de colisão de nomes são os pacotes.

Existe uma convenção de nomeação de pacotes que reduz o risco de colisão de nomes. Basta utilizar o nome do domínio invertido. Por exemplo:

```
com.headfirstjava.Book
```

A primeira parte, `com.headfirstjava`, é o nome do domínio invertido. E a segunda parte, `Book`, é o nome da classe. Na verdade, o nome da classe acaba sendo tudo, ou seja, `com.headfirstjava.Book`.

Para que uma classe pertença a um pacote, a primeira declaração dessa classe deve ser o pacote:

```java
package com.headfirstjava;
```

Depois você **deverá** criar uma estrutura de diretórios na pasta de arquivos fontes e de classes que coincida com o nome do pacote. Por exemplo, se a classe *Book* pertence ao pacote *com.headfirstjava*, então primeiro temos a pasta *com* e, dentro desta, temos a pasta *headfirstjava* e, dentro desta, temos o arquivo fonte de *Book*. Embora você tenha a opção de não fazer essa estrutura de diretórios, ela é bastante recomendável.

Compilar um projeto organizado dessa forma não é tão trivial como antes. Primeiro, você entra na pasta *source*. Depois use o comando *javac* com a *flag* `-d` para indicar o diretório de classes. E por último indique os arquivos fontes **sem** sair do diretório *source*. Tudo numa linha:

```
javac -d ../class/ com/mydomain/*.java
```

O compilador irá construir a estrutura necessária no diretório *class*. Para executar o aplicativo, faça algo como:

```
java com.mydomain.Mainclass
```

##Criando arquivo *JAR* com pacotes

1.Certifique-se de que todos os seus arquivos de classe fiquem dentro da estrutura de pacote correta, sob o diretório classes.

2.Crie um arquivo *manifest.txt* (na raiz da pasta de classes) que declare que classe tem o método *main()*, usando o nome qualificado.

```
Main-Class: com.headfirstjava.PackageExercise

```

3.Execute a ferramenta *jar* para criar um novo arquivo *JAR* que contenha os diretórios do pacote mais o arquivo de declaração.

```
cd class/
jar -cvmf manifest.txt pack.jar com
```

Veja que você só precisa informar o diretório principal. A ferramenta *jar* se encarregará do resto.

##Listar e extrair *JAR*

Para listar o conteúdo de um arquivo *JAR*, usamos o comando *jar* mais a *flag* `-tf`.

```
jar -tf myapp.jar
```

Para extrair o conteúdo de um arquivo *JAR*, usamos a flag `-xf`. O resultado será uma pasta *META-INF* com um arquivo *MANIFEST.MF* (que conterá algumas informações, como versão do *manifest*, versão do compilador e qual a classe principal), e a pasta de classes. *META-INF* quer dizer *metainformação*.

##Java Web Start

(essa parte é rápida. leia o livro)

#**18 - Implantação remota com o RMI**


