package BLL;

import ConnectionDatabase.ConnectionUtils;
import EntityOlympia.ETangToc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class BTangToc {

    private static Connection conn = null;
    private static CallableStatement st = null;

    private static ETangToc toETangToc(ResultSet rs) throws SQLException {
        ETangToc temp = new ETangToc();
        temp.setStt(rs.getInt(1));
        temp.setQuestion(rs.getString(2));
        temp.setAnsA(rs.getString(3));
        temp.setAnsB(rs.getString(4));
        temp.setAnsC(rs.getString(5));
        temp.setAnsD(rs.getString(6));
        temp.setAnswer(rs.getString(7));
        return temp;
    }

    public static ObservableList<ETangToc> SelectAll() {
        ResultSet rs = null;
        ObservableList<ETangToc> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblTangToc_SelectAll}";
            st = conn.prepareCall(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                result.add(toETangToc(rs));
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

    public static ObservableList<ETangToc> SelectById(int id) {
        ResultSet rs = null;
        ObservableList<ETangToc> result = FXCollections.observableArrayList();
        try{
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblTangToc_SelectByID(?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery(sql);

            while (rs.next()) {
                result.add(toETangToc(rs));
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

    public static void Insert(ETangToc tangToc) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblTangToc_Insert(?, ?, ?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, tangToc.getStt());
            st.setString(2, tangToc.getQuestion());
            st.setString(3, tangToc.getAnsA());
            st.setString(4, tangToc.getAnsB());
            st.setString(5, tangToc.getAnsC());
            st.setString(6, tangToc.getAnsD());
            st.setString(7, tangToc.getAnswer());
            st.execute();

            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(ETangToc tangToc) {
        try {
            conn = ConnectionUtils.getMyConnection();
            String sql = "{call tblTangToc_Update(?, ?, ?, ?, ?, ?, ?)}";
            st = conn.prepareCall(sql);
            st.setInt(1, tangToc.getStt());
            st.setString(2, tangToc.getQuestion());
            st.setString(3, tangToc.getAnsA());
            st.setString(4, tangToc.getAnsB());
            st.setString(5, tangToc.getAnsC());
            st.setString(6, tangToc.getAnsD());
            st.setString(7, tangToc.getAnswer());
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
            String sql = "{call tblTangToc_Delete(?)";
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
            String sql = "{call tblTangToc_LastSTT}";
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
