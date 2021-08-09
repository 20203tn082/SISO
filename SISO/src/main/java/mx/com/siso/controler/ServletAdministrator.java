package mx.com.siso.controler;

import mx.com.siso.model.administrador.DaoAdministrator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAdministrator", value = "/ServletAdministrator")
public class ServletAdministrator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("beanAdministrator", new DaoAdministrator().findAdministrator());
        request.getRequestDispatcher("/views/administrator/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
