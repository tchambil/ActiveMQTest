package com.ejemplo.app.activeproducer;

/**
 *
 * @author olmedo.arcila
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "tcp://localhost:61616";
        String[] channels = {"CHANNEL.CYCLE", "CHANNEL.COUNTER"};
        CyclicProducer producer = new CyclicProducer(45, url, channels);
        producer.start();
    }

}
