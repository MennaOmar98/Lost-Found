

import java.util.Vector;

public class Message {
    
    public Account Sender;
    public Account Receiver;
    public Vector<String> Content;
    
    Message(){
        
    }
    
    Message(Account sender, Account receiver){
        Sender=sender;
        Receiver=receiver;
    }
}
