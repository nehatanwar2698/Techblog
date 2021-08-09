
package com.tech.blog.dao;
import java.sql.*;


public class LikeDao {
     Connection con;

    public LikeDao(Connection con) {
        this.con = con;
    }
    
    public boolean insertLike(int pid, int uid)
    {
        boolean f=false;
        try {
            String q="insert into liked(pid,uid) values(?,?)";
            PreparedStatement p=this.con.prepareStatement(q);
            //values set..
            p.setInt(1, pid);
            p.setInt(2, uid);
            p.executeUpdate();
            f=true;
        } catch (Exception e) {
        }
        return f;
    }
    
    public int countLikeOnPost(int pid)
    {
        int count=0;
        
        String q="select count(*) from liked where pid=?";
        
        try {
            PreparedStatement p=this.con.prepareStatement(q);
            p.setInt(1, pid);
            //here we are expecting a result, when we count db se data aayega
            ResultSet set=p.executeQuery();
            if(set.next())
            {
                count=set.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return count;
    }
    
    //check whether a person liked a post already or not, we want to show if a person already liked so that he can either dislike if he clicks it again or not click on it again
    public boolean isLikedByUser(int pid, int uid)
    {
        boolean f=false;
        
        try {
            PreparedStatement p= this.con.prepareStatement("select * from liked where pid=? and uid=?");
            p.setInt(1, pid);
            p.setInt(2, uid);
            ResultSet set=p.executeQuery();
            if(set.next())
            {
                f=true;
            }
        } catch (Exception e) {
        }
        
        return f;
    }
    
    //dislike the post
    public boolean deleteLike(int pid, int uid)
    {
        boolean f=false;
        
        try {
            PreparedStatement p=this.con.prepareStatement("delete from liked where pid=? and uid=?");
            p.setInt(1, pid);
            p.setInt(2, uid);
            //we are not expecting any data here
            p.executeUpdate();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
    }
}
