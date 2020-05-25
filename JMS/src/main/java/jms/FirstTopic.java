package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstTopic {
	public static void main(String[] args) {

		InitialContext initailContext = null;
		Connection connection = null;
		try {
			initailContext = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) initailContext.lookup("ConnectionFactory");
			connection = cf.createConnection();
			Session session = connection.createSession();
			Topic topic = (Topic) initailContext.lookup("topic/myTopic");

			// producer
			MessageProducer producer = session.createProducer(topic);
			TextMessage messageToSend = session.createTextMessage("Topic Message");
			producer.send(messageToSend);
			System.out.println("Message Sent : " + messageToSend.getText());

			// consumer
			MessageConsumer consumer1 = session.createConsumer(topic);
			MessageConsumer consumer2 = session.createConsumer(topic);
			MessageConsumer consumer3 = session.createConsumer(topic);
			connection.start();
			TextMessage messageToReceive1 = (TextMessage) consumer1.receive();
			TextMessage messageToReceive2 = (TextMessage) consumer2.receive();
			TextMessage messageToReceive3 = (TextMessage) consumer3.receive();

			System.out.println("Message Received 1 : " + messageToReceive1.getText());
			System.out.println("Message Received 2 : " + messageToReceive2.getText());
			System.out.println("Message Received 3 : " + messageToReceive3.getText());

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
