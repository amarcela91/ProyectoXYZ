package co.edu.udea.iw.impl;

import java.util.Date;

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
@ContextConfiguration(locations = "classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase PeticionImplTest implementa la clase PeticionImpl
 * 
 */
public class PeticionImplTest {
	
	@Autowired
	PeticionImpl peticionImpl;
	
	@Test
	/**
	 * Prueba de Metodo que permite crear una peticion y validar los parametros ingresados
	 *  
	 */
	public void testCreaPeticion() {
		try{
			peticionImpl.creaPeticion(3, "Cordial saludo, deseo realizar una peticion sobre","39400796", new Date());
			
			}catch(ExceptionPropia e){
				e.printStackTrace();
				Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	/**
	 * Prueba de metodo que obtiene todas las peticiones
	 * 
	 */
	public void testObtener() {
		try{
			peticionImpl.obtener();
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}		
	}
	

}
