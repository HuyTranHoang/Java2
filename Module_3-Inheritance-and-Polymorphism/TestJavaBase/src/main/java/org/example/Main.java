package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
//        int count = SinhVienDAO.insert(5,"Sơn Trần");
//        System.out.println("Số dòng đã ảnh hưởng là " + count);
//        SinhVienDAO.update(5,"Sơn Sơn");
//        SinhVienDAO.delete(5);
//        SinhVienDAO.insert(6,"Pekora");
        ResultSet rs = null;
        rs = SinhVienDAO.read("SELECT * FROM sinhvien");
    }

}

