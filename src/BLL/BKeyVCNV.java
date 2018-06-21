package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EKeyVCNV;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class BKeyVCNV {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EKeyVCNV toEKeyVCNV(ResultSet rs) throws SQLException {
        EKeyVCNV temp = new EKeyVCNV();
        temp.setStt(rs.getInt(1));
        temp.setQuestion(rs.getString(2));
        temp.setAnswer(rs.getString(3));
        temp.setSoOHN(rs.getInt(4));
        temp.setPath(rs.getString(5));
        return temp;
    }

    public static ObservableList<EKeyVCNV> SelectAll() {
        ResultSet rs = null;
        ObservableList<EKeyVCNV> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KeyVCNV_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEKeyVCNV(rs));
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

    public static EKeyVCNV SelectById(int id) {
        ResultSet rs = null;
        EKeyVCNV result = new EKeyVCNV();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KeyVCNV_SelectByID(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                result = toEKeyVCNV(rs);
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

    public static void Insert(EKeyVCNV vcnv) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KeyVCNV_Insert(?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, vcnv.getStt());
            st.setString(2, vcnv.getQuestion());
            st.setString(3, vcnv.getAnswer());
            st.setInt(4, vcnv.getSoOHN());
            st.setString(5, vcnv.getPath());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EKeyVCNV vcnv) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KeyVCNV_Update(?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, vcnv.getStt());
            st.setString(2, vcnv.getQuestion());
            st.setString(3, vcnv.getAnswer());
            st.setInt(4, vcnv.getSoOHN());
            st.setString(5, vcnv.getPath());
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
            String sql = "{call KeyVCNV_Delete(?)}";
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
