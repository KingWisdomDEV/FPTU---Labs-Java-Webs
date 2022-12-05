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

import entity.Contact;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Contact Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface IContact {
    
    /**
     * Lấy thông tin tất cả các record trong bảng Contact Kết quả chứa danh sách
     * các đối tượng <code> entity.Contact</code> có id, name, address, tel,
     * email, openHours
     *
     * @return danh sách các đối tượng <code>Contact</code>. Nó là một đối
     * tượng<code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public Contact getInfo() throws Exception;
}

