/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0013
 * The Sushi Restaurant
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 20-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp này có các phương thức thực hiện kết nối với Database SQLServer. Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class DBContext {

    /**
     * Mở kết nối với Database SQLServer
     *
     * @return Đối tượng <code>Connection</code>. Nó là một đối tượng
     * <code>java.sql.Connection</code>
     * @throws java.lang.Exception
     */
    public Connection getConnection() throws Exception {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    /**
     * Đóng kết nối ResultSet với Database SQLServer
     *
     * @param rs đối tượng kết nối ResultSet trong Database SQLServer
     * @throws java.lang.Exception
     */
    public void closeRS(ResultSet rs) throws Exception {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * Đóng kết nối PreparedStatement với Database SQLServer
     *
     * @param st đối tượng kết nối PreparedStatement trong Database SQLServer
     * @throws java.lang.Exception
     */
    public void closePS(PreparedStatement st) throws Exception {
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    /**
     * Đóng kết nối Connection với Database SQLServer
     *
     * @param con đối tượng kết nối Connection trong Database SQLServer
     * @throws java.lang.Exception
     */
    public void closeCon(Connection con) throws Exception {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "J3SP0013_Sushi_Restaurant";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

}
