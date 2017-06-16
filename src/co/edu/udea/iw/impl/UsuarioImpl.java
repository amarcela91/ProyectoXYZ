package co.edu.udea.iw.impl;

import java.util.List;

import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionPropia;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementacion de los servicios que controlan el usuario
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class UsuarioImpl {
	private UsuarioDAO usuarioDAO;
	
	private RolDAO rolDAO;
	
	/**
	 * Metodo que crea un usuario y valida los parametros ingreados
	 * @param login del usuario
	 * @param nombres del usuario
	 * @param apellidos del usuario
	 * @param contrasena del usuario
	 * @param rol del usuario 
	 * @throws ExceptionPropia en caso de ocurrir erro de conexion
	 */
	public void crearUsuario(String login, String nombres, String apellidos, String contrasena, String rol) throws ExceptionPropia{
		
		Usuario usuario = new Usuario();	
		Cifrar cifrar = new Cifrar();
		Rol roles = new Rol();
		
		if(Validaciones.isTextoVacio(login)){
			throw new ExceptionPropia("El login del usuario no puede ser nula");
		}
						
		if(Validaciones.isTextoVacio(nombres)){
			throw new ExceptionPropia("El nombre del usuario no puede ser nula");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new ExceptionPropia("El apellido no puede ser nulo");
		}
		
		if(Validaciones.isTextoVacio(contrasena)){
			throw new ExceptionPropia("La clave del usuario no puede ser nula");
		}
		
		if(Validaciones.isTextoVacio(rol)){
			throw new ExceptionPropia("El rol del usuario no puede ser nula");
		}
				
		roles = rolDAO.obtener(rol);
		
		
		if(roles == null){
			throw new ExceptionPropia("Rol no válido");
		}
		
		
		Usuario usuarioCheck = new Usuario();
		usuarioCheck = usuarioDAO.obtener(login);
		
		if(usuarioCheck != null){
			throw new ExceptionPropia("Usuario ya existe en el sistema");
		}
		

		usuario.setLogin(login);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setContrasena(cifrar.encrypt(contrasena));
		usuario.setRol(roles);
		
		usuarioDAO.crear(usuario);
		
	}

	/**
	 * Metodo que permite obtener el listado de los usuarios existentes
	 * @return listado de usuarios
	 * @throws ExceptionPropia si ocurre un error de conexión
	 */
	public List<Usuario> obtener() throws ExceptionPropia{
		return usuarioDAO.obtener();
	}	
	
	/**
	 * Metodo que permite obtener el un usuario correspondiente al login
	 * @return usuario correspondiente al login
	 * @throws ExceptionPropia si ocurre un error de conexión
	 */
	public Usuario obtener(String login) throws ExceptionPropia{
		if(login == null && "".equals(login)){
			throw new ExceptionPropia("El login del usuario a buscar no puede ser nulo");
		}
		
		return usuarioDAO.obtener(login);
	}
	

	/**
	 * Metodo que usa la clase Cifrar y Validaciones para verificar los datos ingresados  
	 * @param login del usuario 
	 * @param clave del usuario
	 * @return boolean que indica si los datos son correctos o no
	 * @throws ExceptionPropia en caso de ocurrir un error
	 */
	public Boolean validar(String login, String clave) throws ExceptionPropia{
		
		Cifrar cifrar = new Cifrar();
		
		if(Validaciones.isTextoVacio(login)){
			throw new ExceptionPropia("El login del usuario no puede ser nulo");
		}
		
		if(Validaciones.isTextoVacio(clave)){
			throw new ExceptionPropia("La clave del usuario no puede ser nula");
		}
		
		Usuario usuario = usuarioDAO.obtener(login);
		if(usuario == null){
			throw new ExceptionPropia("usuario o contraseña no invalidos");
		}
		
		
		if(!cifrar.encrypt(clave).equals(usuario.getContrasena())){
			throw new ExceptionPropia("Usuario o contraseña no invalidos");
		}
		
		return Boolean.TRUE;		
		
	}

	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

}
