package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.exception.ExceptionPropia;
/**
 * Interface que me define los metodos permitidos para la clase Encuesta
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface EncuestaDAO {
	/**
	 * Crea una nueva encuesta
	 * @param recibe un objeto encuesta con la informacion de la encuesta
	 * @return peticion insertada
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Encuesta insertar(Encuesta encuesta) throws ExceptionPropia;
	
	/**
	 * Entrega los datos de una encuesta dado su codigo
	 * @param recibe el codigo de la encuesta a obtener
	 * @return una instancia de los datos de la encuesta obtenida, si no existe
	 * dicha encuesta con el codigo dado retorna null
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Encuesta obtener(Integer codigo) throws ExceptionPropia;
	

}
