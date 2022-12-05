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

import dao.IGalleryDAO;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Gallery Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public class GalleryDAO extends DBContext implements IGalleryDAO {

    /**
     * Lấy thông tin tất cả các record trong bảng Gallery theo groupGallery sử
     * dụng phân trang. Kết quả chứa danh sách các đối tượng <code> entity.Gallery
     * </code> có id, title, image, groupGallery
     *
     * @param groupGallery - nhóm ảnh hiển thị có kiểu <code>int</code>
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu <code>int</code>
     * @return danh sách các đối tượng <code>entity.Gallery</code>. Nó là một
     * đối tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Gallery> getAllByPage(int groupGallery, int pageIndex, int pageSize) throws Exception{
        List<Gallery> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "WITH t AS ( \n" +
                    "	SELECT ROW_NUMBER() OVER (ORDER BY id) rownum,* \n" +
                    "    FROM Gallery WHERE groupGallery = ? )\n" +
                    "SELECT * FROM t \n" +
                    "WHERE t.rownum >= (? - 1) * ? + 1 AND t.rownum <= ? * ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, groupGallery);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageIndex);
            st.setInt(5, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setId(rs.getInt(2));
                gallery.setTitle(rs.getString(3));
                gallery.setImage(rs.getString(4));
                gallery.setGroupGallery(rs.getInt(5));
                ls.add(gallery);
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
     * Đếm số lượng các bản ghi trong bảng Gallery theo groupGallery
     *
     * @param groupGallery - nhóm ảnh hiển thị có kiểu <code>int</code>
     * @return số lượng bản ghi có kiểu dữ liệu <code>int</code>
     * @throws java.lang.Exception
     */
    @Override
    public int totalResults(int groupGallery) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT Count(*) FROM Gallery WHERE groupGallery = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, groupGallery);
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
