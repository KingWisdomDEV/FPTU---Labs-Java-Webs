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

import dao.ITrekkingLink;
import entity.TrekkingLink;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng TrekkingLink Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class TrekkingLinkDAO extends DBContext implements ITrekkingLink{
    
    /**
     * Lấy thông tin tất cả các record trong bảng TrekkingLink Kết quả chứa danh sách
     * các đối tượng <code> model.TrekkingLink </code> có id, title, short_desc, link
     *
     * @return danh sách các đối tượng <code>TrekkingLink</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<TrekkingLink> getAll() throws Exception{
        List<TrekkingLink> ls = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM TrekkingLink";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                TrekkingLink c = new TrekkingLink();
                c.setId(rs.getInt(1));
                c.setTitle(rs.getString(2));
                c.setShort_desc(rs.getString(3));
                c.setLink(rs.getString(4));
                ls.add(c);
            }
        } catch (SQLException e) {
            throw e;
        }
        finally{
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return ls;
    }
    
    /**
     * Lấy thông tin tất cả các record trong bảng TrekkingLink có vị trí từ start đến end trong List.Kết quả chứa danh sách
     * các đối tượng <code> model.TrekkingLink </code> có id, title, short_desc, link
     *
     * @param list danh sách đối tượng <code>TrekkingLink</code>. Nó là một đối tượng <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>TrekkingLink</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     */
    @Override
    public List<TrekkingLink> getAllByPage(List<TrekkingLink> list, int start, int end) {
        List<TrekkingLink> ls = new ArrayList<>();
        for (int i = start; i < end; i++) {
            ls.add(list.get(i));
        }
        return ls;
    }
    
}
