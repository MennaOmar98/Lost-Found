

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Post_Model {

    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;

    Post_Model() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/Lost&Found?user=root&password=123456");
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void Insert(Post post) {
        String Query;
        if (post.Item.Status == true)
            Query = "insert into Posts(Date_Of_Post,UserName,User_Email,Category,Place,Desc_ription,State,Date_of_lost_or_found,Picture) values('" + post.Date_Of_Post + "','" + post.User.get_Name() + "','" + post.User.get_Mail() + "','" + post.Item.Category + "','" + post.Item.Place + "','" + post.Item.Description + "','Found','" + post.Item.Date_Of_Lost_or_Found + "','" + post.Item.Picture + "')";
        else 
            Query = "insert into Posts(Date_Of_Post,UserName,User_Email,Category,Place,Desc_ription,State,Date_of_lost_or_found,Picture) values('" + post.Date_Of_Post + "','" + post.User.get_Name() + "','" + post.User.get_Mail() + "','" + post.Item.Category + "','" + post.Item.Place + "','" + post.Item.Description + "','Lost','" + post.Item.Date_Of_Lost_or_Found + "','" + post.Item.Picture + "')";
        try {
            Connect.prepareStatement(Query).executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void read_resultSet(Vector<Post> posts) {
        try {
            while (resultSet.next()) {
                Post post = new Post();
                post.Post_ID = resultSet.getInt("Post_ID");
                post.Date_Of_Post = resultSet.getDate("Date_Of_Post");
                post.User.set_Name(resultSet.getString("UserName"));
                post.User.set_Mail(resultSet.getString("User_Email"));
                post.Item.Category = resultSet.getString("Category");
                post.Item.Date_Of_Lost_or_Found = resultSet.getDate("Date_of_lost_or_found");
                post.Item.Description = resultSet.getString("Desc_ription");
                post.Item.Place = resultSet.getString("Place");
                String status = resultSet.getString("State");
                if (status.equals("Lost")) {
                    post.Item.Status = false;
                } else {
                    post.Item.Status = true;
                }
                post.Item.Picture = resultSet.getBlob("Picture");
                posts.addElement(post);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Post_Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Vector<Post> Check(boolean Status) {
        String Query;
        if (Status == false) {
            Query = "select * from Posts where State='Lost'";
        } else {
            Query = "select * from Posts where State='Found'";
        }
        Vector<Post> posts = new Vector();
        try {
            resultSet = statement.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Post_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        read_resultSet(posts);
        return posts;
    }

    public Vector<Post> Check(String Category) {
        Vector<Post> posts = new Vector();
        String Query = "";
        if (Category.equals("All")) {
            Query = "select * " + "from Posts ";
        } else {
            Query = "select * " + "from Posts " + "where Category='" + Category + "'";
        }
        try {
            resultSet = statement.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Post_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        read_resultSet(posts);
        return posts;
    }
    
    public Vector<Post> Check(Account account) {
        String Query = "select * " + "from Posts " + "where User_Email='" + account.get_Mail() + "'";
        Vector<Post> posts = new Vector();
        try {
            resultSet = statement.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Post_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        read_resultSet(posts);
        return posts;
    }
    
    public Vector<Post> Check(String City, String Category) {
        Vector<Post> posts = new Vector();
        String Query;
        if ((City.equals("All")) && (Category.equals("All"))) {
            Query = "select * " + "from Posts ";
        } else if (City.equals("All")) {
            Query = "select * " + "from Posts " + "where Category='" + Category + "'";
        } else if (Category.equals("All")) {
            Query = "select * " + "from Posts " + "where Place='" + City + "'";
        } else {
            Query = "select * " + "from Posts " + "where Category='" + Category + "' and Place='" + City + "'";
        }
        try {
            resultSet = statement.executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Post_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        read_resultSet(posts);
        return posts;
    }

    public void Update(Post Old, Post New) {

    }

    public void Insert(Form form) {

    }

    public void Delete(Form form) {

    }

//    public boolean Check(Post post) {
//
//    }
}
