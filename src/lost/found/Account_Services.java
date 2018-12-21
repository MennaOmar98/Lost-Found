

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account_Services {

    Account_Model Acc_Model = new Account_Model();

    public boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    public boolean Sign_Up(Account account) {
        boolean valid = false;
        if ((isValid(account.get_Mail())) && (account.get_Age() >= 18)) {
            valid = true;
        }
        if (valid) {
            boolean check = false;
            check = Acc_Model.Check(account);
            if (check) {
                return false;
            } else {
                Acc_Model.Insert(account);
                return true;
            }
        } else {
            return false;
        }
    }
    
    public boolean Log_In(Account account) {
        boolean check = false;
        check = Acc_Model.Check(account);
        if (check) {
            return true;
        } else 
            return false;
    }
    
    public Account Read(Account account)
    {
        Account acc=Acc_Model.Read(account);
        return acc;
    }

//
//    public boolean Update(Account Old, Account New) {
//
//    }

//    public boolean Validate(Account account){
//        
//    }
}
