(Notas do livro **Ruby on Rails - coloque sua aplicação web nos trilhos**, da casa do código)
*Obs: de maneira alguma essas notas substituem o livro. Aqui apenas anoto passagens que me ajudem a lembrar rapidamente alguns conceitos. Em geral, essas notas só fazem sentido em conjunto com o livro.*

[TOC]

#**Capítulo 2 -  Conhecendo Ruby**

**Query methods** - métodos terminados em ***?***. Em geral são usados em métodos de retorno *true* ou *false*. Exemplo para saber se o objeto *shopping_cart* responde ao método *clear*:
```ruby
shopping_cart.respond_to? 'clear' # true
```
##2.3 Tipos e Estruturas de Dados
###Strings
Tudo em ruby é objeto. Por exemplo, podemos fazer:
```ruby
"example".upcase # EXAMPLE
```
Sendo que *upcase* é um método de um objeto da classe *String*.

A concatenação é feita com o sinal de soma **+**:
```ruby
"Como"+" vai?" # Como vai?
```

Usar o sinal de multiplicação em string irá fazer com que a string se repita:
```ruby
"ha "*3 # ha ha ha
```
O sinal **<<** irá anexar Strings:
```ruby
name = "Pedro"
name << " Andre"
puts name # Pedro Andre
```
###Interpolação de Strings
Uso de variáveis (a String deve vir com aspas duplas):
```ruby
name = "Silver"
"O seu nome é #{name}." # O seu nome é Silver.
```
Se houver uma expressão na interpolação, essa expressão será avaliada apenas uma vez, mesmo que a string se repita:
```ruby
a = 1
"#{a = a + 2} " * 2 # 3 3
```
Interpolação com **%**:
```ruby
"Valor: R$ %.2f" % 90 # Valor: R$ 90.00
```
###Inteiros e Floats
Conversão de inteiro para *float* e vice-e-versa:
```ruby
100.0.to_i # 100
100.to_f # 100.0
```
A divisão entre inteiros retorna um inteiro. Para retornar um *float*, devemos converter um deles para *float*:
```ruby
100.to_f/3 # 33.333333...336
```
> *Observação: não use float para valores financeiros, pois há perda na conversão desses valores de decimal para binário. O melhor é usar BigDecimal.*

###Constantes
Ruby trata como constante toda variável que começa com a primeira letra maiúscula. Porém, o ideal é usar todas as letras maiúsculas uma vez que usa-se o padrão *CamelCase* para classes.

Apesar do nome, constantes podem ser alteradas (o interpretador emitirá um alerta neste caso).

###Arrays
Podemos fazer soma e subtração de conjuntos:
```ruby
a=[1,3,2]
b=[5,1,2]
a + b # [1,3,2,5,1,2]
a - b # [3]
b - a # [5]
```
Também podemos fazer união e intersecção:
```ruby
a | b # [1,3,2,5]
a & b # [1,2]
```
Consulte o livro para revisar diversos métodos bastante usados em *arrays*.

>*Muitos dos métodos de arrays retornam o array modificado ao invés de modificar a própria variável. Se o método possuir uma versão "BANG!", então é possível modificar a própria variável com o uso de ! no final do nome do método.*

>*Métodos "BANG!" modificam o estado interno de um objeto ou disparam uma exceção em caso de falha.*

###Hashes
