package com.ejemplo.app.activelib;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author olmedo.arcila
 */
public class SessionManager {

    private final Connection connection;
    private final Session session;

    public SessionManager(String broker, ExceptionListener listener) throws JMSException {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(broker);
        // Create a Connection
        connection = connectionFactory.createConnection();
        connection.start();
        if (listener != null) {
            connection.setExceptionListener(listener);
        }
        // Create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    /**
     * Get the value of session
     *
     * @return the value of session
     */
    public Session getSession() {
        return session;
    }

    public Connection getConnection() {
        return connection;
    }

    public MessageProducer createProductor(String topic) throws JMSException {
        // Create the destination (Topic or Queue)
        Destination destination = session.createTopic(topic);
        // Create a MessageProducer from the Session to the Topic or Queue
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        return producer;
    }

    public TextMessage createMessage(String text) throws JMSException {
        return session.createTextMessage(text);
    }

    public MessageConsumer createConsumer(String topic) throws JMSException {
        Destination destination = session.createTopic(topic);
        return session.createConsumer(destination);
    }

    void close() throws JMSException {
        session.close();
        connection.close();
    }

}