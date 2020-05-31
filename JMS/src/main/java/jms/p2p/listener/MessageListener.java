package jms.p2p.listener;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import jms.p2p.model.Patient;

public class MessageListener implements javax.jms.MessageListener {

	@Override
	public void onMessage(Message message) {

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {

			InitialContext context = new InitialContext();
			Queue replyQueue = (Queue) context.lookup("queue/replyQueue");
			MapMessage replyMessage = jmsContext.createMapMessage();

			Patient patient = message.getBody(Patient.class);
			System.out.println(patient);
			if (patient.getInsuranceProvider().equals("A")) {
				if (patient.getCopay() < 40 && patient.getAmountTobePaid() < 1000) {
					replyMessage.setBoolean("eligible", true);
				}
			} else {
				replyMessage.setBoolean("eligible", true);
			}

			JMSProducer producer = jmsContext.createProducer();
			producer.send(replyQueue, replyMessage);

		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
	}

}
