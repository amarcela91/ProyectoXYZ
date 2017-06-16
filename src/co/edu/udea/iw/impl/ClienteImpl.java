package co.edu.udea.iw.impl;

import java.util.List;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionPropia;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementacion de los servicios que controlan los clientes
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/

public class ClienteImpl {
	
	private ClienteDAO clienteDAO;
	
	
	/**
	 * Metodo que recibe y valida los parametros para crear un cliente 
	 * @param cedula del cliente
	 * @param nombres del cliente
	 * @param apellidos del cliente
	 * @param email de cliente
	 * @param telefono del cliente
	 * @param direccion del cliente
	 * @throws ExceptionPropia en caso de ocurrir un error
	 * 
	 */
	public void guardaCliente(String cedula, String nombres, String apellidos, 
			String email, String telefono, String direccion) throws ExceptionPropia{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new ExceptionPropia("Error, cedula del cliente no puede estar vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new ExceptionPropia("Error, nombre del cliente no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new ExceptionPropia("Error, el apellido del cliente no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(email)){
			throw new ExceptionPropia("Error, el correo no es valido");
		}
		if(Validaciones.isTextoVacio(telefono)){
			throw new ExceptionPropia("Error, el telefono no puede ser nulo");
		}
		
		if(!Validaciones.isEmail(direccion)){
			throw new ExceptionPropia("La direccion del cliente no puede ser nulo");
		}
		
		if(clienteDAO.obtener(cedula) != null){
			throw new ExceptionPropia("Ya existe un cliente con cedula " + cedula);
		}
		
		
		
		cliente = new Cliente();
		
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		
		clienteDAO.insertar(cliente);
	}
	
	/**
	 * Metodo que permite actualizar un cliente y valida los datos a actualizar
	 * @param cedula del cliente
	 * @param nombres del cliente
	 * @param apellidos del cliente
	 * @param email de cliente
	 * @param telefono del cliente
	 * @param direccion del cliente
	 * @throws ExceptionPropia en caso de ocurrir un error
	 * 
	 */
	public void actualizarCliente(String cedula, String nombres, String apellidos, 
			String email, String telefono, String direccion) throws ExceptionPropia{
		
		Cliente cliente = null;
		
		if(Validaciones.isTextoVacio(cedula)){
			throw new ExceptionPropia("La cédula del cliente no puede ser nula");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new ExceptionPropia("Los nombres del cliente no puede ser nula");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new ExceptionPropia("Los apellidos del cliente no puede ser nula");
		}
		if(Validaciones.isTextoVacio(email)){
			throw new ExceptionPropia("El email del cliente no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(telefono)){
			throw new ExceptionPropia("El telefono del cliente no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(direccion)){
			throw new ExceptionPropia("La direccion del cliente no puede ser nula");
		}
		
		if(!Validaciones.isEmail(email)){
			throw new ExceptionPropia("El correo electrónico del cliente debe ser válido");
		}
		
				
		cliente = clienteDAO.obtener(cedula);
		
		if(cliente == null){
			throw new ExceptionPropia("El cliente a modificar no existe en el sistema");
		}
		
		
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		
		clienteDAO.modificar(cliente);
		
	}
	
	/**
	 * Metodo retorna una lista de clientes del sistema
	 * @return lista de clientes
	 * @throws ExceptionPropia si ocurre algun error con la conexion a la BD
	 */
	
	public List<Cliente> obtener() throws ExceptionPropia{
		return clienteDAO.obtener();
	}
	
	/**
	 * Metodo que permite obtener un cliente dada la cedula
	 * @param cedula del cliente
	 * @return el cliente correspondiente a la cedula ingresada
	 * @throws ExceptionPropia si ocurre algun error en la conexión 
	 * 
	 */
	public Cliente obtener(String cedula) throws ExceptionPropia{
		if(cedula == null && "".equals(cedula)){
			throw new ExceptionPropia("La cédula del cliente a buscar no puede ser nula");
		}
		
		return clienteDAO.obtener(cedula);
	}
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}


	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}


	
	

}
