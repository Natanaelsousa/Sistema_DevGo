/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.devgo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sistema.devgo.java.UsuarioSistema;

/**
 *
 * @author Sibele
 */
@WebServlet(name = "ApresentacaoVenda", urlPatterns = {"/ApresentacaoVenda"})
public class ApresentacaoVenda extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApresentacaoVenda</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApresentacaoVenda at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession(false);

        Object objSessao = sessao.getAttribute("user");
        UsuarioSistema usuario = (UsuarioSistema) objSessao;
        usuario.getDepartamento();

        request.setAttribute("departamento", usuario.getDepartamento());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ApresentacaoVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession(false);

        Object objSessao = sessao.getAttribute("user");
        UsuarioSistema usuario = (UsuarioSistema) objSessao;
        usuario.getDepartamento();

        request.setAttribute("departamento", usuario.getDepartamento());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/buscaCNPJvenda.jsp");
        dispatcher.forward(request, response);
        
        String serv = "/WEB-INF/sucesso-venda-efetuada.jsp";
        request.setAttribute("msgm", "sucesso");
        
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
