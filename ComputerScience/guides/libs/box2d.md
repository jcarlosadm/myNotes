#Biblioteca Box2D para c++

Primeiro, baixe a versão mais recente desta biblioteca. Depois descompacte e entre na pasta. Crie um diretório **build**, entre nele e execute:

```
cmake ..
make
```

Bom, agora começa o caminho que ninguém informa. Primeiro instale no sistema (talvez você precise informar ao sistema algumas opções antes):
```
sudo make install
```

Depois você precisa copiar uma pasta e um arquivo para outra pasta cada um:
```
sudo cp -R /usr/local/include/Box2D/ /usr/include/
sudo cp -R /usr/local/lib/libBox2D.a /usr/lib/
```

Depois é só compilar o o projeto com a opção *-lBox2D*.
