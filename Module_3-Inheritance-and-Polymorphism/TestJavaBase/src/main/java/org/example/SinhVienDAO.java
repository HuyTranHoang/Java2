package org.example;

import java.sql.*;

public class SinhVienDAO {
    private static Connection connection = ConnectDB.getInstance();

    public static ResultSet read(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
//            rs.afterLast();
            rs.moveToInsertRow();
            rs.updateInt("masv",10);
            rs.updateString("tenSV","Gawr Gura desu ne hjhj");
            rs.updateRow();
            rs.moveToCurrentRow();
            while (rs.next()){
                int id = rs.getInt("maSV");
                String name = rs.getString("tenSV");
                System.out.println("maSV: " + id + ", tenSV: " + name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static int insert(int maSV, String tenSV) {
        try {
            String sql = "INSERT INTO \"sinhvien\"(MaSV, TenSV)" +
                    "VALUES (?, ?);";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,maSV);
            stmt.setString(2,tenSV);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(int maSV, String tenSV) {
        try {
            String sql = "UPDATE \"sinhvien\" Set tenSV = ? WHERE maSV = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,tenSV);
            stmt.setInt(2,maSV);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(int maSV) {
        try {
            String sql = "DELETE \"sinhvien\" WHERE maSV = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,maSV);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
