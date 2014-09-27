Uma série de comandos e dicas para linux:

[TOC]

#**Atalhos comuns**

Abrir terminal:
>ctrl + alt + t

Menu iniciar:
>alt + f2

Abrir aba:
>ctrl + t

Fechar aba:
>ctrl + w

#**Conversão de vídeo**

Converter de ogv para avi:
```
mencoder -idx teste.ogv -ovc lavc -oac mp3lame -o teste.avi
```

#**Comandos de terminal**

##Entrar/sair de um diretório

```
cd caminho
```

Usar `~/` representa a sua pasta de usuário. E `../` volta uma pasta. use a tecla *tab* para autocompletar o nome de um diretório ou arquivo.

##Saber o conteúdo de um diretório

```
ls
```

Você pode adicionar a opção `-a` para listar os arquivos ocultos.

A opção `-l` lista as permissões. O primeiro caractere `-` significa que é um arquivo, e `d` um diretório. Depois temos três conjuntos de três caracteres, que são `rwx`, e o que aparecer é a permissão para o grupo especificado. Por exemplo, `r-x` no primeiro conjunto é leitura e execução para o usuário.

##Para criar um arquivo

```
touch nomedoarquivo
```

##Para criar um diretório

```
mkdir nomedodiretorio
```

##Para copiar um arquivo

```
cp nomedoarquivo destino
```

Opções: `-l` cria um link, `-L` cria um link simbólico, `-n` não permite reescrita do arquivo no destino.

Você ainda pode usar `-R` para copiar recursivamente (todo o conteúdo de um diretório), e `-p` para manter os atributos dos arquivos e pastas do diretório (data de modificação, de criação etc), ótimo para fazer backup do Dropbox, por exemplo.

##Para criar um link simbólico

```
ln -s origem destino
```

##Para remover um arquivo

```
rm nomedoarquivo
```

Remover diretório não vazio:
```
rm -rf mydir
```

Remover diretório vazio:
```
rmdir mydir
```

Para mover um arquivo para a lixeira (`rm` remove totalmente), primeiro instale o `trash-cli`, e use:

```
trash-put arquivo
```

>Atenção: tenha cuidado com o comando `rm`. ele deleta os arquivos totalmente, então tenha certeza do que está fazendo.

##Para mover um arquivo

```
mv fonte destino
```

Antes da fonte, é possível definir algumas opções, como `-f` que força reescrever arquivos de destino com o mesmo nome, `-i` pergunta se deverá reescrever arquivos do destino e `-n` para não sobrescrever o arquivo no destino.

##Para mostrar o conteúdo de um arquivo

```
cat arquivo
```

Claro, você pode usar o `vim` com o mesmo propósito, e em geral é até melhor que usar o comando `cat`.

Para copiar o conteúdo de um arquivo para outro arquivo:
```
cat arquivo1 > arquivo2
```

Para mostrar o conteúdo de diversos arquivos em sequência:
```
cat arq1 arq2
```

Para concatenar diversos arquivos e pôr tudo em um arquivo:
```
cat arq1 arq2 > arq3
```

##Para renomear um arquivo

```
rename nome1 nome2
```

Você pode usar aspas duplas para renomear arquivos com caracteres de espaços entre as palavras, mas não crie arquivos fontes assim se estiver programando. Renomear diretórios é similar a renomear arquivos.

#**Permissões de arquivo**

Para declarar permissões de arquivos, você usa o comando `chmod`, seguido de três digitos. Cada um desses dígitos pode ser de 0 a 7, que define a permissão para o usuário(primeiro dígito), grupo (segundo dígito) e outros (terceiro dígito).

Valor Decimal|Valor Binário|Permissões
---|---|---
0|000|Nenhuma
1|001|execução
2|010|gravação
3|011|gravação e execução
4|100|leitura
5|101|leitura e execução
6|110|leitura e gravação
7|111|leitura, gravação e execução

Podemos lembrar essas permissões pelo valor binário: leitura para o primeiro binário (da esquerda para a direita), gravação para o segundo e execução para o terceiro.

Você pode adicionar ainda `-R` para que essas permissões possam ser aplicadas a subpastas.
