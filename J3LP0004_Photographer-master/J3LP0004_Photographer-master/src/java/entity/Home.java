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
 * Lớp này có các phương thức và thuộc tính của đối tượng <code>entity.Home</code>
 *
 * @author Hoàng Văn Tuệ
 */
public class Home {
    private int id;
    private String title;
    private String image;
    private String description;
    private String link;
    private String altText;

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.Home</code>
     *
     */
    public Home() {
    }

    /**
     * Lấy giá trị của thuộc tính id của đối tượng <code>entity.Home</code>
     *
     * @return id có kiểu dữ liệu <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Gán giá trị cho thuộc tính id của đối tượng <code>entity.Home</code>
     *
     * @param id - khóa chính của đối tượng <code>entity.Home</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Lấy giá trị của thuộc tính title của đối tượng <code>entity.Home</code>
     *
     * @return title có kiểu dữ liệu <code>int</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gán giá trị cho thuộc tính title của đối tượng <code>entity.Home</code>
     *
     * @param title - tiêu đề hiển thị của đối tượng <code>entity.Home</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Lấy giá trị của thuộc tính image của đối tượng <code>entity.Home</code>
     *
     * @return image có kiểu dữ liệu <code>int</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Gán giá trị cho thuộc tính image của đối tượng <code>entity.Home</code>
     *
     * @param image - vị trí chứa ảnh của đối tượng <code>entity.Home</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Lấy giá trị của thuộc tính description của đối tượng <code>entity.Home</code>
     *
     * @return description có kiểu dữ liệu <code>int</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gán giá trị cho thuộc tính description của đối tượng <code>entity.Home</code>
     *
     * @param description - mô tả của nhóm ảnh của đối tượng <code>entity.Home</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Lấy giá trị của thuộc tính link của đối tượng <code>entity.Home</code>
     *
     * @return link có kiểu dữ liệu <code>int</code>
     */
    public String getLink() {
        return link;
    }

    /**
     * Gán giá trị cho thuộc tính link của đối tượng <code>entity.Home</code>
     *
     * @param link - đường truyền truy cập nhóm ảnh của đối tượng <code>entity.Home</code>
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Lấy giá trị của thuộc tính altText của đối tượng <code>entity.Home</code>
     *
     * @return altText có kiểu dữ liệu <code>int</code>
     */
    public String getAltText() {
        return altText;
    }

    /**
     * Gán giá trị cho thuộc tính altText của đối tượng <code>entity.Home</code>
     *
     * @param altText - mô tả của thuộc tính alt của ảnh của đối tượng <code>entity.Home</code>
     */
    public void setAltText(String altText) {
        this.altText = altText;
    }
    
}
