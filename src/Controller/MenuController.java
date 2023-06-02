package Controller;

import Consultas.QueryMenu;
import Model.Bebida;
import Model.Comida;
import Model.Postre;
import View.MenuPrincipal;
import View.ViewCantidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuController implements ActionListener{
    
   
    private MenuPrincipal menuView = new MenuPrincipal();
    private QueryMenu queryMenu = new QueryMenu();
    private ViewCantidad viewCantidadComida = new ViewCantidad();
    private ViewCantidad viewCantidadBebida = new ViewCantidad();
    private ViewCantidad viewCantidadPostre = new ViewCantidad();


    
    DefaultTableModel modeloProductos = new DefaultTableModel();
    
    public MenuController(){
        iniciarCbbProductos();
        iniciarCbbBebidas();
        iniciarCbbPostre();
        iniciarTablaProductos();
        this.menuView.cbbProductos.addActionListener(this);
        this.viewCantidadComida.btnAgregar.addActionListener(this);
        this.menuView.btnAgregarManual.addActionListener(this);
        this.menuView.cbbBebidas.addActionListener(this);
        this.viewCantidadBebida.btnAgregar.addActionListener(this);
        this.menuView.cbbPostres.addActionListener(this);
        this.viewCantidadPostre.btnAgregar.addActionListener(this);
        this.menuView.cbbPostres.addActionListener(this);
    }
    
    public void loadMenu(){
        menuView.setVisible(true);
        menuView.setLocationRelativeTo(null);
    }
    
    public void iniciarCbbProductos(){
        ArrayList<Comida> listComidas = queryMenu.listarComidas();
        for (Comida p : listComidas) {
            String productoDetalle = p.getDetalle();
            menuView.cbbProductos.addItem(productoDetalle);
        }
    }
    
    public void iniciarCbbBebidas(){
        ArrayList<Bebida> listBebidas = queryMenu.listarBebidas();
        for (Bebida b : listBebidas) {
            String bebidaDetalle = b.getDetalle();
            menuView.cbbBebidas.addItem(bebidaDetalle);
        }
    }
    
    public void iniciarCbbPostre(){
        ArrayList<Postre> listPostre = queryMenu.listarPostres();
        for (Postre p: listPostre) {
            String postreDetalle = p.getDetalle();
            menuView.cbbPostres.addItem(postreDetalle);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        accionCbbProductos(e);
        accionAgregarProducto(e);
        accionAgregarManual(e);
        accionCbbBebidas(e);
        accionAgregarBebida(e);
        accionCbbPostres(e);
        accionAgregarPostre(e);
    }
    
    public void accionCbbProductos(ActionEvent e){
        if(e.getSource() == menuView.cbbProductos){
            viewCantidadComida.setVisible(true);
            viewCantidadComida.setLocationRelativeTo(null);
            viewCantidadComida.labelProductoSeleccionado.setText((String) menuView.cbbProductos.getSelectedItem());
        }
    }
    
    public void accionCbbBebidas(ActionEvent e){
        if(e.getSource() == menuView.cbbBebidas){
            viewCantidadBebida.setVisible(true);
            viewCantidadBebida.setLocationRelativeTo(null);
            viewCantidadBebida.labelProductoSeleccionado.setText((String) menuView.cbbBebidas.getSelectedItem());
        }
    }
    
    public void accionCbbPostres(ActionEvent e){
        if(e.getSource() == menuView.cbbPostres){
            viewCantidadPostre.setVisible(true);
            viewCantidadPostre.setLocationRelativeTo(null);
            viewCantidadPostre.labelProductoSeleccionado.setText((String) menuView.cbbPostres.getSelectedItem());
        }
    }
    
    public void iniciarTablaProductos(){
        modeloProductos.addColumn("Nombre");
        modeloProductos.addColumn("Precio");
        modeloProductos.addColumn("Cantidad");
        menuView.tablaProductos.setModel(modeloProductos);
    }
    
    public void accionAgregarProducto(ActionEvent e){
        if(e.getSource() == viewCantidadComida.btnAgregar){
            listarEnTabla(viewCantidadComida.labelProductoSeleccionado.getText(),viewCantidadComida.txtCantidad.getText());
            viewCantidadComida.txtCantidad.setText("");
            viewCantidadComida.setVisible(false);
        }
    }
    
    public void accionAgregarBebida(ActionEvent e){
        if(e.getSource() == viewCantidadBebida.btnAgregar){
            listarBebidaEnTabla(viewCantidadBebida.labelProductoSeleccionado.getText(),viewCantidadBebida.txtCantidad.getText());
            viewCantidadBebida.txtCantidad.setText("");
            viewCantidadBebida.setVisible(false);
        }
    }
    
    public void accionAgregarPostre(ActionEvent e){
        if(e.getSource() == viewCantidadPostre.btnAgregar){
            listarPostreEnTabla(viewCantidadPostre.labelProductoSeleccionado.getText(),viewCantidadPostre.txtCantidad.getText());
            viewCantidadPostre.txtCantidad.setText("");
            viewCantidadPostre.setVisible(false);
        }
    }
    
    public void listarEnTabla(String nombre, String cantidad){
        queryMenu.listarProducto(nombre,cantidad, modeloProductos);
    }
    
    public void listarBebidaEnTabla(String nombre, String cantidad){
        queryMenu.listarBebidaTabla(nombre,cantidad, modeloProductos);
    }
    
    public void listarPostreEnTabla(String nombre, String cantidad){
        queryMenu.listarPostreEnTabla(nombre,cantidad, modeloProductos);
    }
    
    /*Metodo para agregar manualmente un producto*/
    public void accionAgregarManual(ActionEvent e){
        if(e.getSource() == menuView.btnAgregarManual){
            if(!verificarVacioNombre() &&
                    !verificarVacioPrecio() 
                    && !verificarVacioCantidad()){
                listarProductoManual(menuView.txtNombre.getText(),menuView.txtPrecio.getText(),menuView.txtCantidad.getText(),modeloProductos);
                vaciarCamposManuales();
            }
            else{
                JOptionPane.showMessageDialog(null, "Verificar que los campos, Nombre, Precio, o Cantidad \n"
                        + "no esten vacios");
            }
        }
    }
    
    public boolean verificarVacioNombre(){
        if(menuView.txtNombre.getText().equals("")){
            return true;
        }
        return false;
    }
    
    public boolean verificarVacioPrecio(){
        if(menuView.txtPrecio.getText().equals("")){
            return true;
        }
        return false;
    }
    
    public boolean verificarVacioCantidad(){
        if(menuView.txtCantidad.getText().equals("")){
            return true;
        }
        return false;
    }
    
    public void listarProductoManual(String nombre,String precio,String cantidad,DefaultTableModel model){
        String[] dato= new String[3];
        dato[0]=nombre;
        dato[1]="$ "+precio;
        dato[2]=cantidad;
        model.addRow(dato);
    }
    
    /*Vacia los campos luego de agregar manualmente el plato*/
    public void vaciarCamposManuales(){
        menuView.txtNombre.setText("");
        menuView.txtPrecio.setText("");
        menuView.txtCantidad.setText("");
    }
}
