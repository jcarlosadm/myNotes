Anotações do livro headfirst html5

[TOC]

--------------------------------------------------------
#**1. Getting to know HTML5**

##Update HTML

Os três elementos que transformam uma página em *HTML5*:

```html
<!doctype html>
<meta charset="utf-8">
<link rel="stylesheet" href="loung.css">
``` 

Como ficou a *tag* **script**:
```html
<script src="loung.js"></script> 
```
ou:
```html
	<script> 
		// Codigo 
	</script>
```

---------------------------------------------------------
#**2. Introducing Javascript and the DOM**

**DOM** - *Modelo de Objetos do Documento* (gerado após carregar a página). 
 
Você pode criar três tipos de variáveis: 
1. String
2. Numérica
3. Booleana (*true* ou *false*)

```javascript
var nome = "José"; 
nome = nome + "Carlos"; 
var numero = 5; 
numero = 99.8; 
numero = Math.random();
var escolheu = true; 
```

Você pode usar laços:
```javascript
	while(countar>0) 
	{ 
		fazerAlgo(); 
		contar=contar-1; 
	} 
``` 
Você pode tomar decisões:
```javascript
	if(escolha) 
	{ 
		fazerAlgo(); 
	} 
	else 
	{ 
		repetirPergunta(); 
	} 
``` 
##Declarando variáveis 
 
Use a palavra reservada **var** para declarar uma variável. Uma variável declarada não possui tipo (*undefined*). O tipo só será definido após a inicializar. 
 
Uma variável pode ainda receber **null**, que significa nenhum valor. 
 
##Sintaxe 
 
Cada comando termina com um ponto e vírgula. 
 
Uma linha de comentário começa com duas barras. 
 
Espaços em branco não são levados em consideração. 
 
Strings usam aspas duplas. 
 
Variáveis são declaradas usando a palavra reservada **var**. 
 
Variáveis booleanas recebem somente valor *true* ou *false*. 
 
As variáveis não necessitam de um valor quando são declaradas. 
 
##Nomeando variáveis 
 
Comece com letra, underline ou símbolo de moeda (**\$**). Depois pode usar qualquer letra, número, underline ou símbolo de moeda (**\$**). Nunca use palavras reservadas. 
 
##Loops 
 
Você pode usar **while** para repetir a execução de um pedaço do código. 
```javascript 
while(count>0) 
{ 
	faça algo; 
} 
``` 
O **for** é outro tipo de loop, que possui uma inicialização (você pode declarar a variável aqui!), uma condição de execução e uma execução a cada final de loop. 
```javascript 
for(int i=0;i<10;i++) 
{ 
	faça algo; 
} 
``` 
Porém, o ideal é declarar a variável em outro lugar, para ter certeza de que irá declarar apenas uma vez. 
 
##Decisões 
 
Use **if** para decidir sobre algo. Se a condição não for satisfeita, você pode usar **else if** para indicar outra condição caso contrário, ou **else** para executar algo caso a condição não seja satisfeita. 
 
##Onde colocar o Javascript 
 
Entre a tag `<script>` e `</script>`. 
 
Se desejar indicar o link para um arquivo javascript externo, é só utilizar o atributo **src** na *tag* `<script>`. 
```html 
<script src="meujavascript.js"></script> 
``` 
##*getElementById()* 
 
Esse método obtém um elemento *html* pelo seu **id**, indicado entre parênteses e entre aspas. É possível pegar esse elemento e colocar em uma variável. 
 
Podemos ainda inserir algo entre *tags* de abertura e fechamento com **innerHTML** (ou pegar algo entre essas *tags*). 
 
##Carregamento da página e Javascript 
 
Antes de executar o Javascript, tenha certeza de que a página já carregou totalmente. Senão os elementos que por ventura forem referenciados, ainda não existirão quando da execução do Javascript. 
 
Podemos fazer isso criando uma função de inicialização (como *function init()*) e chamando um *window.onload = init;* 
```javascript 
function init() 
{ 
	// seu código aqui 
} 
window.onload = init; 
``` 
##Outras coisas que você pode obter do DOM 
 
Você pode obter não apenas um elemento, mas vários deles através de nomes de classes, de *tags* e de atributos. 
 
Você pode adicionar coisas no DOM, assim como pode remover. 
 
E ainda pode configurar os atributos dos elementos de um DOM. 
 
##Arrays 
 
Uma array é declarada da seguinte forma: 
```javascript 
var nomes = new Array(); 
nomes[0] = "josé carlos"; 
nomes[1] = "maria"; 
``` 
Ou: 
```javascript 
var nomes = ["jose carlos","maria"]; 
``` 
Para usar a array: 
```javascript 
nomes[0]; // retorna jose carlos 
``` 
Para saber o tamanho de uma array: 
```javascript 
nomes.length; // retorna 2 
``` 
##Algumas funções 
 
**math.random()** retorna um valor entre 0 e 1 (mas nunca exatamente 1). Multiplique para obter um valor aleatório entre 0 e um valor qualquer. 
 
**math.floor()** arredonda um valor real para baixo. Usada com **math.random()**, é possível  gerar valores aleatórios inteiros entre 0 e qualquer número-1: 
```javascript 
math.floor(math.random()*5); // gera um valor aleatório entre 0 e 4. 
```

----------------------------------------------------------------
#**3. Events and handlers**

Eventos: **onload** e **onclick**. 
 
Você pode criar elementos *html* com **createElement()**, como segue: 
```javascript 
var li = document.createElement("li"); // cria elemento e coloca na variável 
``` 
Podemos inserir algo entre esse elemento com **innerHTML**. Como colocar esse conteúdo na página? Use **appendChild()** para anexar a um elemento existente. 
```javascript 
li.innerHTML = songName; // coloca songName entre as tags li criada 
var ul = getElementById("playlist"); // obtem o elemento ul existente 
ul.appendChild(li); // anexa li em ul 
``` 
Você pode guardar e recuperar dados localmente, sem precisar recorrer a *cookies*. O livro possui um código de exemplo de funções que fazem isso. Basta referenciar o código javascript no documento *html* e usar as funções *loadPlaylist()* e *save(variavelASerSalva)*. 


-------------------------------------------------------------------
#**4. Javascript functions and objects**

##Criando funções 
```javascript 
function nomeDaFuncao(parametros) 
{ 
	// codigo 
} 
``` 
Obs: a seguinte sintaxe também é válida: 
```javascript 
var nomeDaFuncao = function(parametros) 
{ 
	// codigo 
}; 
```
Alguns conceitos:

- *Parâmetro*: quando você define em uma função os valores que ela pode receber. 

- *Argumento*: quando você informa valores ao usar a função. 
 
- *Variáveis globais*: podem ser acessadas em qualquer lugar

- *Variáveis locais*: só existem em seu bloco 


Procure minimizar as variáveis globais.

Quando você declara uma variável local com o mesmo nome de uma variável global, a local tem preferência e acaba por ser usada. Procure não fazer isso, ou seja, defina bem suas variáveis.

Se não usar a palavra reservada **var** para declarar uma variável, então ela será tratada como global, mesmo que esteja em algum bloco. 
 
Uma função anônima (útil para fazer algo se um evento for disparado): 
```javascript 
function() 
{ 
	//código 
}; 
``` 
Podemos usar uma função anônima para o carregamento da página: 
```javascript 
window.onload = function() 
{ 
	//código 
} 
``` 
Exemplo de objeto em javascript: 
```javascript 
var fido = { 
	name: "Fido", 
	weight: 40, 
	breed: "Mixed", 
	loves: ["walks","fetching balls"] 
}; 
``` 
Usa-se o ponto para acessar uma propriedade de um objeto em Javascript: 
```javascript 
peso = fido.weight; 
``` 
Ou pode-se usar colchetes: 
```javascript 
peso = fido["weight"]; 
``` 
Enumerando todas as propriedades de um objeto: 
```javascript 
for(var prop in fido) 
{ 
	alert(prop); 
} 
``` 
Adicionando propriedades a um objeto: 
```javascript 
fido.age = 10; 
``` 
Removendo propriedades a um objeto: 
```javascript 
delete fido.age; 
``` 
Quando um objeto é associado a uma variável, aquela variável recebe a referência para o objeto, não o objeto em si. Então quando você passa um objeto para uma função, você estará passando a sua referência, o que significa que as mudanças que ocorrerem na função afetarão o objeto original.
 
Além de possuir propriedades, objetos podem ter comportamento, ou métodos: 
```javascript 
var fido = { 
	name: "Fido", 
	weight: 40, 
	breed: "Mixed", 
	loves: ["walks","fetching balls"], 
	bark: function(){ 
		alert("Woof woof!"); 
	} 
}; 
``` 
Para usar o método de um objeto, fazemos de maneira similar com as propriedades: 
```javascript 
fido.bark(); 
``` 
Quando se está definindo métodos, é importante conhecer a palavra reservada **this**, que se refere ao próprio objeto. Ou seja, quando se usa **this**, você pode pegar propriedades e métodos do próprio objeto para usá-los no método que está criando. 
```javascript 
var fido = { 
	name: "Fido", 
	weight: 40, 
	breed: "Mixed", 
	loves: ["walks","fetching balls"], 
	bark: function(){ 
		alert("Woof woof! "+this.name); 
	} 
}; 
``` 
Para criar muitos objetos com as mesmas propriedades e métodos, usa-se construtores, que é uma função especial (ou classe) usada para criar objetos.
```javascript 
function Dog(name,breed,weight){ 
	this.name = name; 
	this.breed = breed; 
	this.weight = weight; 
	this.bark = function() 
	{ 
		if(this.weight>25) 
		{ 
			alert(this.name + " says Woof!"); 
		} 
		else 
		{ 
			alert(this.name + " says Yip!"); 
		} 
	}; 
} 
``` 
Agora usando o construtor criado para gerar novos objetos usando a palavra **new**: 
```javascript 
var fido = new Dog("Fido","Mixed",38); 
var tiny = new Dog("Tiny","Chawalla",8); 
var clifford = new Dog("Clifford","Bloodhound",65); 
``` 
Os elementos da página web também são objetos, com suas próprias propriedades e métodos. Por exemplo, o elemento  **document** possui a propriedade **title** e o método **getElementById**. Para o objeto **window**, temos as propriedades **location** (que possui a *url*), **status** (uma string que aparece na barra de status), **onload** (que guarda a função que é disparada quando a página é totalmente carregada) e **document** (que guarda o *DOM*), e os métodos **alert**, **prompt**, **open** (abre nova janela), **close** (fecha a janela), **setTimeOut** e **setInterval**. 
 
Observe que o objeto **window** é global, ou seja, você não precisa escrever **window.alert**, apenas **alert**. De maneira similar, qualquer variável global que você definir, é colocada no namespace da window, ou seja, você pode se referir a variável usando **window.variavel**. 


----------------------------------------------------------------------------
#**5. Making your html location aware**

A latitude e longitude determinam a localização de um ponto no globo. A latitude se refere a distância norte (positiva) ou sul (negativa) do equador. Enquanto que a longitude se refere a distância leste (positiva) ou oeste (negativa) de Greenwich, Inglaterra. 
 
Em geral temos a representação da latitude e longitude em *graus:minutos:segundos*, ou em decimais. Este livro usará o sistema decimal, e uma função pode ajudar a conversão: 
```javascript 
function degreesToDecimal(degrees, minutes, seconds) { 
	return degrees + (minutes / 60.0) + (seconds / 3600.0); 
} 
``` 
Existem muitas maneiras de se determinar a localização do usuário pelos dispositivos: gps, endereço ip, wi fi, telefone celular entre outros. Acontece que o browser se encarrega de determina qual o melhor método disponível e então o utiliza. E tudo o que você precisa fazer é resgatar a informação. 
 
É possível utilizar *APIs* externas, fazendo link a scripts de urls externas. O *google map* possui exemplos de *APIs*, que podem ser integrados a qualquer site web. 
 
*(o restante do capítulo deve ser estudado fazendo os exercícios. Existem conceitos muito específicos para o tipo de aplicação estudada, então o ideal é voltar a ler o capítulo caso queira relembrar)* 

----------------------------------------------------------------------------
#**6. Talking to the web**

*(exercício, com algumas anotações abaixo)* 
 
- Requisição de dados do servidor: é possível requisitar dados do servidor de maneira assíncrona, ou seja, sem a necessidade de recarregar a página, usando Javascript. Essa técnica é chamada de *AJAX*. 
 
Vejamos como fazer uma requisição: 
 
1. Primeiro, você precisa de uma URL, onde os dados se encontram. Exemplo: `var url = "http://someserver.com/data.json";`. (observe que usamos **.json** como tipo do arquivo a ser requisitado). 
2. Então criamos um objeto de requisição, como isso: `var request = new XMLHttpRequest();`. 
3. Agora usamos o método **open** do objeto criado com o tipo de requisição e a *url* da localização dos dados para configurar a requisição: `request.open("GET",url);`. 
4. Agora definimos o que acontece quando os dados forem recebidos: `request.onload = function(){ if(request.status==200){alert("Data received!");}};`. 
5. Para finalizar, nós enviamos a requisição: `request.send(null);`. 
 
*JSON* é um formato de dados (assim com *xml*) bastante legível tanto para humanos como computadores. Nasceu do javascript, mas logo foi adotado por outras linguagens, permitindo o intercâmbio de dados entre sistemas diversos (assim como era o objetivo do *xml*). 
 
Para passar um objeto em javascript para o formato *JSON* usamos o método **JSON.stringify(*objeto*)**, e para passar a string em formato *JSON* para o formato objeto do javascript, usamos **JSON.parse(*jsonString*)**. 
 
É possível ainda requisitar dados de um servidor diferente usando técnicas de *JSONP*. Devidos a alguns padrões de segurança, não é permitido fazer requisição de dados para um servidor diferente. Mas através da *tag* `<script>`, isso é possível. Um código é executado no servidor alvo, retornando os dados necessários já parseados. (veja o livro e pesquise sobre o assunto). 


----------------------------------------------------------------------------
#**7. Bringing out your inner artist - The Canvas**

A tag canvas cria um espaço no navegador que possibilita desenhar e manipular gráficos. 
```html 
<canvas id="myCanvas" width="600" height="200"></canvas> 
``` 
Para ver o canvas, ajuste a cor e espessura da borda no *css*. 
 
No javascript, antes de você usar o canvas, deverá informar o contexto em que os gráficos serão desenhados ou manipulados. Até o momento, só existe o contexto 2d. 
```javascript 
var canvas = document.getElementById("myCanvas"); 
var context = canvas.getContext("2d"); 
``` 
Para desenhar um retângulo use a função **fillRect(*x*, *y*, *largura*, *altura*)**. O retângulo será preenchido. Para o retângulo não preenchido, use **strokeRect**. 
```javascript 
context.fillRect(10,10,100,100); 
``` 
É uma boa idéia sempre colocar algo entre as *tags* **canvas** no *html* avisando que o usuário deverá atualizar o seu navegador caso ele não tenha suporte a canvas. 
 
Você pode usar o método **fillStyle** para segurar uma cor no contexto, e desenhar qualquer coisa nesta cor . 
```javascript 
context.fillStyle = "black"; 
``` 
Para criar outras formas geométricas diferentes de um retângulo, você usará caminhos (*paths*). Para um triângulo, nós temos: 
```javascript 
context.beginPath();  //começa a escrever o caminho 
context.moveTo(100,150); //determina a posição inicial do caminho 
context.lineTo(250,75); //traça uma linha da posição anterior até esta posição 
context.lineTo(125,30); //traça uma linha da posição anterior até esta posição 
context.closePath(); // traça uma linha restante, fechando a forma 
``` 
Feito o caminho, resta desenhar. 
```javascript 
context.lineWidth = 5; // determina a largura da linha 
context.stroke(); // desenha a linha na cor preta, use strokeStyle para outra cor 
context.fillStyle() = "red";// cor do preenchimento 
context.fill(); // preenche a forma 
``` 
Para desenhar um círculo, basta usar o método **arc(x, y, raio, inicioAngulo, fimAngulo, direcao)**. Os valores *x* e *y* correspondem ao centro do círculo. O *raio* é metade da largura do círculo. O *inicioAngulo* e *fimAngulo* é onde o círculo começa e termina, em radianos (use uma função para transformar graus em radianos). E direcao será *true* se for traçado no sentido antihorário e *false* se for no sentido horário. obs: os graus são contados no sentido horário. 
```javascript 
context.arc(100,100,75,0,degreesToRadians(270),true) 
``` 
A função **degreesToRadians**: 
```javascript 
function degreesToRadians(degrees){ 
	return (degrees * Math.PI)/180; 
} 
``` 
Trabalhar com texto exige o conhecimento de certos métodos e propriedades. 
 
A propriedade **textAlign** permite alinhar o texto. Os possíveis valores são *start*, *end*, *left*, *right* e *center*. *start* e *end* são o mesmo que *left* e *right* em idiomas esquerda-para-direita, e o reverso em idiomas direita-para-esquerda (como Japonês). 
```javascript 
context.textAlign = "left"; 
``` 
Os métodos **fillText** e **strokeText** são usados para preencher a forma e as linhas do texto, respectivamente. Os parâmetros nos dois casos são: *x*, *y* e *largura máxima* (este último opcional). 
```javascript 
context.fillText("Dog",100,100,200) // cria um texto somente com preenchimento, sem borda 
context.strokeText("Cat",100,150,100,200) // cria um texto somente com borda, sem preenchimento 
``` 
A propriedade **font** define o estilo, peso (negrito), tamanho e família. É usado da mesma forma que no *css*. Procure usar somente fontes vetoriais (fontes bitmaps não funcionam muito bem). 
```javascript 
context.font = "italic bold 1.5em Times, serif"; 
``` 
A propriedade **baseline** configura pontos de alinhamento da fonte e determina a linha em que as letras estão. Os possíveis valores são: *top*, *hanging*, *middle*, *alphabetic*, *ideographic* e *bottom*. Obs: isso não irá desenhar nada, apenas determinar se o texto vai "subir" ou "descer". 
```javascript 
context.beginPath(); 
context.moveTo(100, 100); 
context.lineTo(250, 100); 
context.stroke(); 
context.textBaseline = "middle"; 
context.fillText("Alphabet", 100, 100); 
``` 
Para usar uma imagem, siga esses passos: 
1. Crie um novo objeto de imagem. 
2. Agora com o método **drawImage(x, y, largura, altura)** de **context** nós desenhamos no canvas. 
3. Esse método permite desenhar a imagem, mas e se a imagem não estiver totalmente carregada? Assim, usamos o evento **onload** da imagem para verificar isso.
4. Definimos a url, e o navegador irá carregar a imagem automaticamente.
```javascript
var twitterBird = new Image(); 
context.drawImage(twitterBird,20,120,70,70);
twitterBird.onload = function(){ 
	context.drawImage(twitterBird,20,120,70,70); 
};
twitterBird.src = "twitterBird.png";
```

------------------------------------------------------------------------
#**8. Not your father's tv, Video**

Cada navegador tem o seu formato preferido de vídeo. O *Chrome* prefere o formato *webm*, o *Safari* prefere *H.264* e o *Firefox* e *Opera* preferem o formato *ogv*. 
 
Sobre o elemento `<video>`: 
```html
<video 
	controls <!-- fornece controles do vídeo. --> 
	autoplay <!-- o video começa assim que a página for carregada.--> 
	src="" <!--a localização do video.--> 
	width="480" height="360"  <!-- a largura e altura do vídeo na página.--> 
	poster="images/" <!-- uma imagem que é mostrada quando o vídeo não está carregando --> 
	id="video" <!-- uma id para acessar essa tag no javascript-->
	>
</video> 
``` 
Existem ainda os atributos **preload** e **loop**. 
 
Cada formato possui uma codificação de vídeo e áudio diferentes. O que você deverá fazer para que o vídeo do seu site seja visível para a maioria dos navegadores é indicar a url de cada formato, e o primeiro formato suportado pelo navegador será carregado. 
```html 
<video id="video" poster="video/prerollposter.jpg" controls width="480" height="360"> 
	<source src="video/preroll.mp4"> 
	<source src="video/preroll.webm"> 
	<source src="video/preroll.ogv"> 
	<p>Sorry, your browser doesn’t support the video element</p> 
</video> 
``` 
A tag `<source>` possibilita informar mais de uma *url* para uma mesma mídia. Você pode ser mais específico informando atributos desta *tag*. O atributo *type* informa o tipo de arquivo e formato, além dos codecs usados, por exemplo: 
```html 
<source src="video/preroll.ogv" type='video/ogg; codecs="theora, vorbis"'> 
``` 
Veja que o atributo **type** define várias coisas, e que usa aspas simples para pegar todos os valores, e aspas duplas para definir a lista de *codecs*. 
 
Dentro da tag `<video>` você pode inserir uma tag `<object>` para o caso do browser não ter suporte a `html5`, e assim executar flash, por exemplo. 
 
Tenha em mente que o seu vídeo é um objeto e, por isso, há uma variedade de métodos, propriedades e eventos relacionados que podem ser usados. 
 
Você pode adicionar um evento a um objeto com o método **addEventListener**, onde recebe três parâmetros: o nome do evento (não use "*on*", que é adicionado automaticamente), a função que é acionada, e se o evento é testado (isso exige programação avançada, então por enquanto deixe como *false*). 
```javascript 
video.addEventListener("ended",nextVideo,false); 
``` 
Você pode usar a propriedade **src** para informar a *url* do vídeo e os métodos **load()** e **play()**, nesta ordem, para carregar e começar o vídeo. 
 
Existe ainda o método **canPlayType()**, que retorna uma string informando se o browser pode ou não tocar determinado formato de vídeo. Se passar uma forma curta (como "*video/ogg*"), você obterá somente "" ou "*maybe*" como resposta. Mas se passar  a forma completa (como '*video/ogg; codecs="theora, vorbis"*'), você ainda poderá receber mais uma resposta: "*probably*". Uma string vazia ("") indica que o browser sabe que não pode tocar o vídeo. "*maybe*" indica que o browser possivelmente poderá tocar o vídeo. E "*probably*" quer dizer que o browser tem quase certeza que pode tocar o vídeo. 
 
Quando você configura um evento para que execute uma função caso seja ativado, você pode passar para essa função um parâmetro que significa *event*, e então usá-lo para localizar o objeto correspondente. Por exemplo: 
```javascript 
effectLinks[i].onclick = setEffect; // configura o evento onclick do objeto effectLinks[i] 
function setEffect(e) { // pode usar e ou qualquer outro nome para se referenciar ao evento 
	var id = e.target.getAttribute("id"); // pega o atributo id do objeto que disparou o evento 
	//.... 
} 
``` 
(Por alguma razão, o exemplo do videobooth não funciona. Exercício pulado, mas já tenho uma ideia de como reproduzir o mesmo) 


-----------------------------------------------------------------------
#**9. Storing things locally, Web Storage**

##How browser storage works (1995 - 2010) 
 
Para armazenar informações do usuário, os navegadores usavam *cookies*. Esses *cookies* eram limitados a 4k de informação e tinham vida útil limitada. Esses *cookies* eram enviados para o servidor, permitindo personalizar o site de acordo com cada cliente. 
 
##How HTML5 Web Storage works 
 
O armazenamento web *html5* permite que você salve pares de dados de forma persistente. Os navegadores atuais oferecem de 5 a 10 megabytes para guardar todos os dados do usuário por domínio. E esses dados são salvos localmente, ou seja, nada de comunicação desnecessária com o servidor. 
 
##Note to self... 
 
Primeiro, você tem um objeto chamado de **localStorage**, que permite o acesso ao *API* de armazenamento web. O objeto **localStorage** possui um método chamado **setItem**, que é usado para guarda coisas. Esse método recebe uma string chave e uma string de valor, onde a chave é associada ao valor. 
```javascript 
localStorage.setItem("key","value"); 
``` 
Sim, você só poderá guardar strings. Mas é possível converter essas strings para números depois. 
 
Se você usar o método **setItem** para uma chave já existente, o valor será reescrito (o valor anterior será perdido). Lembre-se: esses pares chave/valor são separados por domínios, então não se preocupe em manter as chaves de seu domínio diferentes de seu concorrente! 
 
Para recuperar um valor, você usa o método **getItem**, que recebe apenas um parâmetro: a chave. Esse método retorna o valor associado aquela chave. 
```javascript 
localStorage.getItem("key"); 
``` 
Sabendo como recuperar um valor armazenado em **localStorage**, agora vamos ver como converter uma string para número, quando isso for necessário. É simples, e você provavelmente já fez isso: use as funções **parseInt()** e **parseFloat()**. A primeira converte para inteiro e a segunda converte para número com ponto flutuante. 
 
##Were Local Storage and the Array separated at birth? 
 
Você pode usar o objeto **localStorage** como um array associativo. 
```javascript 
localStorage["key"] = "value"; 
var my_var = localStore["key"]; 
``` 
##But wait, there’s more! 
 
O objeto **localStorage** possui uma propriedade chamada **length** e um método chamado **key**. 
 
A propriedade **length** guarda a quantidade de itens guardados no armazenamento local. Isso permite, por exemplo, percorrer todos os itens de **localStorage**. 
 
Já o método **key()** recebe um índice, a partir do zero, que indica a posição do item no **localStorage** (você pode usar o loop explicado no parágrafo anterior para fornecer esse índice), e retorna a chave correspondente (que pode ser usada para acessar o valor correspondente a essa chave). 
 
##We need to stop for a little scheduled service 
 
É possível ver o armazenamento local por meio de seu navegador. No *Chrome*, basta pressionar *crtl + shift + j*, depois clicar em "*resources*", abrir "*local storage*" e clicar no domínio (que será *localhost* se você estiver num servidor local). É possível editar ou deletar cada valor do armazenamento local (no caso da edição, é possível editar a chave e o valor). 
 
*(isso pode ser um problema, principalmente no caso de dados que o usuário pode editar para trapacear. Por exemplo, você pode guardar, em um jogo, as fases disponíveis. Nestes casos, você pode ter duas opções: criptografia na chave e valor, ou guardar alguns dados no servidor)*
 
Existe um método do objeto *localStorage* que deleta todos os dados locais do domínio: **clear()**. Esse método não recebe argumentos. 
 
##Reworking our app to use an array 
 
Para cada projeto, você pode criar um espaço para o armazenamento local, evitando misturar com dados de outros projetos. Para atingir esse propósito, você pode armazenar um array no lugar de um valor e assim armazenar um array de chaves. Então é só usar essas chaves para acessar os valores em **localStorage**. Veja o exemplo em javascript do livro para ter uma ideia de como usar isso. 
 
##Deleting sticky notes 
 
Sabemos como deletar todos os dados locais. Mas e para deletar um item específico? Neste caso usamos um método denominado **removeItem()**, que recebe a chave do item a ser deletado. 
```javascript 
localStorage.deleteItem(key); 
``` 
##Try this at Home 
 
Uma coisa que você precisa tomar cuidado é com limite de armazenamento. É necessário tratar o erro de quando não conseguir armazenar os dados. 
 
Você pode usar *try/catch* para fazer essa verificação e tratar o erro: 
```javascript 
try{ 
	localStorage.setItem(myKey,myValue); 
}catch(e){ 
	if (e==QUOTA_EXCEEDED_ERR) 
	alert("Out of storage!"); 
} 
``` 
##No Luke, there is another Skywalker. 
 
Além de **localStorage**, existe o **sessionStorage**, que tem as mesmas propriedades e métodos. A diferença é que o **sessionStorage** tem limite de duração de uma sessão. Quando você termina sua sessão (fechando o navegador, desligando a conexão, desligando o computador...), os dados se perdem. 


-------------------------------------------------------------------------
#**10. putting javascript to work, Web Workers**

O JavaScript faz uma coisa por vez. Assim, não dá para fazer tarefas serem executadas ao mesmo tempo. Logo, tarefas pesadas podem atrasar outras tarefas mais simples. 
 
Um fluxo de processos normais da página pode ser denominado *thread*. Antes do *html5*, tínhamos apenas um *thread* para executar tudo. Mas agora podemos gerar *Web Workers* como uma forma de criar novos *threads*. Assim, se um pedaço do código levar muito tempo para ser computado, basta gerar um *Web Worker* e deixá-lo cuidar da tarefa. 
 
*(daqui por diante iremos chamar o thread principal de thread javascript, e os outros de thread web worker)* 
 
##How Web Workers work 
 
Cada *worker* é definido em seu próprio arquivo javascript que contém todo o código (ou referências para o código) para o seu trabalho. Além disso, eles não podem acessar o DOM ou qualquer das variáveis ou funções do código principal (nem de outros *workers*). 
 
Para fazer um *worker* começar a trabalhar, o navegador manda uma mensagem a ele. O *worker* recebe a mensagem, a analisa a procura de qualquer instrução especial, e começa a trabalhar. 
 
Quando um *worker* termina o seu trabalho, ele manda uma mensagem de volta com o resultado final. O navegador pega então estes resultados e os incorpora na página de alguma maneira. 
 
*(devido a restrições de segurança, o google chrome previne que web worker sejam gerados a partir de um arquivo local, como em file://. Use um navegador diferente para executar isso)* 
 
##How to create a Web Worker 
 
Para criar um *web worker* é simples: 
```javascript 
var worker = new Worker("worker.js"); 
``` 
Você pode criar quantos *workers* desejar com base no mesmo arquivo ou com base em arquivos diferentes. 
 
Para fazer o *worker* trabalhar, nós precisamos enviar uma mensagem a ele. Para isso temos o método **postMessage()** do objeto **Worker**, que recebe a mensagem a ser enviada como argumento. É apenas um argumento, mas você pode enviar um array, uma string, um número, um objeto *JSON*, etc. Mas não pode enviar funções ou objetos do DOM! 
 
##Receiving messages from the worker 
 
Para receber mensagem do *worker* (se ele conseguir realizar a tarefa), precisamos de um evento, pois não sabemos quanto tempo ele irá levar! Para isso usamos o evento **onmessage** do **Worker**. 
 
##Now let’s write the worker 
 
Todo worker recebe mensagens. Logo precisamos criar um evento no *worker* que ao receber a mensagem, dispare um evento que fará alguma coisa. Para isso, criamos uma variável (ou propriedade) e igualamos a uma função evento. No exemplo abaixo, **onmessage** é a propriedade e *pingPong* é a função: 
```javascript 
onmessage = pingPong; 
``` 
Agora precisamos escrever a função. No exemplo abaixo, se os dados do evento coincidirem com o esperado, a função *postMessage* é disparada: 
```javascript 
function pingPong(event) { 
	if (event.data == "ping"){ 
		postMessage("pong"); 
	} 
} 
``` 
##Take a look at importScripts. 
 
*Web workers* possuem uma função global denominada **importScripts** que importa um ou mais arquivos javascripts para o seu *worker*. Se mais de um script for importado, eles são separados por vírgula. 
 
Você pode importar de acordo com a tarefa: 
```javascript 
if (taskType == "songdetection") { 
	importScripts("audio.js"); 
} 
```

---------------------------------------------------------------------
#**Appendix**

##1. *Modernizr* 
 
*Modernizr* é uma forma de detectar o suporte ou não dos navegadores quanto aos elementos do *html5* e *css3*. É uma biblioteca javascript, que você baixa e carrega na página, possibilitando fazer essas verificações. 
 
##2. Audio 
 
O *html5* possui uma tag **audio** que permite executar audio sem plugins adicionais. A *API* de **audio** possui métodos como **play**, **pause** e **load**, assim como **video**. Também possui propriedades como **src**, **currentTime** e **volume**. 
 
Os formatos mais populares de audio são *mp3*, *wav* e *Ogg Vorbis* (*Chrome* é o ínico navegador que suporta os três formatos). 
 
##3. *jQuery* 
 
*jQuery* é uma biblioteca javascript que facilita muito da linguagem. Coisas como acessar o DOM, usar *AJAX* e adicionar efeitos visuais em suas páginas. Basta baixar a versão mais recente e carregar na página. 
 
##4. XHTML is dead, long live XHTML 
 
Existem tecnologias que usam *XML*, como *SVG*. Logo, você ainda pode usar *XHTML* se ainda precisar usam essas tecnologias. A boa notícia é que o *XHTML* mudou um pouco e será mais fácil trabalhar com ele. 
 
##5. *SVG* 
 
*SVG* (*Scalable Vector Graphics*) é outra maneira (ao lado do *canvas*) de tratar gráficos em suas páginas web. Canvas usa javascript para desenhar gráficos na página. Já o *SVG* usa *XML* para especificar esses gráficos. O *XML* lhe permitirá criar elementos que representam gráficos, e você poderá usar esses elementos da forma que desejar. 
 
##6. Offline web apps 
 
O *html5* permite criar aplicativos que funcionam offline (claro, IE não permite isso...). Para ativar essa funcionalidade, você deve criar um arquivo **cache manifest** que contém uma lista de todos os arquivos que o seu aplicativo precisa para funcionar, e o navegador irá baixar todos esses arquivos e mudar para arquivo local caso esteja *offline*. Para informar à sua página que um arquivo se trata de um arquivo **manifest**, você simplesmente adiciona o nome do arquivo ao atributo **manifest** na sua tag **html**, como isso: 
```html 
<html manifest="notoself.manifest"> 
``` 
Aqui temos um exemplo de um arquivo *manifest*: 
``` 
CACHE MANIFEST 
CACHE: 
notetoself.html 
notetoself.css 
notetoself.js 
``` 
Você também deve adicionar mais duas outras seções no arquivo: **FALLBACK** e **NETWORK**. O primeiro você especifica um arquivo para usar se você tentar acessar um arquivo que não estiver no cache, e **NETWORK** especifica arquivos que nunca devem estar no cache. 
 
*(há outros detalhes. Se realmente for de interesse, pesquise)* 
 
##7. *Web Sockets* 
 
*Web Socket* é uma *API* que mantém uma linha aberta com um serviço. A qualquer momento, o serviço pode enviar dados para você, e então você é notificado disso. Veja um exemplo de como criar um *websocket*: 
```javascript 
var socket = new WebSocket("ws://yourdomain/yourservice"); 
``` 
Então você pode criar um evento para notificá-lo quando o socket estiver aberto: 
```javascript 
socket.onopen = function(){ 
	alert("Your socket is now open with the web service"); 
} 
``` 
Você pode mandar uma mensagem para o serviço web com o método **postMessage**: 
```javascript 
socket.postMessage("player moved right"); 
``` 
E o evento que você escreve para recebe mensagens do serviço web: 
```javascript 
socket.onmessage = function(event){ 
	alert("From socket: "+event.data); 
} 
``` 
*(também há outros detalhes)* 
 
##8. More canvas API 
 
Os métodos **save** e **restore** (ambos sem argumentos) de **context** permitem salvar e restaurar o contexto salvo, respectivamente. 
 
##9. Selectors API 
 
Além de **getElementById**, você também tem **getElementByTagName** (retorna um array de elementos com a mesma tag) **getElementByClassName** (retorna um array de elementos com a mesma classe). 
 
Bom, em *html5*, existe o método **querySelector** que seleciona os elementos de acordo com o argumento que você passar (da mesma forma que no *jQuery*). Porém, esse método só retorna um elemento; para retornar um array de elementos, use **querySelectorAll**. 
 
##10 But, there’s even more! 
 
Algumas tecnologias recentes: 
1. *Web SQL* e *IndexedDB*: uso de banco de dados local!. 
2. Arrastar e soltar: os desenvolvedores estão usando *jQuery* para permitir fazer isso com elementos da página, mas com a *API* *Drag and Drop*, você apenas precisa especificar o atributo **draggable** de um elemento como *true*. Essa *API* possui outras funcionalidades. 


