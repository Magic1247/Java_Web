package Utill;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtills {
    /**
     * @return 返回Connection对象
     */
    public static Connection getConnection() {
        ClassLoader classLoader = JDBCUtills.class.getClassLoader();
        Properties pro = new Properties();
        try {
            pro.load(classLoader.getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String url = pro.getProperty("url");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * @param coon 需要关闭的Connection 对象
     * @param stmt 需要关闭的Statement 对象
     */
    public static void close(Connection coon, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
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

    /**
     * @param rs   需要关闭的ResultSet 对象
     * @param coon 需要关闭的Connection 对象
     * @param stmt 需要关闭的Statement 对象
     */
    public static void close(ResultSet rs, Connection coon, Statement stmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
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
