#**XAMPP**

Faça o download do xampp para linux:
https://www.apachefriends.org/index.html

Instalação (mude o nome do arquivo):
```
sudo chmod +x xampp-linux-x64-1.8.2-2-installer.run
sudo ./xampp-linux-x64-1.8.2-2-installer.run
```

Definir senhas:
```
sudo /opt/lampp/lampp security
```

Inicializando o xampp:
```
sudo /opt/lampp/lampp start
```

Habilitar leitura e escrita:
```
sudo chmod 777 -R /opt/lampp/htdocs
```

Testar servidor local:
>Digite `localhost` na barra de endereço do navegador.

Para executar o *mysql* (as bases de dados criadas são colocadas em `/opt/lampp/var/mysql/`; por padrão o *root* vem sem senha, então quando pedir uma apenas tecle ENTER):
```
cd /opt/lampp/bin/
./mysql -u root -p
```

Você pode acessar o *phpAdmin*, digitando no navegador:
>`localhost/phpmyadmin` na barra de endereços


