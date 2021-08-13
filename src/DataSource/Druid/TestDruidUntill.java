package DataSource.Druid;

import Utill.DruidUntill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDruidUntill {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DruidUntill.getConnection();
            String sql = "insert into money values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,3);
            pstmt.setString(2,"wangwu");
            pstmt.setInt(3,300);
            System.out.println(pstmt.executeUpdate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUntill.close(pstmt,conn);
        }
    }
}
