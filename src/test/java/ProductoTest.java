
import com.pallol.novela.bean.ProductoBean;
import com.pallol.novela.dao.CompraRealizadaDAO;
import com.pallol.novela.entities.CompraRealizada;
import com.pallol.novela.entities.Producto;
import com.pallol.novela.entities.ProductoCompra;
import com.pallol.novela.entities.Usuario;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author casa pallol
 */
public class ProductoTest {

//    @Test
//    @Transactional
    public void pruebaProducto() {
        ProductoBean productoBean = new ProductoBean();

        //Este proceso ya en el sitio, debemos hacerlo al acceder a la pantalla de productos
        //Ya que el usuario se guarda en sesion, es solo cuestion de asignarlo a la variable
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1);//Usuario Pallol
        productoBean.setUsuarioId(usuario.getUsuarioId());

        //Traemos todos los productos en base de datos para el ejemplo
        List<Producto> lstProductos = productoBean.muestraProductos();

        productoBean.anadeProductoCarrito((long)lstProductos.get(0).getIdproducto(), 10L);
        productoBean.anadeProductoCarrito((long)lstProductos.get(1).getIdproducto(), 20L);

        List<ProductoCompra> lstProductoCompras = productoBean.muestraProductosUsuario();

        Assert.assertNotEquals(lstProductoCompras.size(), 0);

        productoBean.actualizaProductoCompra(lstProductoCompras.get(0).getId(), 1000);
        lstProductoCompras = productoBean.muestraProductosUsuario();

        Assert.assertEquals((long) lstProductoCompras.get(0).getCantidad(), 1000);

//        productoBean.eliminaProductoCarrito(lstProductoCompras.get(0).getId());
//        productoBean.eliminaProductoCarrito(lstProductoCompras.get(1).getId());
//        lstProductoCompras = productoBean.muestraProductosUsuario();
//        Assert.assertEquals(0, lstProductoCompras.size());
    }

//    @Test
    public void pruebaTotal() {
        ProductoBean productoBean = new ProductoBean();
        
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1);//Usuario Pallol
        productoBean.setUsuarioId(usuario.getUsuarioId());
        
        Integer total = productoBean.obtieneCuentaTotalProductos();
        
        System.out.println("Total: " + total);
        productoBean.finalizaCompra();
    }
}
