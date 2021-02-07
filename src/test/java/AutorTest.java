
import com.pallol.novela.bean.UsuarioBean;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Usuario;
import org.junit.Assert;
import org.junit.Ignore;
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
public class AutorTest {

//    @Test
    public void pruebaValidacionNovelasUsuario() {
        UsuarioBean usuarioBean = new UsuarioBean();

        Usuario usuario = new Usuario();
        usuario.setCodigo("pallol");
        usuario.setContrasena("1");

        usuarioBean.setUsuario(usuario);
        String paginaDestino = usuarioBean.iniciaSesion();
        
        Assert.assertNotNull(paginaDestino);
        Assert.assertNotEquals(0, usuarioBean.getUsuario().getUsuarioId());
        Assert.assertNotNull(usuarioBean.getPersona().getNombre());

        System.out.println("El nombre del usuario de prueba es: " +  usuarioBean.getPersona().getNombre());
        System.out.println("Su rol es: " +  usuarioBean.getRol().getNombre());
        
        usuarioBean.muestraNovelasDetalleUsuario(usuarioBean.getUsuario().getUsuarioId());
        System.out.println("Novelas del Usuario:\n ");
        for (Novela novela : usuarioBean.getLstNovela()) {
            System.out.println(novela.getNombre() + "\n");
        }
    }
    
    @Test
    public void pruebaCorreo(){
        Usuario usuario = new Usuario();
        usuario.setCodigo("jorgepallol1@gmail.com");
        UsuarioBean usuarioBean = new UsuarioBean();
        usuarioBean.setUsuario(usuario);
//        usuarioBean.enviaCodigoContrasena();
    }

}
