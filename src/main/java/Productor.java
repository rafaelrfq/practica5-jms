import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Productor {
    public Productor(){}

    public void enviarMensaje(String cola, int idDisp) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://servidor:61616");
        Connection connection = factory.createConnection("admin","admin");
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(cola);
        MessageProducer producer = session.createProducer(topic);

        Mensaje msg = new Mensaje();
        msg.setIdDispositivo(idDisp);

        TextMessage message = session.createTextMessage(msg.getJson());
        producer.send(message);

        producer.close();
        session.close();
        connection.stop();
    }
}
