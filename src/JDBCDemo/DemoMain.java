package JDBCDemo;

import java.sql.*;

public class DemoMain {
    public static void main(String[] args) {
        // 在try外提前定义Connection并赋值为null，方便在finally中释放资源
        Connection coon = null;
        // 在try外提前定义Statement并赋值为null，方便在finally中释放资源
        Statement statement = null;
        // 在try外提前定义resultSet并赋值为null，方便在finally中释放资源
        ResultSet resultSet = null;
        try {
            // 导入jdbc驱动，可省略
            Class.forName("com.mysql.jdbc.Driver");
            // 获取jdbc连接对象
            coon = DriverManager.getConnection("jdbc:mysql://121.4.104.195:3306/db_hr", "root", "Yasugongshang1");
            // 获取数据库执行对象 statement 用以执行静态sql
            statement = coon.createStatement();
            // 定义sql语句
            String querySql = "Select * from demo";
            // 使用executeQuery方法执行DQL查询语句
            resultSet = statement.executeQuery(querySql);
            // 如果游标未在最后一行，获取当前行数据并创建DemoDBPerson对象打印对象信息
            while (resultSet.next()) {
                System.out.println(new DemoDBPerson(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {  // 在finally中释放获取的资源，先获取的资源最后释放，类压栈原理
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (coon != null) {
                try {
                    coon.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
