package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Peticion;
import co.edu.udea.iw.dto.Peticion2;
import co.edu.udea.iw.exception.ExceptionPropia;
/**
 * Interface que me define los metodos permitidos para las peticiones
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface PeticionDAO {
	
	/**
	 * inserta una nueva peticion
	 * @param objeto peticion con la informacion de la misma
	 * @return el objeto peticion que fue insertado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Peticion insertar(Peticion peticiones) throws  ExceptionPropia;
		

	/**
	 * Metodo para obtener una peticion
	 * @param objeto Peticion2 (la identificacion de la peticion a obtener)
	 * @return un objeto petición correspondiente al id enviado en el parametro
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */	
	public Peticion obtener(Peticion2 peticion2) throws  ExceptionPropia;
	

	/**
	 * Metodo que permite obtener el listado de peticiones
	 * @return una lista de todas las peticiones
	 * @throws .ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */ 
	public List<Peticion> obtener() throws  ExceptionPropia;
	
}
