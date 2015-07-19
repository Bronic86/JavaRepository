package module3.laba7.receiver1;


import java.util.ArrayList;

public interface ReceiverDAO {

    Receiver getReceiver(int num);

    ArrayList<Receiver> getReceivers();

    int addReceiver(Receiver receiver);

}