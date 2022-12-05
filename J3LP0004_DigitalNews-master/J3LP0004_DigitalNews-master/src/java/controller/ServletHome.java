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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IPostDAO;

/**
 * Lớp này có các phương thức thực hiện nhận yêu cầu của từ trang /home để
 * phản hồi dữ liệu sang View.<p>
 * Bugs: Chưa xuất hiện
 *
 * @author King Wisdom
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
        String sid = request.getParameter("id");// Id lấy từ url
        boolean isExistPost = false; //kiểm tra bài viết có tồn tại hay không
        Post post = null;
        IPostDAO postDAO = new PostDAO();
        int id = 0; // id của bài viết hiện tại
                
        // Nếu không tồn tại param có tên id thì hiển thị blog mới nhất
        if (sid == null) {            
            post = postDAO.getTopPostByNumber(0, 1).get(0);
            id = post.getId();
            isExistPost = true;
        } // Nếu id là số tự nhiên thì kiểm tra id có tồn tại trong Database không
        else if (sid.trim().matches("^[0-9]+$")) {
            id = Integer.parseInt(sid.trim());
            post = postDAO.getPostByID(id);
            isExistPost = (post != null); // nếu id tồn tại thì trả về true, ngược lại trả về false
        }
        
        // Nếu id tồn tại thì gửi dữ liệu post sang view, ngược lại thì báo lỗi
        if (isExistPost == true) {
            request.setAttribute("post", post);
            request.setAttribute("listTop5Post", postDAO.getTopPostByNumber(id, 5));
            request.setAttribute("shortDesc", post.getDescription().substring(0, 255));
            request.setAttribute("lastPostId", postDAO.getTopPostByNumber(0, 1).get(0).getId());
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Post does not exist or has been deleted!!!");
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
