package co.edu.udea.iw.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations ="classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase ClienteImplTest implementa la clase ClienteImpl
 * 
 */
public class ClienteImplTest {
	
	@Autowired
	ClienteImpl clienteImpl;
	
	@Test	
	/**
	 * Prueba de Metodo que recibe y valida los parametros para crear un cliente 
	 */
	public void testGuardaCliente() {
		
		try{
			clienteImpl.guardaCliente("98624111", "Luis", "Guzman", "lucho50@hotmail.com", "3495050","Avenida siempre viva");
			
			System.out.println("Usuario Guardado con éxito");
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test	
	/**
	 * Prueba de Metodo que permite actualizar un cliente y valida los datos a actualizar
	 */
	public void testActualizarCliente() {
		
		try{
				
			clienteImpl.actualizarCliente("1029001659", "Adriana Marcela", "Guzman Londoño", "adrimar@gmail.com", 
					"3135490088","Calle Alegre");
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Prueba de Metodo retorna una lista de clientes del sistema
	 * 
	 */
	public void testObtenerLista() {
		try{
			clienteImpl.obtener();
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}		
	}
	
	@Test
	/**
	 * Prueba de Metodo que permite obtener un cliente dada la cedula
	 * 
	 */
	public void testObtener() {
		try{
			clienteImpl.obtener("1029001659");
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}

}
