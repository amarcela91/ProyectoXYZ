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
@ContextConfiguration(locations = "classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase EncuestaImplTest implementa la clase EncuestaImpl
 * 
 */
public class EncuestaImplTest {
	@Autowired
	EncuestaImpl encuestaImpl;

	@Test
	/**
	 *Prueba de  Metodo que permite crear una encuesta y validar los parametros ingresados
	 * 
	 */
	public void testCreaEncuesta() {
		try{
			encuestaImpl.creaEncuesta(6, 9, 9, 9, 10);
			
			}catch(ExceptionPropia e){
				e.printStackTrace();
				Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	/**
	 * Prueba de Metodo que permite obtener una encuesta en especifico dado su codigo
	 * 
	 */
	public void testObtenerInteger() {
		try {
			encuestaImpl.obtener(1);
		} catch (ExceptionPropia e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	

}
