Esse é um guia de uso do **GIT** no **ubuntu**.

#Instalando o GIT

Antes de qualquer coisa, você precisa instalar o GIT.
```
apt-get install git
```
Depois você precisa configurar o seu nome e email:
```
git config --global user.name "Your Name"
git config --global user.email codexico@gmail.com
```
Você pode usar esse usuário e email para todo e qualquer repositório, de qualquer origem. Ou seja, só precisa fazer isso uma vez, mesmo que use github e googlecode ao mesmo tempo.

#GIT + Googlecode

Em primeiro lugar, você precisa criar um novo projeto no google code. Tem como você criar localmente e enviar remotamente, mas prefiro criar diretamente no google code primeiro.

Basta ir no site do Google Code e criar um novo projeto com git. Depois é só clicar em **Source** e será apresentado um comando para clonar o projeto numa pasta local. Copie esse comando.

Agora abra o *prompt* e navegue até um local apropriado para o seu projeto (recomendo o **dropbox**; até o momento não encontrei problemas de conflito que alguns afirmam existir). Digite o comando copiado do projeto do googlecode (ou simplesmente cole no terminal). Ok, agora entre na pasta.

O seu projeto estará vazio. Na verdade, tem uma pasta oculta com o nome **.git**, que contém as configurações do projeto (inclusive endereço do repositório; **NÃO** entre ou modifique/delete essa pasta, nem seu conteúdo, ela é de vital importância para o projeto). Bom, o seu projeto está vazio. Quando tiver adicionado os primeiros arquivos, você precisa adicionar esses arquivos no git. Há duas maneiras: todos os arquivos da pasta ou apenas alguns deles. É recomendável enviar somente códigos fonte, e evitar arquivos grandes e/ou imutáveis, como imagens. Também evite arquivos específicos de *IDEs* (como *Eclipse*), a menos que todos da equipe concordem em usar a mesma ferramenta (mas pense bem sobre isso: membros da equipe podem mudar, portanto não impeça que cada um use suas ferramentas preferidas).

Adicionando tudo:
```
git add *
```
Adicionando apenas alguns arquivos:

```
git add arquivo1.c arquivo2 arquivo3.h
```

Agora que já adicionou os arquivos, vamos fazer o commit, que é pegar todos os arquivos e adicionar um comentário. Esse comentário é obrigatório:

```
git commit -m "comentario"
```

Bom, mas ainda você não enviou os arquivos. Para isso, em primeiro lugar você vai precisar da sua senha pessoal do google code (procure nas configurações de usuário). Agora digite:
```
git push origin master
```

O git pedirá a senha do google code (apenas cole a senha copiada). Você pode trocar **master** por outro ramo no seu repositório, mas é preciso estar ciente de como gerenciar isso (usar *branches* só é recomendável quando se faz grandes alterações no código, o que pode afetar a maior parte do código da equipe; é uma boa ideia pesquisar sobre isso).

E depois? Bom, antes de começar a trabalhar é bom baixar a última versão do repositório (isso é recomendável todas as vezes que você for começar a trabalhar):
```
git pull
```

Procure não acumular muitas alterações antes de enviar algo. De qualquer maneira, você pode verificar conflitos ao usar o comando **pull**. Como resolvê-los? Existem diversas maneiras para isso. Eu prefiro resolver manualmente (no caso de conflito, o git informa esses conflitos no código fonte onde ele ocorre) e fazer o commit como segue:

```
commit -a -m "mensagem"
```

Ao invés de **pull** você pode usar **checkout**. Esse comando é útil quando temos ramificações do projeto no repositório (lembra quando falei do caso de você fazer grandes modificações no código?).

#GIT + GitHub

Primeiro crie o repositório no Github. Do lado direito do repositório, você terá um link para fazer o clone numa pasta local. Bom, copie esse link.

Na sua pasta local, digite:

```
git clone link
```

Onde *link* é o link que você copiou. Você não precisa de senha para fazer o clone.

Entre na pasta (usando o comando **cd**). Adicione arquivos nesta pasta, e quando estiver pronto use o comando **add** para adicionar os arquivos para fazer o commit:
```
git add *
```

O comando acima adiciona todos os arquivos da pasta. Para adicionar apenas alguns arquivos, não digite *****, trocando-o pelos arquivos que você quer enviar.

Agora use o comando **commit**:

```
git commit -m "mensagem"
```

Depois é só usar o comando **push**:
```
git push origin master
```

Antes de começar a trabalhar, é uma boa ideia usar o comando **pull**:

```
git pull
```

O que atualizará a sua pasta local com as últimas modifcações.

Por enquanto é isso. Existe ainda a possibilidade de criar branches. O processo é o mesmo para o googlecode e git. Mas isso é assunto para outro guia.