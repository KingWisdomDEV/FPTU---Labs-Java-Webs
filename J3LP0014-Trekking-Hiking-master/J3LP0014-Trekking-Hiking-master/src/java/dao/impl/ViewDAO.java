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

import dao.IView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng View Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class ViewDAO extends DBContext implements IView {

    /**
     * Lấy số lượt xem trong bảng View
     *
     * @return số lượng người xem. Nó có kiểu int
     * @throws java.lang.Exception
     */
    @Override
    public int getViewed() throws Exception {
        Connection con = getConnection();
        String sql = "SELECT * FROM [View]";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("viewed");
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
     * Cập nhật số lượt xem thêm 1 trong bảng View
     *
     * @return số lượng bản ghi đã thay đổi. Nó có kiểu int
     * @throws java.lang.Exception
     */
    @Override
    public int updateView() throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE [View]\n"
                + "SET viewed = viewed + 1";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            int rowAffected = st.executeUpdate();
            return rowAffected;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
    }
}
