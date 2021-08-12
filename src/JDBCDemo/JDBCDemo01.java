package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        // 将jdbc加载进内存,mysql5.0版本之后的jar包可以省略此操作
//        Class.forName("com.mysql.jdbc.Driver");
        // 创建connection对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://121.4.104.195:3306/db_hr?characterEncoding=utf-8&serverTimezone=UTC", "root", "Yasugongshang1");
        // 定义sql语句
        String sql = "update users set sex = 0";
        // 获取statement 对象执行sql
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(sql); // executeUpdate 用来执行DML，返回的int为影响的行数
        System.out.println(i);
        // 释放数据库连接资源
        statement.close();
        connection.close();
    }
}
