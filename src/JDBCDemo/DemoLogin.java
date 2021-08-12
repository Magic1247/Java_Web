package JDBCDemo;

import Utill.JDBCUtills;

import java.sql.*;
import java.util.Scanner;

public class DemoLogin {
    public static void main(String[] args) {
//        System.out.println(login("1 or 1=1 ", "pw666"));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号：");
        String userAccount = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        boolean flag = login3(userAccount, password);
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    private static String login(String userAccount, String Password) {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = JDBCUtills.getConnection();
        String queryAccount = "select * from user_account where userAccount =" + userAccount;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryAccount);
            int count = 0;

            while (resultSet.next()) {
                count++;
                int anInt = resultSet.getInt("userAccount");
            }
            if (count > 0) {
                String querypasswrod = "select password from user_account where userAccount =" + userAccount;
                ResultSet passwordResult = statement.executeQuery(querypasswrod);
                String truepassword = null;
                while (passwordResult.next()) {
                    truepassword = passwordResult.getString(1);
                }
                if (Password.equals(truepassword)) {
                    return "登录成功";
                } else {
                    return "密码错误";
                }
            } else {
                return userAccount + "账户不存在";
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
            return "内部异常";
        }
    }

    private static boolean login2(String userAccount, String Password) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtills.getConnection();
            statement = connection.createStatement();
            String sql = "select * from user_account where userAccount = " + userAccount + " and password = '" + Password + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    private static boolean login3(String userAccount, String Password) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement pstmt = null;
        try {
            connection = JDBCUtills.getConnection();
            String sql = "select * from user_account where userAccount = ? and password = ?";
            pstmt = connection.prepareStatement(sql);
            System.out.println(sql);
            pstmt.setString(1,userAccount);
            pstmt.setString(2,Password);
            resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

}


