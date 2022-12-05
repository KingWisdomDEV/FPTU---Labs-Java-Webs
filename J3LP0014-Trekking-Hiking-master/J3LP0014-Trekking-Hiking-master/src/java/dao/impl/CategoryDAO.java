/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0014
 * Trekking and Hiking Blog
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 10-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import dao.ICategory;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Category Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class CategoryDAO extends DBContext implements ICategory {

    /**
     * Lấy thông tin tất cả các record trong bảng Category Kết quả chứa danh
     * sách các đối tượng <code> model.Category </code> có id, name, short_desc,
     * image, link
     *
     * @return danh sách các đối tượng <code>Category</code>. Nó là một đối
     * tượng <code> java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Category> getAll() throws Exception {
        List<Category> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM Category";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setShort_desc(rs.getString(3));
                c.setImage(rs.getString(4));
                c.setLink(rs.getString(5));
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

}
