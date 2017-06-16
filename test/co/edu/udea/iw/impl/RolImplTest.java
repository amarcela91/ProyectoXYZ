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
 * Clase RolImplTest implementa la clase RolImpl
 * 
 */
public class RolImplTest {
	@Autowired
	RolImpl rolImpl;
	
	@Test
	/**
	 * Metodo que crea un rol y valida los parametros ingresados
	 * 
	 */
	public void testCreaRol() {
		try{
			rolImpl.creaRol("CAJ", "Cajero");
			
			}catch(ExceptionPropia e){
				e.printStackTrace();
				Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	//Test que modifica un rol
	public void testModificaRol() {
		try{
			
			rolImpl.modificaRol("ENC", "Encargado de responder");
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	//Test que obtiene todos los roles existentes
	public void testObtener() {
		try{
			rolImpl.obtener();
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}	
	
	@Test
	//test que obtiene un rol correspondiente al codigo ingresado
	public void testObtenerUno() {
		try {
			rolImpl.obtener("ENC");
		} catch (ExceptionPropia e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

}
