/*
 * Copyright(C) 2021, King Wisdom
 * J3LP0004
 * Digital News
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 24-2-2021                    1.0            King Wisdom                  First Implement
 */
package controller;

import dao.impl.PostDAO;
import entity.Post;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IPostDAO;

/**
 * Lớp này có các phương thức thực hiện nhận yêu cầu của từ trang /search để
 * phản hồi dữ liệu sang View.<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
 */
@WebServlet(name = "ServletSearch", urlPatterns = {"/search"})
public class ServletSearch extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String stitle = request.getParameter("keyword");
        String title = (stitle != null) ? stitle.trim() : "";//keyword lấy từ url khi người dùng gửi form
        
        IPostDAO postDAO = new PostDAO();
        Post lastPost = postDAO.getTopPostByNumber(-1, 1).get(0);
        int lastPostId = lastPost.getId(); // id của bài viết cuối cùng gần nhất

        // PAGING START
        int size = postDAO.totalResults(title); //số lượng bản ghi trong database
        String spage = request.getParameter("page");
        int pageNum = (spage != null && spage.trim().matches("^[0-9]+$")) ? Integer.parseInt(spage) : 1;
        int pageSize = 3;    // số lượng bản ghi hiển thị tối đa trong 1 trang
        int totalPage = (size / pageSize) + ((size % pageSize == 0 && (pageNum) != 0) ? 0 : 1);//tổng số trang tối đa của list
        if ((pageNum > totalPage && totalPage != 0) || pageNum < 0) {
            response.sendRedirect("../myblog.com/home");
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
            List<Post> data = postDAO.getAllByPage(title, pageNum, pageSize);
            request.setAttribute("listObj", data);
            request.setAttribute("listTop5Post", postDAO.getTopPostByNumber(0, 5));
            request.setAttribute("shortDesc", lastPost.getDescription().substring(0, 255));
            request.setAttribute("lastPostId", lastPostId);
            request.getRequestDispatcher("/view/search.jsp").forward(request, response);
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
