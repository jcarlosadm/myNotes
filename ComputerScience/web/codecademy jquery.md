Anotações do tutorial jQuery do codecademy.com

[TOC]

--------------------------------------------------------------------------
#**Introduction to jQuery** 

jQuery é uma biblioteca *JavaScript*. Além de possuir uma série de funções prontas de manipulação do *DOM*, jQuery permite selecionar e adicionar elementos rapidamente. 
 
O jQuery usa o símbolo **\$** para manipulação de objetos do *DOM*. Para começar, devemos selecionar nossa página e fazer algo somente quando ela estiver totalmente carregada. 

```javascript
$(document).ready(function(){ 
	// faça algo 
}); 
```

O elemento do *DOM* entre parênteses do símbolo **$** deve estar entre aspas (como "*div*"), exceto pelo elemento **document**. 
 
Por exemplo, **fadeOut(*duração*)** é uma função que torna o elemento selecionado transparente. *Duração* é o seu argumento (em *milissegundos*). 

```javascript 
$(document).ready(function(){ 
	$("div").fadeOut(1000); 
}); 
``` 

Já **fadeTo(*velocidade*,*transparência*)** é uma função de animação que define uma transição de transparência em uma velocidade específica. Por exemplo: 

```javascript 
$(document).ready(function(){ 
	$("div").mouseenter(function(){ 
		$("div").fadeTo("fast",1); 
	}); 
	$("div").mouseleave(function(){ 
		$("div").fadeTo("fast",0.5); 
	}); 
}); 
```
 
Existe um método chamado **effect()** que possui diversos efeitos interessantes, entre eles o "*explode*", que literalmente explode o objeto. Outro efeito é "*bounce*", que faz o objeto pular algumas vezes (você deverá passar mais dois argumentos; veja a documentação para mais detalhes). Existe ainda o "*slide*", em que o objeto é aparece aos poucos da esquerda para a direita. 

----------------------------------------------------------------------
#**jQuery Functions and Selectors**

O **$()** torna o elemento *DOM* em um objeto jQuery. Todo objeto possui métodos (ou funções para objetos) que fazem algo acontecer. Logo, **ready()** é um método que dispara quando o elemento foi carregado totalmente. 
 
Dentro do método do objeto jQuery costumamos colocar uma função: **function(){}**. Onde dentro das chaves temos o código que será executado quando o método for disparado. 
 
Dentro dos parênteses de **\$()** você pode especificar qualquer elemento do *DOM*. O jQuery selecionará todos os elementos do tipo. Se você deseja selecionar de maneira diferente, então use seletores *CSS* entre aspas. Por exemplo, para selecionar um elemento com a **id** *ana*, você deverá usar **\$("#ana")**, ou para selecionar todos os elementos da classe *dog*, use **\$(".dog")**. 
 
Digamos que você selecione um ou mais elementos, e dentro da função que se refere este elemento você precise selecioná-lo novamente. Neste caso use **this**. Por exemplo: 

```javascript 
$(document).ready(function() { 
	$('div').click(function() { 
		$(this).fadeOut('slow'); 
	}); 
}); 
```

---------------------------------------------------------------------
#**Modifying HTML Elements**

##Adicionando e removendo elementos HTML 
 
Para criar elementos *HTML* basta criar uma variável e atribuir (igualar) a um objeto jQuery contendo o elemento *HTML*. 

```javascript 
var h1 = $("<h1>Hello!</h1>")
```
 
Você pode adicionar um elemento em outro elemento numa página usando **append** ou **prepend**. O método **append** adiciona o elemento como filho final do elemento alvo. O método **prepend** adiciona como filho inicial. 

```javascript 
$("body").append("<p>I'm a paragraph!</p>") 
$("body").prepend("<p>I'm a paragraph!</p>") 
```
 
O primeiro adiciona o parágrafo como último filho de **body**, enquanto que o segundo adiciona como primeiro filho. 
 
Você ainda pode usar **appendTo**, que é igual a **append**, mudando apenas a ordem do que é adicionado a quem: 

```javascript 
$("<p>I'm a paragraph!</p>").appendTo("body") 
```
 
O mesmo acontece com **prependTo**, similar a **prepend**. 
 
Você pode adicionar um elemento antes ou depois de outro elemento com o método **before()** ou **after()**, respectivamente. O exemplo abaixo insere um parágrafo após o elemento com **id** *one*. 

```javascript 
$(document).ready(function(){ 
    $("#one").after("<p>Ola</p>"); 
}); 
```
 
Os métodos **before()** e **after()** não servem apenas para inserir elementos antes ou depois de outros, mas também mover elementos antes ou depois de outros elementos. O exemplo abaixo move um elemento com **id** *two* para depois do elemento com **id** *one*: 

```javascript 
$(document).ready(function(){ 
    var two = $("#two"); 
    $("#one").after(two); 
}); 
```
 
Para remover elementos, jQuery possui a funções **remove()** e **empty()**. A função **empty()** remove o conteúdo do elemento selecionado (assim como elementos filhos), mas mantém esse elemento. A função **remove()** elimina o conteúdo (e elementos filhos) e o próprio elemento. Existe ainda um terceiro método **detach()**, que funciona como **remove()**, mas você pode gravar os dados em uma variável (basta igualar uma variável ao uso do método), para inserir novamente mais tarde, por exemplo. 
 
##Modificando Classes e Conteúdo 
 
Você pode adicionar e remover classes de elementos usando os métodos **addClass()** e **removeClass()**. 

```javascript 
$('#buttonId').addClass('buttonClass'); 
```
 
Tem um método em jQuery que permite adicionar uma classe se ela não existir e removê-la caso contrário. Se chama **toggleClass()**. 

```javascript 
$('#buttonId').toggleClass('buttonClass'); 
```
 
Para mudar a altura e largura de um elemento, jQuery possui os métodos **height()** e **width()**. 

```javascript 
$("div").height("100px"); 
```
 
Porém, jQuery tem um método geral para resolver isso: **css(*parâmetro css*, *valor desse parâmetro*)**. Por exemplo: 

```javascript 
$("div").css("background-color","red"); 
```
 
O método **html()** retorna o conteúdo do elemento selecionado se não usar argumento no método, ou muda o seu conteúdo caso contrário. O método abaixo muda o conteúdo de um parágrafo para o texto que aparece como argumento. 

```javascript 
$("p").html("jQuery magic in action!"); 
```
 
O método **val()** funciona como **html()**, mas é aplicado a elementos de formulários. Esse método retorna o valor do campo selecionado. 

```javascript 
var value = $('input:checkbox:checked').val(); 
var value2 = $('input[name=checkListItem]').val(); 
```
 
Quando você adiciona elementos, não dá para simplesmente usar **remove()** para removê-los depois, pois o documento foi carregado antes de serem adicionados. Para isso, é necessário usar o método **on()**, que recebe um evento, um seletor e uma função. 

```javascript 
$(document).on("click",".item",function(){ 
      $(this).remove(); 
}); 
```

------------------------------------------------------------------------
#**jQuery Events**

##Eventos do Mouse e Teclado 
 
Existe o evento **dblclick()** em jQuery que dispara quando há um clique duplo em um elemento. 

```javascript 
$("div").dblclick(function(){ 
        $(this).fadeOut("fast"); 
}); 
```
 
O evento **hover()**, que já vimos, é um evento que dispara quando o mouse entra na área do elemento. Acontece que **hover()** pode comportar duas funções como argumentos, separadas por uma vírgula. A primeira função é disparada quando entramos na área do elemento, a segunda quando deixamos a área do elemento. 

```javascript 
$("div").hover( 
    function(){ 
        $(this).addClass("active"); 
    }, 
    function(){ 
        $(this).removeClass("active"); 
    } 
); 
```
 
Você pode usar **focus()** em elementos de formulário para mudar alguma propriedade quando esse elemento ganha foco. 

```javascript 
$("input").focus(function(){ 
        $(this).css("outline-color","#FF0000"); 
}); 
```
 
Para o *teclado*, existe um evento chamado **keydown()**, que dispara quando uma tecla é pressionada. Esse evento requer apenas uma função, que dispara quando qualquer tecla é pressionada (se quiser tratar uma tecla específica, trate-a na função). 

```javascript 
$(document).ready(function(){ 
    $(this).keydown(function(){ 
        $("div").animate({left:"+=10px"},500); 
    }); 
}); 
```
 
Com tratamento de tecla específica: 

```javascript 
$(document).ready(function() { 
    $(document).keydown(function(key) { 
        switch(parseInt(key.which,10)) { 
			// Left arrow key pressed 
			case 37: 
				$('img').animate({left: "-=10px"}, 'fast'); 
				break; 
			// Up Arrow Pressed 
			case 38: 
				$('img').animate({top: "-=10px"}, 'fast'); 
				break; 
			// Right Arrow Pressed 
			case 39: 
				$('img').animate({left: "+=10px"}, 'fast'); 
				break; 
			// Down Array Pressed 
			case 40: 
				$('img').animate({top: "+=10px"}, 'fast'); 
				break; 
		}
    }); 
}); 
```

--------------------------------------------------------------------
#**jQuery Effects**

##jQuery UI Interactions 
 
A linguagem jQuery já facilita bastante a nossa vida. Ok, mas existem ainda uma coleção de métodos bem específicos que fazem coisas incríveis em jQuery: *jQuery UI*. 
 
Para menus que abrem e fecham quando você clica neles, e somente um está ativo ao mesmo tempo, temos o método **accordion()**, que tem dois argumentos básicos: *collapsible* (*true* ou *false*), e *active* (*true* ou *false*). O código abaixo foi aplicado em um **div** com **id** "*menu*", que possui três elementos **h3** diretos, cada com um **div** com um parágrafo. 

```javascript 
$(document).ready(function() { 
    $("#menu").accordion({collapsible: true, active: false}); 
}); 
```
 
Outro método interessante é **draggable()**, que permite que você arraste um elemento para qualquer lugar na página. 

```javascript 
$(document).ready(function(){ 
    $("#car").draggable(); 
}); 
```
 
O método **resizable()** permite que você possa ajustar o tamanho de um elemento no browse. 

```javascript 
$(document).ready(function(){ 
    $("div").resizable(); 
}); 
```
 
Para opções selecionáveis, use o método **selectable()**. Esse método, aplicado a um elemento **ol** ou **ul**, permite tornar os elementos **li** selecionáveis. É necessário especificar, na *CSS*, o que acontece com o elemento **li** que for selecionado (basta usar o seletor "*ol .ui-selected*", ou mude *ol* por *ul* se estiver usando lista não ordenada). 

```javascript 
$(document).ready(function(){ 
    $("ol").selectable(); 
}); 
```
 
O método **sortable()** também pode ser aplicado a listas, e permite que o usuário possa ordenar os elementos como desejar. 

```javascript 
$(document).ready(function(){ 
    $("ol").sortable(); 
}); 
```


