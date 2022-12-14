package saquapi.database;

// Importing database
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import javax.sql.rowset.serial.SerialBlob;
import java.nio.charset.StandardCharsets;
import java.sql.*;
// Importing required classes
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class DatabaseConnection {
    private static Connection con;
    private  static PreparedStatement ps;
    private static ResultSet rs;
    private static final List<ResponseDataRecord> myData = new ArrayList<>();

    public static void deleteUser(int roomNumber){
        try{
            ps = con.prepareStatement("delete from Users where RoomNumber=?");
            ps.setInt(1,roomNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeUserEmail(int roomNumber, String email){
        try{
            ps = con.prepareStatement("update Users set Email=? where RoomNumber=?");
            ps.setString(1,email);
            ps.setInt(2,roomNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean changeUserPassword(int roomNumber, String newPass){
        try{
            ps = con.prepareStatement("update Users set Password=? where RoomNumber=?");
            ps.setString(1,newPass);
            ps.setInt(2,roomNumber);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void newUser(int roomNumber, String password, String email){
        try{
            ps = con.prepareStatement("insert into Users values (?,?,?)");
            ps.setInt(1,roomNumber);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getImage(int key){
        try{
            ps = con.prepareStatement("select Image from Data where IDX=?");
            ps.setInt(1,key);
            rs = ps.executeQuery();
            if(rs.next()){
                Blob b = rs.getBlob("Image");
                byte[] encodedByte = b.getBytes(1, (int) b.length());
                return Base64.getEncoder().encodeToString(encodedByte);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ""; // just in case something went wrong
    } // SELECT get image on index(key)

    public  static void deleteData(int key){
        try{
            ps = con.prepareStatement("delete from Data where IDX=?");
            ps.setInt(1,key);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // DELETE delete record

    public static boolean updateData(int key, long coldWater, long hotWater){
        try{
            ps = con.prepareStatement("update Data set ColdWater=?, HotWater=? where IDX=?");
            ps.setLong(1,coldWater);
            ps.setLong(2,hotWater);
            ps.setInt(3,key);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // UPDATE update data

    public static void insertData(int roomNumber, long coldWater, long hotWater, Date date, String fin){
        try{
            byte[] decodedByte = Base64.getDecoder().decode(fin);
            Blob b = new SerialBlob(decodedByte);
            ps = con.prepareStatement("insert into Data(roomnumber, coldwater, hotwater, date, image) values(?,?,?,?,?)");
            ps.setInt(1,roomNumber);
            ps.setLong(2,coldWater);
            ps.setLong(3,hotWater);
            ps.setDate(4,date);
            ps.setBlob(5,b);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // INSERT insert new data

    public static List<ResponseDataRecord> listLatestDataEachRoom(){
        try{
            myData.clear();
            ps = con.prepareStatement("SELECT a.* FROM Data a INNER JOIN" +
                    " (SELECT RoomNumber, MAX(Date) as MaxDate FROM Data GROUP BY RoomNumber) b" +
                    " ON a.RoomNumber = b.RoomNumber AND a.Date = b.MaxDate");
            rs = ps.executeQuery();
            while(rs.next()){
                ResponseDataRecord rdr = new ResponseDataRecord(rs.getInt("IDX"),rs.getInt("RoomNumber"),rs.getLong("ColdWater"),rs.getLong("HotWater"),rs.getDate("Date").toLocalDate());
                System.out.println(rdr);
                myData.add(rdr);
            }
            return myData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list latest data each room

    public static List<ResponseDataRecord> listRoomData(int roomNumber){
        try{
            myData.clear();
            ps = con.prepareStatement("select IDX,HotWater,ColdWater,Date from Data where RoomNumber=?");
            ps.setInt(1,roomNumber);
            rs = ps.executeQuery();
            while (rs.next()){
                myData.add(new ResponseDataRecord(rs.getInt("IDX"),roomNumber,rs.getLong("ColdWater"),rs.getLong("HotWater"),rs.getDate("Date").toLocalDate()));
            }
            return myData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data of given roomNumber

    public static List<ResponseDataRecord> listAll(){
        try{
            myData.clear();
            ps = con.prepareStatement("select IDX,RoomNumber,ColdWater,HotWater,Date from Data");
            rs = ps.executeQuery();
            while(rs.next()){
                myData.add(new ResponseDataRecord(rs.getInt("IDX"),rs.getInt("RoomNumber"),rs.getLong("ColdWater"),rs.getLong("HotWater"),rs.getDate("Date").toLocalDate()));
            }
            return myData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data

    public static boolean loginCredentials(int roomNumber, String password){
        try{
            ps = con.prepareStatement("select 1 from Users where RoomNumber=? and Password=?");
            ps.setInt(1,roomNumber);
            ps.setString(2,password);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT check if the given username-password pair exists

    public static void establishConnection(){
        try {
            String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11529590"; // table details
            String username = "sql11529590"; // MySQL credentials
            String password = "zgLnGAJWEY";
            Class.forName("com.mysql.jdbc.Driver"); // Driver name
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    } // create connection with DB

    public static void closeConnection(){
        try{
            con.close(); // close connection
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // close the DB connection
}
