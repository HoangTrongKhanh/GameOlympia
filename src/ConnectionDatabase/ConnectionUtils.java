package ConnectionDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getMyConnection() throws SQLException {
        return SQLServerConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException {

        System.out.println("Get connection ... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = ConnectionUtils.getMyConnection();

        System.out.println("Get connection " + conn);

        System.out.println("Done!");
    }
}