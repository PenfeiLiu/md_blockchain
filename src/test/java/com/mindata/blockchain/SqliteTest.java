package com.mindata.blockchain;

/**
 * Created by liupengfei on 2019/3/11.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        String db = "a.db";
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db);
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from message;"); //查询数据
        while (rs.next()) { //将查询到的数据打印出来
            System.out.print("name = " + rs.getString("id") + " "); //列属性一
            System.out.println("age = " + rs.getString("content")); //列属性二
        }
        rs.close();
        conn.close();

    }

}

