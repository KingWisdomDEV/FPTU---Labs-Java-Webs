/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0014
 * Trekking and Hiking Blog
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 10-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao;

import java.util.List;
import entity.SocialNetwork;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng SocialNetwork Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface ISocialNetwork {
    
    /**
     * Lấy thông tin tất cả các record trong bảng SocialNetwork Kết quả chứa danh sách
     * các đối tượng <code> model.SocialNetwork </code> có id, name, link, icon
     *
     * @return danh sách các đối tượng <code>SocialNetwork</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<SocialNetwork> getAll() throws Exception;
}
