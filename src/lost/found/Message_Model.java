

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Message_Model {

    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;

    Message_Model() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/Lost&Found?user=root&password=123456");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Insert(Message message) {
    }

    public void Update(Message Old, Message New) {

    }

    public void Delete(Message message) {

    }

//    public boolean Check(Message message) {
//        
//    }
    public void Insert(String content) {
        
    }

//    public boolean Check(Account account) {
//
//    }
}
