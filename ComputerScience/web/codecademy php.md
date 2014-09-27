Tutorial de php do site codecademy.com

[TOC]

--------------------------------------------------------------------------
#**Introduction to PHP**

*PHP* é uma linguagem de programação para servidores que pode fazer uma série de coisas, como se conectar a banco de dados, receber dados de formulários preenchidos por clientes, enviar *cookies*, criar páginas dinâmicas etc etc etc. 
 
Tá, mas como se escreve *php*? O arquivo com o código php precisa ter a extensão "**.php**". Na verdade, você pode escrever em html padrão, e colocar "espaços php" no arquivo com as tags `<?php` e `?>`. O que estiver entre essas duas tags é código php; o resto é html. 
 
##Sintaxe 
 
Para a saída de strings no html, o php tem a função **echo**. 
```php 
echo "Hello!"; 
```
 
Essa função é importante pois ela pode gerar elementos html, e até funções javascript! 
```php 
echo "<p>Hello!</p>"; 
``` 
Para concatenar strings, o php usa o sinal de ponto. 
```php 
echo "<p>" . "Hello!" . "</p>"; 
``` 
Essa função também pode receber outros tipos de dados, como números, que são exportados como strings. A função **print** faz quase o mesmo que **echo**, mas retorna 1 e geralmente é mais lenta, além de aceitar somente um parâmetro. Ou seja, procure usar **echo**, exceto nos casos em que é necessário usar **print**. 
 
As variáveis php sempre começam com um sinal de dólar ("**$**"). 
```php 
$name = "Jhon"; 
``` 
Toda linha em php termina em ponto e vírgula. 
 
Os comentários em php seguem o padrão C: **//** para uma linha ou **/\*** e **\*/** para linhas múltiplas. 


--------------------------------------------------------------------------
#**Conditionals and Control Flow**

Os operadores de comparação são os mesmos de outras linguagens de programação. 
```php 
5 < 10 
``` 
A estrutura *if else* é bem parecida com o padrão C, pois usa chaves e ponto-e-vírgula. 
```php 
if ($a > $b) { 
    echo "a is bigger than b"; 
} elseif ($a == $b) { 
    echo "a is equal to b"; 
} else { 
    echo "a is smaller than b"; 
} 
``` 
Veja que a diferença está no **elseif**. 


--------------------------------------------------------------------------
#**Control Flow: Switch**

A estrutura *switch case* também é bastante similar ao padrão C. A diferença é que C só aceita números ou um caractere, enquanto que php aceita, além desses dois, strings. 
```php 
switch (2) { 
    case 0: 
        echo 'The value is 0'; 
        break; 
    case 1: 
        echo 'The value is 1'; 
        break; 
    case 2: 
        echo 'The value is 2'; 
        break; 
    default: 
        echo "The value isn't 0, 1 or 2"; 
} 
``` 
Ao invés de chaves, você pode começar o bloco com dois pontos e terminar com a palavra reservada **endswitch**. 
```php 
switch (2): 
    case 0: 
        echo 'The value is 0'; 
        break; 
    case 1: 
        echo 'The value is 1'; 
        break; 
    case 2: 
        echo 'The value is 2'; 
        break; 
    default: 
        echo "The value isn't 0, 1 or 2"; 
endswitch; 
```

--------------------------------------------------------------------------
#**Arrays**

Você pode criar um array da seguinte forma: 
```php 
$my_array = array("Egg", "Tomato", "Beans"); 
``` 
O acesso aos elementos do array é feito como em outras linguagens de programação: 
```php 
$my_array[2] 
``` 
Ao invés de colchetes, você pode usar chaves. Para mudar os elementos de um array, você pode fazer diretamente como em outras linguagens de programação. O tamanho do array também é flexível. 
 
Para  deletar um elemento de um array, você pode usar a função **unset()**. Se passar todo o array, todos os elementos serão deletados (cuidado: o array não ficará vazio, deixará de existir! Geralmente se faz isso quando não precisar mais do array, para economizar memória). 
```php 
unset(my_array[1]); 
```

-------------------------------------------------------------------------
#**For Loops in PHP**

O loop for tem a mesma estrutura que em outras linguagens de programação. 
```php 
for ($leap = 2004; $leap < 2050; $leap = $leap + 4) { 
        echo "<p>$leap</p>"; 
} 
``` 
Existe uma função especial que executa um loop nos elementos de um array. É chamado de **foreach**. 
```php 
foreach($numbers as $item) { 
	echo $item; 
} 
```

------------------------------------------------------------------------
#**While Loops in PHP**

O **while** básico do php é similar a outras linguagens: 
```php 
while(cond) { 
	// looped statements go here 
} 
``` 
Você pode substituir as chaves por dois pontos e **endwhile**. 
```php 
while(cond): 
	// looped statements go here 
endwhile; 
``` 
O loop **do-while** é similar ao **while**, mas a verificação é feita no final. 


--------------------------------------------------------------------
#**Functions, Part I**

Com a função **strlen()** você pode obter o tamanho de uma string. A função **substr()** retorna uma parte de uma string; os argumentos são: uma string, um inteiro representado o início da substring e outro inteiro representando o tamanho da substring. 
 
Outras duas funções úteis de string são **strtoupper()** e **strtolower()**, que tornam os caracteres de uma string todos maiúsculos ou minúsculos, respectivamente. 
 
Para encontrar a posição de uma substring em uma string, use **strpos()**. Você informa a string e a substring, e um inteiro é retornado. Esse inteiro é a posição da substring. Se a string não contiver a substring, o valor *false* é retornado. 
 
A função **round()** é uma função matemática que arredonda um número real. Recebe como parâmetro o número real, e o transforma em inteiro. Você pode passar uma segundo parâmetro (opcional) que indica quantas casas decimais você deseja arredondar. 
 
A função **rand()** retorna um número aleatório entre dois números. Se não fornecer parâmetros, o número retornado será entre 0 e 32767. Ou pode fornecer dois números como parâmetros que indicam o limite inferior e superior do número a ser gerado. 
 
Na seção sobre arrays nós usamos uma função para criação de arrays: **array()**. Existe outra função que insere elementos em um array: **array_push()**. Essa função recebe um array e um valor a ser inserido neste array. O valor será inserido na última posição. Outra função é **count()**, que conta a quantidade de elementos do array (você só passa o array como parâmetro). 
 
Outra função de array útil é **sort()**, que ordena o array. Para ordenar no sentido contrário use **rsort()**. Ambas as funções só recebem o array a ser ordenado. 
 
Para imprimir os elementos de um array na tela, a função **join()** cria uma string de representação do array. Recebe dois parâmetros: uma string que servirá para separar um elemento de outro, e o array. 


-------------------------------------------------------------------------
#**Functions, Part II**

Acontece que em php você pode construir suas próprias funções. A sintaxe: 
```php 
function name (parameters) { 
	statement; 
} 
``` 
Para chamar uma função, basta escrever o seu nome, com os parâmetros entre parênteses (ou parênteses vazios se não houver parâmetros). 
 
Você pode usar a palavra **return** para que uma função retorne alguma coisa. 
 
Você pode definir um valor padrão para um parâmetro, tornando-o opcional na chamada da função. Dessa forma, se o usuário não definir o parâmetro, será usado o valor padrão. Você define esse valor padrão com o sinal de igualdade (como **$nome="carlos"**). Todos os parâmetros opcionais devem aparecer por último na ordem de parâmetros. 


-----------------------------------------------------------------------
#**Objects in PHP**

Php é uma linguagem orientada a objeto. Cada objeto possui métodos e propriedades. 
 
A sintaxe básica de uma classe é a seguinte: 
```php 
class ClassName { 
 
} 
``` 
E você pode criar uma nova instância de um objeto com a seguinte sintaxe: 
```php 
$obj1 = new ClassName(); 
``` 
A palavra reserva **new** inicializa o construtor. Antes de falar de construtores, vamos falar de propriedades. Propriedades são como variáveis exclusivas de um objeto (assim como em outras linguagens de programação). As propriedades são definidas na classe da mesma forma que uma variável comum, com a diferença que usamos uma palavra antes do nome da variável para definir se é uma variável pública ou privada: **public** ou **private**. Uma variável privada só pode ser acessada dentro da classe. Já as variáveis públicas podem ser acessadas do lado de fora da classe. 
```php 
class Fruit { 
	public $count = 3; 
	public $type; 
} 
 
$apple = new Fruit(); 
$apple->type = "apple"; 
print $apple->count; // 3 
print $apple->type; // apple 
``` 
Agora que conhecemos as propriedades, vamos falar do construtor. O construtor é um método da classe que inicializa o objeto, ou seja, configura suas propriedades iniciais. A sintaxe de um construtor: 
```php 
public function __construct($prop1,$prop2){ 
	$this->prop1 = $prop1; 
	$this->prop2 = $prop2; 
} 
``` 
A palavra **$this** se refere ao próprio objeto, ou seja, use-a para acessar propriedades e métodos particulares de um objeto dentro da classe. Um construtor deve ser um método público, pois deverá ser acessado fora da classe. Todo construtor tem o nome **__construct**, com dois símbolos underlines. E, finalmente, o construtor é um método, ou seja, uma função pertencente a um objeto. 
 
Da mesma forma que as propriedades, as funções podem ser públicas ou privadas. São definidas quase da mesma forma que uma função comum (após **public** ou **private** use **function** mais o nome do método, o resto é a mesma coisa; lembre-se de usar **$this** para se referir a propriedades e métodos do próprio objeto). Para acessar um método público de um objeto, usamos a sintaxe: 
```php 
$obj1->meth1(); 
``` 
Quase da mesma forma que acessar uma propriedade. 


----------------------------------------------------------------------
#**Object-Oriented PHP**

Existem funções que recebem objetos para fazer certas operações ou verificações. É o caso de **is_a()**, **property_exists()** e **method_exists()**. A função **is_a()** verifica se um objeto pertence a uma determinada classe; você passa o objeto e a classe para a função, nesta ordem. A função **property_exists()** verifica se uma propriedade existe em um objeto; você passa o objeto e a propriedade, nesta ordem. E a função **method_exists()** verifica se um método existe em um objeto; você passa o objeto e o nome do método. 
 
O conceito de herança também existe em php. A herança ocorre quando uma classe herda propriedades e métodos de outra classe. Usamos a palavra reservada **extends** para indicar isso: 
```php 
class Shape { 
     public $hasSides = true; 
} 
         
class Square extends Shape { 
         
} 
``` 
Você pode prevenir que um método seja reescrito por subclasses derivadas com a palavra **final**. Essa palavra deve vir antes de **public** ou **private**: 
```php 
class Vehicle { 
	final public function drive() { 
		return "I'm drivin' here!"; 
	} 
} 
``` 
Classes podem conter constantes. Para criar uma constante, escreva a palavra **const** e depois o nome da constante, sem o sinal de dólar **$**. 
```php 
const pi_value = 3.14; 
``` 
Para acessar uma constante de uma classe, use o nome da classe mais dois pontos duplos mais o nome da constante: 
```php 
Math::pi_value; 
``` 
Os dois pontos duplos é chamado de operador de escopo. 
 
Você pode usar a palavra **static** para permitir usar um método ou propriedade da classe sem a necessidade de um objeto. 
```php 
class Person { 
	public static $isAlive = "Yep!"; 
	public static function greet() { 
		echo "Hello there!"; 
	} 
} 
 
echo Person::$isAlive; // prints "Yep!" 
Person::greet(); // prints "Hello there!" 
``` 
Veja que precisamos usar o operador de escopo para acessar a propriedade ou método da classe. 


--------------------------------------------------------------------------
#**Advanced Arrays**

Já sabemos como funciona os arrays. Php possui também os *arrays associativos*. Arrays associativos são arrays em que cada valor possui uma chave, que é usada para acessar um valor específico (similar a dicionários em *Python* ou hash em *Ruby*). Php usa o sinal **=>** para associar cada chave ao seu respectivo valor. 
```php 
$myAssocArray = array('year' => 2012, 'colour' => 'blue', 'doors' => 5); 
``` 
Para acessar um valor em um array associativo, usamos a chave no lugar do índice: 
```php 
$myAssocArray["year"]; 
``` 
Arrays associativos também são conhecidos como *maps*. 
 
Para usar o **foreach** com arrays associativos, é muito simples: 
```php 
$salad = array('lettuce' => 'with', 
               'tomato'  => 'without', 
               'onions'  => 'with'); 
 
foreach ($salad as $ingredient=>$include) { 
    echo $include . ' ' . $ingredient . '<br />'; 
} 
``` 
Arrays também podem conter outros arrays, criando arrays multidimensionais. O acesso a arrays multidimencionais é feito usando mais de um índice ou chave: 
```php 
$my_array = array(array(1,2,3), 
     			  array(4,5,6)); 
 
echo $my_array[1][2]; // print 6 
```

--------------------------------------------
#**(pesquisar)**

1. super 
2. destrutor 
3. include() 
4. ver slide (salvo em downloads) 
