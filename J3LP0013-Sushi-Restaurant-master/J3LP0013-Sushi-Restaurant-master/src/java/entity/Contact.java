/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0013
 * The Sushi Restaurant
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 20-1-2021                    1.0            King Wisdom                  First Implement
 */
package entity;

/**
 * Lớp này có các phương thức và thuộc tính của đối tượng Contact<p>
 *
 * @author King Wisdom
 */
public class Contact {
    private int id;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String openHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public Contact(int id, String name, String address, String tel, String email, String openHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openHours = openHours;
    }

    public Contact() {
    }
}
