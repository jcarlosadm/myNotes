**Notas tutorial LUA**


*Site:* [lua-users wiki](http://lua-users.org/wiki/TutorialDirectory)

**Sumário:**

[TOC]

#**Lua Types**

Os comentários em lua são feitos com dois sinais de menos `--`. Em lua, `print()` é usado para imprimir algo.

##Numbers
Os números em lua são números reais, não inteiros.

Alguns exemplos:

```lua
print(2+2)
print(2-7)
print(7*8)
print(7/8)

x=7
print(x)

x = x*9
print(x)

print(x*2)

print(x)
```

##Boolean

Lua possui variáveis booleanas, que aceita os valores `true` e `false`. Os operadores de comparação de lua são `==` e `~=`.

```lua
x = true
print(x)

print(not x)

print(not false)

print("....")

print(1 == 0)
print(1==1)

print(1~=0)
print(true~=false)
```

##Strings

Use aspas simples ou duplas para delimitar strings. O operador `..` serve para concatenar string (não se usa o operador `+` como em outras linguagens).

```lua
print("hello")

who = "lua user"
print (who)

print(".....")
print("hello ")
print("hello " .. who)
print(who)
print(".....")
```

##Tables

Lua possui uma proposta geral de tipos de dados agregados denominada **table**. Tipos de dados agregados guardam coleções (como listas, conjuntos, arrays e arrays associativos). Lua usa table para representar todos esses tipos de dados.

Tables são criadas com chaves `{}`

```lua
-- exemplo de uma table vazia
x = {}
print(x)
```

Mais adiante haverá um tutorial sobre tables.

##Functions

Em lua, funções são guardadas em variáveis, e usam a palavra reservada function.

```lua
foo = function() print("hello") end -- declara a função
foo() -- usa a função
```

As funções, assim como tables, possuem um identificador único.

```lua
print(foo) -- imprime o identificador da função foo
```

Outro exemplo de função:

```lua
c = function()
    print("\n\thello")
end
```

##nil

**nil** é um valor especial em lua que quer dizer falta de um um valor útil (algo com *NULL* em **C**).

```lua
print(x) -- nil, pois x ainda não foi definido
```

##Dynamic and Querying Type

```lua
-- Dynamic typing
a = 1
print(a)
a = "hello"
print(a)

-- Querying type
x = "123"
print(x,type(x))
x = x+7
print(x,type(x))
```

#**Assignment Tutorial**

##Assignment values

Configurar o valor de uma variável é chamado de *atribuição*:

```lua
x = 1
y = "hello"
print(x,y)
```

##Multiple assignment

Em lua, podemos executar múltiplas atribuições em uma simples linha:

```lua
x, y = 2, "there"
print(x,y)
```

Os valores à direita do sinal de igualdade podem ser expressões, como `i+2`. Mas não é possível fazer os valores à esquerda do sinal de igualdade.

##Resoluções ocorrem antes da atribuição

Qualquer expressão é resolvida primeiro. As expressões resolvidas são então atribuídas.

```lua
i = 7
i, x = i+1, i
print(i,x) -- imprime 8  7
```

##Swapping values

