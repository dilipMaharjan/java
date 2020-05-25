package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstQueue {
	public static void main(String[] args) {
		InitialContext initailContext = null;
		Connection connection = null;
		try {
			initailContext = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) initailContext.lookup("ConnectionFactory");
			connection = cf.createConnection();
			Session session = connection.createSession();
			Queue queue = (Queue) initailContext.lookup("queue/myQueue");

			// producer
			MessageProducer producer = session.createProducer(queue);
			TextMessage messageToSend = session.createTextMessage("Text Message");
			producer.send(messageToSend);
			System.out.println("Message Sent : " + messageToSend.getText());
			// consumer
			MessageConsumer consumer = session.createConsumer(queue);
			connection.start();
			TextMessage messageToReceive = (TextMessage) consumer.receive(5000);
			System.out.println("Message Received : " + messageToReceive.getText());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (null != initailContext) {
				try {
					initailContext.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
