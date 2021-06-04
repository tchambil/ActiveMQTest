package com.ejemplo.app.activecounter;

import com.ejemplo.app.activelib.SessionManager;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

/**
 *
 * @author olmedo.arcila
 */
public class RegularConsumer extends Thread {

    private final String channelName;
    private SessionManager manager;

    public RegularConsumer(String url, String channelName) {
        this.channelName = channelName;

        try {
            manager = new SessionManager(url, null);
        } catch (JMSException ex) {
            Logger.getLogger(RegularConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        super.run();

        try {
            MessageConsumer consumer = manager.createConsumer(channelName);

            while (true) {
                Message message = consumer.receiveNoWait();

                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Received: (" + channelName + ")" + text + " " + new Date());
                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(RegularConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
