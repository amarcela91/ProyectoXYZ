package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionPropia;
/**
 * Interface que me define los metodos permitidos para los usuarios
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface UsuarioDAO {
	/**
	 * obtiene la información de un usuario dadas su login
	 * @param login instancia del cliente a crear
	 * @return retorna los datos del usuario
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Usuario obtener(String login) throws ExceptionPropia;
	
	/**
	 * crea un nuevo usuario 
	 * @param usuario a ser creado
	 * @return usuario creado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Usuario crear(Usuario usuario) throws ExceptionPropia;
	
	/**
	 * modifica un usuario 
	 * @param usuario a ser modificado
	 * @return el usuario modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Usuario modificar(Usuario usuario) throws ExceptionPropia;
		
	/**
	 * Entrega la lista de usuarios existentes en el sistema
	 * @return lista de usuarios
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public List<Usuario> obtener() throws ExceptionPropia;

}
