package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * La clase Peticion corresponde al DTO Para la tabla peticiones
 */
public class Peticion {
	private Peticion2 peticion2;
	private int codigo;
	private String texto;
	private String cliente;
	private Date fechaCreacion;
	private int resuelto;
	public Peticion2 getPeticion2() {
		return peticion2;
	}
	public void setPeticion2(Peticion2 peticion2) {
		this.peticion2 = peticion2;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getResuelto() {
		return resuelto;
	}
	public void setResuelto(int resuelto) {
		this.resuelto = resuelto;
	}
	
	

}
