/*
 * Copyright(C) 2021, King Wisdom
 * J3LP0004
 * Digital News
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-2-2021                    1.0            King Wisdom                  First Implement
 */
package entity;

import java.util.Date;

/**
 * Lớp này có các phương thức và thuộc tính của đối tượng <code>entity.Post</code>
 *
 * @author King Wisdom
 */
public class Post {

    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date createdDate;

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.Post</code>
     *
     */
    public Post() {
    }

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.Post</code>
     *
     * @param id - khóa chính của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>int</code>
     * @param title - tiêu đề của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>String</code>
     * @param description - mô tả nội dung của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>String</code>
     * @param image - địa chỉ ảnh của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>String</code>
     * @param author - tên tác giả của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>String</code>
     * @param createdDate - ngày viết bài của đối tượng <code>entity.Post</code> có kiểu dữ liệu <code>java.util.Date</code>
     */
    public Post(int id, String title, String description, String image, String author, Date createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.createdDate = createdDate;
    }

    /**
     * Lấy giá trị của thuộc tính id của đối tượng <code>entity.Post</code>
     *
     * @return id có kiểu dữ liệu <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Gán giá trị cho thuộc tính id của đối tượng <code>entity.Post</code>
     *
     * @param id - khóa chính của đối tượng <code>entity.Post</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Lấy giá trị của thuộc tính title của đối tượng <code>entity.Post</code>
     *
     * @return title có kiểu dữ liệu <code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gán giá trị cho thuộc tính title của đối tượng <code>entity.Post</code>
     *
     * @param title - tiêu đề của đối tượng <code>entity.Post</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Lấy giá trị của thuộc tính description của đối tượng
     * <code>entity.Post</code>
     *
     * @return description có kiểu dữ liệu <code>String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gán giá trị cho thuộc tính description của đối tượng
     * <code>entity.Post</code>
     *
     * @param description - mô tả chi tiết nội dung của đối tượng
     * <code>entity.Post</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Lấy giá trị của thuộc tính image của đối tượng <code>entity.Post</code>
     *
     * @return image có kiểu dữ liệu <code>String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Gán giá trị cho thuộc tính image của đối tượng <code>entity.Post</code>
     *
     * @param image - địa chỉ trỏ đến ảnh của đối tượng <code>entity.Post</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Lấy giá trị của thuộc tính author của đối tượng <code>entity.Post</code>
     *
     * @return author có kiểu dữ liệu <code>String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gán giá trị cho thuộc tính author của đối tượng <code>entity.Post</code>
     *
     * @param author - tác giả, người đã viết bài của đối tượng
     * <code>entity.Post</code>
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Lấy giá trị của thuộc tính createdDate của đối tượng
     * <code>entity.Post</code>
     *
     * @return createdDate có kiểu dữ liệu <code>java.util.Date</code>
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Gán giá trị cho thuộc tính createdDate của đối tượng
     * <code>entity.Post</code>
     *
     * @param createdDate - thời gian viết bài của đối tượng
     * <code>entity.Post</code>
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
