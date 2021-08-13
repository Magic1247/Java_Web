package DataSource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class cpp0Demo02 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();  // 传输对应的named获取不同的配置，默认取defult配置
        for (int i = 0; i < 5; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i + ":" + connection);
        }
    }
}
