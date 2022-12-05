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
 * Lớp này có các phương thức và thuộc tính của đối tượng <code>entity.Contact</code>
 *
 * @author Hoàng Văn Tuệ
 */
public class Contact {
    private String address;
    private String city;
    private String country;
    private String tel;
    private String email;

    /**
     * Hàm khởi tạo dùng để khởi tạo dữ liệu cho đối tượng <code>entity.Contact</code>
     *
     */
    public Contact() {
    }

    /**
     * Lấy giá trị của thuộc tính address của đối tượng <code>entity.Contact</code>
     *
     * @return address - địa chỉ có kiểu dữ liệu <code>String</code>
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gán giá trị cho thuộc tính address của đối tượng <code>entity.Contact</code>
     *
     * @param address - thông tin địa chỉ của đối tượng <code>entity.Contact</code>
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Lấy giá trị của thuộc tính city của đối tượng <code>entity.Contact</code>
     *
     * @return city - thông tin thành phố có kiểu dữ liệu <code>String</code>
     */
    public String getCity() {
        return city;
    }

    /**
     * Gán giá trị cho thuộc tính city của đối tượng <code>entity.Contact</code>
     *
     * @param city - thông tin thành phố của đối tượng <code>entity.Contact</code>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Lấy giá trị của thuộc tính country của đối tượng <code>entity.Contact</code>
     *
     * @return country - thông tin đất nước có kiểu dữ liệu <code>String</code>
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gán giá trị cho thuộc tính country của đối tượng <code>entity.Contact</code>
     *
     * @param country - thông tin đất nước của đối tượng <code>entity.Contact</code>
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Lấy giá trị của thuộc tính tel của đối tượng <code>entity.Contact</code>
     *
     * @return tel - thông tin số điện thoại có kiểu dữ liệu <code>String</code>
     */
    public String getTel() {
        return tel;
    }

    /**
     * Gán giá trị cho thuộc tính tel của đối tượng <code>entity.Contact</code>
     *
     * @param tel - thông tin số điện thoại của đối tượng <code>entity.Contact</code>
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Lấy giá trị của thuộc tính email của đối tượng <code>entity.Contact</code>
     *
     * @return email - thông tin email có kiểu dữ liệu <code>String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gán giá trị cho thuộc tính email của đối tượng <code>entity.Contact</code>
     *
     * @param email - thông tin email của đối tượng <code>entity.Contact</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
