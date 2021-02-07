/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pallol.novela.dao.UsuarioDAO;
import com.pallol.novela.entities.Novela;
import com.pallol.novela.entities.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jessai
 */
public class UsuarioNovelaTest {

    public UsuarioNovelaTest() {
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
    public void hello() {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Novela novela = new Novela();
        novela.setNovelaId(26);

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1);

        boolean comprobacion = usuarioDAO.eliminaUsuarioDeNovela(usuario.getUsuarioId(), novela.getNovelaId());
//        Assert.assertTrue(comprobacion);
    }
}
