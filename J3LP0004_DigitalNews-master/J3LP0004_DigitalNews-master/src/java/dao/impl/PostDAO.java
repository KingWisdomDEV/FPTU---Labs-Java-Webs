/*
 * Copyright(C) 2021, King Wisdom
 * J3LP0004
 * Digital News
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-2-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.IPostDAO;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Post Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class PostDAO extends DBContext implements IPostDAO {

    /**
     * Lấy thông tin số record(theo totalRecord) gần nhất ngoại trừ Post đang hiển thị trong bảng
     * Post Kết quả chứa danh sách các đối tượng <code>entity.Post</code> có id,
     * title, type, image, description, author, created_at
     *
     * @param totalRecord - tổng số bản ghi sẽ trả về
     * @return danh sách các đối tượng <code>Post</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Post> getTopPostByNumber(int id, int totalRecord) throws Exception {
        List<Post> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT TOP " + totalRecord + " * FROM Post WHERE id != ? ORDER BY createdDate DESC";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Post c = new Post();
                c.setId(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setImage(rs.getString(4));
                c.setAuthor(rs.getString(5));
                c.setCreatedDate(rs.getDate(6));
                ls.add(c);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return ls;
    }
    
    /**
     * Lấy thông tin tất cả các record trong bảng Post theo title sử dụng phân
     * trang.Kết quả chứa danh sách các đối tượng <code> entity.Post
     * </code> có id, title, description, image, author, createdDate
     *
     * @param title - tiêu đè bài viết có kiểu dữ liệu <code>String</code>
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu <code>int</code>
     * @return danh sách các đối tượng <code>entity.Post</code>. Nó là một đối
     * tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Post> getAllByPage(String title, int pageIndex, int pageSize) throws Exception{
        List<Post> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "WITH t AS ( \n" +
                    "	SELECT ROW_NUMBER() OVER (ORDER BY id) rownum,* \n" +
                    "    FROM Post WHERE title like N'%' + ? + '%'  )\n" +
                    "SELECT * FROM t \n" +
                    "WHERE t.rownum >= (? - 1) * ? + 1 AND t.rownum <= ? * ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, pageIndex);
            st.setInt(3, pageSize);
            st.setInt(4, pageIndex);
            st.setInt(5, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                Post c = new Post();
                    c.setId(rs.getInt(2));
                    c.setTitle(rs.getString(3));
                    c.setDescription(rs.getString(4));
                    c.setImage(rs.getString(5));
                    c.setAuthor(rs.getString(6));
                    c.setCreatedDate(rs.getDate(7));
                    ls.add(c);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return ls;
    }
    
    /**
     * Đếm số lượng các record trong bảng Post theo title
     *
     * @param title - tiêu đè bài viết có kiểu dữ liệu <code>String</code>
     * @return số lượng bản ghi
     * @throws java.lang.Exception
     */
    @Override
    public int totalResults(String title) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT Count(*) FROM Post WHERE title like N'%' + ? + '%'";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, title);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return 0;
    }
    
    
    /**
     * Lấy thông tin Post trong bảng Post theo ID. Kết quả chứa danh sách các
     * đối tượng <code>entity.Post</code> có id, name, price, shortDesc,
     * detailDesc
     *
     * @param id - khóa chính của đối tượng <code>entity.Post</code>
     * @return danh sách các đối tượng <code>entity.Post</code>. Nó là một đối
     * tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    @Override
    public Post getPostByID(int id) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM Post where id = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Post obj = new Post();
                obj.setId(rs.getInt(1));
                obj.setTitle(rs.getString(2));
                obj.setDescription(rs.getString(3));
                obj.setImage(rs.getString(4));
                obj.setAuthor(rs.getString(5));
                obj.setCreatedDate(rs.getDate(6));
                return obj;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return null;
    }

}
