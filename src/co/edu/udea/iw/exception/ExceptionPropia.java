package co.edu.udea.iw.exception;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * Clase ExceptionPropia que hereda de la clase Exception y manejará las excepciones del
 * proyecto
 */
public class ExceptionPropia extends Exception {
	
	/**
	 * Metodo ExceptionPropia maneja excepciones con null como mensaje de detalle
	 */
	public ExceptionPropia() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo ExceptiónPropia(String arg0) maneja excepciones con mensaje especificado
	 * @param String con el mensaje del posible error
	 */	
	public ExceptionPropia(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo ExceptionPropia(Throwable arg0) maneja excepciones que muestra la causa y 
	 * el mensaje de la excepción.
	 * @param arg0 indica la causa del posible error
	 */
	public ExceptionPropia(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo ExceptionPropia(String arg0, Throwable arg1) construye una nueva excepción  
	 * con el mensaje indicado en el string y la causa en el arg1
	 * @param arg0 El mensaje detallado del posible error. 
	 * @param arg1 indica la causa del posible error.
	 */
	public ExceptionPropia(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
