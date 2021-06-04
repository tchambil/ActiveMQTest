package com.ejemplo.app.activeproducer;

import com.ejemplo.app.activelib.SessionManager;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 *
 * @author olmedo.arcila
 *
 */
public class CyclicProducer extends Thread {

    private final int cicleEnd;
    private int cicleCounter;
    private SessionManager manager;
    private String[] channels;

    public CyclicProducer(int cicleEnd, String url, String[] channels) {
        this.cicleEnd = cicleEnd;
        cicleCounter = 0;
        this.channels = channels;

        try {
            manager = new SessionManager(url, null);
        } catch (JMSException ex) {
            Logger.getLogger(CyclicProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            MessageProducer cicleProducer = manager.createProductor(channels[0]);
            MessageProducer counterProducer = manager.createProductor(channels[1]);

            while (true) {
                Thread.sleep(1000);
                Date date = new Date();
                String text = String.format("{name:'ciclo',cicle:%d,date:'%s'}", cicleCounter, date);
                TextMessage message = manager.createMessage(text);
                counterProducer.send(message);
                System.out.println(CyclicProducer.class.getSimpleName() + "::Ciclo: " + cicleCounter);
                cicleCounter++;
                if (cicleCounter == cicleEnd) {
                    cicleCounter = 0;
                    cicleProducer.send(manager.createMessage("FIN_CICLO"));
                    System.out.println(CyclicProducer.class.getSimpleName() + "::Fin Ciclo");
                }
            }
        } catch (InterruptedException | JMSException ex) {
            Logger.getLogger(CyclicProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
