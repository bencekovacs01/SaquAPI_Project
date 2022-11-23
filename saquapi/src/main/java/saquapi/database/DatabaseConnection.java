package saquapi.database;

// Importing database
import java.sql.*;
// Importing required classes
import java.io.*;
import java.util.List;

public class DatabaseConnection {
    private static Connection con;
    private  static PreparedStatement ps;
    private static ResultSet rs;
    private static List<DataRecord> mydata;

    public static void deleteUser(int roomnumber){
        try{
            ps = con.prepareStatement("delete from Users where Name=?");
            ps.setInt(1,roomnumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeUserEmail(int roomnumber, String email){
        try{
            ps = con.prepareStatement("update Users set Email=? where RoomNumber=?");
            ps.setString(1,email);
            ps.setInt(2,roomnumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeUserPassword(int roomnumber, String newPass){
        try{
            ps = con.prepareStatement("update Users set Password=? where RoomNumber=?");
            ps.setString(1,newPass);
            ps.setInt(2,roomnumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(int roomnumber, String password, String email){
        try{
            ps = con.prepareStatement("insert into Users values (?,?,?)");
            ps.setInt(1,roomnumber);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] getImage(int key){
        try{
            ps = con.prepareStatement("select Image from Data");
            rs = ps.executeQuery();
            if(rs.next()){
                Blob b = rs.getBlob("Image");
                return b.getBytes(1,(int)b.length());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new byte[0]; // just in case something went wrong
    } // SELECT get image on index(key)

    public  static void deleteData(int key){
        try{
            ps = con.prepareStatement("delete from Data where `Key`=?");
            ps.setInt(1,key);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // DELETE delete record

    public static void updateData(int key, long coldwater, long hotwater){
        try{
            ps = con.prepareStatement("update Data set ColdWater=?, HotWater=? where `Key`=?");
            ps.setLong(1,coldwater);
            ps.setLong(2,hotwater);
            ps.setInt(3,key);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // UPDATE update data

    public static void insertData(int roomnumber, long coldwater, long hotwater, Date date, FileInputStream fin){
        try{
            ps = con.prepareStatement("insert into Data(roomnumber, coldwater, hotwater, date, image) values(?,?,?,?,?)");
            ps.setInt(1,roomnumber);
            ps.setLong(2,coldwater);
            ps.setLong(3,hotwater);
            ps.setDate(4,date);
            ps.setBinaryStream(5,fin,fin.available());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    } // INSERT insert new data

    public static List<DataRecord> listRoomData(int roomnumber){
        try{
            mydata = null;
            ps = con.prepareStatement("select HotWater, ColdWater, `Key` from Data where RoomNumber=?");
            ps.setInt(1,roomnumber);
            rs = ps.executeQuery();
            while (rs.next()){
                mydata.add(new DataRecord(rs.getInt("Key"),roomnumber,rs.getLong("ColdWater"),rs.getLong("HotWater")));
            }
            return mydata;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data of given roomnumber

    public static List<DataRecord> listAll(){
        try{
            mydata = null;
            ps = con.prepareStatement("select * from Data");
            rs = ps.executeQuery();
            while(rs.next()){
                mydata.add(new DataRecord(rs.getInt("Key"),rs.getInt("RoomNumber"),rs.getLong("ColdWater"),rs.getLong("HotWater")));
            }
            return mydata;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data

    public static boolean loginCredentials(String username, String password){
        try{
            ps = con.prepareStatement("select 1 from Users where UserName=? and Password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT check if the given username-password pair exists

    public static void estabilishConnection(){
        try {
            String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11529590"; // table details
            String username = "sql11529590"; // MySQL credentials
            String password = "zgLnGAJWEY";
            Class.forName("com.mysql.jdbc.Driver"); // Driver name
            System.out.println("Establishing connection...");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    } // create connection with DB

    public static void closeConnection(){
        try{
            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // close the DB connection
}
