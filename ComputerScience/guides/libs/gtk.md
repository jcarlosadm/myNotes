#**GTK e Glade**

Como instalar o *gtk3*:

```
sudo apt-get install libgtk-3-dev
```

Compilar *gtk3* no *gcc* (também funciona com *g++*):

```
gcc -Wall -g base.c -o base `pkg-config --cflags --libs gtk+-3.0`
```

Instale o *Glade* usando o gerenciador de instalação de sua preferência. Você pode criar interfaces com o *Glade* e exportar o arquivo *xml* (que terá a extensão **.glade**, mas se você abrir verá um arquivo *xml*), para ser usado com diversas linguagens. O exemplo abaixo é usando com a linguagem **C** e a biblioteca *gtk3*:

```c
/*
Save this file as main.c and compile it using this command
(those are backticks, not single quotes):
  gcc -Wall -g -o teste main.c `pkg-config --cflags --libs gtk+-3.0` -export-dynamic
  
Then execute it using:
  ./teste

http://www.micahcarrick.com/gtk-glade-tutorial-part-1.html
*/
#include <gtk/gtk.h>
#include <stdio.h>


void 
on_window_destroy (GtkWidget *object, gpointer user_data)
{
    gtk_main_quit ();
}


void hi_function(GtkWidget *object, gpointer user_data)
{
    printf("bye ^_^ \n");
    gtk_main_quit ();
}

int
main (int argc, char *argv[])
{
    // cria os ponteiros para o builder e widget
    GtkBuilder      *builder; 
    GtkWidget       *window;
    
    // inicia o gtk
    gtk_init (&argc, &argv);
    
    // cria o builder
    builder = gtk_builder_new ();
    // carrega o builder
    gtk_builder_add_from_file (builder, "teste.glade", NULL);
    // GTK_WIDGET retorna um widget do builder
    window = GTK_WIDGET (gtk_builder_get_object (builder, "window1"));
    // conecta todos os sinais do builder
    gtk_builder_connect_signals (builder, NULL);
    
    // não precisamos mais do builder
    g_object_unref (G_OBJECT (builder));
    
    // mostra a janela
    gtk_widget_show (window);
    
    // executa o processo principal
    gtk_main ();

    return 0;
}
```

Para usar *gtk3* em **C++**, recomenda-se primeiro ter alguma noção de *gtk3* para **C** e então aprender a usar a biblioteca **gtkmm 3**. Você pode instalar essa biblioteca com o comando:

```
apt-get install libgtkmm-3.0-dev
```

O *glade* também é compatível com o *gtkmm 3*. Para saber mais sobre o *gtkmm 3* e sua integração com o *glade*, visite:

https://developer.gnome.org/gtkmm/3.9/
https://developer.gnome.org/gtkmm-tutorial/stable/
https://developer.gnome.org/gtkmm-tutorial/unstable/sec-builder-loading-glade-file.html.en
