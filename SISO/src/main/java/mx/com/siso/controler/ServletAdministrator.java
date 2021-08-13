package mx.com.siso.controler;

import mx.com.siso.model.administrador.BeanAdministrador;
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
        request.setCharacterEncoding("UTF-8");
        String action =request.getParameter("action");
        switch (action){
            case "update":
                String username = request.getParameter("name");
                String password = request.getParameter("password");
                String id = request.getParameter("username");
                BeanAdministrador beanAdministrador = new BeanAdministrador(username,password);
                if (new DaoAdministrator().update(beanAdministrador, id)){
                    System.out.println("Se ha actualizado correctamente");
                }else {
                    System.out.println("El usuario ya existe");
                }
                break;
        }
    }
}
