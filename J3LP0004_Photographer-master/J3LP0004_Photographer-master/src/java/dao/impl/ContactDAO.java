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

import dao.IContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Contact Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public class ContactDAO extends DBContext implements IContactDAO {

    /**
     * Lấy thông tin trong bảng Contact Kết quả là đối tượng<code> entity.Contact</code> có address, city, country, tel, email
     *
     * @return đối tượng thông tin liên hệ <code>entity.Contact</code>. 
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
                Contact contact = new Contact();
                contact.setAddress(rs.getString(1));
                contact.setCity(rs.getString(2));
                contact.setCountry(rs.getString(3));
                contact.setTel(rs.getString(4));
                contact.setEmail(rs.getString(5));
                return contact;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return null;
    }

}
