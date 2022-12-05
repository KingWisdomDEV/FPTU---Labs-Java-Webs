/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0014
 * Trekking and Hiking Blog
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 10-1-2021                    1.0            King Wisdom                  First Implement
 */
package entity;

/**
 * Lớp này có các phương thức và thuộc tính của đối tượng TrekkingLink<p>
 *
 * @author King Wisdom
 */
public class TrekkingLink {
    private int id;
    private String title;
    private String short_desc;
    private String link;

    public TrekkingLink() {
    }

    public TrekkingLink(int id, String title, String short_desc, String link) {
        this.id = id;
        this.title = title;
        this.short_desc = short_desc;
        this.link = link;
    }

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

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
