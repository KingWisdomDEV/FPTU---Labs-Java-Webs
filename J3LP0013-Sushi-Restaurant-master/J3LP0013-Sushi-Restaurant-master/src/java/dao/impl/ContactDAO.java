/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0013
 * The Sushi Restaurant 
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import dao.IContact;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Contact Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class ContactDAO extends DBContext implements IContact {

    /**
     * Lấy thông tin tất cả các record trong bảng Contact Kết quả chứa danh sách
     * các đối tượng <code> entity.Contact</code> có id, name, address, tel,
     * email, openHours
     *
     * @return danh sách các đối tượng <code>Contact</code>. Nó là một đối
     * tượng<code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public Contact getInfo() throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM Contact";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                Contact c = new Contact();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAddress(rs.getString(3));
                c.setTel(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setOpenHours(rs.getString(6));
                return c;
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
