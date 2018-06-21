package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EVuotChuongNgaiVat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class BVuotChuongNgaiVat {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EVuotChuongNgaiVat toEVuotChuongNgaiVat(ResultSet rs) throws SQLException {
        EVuotChuongNgaiVat temp = new EVuotChuongNgaiVat();
        temp.setStt(rs.getInt(1));
        temp.setSttHN(rs.getInt(2));
        temp.setSoOHN(rs.getInt(3));
        temp.setQuestion(rs.getString(4));
        temp.setAnswer(rs.getString(5));
        return temp;
    }

    public static ObservableList<EVuotChuongNgaiVat> SelectAll() {
        ResultSet rs = null;
        ObservableList<EVuotChuongNgaiVat> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVat_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVuotChuongNgaiVat(rs));
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

    public static ObservableList<EVuotChuongNgaiVat> SelectById(int id) {
        ResultSet rs = null;
        ObservableList<EVuotChuongNgaiVat> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVatSelectByID(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVuotChuongNgaiVat(rs));
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

    public static EVuotChuongNgaiVat SelectBy2Id(int stt, int stthn) {
        ResultSet rs = null;
        EVuotChuongNgaiVat result = new EVuotChuongNgaiVat();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVat_SelectBy2ID(?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, stt);
            st.setInt(2, stthn);
            rs = st.executeQuery();

            while (rs.next()) {
                result = toEVuotChuongNgaiVat(rs);
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

    public static void Insert(EVuotChuongNgaiVat vuotChuongNgaiVat) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVat_Insert(?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, vuotChuongNgaiVat.getStt());
            st.setInt(2, vuotChuongNgaiVat.getSttHN());
            st.setInt(3, vuotChuongNgaiVat.getSoOHN());
            st.setString(4, vuotChuongNgaiVat.getQuestion());
            st.setString(5, vuotChuongNgaiVat.getAnswer());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EVuotChuongNgaiVat vuotChuongNgaiVat) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVat_Update(?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, vuotChuongNgaiVat.getStt());
            st.setInt(2, vuotChuongNgaiVat.getSttHN());
            st.setInt(3, vuotChuongNgaiVat.getSoOHN());
            st.setString(4, vuotChuongNgaiVat.getQuestion());
            st.setString(5, vuotChuongNgaiVat.getAnswer());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(EVuotChuongNgaiVat vuotChuongNgaiVat) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVuotChuongNgaiVat_Delete(?, ?)";
            st = conn.prepareCall(sql);
            st.setInt(1, vuotChuongNgaiVat.getStt());
            st.setInt(2, vuotChuongNgaiVat.getSttHN());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
