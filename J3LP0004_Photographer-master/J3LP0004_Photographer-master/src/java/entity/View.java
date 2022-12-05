/*
 * Copyright(C) 2021, Hoàng Văn Tuệ
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 02-03-2021                    1.0            Hoàng Văn Tuệ                 First Implement
 */
package entity;

/**
 * Lớp này có các phương thức và thuộc tính của đối tượng <code>entity.View</code>
 *
 * @author Hoàng Văn Tuệ
 */
public class View {
    private int viewed;

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.View</code>
     *
     */
    public View() {
    }
    
    /**
     * Lấy giá trị của thuộc tính viewed của đối tượng <code>entity.View</code>
     *
     * @return viewed có kiểu dữ liệu <code>int</code>
     */
    public int getViewed() {
        return viewed;
    }
     
    /**
     * Gán giá trị cho thuộc tính viewed của đối tượng <code>entity.View</code>
     *
     * @param viewed - số lượt đã truy cập trang web <code>entity.View</code>
     */
    public void setViewed(int viewed) {
        this.viewed = viewed;
    }
}
