package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;

public class BPoint {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EPoint toEPoint(ResultSet rs) throws SQLException {
        EPoint temp = new EPoint();
        temp.setStt(rs.getInt(1));
        temp.setName(rs.getString(2));
        temp.setDiem(rs.getInt(3));
        return temp;
    }

    public static ObservableList<EPoint> SelectAll() {
        ResultSet rs = null;
        ObservableList<EPoint> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblPoint_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEPoint(rs));
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

    public static void Insert(EPoint point) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblPoint_Insert(?, ?)}";
            st = conn.prepareCall(sql);
            st.setString(1, point.getName());
            st.setInt(2, point.getDiem());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EPoint point) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblPoint_Update(?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setString(1, point.getName());
            st.setInt(2, point.getDiem());
            st.setInt(3, point.getStt());
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
            String sql = "{call tblPoint_Delete(?)}";
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
