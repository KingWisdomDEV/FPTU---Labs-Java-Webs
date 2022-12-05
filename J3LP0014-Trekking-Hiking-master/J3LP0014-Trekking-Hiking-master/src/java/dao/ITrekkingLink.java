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
import entity.TrekkingLink;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng TrekkingLink Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface ITrekkingLink {
    
    /**
     * Lấy thông tin tất cả các record trong bảng TrekkingLink Kết quả chứa danh sách
     * các đối tượng <code> model.TrekkingLink </code> có id, title, short_desc, link
     *
     * @return danh sách các đối tượng <code>TrekkingLink</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<TrekkingLink> getAll() throws Exception;
    
    /**
     * Lấy thông tin tất cả các record trong bảng TrekkingLink có vị trí từ start đến end trong List.Kết quả chứa danh sách
     * các đối tượng <code> model.TrekkingLink </code> có id, title, short_desc, link
     *
     * @param list danh sách đối tượng <code>TrekkingLink</code>. Nó là một đối tượng <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>TrekkingLink</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<TrekkingLink> getAllByPage(List<TrekkingLink> list, int start, int end) throws Exception;
}
