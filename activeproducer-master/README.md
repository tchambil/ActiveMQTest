# Proyecto ActiveProducer

ActiveProducer es un proyecto escrito en Java y usa maven, esta encargado realizar la conexión con el servidor de ActiveMQ, mediante la librería definida en el proyecto ActiveLib.
El programa ActriveProducer simula un generador de segundos con un limite de ciclo. El programa se conecta con el servidor y por medio de dos canales envía diferente información. Por el canal llamado "CHANNEL.COUNTER" se envían los mensajes de los datos correspondientes a cada segundo, mientras que por el canal llamado "CHANNEL.CYCLE" se envia un mensaje cada que termina el ciclo.
El IDE utilizado es NetBeans, pero por ser un proyecto que usa como administrador de archivos a maven, puede ser usado en otros IDE, como eclipes, IntelliJ, VS Code.

## Configuracion Maven

El proyecto esta registrado bajo el group com.ejemplo.app y el artefacto ActiveProducer, como se muestra en el archivo pom.xml.

```
<groupId>com.ejemplo.app</groupId>
<artifactId>ActiveProducer</artifactId>
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
