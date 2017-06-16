package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionPropia;
/**
 * Interface que me define los metodos permitidos para los clientes
 * en el sistema
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public interface ClienteDAO {
	
	/**
	 * Entrega la información del cliente correspondiente a una cedula
	 * @param cedula  del cliente
	 * @return un objeto del tipo Cliente con los datos del cliente
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Cliente obtener(String cedula) throws ExceptionPropia;
	
	
	/**
	 * Entrega la lista de clientes activos en el sistema
	 * @return lista de clientes
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public List<Cliente> obtener() throws ExceptionPropia;
	
	/**
	 * inserta un cliente 
	 * @param recibe un objeto cliente como parametro
	 * @return el objeto Cliente insertado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Cliente insertar(Cliente cliente) throws ExceptionPropia;
	
	
	/**
	 * Modifica la información de un cliente 
	 * @param recibe el objeto cliente que se desea modificar
	 * @return el objeto cliente modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	public Cliente modificar(Cliente cliente) throws ExceptionPropia;	
	
	

}
