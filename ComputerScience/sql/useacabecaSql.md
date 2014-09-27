Anotações sobre o livro Use a cabeça SQL

[TOC]

#**1 - Dados e tabelas**

Uma **tabela** é um arranjo de **linhas** e **colunas**, onde as **colunas** são as categorias e as **linhas** são os dados de cada unidade (pessoa, objeto etc). Cada **coluna**, ou **campo**, possui um tipo. Cada **linha** representa um **registro**.

Um **banco de dados** é um local que guarda tabelas e outras estruturas relacionadas a essas tabelas. Todas as tabelas em um banco de dados precisam estar interligadas de alguma forma.

Para criar uma base de dados, abra o console mysql e digite (o uso de maiúscula é uma boa prática, não uma obrigatoriedade):

```sql
CREATE DATABASE myDataBase;
```

E você pode mostrar a lista de base de dados com:

```sql
SHOW databases;
```

>Uma observação cabe aqui: você precisa ter o mysql instalado. Ok, você pode fazer isso com o pacote do XAMPP ou instalar separadamente. Seja como for, execute o mysql com as opções `-u root -p` e digite a senha do *root* (apenas tecle ENTER se não configurou).

Para começar a usar um banco de dados existente, é necessário usar o comando `USE`:

```sql
USE myDataBase;
```

##Criando uma tabela

Para criar uma tabela em uma base de dados, usamos o comando `CREATE TABLE`:

```sql
CREATE TABLE myTable
(
    nome VARCHAR(10),
    tipo VARCHAR(6)
);
```

`VARCHAR` é o tipo, neste caso *string*. Para uma data usamos `DATE`, para valores decimais usamos `DEC`, para valores inteiros usamos `INT`, e assim por diante. É preciso checar a sua versão do sql para ver quais nomes são utilizados.

Para descrever uma tabela em um banco de dados, use o comando `DESC`:

```sql
DESC myTable;
```

##Recriando tabelas

O comando `DROP` permite deletar algo, seja uma base de dados ou tabela. Por exemplo, para deletar uma base de dados faça:

```sql
DROP DATABASE myDataBase;
```

O seguinte comando deleta uma tabela:

```sql
DROP TABLE myTable;
```

>Atenção: isso apagará o banco/tabela, assim como todos os dados! Tenha cuidado!

>O comando `SOURCE` poderá executar um script sql com todos os comandos que ele tiver:

```sql
SOURCE /home/user/Desktop/test.sql;
```

Assim, depois de excluir uma tabela, você pode recriá-la usando o comando `CREATE TABLE`. Mais adiante aprenderemos como adicionar campos sem precisar deletar toda a tabela.

##Inserindo valores em uma tabela

O comando `INSERT` permite inserir valores em uma tabela. Vejamos um exemplo de uso:

```sql
INSERT INTO myTable(colunn1, colunn2)
    VALUES('value1','value2');
```

Se houvesse um campo numérico, o valor desse campo não poderia ter aspas.

Ao inserir valores, você pode omitir as colunas na declaração, mas os valores precisam estar na mesma ordem como no banco de dados. Ou então você pode alterar a ordem das colunas ou até omitir algumas, mas os valores precisam corresponder a ordem e as colunas que você declarou.

Para ver o conteúdo de uma tabela, use `SELECT`:

```sql
SELECT * FROM myTable;
```

Os campos que não foram preenchidos recebem *NULL*. Para prevenir campos que devem ser preenchidos, use `NOT NULL` no momento de criação da tabela.

```sql
CREATE TABLE meus_contatos
(
    sobrenome VARCHAR(30) NOT NULL,
    primeiro_nome VARCHAR(20) NOT NULL,
    email VARCHAR(50),
    sexo CHAR(1),
    aniversario DATE,
    profissao VARCHAR(50),
    estado_civil VARCHAR(20),
    interesses VARCHAR(100),
    procura VARCHAR(100)
);
```

Você pode definir um valor padrão para um campo com o comando `DEFAULT`. Esse campo será preenchido com esse valor se não for definido um:

```sql
CREATE TABLE meus_contatos
(
    sobrenome VARCHAR(30) NOT NULL DEFAULT 'nobody',
    primeiro_nome VARCHAR(20) NOT NULL DEFAULT 'nobody',
    email VARCHAR(50),
    sexo CHAR(1),
    aniversario DATE,
    profissao VARCHAR(50),
    estado_civil VARCHAR(20),
    interesses VARCHAR(100),
    procura VARCHAR(100)
);
```

#**2 - O comando SELECT**


