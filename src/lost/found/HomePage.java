

import java.util.Scanner;

public class HomePage {

    Account User_Account;
    Account_Services Acc_Serv = new Account_Services();
    
    HomePage(){
        
    }
    
    HomePage(Account Account)
    {
        User_Account=Account;
    }
    public boolean Sign_Up(Account account) {
        boolean ForN = Acc_Serv.Sign_Up(account);
        if (!ForN) {
            return false;
        } else {
            User_Account = account;
            Show_Home_Page(account);
            return true;
        }
    }
    
    public boolean LogIn(Account account) {
        boolean ForN = Acc_Serv.Log_In(account);
        if (!ForN) {
            return false;
        } else {
            account=Acc_Serv.Read(account);
            Show_Home_Page(account);
            return true;
        }
    }

    public void Show_Home_Page(Account account) {
        User_Account=account;
        Posts_Interface PI = new Posts_Interface(User_Account);
        Messages_Interface MI = new Messages_Interface(User_Account);
        new Home_Page(account).setVisible(true);
    }

}
