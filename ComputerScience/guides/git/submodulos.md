Para adicionar outros projetos dentro de seu próprio projeto, vá até a pasta de seu projeto e digite algo como:

git submodule add git@mygithost:billboard lib/billboard

Onde git@mygithost:billboard é a url do repositório que você deseja adicionar, e lib/billboard é a pasta do seu projeto em que você deseja colocar os arquivos do submódulo

Para atualizar o submódulo, use:

git submodule update
cd lib/billboard/
git checkout master
git pull

Para clonar o seu projeto com todos os submódulos:

git clone urlmeuprojeto --recursive

Se esqueceu de usar a flag "--recursive"? use:

git submodule update --init
