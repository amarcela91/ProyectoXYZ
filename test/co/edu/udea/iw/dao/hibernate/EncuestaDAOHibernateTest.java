package co.edu.udea.iw.dao.hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase EncuestaDAOHibernateTest implementa la clase EncuestaDAOHibernate.
 * 
 */
public class EncuestaDAOHibernateTest {
	@Autowired
	EncuestaDAO encuestaDao;
	
	@Test	
	/**
	 * Test Crea una nueva encuesta
	 * 
	 */
	public void testInsertar() {
		Encuesta encuesta = null;
		encuesta = new Encuesta();
		
		try{
			encuesta.setCodigo(5);
			encuesta.setPregunta1(9);
			encuesta.setPregunta2(10);
			encuesta.setPregunta3(5);
			encuesta.setPregunta4(8);
			
			encuestaDao.insertar(encuesta);
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	/**
	 * Test Entrega los datos de una encuesta dado su codigo
	 *
	 */
	public void testObtener() {
		Encuesta encuesta = null;
		
		try{
			encuesta = encuestaDao.obtener(2);
			
			System.out.println("La respuesta de la encuesta con codigo : " + encuesta.getCodigo() + " es:");
			System.out.println("1.Percepción de calidad del producto vs precio: " + encuesta.getPregunta1());
			System.out.println("2.Calidad del servicio que recibio: "+ encuesta.getPregunta2());
			System.out.println("3.Recomendaria nuestros productos a otras personas: "+ encuesta.getPregunta3());
			System.out.println("4.Rapidez para contestar solicitud"+ encuesta.getPregunta4());
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	

}
