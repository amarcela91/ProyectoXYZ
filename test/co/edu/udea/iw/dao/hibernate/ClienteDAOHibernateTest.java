package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase ClienteDAOHibernateTest implementa la clase ClienteDAOHibernate.
 * 
 */
public class ClienteDAOHibernateTest {
	
	@Autowired
	ClienteDAO clienteDao;
	
	
	@Test
	/**
	 * Test del Metodo que permite obtener un Cliente dada su cedula
	 * 
	 */
	public void testObtener() {
		
		Cliente cliente = null;
		
		try{
			cliente = clienteDao.obtener("99999999");
			
			System.out.println("El cliente es: " + cliente.getNombres());
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	/**
	 *  Test del Metodo que entrega una lista con clientes existentes
	 *  
	 */
	public void testObtenerLista() {		
		
		List<Cliente> clientes = null;
		
		try{
			clientes = clienteDao.obtener();
			
			for(Cliente cliente : clientes){
				System.out.println("El nombre del cliente es : " + cliente.getNombres());
			}
			
			
		}catch(ExceptionPropia e){
			Assert.fail(e.getMessage());
			
		}
	}
	
	
	@Test
	/**
	 *  Test del metodo que ingresa un cliente 
	 *
	 */
	public void testInsertar() {
		Cliente cliente = null;
		cliente = new Cliente();

		try{
						
			cliente.setCedula("1028");
			cliente.setNombres("Adriana");
			cliente.setApellidos("Guzman");
			cliente.setEmail("nana@udea.com");
			cliente.setTelefono("3016000000");
			cliente.setDireccion("Calle fortuna");
			
			
			clienteDao.insertar(cliente);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	
	@Test
	/**
	 *  Test del metodo que Modifica la información de un cliente 
	 * 
	 */
	public void testModificar() {
		Cliente cliente = null;
		cliente = new Cliente();
		try{
			
			
			cliente = clienteDao.obtener("1028");
			
			cliente.setNombres("Adriana");
			cliente.setApellidos("Guzman");
			cliente.setEmail("nana349@udea.com");
			cliente.setTelefono("3016250000");
			cliente.setDireccion("Calle fortuna");
			
			clienteDao.modificar(cliente);
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	

}
