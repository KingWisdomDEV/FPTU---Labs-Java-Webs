/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0011
 * Blogging About My Life
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 30-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import dao.IHome;
import entity.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Home Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class HomeDAO extends DBContext implements IHome {

    /**
     * Lấy thông tin tất cả các record trong bảng Home Kết quả chứa danh sách
     * các đối tượng <code>entity.Home</code> có id, title, type, image, description, author, created_at
     *
     * @return danh sách các đối tượng <code>Home</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM Blog";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Blog c = new Blog();
                c.setId(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setType(rs.getString(3));
                c.setImage(rs.getString(4));
                c.setDescription(rs.getString(5));
                c.setAuthor(rs.getString(6));
                c.setCreated_at(rs.getDate(7));
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
     * Lấy thông tin tất cả các record trong bảng Home có vị trí từ start đến
     * end trong List.Kết quả chứa danh sách các đối tượng <code> model.Home
     * </code> có id, title, type, image, description, author, created_at
     *
     * @param list danh sách đối tượng <code>entity.Home</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     */
    @Override
    public List<Blog> getAllByPage(List<Blog> list, int start, int end) {
        List<Blog> ls = new ArrayList<>();
        for (int i = start; i < end; i++) {
            ls.add(list.get(i));
        }
        return ls;
    }

    /**
     * Lấy thông tin Blog trong bảng Home theo ID. Kết quả chứa danh sách các
     * đối tượng <code>entity.Home</code> có id, name, price, shortDesc,
     * detailDesc
     *
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    @Override
    public Blog getBlogByID(int id) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM Blog where id = ?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Blog obj = new Blog();
                obj.setId(rs.getInt(1));
                obj.setTitle(rs.getString(2));
                obj.setType(rs.getString(3));
                obj.setImage(rs.getString(4));
                obj.setDescription(rs.getString(5));
                obj.setAuthor(rs.getString(6));
                obj.setCreated_at(rs.getDate(7));
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
