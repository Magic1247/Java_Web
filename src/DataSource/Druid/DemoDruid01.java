 package DataSource.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DemoDruid01 {
    public static void main(String[] args) throws IOException {
        InputStream ls = DemoDruid01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(ls);
        DataSource ds = null;
        Connection conn = null;
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            String sql = "Select * from money where name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"lisi");
            ResultSet resultSet = pstmt.executeQuery();
            conn.commit();
            resultSet.next();
            System.out.println(resultSet.getString("name"));
        } catch (Exception e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }

    }
}
