package co.edu.udea.iw.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.PeticionDAO;
import co.edu.udea.iw.dto.Peticion;
import co.edu.udea.iw.dto.Peticion2;
import co.edu.udea.iw.exception.ExceptionPropia;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase PeticionDAOHibernateTest implementa la clase PeticionDAOHibernate.
 * 
 */
public class PeticionDAOHibernateTest {
	
	@Autowired
	ClienteDAO clienteDao;
	@Autowired
	PeticionDAO peticionDao;
	
	@Test
	/**
	 *Test inserta una nueva peticion
	 * 
	 * 
	 */
	public void testInsertar() {
		Peticion peticion = new Peticion();
		Peticion2 peticion2 = new Peticion2();
		
		try{
			
			peticion2.setCliente(clienteDao.obtener("1029001659"));
			peticion2.setCodigo(3);
			
			peticion.setPeticion2(peticion2);
			peticion.setFechaCreacion(new Date());
			peticion.setTexto("Cordial saludo, deseo solicitar un cambio de articulo");
			
			peticionDao.insertar(peticion);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test Metodo para obtener una peticion
	 * 
	 */	
	public void testObtener() {
		Peticion peticion = new Peticion();
		Peticion2 peticion2 = new Peticion2();
		
		try{
			
			peticion2.setCliente(clienteDao.obtener("99999999"));
			peticion2.setCodigo(2);
			
			peticion = peticionDao.obtener(peticion2);
			
			System.out.println("La peticion del cliente 99999999  es: " + peticion.getTexto());
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test Metodo que permite obtener el listado de peticiones
	 *
	 */
	public void testObtenerLista() {
		

		List<Peticion> listaPeticiones = null;
		
		try{
			listaPeticiones = peticionDao.obtener();
			
			for(Peticion peticiones : listaPeticiones){
				System.out.println("la peticion con ID : " + peticiones.getPeticion2().getCodigo() + " del cliente: " +  peticiones.getPeticion2().getCliente().getNombres() + " " +peticiones.getPeticion2().getCliente().getApellidos() +  " es: " + peticiones.getTexto() );
			}
			
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
