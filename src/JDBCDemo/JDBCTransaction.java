package JDBCDemo;

import Utill.JDBCUtills;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransaction {
    public static void main(String[] args) {
        demo01("zhangsan","lisi",80);
    }

    private static void demo01(String owner, String accepter, int money) {
        Connection connection = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            connection = JDBCUtills.getConnection();
            connection.setAutoCommit(false);
            String sql1 = "update money set money = money- ? where name = ?";
            pstmt1 = connection.prepareStatement(sql1);
            pstmt1.setInt(1,money);
            pstmt1.setString(2,owner);
            pstmt1.executeUpdate();

            String sql2 = "update money set money = money+ ? where name = ?";
            pstmt2 = connection.prepareStatement(sql2);
            pstmt2.setInt(1,money);
//            int i = 1/0;
            pstmt2.setString(2,accepter);
            pstmt2.executeUpdate();
            connection.commit();
        } catch (Exception throwables) {  // 直接捕获Exception，不论出现什么异常都进行回滚操作
            throwables.printStackTrace();
            try {
                if(connection != null){
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
