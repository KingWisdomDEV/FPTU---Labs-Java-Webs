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

import dao.IHome;
import entity.Home;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Home Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class HomeDAO extends DBContext implements IHome {

    /**
     * Lấy thông tin tất cả các record trong bảng Home Kết quả chứa danh sách
     * các đối tượng <code> model.Home </code> có id, title, description, image
     *
     * @return danh sách các đối tượng <code>Home</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Home> getAll() throws Exception {
        List<Home> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM Home";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Home c = new Home();
                c.setId(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setDescription(rs.getString(3));
                c.setImage(rs.getString(4));
                ls.add(c);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return ls;
    }

}
