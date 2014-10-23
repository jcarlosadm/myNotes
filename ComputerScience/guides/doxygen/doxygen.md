Uso rápido do Doxygen
=======================

Em primeiro lugar, entre na pasta onde se encontram os arquivos fontes a serem documentados. Depois rode o seguinte comando:

```
doxygen -g config_file
```

Onde *config_file* é o nome do arquivo de configuração (pode ser qualquer outro). Abra o arquivo de configuração e mude algumas opções:

- OUTPUT_LANGUAGE: Deixe em **English**, ou mude para **Brazilian**
- EXTRACT_ALL: evita que você quebre a cabeça procurando por configurações específicas, habilitando documentação de todos os elementos. Coloque **YES**
- JAVADOC_AUTOBRIEF: coloque **YES** se deseja usar o estilo do javadoc.

Por último, para gerar a documentação, rode:

```
doxygen config_file arquivo.h
```

Onde *arquivo.h* é o arquivo que você irá documentar. Pronto, uma pasta *html* será gerada no diretório atual. Procure por um arquivo *index.html* e abra em qualquer navegador.

Existem vários exemplos de como o código deve ser documentado.
