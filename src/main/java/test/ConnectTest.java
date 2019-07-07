package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectTest {
    public static void main(String []args) throws SQLException {
        Connection realConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?serverTimezone=UTC",
                "root","123456");
        String sql = "insert into sample(id, column1, column2) values (?,?,?) ";
        Object [] ob = new Object[]{1,1,"test"};
        PreparedStatement ps = realConnection.prepareStatement(sql);
        for (int i = 0; i < ob.length; i++){
            ps.setObject(i + 1, ob[i]);
        }
        ps.executeUpdate();
    }
}
