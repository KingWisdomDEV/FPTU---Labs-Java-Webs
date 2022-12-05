/*
 * Copyright(C) 2021, King Wisdom
 * J3LP0004
 * Digital News
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-2-2021                    1.0            King Wisdom                  First Implement
 */
package dao;

import java.util.List;
import entity.Post;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Post Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface IPostDAO {

    /**
     * Lấy thông tin số record(theo totalRecord) gần nhất ngoại trừ Post đang
     * hiển thị trong bảng Post Kết quả chứa danh sách các đối tượng
     * <code>entity.Post</code> có id, title, description, image, author,
     * createdDate
     *
     * @param id - khóa chính của đối tượng <code>entity.Post</code>
     * @param totalRecord - tổng số bản ghi sẽ trả về
     * @return danh sách các đối tượng <code>Post</code>. Nó là một đối tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    public List<Post> getTopPostByNumber(int id, int totalRecord) throws Exception;

    /**
     * Lấy thông tin tất cả các record trong bảng Post theo title sử dụng phân
     * trang.Kết quả chứa danh sách các đối tượng <code> entity.Post
     * </code> có id, title, description, image, author, createdDate
     *
     * @param title - tiêu đè bài viết có kiểu dữ liệu <code>String</code>
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu <code>int</code>
     * @return danh sách các đối tượng <code>entity.Post</code>. Nó là một đối
     * tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<Post> getAllByPage(String title, int pageIndex, int pageSize) throws Exception;

    /**
     * Đếm số lượng các record trong bảng Post theo title
     *
     * @param title - tiêu đè bài viết có kiểu dữ liệu <code>String</code>
     * @return số lượng bản ghi
     * @throws java.lang.Exception
     */
    public int totalResults(String title) throws Exception;

    /**
     * Lấy thông tin Post trong bảng Post theo ID. Kết quả chứa danh sách các
     * đối tượng <code>entity.Post</code> có id, title, description, image,
     * author, createdDate
     *
     * @param id - khóa chính của đối tượng <code>entity.Post</code>
     * @return danh sách các đối tượng <code>entity.Post</code>. Nó là một đối
     * tượng <code> java.util.List
     * </code>
     * @throws java.lang.Exception
     */
    public Post getPostByID(int id) throws Exception;

}
