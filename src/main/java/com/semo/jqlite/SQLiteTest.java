package com.semo.jqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteTest {
    public static void main(String[] args) {
        Connection con = null;
        try {
        // SQLite JDBC 체크
        Class.forName("org.sqlite.JDBC");
        // SQLite 데이터베이스 파일에 연결
        String dbFile = "/Users/gimgyeong-o/Library/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db";
        con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        // SQL 수행
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery("SELECT Title,ArtistId FROM Album");
        while(rs.next()) {
            String id = rs.getString("Title");
            String name = rs.getString("ArtistId");
            System.out.println("query :: "+ id + " " + name);
        }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(con != null) {
                try {
                    con.close();
                }catch(Exception e) {}
            }
        }
    }
}
