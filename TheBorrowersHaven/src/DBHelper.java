
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shanesha C. Cuevas
 * @Date 16 Mar 2021
 * @version 1.0
 */
public class DBHelper {
    Connection con = null;
    Statement stmt = null;
    
    public void connectDB() throws Exception{
    con = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/TheBorrowersHaven", "Shan", "Shanee");
    System.out.print("Connected to database...\n");
}
    
    public boolean insertRecord(String firstName, String lastName, String userName, String email, String password, String birthday){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Insert into tblUserInformation values ('"+firstName+"','"+lastName+"','"+userName+"','"+email+"','"+password+"','"+birthday+"')"; 
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean insertBookRecord(String bookTitle, String bookAuthor, String bookNumber, String dateBorrowed, String dateDue, String userName){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Insert into tblBorrowSystem values ('"+bookTitle+"','"+bookAuthor+"','"+bookNumber+"','"+dateBorrowed+"','"+dateDue+"','"+userName+"')"; 
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    public boolean insertAdminRecord(String adminEmail, String password, String adminID){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Insert into tblAdminInformation values ('"+adminEmail+"','"+password+"','"+adminID+"')"; 
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean insertBookRecord(String bookTitle, String bookAuthor, String bookNumber){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Insert into tblBookInformation values ('"+bookTitle+"','"+bookAuthor+"','"+bookNumber+"')"; 
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
     public ResultSet displayAllRecords(){
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblUserInformation";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     public ResultSet displayAllBooks(){
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblBookInformation";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
      public ResultSet displayAllAdmin(){
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblAdminInformation";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     
     public ResultSet displayByLastName(String lastName)
    {
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblUserInformation where LastName = '"+lastName+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     
     public ResultSet displayByUserNameforBook(String userName)
    {
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblBorrowSystem where UserName = '"+userName+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     public ResultSet displayByUserName(String userName)
    {
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblUserInformation where UserName = '"+userName+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     public ResultSet displayByadminID(String adminID)
    {
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblAdminInformation where adminID = '"+adminID+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     public ResultSet displayByBookNumber(String bookNumber)
    {
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblBookInformation where bookNumber = '"+bookNumber+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     
     
     public boolean updateRecord(String userName, String firstName, String lastName, String email){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Update tblUserInformation set FirstName = '"+firstName+"', LastName = '"+lastName+"', Email = '"+email+"' where UserName = '"+userName+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
     public boolean updateAdminRecord(String adminID, String adminEmail, String password){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Update tblAdminInformation set adminEmail = '"+adminEmail+"', password = '"+password+"' where AdminID = '"+adminID+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
     public boolean updateBSRecord(String userName, String dateBorrowed, String dateDue){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Update tblBorrowSystem set dateBorrowed = '"+dateBorrowed+"', dateDue = '"+dateDue+"' where UserName = '"+userName+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
     
     public boolean deleteRecord(String userName){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Delete from tblUserInformation where UserName = '"+userName+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
      public boolean deleteAdminRecord(String adminID){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Delete from tblAdminInformation where adminID = '"+adminID+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
      public boolean deleteBSRecord(String userName){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Delete from tblBorrowSystem where UserName = '"+userName+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
      public boolean deleteBook(String bookNumber){
        boolean flag = false;
       
        try {
            stmt = con.createStatement();
            String sq1 = "Delete from tblBookInformation where bookNumber = '"+bookNumber+"'";
            if (stmt.executeUpdate(sq1) == 1)
                flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
     
    public ResultSet displayByBookTitle(String bookTitle){
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            String sql = "Select * from tblBookInformation where BookTitle = '"+bookTitle+"'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
     
     public void disconnectDB(){
            try {
            if (con != null)
                 con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}   
    
