package co.edu.udea.iw.impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.PeticionDAO;
import co.edu.udea.iw.dto.Peticion;
import co.edu.udea.iw.dto.Peticion2;
import co.edu.udea.iw.exception.ExceptionPropia;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Implementacion de los servicios que controlan una peticion
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class PeticionImpl {
	
	private PeticionDAO peticionDAO;
	
	private ClienteDAO clienteDAO;
	
	/**
	 * Metodo que permite crear una peticion y validar los parametros ingresados
	 * @param codigo de la peticion
	 * @param texto quoe crea la peticion
	 * @param cliente que explica el asunto de la peticion
	 * @param fechaCreacion de la peticion
	 * @throws ExceptionPropia si ocurre un error en la conexión 
	 * 
	 */
public void creaPeticion(Integer codigo, String texto, String cliente, Date fechaCreacion) throws ExceptionPropia{
		
		Peticion peticion = null;
		Peticion2 peticion2 = new Peticion2();
		
		if(codigo == null){
			throw new ExceptionPropia("El codigo de la peticion no puede ser nula");
		}
		if(Validaciones.isTextoVacio(texto)){
			throw new ExceptionPropia("El texto de la peticion no puede ser nulo");
		}
		if(Validaciones.isTextoVacio(cliente)){
			throw new ExceptionPropia("El cliente no puede ser nulo");
		}
				
		if(clienteDAO.obtener(cliente) == null){
			throw new ExceptionPropia("El cliente con cedula " + cliente + " no existe en el sistema");
		}
		
		peticion2.setCodigo(codigo);
		peticion2.setCliente(clienteDAO.obtener(cliente));
		
		peticion = new Peticion();
		
		peticion.setPeticion2(peticion2);
		peticion.setTexto(texto);
		peticion.setFechaCreacion(fechaCreacion);
		peticion.setResuelto(0);
		
		peticionDAO.insertar(peticion);
		
	}

	/**
	 * metodo que obtiene todas las peticiones
	 * @return listado de las peticiones
	 * @throws ExceptionPropia si ocurre un error en la conexión
	 */
	public List<Peticion> obtener() throws ExceptionPropia{
		return peticionDAO.obtener();
	}
	
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}
	
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}


	public PeticionDAO getPeticionDAO() {
		return peticionDAO;
	}


	public void setPeticionDAO(PeticionDAO peticionesDAO) {
		this.peticionDAO = peticionesDAO;
	}

}
