/*
 *Copyright(C) 2021, King Wisdom
 * J3LP0014
 * Trekking and Hiking Blog
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 10-1-2021                    1.0            King Wisdom                  First Implement
 */
package controller;

import dao.impl.SocialNetworkDAO;
import dao.impl.TrekkingLinkDAO;
import dao.ISocialNetwork;
import dao.ITrekkingLink;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.SocialNetwork;
import entity.TrekkingLink;

/**
 * Lớp này có các phương thức thực hiện nhận yêu cầu của từ trang /trekking-link để
 * phản hồi dữ liệu sang View.<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
@WebServlet(name = "ServletTrekkingLink", urlPatterns = {"/trekking-link"})
public class ServletTrekkingLink extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        // Get List<TrekkingLink> from Database
        ITrekkingLink db = new TrekkingLinkDAO();
        List<TrekkingLink> list = db.getAll();

        // Get List<SocialNetwork> from Database
        ISocialNetwork dbSocial = new SocialNetworkDAO();
        List<SocialNetwork> listSocial = dbSocial.getAll();

        // PAGING START
        int size = list.size(); //số lượng bản ghi trong database
        String spage = request.getParameter("page");
        int pageNum = (spage != null && spage.trim().matches("^[0-9]+$")) ? Integer.parseInt(spage) : 1;
        int perpage = 3;    // số lượng bản ghi hiển thị tối đa trong 1 trang
        int totalPage = (size / perpage) + ((size % perpage == 0 && (pageNum) != 0) ? 0 : 1);//tổng số trang tối đa của list
        if ((pageNum > totalPage && totalPage != 0) || pageNum < 0) {
            response.sendRedirect("../Trekking_and_Hiking/trekking-link");
        } else {
            int start = pageNum * perpage - perpage;// vị trí bản ghi đầu tiên hiển thị ở trang trong database
            int end = ((start + perpage) < list.size()) ? (start + perpage) : list.size();
            int numOfLink = 5;// số lượng link page muốn hiển thị ở view
            int maxPage = (totalPage < numOfLink) ? totalPage : numOfLink;//số page hiển thị tối đa
            int startPage = ((pageNum - (maxPage / 2)) > 0) ? (pageNum - (maxPage / 2)) : 1;
            int endPage = ((startPage + maxPage - 1) < totalPage) ? (startPage + maxPage - 1) : totalPage;
            if ((endPage - startPage) < totalPage && maxPage <= totalPage) {
                startPage = endPage - (numOfLink - 1);
            }
            if (startPage <= 0) {
                startPage = 1;
            }
            if (maxPage > 1) {
                request.setAttribute("startPage", startPage);
                request.setAttribute("endPage", endPage);
                request.setAttribute("totalPage", totalPage);
            }
            // PAGING END

            List<TrekkingLink> data = db.getAllByPage(list, start, end);
            // Pass data to View
            request.setAttribute("listObj", data);
            request.setAttribute("listSocialObj", listSocial);
            request.getRequestDispatcher("View/trekking-links.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("/View/error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("/View/error.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
