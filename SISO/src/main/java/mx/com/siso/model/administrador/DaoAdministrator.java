package mx.com.siso.model.administrador;

import mx.com.siso.service.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAdministrator {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;

    public BeanAdministrador findAdministrator(){
        BeanAdministrador beanAdministrador = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call find_administrator}");
            rs = cstm.executeQuery();
            while (rs.next()){
                beanAdministrador = new BeanAdministrador();
                beanAdministrador.setNameAdmin(rs.getString("administrator_name"));
                beanAdministrador.setPasswordAdmin(rs.getString("administrator_pass"));
            }
        }catch (SQLException e){
            System.out.println("Se ha encontrado el error " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnection(con, cstm, rs);
        }
        return beanAdministrador;
    }
}
