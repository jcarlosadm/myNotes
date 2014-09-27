Tutorial de html5 game dev do site udacity
https://www.udacity.com/course/cs255

*Obs: Esse tutorial usa o código **Simple Inheritance** de **John Resig**. Porém, existe um código baseado neste e melhor que simular membros privados de uma forma mais direta e limpa: **JClass**, ou **JavaScript Inheritance with Private Members**.*
Github do projeto: [*JClass*](https://github.com/riga/jclass).
Código: [jclass.js](https://github.com/riga/jclass/blob/master/lib/jclass.js), ou a forma compactada [jclass.mini.js](https://github.com/riga/jclass/blob/master/lib/jclass.min.js)

[TOC]

-----------------------------------------------------------------
#**Optional JavaScript Crash Course**

##Requisitos

Antes de começar, é bom estudar a sintaxe de javascript, principalmente a sintaxe de objeto e o uso da palavra **this**. E também sobre herança. Também deverá conhecer a sintaxe e uso de arquivos *JSON*. 
 
Só uma revisão: pegar dados *JSON* do servidor: 
```javascript 
var request = new XMLHttpRequest(); 
request.open("GET","/media/resources/gamedev/weapon.json",true); 
request.onload = function(){ 
        JSON.parse(this.responseText); 
}; 
request.send(null); 
``` 

##*Callbacks*

*(esse conteúdo não foi do udacity)* 
 
Quando for necessário usar uma função síncrona, o ideal é usar *callback*: 
```javascript 
var requestJson = function(url,callback){ 
	// novo objeto de requisição 
	var request = new XMLHttpRequest(); 
	 
	// configura a requisição 
	request.open("GET", url, true); 
	 
	// define o que acontece após receber a resposta 
	request.onload = function(){ 
		// executa callback com a resposta 
		callback(JSON.parse(this.responseText)); 
	}; 
 
	// envia a requisição 
	request.send(); 
}; 
``` 
Para usar esse *callback*: 
```javascript 
requestJson (url, function(){ 
	// codigo 
}); 
``` 
Assim, o código só será executado após a requisição retornar o objeto solicitado (talvez seja melhor tratar a função de requisição para o caso de algum erro).


##Som

Já sabemos como requisitar arquivos *JSON* e imagens do servidor, mas e som? Bom, para requisitar um arquivo de audio, fazemos algo como: 
```javascript 
soundRequest = new XMLHttpRequest(); 
soundRequest.open("GET", '/media/audio/gamedev/bg_menu.ogg', true); 
soundRequest.responseType = 'arraybuffer'; 
 
soundRequest.onload = function () {  
	try { 
	var context = new webkitAudioContext(); 
	 
	var mainNode = context.createGainNode(0); 
	mainNode.connect(context.destination); 
	 
	var clip = context.createBufferSource(); 
	 
	context.decodeAudioData(soundRequest.response, function (buffer) { 
		clip.buffer = buffer; 
		clip.gain.value = 1.0; 
		clip.connect(mainNode); 
		clip.loop = true; 
		clip.noteOn(0); 
		}, function (data) {}); 
	} 
	catch(e) { 
		console.warn('Web Audio API is not supported in this browser'); 
	} 
}; 
 
soundRequest.send(); 
``` 
Nós podemos criar uma função para unificar a requisição de arquivo *JSON* e de som (o parâmetro *callback* é a função que irá fazer a requisição *JSON* ou de *som*, e **type** pode ser *null* ou '*arraybuffer*'): 
```javascript 
function xhrGet(reqUri, callback, type) { 
    var request = new XMLHttpRequest(); 
    request.open("GET",reqUri,true); 
    if(type!==null) request.responseType = type; 
    request.onload = function(){ 
        callback(this); 
    }; 
    request.send(); 
     
    return request; 
} 
``` 
As outras funções para tratar o arquivo *JSON* ou tocar o audio (use no lugar de *callback* quando usar a função acima): 
```javascript 
parseJSON = function (xhr) { 
    var parsedJSON = JSON.parse(xhr.responseText); 
 
    var x = parsedJSON.frames['chaingun_impact.png'].spriteSourceSize.x; 
    console.log(x); 
    return x; 
}; 
 
playSound = function (xhr) { 
    try { 
        var context = new webkitAudioContext(); 
 
        var mainNode = context.createGainNode(0); 
        mainNode.connect(context.destination); 
 
        var clip = context.createBufferSource(); 
 
        context.decodeAudioData(xhr.response, function (buffer) { 
            clip.buffer = buffer; 
            clip.gain.value = 1.0; 
            clip.connect(mainNode); 
            clip.loop = true; 
            clip.noteOn(0); 
        }, function (data) {}); 
    } 
    catch(e) { 
        console.warn('Web Audio API is not supported in this browser'); 
    } 
}; 
```

##Classes

Para esse curso, se usará o código de John Resig que simula a programação orientada a objeto de outras linguagens. O código se encontra em [aqui](http://ejohn.org/blog/simple-javascript-inheritance/). 
 
Abaixo você encontra exemplos de como usar (tirado do blog): 
```javascript 
var Person = Class.extend({ 
  init: function(isDancing){ 
    this.dancing = isDancing; 
  }, 
  dance: function(){ 
    return this.dancing; 
  } 
}); 
  
var Ninja = Person.extend({ 
  init: function(){ 
    this._super( false ); 
  }, 
  dance: function(){ 
    // Call the inherited version of dance() 
    return this._super(); 
  }, 
  swingSword: function(){ 
    return true; 
  } 
}); 
  
var p = new Person(true); 
p.dance(); // => true 
  
var n = new Ninja(); 
n.dance(); // => false 
n.swingSword(); // => true 
  
// Should all be true 
p instanceof Person && p instanceof Class && 
n instanceof Ninja && n instanceof Person && n instanceof Class 
``` 
Para usar, basta copiar essas linhas abaixo (tirado do blog): 
```javascript 
/* Simple JavaScript Inheritance 
 * By John Resig http://ejohn.org/ 
 * MIT Licensed. 
 */ 
// Inspired by base2 and Prototype 
(function(){ 
  var initializing = false, fnTest = /xyz/.test(function(){xyz;}) ? /\b_super\b/ : /.*/; 
  
  // The base Class implementation (does nothing) 
  this.Class = function(){}; 
  
  // Create a new Class that inherits from this class 
  Class.extend = function(prop) { 
    var _super = this.prototype; 
    
    // Instantiate a base class (but only create the instance, 
    // don't run the init constructor) 
    initializing = true; 
    var prototype = new this(); 
    initializing = false; 
    
    // Copy the properties over onto the new prototype 
    for (var name in prop) { 
      // Check if we're overwriting an existing function 
      prototype[name] = typeof prop[name] == "function" && 
        typeof _super[name] == "function" && fnTest.test(prop[name]) ? 
        (function(name, fn){ 
          return function() { 
            var tmp = this._super; 
            
            // Add a new ._super() method that is the same method 
            // but on the super-class 
            this._super = _super[name]; 
            
            // The method only need to be bound temporarily, so we 
            // remove it when we're done executing 
            var ret = fn.apply(this, arguments);         
            this._super = tmp; 
            
            return ret; 
          }; 
        })(name, prop[name]) : 
        prop[name]; 
    } 
    
    // The dummy class constructor 
    function Class() { 
      // All construction is actually done in the init method 
      if ( !initializing && this.init ) 
        this.init.apply(this, arguments); 
    } 
    
    // Populate our constructed prototype object 
    Class.prototype = prototype; 
    
    // Enforce the constructor to be what we expect 
    Class.prototype.constructor = Class; 
  
    // And make this class extendable 
    Class.extend = arguments.callee; 
    
    return Class; 
  }; 
})(); 
``` 
Você pode adicionar variáveis privadas dentro de um método, como isso (tirado do blog): 
```javascript 
init: function() { 
   // Private var 
   var _div = $( div ); 
   // Priviledged method accesses private var 
   this.getDiv = function () { 
 return _div; 
   } 
   this.setDiv = function (div) { 
 _div = div; 
   }    
   // other initialization stuff 
} 
```

--------------------------------------------------------------------------
#**Canvas**

##Criando canvas
```javascript
var body = document.getElementById("body"); // pegando o elemento com id body
 
var canvas = document.createElement("canvas"); 
canvas.width = window.innerWidth; // pega a largura da área de conteúdo da janela 
canvas.height = window.innerHeight; // pega a altura da área de conteúdo da janela 
body.appendChild(canvas); // anexa canvas em body 
```

##Carregando imagens

Carregar uma imagem do servidor é fácil. O processo envolve criar um novo objeto de imagem, definir o que fazer quando a imagem for carregada (uma função) e qual a *url* da imagem: 
```javascript 
image = new Image(); 
image.onload = onImageLoad; 
image.src = "image.jpg"; 
``` 
Você pode usar *callback* para carregar imagens do servidor da mesma maneira:
```javascript 
var load_image = function(url, callback){ 
	// cria um novo objeto de imagem 
	var image = new Image(); 
	 
	// define o que acontece quando a imagem é carregada 
	image.onload = function(){ 
		// executa callback com a imagem 
		callback(image); 
	}; 
	 
	// define o endereço de onde se encontra a imagem 
	image.src = url; 
}; 
``` 
Você pode carregar imagens *jpeg* e *png*. O formato *jpeg* é mais leve, enquanto que o *png* possui o canal *alpha*, responsável pela transparência. Existe ainda um novo formato denominado *webp*, que possui tanto compressão como transparência. 


##Desenhando imagens

Para desenhar, você precisa do contexto: 
```javascript 
ctx = canvas.getContext('2d'); 
``` 
O objeto **context** possui um método denominado **drawImage** que desenha algo no canvas. Esse método possui uma série de parâmetros, mas você só precisa de três por enquanto: o objeto de imagem, a posição *x* e a posição *y*. 
```javascript 
ctx.drawImage(image,192,192); 
```

##Animação

Para animação, usamos uma função do javascript chamada de **setInterval()**, que recebe uma função como primeiro parâmetro e a quantidade de milissegundos de ativação da função como segundo parametro. 
```javascript 
setInterval(animation,1000/30); // chama a função animation 30 vezes por segundo 
``` 
Na função de animação, você precisa apagar a imagem desenhada no contexto antes de desenhar novamente (pode apagar mesmo que não tenha desenhado ainda). Usamos, para isso, o método **clearRect** de **context**, que recebe as coordenadas *x* e *y*, a *largura* e a *altura*. 


--------------------------------------------------------------------------
#**Atlases**

##Parsing texturepacker output

Em primeiro lugar, você deve transformar a string *JSON* carregada do servidor em um objeto JavaScript. Isso se faz com o método **parse** do objeto **JSON**: 
```javascript 
var parsed = JSON.parse(atlasJSON); 
``` 
Depois você pode acessar os dados *JSON* carregados do servidor da mesma maneira que acessa dados de um objeto. 
 
Uma dica: se a visualização do jogo é superior, então talvez você queira definir o centro do sprite do jogador. Para isso você pode calcular metade da altura e largura, e então colocar esses valores de forma negativa em uma variável. Depois, use o ajuste da largura para deslocar a imagem para a esquerda, e o ajuste da altura para deslocar para cima. 

##drawImage from Atlas

Para desenhar uma imagem do Atlas, use mais parâmetros no método **drawImage** do objeto **context**. Primeiro você define o objeto de imagem, e depois vem *x*, *y*, *largura* e *altura*, todos do Atlas. Os últimos parâmetros são *x*, *y*, *largura* e *altura*, todos do destino. 
 
Lembre-se que você deve ajustar a posição *x* e *y* do destino para centralizar o seu sprite na tela. 

##Parsing trimmed texture

O *texturepacker* possui uma opção que remove espaços transparentes da imagem para diminuir o tamanho total. Logo, você precisa ter um cuidado especial ao utilizar as informações do Atlas. Permite que a ferramenta faça isso, pois diminui o tamanho do atlas e facilita na hora de carregar do servidor. 
 
*(essa ferramenta também permite rotacionar; a menos que aprenda a retornar ao estado original de cada imagem, não recomendamos que use essa opção)* 

##Tiled

Você pode criar mapas em um editor chamado *Tiled*. Essa ferramenta pode exportar o resultado na forma de um arquivo *JSON*, que você pode usar para montar o mapa do jogo. 
 
O *Tiled* é uma boa ferramenta pois permite que você crie camadas, defina objetos, animações etc. E exporte todas as informações para um arquivo *JSON*. Além disso, muitos frameworks *html5* para jogos usam os outputs do *Tiled*. 
 
Por exemplo, podemos criar uma camada base, onde o herói irá colidir, e mais duas camadas, uma a frente e outra atrás da camada base. 
 
No array de blocos, um valor 0 significa que nenhum bloco foi colocado nesta posição.

-------------------------------------------------------------------------
#**Input**

##Event Listeners

Você pode adicionar um evento a um objeto, que executará uma função quando algo acontecer, por meio de **addEventListener(*evento*, *função*)**. Não é a única maneira, mas é uma das melhores, pois permite adicionar mais que um manipulador por evento, e funciona com qualquer elemento *DOM*, não apenas *HTML* (veja [aqui](https://developer.mozilla.org/pt-BR/docs/Web/API/Element.addEventListener)).

```javascript
document.getElementById("id").addEventListener('mousemove',onMouseMove);
```
Exercício retirado do *Udacity*:
```javascript
function setup() {
    var myCanvas = document.getElementById("my_canvas");
    myCanvas.addEventListener('mousemove',onMouseMove);
    myCanvas.addEventListener('keydown',onKeyDown);
}

function onMouseMove(event) {
    var posx = event.clientX;
    var posy = event.clientY;
    return posx;
}

function onKeyDown(event) {
	return event.keyID;
}
```

##Problems With Keyboard Input

Na verdade, um problema com a programação orientada a eventos é que não sabemos exatamente quando os eventos ocorrem. O jogo possui o seu próprio fluxo de atualização e renderização, e a verificação e chamada de eventos ocorre em seu próprio fluxo.

Uma maneira de resolver isso é usar uma variável booleana de pressionamento de tecla. Essa variável será configurada para *true* se o evento do pressionamento ocorrer. No momento correto do loop de jogo, essa variável pode ser verificada para que algo aconteça no momento certo. Você pode ter o seu próprio array de teclado, onde cada posição corresponde a uma posição do teclado.

##Key Mapping

Key Mapping é uma técnica que desenvolvedores de jogos utilizam para que os jogadores possam personalizar o controle de acordo com a sua preferência.

Para utilizar isso, o seu jogo não pode verificar as teclas diretamente. Deverá haver alguma forma de configuração, e um comando geral, como **"key_up"**. Então associamos cada comando geral a uma tecla. Quando uma tecla é pressionada, procura-se o comando correspondente, e então se executa a ação correspondente.

#**Entities**

As **Entities** de seu jogo são todas as criaturas, itens, armadilhas etc. Ou seja, objetos que possuem uma posição (x e y), uma dimensão (largura e altura) e uma atualização a cada frame.

Cada *Entitie* possui sua classe. Uma dica: na inicialização da *Entitie*, adicione sua classe em um hash no gameEngine. Assim, ao criar uma nova entidade, basta chamar o seu nome e criar um novo objeto.

O objeto criado pode ser inserido numa lista para atualização a cada frame.

Talvez você queira adicionar uma flag quando uma entidade for morta, como **killed**. Primeiro você atualiza as entidades e depois você as retira de jogo. Essa questão do que é atualizado primeiro é um pouco complicado de se resolver, portanto gaste algum tempo nisso.

na rederização, adicione um valor **z** que indica a ordem em que o objeto é renderizado, evitando problemas no momento de procurar saber o que é renderizado primeiro.

#**Physics**

##Colisões

Para calcular a colisão entre dois objetos, podemos usar o modelo de caixa, onde temos um limite superior, inferior, direito e esquerdo para cada objeto, e então verificamos, a cada frame, se esses limites se interceptam (é mais fácil verificam onde não se interceptam).

```javascript
/*
Struct of r:
r = {
    top:y1,
    bottom:y2,
    right:x1,
    left:x2
}
*/
function isCollision(r1, r2){
    if((r1.top > r2.bottom)||(r1.bottom < r2.top)||(r1.right < r2.left)|| (r1.left > r2.right))
        return false;
    else
        return true;
}
```

##Box2D

O [**Box2D**](http://box2d.org/) é uma biblioteca de física open source para uso em objetos de 2 dimensões. Foi escrito para uso em **c++**, mas há uma versão para [javascript](http://box2d-js.sourceforge.net/#howto).

Após baixar o script, colocá-lo em seu game é fácil. Basta carregar o script (não se esqueça de dar os devidos créditos!):

```html
<script src="./box2d.min.js"></script>
```

Você pode usar a [*API*](http://www.kyucon.com/doc/box2d/) do *Box2D*, ou então ler o manual do *Box2D* para [*Flash*](http://www.box2dflash.org/docs/2.0.2/manual) (os conceitos são os mesmos).

Bom, em primeiro lugar, há uma série de métodos que podemos usar. Para simplificar a chamada destes métodos, podemos usar atalhos:

```javascript
Vec2 = Box2D.Common.Math.b2Vec2;
BodyDef = Box2D.Dynamics.b2BodyDef;
Body = Box2D.Dynamics.b2Body;
FixtureDef = Box2D.Dynamics.b2FixtureDef;
Fixture = Box2D.Dynamics.b2Fixture;
World = Box2D.Dynamics.b2World;
MassData = Box2D.Collision.Shapes.b2MassData;
PolygonShape = Box2D.Collision.Shapes.b2PolygonShape;
CircleShape = Box2D.Collision.Shapes.b2CircleShape;
DebugDraw = Box2D.Dynamics.b2DebugDraw;
RevoluteJointDef = Box2D.Dynamics.Joints.b2RevoluteJointDef;
```

Você pode encontrar as referências a estes métodos no manual.

Agora devemos criar uma classe que irá gerenciar o *Box2D*:

```javascript
PhysicsEngineClass = Class.extend({
    world: null,

    create: function (xGravity,yGravity,sleep) {
		// World takes two parameters:
		//
		// a Vec2(x,y) object specifying the gravity vector
		// a Boolean allowing sleep (true) or disallowing sleep (false)
        gPhysicsEngine.world = new World(new Vec2(xGravity,yGravity),sleep);
    }

});
```

O **world** referenciado aqui é o *mundo* em que os objetos estarão interagindo. Você pode criar vários mundos, mas um é o bastante (é possível mudar as características deste mundo). Primeiro você passa a gravidade, que recebe um valor x (gravidade horizontal) e outro y (gravidade vertical), sendo que x positivo é para a direita e y positivo é para cima. Depois você passa um valor booleano que indica se os objetos podem *dormir* ou não (durante o *sono*, o motor físico é desligado para o objeto).

###Steps

No *Box2D*, o método **update** do objeto world se chama **Step**. Esse método recebe três parâmetros:

- Um framerate (pode colocar como 1.0/60.0 se o jogo rodar a 60 quadros por segundo);
- A velocidade das interações (10 é um bom valor);
- A quantidade de interações (10 é um bom valor);

