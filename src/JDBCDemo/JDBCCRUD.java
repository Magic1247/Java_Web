package JDBCDemo;

import java.sql.*;

public class JDBCCRUD {
    public static void main(String[] args) {
        String insertsql = "insert into demo values(2,'中文测试',0,8000000)";
        String updateName = "update demo set name = 'gulinazha' where id = 3 limit 1";
        String deletegulinazha = "delete from demo where name = 'gulinazha'";
//        sqlupdate(insertsql);
        ResultSet sda = sqlquery("select * from demo");
        while (true) {
            try {
                if (!sda.next()) break;
                System.out.println("id:"+sda.getInt(1)+ " " +"name:"+sda.getString(2));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static ResultSet sqlquery(String sql) {
        Connection coon = null;
        Statement statement =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://121.4.104.195:3306/db_hr","root","Yasugongshang1");
            statement = coon.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
//        finally {
//            if(statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//            if(coon != null){
//                try {
//                    coon.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//
//        }
    }





    private static void sqlupdate(String sql) {
        Connection coon = null;
        Statement statement =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://121.4.104.195:3306/db_hr","root","Yasugongshang1");
            statement = coon.createStatement();

            int count = statement.executeUpdate(sql);
            if (count > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(coon != null){
                try {
                    coon.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
