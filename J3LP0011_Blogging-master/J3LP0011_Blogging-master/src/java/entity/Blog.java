/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0011
 * Blogging About My Life
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 30-1-2021                    1.0            King Wisdom                  First Implement
 */
package entity;

import java.sql.Date;

/**
 * Lớp này có các phương thức và thuộc tính của đối tượng Blog<p>
 *
 * @author King Wisdom
 */
public class Blog {
    private int id;
    private String title;
    private String type;
    private String image;
    private String description;
    private String author;
    private Date created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Blog(int id, String title, String type, String image, String description, String author, Date created_at) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.image = image;
        this.description = description;
        this.author = author;
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Blog() {
    }
}
