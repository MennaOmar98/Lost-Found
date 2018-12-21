

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account_Model {

    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;

    Account_Model() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/Lost&Found?user=root&password=123456");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Insert(Account account) {
        String Query = "insert into Accounts(UserName,pass,Email,Age) values('" + account.get_Name() + "','" + account.get_Password() + "','" + account.get_Mail() + "'," + account.get_Age() + ")";
        try {
            Connect.prepareStatement(Query).executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Update(Account Old, Account New) {

    }

    public void Delete(Account account) {
        String Query = "delete from Accounts where Email='" + account.get_Mail() + "'";
        try {
            Connect.prepareStatement(Query).executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean Check(Account account) {
        String Query = "";
        if (account.get_Name() != null) {
            Query = "select * " + "from Accounts " + "where Email='" + account.get_Mail() + "'";
        } else {
            Query = "select * " + "from Accounts " + "where Email='" + account.get_Mail() + "' and pass='" + account.get_Password() + "'";
        }
        boolean Excists = false;
        try {
            resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                account.set_Name(resultSet.getString("UserName"));
                account.set_Age(resultSet.getInt("Age"));
                Excists = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            return true;
        } else {
            return false;
        }
    }

}
