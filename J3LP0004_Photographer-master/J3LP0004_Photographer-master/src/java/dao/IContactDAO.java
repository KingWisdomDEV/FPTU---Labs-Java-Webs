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

import entity.Contact;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng Contact Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public interface IContactDAO {
    
    /**
     * Lấy thông tin trong bảng Contact Kết quả là đối tượng<code> entity.Contact</code> có address, city, country, tel, email
     *
     * @return đối tượng thông tin liên hệ <code>entity.Contact</code>. 
     * @throws java.lang.Exception
     */
    public Contact getInfo() throws Exception;
}
