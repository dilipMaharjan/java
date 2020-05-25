package jms.pubsub.hr;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import jms.pubsub.model.Employee;

public class HRApp {

	public static void main(String[] args) {

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {
			InitialContext context = new InitialContext();
			Topic topic = (Topic) context.lookup("topic/employeeTopic");

			Employee employee = new Employee(100, "Aurther", "Gun", "Artist", "aurther@gun.com");

			JMSProducer producer = jmsContext.createProducer();
			producer.send(topic, employee);

			System.out.println("Message Sent!");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
