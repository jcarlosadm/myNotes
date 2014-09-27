Explicando resumidamente: você deseja colocar o repositório A como subpasta do repositório B.

Em primeiro lugar, duplique o repositório para outro lugar, evitando assim que erros durante o processo possam afetar o seu repositório original.

No repositório A duplicado (no lugar de 'repoA' você poderá usar qualquer outro nome; esse nome será o nome da pasta no outro repositório):

mkdir repoA
(copie cada arquivo/pasta com o comando cp para o diretório)
(use 'git rm' para cada arquivo/pasta que não estão na pasta 'repoA'; não remova a pasta 'repoA'!)
git add . (ou adicione manualmente todos os arquivos da pasta 'repoA')
git commit
git push origin master

No repositório destino, em que colocaremos o repositório A duplicado como subpasta:

git remote add repo-a-branch ../repoA/ (em ../repoA/ apenas voltamos uma pasta e entramos na pasta do projeto repoA)
git pull repo-a-branch master
(se os arquivos do repositório A aparecem de forma inadequada, remova-os com 'git rm')
git push origin master

Pronto, o repositório B terá o repositório A como subdiretório, de forma idenpendente. Pode excluir o repositório A duplicado e, se desejar, até mesmo o repositório A original.
