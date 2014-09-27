Tutorial de ruby do codecademy

[TOC]

-----------------------------------------------------------------
#**Introduction**

##Tipos de dados 
 
Ruby possui três tipos básicos de dados: numérico, booleano e texto ("string"). Basta declarar uma variável com os dados, e Ruby irá usar o tipo apropriado automaticamente. 
 
Exemplos: 
```ruby 
my_num = 25 # Add your code here! 
 
my_boolean = true # And here! 
 
my_string = "Ruby" # Also here. 
``` 
Exponenciais em ruby: ****** 
Módulo em ruby: **%** 
 
Você pode usar **to_f** para coverter para *float*, **to_s** para *string* e **to_i** para *inteiro*. 
 
Existe ainda o tipo **nil**, que quer dizer nulo. Você verá mais utilidades deste tipo mais adiante, mas geralmente é usado quando um programa não consegue retornar algum valor esperado. Por exemplo, se um array possui 3 posições e você tentar acessar a 5ª posição, o valor retornado será **nil**. 
 
##Entrada e Saída 
 
Existem dois comandos de saída bem parecidos: **puts** (com nova linha) e **print** (sem nova linha). Você pode imprimir variáveis também, como por exemplo: 
```ruby 
puts "Hello #{name}!" 
``` 
O código acima irá substituir **#{*name*}** pelo valor armazenado na variável *name*, e imprimir na tela. 
 
Para comando de entrada, temos **gets**. Você pode chamar **gets** e colocar o que o usuário digitar diretamente em uma variável. Por exemplo: 
```ruby 
my_name = gets.chomp 
``` 
O método **chomp** acima evita que a linha extra ao apertar *enter* seja incluída na variável. 
 
##Métodos 
 
Como tudo em ruby é objeto, nós podemos chamar um método de qualquer objeto usando a notação de ponto. Por exemplo, temos o método **length**, que retorna o tamanho de um objeto do tipo *string* (também pode ser usado em outros tipos de objetos). Logo, se chamarmos 
```ruby 
"Hello!".length 
``` 
teremos como retorno o valor 6, que é o tamanho da string "*Hello!*". 
 
Outro método de *string* interessante é **reverse**, que retorna a cadeia de caracteres na ordem inversa. Os métodos **upcase** e **downcase** retornam todos os caracteres da cadeia em maiúscula e minúscula, respectivamente. O método **capitalize** torna a primeira letra maiúscula e as demais minúsculas. 
 
Você pode usar o ponto de exclamação para modificar uma variável ao aplicar um método. Isso é importante quando você não quer somente retornar, por exemplo, uma string modificada, mas sim modificar a variável com esse retorno. Logo 
```ruby 
name.upcase! 
``` 
é o mesmo que 
```ruby 
name = name.upcase 
``` 
Um método interessante de substituição de substring é **gsub**. No lugar de uma *substring*, é colocada outra *substring*. Por exemplo, o código abaixo irá transformar "*Carlos*" em "*Carloth*": 
```ruby 
"Carlos".gsub!(/s/,"th") 
``` 
Ruby possui diversos métodos de verificação, que retornam *true* ou *false*. Em geral, esses métodos terminam com um ponto de interrogação. Por exemplo: 
```ruby 
"carlos".include? "s" 
``` 
retorna *true*, pois a substring "*s*" se encontra na string "*carlos*". 
 
Um método bastante interessante é **sort_by**. Você pode aplicar a *hashes* (veja na sessão mais adiante). Vejamos um exemplo de um hash: 
```ruby
frequencies = frequencies.sort_by {|a, b| b } 
```
Existe ainda o **reverse**. Isso irá inverter a ordem de um array (se bidimensional, irá ser de acordo com o 1º índice de cada subarray). Use o sinal de exclamação se quiser que o array ou hash seja modificado. 
 
Você pode verificar se um número é inteiro com o seguinte código: 
```ruby 
number = 2 
number.is_a? Integer # retorna true 
``` 
##Comentários 
 
Ruby usa o símbolo **#** para comentários de linha. Para comentar diversas linhas, use **=begin** para abrir o comentário e **=end** para terminar o comentário. 
```ruby 
# comentário de linha 
 
=begin 
Comentário 
de diversas 
linhas 
=end 
``` 
##Variáveis Locais 
 
As variáveis locais são variáveis que existem somente no escopo atual, e desaparecem fora dele. Em geral, são nomeadas com letras minúsculas. Se houver mais de uma palavra, elas em geral são separadas por underlines ("_"). 
##Variáveis Globais 
 
Variáveis globais podem ser acessadas em qualquer lugar do programa. São iniciadas com **$**, e geralmente as definimos no começo do programa. Tenha em mente uma coisa: tente reduzir o número de variáveis globais para zero. Muitas vezes é difícil definir o escopo de uma variável, o que pode gerar um monte de variáveis globais que na verdade poderiam ser locais. Além disso, variáveis globais sempre estão presentes, logo a memória sempre estará alocada e nunca liberada. 
 
##Constantes 
 
Constantes são como variáveis que não podem ser mudadas. Elas são inicializadas com um valor, e esse valor não pode ser alterado (na verdade você pode, mas ruby emitirá um alerta se você tentar fazer isso). O nome da constante deve conter apenas letras maiúsculas, e ela deve ser inicializada assim que criada. 
 
Mais adiante, na parte de módulos, as constantes poderão guardar informações importantes e imutáveis. Elas são muito importantes em diversas aplicações.

--------------------------------------------------------------------
#**Control Flow**

##If Else 
 
Ruby usa uma sintaxe **if else** levemente diferente da sintaxe padrão vista em outras linguagens. Em primeiro lugar todo fluxo **if** termina com a palavra **end**. 
```ruby 
if 3 < 10 
	print "this is true" 
end 
``` 
O estado **else** é normal como em outras linguagens. Porém, *else if* é substituído por **elsif**: 
```ruby 
if a < b 
	print "hello!" 
elsif b > a 
	print "hey!" 
else 
	print "a equal b" 
end 
``` 
Você também pode querer checar quando algo for *false*. Neste caso, você pode usar **unless**: 
```ruby 
unless sleep 
	print "study!" 
else 
	print "sleeping" 
end 
``` 
Veja que **unless** também possui um **end** no final. Ele é muito usado em linhas abreviadas, para fazer algo se um valor for *false*: 
```ruby 
print "Work!" unless sleeping 
``` 
##Case 
 
O **case** é uma estrutura de controle que verifica diversos casos. Quando algum dos casos ocorre, o código correspondente é executado. Se nenhum dos casos se encaixam, o **else** é executado (opcional). Vejamos a sintaxe: 
```ruby 
case language 
when "JS" 
	puts "Websites!" 
when "Python" 
	puts "Science!" 
when "Ruby" 
	puts "Web apps!" 
else 
	puts "I don't know!" 
end 
``` 
##Operadores de comparação 
 
Para usar os fluxos de controle corretamente, precisamos de operadores de comparação. Como em outras linguagens, em ruby nós temos **==** para comparar se duas coisas são iguais e **!=** para verificar se são diferentes. O resultado da comparação sempre retorna *true* ou *false*. 
 
Outros operadores de comparação são **<**, **>**, **<=** e **>=**. 
 
##Operadores booleanos 
 
Já observamos que o resultado de uma comparação retorna *true* ou *false*. E que existe um tipo de variável chamado *booleano*. Uma variável booleana pode receber somente dois valores: ou *true*, ou *false*. 
 
Variáveis booleanas são muito úteis no controle de estados e fluxos. 
 
Existem três operadores booleanos: *and* ("**&&**"), *or* ("**||**") e *not* ("**!**"). 
 
O operador *and* compara dois valores booleanos, e só retorna *true* se ambos forem *true*. Caso contrário, retorna *false*. 
```ruby 
true && true # true 
true && false # false 
false && true # false 
false && false # false 
``` 
O operador *or* compara dois valores, e só retorna *false* se ambos forem *false*. Caso contrário retorna *true*. 
```ruby 
true || true # true 
true || false # true 
false || true # true 
false || false # false 
``` 
O operador *not* inverte o valor booleano em que é aplicado. 
```ruby 
!true # false 
!false # true 
``` 
Você pode combinar diversos operadores booleanos, mas use parênteses para controlar a ordem de procedência. 

------------------------------------------------------
#**Loops & Iterators**

##While 
 
O **while** sempre executa quando a condição de teste é verdadeira. Por exemplo: 
```ruby 
counter = 1 
while counter < 11 
	puts counter 
	counter = counter + 1 
end 
``` 
Irá imprimir *counter* enquanto *counter* for menor que 11. 
 
O loop **until** funciona como **while**, só que executa o código enquanto uma condição não for verdade. Por exemplo: 
```ruby 
until sleep 
	puts "work!" 
	sleep = true 
end 
``` 
Enquanto *sleep* for *false*, é impressa a palavra "*work!*". É necessário tornar o estado de *sleep* para *true* para sair do loop. 
 
Ruby usa **+=** (e também **-=**, ***=** e assim por diante) para abreviar operações como **a = a + b**. Porém, essa linguagem não usa **++** ou **- -**. 
 
##For 
 
O loop **for** também é presente em ruby, de modo que é mais indicado quando se conhece o número de iterações do loop. 
```ruby 
for num in 1...10 
	puts num 
end 
``` 
No código acima, o loop percorre de 1 a 9, armazenando cada valor em *num*. O valor 10 não foi incluído pois usamos a notação de três pontos. Se tivéssemos usado a notação de dois pontos, o 10 teria sido incluso. 
 
##Loop do 
 
Existe ainda uma outra maneira de executar loops. Se fizermos 
```ruby 
loop{ print "Hello World!" } 
``` 
Ruby irá interpretar a chave de abertura como **do** e a chave de fechamento como **end**. Assim, esse código é equivalente a 
```ruby 
loop do 
	print "Hello World!" 
end 
``` 
Porém, esse código entrará num loop infinito. É necessária uma condição de parada para que o loop termine. Usamos **break** para isso 
```ruby 
loop do 
	print "Hello World!" 
	print "digite y para terminar: " 
	user_input = gets.chomp 
	user_input.downcase! 
	break if user_input == "y" 
end 
``` 
O loop acima irá terminar se o usuário digitar *Y* ou *y*. 
 
Para passar imediatamente para o próximo loop, usamos **next**. Isso irá interromper o loop atual e passar para o próximo. Tenha o cuidado de não gerar loops infinitos com isso. 
 
##Arrays 
 
Arrays são vetores que podem armazenar múltiplos valores. Em ruby, arrays são declarados como variáveis, mas com os diversos valores separados por vírgula, e todo o array entre colchetes (como na maioria das linguagens de programação) 
```ruby 
my_array = [1,3,2,5,8] 
``` 
Você acessa os valores do array pelo índice do mesmo: 
```ruby 
my_array[0] 
``` 
O código acima irá retornar o valor da primeira posição do array (os índices do array sempre começam em 0). 
 
Você pode usar **.each** para percorrer todos os valores do array. Ou seja, **.each** é um método que gera um loop. 
```ruby 
my_array.each do |x| 
	print x 
end 
``` 
Lembre-se que se pode usar chaves no lugar de **do** e de **end**.
```ruby 
my_array.each{ |x| print x } 
``` 
Você pode transformar uma string num array usando o método **split()**. No parênteses do split coloque **""** para separar todas as letras da string (cada letra terá uma posição no array) ou outro caractere para separar em substrings dependendo desse caractere. Por exemplo, o código abaixo separa a frase colocando cada palavra em uma posição do array: 
```ruby 
my_array = "eu ando de onibus".split(" ") 
``` 
##.times 
 
O método **times** aplicado a um número inteiro faz um loop uma quantidade de vezes igual a esse número. Por exemplo, o código abaixo imprime "*a*" dez vezes: 
```ruby 
10.times{ print "a" } 
```

-----------------------------------------------------------------------
#**Data Structures**

##Arrays 
 
Array (ou vetor) é um tipo de estrutura de dados que permite armazenar mais de uma valor. É como uma variável, mas com mais espaço de armazenamento. 
 
Em ruby, um array é flexível. Você não declara o seu tamanho na declaração do mesmo, basta atribuir um array vazio ou um array com conteúdo, usando colchetes. 
```ruby 
my_array_1 = [] 
my_array_2 = [1,2,5] 
``` 
Você também pode criar um array vazio da seguinte maneira: 
```ruby 
my_array = Array.new 
``` 
Como em outras linguagens, as posições de um array em ruby são indexadas a partir do zero. Assim, para acessar a terceira posição de um array, fazemos 
```ruby 
my_array[2] 
``` 
Também como em outras linguagens, os arrays em ruby podem ter mais de uma dimensão sem problemas. 
 
Outra coisa importante com relação aos arrays: o tamanho do mesmo não é fixo, você pode adicionar elementos além do seu tamanho inicial, e inclusive retirá-los. Também é possível adicionar uma posição com valor nulo (valor representado por **nil** em ruby). 
 
##Hashes 
 
Um Hashe é similar a um array, só que você não define apenas os conteúdos. Para cada conteúdo você terá que definir uma chave. Isso é bem similar aos objetos em *JavaScript* ou os dicionários em *Python*. 
```ruby 
my_hash = { 
	"name" => "Carlos", 
	"age" => 29 
} 
``` 
Assim, para acessar valores de um hash, o procedimento é bem parecido com arrays. A diferença é que você passa a chave ao invés do índice 
```ruby 
my_hash["name"] 
``` 
Assim como nos arrays, os hashes podem receber novos conteúdos. Assim, 
```ruby 
my_hash = Hash.new 
my_hash["name"] = "John" 
``` 
Você pode colocar algo no parênteses de **new** para que toda nova chave possa receber um valor padrão. Por exemplo: 
```ruby 
my_hash = Hash.new(0) # o valor padrão é zero 
my_hash["c1"] += 1 # chave c1 é criada com valor 0, e então é incrementada 
``` 
Em arrays, você pode usar **.each** para gerar um loop com todos os seus valores. Em hashes você pode fazer o mesmo, 
```ruby 
my_hash.each{ |x,y| puts "#{x}: #{y}" } 
```

--------------------------------------------------------------
#**Methods, Blocks, & Sorting**

##Métodos

Métodos são trechos reutilizáveis de código, escritos para tarefas específicas. Em outras linguagens orientadas a objeto, nós temos funções e métodos, este último sendo funções de classes. Mas em ruby, métodos são funções de qualquer tipo, seja de classe ou não. 
 
*(de fato, se tudo é objeto, então as funções "sem classe" na verdade também são métodos)*
 
Sintaxe de um método: 
```ruby 
def soma(a,b) 
	c = a + b 
	puts c 
end 
``` 
Você pode definir métodos "vazios", sem código em seu interior, com uma única linha: 
```ruby 
def algumacoisa; end 
``` 
Se o método não possuir parâmetros, você pode deixar os parênteses vazios, ou simplesmente não colocar parênteses. 
 
Para chamar um método, basta digitar o seu nome com os argumentos necessários (ou sem parênteses caso não tenha parâmetros). 
 
Você pode definir parâmetros com argumentos padrão. Argumentos padrão são utilizados quando não se define o mesmo na chamada da função. Sempre coloque os parâmetros com valores padrão por último, para que o interpretador ruby saiba que valores estão faltando. Por exemplo: 
```ruby 
def soma(a,b=0) 
	return a+b 
end 
 
soma(10) 
``` 
No código acima, observe que chamamos *soma* somente com um argumento. Como não definimos um argumento para o parâmetro *b*, o valor padrão 0 é utilizado. 
 
##Splat Arguments 
 
Estes são usados quando o usuário digita vários argumentos de um mesmo tipo. Por exemplo, 
```ruby 
def somatorio(*a) 
	c = 0 
	a.each { |value|  c +=value } 
	puts c 
end 
 
somatorio(2,3,5) 
``` 
O código acima faz o somatório dos números 2, 3 e 5. Esse tipo de argumento é precedido de um asterisco ("*****"), indicando que o usuário pode fornecer mais um. Ele será tratado como um array no código. 
 
##Return 
 
O **return** retorna algo para o trecho do código que chamou o método. Por exemplo: 
```ruby 
def soma(a,b) 
	return (a + b) # retorna o valor da soma 
end 
 
puts soma(5,10) # imprime o valor retornado 
``` 
O método, quando chamado, retorna alguma coisa, que poderá ser utilizado pelo programador. 
 
Porém, tenha isso em mente: o **return** interrompe o método, saindo dele, não importa em que parte do código você esteja. Mas isso pode ser útil; por exemplo, um método que calcule a média, pode calcular a média do tipo aritmética ou geométrica. Uma vez calculada a média pretendida, não há mais necessidade de calcular qualquer outra média. 
```ruby 
# method 1: arithmetic 
# method 2: geometric 
def mean(method,*a) 
	if (method == 1) 
		c = 0 
		count = 0 
		each.a { |value| 
			c+=value 
			count+=1 
		} 
		if (count>0) 
			return (c/count) # retorna média aritmética 
		else 
			return -1 
		end 
	end 
	if (method==2) 
		c = 1 
		count = 0 
		each.a { |value| 
			c *= value 
			count+=1 
		} 
		if(count >0) 
			return (c**(1/count)) # retorna média geométrica 
		else 
			return -1 
		end 
	end 
end 
 
puts mean(1,4,5,6,7) 
``` 
Você ainda pode colocar um ponto de interrogação depois do nome do método (e antes dos parâmetros) para que o valor retornado seja traduzido em *true* ou *false*. 
```ruby 
def is_even?(n) 
	return (n%2==0) 
end 
``` 
No código acima, se **n%2** for igual a zero, então o método retorna *true*. Caso contrário retorna *false*. 
 
##Blocos 
 
Blocos são definidos com as palavras reservadas **do** e **end**, ou por meio de chaves. Por exemplos, temos dois blocos abaixo: 
```ruby 
1.times do 
	puts "Hello!" 
end 
 
1.times { puts "Hello!" } 
``` 
Blocos são como métodos sem nome. Por isso, só podem ser utilizados uma vez. Blocos são melhores que métodos quando precisamos fazer algo apenas uma vez. Além disso, nada impede de um método possuir um ou mais blocos dentro dele, ou ainda pegar o bloco como parâmetro (por exemplo, **each** faz isso). 
 
##Ordenação 
 
O método **sort** pode ser usado para ordenar um array (use um ponto de exclamação para alterar o array após ordená-lo). 
```ruby 
my_array.sort! 
``` 
Você pode usar o operador combinado de comparação **<=>** para verificar se um objeto é maior, menor ou igual a outro. Se igual, retorna 0 (zero), se o primeiro é menor retorna -1 e se o primeiro é maior retorna 1. 
 
Usando o operador combinado de comparação, é possível ordenar um array de forma descendente. Por exemplo, 
```ruby 
my_array.sort! { |second, first| first <=> second } 
``` 
Ao invés disso, você pode usar o método **reverse**, que faz o mesmo que **sort**, só que na ordem inversa. 

----------------------------------------------------------------------
#**Hashes and Symbols**

##Hash

*Hash* é uma estrutura formada por pares de valores, onde o primeiro elemento do par é uma chave, e o segundo elemento do par é um valor. Cada chave deve ser única, mas os valores podem se repetir. 
```ruby 
my_hash = { 
	"name" => "jos", 
	"age" => 29 
} 
``` 
Você pode usar o método **each** para interagir com os elementos do hash. 
```ruby 
my_hash.each { |key, value| 
	puts key, my_hash[key] 
} 
``` 
Se tentar acessar um hash com uma chave que não existe, o valor retornado será **nil**. Esse valor retornado pode ser diferente se usar um argumento na criação do hash em **Hash.new**. Por exemplo: 
```ruby 
my_hash = Hash.new("valor padrao") 
``` 
No código acima, "*valor padrao*" será retornado se a chave especificada não existir. 
 
##Símbolos 
 
Símbolos, iniciados por dois pontos ("**:**"), são conjuntos de nomes, que podem ser usados no lugar de strings para definição de chaves. 
 
Duas strings com o mesmo valor ainda são dois objetos diferentes. Mas dois símbolos com o mesmo nome são dois objetos iguais. Isso quer dizer que 
```ruby 
"ola".object_id == "ola".object_id 
:ola.object_id == :ola.object_id 
``` 
na primeira linha, o retorno é *false*, enquanto que na segunda é *true*. O método **object_id** retorna o *id* do objeto. 
 
Um símbolo começa com dois pontos, e o próximo caractere deve ser um underscore ou letra; depois pode ser qualquer combinação de letras, números e underscores. Abaixo temos um exemplo do uso de símbolos em um hash: 
```ruby 
my_hash = { 
	:name => "jc", 
	:age => 29 
} 
``` 
Símbolos como chaves são melhores que strings, pois somente uma cópia de um símbolo existe ao mesmo tempo (economia de memória) e são imutáveis após criados. Você pode converter símbolos para strings usando o método **to_s**, e strings para símbolo com **to_sym**. O método **intern** tem o mesmo efeito que **to_sym**. 
 
A partir do *ruby 1.9*, a sintaxe foi levemente alterada (você ainda pode usar a sintaxe usual), por exemplo: 
```ruby 
my_hash = { 
	name: "jos", 
	age: 29 
} 
``` 
Observe que *name* e *age* são símbolos, ou seja, *:name* e *:age*. 
 
##Select 
 
O método **select** pode ser usado para filtrar um *hash*, retornando outro *hash* que atenda aos critérios especificados. Por exemplo 
```ruby 
my_hash= { 
	um: 1, 
	dois: 2, 
	tres: 3 
} 
 
my_hash.select { |key,value| value <= 2 } 
``` 
A última linha do código acima retorna um hash com pares que tenham valores menores ou iguais a 2. 
 
##Navegar somente nos valores ou chaves 
 
Ao invés de navegar nos pares de chaves e valores em hashes usando o método **each**, você pode navegar somente nos valores ou somente nas chaves. Por exemplo: 
```ruby 
my_hash = { 
	um: 1, 
	dois: 2, 
	tres: 3 
} 
 
my_hash.each_key { |v| puts v } 
my_hash.each_value { |v| puts v } 
``` 
A penúltima linha imprime somente as chaves, enquanto que a última linha imprime somente os valores. 
 
##Deletar pares do hash 
 
Você pode deletar pares do hash usando o método **delete**. 
```ruby 
my_hash = { 
	name: "jc", 
	age: 29 
} 
my_hash.delete(:name) 
```

-----------------------------------------------------------
#**The Zen of Ruby**

##Linhas abreviadas 
 
Você pode usar uma abreviação que comece com um código e depois uma condição simples, numa única linha. Não coloque a condição antes! A condição vem depois para evitar o uso da palavra **end**. 
```ruby 
puts "Hello!" if ok 
``` 
No código acima, se *ok* for *true* então, "*Hello!*" é impresso. 
 
Existe ainda o **unless**, que pode ser usado da mesma forma (só que **unless** significa "ao menos que", ou seja, executa o código exceto quando algo for verdade). 
```ruby 
puts "Awake!" unless sleeping 
``` 
Podemos estender essas abreviações as expressões condicionais ternárias, que começam com uma condição, um sinal de interrogação, um código se verdadeiro, dois pontos e um código se falso. 
```ruby 
puts ( 3<4 ? "3 e menor que 4" : "3 nao e menor que 4" ) 
``` 
Também é possível abreviar estruturas *case/when* com a palavra **then** após cada **when** (exceto no **else**): 
```ruby 
case number 
when 1 then puts "one" 
when 2 then puts "two" 
else puts "other!" 
end 
``` 
##Dicas e Truques 
 
Você pode usar o operador de atribuição **=** para atribuir um valor a uma variável. Porém, e se você desejar atribuir um valor somente se nenhum valor já foi atribuído? É assim que funciona o operador de atribuição condicional **||=**. 
```ruby 
my_variable = nil 
 
my_variable ||= "Hello!" # aceita a atribuição, pois a variável tem valor nulo 
 
my_variable ||= "Hi!" # não aceita a atribuição, pois a variável é não nula 
``` 
Quando um método não retorna um valor, ruby irá retornar alguma coisa de forma implícita. Por exemplo, se um método que calcula a soma de dois números não tiver um return, o resultado da última operação realizada é retornado. As vezes pode ser uma maneira de resumir o código, mas tenha cuidado com isso: é difícil definir com certeza o que é retornado, além do fato de às vezes precisamos verificar se um método foi bem sucedido em fazer algo (retorno *true* ou *false*). 
```ruby 
def soma(a,b) 
    a+b # esse resultado é retornado 
end 
``` 
Lembra dos operadores booleanos? Ruby sempre irá parar de executar uma expressão quando o resultado já puder ser definido. Por exemplo, nas expressões 
```ruby 
false && true 
true || false 
``` 
Na primeira linha acima, o código irá parar no primeiro *false*, já que usamos o operador **&&** e, portanto, só daria *true* se ambos fossem *true*. Já na segunda linha, como usamos o operador **||**, temos a expressão só dará *false* se ambos forem *false*, logo a execução vai parar em *true*. É preciso ter isso em mente quando precisamos verificar diversas condições em sequência, mas a segunda condição depende da primeira ser verdadeira; se a primeira for falsa, o código não executa a segunda (usamos neste caso o operador **&&**). 
 
Dois loops interessantes são através dos métodos **upto** e **downto**. O método **upto** gera um loop crescente até um valor de parada (por exemplo, de 9 até 12, ou de "*a*" até "*f*"). O **downto** gera um loop decrescente. Vejamos exemplos de ambos 
```ruby 
9.upto(15) {|number| puts number} 
"a".upto("h") {|letter| puts letter} 
9.downto(5) {|number| puts number} 
``` 
Você pode verificar se um objeto pode executar um determinado método com **respond_to**. Por exemplo, para verificar se um array pode receber o método **push**, podemos fazer 
```ruby 
[1,2,3].respond_to?(:push) 
``` 
Veja que o método a ser testado é colocado como argumento na forma de símbolo. O código acima retornará *true*, pois **push** pode ser aplicado a um array. 
 
Sabemos que o método **push** adiciona elementos no final de um array e que **+=** pode ser usado para concatenação de strings. Bom, você também pode usar o operador **<<** para fazer a mesma coisa em ruby: 
```ruby 
a = [1,2,3] 
a << 4 
b = "Hello" 
b << "!" 
``` 
No código acima, a segunda linha adiciona 4 ao final do array, e a última linha concatena a string de *b* com "*!*". 

----------------------------------------------------------------
#**Blocks, Procs, and Lambdas**

##Blocos 
 
O método **each** pega cada elemento de um array e faz alguma operação, como imprimir o elemento na tela. Mas e se desejamos alterar o array de alguma forma e retornar outro array alterado? Para isso temos o **collect**: 
```ruby 
my_array = [1,2,3] 
 
my_array.collect{|number| number**2} 
``` 
O código acima irá retornar outro array modificado (o original não é modificado; para modificar o original, use o ponto de exclamação), ou seja, [1,4,9]. 
 
Existe uma maneira de escrever métodos que aceitam blocos em ruby. Veja o exemplo abaixo. Ele usa a palavra **yield** para executar o que estiver no bloco da chamada do método dentro do método. 
```ruby 
def test 
	print "Hello! " 
	yield 
	puts " Hi!" 
end 
 
test{ print "I'm Carlos!"} 
``` 
O código acima irá imprimir "*Hello! I'm Carlos! Hi!*", pois usamos **yield** na segunda linha do método, invocando o bloco que foi passado para a chamada do método. 
 
O bloco **yield** também pode receber parâmetros. Veja o código abaixo para ter uma ideia de como fazer isso: 
```ruby 
def test(name) 
	print "Hello! " 
	yield(name) 
	puts " Hi!" 
end 
 
test("Carlos"){|name| print "My name is #{name}!"} 
``` 
##Procs 
 
Blocos são exceção da regra principal de ruby: "tudo é objeto". Mas os *procs* existem para contornar esse problema. Os *procs* são blocos salváveis. Basta atribuir a uma variável e o bloco poderá ser usado novamente. 
```ruby 
multiples_of_3 = Proc.new {|n| n%3 == 0} 
(1..100).to_a.select(&multiples_of_3) 
``` 
No código acima um bloco é salvo na variável *multiples_of_3*, usada na segunda linha. Observe a sintaxe para salvar o bloco e para utilizá-lo. 
 
O código abaixo permite que você use um *proc* em um método por meio do **yield**: 
```ruby 
def greeter(hi) 
	puts hi 
	yield 
end 
 
phrase = Proc.new{puts "Hello there!"} 
greeter("Hi!",&phrase) 
``` 
Procs podem ser chamados diretamente por meio do método **call**. 
```ruby 
test = Proc.new{puts "Hi!"} 
 
test.call 
``` 
Já vimos que podemos passar o nome de um método como um símbolo, por exemplo **:to_i**. Acontece que podemos transformar um símbolo em *proc* usando o operador *&*. Por exemplo 
```ruby 
strings = ["1","2","3"] 
nums = strings.map(&:to_i) 
``` 
##Lambda 
 
*Lambdas* também são objetos. Na verdade, o que diferencia *procs* de *lambdas* é a sintaxe. 
```ruby 
def greeter(hi) 
	puts hi 
	yield 
end 
 
phrase = lambda{puts "Hello there!"} 
greeter("Hi!",&phrase) 
``` 
Mas existem duas diferenças entre *procs* e *lambdas*. A primeira é que *lambda* checa o número de argumentos (e você pode tratar alguma possibilidade de erro), enquanto que *proc* não o faz. Outra questão é que quando um método chama um *lambda* que retorna algo, quando o retorno acontece, ele volta a executar o método de onde parou; no caso de *proc*, o método é imediatamente interrompido. 

------------------------------------------------------------------
#**Object-Oriented Programming I**

Ruby é uma linguagem de programação orientada a objeto, que são construtos que possuem métodos e atributos. Para gerar objetos, ruby usa classes. Uma classe é um conjunto de código que cria objetos com métodos e atributos similares. 
```ruby 
class Language 
	def initialize(name, creator) 
		@name = name 
		@creator = creator 
	end 
	def description 
		puts "I'm #{@name} and I was created by #{@creator}!" 
	end 
end 
 
ruby = Language.new("Ruby", "Yukihiro Matsumoto") 
python = Language.new("Python", "Guido van Rossum") 
javascript = Language.new("JavaScript", "Brendan Eich") 
 
ruby.description 
python.description 
javascript.description 
``` 
##Classe 
 
A sintaxe básica de uma classe é muito simples. Basta usar a palavra **class** mais o nome da classe, em geral com a primeira letra maiúscula (isso é convenção). 
```ruby 
class Person 
	# conteúdo da classe 
end 
``` 
Existe um método padrão que existe em toda classe: **initialize**. Esse método é o que gera o objeto, é o ponto de partida inicial ao usar a classe. 
```ruby 
class Person 
	def initialize 
		# conteúdo da inicialização 
	end 
end 
``` 
O símbolo **@** antes do nome de uma variável significa que é uma variável de instância. Uma instância é um objeto gerado por uma classe. Logo, a variável de instância possui valores particulares de cada objeto, ou seja, cada objeto possui a sua variável em particular. Por exemplo, se uma classe possui uma variável *@name*, então cada objeto gerado por essa classe terá o seu próprio *@name*. 
```ruby 
class Person 
	def initialize(name) # new tem um parâmetro 
		@name = name 
	end 
end 
``` 
Criar um objeto a partir de uma classe é muito fácil. Basta criar uma variável e atribuir a uma classe com o método **new** e seus argumentos. Por exemplo: 
```ruby 
carlos = Person.new("Carlos") 
``` 
A variável *carlos* será um objeto daqui para frente, com a variável de instância *@name* igual a "*Carlos*". 
 
##Classes e Objetos 
 
O escopo é algo importante em ruby. Existem variáveis que são visíveis em qualquer lugar (globais), enquanto que existem variáveis que somente são visíveis em um contexto particular (locais). Já vimos que variáveis locais são definidas normalmente, sem qualquer símbolo no início, e que variáveis globais começam com **\$**. Também vimos que variáveis de instância começam com **@**. Na verdade, variáveis globais podem ser definidas da mesma forma que as variáveis locais, basta colocar fora de qualquer classe ou bloco (mesmo assim, é uma boa ideia usar o símbolo **$**). 
 
*(Uma pausa para um lembrete: variáveis globais podem ser alteradas em qualquer lugar de seu programa. Por isso tente evitá-las)*
 
Existe ainda outro tipo de variável que não vimos ainda: *variáveis de classe*. As variáveis de classe começam com **@@** e são visíveis a todos os objetos de uma mesma classe. Por exemplo, digamos que você queira contar quantos objetos foram criados por uma classe. Basta fazer como no exemplo abaixo: 
```ruby 
class Person 
	@@n_persons = 0 
	def initialize(name) 
		@@n_persons += 1 
		@name = name 
	end 
	def self.display_n_persons 
		puts @@n_persons 
	end 
end 
 
jack = Person.new("Jack") 
Person.display_n_persons 
``` 
Veja que a classe inicializa *@@n_persons* em 0. Quando um objeto é criado, *@@n_persons* aumenta em um. O método *display_n_persons* mostra o valor atual de *@@n_persons* (veremos mais sobre métodos de classes mais adiante); para chamar esse método, não utilizamos o objeto criado, mas o nome da classe, pois a variável que queremos acessar é uma variável de classe. 
 
##Herança 
 
Em programação orientada a objeto, o conceito de herança é importante. A herança ocorre quando queremos que uma classe tenha os mesmos métodos e atributos de outra classe. Digamos que você esteja construindo duas classes, *Cat* e *Dog*. Acontece que *Cat* e *Dog*, mesmo que sejam duas classes diferentes, herdam métodos e atributos de *Animal*. Vejamos um exemplo simples: 
```ruby 
class Animal 
	def initialize 
		@alive = true 
	end 
 
	def alive_message 
		puts "I'm alive!" if @alive 
		puts "I'm dead" unless @alive 
	end 
end 
 
class Dog < Animal 
 
end 
 
chiaua = Dog.new 
``` 
Veja a forma como criamos a herança em *Dog*. Basta usar o símbolo **<**, que indica que *Dog* está herdando de *Animal*. Mesmo que Dog não tenha um método **initialize**, *Animal* tem, o que significa que *Dog* também terá, assim como a variável de instância *@alive*. 
 
A herança reduz a quantidade de código repetido que você precisa escrever quando cria muitas classes. Para usar a herança de forma adequada, verifique quais as classes de seu projeto, e planeje como criá-las. 
 
Você ainda pode sobrescrever um método da classe herdada definindo-o novamente na nova classe. Por exemplo, usando a classe *Animal* definida anteriormente: 
```ruby 
class Zombie < Animal 
	def initialize 
		@alive = false 
	end 
end 
``` 
No código acima, nós sobrescrevemos o método initialize de *Animal* em *Zombie* (não se preocupe, isso não afetará *Animal*). 
 
Ao invés de sobrescrever o método, podemos expandir o mesmo com a palavra **super**. O que essa palavra faz é invocar o mesmo método na classe herdada.
```ruby 
class Creature 
	def initialize(name) 
		@name = name 
	end 
   
	def fight 
		return "Punch to the chops!" 
	end 
end 
 
class Dragon < Creature 
	def fight 
		puts "Instead of breathing fire..." 
		super 
	end 
end 
``` 
Uma coisa importante: você não pode ter uma classe com duas heranças diretas. Por exemplo, Dog que herda de *Animal* e de *Wolf* diretamente. O ideal é que *Wolf* herde de *Animal* e *Dog* herde de *Wolf*. Veremos sobre herança múltipla mais adiante. 

--------------------------------------------------------------------------
#**Object-Oriented Programming II**

##Restrições 
 
Em ruby, você pode definir que um método é privado. Isso significa que ele só pode ser acessado de dentro da classe, nunca fora dela. Já um método público pode ser acessado de fora normalmente. Podemos definir métodos públicos e privados com as palavras **public** e **private**. 
```ruby 
class Person 
	def initialize(name) 
		@name = name 
	end 
 
	public 
 
	def say_hello 
		puts "Hello! I'm #{@name}!" 
	end 
 
	private 
 
	def new_name(name) 
		@name = name 
	end 
end 
``` 
O que signica exatamente "poder chamar um método de fora da classe"? Significa chamar um método numa instância da classe. Por exemplo, se *charles* é uma instância de *Person*, nós podemos chamar *charles.say_hello*, mas não *charles.new_name("jackie")*, pois o método *new_name* é privado. 
 
Os métodos são públicos por padrão em ruby. Porém, usar a palavra **public** faz seu código ser mais legível para as outras pessoas. 
 
Nós podemos definir o que é possível fazer externamente com as variáveis de instância. Por exemplo, pode ser que queiramos acessar o valor de uma variável de instância, ou mudar esse valor. Ruby considera que todas as variáveis de instância são privadas por padrão, a menos que você crie algum método de acesso/alteração: 
```ruby 
def name 
	@name 
end 
 
def name=(value) 
	@name = value 
end 
``` 
O primeiro método retorna o valor da variável de instância *@name*. O segundo método altera. Ruby tem uma solução mais elegante para esses dois casos, usando as palavras **attr_reader** e **attr_writer**, que são, respectivamente, leitura e escrita: 
```ruby 
attr_reader :name 
attr_writer :name 
``` 
Se uma variável é leitura e escrita ao mesmo tempo, você pode usar a palavra **attr_accessor**: 
```ruby 
attr_accessor :name, :age 
``` 
##Módulos 
 
Módulos são locais onde você pode guarda métodos e constantes. Eles sempre estarão disponíveis para uso. São bem parecidos com classes, mas não podem instanciar objetos nem possuem subclasses. Eles apenas guardam coisas. 
```ruby 
module Circle 
	PI = 3.14 
 
	def Circle.area(radius) 
		PI*radius**2 
	end 
 
	def Circle.circunference(radius) 
		2*PI*radius 
	end 
end 
``` 
Para acessar uma constante do módulo, basta usar o nome do módulo, dois pontos duplos e o nome da constante. 
```ruby 
Math::PI 
``` 
Para que possa usar um módulo, é necessário importar o mesmo com a palavra *require*: 
```ruby 
require 'date' 
``` 
Qualquer classe pode incluir módulos em seu interior. Assim, você não precisa mais usar **nome-do-módulo::** para acessar qualquer método ou constante do módulo. Para isso basta colocar **include** mais o nome do módulo, sem aspas, no início da classe: 
```ruby 
class test 
	include Circle 
	def initialize 
		@pi = PI 
	end 
end 
``` 
##Mixin 
 
Você pode usar módulos para adicionar comportamentos adicionais à classes, o que chamamos de *mixin*. São úteis quando precisamos, por exemplo, adicionar diversos comportamentos a diversas classes, com um mínimo de reescrita. 
```ruby 
module Action 
  def jump 
    @distance = rand(4) + 2 
    puts "I jumped forward #{@distance} feet!" 
  end 
end 
 
class Rabbit 
  include Action 
  attr_reader :name 
  def initialize(name) 
    @name = name 
  end 
end 
 
class Cricket 
  include Action 
  attr_reader :name 
  def initialize(name) 
    @name = name 
  end 
end 
 
peter = Rabbit.new("Peter") 
jiminy = Cricket.new("Jiminy") 
 
peter.jump 
jiminy.jump 
``` 
No código acima, observe que adicionamos o método *jump* às classes *Rabbit* e *Cricket*, usando o módulo *Action*. 
 
Enquanto que **include** adiciona métodos do módulo para as instâncias da classe, **extend** adiciona métodos do módulo para a classe. 
```ruby 
module ThePresent 
  def now 
    puts "It's #{Time.new.hour > 12 ? Time.new.hour - 12 : Time.new.hour}:#{Time.new.min} #{Time.new.hour > 12 ? 'PM' : 'AM'} (GMT)." 
  end 
end 
 
class TheHereAnd 
  extend ThePresent 
end 
 
TheHereAnd.now 
``` 
Também é possível ter classes dentro de módulos, assim como módulos dentro de módulos ou classes dentro de classes. Pode parecer uma bagunça, mas isso é importante em projetos complexos. 


