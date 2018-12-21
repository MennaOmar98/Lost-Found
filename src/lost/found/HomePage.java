

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
}
