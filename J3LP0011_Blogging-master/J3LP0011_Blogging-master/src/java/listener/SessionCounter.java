/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0011
 * Blogging About My Life
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 30-1-2021                    1.0            King Wisdom                  First Implement
 */
package listener;

import dao.impl.ViewDAO;
import dao.IView;
import javax.servlet.http.*;

/**
 * Listener that keeps track of the number of sessions that the Web application
 * is currently using and has ever used in its life cycle.
 */
/**
 * Lớp này có các phương thức khi Session được tạo hoặc bị ngắt
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
public class SessionCounter implements HttpSessionListener {

    /**
     * Cập nhật số lượng lượt xem và tạo Session đếm lượt xem theo format
     *
     * @param event khi Session được tạo mới
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        IView dbView = new ViewDAO();
        try {
            dbView.updateView();
            HttpSession session = (HttpSession) event.getSession();
            session.setAttribute("views", String.format("%06d", dbView.getViewed()));
        } catch (Exception ex) {
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }

}
