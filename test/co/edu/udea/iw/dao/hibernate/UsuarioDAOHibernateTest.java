package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase UsuarioDAOHibernateTest implementa la clase UsuarioDAOHibernate.
 * 
 */
public class UsuarioDAOHibernateTest {
	@Autowired
	UsuarioDAO usuarioDao;
	@Autowired
	RolDAO rolDao;
	
	@Test
	/**
	 * Test obtiene la información de un usuario dadas su login
	 * 
	 */
	public void testObtener() {
		
		Usuario usuario = null;
		
		try{
			usuario = usuarioDao.obtener("encargado");
			
			System.out.println("El usuario que con login 'encargado' es: " + usuario.getNombres());
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test crea un nuevo usuario 
	 * 
	 */
	public void testCrear() {
		Usuario usuario = null;
		usuario = new Usuario();

		try{
			
			usuario.setLogin("empleado2");
			usuario.setNombres("Edison");
			usuario.setApellidos("Guzman");
			usuario.setContrasena("e0928466fb498920b3a1910027a8419aad1c27e9");
			usuario.setRol(rolDao.obtener("EMP"));
			
			usuarioDao.crear(usuario);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test modifica un usuario 
	 * 
	 */
	public void testModificar() {
		Usuario usuario = null;
		usuario = new Usuario();
		try{
			
			
			usuario = usuarioDao.obtener("empleado1");
			
			usuario.setLogin("empleado1");
			usuario.setNombres("Fulanito de tal");
			usuario.setApellidos("Redondo");
			usuario.setContrasena("0152ffead0c60a4740cdfb2");
			usuario.setRol(rolDao.obtener("EMP"));
			
			usuarioDao.modificar(usuario);
			
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test Entrega la lista de usuarios existentes en el sistema
	 *
	 */
	public void testObtenerLista() {
		List<Usuario> usuarios = null;
		
		try{
			usuarios = usuarioDao.obtener();
			
			for(Usuario usuario : usuarios){
				System.out.println("El nombre del usuario es : " + usuario.getNombres());
			}
						
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}


}
