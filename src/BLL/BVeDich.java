package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.EVeDich;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class BVeDich {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static EVeDich toEVeDich(ResultSet rs) throws SQLException {
        EVeDich temp = new EVeDich();
        temp.setStt(rs.getInt(1));
        temp.setQuestion(rs.getString(2));
        temp.setAnsA(rs.getString(3));
        temp.setAnsB(rs.getString(4));
        temp.setAnsC(rs.getString(5));
        temp.setAnsD(rs.getString(6));
        temp.setAnswer(rs.getString(7));
        temp.setPoint(rs.getInt(8));
        return temp;
    }

    public static ObservableList<EVeDich> SelectAll() {
        ResultSet rs = null;
        ObservableList<EVeDich> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVeDich(rs));
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

    public static ObservableList<EVeDich> SelectById(int id) {
        ResultSet rs = null;
        ObservableList<EVeDich> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_SelectByID(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVeDich(rs));
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

    public static ObservableList<EVeDich> SelectBy2Id(int stt, int stthn) {
        ResultSet rs = null;
        ObservableList<EVeDich> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_SelectBy2ID(?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, stt);
            st.setInt(2, stthn);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVeDich(rs));
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

    public static ObservableList<EVeDich> SelectByPoint(int point) {
        ResultSet rs = null;
        ObservableList<EVeDich> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_SelectbyPoint(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, point);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toEVeDich(rs));
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

    public static void Insert(EVeDich veDich) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_Insert(?, ?, ?, ?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, veDich.getStt());
            st.setString(2, veDich.getQuestion());
            st.setString(3, veDich.getAnsA());
            st.setString(4, veDich.getAnsB());
            st.setString(5, veDich.getAnsC());
            st.setString(6, veDich.getAnsD());
            st.setString(7, veDich.getAnswer());
            st.setInt(8, veDich.getPoint());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(EVeDich veDich) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_Update(?, ?, ?, ?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, veDich.getStt());
            st.setString(2, veDich.getQuestion());
            st.setString(3, veDich.getAnsA());
            st.setString(4, veDich.getAnsB());
            st.setString(5, veDich.getAnsC());
            st.setString(6, veDich.getAnsD());
            st.setString(7, veDich.getAnswer());
            st.setInt(8, veDich.getPoint());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Delete(EVeDich veDich) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblVeDich_Delete(?, ?)";
            st = conn.prepareCall(sql);
            st.setInt(1, veDich.getStt());
            st.setInt(2, veDich.getPoint());
            st.executeUpdate();

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
            String sql = "{call tblVeDich_LastSTT}";
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
