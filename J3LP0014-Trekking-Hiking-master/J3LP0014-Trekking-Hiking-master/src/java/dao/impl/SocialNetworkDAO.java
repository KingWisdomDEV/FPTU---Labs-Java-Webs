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

import dao.ISocialNetwork;
import entity.SocialNetwork;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng SocialNetwork Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class SocialNetworkDAO extends DBContext implements ISocialNetwork {

    /**
     * Lấy thông tin tất cả các record trong bảng SocialNetwork Kết quả chứa danh sách
     * các đối tượng <code> model.SocialNetwork </code> có id, name, link, icon
     *
     * @return danh sách các đối tượng <code>SocialNetwork</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<SocialNetwork> getAll() throws Exception {
        List<SocialNetwork> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM SocialNetwork";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                SocialNetwork c = new SocialNetwork();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setLink(rs.getString(3));
                c.setIcon(rs.getString(4));
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
