package mx.com.siso.controler;

import mx.com.siso.model.department.BeanDepartment;
import mx.com.siso.model.records.BeanRecords;
import mx.com.siso.model.priority.BeanPriority;
import mx.com.siso.model.records.DaoRecords;
import mx.com.siso.model.response_file.BeanResponse_file;
import mx.com.siso.model.response_file.DaoResponse;
import mx.com.siso.model.users.BeanUsers;
import mx.com.siso.model.users.DaoUsers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ServletResponse", value = "/ServletResponse")
@MultipartConfig(maxFileSize = 16177215)
public class ServletResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action) {
            case "insert":
                boolean flag = false;
                int[] resultado = new int[3];
                BeanResponse_file beanResponse_file = null;
                int idRecord = Integer.parseInt(request.getParameter("id")!= null ? request.getParameter("id") : "");
                String comment = request.getParameter("comment")!= null ? request.getParameter("comment") : "";
                BeanRecords beanRecords = new BeanRecords(idRecord,null,0,null,null,null,comment,0,null,null,null);
                InputStream inputStream = null;
                System.out.println(idRecord);
                System.out.println(comment);
                Collection<Part> fileParts = request.getParts().stream().filter(part -> "archivos".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());
                for (Part filePart : fileParts) {
                    inputStream  = filePart.getInputStream();
                    int size = inputStream.available();
                    byte[] bytes = new byte[size];
                    inputStream.read(bytes);
                    String file = Base64.getEncoder().encodeToString(bytes);
                    beanResponse_file = new BeanResponse_file(0,file,beanRecords);
                    try {
                        resultado = new DaoResponse().createResponse(beanResponse_file);
                        flag = true;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if(resultado[0] == 1){
                        System.out.println("Se inserto correctamente");
                    }else {
                        if (resultado[1] == 1){
                            System.out.println("No existe el oficio");
                        }else {
                            if (resultado[2] == 1) {
                                System.out.println("El oficio ya esta atendido");
                            }
                        }
                    }
                }
                try {
                    if (flag){
                        new DaoResponse().changeAttended(beanResponse_file);
                        idRecord = 0;
                        int resultado2[] = new int[2];
                        String nameUser3 = (String) request.getSession().getAttribute("usuariom2");
                        String password3 = (String) request.getSession().getAttribute("contram2");

                        BeanUsers beanUsers4 = new BeanUsers(0, nameUser3, password3, "", "", "","",0, "", null,0, "", null, null);
                        try {
                            resultado2 = new DaoUsers().login(beanUsers4);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                        request.setAttribute("listMinutes", new DaoRecords().findRecordsByAssistant(resultado2[0]));
                        request.getRequestDispatcher("/views/users/mainAssistant.jsp").forward(request, response);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
                case "getResponseById":
                int id = Integer.parseInt(request.getParameter("idRecord"));
                request.setAttribute("listResponse", new DaoResponse().findResponse(id));
                request.getRequestDispatcher("/views/response/listResponse.jsp").forward(request, response);
                break;
            case "mostrar":
                response.setContentType("application/pdf");
                int responseId = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "");
                System.out.println("Id de la respuesta" + responseId);
                response.getOutputStream().write(Base64.getDecoder().decode(new DaoResponse().findResponseById(responseId)));
                break;

            default:
        }
    }
}
