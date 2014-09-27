**notas da apostila da [Caelum](http://www.caelum.com.br/apostila-html-css-javascript)**


[TOC]

--------------------------------------------------------
#Capítulo 3 - HTML semântico e posicionamento no css

##3.1 - O processo de desenvolvimento de uma tela

1. Detectar necessidade, conhecer público-alvo;
2. Levantar e organizar informações de características humanas do projeto;
3. Aplicar conceitos de **Design de interação**, **Experiência do usuário** e **Usabilidade**;
    - Gerar ***wireframes*** (esboço das páginas).
4. Gerar ***layouts***(cada *wireframe* tratado graficamente);
5. Programação *front-end*;

##3.3 - Analisando o layout

O HTML5 trouxe consigo algumas tags novas. Podemos usar a tag `<header>` para marcar o cabeçalho da página, a `<section>` para marcar uma seção (como a parte central da página) e a tag `<footer>` para marcar o rodapé.

##3.8 - CSS Reset

Cada navegador tem uma série de estilos padrão. Isso pode causar certa confusão na hora de testar um projeto em diferentes navegadores, causando resultados inesperados. Por isso, alguns desenvolvedores usam um estilo chamado **css reset**.

Existem diversos códigos prontos para se fazer isso:

- HTML Boilerplate
- YUI3 CSS Reset
- Eric Meyer CSS Reset

##3.11 - Position

- **static**: posição padrão. Não aceita posicionamento manual (left, right, top, bottom). O tamanho do elemento pai leva em conta o tamanho do elemento static.
- **relative**: em geral, renderizado da mesma maneira que **static**. Aceita posicionamento manual. O tamanho do elemento pai leva em conta o tamanho do elemento relative, mas sem levar em conta o seu posicionamento.
- **fixed**: é obrigatorio definir o posicionamento (left/right e top/bottom). O elemento será renderizado na página na posição indicada, mesmo com rolagem. O tamanho do elemento pai não se altera (como se não fosse elemento pai).
- **absolute**: é obrigatório definir o posicionamento. Elemento renderizado em relação ao primeiro pai com *position* diferente de **static**. O seu tamanho não conta para definir o tamanho do elemento pai.

#Capítulo 4 - Mais HTML e CSS

##4.2 - Formulários

O elemento `<form>` cria formulários, e pode conter diversos `<input>`'s, ou entradas, de diversos tipos.

Um tipo de **input** é **search**, que captura dados digitados, e outro é **image**, que exibe um botão com uma imagem:

```html
<form>
  <input type="search">
  <input type="image" src="img/busca.png" class="lupa">
</form>
```

##4.3 - Posicionamento com *Float* e *Clear*

A propriedade **clear** determina o comportamento de elementos ao seu redor. Recebe *left*, *right* ou *both*.

O que essa propriedade faz é impedir elementos flutuantes a esquerda, direita ou em ambos os lados de um elemento.

##4.5 - Cascata e Herança no CSS

Algumas propriedades de elementos pai, quando alteradas, são definidas automaticamente para os seus elementos filho. São propriedades como **color** e **font-family**.

Existem propriedades em que isso não acontece, como **padding** e **margin**, pois afetam diretamente a caixa do elemento.

##4.6 - inherit

Para propriedades que não são herdadas em cascata, podemos utilizar o valor **inherit** para informar que determinada propriedade herda o valor da mesma propriedade do elemento pai.

##4.8 - Display *inline-block*

Para elementos de bloco, a propriedade **display** possui o valor *block*. Nós podemos mudar essa propriedade no css para *inline*, e o elemento será tratado como elemento de linha, exibindo lado-a-lado.

Ok, mas elementos de linha não possuem **width**, **margin** ou **padding**. O que fazemos então? Usamos o valor *inline-block* para **display**, que faz com que elementos de bloco mantenham as suas propriedades ao mesmo tempo em que possam ficar lado-a-lado como elementos de linha.

##4.10 - Seletores de atributos do CSS3

O CSS3 possui um seletor que verifica a presença de um atributo em um elemento, como por exemplo:
```css
input[value] {
  color: #cc0000;
}
```
o seletor acima irá selecionar todos os elementos **inputs** com o atributo **value**. Verificando se um atributo possui um valor específico:
```css
input[type="text"] {
  border-radius: 4px;
}
```
Existem variações desse seletor com um caractere antes do sinal de igualdade:

- **|**: procura os elementos que possuem o atributo especificado que comecem com a palavra especificada no valor.
- **~**: que possuem a palavra especificada no valor  do atributo.
- **^**: que comecem com a palavra especifica no valor do atributo.
- **$**: que terminem com a palavra especificada no valor do atributo.
- *****: que possuem a palavra especificada no valor do atributo.

##4.12 - Substituição por Imagem

*Image Replacement* é uma técnica de css que visa substituir um elemento de texto por uma imagem.

Segue três passos:

1. Tamanho do elemento fica igual ao da imagem
2. Imagem fica como background do elemento
3. Esconder o texto

##4.15 - Para saber mais: suporte HTML5 no Internet Explorer antigo

Para que navegadores antigos do IE tenham suporte a html5, deve-se incluir o seguinte código no **head**:

```html
<!--[if lt IE 9]>
<script src="dist/html5shiv.js"></script>
<![endif]-->
```

E baixar esse [arquivo](https://github.com/aFarkas/html5shiv/zipball/master).

#Capítulo 5 - JavaScript e interatividade na Web

##5.5 - Interatividade na Web

A função **querySelector** sempre retorna um elemento compatível com o seletor CSS passado; se houver mais de um elemento, retornará o primeiro da lista. A função **querySelectorAll** retornará um array de elementos.

```javascript
var myVar = document.querySelector("#myID");
```

Que produz o mesmo resultado de:

```javascript
var myVar = document.querySelector.getElementById("myID");
```

##5.7 - Funções Temporais

Javascript possui uma função que dispara um código após determinado intervalo de tempo. Essa função recebe o nome de **setTimeout**.

```javascript
setTimeout(minhafuncao, 1000); // executa minhafuncao daqui a 1 segundo
```

Já a função **setInterval** executa um código indefinidamente em determinados intervalos de tempo.

```javascript
setInterval(minhafuncao,1000); // executa minhafuncao a cada 1 segundo
```

Você pode finalizar a função **setInterval** com a função **clearInterval**:

```javascript
var interval = setInterval(minhafuncao,1000); // cria a repetição
clearInterval(interval); // finaliza a repetição
```

##5.10 - Para saber mais: vários callbacks no mesmo elemento

É sempre mais recomendado usar **addEventlistener** para adicionar funções a eventos, pois cada evento de cada elemento só pode ter uma função.

```javascript
document.querySelector('#destaque').addEventListener('click', function() {
  // tratamento do evento
});
```

Para os IEs velhos:

```javascript
document.querySelector('#destaque').attachEvent('onclick', function() {
  // tratamento do evento
});
```

#capítulo 6 - CSS Avançado

##6.1 - Seletores Avançados

###Seletor de irmãos

O seletor *sibling* (**~**) seleciona os irmãos posteiores a um elemento.

```html
<article>
  <h1>Título</h1>
  <p>Início</p>

  <h2>Subtítulo</h2>
  <p>Texto</p>
  <p>Mais texto</p>
</article>
```

```css
h2 ~ p{
  font-style: italic;
}
```

O que o código anterior faz é selecionar todos os parágrafos irmãos de h2, posteiores a ele.

###Seletor de irmãos adjacentes

Para selecionar um elemento irmão imediatamente após um elemento, usamos o seletor *adjacent sibling* (**+**).

###Seletor de filho direto

Para selecionar um filho direto de um elemento, usamos o seletor de filho direto (**>**).

###Negação

Para selecionar vários elementos exceto um em especial, usa-se o seletor de negação (**:not()**).

```css
p:not(.especial){ /* seleciona todos os parágrafos exceto o com a classe "especial" */
  color: gray; /* cor cinza */
}
```

##6.2 - Pseudo-classes

As pseudo-classes **first-child** e **last-child** permitem selecionar o primeiro e o último elemento de uma série, respectivamente.

Você ainda pode usar **nth-child()** para selecionar enésimo elemento (se passar 3, por exemplo, será selecionado o 3º elemento). Se o valor entre parênteses for **2n**, serão selecionados números pares (da mesma forma que **2n + 1** selecionará os elementos ímpares).

###Pseudo classes de estado

*CSS* possui pseudo-classes que representam estados dos elementos, como por exemplo a **:hover**, que representa o momento em que o usuário passa o mouse em cima do elemento.

```css
a:hover {
    background-color:#FF00FF;
}

```

A **:hover** pode ser usado em qualquer elemento, mas os links possuem ainda outras pseudo classes:

- **:link** representa links ainda não visitados.
- **:visited** representa links já visitados.
- **:active** representa o link no momento em que clicamos nele.

##6.3 - Pseudo Elementos

O pseudo elemento **:first-letter** seleciona a primeira letra de um elemento de texto. O pseudo elemento **:first-line** seleciona a primeira linha.

###Novos conteúdos

Algumas vezes, por motivos estéticos, talvez você queira adiciona caracteres na página. Não se trata de informação de fato, então não devemos colocar isso no html. O *CSS* também tem uma solção para isso.

Por exemplo, digamos que você queira adicionar caracteres antes e depois de um elemento. O *CSS* possui os pseudo elementos **:after** e **:before**, que permitem adicionar tais conteúdos.

```css
a:before {
    content: '[ ';
}
a:after {
    content: ' ]';
}

```

##6.6 - CSS3: Border Radius

O *CSS3* trouxe uma novidade há muito aguardada: bordas arredondadas. Basta usar a propriedade **border-radius** igual ao tamanho da borda em *pixels*.

```css
div{
    border-radius : 5px;
}
```

Você pode definir configurações diferentes para cada canto da borda. Os padrões são os mesmos que **padding** ou **border**, mas começando pelo canto superior esquerdo e terminando pelo canto inferior esquerdo.

Observação: com um certo nível de arredondamento, é possível gerar outras formas, como triângulos e círculos.

##6.7 - CSS3: Text Shadow.

Com a propriedade **text-shadow**, um texto recebe uma sombra. Recebe de dois a quatro valores (os dois últimos opcionais): deslocamento da sombra para a direita, deslocamento para baixo, raio para efeito blur e cor da sombra. Os valores de 1 a 3 podem ser em *pixels*.

Também é possível passar mais de uma sombra ao mesmo tempo, separando cada conjunto de valores por meio da vírgula:

```css
text-shadow: 10px 10px 5px red, -5px -5px 4px red;

```

##6.8 - CSS3: Box Shadow

A propriedade **box-shadow** insere uma sombra em qualquer elemento. Você deve passar o deslocamento para a direita e para baixo. Outros valores são opcionais: raio para efeito blur (em *pixels*), extender tamanho da sombra (em *pixels*), cor, e *inset* (esse valor fará a sombra ser representada dentro do elemento).

##6.9 - Opacidade e RGBA

A propriedade **opacity** permite alterar a opacidade de um elemento, ou seja, quanto maior o valor dessa propriedade, mais "*sólido*" ele parecerá. Essa propriedade recebe um valor entre 0 e 1.

O *CSS3* possibilita definir o canal *alpha*, ou *transparência* de uma cor. Ao invés de definir uma cor por meio de **rgb()**, podemos definir por meio de **rgba()** e usar um quarto valor para o canal *alpha*:

```css
p{
    background: rgba(0,0,0,0.3); // fundo preto com 30% de opacidade
    color: white; // o parágrafo terá cor branca não opaca!
}
```

##6.10 - Prefixos

Muitas propriedades são provisórias e ainda não foram incluídas na versão final. Por isso, muitas vezes é interessante incluir um prefixo antes de uma propriedade, informando o navegador em que aquela propriedade é usada. Temos os seguintes prefixos:

- **-webkit-**: navegadores Webkit (Chrome, Safari, iOS, Android)
- **-moz-**: Firefox (Mozilla)
- **-ms-**: Internet Explorer (Microsoft)
- **-o-**: Opera

Para um máximo de compatibilidade, devemos usar diversos prefixos ao mesmo tempo:

```css
p {
    /* Chrome até versão 3, Safari até versão 4 */
    -webkit-border-radius: 5px;
    /* Firefox até 3.6 */
    -moz-border-radius: 5px;
    /* Todas as versões modernas dos navegadores,
    incluindo IE e Opera que nunca precisaram de
    prefixo pra isso */
    border-radius: 5px;
}
```

É preciso consultar a documentação para verificar quando usar os prefixos em cada caso.

##6.11 - CSS3: Gradientes

O *CSS3* também permite trabalhar com gradientes. Você pode usar gradientes radiais e lineares, com angulações diferentes e múltiplas paradas:

```css
.linear {
  background: linear-gradient(white, blue);
}

.radial {
  background: radial-gradient(white, blue);
}

.gradiente {
  background: linear-gradient(45deg, #f0f9ff 0%, #cbebff 47%, #a1dbff 100%);
```

###Prefixos

Para ter suporte a browsers antigos, os prefixos são necessários. Além disso, preste atenção na sintaxe, que mudou bastante.

###Gambiarras pro IE antigo

Somente o IE 10 aceita gradientes como o da sintaxe acima. Porém, há uma gambiarra para o IE do 6 ao 9 (não aceita no 10):

```css
.linear {
  filter: progid:DXImageTransform.Microsoft.gradient(
      startColorstr='#FFFFFF', endColorstr='#0000FF',GradientType=0);
}
```

###Geração de gradientes

Para os navegadores mais antigos, deve-se procurar definir um background simples e sólido, para ter um resultado apresentável. Isso não é necessário hoje em dia.

```css
.gradiente {
  background: #cbebff;
  background: linear-gradient(45deg, #f0f9ff 0%, #cbebff 47%, #a1dbff 100%);
}
```

Uma ferramenta útil é o **Ultimate CSS Gradient Generator** da ColorZilla, que implementa todos os hacks e prefixos automaticamente. A ferramenta pode ser acessada [aqui](http://www.colorzilla.com/gradient-editor/).

##6.12 - Progressive Enhancement

Essa é uma abordagem que procura manter a experiência de navegação para todos, e então melhorar aos poucos essa experiência para os navegadores mais modernos.

Ou seja, para o caso das bordas arredondadas, faça com bordas quadradas, e arredonde usando o *CSS3* para os navegadores mais modernos. Veja mais sobre o assunto [aqui](http://blog.caelum.com.br/css3-e-progressive-enhancement/?utm_source=Apostila_HTML&utm_campaign=WD-43&utm_medium=referral).

##6.14 - CSS3 Trasitions

Com o *CSS3*, podemos realizar animações mudando valores css. Para uma animação gradual, você pode usar **transition**. Por exemplo, o código abaixo desloca um elemento para cima durante 2 segundos quando passamos o mouse em cima:

```css
#teste:hover{
    transition: top 2s;
}
```

Existem alguns tipos de animação:

- **linear** (padrão): valocidade constante.
- **ease**: redução gradual na velocidade de animação.
- **ease-in**: aumento gradual da velocidade.
- **ease-in-out**: aumento gradual, depois redução gradual.
- **cubic-bezier(*x1*,*y1*,*x2*,*y2*)**: curva de velocidade (avançado).

Existe uma ferramenta online para auxiliar na configuração do **cubic-bezier** [aqui](http://www.roblaplaca.com/examples/bezierBuilder/).

Você pode mudar mais de uma propriedade ao mesmo tempo.

```css
#teste {
  position: relative;
  top: 0;
  color: white;
}
#teste:hover {
  top: 30px;
  color: red;
  transition: top 2s, color 1s ease;  
}
```
Ou para todas as propriedades ao mesmo tempo:
```css
#teste {
  position: relative;
  top: 0;
  color: white;
}
#teste:hover {
  top: 30px;
  color: red;
  transition: all 2s ease;
}
```

Ainda em estágio inicial, é necessário usar prefixo ana maioria dos navegadores.

##6.15 - CSS Transforms

Com **transform**, você pode alterar propriedades visuais dos elementos. Coisas como o seu tamanho, localização ou ângulo, por exemplo.

###Translate

Você pode alterar apenas o eixo x com **translateX(*pixels*)**, apenas o eixo y com **translateY(*pixels*)** ou os dois eixos com **translate(*pixelsX*, *pixelsY*)**.

###Rotate

Gira o elemento. Use **rotate(*degrees*)**, onde *degrees* é em graus (10 graus você indica como *10deg*).

###Scale

Para alterar o tamanho da imagem, use **scale**. Aceita um ou dois valores numéricos, com 1 representando a escala normal. Se informar um valor, o objeto será escalado tanto verticalmente como horizontalmente. Se informar dois valores, o primeiro é para a escala vertical e o segundo é para a escala horizontal.

###Skew

Se usar **skewX(*degrees*)** ou **skewY(*degrees*)**, o elemento será inclinado horizontalmente ou verticalmente, respectivamente. Informe graus.

Todas as implementações exigem o uso de prefixo.

#Capítulo 7 - Web para dispositivos móveis

Primeira questão: fazer um site exclusivo para dispositivos móveis, ou adaptar nosso site para funcionar em qualquer dispositivo?

Cada vez mais a ideia da web única (*one web*) está ganhando aceitação. Você pode construir um único site, e usar tecnologias (como *CSS*) para adaptar o site para diferentes plataformas.

##7.2 - CSS Media Types

