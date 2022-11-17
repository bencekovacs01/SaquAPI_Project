package saquapi.database;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
// Importing database
import java.sql.*;
// Importing required classes
import java.util.*;
import java.io.*;

@Path("/databaseConnection")
public class databaseConnection {
    private static Connection con;

    @GET
    public static void myMain(){ // call functions to be tested
        estabilishConnection();
        uploadImageToDatabase();
        downloadImageFromDatabase();
        closeConnection();
    }

    public static void uploadImageToDatabase(){
        try{
            PreparedStatement ps=con.prepareStatement("insert into ImgTable values(?,?)"); // query
            ps.setString(1,"MyImage"); // set 1st param
            FileInputStream fin = new FileInputStream("G:\\egyetem\\III\\1\\Software\\kepek\\Fuzi_Zalan.jpg"); // image path
            ps.setBinaryStream(2,fin,fin.available()); // set 2nd param
            int i = ps.executeUpdate();
            System.out.println(i + " records affected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void downloadImageFromDatabase(){
        try{
            PreparedStatement ps=con.prepareStatement("select * from ImgTable");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Blob b=rs.getBlob(2);//2 means 2nd column data
                byte barr[]=b.getBytes(1,(int)b.length());//1 means first image
                FileOutputStream fout=new FileOutputStream("G:\\egyetem\\III\\1\\Software\\kepek\\Fuzi_Zalan1.jpg");
                fout.write(barr);
                fout.close();
            }
            System.out.println("ok");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getUsers(){
        try{
            String query = "select * from Users"; // query to be run
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query); // Execute query
            rs.next();
            String name = rs.getString("UserName"); // Retrieve name from db
            System.out.println(name); // Print result on console
            st.close(); // close statement
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //
    public static void estabilishConnection(){
        try {
            System.out.println("Establishing connection...");
            String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11529590"; // table details
            String username = "sql11529590"; // MySQL credentials
            String password = "zgLnGAJWEY";
            Class.forName("com.mysql.jdbc.Driver"); // Driver name
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection(){
        try{
            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
