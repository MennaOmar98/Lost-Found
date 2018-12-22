

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
    
    public void Browse_Posts(String Category, javax.swing.JTextArea jTextArea1) throws SQLException {
        Vector<Post> posts = new Vector();
        posts = Post_Serv.Browse_Posts(Category);
        Print_Posts(posts, jTextArea1);
    }

    public boolean Post(Post post) {
        boolean flag = Post_Serv.Verify_Completness(post);
        if (!flag) {
            return false;
        } else {
            Post_Serv.Add_Post(post);
            return true;
        }
    }
    
    public void Print_Posts(Vector<Post> posts, javax.swing.JTextArea jTextArea1) throws SQLException {
        if (posts.size() == 0) {
            jTextArea1.setText(null);
            jTextArea1.append("Nothing Found!!");
        } else {
            jTextArea1.setText(null);
            String Status;
            for (int i = 0; i < posts.size(); i++) {
                jTextArea1.append("Post_ID : " + posts.get(i).Post_ID);
                jTextArea1.append("\nDate of Post : " + posts.get(i).Date_Of_Post);
                jTextArea1.append("\nUserName : " + posts.get(i).User.get_Name());
                if (posts.get(i).Item.Status == false) {
                    Status = "Lost";
                } else {
                    Status = "Found";
                }
                jTextArea1.append("\n\nStatus : " + Status);
                jTextArea1.append("\nCategory : " + posts.get(i).Item.Category);
                jTextArea1.append("\nPlace : " + posts.get(i).Item.Place);
                jTextArea1.append("\nDate Of Lost/Found : " + posts.get(i).Item.Date_Of_Lost_or_Found);
                jTextArea1.append("\nDescription : \n" + posts.get(i).Item.Description);
                jTextArea1.append("\n\n------------------------------------------\n\n");
            }
        }
    }

    public void Browse_Lost(javax.swing.JTextArea jTextArea1) throws SQLException {
        Vector<Post> posts = new Vector();
        posts = Post_Serv.Browse_Lost();
        Print_Posts(posts, jTextArea1);
    }

    public void Browse_Found(javax.swing.JTextArea jTextArea1) throws SQLException {
        Vector<Post> posts = new Vector();
        posts = Post_Serv.Browse_Found();
        Print_Posts(posts, jTextArea1);
    }
    
    public void Show_My_Posts(Account Account, javax.swing.JTextArea jTextArea1) throws SQLException {
        Vector<Post> posts = new Vector();
        posts = Post_Serv.Show_My_Posts(Account);
        Print_Posts(posts, jTextArea1);
    }
        
    public void Search(String Place, String Category, javax.swing.JTextArea jTextArea1) throws SQLException {
        Vector<Post> posts = new Vector();
        posts = Post_Serv.Search_Posts(Place, Category);
        Print_Posts(posts, jTextArea1);
    } 
    
    public boolean Delete_Post(int Post_ID, Account Account) {
        boolean Deleted = Post_Serv.Delete_Post(Post_ID, Account);
        if (Deleted) {
            return true;
        } else {
            return false;
        }
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
