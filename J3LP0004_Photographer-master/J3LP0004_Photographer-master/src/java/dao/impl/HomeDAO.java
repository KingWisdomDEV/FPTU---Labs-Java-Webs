/*
 * Copyright(C) 2021, Hoàng Văn Tuệ
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 02-03-2021                    1.0            Hoàng Văn Tuệ                 First Implement
 */
package dao.impl;

import dao.IHomeDAO;
import entity.Home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Home Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public class HomeDAO extends DBContext implements IHomeDAO {

    /**
     * Lấy thông tin tất cả các record trong bảng Home sử dụng phân trang.Kết
     * quả chứa danh sách các đối tượng <code> entity.Home
     * </code> có id, title, image, description, link, altText
     *
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu
     * <code>int</code>
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối
     * tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Home> getAllByPage(int pageIndex, int pageSize) throws Exception {
        List<Home> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "WITH t AS ( \n"
                + "	SELECT ROW_NUMBER() OVER (ORDER BY id) rownum,* \n"
                + "    FROM Home )\n"
                + "SELECT * FROM t \n"
                + "WHERE t.rownum >= (? - 1) * ? + 1 AND t.rownum <= ? * ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageIndex);
            st.setInt(4, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                Home home = new Home();
                home.setId(rs.getInt(2));
                home.setTitle(rs.getString(3));
                home.setImage(rs.getString(4));
                home.setDescription(rs.getString(5));
                home.setLink(rs.getString(6));
                home.setAltText(rs.getString(7));
                ls.add(home);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return ls;
    }

    /**
     * Đếm số lượng các bản ghi trong bảng Home
     *
     * @return số lượng bản ghi có kiểu dữ liệu <code>int</code>
     * @throws java.lang.Exception
     */
    @Override
    public int totalResults() throws Exception {
        Connection con = getConnection();
        String sql = "SELECT Count(*) FROM Home";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return 0;
    }

}
