/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0011
 * Blogging About My Life
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 30-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao;

import java.util.List;
import entity.Blog;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Home Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface IHome {
    
    /**
     * Lấy thông tin tất cả các record trong bảng Home Kết quả chứa danh sách
     * các đối tượng <code>entity.Home</code> có id, title, type, image, description, author, created_at
     *
     * @return danh sách các đối tượng <code>Home</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    public List<Blog> getAll() throws Exception;
    
    /**
     * Lấy thông tin tất cả các record trong bảng Home có vị trí từ start đến
     * end trong List.Kết quả chứa danh sách các đối tượng <code> model.Home
     * </code> có id, title, type, image, description, author, created_at
     *
     * @param list danh sách đối tượng <code>entity.Home</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @param start vị trí bắt đầu trong List
     * @param end vị trí kết thúc trong List
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     */
    public List<Blog> getAllByPage(List<Blog> list, int start, int end) throws Exception;
    
    /**
     * Lấy thông tin Blog trong bảng Home theo ID. Kết quả chứa danh sách các
     * đối tượng <code>entity.Home</code> có id, name, price, shortDesc,
     * detailDesc
     *
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    public Blog getBlogByID(int id) throws Exception;
}
