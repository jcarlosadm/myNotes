O gdb é uma ferramenta de linha de comando simples que pode ser usada para debugar código em c/c++.

Em primeiro lugar compile o seu programa com a flag `-g`:

```
gcc -g test.c
```

Vai ser gerado um arquivo `a.out` que guardará informações de debug. Depois basta executar com:

```
gdb a.out
```

Antes de executar um programa, é útil definir um *breakpoint*, que é onde o programa irá parar sua execução, permitindo que você analise melhor o que está acontecendo. Você adiciona *breakpoints* em funções. Abaixo temos um exemplo de um breakpoint em main:

```
b main
```

Também é possível definir um *breakpoint* em uma linha. Basta digitar `b 5` para criar um na linha 5, por exemplo.

Após definir os *breakpoints*, você pode rodar o programa:

```
run
```

Ou pode usar `r` no lugar de `run`.

Após rodar com o comando acima, o programa irá parar no próximo *breakpoint*. A partir deste ponto, uma série de comandos podem ser usados:

- s: próxima linha. Entra em funções se encontrar alguma.
- n: próxima linha. Não entra em funções se encontrar alguma.
- p v: onde v é um nome de variável, imprime valor da variável.
- c: continua até o próximo *breakpoint*.

Após a execução, para sair do gdb digite:

```
quit
```

Uma série de comandos do gdb: http://www.yolinux.com/TUTORIALS/GDB-Commands.html










