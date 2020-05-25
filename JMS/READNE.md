Create Message Broker 
    - cd into apache-artemis-2.12.0/bin
    - run ./artemis create /path nameofthebroker
    - cd into /path/nameofthebroker/bin
    - run ./artemis run to start the broker

Configure JNDI
    - create a jndi.properties file
    - set
        - java.naming.factory.initial=org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory
        - connectionFactory.ConnectionFactory=tcp://localhost:61616
        - queue.queue/myQueue=MyQueue 
        - topic.topic/myTopic=MyTopic 

Components of JMS 1.X
    - CoonectionFactory
        - Provided by JMS provider 
    - Destination 
        - Provided by JMS provider
        - Queue for point to point messaging 
        - Topic for publish subscribe messaging  
    - ConecctionFactory and Destination are accessed through jndi 
    - Connection 
        - Connection is acquired from ConecctionFactory
    - Session 
        - Session is acquired from Connection 
        - It is a unit of work 
        - Can create any number of sessions
    - Message
        - Can create message from the session 
    - Message Producer 
        - can create Message Producer from session 
        - can send message
    - Message Consumer
        - can create Message Consumer from session 
        - can receive message  

Message 
    - All the data or events are communicated through message.
    - Message Headers
        - Meta data
        - Provide set header
            - JMSDestination
            - JMSDeliverMode
            - JMSMessagedId
            - JMSTimestamp
            - JMSExpiration
            - JMSRedelivered
            - JMSPriority

        - Consumer set header
            - JMSReplyTo
            - JMSCorrelationID
            - JMSType

    - Message Properties
        - Application specific 
            - setXXXProperty
            - getXXXProperty
        - Provider Specific
            - JMSXUserId
            - JMSXAppID
            - JMSXProducerTXID
            - JMSXRcvTimestamp
            - JMSDeliveryCount
            - JMSXState
            - JMSXGroupID
            - JMSXGroupSeq

    - MessageBody/payload 

    - types of messages
        - TextMessage
        - ByteMessage
        - ObjectMessage
        - MapMessage
        - StreamMessage

Point to Point (P2P)
    - Used for one to one communication
    - Use for ease of interoperability
    - Used for throughput/ performance 
    - Queue Browser is only available for P2P 



