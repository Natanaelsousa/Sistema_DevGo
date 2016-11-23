
package sistema.devgo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sistema.devgo.Model.dao.PlanoDAO;
import sistema.devgo.java.Plano;


@WebServlet(name = "CadastroPlano", urlPatterns = {"/CadastroPlano"})
public class CadastroPlano extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroPlano</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroPlano at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CadastrarPlano.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String serv = "/WEB-INF/sucesso-plano-cadastrado.jsp";
         
        // Guardando dados vindos da tela nas variaveis
        String nome = request.getParameter("Plano");
        long periodo = Long.parseLong(request.getParameter("opcao"));
        
        double preco = Double.parseDouble(request.getParameter("Preco")); 
        
        Plano plano= new Plano();
        plano.setNomePlano(nome);
        plano.setCod_Periodo(periodo);
       
        plano.setPreco(preco);
       
        
         PlanoDAO dao = new PlanoDAO ();
         try {
            dao.insert(plano);
        } catch (SQLException ex) {            
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(serv);
        dispatcher.forward(request, response);

   
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
