/*
 * Copyright(C) 2021, Hoàng Văn Tuệ
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 02-03-2021                    1.0            Hoàng Văn Tuệ                 First Implement
 */
package dao;

import java.util.List;
import entity.Home;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Home Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public interface IHomeDAO {
    
    /**
     * Lấy thông tin tất cả các record trong bảng Home sử dụng phân trang.Kết
     * quả chứa danh sách các đối tượng <code> entity.Home
     * </code> có id, title, image, description, link, altText
     *
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu
     * <code>int</code>
     * @return danh sách các đối tượng <code>entity.Home</code>. Nó là một đối
     * tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<Home> getAllByPage(int pageIndex, int pageSize) throws Exception;
    
    /**
     * Đếm số lượng các bản ghi trong bảng Home
     *    
     * @return số lượng bản ghi có kiểu dữ liệu <code>int</code>
     * @throws java.lang.Exception
     */
    public int totalResults() throws Exception;
}
