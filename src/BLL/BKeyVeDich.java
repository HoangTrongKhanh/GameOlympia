package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EKeyVeDich;

import java.sql.*;
import java.util.ArrayList;

public class BKeyVeDich {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EKeyVeDich toEKeyVeDich(ResultSet rs) throws SQLException {
        EKeyVeDich temp = new EKeyVeDich();
        temp.setStt(rs.getInt(1));
        temp.setName(rs.getString(2));
        return temp;
    }

    public static ArrayList<EKeyVeDich> SelectAll() {
        ResultSet rs = null;
        ArrayList<EKeyVeDich> result = new ArrayList<EKeyVeDich>();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKeyVeDich_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEKeyVeDich(rs));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try { rs.close(); } catch (Exception e) {  }
            try { st.close(); } catch (Exception e) {  }
            try { conn.close(); } catch (Exception e) {  }
        }
        return result;
    }

    public static ArrayList<EKeyVeDich> SelectById(int id) {
        ResultSet rs = null;
        ArrayList<EKeyVeDich> result = new ArrayList<EKeyVeDich>();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKeyVeDich_SelectByID(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                result.add(toEKeyVeDich(rs));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try { rs.close(); } catch (Exception e) {  }
            try { st.close(); } catch (Exception e) {  }
            try { conn.close(); } catch (Exception e) {  }
        }
        return result;
    }

    public static void Insert(EKeyVeDich veDich) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKeyVeDich_Insert(?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, veDich.getStt());
            st.setString(2, veDich.getName());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EKeyVeDich veDich) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKeyVeDich_Update(?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, veDich.getStt());
            st.setString(2, veDich.getName());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(int stt) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKeyVeDich_Delete(?)";
            st = conn.prepareCall(sql);
            st.setInt(1, stt);
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
