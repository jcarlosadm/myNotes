Tutorial para instalar allegro4.4:
https://www.allegro.cc/forums/thread/602646

Compilar allegro4.4:
```
gcc -W -Wall -s -O2 -pipe arquivo.c -o arquivo -lalleggl `allegro-config --libs` -lGL -lGLU
```

Integração com eclipse:
http://wiki.allegro.cc/index.php?title=Eclipse

Digitando allegro-config --static:
```
-L/usr/local/lib -lalleg -lm -lpthread -lSM -lICE -lX11 -lXext -lXext -lasound -ljack -lpthread -lrt -ldl
```
