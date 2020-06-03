import java.sql.*;
import java.util.*;

public class AppDefaultDB {

    public String db_url = "jdbc:sqlite:simulator.db";

    public AppDefaultDB() {

    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(db_url);
    }

    public void closeConnection(Connection conn) {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}