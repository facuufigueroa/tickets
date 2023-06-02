
package Consultas;

import ConexionBD.ConexionBD;
import static ConexionBD.ConexionBD.getConnection;
import Model.Bebida;
import Model.Comida;
import Model.Postre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class QueryMenu {
    
    public ArrayList<Comida> listarComidas() {
        ArrayList<Comida> pList = new ArrayList<>();
        Connection conn = ConexionBD.getConnection();
        Statement st;
        try {
            String sql = "SELECT * FROM comida AS c ORDER BY c.detalle DESC";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Comida producto = new Comida();
                producto.setDetalle(rs.getString("detalle"));
                producto.setPrecio(rs.getDouble("precio"));
                pList.add(producto);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return pList;
    }
    
    public String[] listarProducto(String nombre,String cantidad,DefaultTableModel model){
        String[] dato= new String[3];
        Connection conn = getConnection();
        PreparedStatement ps;
        ResultSet rs;
            try{
                ps=conn.prepareStatement("SELECT * FROM comida AS c WHERE c.detalle = '"+nombre+"'");
                rs=ps.executeQuery();
                
                if(rs.next()) {
                    dato[0]=rs.getString("detalle");
                    dato[1]="$ "+rs.getString("precio");
                    dato[2]=cantidad;
                    model.addRow(dato);
                }else{
                }
            } catch(Exception e){
                 System.out.println(e);
    }
            return dato;
    }
    
    public ArrayList<Bebida> listarBebidas() {
        ArrayList<Bebida> bList = new ArrayList<>();
        Connection conn = ConexionBD.getConnection();
        Statement st;
        try {
            String sql = "SELECT * FROM bebida AS b ORDER BY b.nombre DESC";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Bebida bebida = new Bebida();
                bebida.setDetalle(rs.getString("nombre"));
                bebida.setPrecio(rs.getDouble("precio"));
                bList.add(bebida);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return bList;
    }
    
    public String[] listarBebidaTabla(String nombre,String cantidad,DefaultTableModel model){
        String[] dato= new String[3];
        Connection conn = getConnection();
        PreparedStatement ps;
        ResultSet rs;
            try{
                ps=conn.prepareStatement("SELECT * FROM bebida AS b WHERE b.nombre = '"+nombre+"'");
                rs=ps.executeQuery();
                
                if(rs.next()) {
                    dato[0]=rs.getString("nombre");
                    dato[1]="$ "+rs.getString("precio");
                    dato[2]=cantidad;
                    model.addRow(dato);
                }else{
                }
            } catch(Exception e){
                 System.out.println(e);
    }
            return dato;
    }
    
    public ArrayList<Postre> listarPostres() {
        ArrayList<Postre> pList = new ArrayList<>();
        Connection conn = ConexionBD.getConnection();
        Statement st;
        try {
            String sql = "SELECT * FROM postre AS p ORDER BY p.nombre DESC";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Postre postre = new Postre();
                postre.setDetalle(rs.getString("nombre"));
                postre.setPrecio(rs.getDouble("precio"));
                pList.add(postre);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return pList;
    }
    
    public String[] listarPostreEnTabla(String nombre,String cantidad,DefaultTableModel model){
        String[] dato= new String[3];
        Connection conn = getConnection();
        PreparedStatement ps;
        ResultSet rs;
            try{
                ps=conn.prepareStatement("SELECT * FROM postre AS p WHERE p.nombre = '"+nombre+"'");
                rs=ps.executeQuery();
                
                if(rs.next()) {
                    dato[0]=rs.getString("nombre");
                    dato[1]="$ "+rs.getString("precio");
                    dato[2]=cantidad;
                    model.addRow(dato);
                }else{
                }
            } catch(Exception e){
                 System.out.println(e);
    }
            return dato;
    }
}
