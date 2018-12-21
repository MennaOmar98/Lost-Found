

import java.util.Date;
import java.util.Vector;

public class Post {
    int Post_ID;
    java.sql.Date Date_Of_Post;
    Account User;
    Item Item;
    //Account Verified_Account;
    //Vector <Form> Verifications;
        
    Post(){
        User=new Account();
        Item=new Item();
    }
    Post(java.sql.Date date, Account user, Item item){
        Date_Of_Post=date;
        User=user;
        Item=item;
    }

    @Override
    public String toString() {
        return "Post{" + "Date_Of_Post=" + Date_Of_Post + ", User=" + User + ", Item=" + Item + /*", Verified_Account=" + Verified_Account + ", Verifications=" + Verifications + */'}';
    }
}
