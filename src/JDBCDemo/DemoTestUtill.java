package JDBCDemo;

import Utill.JDBCUtills;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTestUtill {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = JDBCUtills.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * from demo";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") +
                                resultSet.getString("name") +
                                resultSet.getInt("sex") +
                                resultSet.getInt("balance")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtills.close(resultSet, connection, statement);

    }
}
