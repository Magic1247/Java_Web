package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * c3p0演示demo
 */
public class c3p0Demo01 {
    public static void main(String[] args) {
        DataSource ds = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = ds.getConnection();
            String sql = "select * from money where name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"zhangsan");
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
