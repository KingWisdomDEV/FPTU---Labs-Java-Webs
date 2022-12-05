/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0014
 * Trekking and Hiking Blog
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 10-1-2021                    1.0            King Wisdom                  First Implement
 */
package dao.impl;

import dao.IPhotoAlbum;
import entity.PhotoAlbum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này có các phương thức thực hiện truy vấn dữ liệu từ bảng PhotoAlbum Các phương
 * thức sẽ trả về một đối tượng của lớp <code>java.lang.Exception</code> khi có
 * bất cứ lỗi nào xảy ra trong quá trình truy vấn<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class PhotoAlbumDAO extends DBContext implements IPhotoAlbum{   
    
    /**
     * Lấy thông tin tất cả các record trong bảng PhotoAlbum Kết quả chứa danh sách
     * các đối tượng <code> model.PhotoAlbum </code> có id, name, image
     *
     * @return danh sách các đối tượng <code>PhotoAlbum</code>. Nó là một đối tượng
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<PhotoAlbum> getAll() throws Exception{
        List<PhotoAlbum> ls = new ArrayList<>();
        Connection con =getConnection();
        String sql = "SELECT * FROM PhotoAlbum";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                PhotoAlbum c = new PhotoAlbum();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setImage(rs.getString(3));
                ls.add(c);
            }
        } catch (SQLException e) {
            throw e;
        }
        finally{
            closeRS(rs);
            closePS(st);
            closeCon(con);
        }
        return ls;
    }  
    
}
