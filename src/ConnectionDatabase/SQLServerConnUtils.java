package ConnectionDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils {

    public static Connection getSQLServerConnection()
            throws SQLException {
        String hostName = "localhost";
        String sqlInstanceName = "SQLEXPRESS";
        String database = "DBGameOlympia2";

        return getSQLServerConnection(hostName, sqlInstanceName, database);
    }

    public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database)
            throws SQLException {
        //jdbc:sqlserver://localhost\SQLEXPRESS;database=DBGameOlympia
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
                + ";instance=" + sqlInstanceName + ";databaseName=" + database + ";integratedSecurity=true;";

        Connection conn = DriverManager.getConnection(connectionURL);
        return conn;
    }
}
