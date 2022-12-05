/*
 * Copyright(C) 2021, Hoàng Văn Tuệ
 * J3LP0017
 * Photographer
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 02-03-2021                    1.0            Hoàng Văn Tuệ                 First Implement
 */
package controller;

import dao.IHomeDAO;
import dao.impl.HomeDAO;
import entity.Home;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Lớp này có các phương thức thực hiện nhận yêu cầu của từ trang /home để
 * phản hồi dữ liệu sang View.<p>
 * Bugs: Chưa xuất hiện
 *
 * @author Hoàng Văn Tuệ
 */
@WebServlet(name = "ServletHome", urlPatterns = {"/home"})
public class ServletHome extends HttpServlet {

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
        IHomeDAO homeDAO = new HomeDAO();
        
        // PAGING START
        int size = homeDAO.totalResults(); //số lượng bản ghi trong database
        String spage = request.getParameter("page");
        int pageNum = (spage != null && spage.trim().matches("^[0-9]+$")) ? Integer.parseInt(spage) : 1;
        int pageSize = 3;    // số lượng bản ghi hiển thị tối đa trong 1 trang
        int totalPage = (size / pageSize) + ((size % pageSize == 0 && (pageNum) != 0) ? 0 : 1);//tổng số trang tối đa của list
        if ((pageNum > totalPage && totalPage != 0) || pageNum < 0) {
            response.sendRedirect("../kingphotos.com/home");
        } else {
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

            // Pass data to View
            List<Home> data = homeDAO.getAllByPage(pageNum, pageSize);
            request.setAttribute("listObj", data);
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
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
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
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
            request.getRequestDispatcher("/view/error.jsp").forward(request, response);
        }
    }

}
