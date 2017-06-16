package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionPropia;
/**
 * Interface que me define los metodos permitidos para Rol
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface RolDAO {
	
	/**
	 * Metodo que permite obtener un rol dado su codigo
	 * @param el codigo del rol
	 * @return el objeto rol correspondiente al codigo
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Rol obtener(String codigo) throws ExceptionPropia;
	
	
	/**
	 * Metodo que permite obtener el listado de los roles existentes
	 * @return una lista con informacion de los roles
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public List<Rol> obtener() throws ExceptionPropia;
	
	/**
	 * Metodo que permite modificar un rol en la BD
	 * @param Un objeto Rol que se desea modifiar
	 * @return el objeto Rol modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Rol modificar(Rol rol) throws ExceptionPropia;
	
	/**
	 * Metodo que permite insertar un rol 
	 * @param objeto Rol con sus respectivos datos
	 * @return el objeto rol que fue insertado 
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Rol insertar(Rol rol) throws ExceptionPropia;
	

}
