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

import dao.impl.CategoryDAO;
import dao.impl.HomeDAO;
import dao.impl.SocialNetworkDAO;
import dao.ICategory;
import dao.IHome;
import dao.ISocialNetwork;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Category;
import entity.Home;
import entity.SocialNetwork;

/**
 * Lớp này có các phương thức thực hiện nhận yêu cầu của từ trang /home để phản
 * hồi dữ liệu sang View.<p>
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
        // Get List<Home> from Database
        IHome db = new HomeDAO();
        List<Home> list = db.getAll();
        
        // Get List<Category> from Database
        ICategory dbCat = new CategoryDAO();
        List<Category> listCat = dbCat.getAll();
        
        // Get List<SocialNetwork> from Database
        ISocialNetwork dbSocial = new SocialNetworkDAO();
        List<SocialNetwork> listSocial = dbSocial.getAll();

        // Pass data to View
        request.setAttribute("listObj", list);
        request.setAttribute("listObjCat", listCat);
        request.setAttribute("listSocialObj", listSocial);
        request.getRequestDispatcher("View/index.jsp").forward(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
