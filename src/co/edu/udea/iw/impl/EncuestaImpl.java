package co.edu.udea.iw.impl;

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.exception.ExceptionPropia;

/**
 * Implementacion de los servicios que controlan la encuesta
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class EncuestaImpl {
	private EncuestaDAO encuestaDAO;
	
	
	/**
	 * Metodo que permite crear una encuesta y validar los parametros ingresados
	 * @param codigo de la encuesta
	 * @param pregunta1 valor de la pregunta 1 
	 * @param pregunta2 valor de la pregunta 2
	 * @param pregunta3 valor de la pregunta 3 
	 * @param pregunta4 valor de la pregunta 4 
	 * @throws ExceptionPropia si ocurre algun error
	 * 
	 */
public void creaEncuesta(Integer codigo, Integer pregunta1, Integer pregunta2, Integer pregunta3, Integer pregunta4) throws ExceptionPropia{
		
		Encuesta encuesta = null;
		
		if(codigo == null){
			throw new ExceptionPropia("El código no puede estar vacia");
		}
		if(pregunta1 == 0 ){
			throw new ExceptionPropia("La valoracion de la pregunta 1 no puede estar vacio ");
		}
		if(pregunta2 == 0 ){
			throw new ExceptionPropia("La valoracion de la pregunta 2 no puede estar vacio");
		}
		if(pregunta3 == 0 ){
			throw new ExceptionPropia("La valoracion de la pregunta 3 no puede estar vacio");
		}
		if(pregunta4 == 0 ){
			throw new ExceptionPropia("La valoracion de la pregunta 4 no puede estar vacio");
		}
				
		
		encuesta = new Encuesta();
		
		encuesta.setCodigo(codigo);
		encuesta.setPregunta1(pregunta1);
		encuesta.setPregunta2(pregunta2);
		encuesta.setPregunta3(pregunta3);
		encuesta.setPregunta3(pregunta4);
		
		encuestaDAO.insertar(encuesta);
		
	}

	
/**
 * Metodo que permite obtener una encuesta en especifico dado su codigo
 * @param codigo de la encuesta
 * @return encuesta correspondiente al codigo
 * @throws ExceptionPropia si ocurre un error en la conexión 
 * 
 */
	public Encuesta obtener(Integer codigo) throws ExceptionPropia{
		if(codigo == null && "".equals(codigo)){
			throw new ExceptionPropia("El código para la encuesta no puede ser nulo");
		}
	
		return encuestaDAO.obtener(codigo);
	}

	public EncuestaDAO getEncuestaDAO() {
		return encuestaDAO;
	}

	public void setEncuestaDAO(EncuestaDAO encuestaDAO) {
		this.encuestaDAO = encuestaDAO;
	}

}
