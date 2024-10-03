/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class DoiTienServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;

    // Tỷ giá quy đổi
    private static final double USD_TO_VND = 21380.00;
    private static final double GBP_TO_VND = 32622.80;
    private static final double EUR_TO_VND = 23555.67;
    private static final double JPY_TO_VND = 178.61;
    private static final double AUD_TO_VND = 16727.44;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoiTienServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            response.getWriter().println("Số tiền: <input type='number' name='amount' required/><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
         String currency = request.getParameter("currency");
        double amount = Double.parseDouble(request.getParameter("amount"));
        double convertedAmount = 0;

        switch (currency) {
            case "USD":
                convertedAmount = amount * USD_TO_VND;
                break;
            case "GBP":
                convertedAmount = amount * GBP_TO_VND;
                break;
            case "EUR":
                convertedAmount = amount * EUR_TO_VND;
                break;
            case "JPY":
                convertedAmount = amount * JPY_TO_VND;
                break;
            case "AUD":
                convertedAmount = amount * AUD_TO_VND;
                break;
            default:
                response.getWriter().println("Ngoại tệ không hợp lệ.");
                return;
        }

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("Số tiền sau khi đổi: " + convertedAmount + " VND");
        response.getWriter().println("<br><a href='doi-tien'>Quay lại</a>");
        response.getWriter().println("</body></html>");
    }
}
