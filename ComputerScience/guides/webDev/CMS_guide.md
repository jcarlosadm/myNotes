A maioria dos *CMS* se instalam de maneira parecida.

#Instruções gerais

Antes de seguir essas instruções, veja as particularidades de cada *CMS*.

1. Execute o *xampp* (isso é, inicie os serviços apache+mysql+servidor ftp).
2. Defina um nome para o site/blog/projeto.
3. Agora entre no *phpmyadmin* do *xampp* (http://localhost/phpmyadmin/)
4. Crie uma nova base de dados com o nome do blog/site/projeto, e no menu suspenso chamado **collation**, escolha a opção *utf8_unicode_ci*.
5. Baixe a última versão estável do *CMS* de sua preferência.
6. Descompacte e renomeie a pasta com o nome do seu blog/site/projeto.
7. Copie a pasta para a pasta *htdocs* do *xampp*.
8. Mude as permissões da pasta (permitindo leitura, execução e escrita para todos) e digite no navegador http://localhost/caminho-para-a-pasta do seu blog/site/projeto.
9. Siga as instruções. Qualquer erro pode ser devido a permissões dos novos arquivos gerados. É só alterar as permissões.

##Wordpress

1. Antes de do passo 8 das instruções gerais, vá na pasta raiz do seu blog/site/projeto e procure pelo arquivo **wp-config-sample.php**.
2. Abra o arquivo e onde houver `define('DB_NAME', 'onomedoseubdaqui')`, mude **onomedoseubdaqui** pelo nome do banco de dados criado no passo 4 das instruções gerais (que deverá coincidir com o nome do projeto).
3. Onde houver `define('DB_USER', 'nomedeusuarioaqui')`, mude **nomedeusuarioaqui** por **root** (ou outro usuário com privilégios de edição do banco de dados criado).
4. Onde houver `define('DB_PASSWORD', 'suasenhaaqui')`, mude **suasenhaaqui** pela senha do usuário que pode modificar o banco de dados (no caso do **root** deixe vazio; mas mantenha as aspas).
5. Salve uma cópia do arquivo como **wp-config.php** no mesmo local.
6. Volte ao passo 8 das intruções gerais.

##Joomla

A única dificuldade do *Joomla* é que no final pode dar algum erro na criação de um arquivo de configuração, devido as permissões da pasta. Mude as permissões da pasta e siga as instruções da tela. Após criar o arquivo de configuração, pode deletar a pasta de instalação, como recomendado. Você pode alterar o idioma do *Joomla* no seu menu.

##Drupal

Antes de mais nada, você precisa baixar o arquivo de idioma do *Drupal* separadamente. E precisa carregar o arquivo durante a instalação. Também tenha certeza de dar permissões de leitura, escrita e execução na pasta do projeto. Siga atentamente todas as instruções que não haverá problemas.
