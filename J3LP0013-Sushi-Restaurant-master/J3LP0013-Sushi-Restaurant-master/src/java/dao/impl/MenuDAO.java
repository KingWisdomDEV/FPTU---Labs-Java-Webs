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

import dao.IMenu;
import entity.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Menu Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class MenuDAO extends DBContext implements IMenu {

    /**
     * Lấy thông tin tất cả các record trong bảng Menu Kết quả chứa danh sách
     * các đối tượng <code>entity.Menu</code> có id, name, price, shortDesc,
     * detailDesc
     *
     * @return danh sách các đối tượng <code>Menu</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Menu> getAll() throws Exception {
        List<Menu> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM Menu";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Menu c = new Menu();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setPrice(rs.getDouble(3));
                c.setShortDesc(rs.getString(4));
                c.setDetailDesc(rs.getString(5));
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
     * Lấy thông tin tất cả các record trong bảng Menu có vị trí từ start đến
     * end trong List.Kết quả chứa danh sách các đối tượng <code> entity.Menu
     * </code> có id, title, short_desc, link
     *
     * @param list danh sách đối tượng <code>entity.Menu</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>entity.Menu</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     */
    @Override
    public List<Menu> getAllByPage(List<Menu> list, int start, int end) {
        List<Menu> ls = new ArrayList<>();
        for (int i = start; i < end; i++) {
            ls.add(list.get(i));
        }
        return ls;
    }
}
