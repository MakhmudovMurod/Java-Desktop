package sample.Database;

import sample.Database.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()throws ClassNotFoundException,SQLException{

        String connectionString="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection=DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(String firstName,String lastName,String Password,String Id){
        String insert ="INSERT INTO "+ Const.USER_TABLE+"("+ Const.USER_FIRSTNAME+", "+Const.USER_LASTNAME+", "+
                Const.USER_USERID+", "+Const.USER_PASSWORD+")"+"VALUES(?,?,?,?)";



        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,firstName);
            prSt.setString(2,lastName);
            prSt.setString(3,Id);
            prSt.setString(4,Password);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
