/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pallol.novela.dao.CapituloDAO;
import com.pallol.novela.dao.CategoriaDAO;
import com.pallol.novela.dao.ComentarioDAO;
import com.pallol.novela.dao.NovelaDAO;
import com.pallol.novela.dao.PersonajeDAO;
import com.pallol.novela.dao.UsuarioDAO;
import com.pallol.novela.entities.Capitulo;
import com.pallol.novela.entities.Categoria;
import com.pallol.novela.entities.Comentario;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Personaje;
import com.pallol.novela.entities.Usuario;
import com.pallol.novela.entities.UsuarioNovela;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Jessai
 */
//@Ignore
public class NovelaTest {

    public NovelaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void pruebaNovela() {
        System.out.println("\n\nNovelas: ");
        NovelaDAO novelaDAO = new NovelaDAO();
        List<Novela> novelas = novelaDAO.obtieneNovela();
        for (Novela novela : novelas) {
            System.out.println(novela.getNombre());
        }

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Categoria categoria = categoriaDAO.obtieneCategoriaPorId(1);

        Novela nuevaNovela = new Novela();
        nuevaNovela.setAnotacion("anotacion");
        nuevaNovela.setCategoria(categoria);
        nuevaNovela.setDescripciong("desc g");
        nuevaNovela.setDescripcionp("desc p");
        nuevaNovela.setImagen("prueba");
        nuevaNovela.setNombre("Nueva novela prueba");
        nuevaNovela.setNotas("notas");
        nuevaNovela.setPrecio(0);
        
        nuevaNovela = novelaDAO.insertaNovela(nuevaNovela);
        
        Assert.assertNotNull(nuevaNovela);
        Assert.assertNotEquals(nuevaNovela.getNovelaId().intValue(), 0);
        
        UsuarioNovela usuarioNovela = new UsuarioNovela();
        Usuario usuario = usuarioDAO.obtieneUsuarioPorId(1);
        usuarioNovela.setUsuario(usuario);
        usuarioNovela.setNovela(nuevaNovela);
        
        usuarioNovela = usuarioDAO.insertaUsuarioNovela(usuarioNovela);
        
        nuevaNovela.setAnotacion("Otra_anotacion");
        novelaDAO.actualizaNovela(nuevaNovela);
        
        Assert.assertEquals(nuevaNovela.getAnotacion(), "Otra_anotacion");

        novelaDAO.eliminaNovela(nuevaNovela);
        Assert.assertEquals("", "");
    }

    @Test
    public void pruebaPersonaje() {
        System.out.println("\n\nPersonajes: ");
        PersonajeDAO personajeDAO = new PersonajeDAO();
        List<Personaje> lstPersonaje = personajeDAO.obtienePersonajePorNovelaId(7);
        for (Personaje personaje : lstPersonaje) {
            System.out.println("Nombre: " + personaje.getNombre() /*+ "\nNovela: " + personaje.getNovela().getNombre()*/);
        }
    }

    @Test
    public void pruebaGaleria() {
        System.out.println("\n\nPersonajes: ");
        PersonajeDAO personajeDAO = new PersonajeDAO();
        List<Personaje> lstPersonaje = personajeDAO.obtienePersonajePorNovelaId(7);
        for (Personaje personaje : lstPersonaje) {
            System.out.println("Nombre: " + personaje.getNombre() /*+ "\nNovela: " + personaje.getNovela().getNombre()*/);
        }

    }

    @Test
    public void pruebaCapitulo() {
        System.out.println("\n\nCapitulo: ");
        CapituloDAO capituloDAO = new CapituloDAO();
        List<Capitulo> lstCapitulo = capituloDAO.obtienePCapitulo(7);
        for (Capitulo capitulo : lstCapitulo) {
            System.out.println("Nombre: " + capitulo.getNombre() /*+ "\nNovela: " + personaje.getNovela().getNombre()*/);
        }
    }

//    @Test
    public void pruebaComentarioDavid() {
        System.out.println("\n\nComentario: ");
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        List<Comentario> lstComentario = comentarioDAO.obtieneComentario(7);
        for (Comentario comentario : lstComentario) {
            System.out.println("Nombre: " + comentario.getTexto() + "\nNovela: " + comentario.getNovela().getNombre() + "\nUsuario: " + comentario.getUsuario().getCodigo());
        }

        //Prueba la insercion de un Comentario
        Novela novela = new Novela();
        novela.setNovelaId(7);

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1);

        Comentario comentario = new Comentario();
        comentario.setTexto("El comentario");
        comentario.setNovela(novela);
        comentario.setUsuario(usuario);

        comentarioDAO.insertaComentario(comentario);
    }
}
