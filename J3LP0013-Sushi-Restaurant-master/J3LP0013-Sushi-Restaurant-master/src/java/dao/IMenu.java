/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0013
 * The Sushi Restaurant
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 20-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao;

import entity.Menu;
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
public interface IMenu {
    
    /**
     * Lấy thông tin tất cả các record trong bảng Menu Kết quả chứa danh sách
     * các đối tượng <code>entity.Menu</code> có id, name, price, shortDesc,
     * detailDesc
     *
     * @return danh sách các đối tượng <code>Menu</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    public List<Menu> getAll() throws Exception;
   
    /**
     * Lấy thông tin tất cả các record trong bảng Menu có vị trí từ start đến
     * end trong List.Kết quả chứa danh sách các đối tượng <code> entity.Menu
     * </code> có id, title, short_desc, link
     *
     * @param list danh sách đối tượng <code>Menu</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>Menu</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     */
    public List<Menu> getAllByPage(List<Menu> list, int start, int end) throws Exception;
}
