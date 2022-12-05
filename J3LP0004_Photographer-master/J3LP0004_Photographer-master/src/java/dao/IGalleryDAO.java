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
import entity.Gallery;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Gallery Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public interface IGalleryDAO {

    /**
     * Lấy thông tin tất cả các record trong bảng Gallery theo groupGallery sử
     * dụng phân trang. Kết quả chứa danh sách các đối tượng <code> entity.Gallery
     * </code> có id, title, image, groupGallery
     *
     * @param groupGallery - nhóm ảnh hiển thị có kiểu <code>int</code>
     * @param pageIndex - vị trí trang hiển thị có kiểu dữ liệu <code>int</code>
     * @param pageSize - số lượng bản ghi hiển thị tối đa có kiểu dữ liệu <code>int</code>
     * @return danh sách các đối tượng <code>entity.Gallery</code>. Nó là một
     * đối tượng <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<Gallery> getAllByPage(int groupGallery, int pageIndex, int pageSize) throws Exception;

    /**
     * Đếm số lượng các bản ghi trong bảng Gallery theo groupGallery
     *
     * @param groupGallery - nhóm ảnh hiển thị có kiểu <code>int</code>
     * @return số lượng bản ghi có kiểu dữ liệu <code>int</code>
     * @throws java.lang.Exception
     */
    public int totalResults(int groupGallery) throws Exception;
}
