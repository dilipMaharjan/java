package jms.pubsub.security;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import jms.pubsub.model.Employee;

public class SecurityApp {
	public static void main(String[] args) {
		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {
			
			InitialContext context = new InitialContext();
			Topic topic = (Topic) context.lookup("topic/employeeTopic");
			
			JMSConsumer consumer = jmsContext.createConsumer(topic);
			Message message = consumer.receive();
			
			Employee employee = message.getBody(Employee.class);
			System.out.println(employee.getFirstName() + " " + employee.getLastName());

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
