# Proyecto ActiveCounter

ActiveProducer es un proyecto escrito en Java y usa maven, esta encargado realizar la conexión con el servidor de ActiveMQ, mediante la librería definida en el proyecto ActiveLib.
El programa ActiveCounter recibe por el canal "CHANNEL.CYCLE", los mensajes que se generan en el productor cade vez que el ciclo de conteo termina.
El IDE utilizado es NetBeans, pero por ser un proyecto que usa como administrador de archivos a maven, puede ser usado en otros IDE, como eclipes, IntelliJ, VS Code.

## Configuracion Maven

El proyecto esta registrado bajo el group com.ejemplo.app y el artefacto ActiveCounter, como se muestra en el archivo pom.xml.

```
<groupId>com.ejemplo.app</groupId>
<artifactId>ActiveCounter</artifactId>
<version>1.0-SNAPSHOT</version>
```

Para el uso la libreria de ActiveMQ, utilizan las dependencias de maven, como se muestra abajo.

```
<dependencies>
    <dependency>
        <groupId>com.ejemplo.app</groupId>
        <artifactId>ActiveLib</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```
