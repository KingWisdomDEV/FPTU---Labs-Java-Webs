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
 * Lớp này có các phương thức và thuộc tính của đối tượng <code>entity.Gallery</code>
 *
 * @author Hoàng Văn Tuệ
 */
public class Gallery {
    private int id;
    private String title;
    private String image;
    private int groupGallery;

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.Gallery</code>
     *
     */
    public Gallery() {
    }

    /**
     * Lấy giá trị của thuộc tính id của đối tượng <code>entity.Gallery</code>
     *
     * @return id có kiểu dữ liệu <code>String</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Gán giá trị cho thuộc tính id của đối tượng <code>entity.Gallery</code>
     *
     * @param id - khóa chính của đối tượng <code>entity.Gallery</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Lấy giá trị của thuộc tính title của đối tượng <code>entity.Gallery</code>
     *
     * @return title có kiểu dữ liệu <code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gán giá trị cho thuộc tính title của đối tượng <code>entity.Gallery</code>
     *
     * @param title - tiêu đề ảnh của đối tượng <code>entity.Gallery</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Lấy giá trị của thuộc tính image của đối tượng <code>entity.Gallery</code>
     *
     * @return image có kiểu dữ liệu <code>String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Gán giá trị cho thuộc tính image của đối tượng <code>entity.Gallery</code>
     *
     * @param image - vị trí chứa ảnh của đối tượng <code>entity.Gallery</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Lấy giá trị của thuộc tính groupGallery của đối tượng <code>entity.Gallery</code>
     *
     * @return groupGallery có kiểu dữ liệu <code>int</code>
     */
    public int getGroupGallery() {
        return groupGallery;
    }

    /**
     * Gán giá trị cho thuộc tính groupGallery của đối tượng <code>entity.Gallery</code>
     *
     * @param groupGallery - nhóm ảnh hiển thị của đối tượng <code>entity.Gallery</code>
     */
    public void setGroupGallery(int groupGallery) {
        this.groupGallery = groupGallery;
    }
    
}
