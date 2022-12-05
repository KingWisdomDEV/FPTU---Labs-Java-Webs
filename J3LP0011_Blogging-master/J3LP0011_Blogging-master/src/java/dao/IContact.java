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

import entity.Contact;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Contact Các
 * phương thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code>
 * khi có bất cứ lỗi nào xảy ra trong quá trình truy vấn
 * <p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public interface IContact {

    /**
     * Lấy thông tin Contact trong bảng Contact Kết quả chứa đối tượng <code> model.Contact
     * </code> có description, author
     *
     * @return đối tượng <code> entity.Contact </code>.
     * @throws java.lang.Exception
     */
    public Contact getInfo() throws Exception;
}

