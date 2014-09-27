Anotações do tutorial javascript do site codecademy.com

[TOC]

----------------------------------------------------------------------
#**Funções**

Sintaxe básica: 
```javascript 
var nomeDaFuncao = function (parametros) 
{ 
	//codigo 
}; 
```

-----------------------------------------------------------------------
#**Objetos**

Sintaxe básica (notação literal): 
```javascript 
var nomeDoObjeto = { 
	propriedade1:valor, 
	propriedade2:valor 
}; 
``` 
Usando um construtor: 
```javascript 
var nomeDoObjeto = new Object(); 
``` 
Criando e preenchendo uma nova propriedade: 
```javascript 
nomeDoObjeto.propriedade3 = valor; 
``` 
Ou ainda: 
```javascript 
nomeDoObjeto["propriedade3"]=valor; 
``` 
Um objeto com método: 
```javascript 
var nomeDoObjeto = { 
	propriedade1:valor, 
	metodo:function() 
	{ 
		//codigo 
	} 
}; 
``` 
Definindo um novo método para um objeto: 
```javascript 
nomeDoObjeto.metodo2 = function() 
{ 
	//codigo 
}; 
``` 
Usando um método: 
```javascript 
nomeDoObjeto.metodo(); 
``` 
Para acessar propriedades do próprio objeto, use a palavra **this**. 
 
Criando classes: 
```javascript 
function nomeClasse(parametro1,parametro2) 
{ 
	this.parametro1 = parametro1; 
	this.parametro2 = parametro2; 
	this.metodo = function() 
	{ 
		//codigo 
	}; 
} 
``` 
Usando classes para criar objetos: 
```javascript 
var nomeDoObjeto = new nomeClasse(argumento1,argumento2); 
``` 
Adicionando métodos a uma classe (e a todos os objetos dela): 
```javascript 
nomeClasse.prototype.metodo = function() 
{ 
	//código 
}; 
``` 
Como fazer uma classe herdar propriedades e métodos de outra classe: 
```javascript 
function nomeClasse2 (parametro) 
{ 
	//propriedades e métodos 
} 
nomeClasse2.prototype = new nomeClasse1(); // classe 2 herda de 1 
``` 
Observação: propriedades e métodos que não foram redefinidos continuam iguais aos da classe herdada. 
 
Por padrão, as propriedades e métodos de uma classe são públicos. Para tornar uma propriedade ou método privado: 
```javascript 
function nomeClasse(parametro) 
{ 
	this.propriedade1:valor; // acesso público 
	var propriedade2=valor; // privado 
	this.metodo1=function() 
	{ 
		//código 
	}; // método público 
	var metodo2=function() 
	{ 
		//código 
	};// método privado 
} 
```

------------------------------------------------------------------------
#**Extras**

Funções matemáticas: 
```javascript 
Math.floor(); 
Math.random(); 
``` 
Retorna o tipo de algo no javascript: 
```javascript 
typeof algumaCoisa; 
``` 
Retorna se um objeto possui determinada propriedade (*true* se sim): 
```javascript 
nomeDoObjeto.hasOwnProperty('nomeDaPropriedade'); 
``` 
Percorrendo as propriedades de um objeto: 
```javascript 
for(var propriedade in nomeObjeto) 
{ 
	//codigo 
} 
``` 
Percorrendo os valores das propriedades de um objeto: 
```javascript 
for(var propriedade in nomeObjeto) 
{ 
	nomeObjeto[propriedade]; 
} 
```

