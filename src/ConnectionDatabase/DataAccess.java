package ConnectionDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

    private static ConnectToDB Conn = new ConnectToDB();
    private static String StrCon = "server="+Conn.getServer()+"; database="+Conn.getNameDatabase()+"; integrated security=true;";

    public Boolean AttachDatabase(String DBPath) {
        Connection conn;
        Statement st;
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "EXEC sp_attach_single_file_db @dbname='Demo', @physname = N'" + DBPath + "'";
            st = conn.createStatement();
            st.execute(sql);

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
