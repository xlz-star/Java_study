package com.xlz.demo01;

import java.sql.*;

public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new Demo04().getRunTime();
    }

    void getRunTime() throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/mysql",
                "root",
                "123456"
        );
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select user,host from user");
        while (resultSet.next()) {
            String user = resultSet.getString("user");
            String host = resultSet.getString("host");
            System.out.printf("%s, %s\n", user, host);
        }
        statement.close();
        conn.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间"+(end - start)+"ms");
    }
}
