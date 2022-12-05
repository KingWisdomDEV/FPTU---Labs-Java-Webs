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
 * Lớp này có các phương thức và thuộc tính của đối tượng View<p>
 *
 * @author King Wisdom
 */
public class View {
    private int viewed;

    public View() {
    }

    public View(int viewed) {
        this.viewed = viewed;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }
    
}
