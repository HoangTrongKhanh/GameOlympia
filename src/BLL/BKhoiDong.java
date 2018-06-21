package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EKhoiDong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class BKhoiDong {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EKhoiDong toEKhoiDong(ResultSet rs) throws SQLException {
        EKhoiDong temp = new EKhoiDong();
        temp.setStt(rs.getInt(1));
        temp.setQuestion(rs.getString(2));
        temp.setAnswer(rs.getBoolean(3));
        return temp;
    }

    public static ObservableList<EKhoiDong> SelectAll() {
        ResultSet rs = null;
        ObservableList<EKhoiDong> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KhoiDong_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEKhoiDong(rs));
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

    public static EKhoiDong SelectById(int id) {
        ResultSet rs = null;
        EKhoiDong khoiDong = new EKhoiDong();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call KhoiDong_SelectBySTT(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                khoiDong = toEKhoiDong(rs);
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
        return khoiDong;
    }

    public static void Insert(EKhoiDong khoiDong) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKhoiDong_Insert(?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, khoiDong.getStt());
            st.setString(2, khoiDong.getQuestion());
            st.setBoolean(3, khoiDong.getAnswer());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EKhoiDong khoiDong) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKhoiDong_Update(?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, khoiDong.getStt());
            st.setString(2, khoiDong.getQuestion());
            st.setBoolean(3, khoiDong.getAnswer());
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
            String sql = "{call tblKhoiDong_Delete(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, stt);
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int LastSTT() {
        int result = 0;
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblKhoiDong_LastSTT}";
            st = conn.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { st.close(); } catch (Exception e) {  }
            try { conn.close(); } catch (Exception e) {  }
        }
        return result;
    }

}
