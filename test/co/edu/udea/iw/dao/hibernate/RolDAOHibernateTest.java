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
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase RolDAOHibernateTest implementa la clase RolDAOHibernate.
 * 
 */
public class RolDAOHibernateTest {
	
	@Autowired
	RolDAO rolDao;
	
	@Test
	/**
	 * Test Metodo que permite obtener un rol dado su codigo
	 * 
	 */
	public void testObtener() {
		Rol rol = null;
		
		try{
			rol = rolDao.obtener("GRT");
			
			System.out.println("El rol pertenece a: " + rol.getNombre());
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test Metodo que permite obtener el listado de los roles existentes
	 * 
	 */
	public void testObtenerLista() {
		
		List<Rol> roles = null;
		
		try{
			roles = rolDao.obtener();
			
			for(Rol rol : roles){
				System.out.println("Rol: " + rol.getCodigo() + " pertenece al cargo " + rol.getNombre());
			}
			
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test	
	/**
	 * Test Metodo que permite modificar un rol en la BD
	 * 
	 */
	public void testModificar() {
		Rol rol = null;
		rol = new Rol();
		try{			
			rol = rolDao.obtener("GRT");
			
			rol.setCodigo("GNT");
			rol.setNombre("Gerente");
			
			rolDao.modificar(rol);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	
	}
	
	@Test	
	/**
	 *Test Metodo que permite insertar un rol 
	 *
	 */ 
	public void testInsertar() {
		Rol rol = null;
		rol = new Rol();

		try{
				
			rol.setCodigo("AYD");
			rol.setNombre("Ayudante");
			
			rolDao.insertar(rol);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
