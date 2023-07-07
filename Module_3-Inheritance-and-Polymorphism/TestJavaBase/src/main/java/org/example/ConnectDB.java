package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDB {



    private static Connection connection;

    private ConnectDB(){};

    public static Connection getInstance(){
        if(connection == null){


            String host="localhost";
            String port="5432";
            String dbname="java";
            String dburl = "jdbc:postgresql://"+host+":"+port+"/"+dbname+"?loggerLevel=OFF";
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
