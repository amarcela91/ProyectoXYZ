package co.edu.udea.iw.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * La clase Peticion2 corresponde a una case con los datos de la clave compuesta
 * de una Petición y sus respectivos metodos gets y sets
 */
@Embeddable
public class Peticion2 implements Serializable {
	private int codigo;
	private Cliente cliente;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
