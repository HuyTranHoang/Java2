package vn.fxdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtils {

    private static Connection connection;

    private DatabaseUtils(){};

    public static Connection getInstance(){
        if(connection == null){


            String host="localhost";
            String port="5432";
            String dbname="java";
            String dburl = "jdbc:postgresql://"+host+":"+port+"/"+dbname+"?loggerLevel=OFF";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "25091995");
            try {
                connection = DriverManager.getConnection(dburl, props);
            } catch (SQLException e) {
                System.out.println("Kết nối không thành công");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Đóng kết nối không thành công");
                e.printStackTrace();
            }
        }
    }
}
