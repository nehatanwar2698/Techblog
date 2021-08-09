
package com.tech.blog.dao;
import java.sql.*;
import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
//    fetch all categories from databse
    Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }
    
    
//   return all categories
    // make a function that will fetch all the categories from database
    public  ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> list=new ArrayList<>();
        try {
            String query="select * from categories";
            Statement st=con.createStatement();
            ResultSet set=st.executeQuery(query);
            while(set.next())
            {
                int cid=set.getInt("cid");
                String name=set.getString("name");
                String description=set.getString("description");
                Category c=new Category(cid, name, description);
                list.add(c);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean savePost(Post p)
    {
        boolean f=false;
        try {
            String q="insert into posts(pTitle, pContent, pCode, pPic, catId, userId) values(?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, p.getpTitle());
            pstmt.setString(2, p.getpContent());
            pstmt.setString(3, p.getpCode());
            pstmt.setString(4, p.getpPic());
            pstmt.setInt(5, p.getCatId());
            pstmt.setInt(6, p.getUserId());
            
            pstmt.executeUpdate();
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    
    //    getAllPosts()-provides list of all the posts
    //get all the posts
    public List<Post> getAllPosts()
    {
        List<Post> list=new ArrayList<>();
        
        //fetch all the posts
        try {
            PreparedStatement p=con.prepareStatement("select * from posts order by pid desc");
            ResultSet set=p.executeQuery();
            while(set.next())
            {
                int pid=set.getInt("pid");
                String pTitle =set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                int catId=set.getInt("catId");
                int userId=set.getInt("userId");
                Post post=new Post(pid,pTitle, pContent, pCode, pPic, date, catId, userId);
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    //provides list of all the posts with a given catId
    public List<Post> getPostByCatId(int catId)
    {
        //get all posts by id
          List<Post> list=new ArrayList<>();
        
        //fetch all the posts
        try {
            PreparedStatement p=con.prepareStatement("select * from posts where catId=?");
            p.setInt(1, catId);
            ResultSet set=p.executeQuery();
            while(set.next())
            {
                int pid=set.getInt("pid");
                String pTitle =set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                int userId=set.getInt("userId");
                Post post=new Post(pid,pTitle, pContent, pCode, pPic, date, catId, userId);
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
//     get blog  post by id 
   public Post getPostByPostId(int postId)
    {
        Post post=null;
        String q="select * from posts where pid=?";
        
        try {
            PreparedStatement p=this.con.prepareStatement(q);
            p.setInt(1, postId);
            ResultSet set=p.executeQuery();
            if(set.next())
            {
                 int pid=set.getInt("pid");
                String pTitle =set.getString("pTitle");
                String pContent=set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp date=set.getTimestamp("pDate");
                int catId=set.getInt("catId");
                int userId=set.getInt("userId");
                post=new Post(pid,pTitle, pContent, pCode, pPic, date, catId, userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
}
