

import java.sql.Blob;

public class Form {
    
    Account User_Account;
    String Description;
    Blob Picture;
    
    Form(){
        
    }
    
    Form(Account account,String Desc,Blob pic){
        User_Account=account;
        Description=Desc;
        Picture=pic;
    }
    
}
