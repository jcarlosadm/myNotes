#**Usando o vim**

Antes de começar a usar, configure criando um arquivo *.vimrc* na sua pasta de usuário (`/home/suapasta/`), para que o vim possa usar indentação e espaços ao invés de tabulação:

```vim
set smartindent
set tabstop=4
set shiftwidth=4
set expandtab

inoremap {      {}<Left>
inoremap {<CR>  {<CR>}<Esc>O
inoremap {{     {
inoremap {}     {}

inoremap (      ()<Left>
inoremap (<CR>  (<CR>)<Esc>O
inoremap ((     (
inoremap ()     ()

inoremap [      []<Left>
inoremap [<CR>  [<CR>]<Esc>O
inoremap [[     [
inoremap []     []
```

Qualquer problema é só copiar o conteúdo do arquivo `/etc/vim/vimrc` para esse arquivo e adicionar as linhas acima.

Você pode abrir um arquivo no vim digitando:

```
vim nomedoarquivo
```

Para entrar em modo de inserção, digite `i` com o arquivo aberto. Para sair do modo de inserção, digite a tecla *ESC*.

Para sair do arquivo, saia do modo de inserção (se estiver nele) e digite `:q`. Para sair do arquivo e salvar as alterações (se você tiver alterado algo), digite `:wq`. Para salvar o arquivo sem sair, digite `:w`.

Para autocompletar, use as teclas *Ctrl-N* ou *Ctrl-P*.
