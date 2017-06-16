package co.edu.udea.iw.dto;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * La clase Cliente corresponde al DTO Para la tabla clientes con cada uno de sus
 * metodos get y set
 */
public class Cliente {
	private String cedula;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	
	
	/**
	 * Metodo get para atributo cedula - permite obtener la cedula de un cliente
	 * @return la cedula del cliente
	 * */
	public String getCedula() {
		return cedula;
	}
	
	/**
	 * Metodo set para atributo cedula - permite almacenar la cedula de un cliente
	 * @param la cedula del cliente
	 * 
	 * */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	/**
	 * Metodo get para atributo nombre - permite obtener el nombre de un cliente
	 * @return el nombre del cliente
	 * */
	public String getNombres() {
		return nombres;
	}
	
	/**
	 * Metodo set para atributo nombre - permite almacenar el nombre de un cliente en 
	 * la variable nombres
	 * @param el nombre del cliente
	 * 
	 * */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	/**
	 * Metodo get para atributo apellido - permite obtener el apellido de un cliente
	 * @return el apellido del cliente
	 * */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * Metodo set para atributo apellido - permite almacenar el apellido de un cliente en 
	 * la variable apellidos
	 * @param el apellido del cliente
	 * 
	 * */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * Metodo get para atributo email - permite obtener el email de un cliente
	 * @return el email del cliente
	 * */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo set para atributo del correo - permite almacenar el correo de un cliente en 
	 * la variable email
	 * @param correo del cliente
	 * 
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Metodo get para atributo telefono - permite obtener el telefono de un cliente
	 * @return el telefono del cliente
	 * */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Metodo set para atributo telefono - permite almacenar el telefono de un cliente en 
	 * la variable telefono
	 * @param el telefono del cliente
	 * 
	 * */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Metodo get para atributo direccion - permite obtener la  direccion de un cliente
	 * @return el nombre del cliente
	 * */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Metodo set para atributo direccion - permite almacenar la direccion de un cliente en 
	 * la variable direccion
	 * @param la direccion del cliente
	 * 
	 * */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
