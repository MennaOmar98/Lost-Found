

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.IOUtils;

public class Posts_Interface {

    Account User_Account;
    Post_Services Post_Serv = new Post_Services();

    Posts_Interface() {

    }

    Posts_Interface(Account account) {
        User_Account = account;
    }

    public void Verify() {

    }

    public void Check_Verification() {

    }

    public void Print_Forms() {

    }

    public void Confirm() {

    }

    public void Decline() {

    }
}
