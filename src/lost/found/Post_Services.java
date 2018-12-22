

import java.util.Vector;

public class Post_Services {

    Post_Model Post_Model = new Post_Model();
    
    public Vector<Post> Browse_Posts(String Category) {
        Vector<Post> posts = new Vector();
        posts = Post_Model.Check(Category);
        return posts;
    }

    public boolean Add_Post(Post post) {
        boolean verify = Verify_Completness(post);
        if (verify) {
            Post_Model.Insert(post);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean Verify_Completness(Post post) {
        if ((!post.Item.Category.isEmpty()) && (!post.Item.Place.isEmpty()) && (!post.Item.Description.isEmpty()) && (((post.Item.Status) || (!post.Item.Status)))) {
            return true;
        } else {
            return false;
        }
    }
    
    public Vector<Post> Browse_Lost() {
        Vector<Post> posts = new Vector();
        posts = Post_Model.Check(false);
        return posts;
    }

    public Vector<Post> Browse_Found() {
        Vector<Post> posts = new Vector();
        posts = Post_Model.Check(true);
        return posts;
    }
    
    public Vector<Post> Show_My_Posts(Account account) {
        Vector<Post> posts = new Vector();
        posts = Post_Model.Check(account);
        return posts;
    }
    
    public Vector<Post> Search_Posts(String City, String Category) {
        Vector<Post> posts = new Vector();
        posts = Post_Model.Check(City, Category);
        return posts;
    }
    
    public boolean Delete_Post(int post_ID, Account account) {
        if (Post_Model.Check(post_ID,account)){
            Post_Model.Delete(post_ID);
            return true;
        }
        else
            return false;
    }

    public void Verify(Form form) {

    }

    public void Show_Verifications(Post post) {

    }

    public void Check_Form(Form form) {

    }

    public void Delete_Form(Form form) {

    }

    public void Verified_Account(Form form) {

    }

}
