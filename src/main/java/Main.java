import org.apache.activemq.broker.BrokerService;

import javax.jms.JMSException;

public class Main {

    public static void main(String[] args) throws JMSException, InterruptedException {
        if(args.length == 0) {
            System.out.println("Pase el parametro correspondiente...");
            return;
        }

        int opcion = Integer.parseInt(args[0]);

        if(opcion == 1){
            System.out.println("Inicializando Servidor JMS...");
            try {
                BrokerService broker = new BrokerService();
                broker.addConnector("tcp://0.0.0.0:61616");
                broker.start();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if(opcion == 2){
            int idDisp = 0;
            idDisp = Integer.parseInt(args[1]);
            if(idDisp > 0){
                for(int i=0; i<5; i++){
                    System.out.println("Iniciando productor...");
                    new Productor().enviarMensaje("notificacion_sensores", idDisp);
                    Thread.sleep(2000);
                }
                return;
            } else {
                System.out.println("Debe pasar un parametro para el ID");
            }
        }
    }
}
