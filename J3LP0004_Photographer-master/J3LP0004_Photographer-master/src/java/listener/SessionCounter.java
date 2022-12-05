/*
 * Copyright(C) 2021, Hoàng Văn Tuệ
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 02-03-2021                    1.0            Hoàng Văn Tuệ                 First Implement
 */
package listener;

import dao.impl.ViewDAO;
import dao.IViewDAO;
import javax.servlet.http.*;

/**
 * Listener that keeps track of the number of sessions that the Web application
 * is currently using and has ever used in its life cycle.
 */
/**
 * Lớp này có các phương thức khi Session được tạo hoặc bị ngắt
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
public class SessionCounter implements HttpSessionListener {

    /**
     * Cập nhật số lượng lượt xem và tạo Session đếm lượt xem theo format
     *
     * @param event khi Session được tạo mới
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        IViewDAO viewDAO = new ViewDAO();
        try {
            viewDAO.updateView();
            HttpSession session = (HttpSession) event.getSession();
            session.setAttribute("views", String.format("%06d", viewDAO.getViewed()));
        } catch (Exception ex) {
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }

}
