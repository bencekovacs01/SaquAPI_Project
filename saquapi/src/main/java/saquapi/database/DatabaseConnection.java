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
    private static List<DataRecord> myData;

    public static void deleteUser(int roomNumber){
        try{
            ps = con.prepareStatement("delete from Users where Name=?");
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

    public static void changeUserPassword(int roomNumber, String newPass){
        try{
            ps = con.prepareStatement("update Users set Password=? where RoomNumber=?");
            ps.setString(1,newPass);
            ps.setInt(2,roomNumber);
            ps.executeUpdate();
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

    public static void updateData(int key, long coldWater, long hotWater){
        try{
            ps = con.prepareStatement("update Data set ColdWater=?, HotWater=? where `Key`=?");
            ps.setLong(1,coldWater);
            ps.setLong(2,hotWater);
            ps.setInt(3,key);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // UPDATE update data

    public static void insertData(int roomNumber, long coldWater, long hotWater, Date date, FileInputStream fin){
        try{
            ps = con.prepareStatement("insert into Data(roomnumber, coldwater, hotwater, date, image) values(?,?,?,?,?)");
            ps.setInt(1,roomNumber);
            ps.setLong(2,coldWater);
            ps.setLong(3,hotWater);
            ps.setDate(4,date);
            ps.setBinaryStream(5,fin,fin.available());
            ps.executeUpdate();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    } // INSERT insert new data

    public static List<DataRecord> listRoomData(int roomNumber){
        try{
            myData = null;
            ps = con.prepareStatement("select HotWater, ColdWater, IDX from Data where RoomNumber=?");
            ps.setInt(1,roomNumber);
            rs = ps.executeQuery();
            while (rs.next()){
                myData.add(new DataRecord(rs.getInt("IDX"),roomNumber,rs.getLong("ColdWater"),rs.getLong("HotWater")));
            }
            return myData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data of given roomNumber

    public static List<DataRecord> listAll(){
        try{
            myData = null;
            ps = con.prepareStatement("select IDX,RoomNumber,ColdWater,HotWater from Data");
            rs = ps.executeQuery();
            while(rs.next()){
                myData.add(new DataRecord(rs.getInt("IDX"),rs.getInt("RoomNumber"),rs.getLong("ColdWater"),rs.getLong("HotWater")));
            }
            return myData;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } // SELECT list all data

    public static boolean loginCredentials(int roomNumber, String password){
        try{

            estabilishConnection();
            ps = con.prepareStatement("select 1 from Users where RoomNumber=? and Password=?");
            ps.setInt(1,roomNumber);
            ps.setString(2,password);
            rs = ps.executeQuery();
            Boolean returnValue = rs.next();
            closeConnection();
            return returnValue;
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
