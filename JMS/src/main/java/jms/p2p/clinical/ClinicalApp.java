package jms.p2p.clinical;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import jms.model.Patient;

public class ClinicalApp {
	public static void main(String[] args) throws NamingException {
		InitialContext context = new InitialContext();
		Queue requestQueue = (Queue) context.lookup("queue/requestQueue");
		Queue replyQueue = (Queue) context.lookup("queue/replyQueue");

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {

			// send message
			JMSProducer producer = jmsContext.createProducer();
			Patient patient = new Patient(1, "John", "A", 30l, 500l);
			producer.send(requestQueue, patient);

			// receive message

			JMSConsumer consumer = jmsContext.createConsumer(replyQueue);
			MapMessage message = (MapMessage) consumer.receive(3000);
			System.out.println(message.getBoolean("eligible"));

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
