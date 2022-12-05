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

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng View Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface IView {
    
    /**
     * Lấy số lượt xem trong bảng View
     *
     * @return số lượng người xem. Nó có kiểu int
     * @throws java.lang.Exception
     */
    public int getViewed() throws Exception;
    
    /**
     * Cập nhật số lượt xem thêm 1 trong bảng View
     *
     * @return số lượng bản ghi đã thay đổi. Nó có kiểu int
     * @throws java.lang.Exception
     */
    public int updateView() throws Exception;
}
