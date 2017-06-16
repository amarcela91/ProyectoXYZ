package co.edu.udea.iw.impl;

import java.util.List;

import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionPropia;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementacion de los servicios que controlan el rol
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class RolImpl {
	
	private RolDAO rolDAO;
	
	/**
	 * Metodo que crea un rol y valida los parametros ingresados
	 * @param codigo del rol
	 * @param nombre del rol
	 * @throws ExceptionPropia en caso de ocurrir en error de conexion cn la BD
	 */
	public void creaRol(String codigo, String nombre) throws ExceptionPropia{
		
		Rol rol = null;
		
		if(Validaciones.isTextoVacio(codigo)){
			throw new ExceptionPropia("El codigo del rol no puede ser vacio");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new ExceptionPropia("El nombre del rol no puede ser vacio");
		}		
		if(rolDAO.obtener(codigo) != null){
			throw new ExceptionPropia("Ya existe un rol " + rol +  " en el sistema");
		}
		
		
		rol = new Rol();
		
		rol.setCodigo(codigo);
		rol.setNombre(nombre);
		
		rolDAO.insertar(rol);
		
	}

	/**
	 *  Metodo que modifica un rol y valida los datos de la modificacion
	 * @param codigo del rol
	 * @param nombre del rol 
	 * @throws ExceptionPropia en caso de ocurrir un error
	 */
	public void modificaRol(String codigo, String nombre) throws ExceptionPropia{
	
		Rol rol = null;
	
		if(Validaciones.isTextoVacio(codigo)){
			throw new ExceptionPropia("El codigo del rol no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new ExceptionPropia("El nombre del rol no puede ser nula, ni una cadena de caracteres vacia");
		}
	
		rol = rolDAO.obtener(codigo);
		
		if(rol == null){
			throw new ExceptionPropia("El rol " + rol +  " no existe en el sistema");
		}
		
		rol.setCodigo(codigo);
		rol.setNombre(nombre);
	
		rolDAO.modificar(rol);
	}
	
	/**
	 * Metodo que permite obtener el listado de roles
	 * @return listado de roles
	 * @throws ExceptionPropia si ocurre un error 
	 */
	public List<Rol> obtener() throws ExceptionPropia{
		return rolDAO.obtener();
	}
	
	/**
	 * Metodo que permite obtener un rol dado su codigo
	 * @param el codigo del rol
	 * @return un objeto rol con el rol correspondiente al codigo
	 * @throws ExceptionPropia si ocurre un error de conexion 
	 */
	public Rol obtener(String codigo) throws ExceptionPropia{
		if(codigo == null && "".equals(codigo)){
			throw new ExceptionPropia("El codigo del rol a buscar no puede ser vacio");
		}
		
		return rolDAO.obtener(codigo);
	}
	
	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

}
