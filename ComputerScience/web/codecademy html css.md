Tutorial de html e css do codecademy

[TOC]

------------------------------------------------------------------------
#**Básico**

*HTML* é uma linguagem de marcação. Sua função não é criar algoritmos, e sim uma estrutura. Nela, você diz onde fica cada elemento, e suas propriedades. Antigamente, essa linguagem também era responsável pelo visual da página. Hoje temos outra linguagem chamada *CSS* que se encarrega do visual da página, deixando para o *HTML* a tarefa de estruturação. 
 
O HTML usa o sinal de menor e de maior (**<** e **>**) para definir os elementos e suas propriedades. Algo que começa com o sinal de menor e termina com o sinal de maior é chamado de *tag*. 
 
O topo de um documento *HTML* tem uma definição básica, o **doctype**. Nela, você informa que o documento é do tipo HTML: 
```html 
<!DOCTYPE html> 
``` 
Todo o *HTML* (Exceto o **doctype**) deve estar entre as tags `<html>` e `</html>`. A primeira é uma tag de abertura e a segunda é uma tag de fechamento. 
```html 
<html> 
</html> 
``` 
Aliás, quase tudo em html tem uma tag de abertura e uma de fechamento. Algumas tags são simples, que se fecham em si mesmas, mas a maioria são compostas de tags duplas. E você pode aninhar uma tag em outra. 
 
Um documento *HTML* tem dois elementos principais: **HEAD** e **BODY**. No elemento **HEAD**, podemos definir o título do site, que ficará no topo da página. No elemento **BODY**, temos todo o conteúdo da página. 
```html 
<!DOCTYPE html> 
<html> 
    <head> 
        <title>Olá mundo</title> 
    </head> 
    <body> 
        Olá mundo! 
    </body> 
</html> 
``` 
Existe um elemento do **BODY** que se chama parágrafo. Mesmo que se possa escrever um parágrafo sem esse elemento, é sempre uma boa ideia usa-lo, pois formatações futuras no parágrafo podem ser necessárias. 
```html 
<p>Esse é um parágrafo</p> 
``` 
Outro elemento de **BODY** para títulos é o `<hx>`, onde *x* é um valor de 1 a 6. O título maior é o `<h1>` e o menor é o `<h6>`. 
```html 
<h1> Esse é um título.</h1> 
```

-----------------------------------------------------------------------------
#**Imagens e links**

A *tag* de imagem é essa: `<img src="" />`. Observe que a *tag* é simples, não possuindo *tag* de fechamento. Esse tipo tem uma barra no final, indicando o fechamento em si mesma. Na *tag* de imagem, o atributo **src** indica o link da imagem, que pode ser local (no seu computador ou no servidor onde se encontra o site) ou em rede (na internet). 
```html 
<img src="http://s3.amazonaws.com/codecademy-blog/assets/f3a16fb6.jpg" /> 
``` 
A *tag* de link é essa:`<a href=""> </a>`. Veja que a *tag* de link possui uma *tag* de fechamento. Você deverá colocar algo entre elas, o que pode ser um texto ou até mesmo uma imagem. O atributo **href** é um link de referência. 
```html 
<a href="http://s3.amazonaws.com/codecademy-blog/assets/f3a16fb6.jpg"> 
    <img src="http://s3.amazonaws.com/codecademy-blog/assets/f3a16fb6.jpg" /> 
</a> 
```
----------------------------------------------------------------------------
#**Listas**

##Listas ordenadas 
 
Você faz uma lista ordenada com a tag `<ol>`. Cada item deve ser envolvido em uma tag `<li>`.
```html 
<ol> 
	<li>Primeiro item</li> 
	<li>Segundo item</li> 
</ol> 
``` 
##Listas não ordenadas 
 
Uma lista não ordenada usa a tag `<ul>`. Cada item deve estar envolvido em uma tag `<li>`.
```html 
<ul> 
	<li>Primeiro item</li> 
	<li>Segundo item</li> 
</ul> 
``` 
##Listas dentro de listas 
 
Você pode criar uma lista dentro de outra lista, dependendo da necessidade. 

-------------------------------------------------------------------------
#**Comentários**

Você pode fazer um comentário em *HTML* com a tag de abertura `<!--` e a tag de fechamento `-->`: 
```html 
<!-- Esse é um comentário 
De mais de uma linha --> 
```
-------------------------------------------------------------------------
#**Estilos em HTML**

Todos os atributos abaixo são para *CSS*. Porém, você pode usar diretamente no código *HTML* em um atributo **style** de uma *tag*. 
 
##font-size 
 
Tamanho da fonte, em *pixels*. 
```html 
<p style="font-size:12px;">Esse é um parágrafo</p> 
``` 
##color 
 
Cor da fonte, através de nomes chaves. 
```html 
<p style="color:red;">Esse é um parágrafo</p> 
``` 
##font-family 
 
Tipo de fonte, através do nome da fonte. 
```html 
<p style="font-family:Arial;">Esse é um parágrafo</p> 
``` 
##background-color 
 
Cor de fundo, através dos nomes chaves. 
```html 
<p style="background-color:black;">Esse é um parágrafo</p> 
``` 
##text-align 
 
Alinhamento do texto. Pode ter três valores: *left* (esquerda), *center* (centro) e *right* (direita). 
```html 
<p style="text-align:center;">Esse é um parágrafo</p> 
```

-----------------------------------------------------------------
#**Texto**

Essas são tags que você pode usar para destacar um texto. 
```html 
<strong> 
``` 
O texto fica em negrito. 
```html 
<em> 
``` 
Enfatiza o texto, o colocando em itálico. 

------------------------------------------------------------------
#**Tabelas**

Uma tabela pode ser criada com a *tag* `<table>` (ela possui uma *tag* de fechamento `</table>`). 
 
Você pode criar linhas na tabela com *tag* `<tr>`. Esse pedaço de código quer dizer "*table row*". 
 
A cada linha você deve adicionar uma ou mais células com a *tag* `<td>`, que quer dizer "*table data*". Sem adicionar essa *tag*, as linhas não serão mostradas. Além disso, a tabela criada se ajustará ao conteúdo. 
 
A cada nova *tag* `<td>` na mesma linha, você cria uma nova coluna. Você pode ver que não criamos colunas diretamente, e sim pela criação de células. 
 
As *tags* `<thead>` e `<tbody>` podem estruturar melhor a sua tabela. Em `<thead>` você coloca a linha de cabeçalho, e em `<tbody>` você coloca toda a tabela (exceto a *tag* `<table>` e `<thead>`). Em `<thead>`, cada dado usa a *tag* `<th>` ao invés de `<td>`. 
 
Você pode "juntar" duas ou mais colunas com o atributo **colspan**. É só definir o número de colunas que serão mescladas. O atributo **rowspan** faz o mesmo, só que com colunas. 
 
Você pode controlar a espessura da borda da tabela com o atributo **border**. A espessura é medida em *pixels*. 

-------------------------------------------------------------------
#**Div e Span**

A *tag* `<div>`, que é uma abreviação de *division*, divide a página em pequenas peças para que você possa manipulá-las como bem entender. Isso é bastante útil para manipular o estilo da página com *CSS*. 
 
A *tag* `<div>` é muito usada para criar menus e diversas áreas em sites. 
 
A *tag* `<span>` serve a um propósito parecido, pois ela divide o códigos em pedaços ainda menores, como parte de um texto. 

-------------------------------------------------------------------
#**CSS**

*CSS* quer dizer *Cascating Style Sheet*.
 
Enquanto usamos o *HTML* para marcação e estrutura, o *CSS* é usado para estilo. As regras de *CSS* possui sua própria sintaxe, e podem ser definidas entre as *tags* `<style>` e `</style>`, ou simplesmente com uma *tag* simples de `<link>`. 
 
A *tag* `<link>` deve ser definida na *tag* `<head>`. Com ela, podemos indicar um arquivo que contenha todas as regras *CSS*. Por exemplo: 
```html 
<link type="text/css" rel="stylesheet" href="stylesheet.css" /> 
``` 
Podemos ver acima uma indicação que o arquivo com as regras *CSS* possui a extensão **.css** no final ("*stylesheet.css*"). 

##Sintaxe Básica

A sintaxe do *CSS* é fácil de aprender. Basicamente, é isso: 
```css 
Seletor{ 
	Propriedade: valor; 
} 
``` 
O seletor pode ser qualquer elemento *HTML*. Isso afetará todos os elementos daquele tipo. Por exemplo: 
```css 
p{ 
	color: red; 
} 
``` 
A regra anterior faz todos os parágrafos do código *HTML* ficarem vermelhos. 
 
A propriedade é um aspecto de um seletor. No exemplo anterior, alteramos a cor, mas poderia ser o estilo da fonte (**font-family**). Você pode estabelecer quaisquer quantidades de propriedades para um mesmo seletor. 
 
O valor é a definição da propriedade. No exemplo anterior, o valor da cor foi vermelho ("*red*"). Sempre coloque um ponto e vírgula após cada valor de cada propriedade definida. 
 
Você também pode definir propriedades de mais de um seletor. Se um seletor for afetado mais de uma vez, a última regra de um mesmo tipo será a regra válida. Por exemplo: 
```css 
body{ 
	color: red; 
	font-size: 24px; 
} 

p{ 
	color: blue; 
} 
``` 
Veja que o seletor *body* engloba tudo no código *HTML*, inclusive *p*. Logo, *p* deverá ser vermelho pela regra de *body*. Porém, redefinimos a regra da cor de *p* para azul depois. A última regra sempre é a válida. O tamanho da fonte de *p* é herdado de *body*, ou seja, 24 *pixels*. 

##Comentários

Em *CSS*, os comentários começam com **/\*** e terminam com **\*/**, sempre. Por exemplo:
```css 
/* Eu sou um comentário */ 
```
##Propriedades

- **color**: muda a cor da fonte. 
 
- **font-family**: muda o tipo da fonte. 
 
- **background-color**: muda a cor de fundo. 
 
- **font-size**: muda o tamanho da fonte. 

##Cores

Você pode definir cores por meio de palavras chaves, mas não existem muitas. Se você quiser uma cor diferente, terá de procurar outros meios. 
 
Um modo de definir cores é por meio de um valor hexadecimal. Nosso código decimal é de base 10, e o código hexadecimal é de base 16. Cada dígito pode ter um valor de 0 (zero) até *f* (*a*=10;*b*=11;*c*=12;*d*=13;*e*=14;*f*=15). 
 
Você pode obter o valor hexadecimal de uma cor por meio um aplicativo online. Basta pesquisar por "*hex color pallete*" ou "*hex color picker*". 
 
Um valor hexadecimal é definido quando começa com **#**, que quer dizer "dígitos". 

##Tamanho da fonte

Você pode definir o tamanho da fonte em *pixels* (por exemplo, *10px*). 
 
Existe outra unidade de medida denominada *em*. É uma medida relativa, e é igual a medida padrão do corpo do código *HTML*. Se você desejar, por exemplo, que as *tags* `<h1>` tenham *150%* do tamanho da fonte padrão, use *1.5em* no tamanho da fonte. Sempre é recomendado que se use *em* no lugar *px*, pois *px* não são redimensionáveis, ao contrário de *em*. 

##Fontes

Saber quais fontes usar é muito importante. Nem sempre as fontes estarão instaladas nos computadores dos usuários. O *CSS* possui três fontes padrão, e você pode definí-las para garantir que alguma fonte seja usada: 
 
- **serif**: elegante. 
- **sans-serif**: clara. 
- **cursive**: decorada. 
 
Sim, você pode definir mais de uma fonte. Isso irá aumentar as chances de que pelo menos uma seja usada. Se a primeira fonte puder ser usada, ela o será; se não, passa para a próxima, e assim por diante. Sempre é bom deixar as fontes padrão por último, para garantir que uma fonte seja usada. 


