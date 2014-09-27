Retirado de: http://www.vivaolinux.com.br/dica/Instalando-Java-no-Ubuntu

Para instalar *java*:

1.Execute os comandos: 

```
sudo apt-get install openjdk-6-jre
sudo apt-get install openjdk-7-jre
sudo apt-get install openjdk-6-jdk
sudo apt-get install openjdk-7-jdk
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java7-installer 
```

2.Depois cheque os seguintes comandos, respectivamente: 

```
java -version
javac -version 
```

Deve aparecer algum resultado, respectivamente: 

```
java version "1.7.0_09"
Java(TM) SE Runtime Environment (build 1.7.0_09-b05)
Java HotSpot(TM) Server VM (build 23.5-b02, mixed mode)
```

```
javac 1.7.0_09
```
