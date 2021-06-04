package com.ejemplo.app.activecounter;

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
        RegularConsumer consumer = new RegularConsumer(url, "CHANNEL.COUNTER");
        RegularConsumercicle consumerCicle = new RegularConsumercicle(url, "CHANNEL.CYCLE");
        consumerCicle.start();
        consumer.start();
    }

}
