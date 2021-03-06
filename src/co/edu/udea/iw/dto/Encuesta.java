package co.edu.udea.iw.dto;

/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * La clase Encuesta corresponde al DTO Para la tabla encuestas con sus respectivos
 * metodos get y set para obtener, almacenar datos.
 */
public class Encuesta {
	private Integer codigo;
	private Integer pregunta1;
	private Integer pregunta2;
	private Integer pregunta3;
	private Integer pregunta4;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getPregunta1() {
		return pregunta1;
	}
	public void setPregunta1(Integer pregunta1) {
		this.pregunta1 = pregunta1;
	}
	public Integer getPregunta2() {
		return pregunta2;
	}
	public void setPregunta2(Integer pregunta2) {
		this.pregunta2 = pregunta2;
	}
	public Integer getPregunta3() {
		return pregunta3;
	}
	public void setPregunta3(Integer pregunta3) {
		this.pregunta3 = pregunta3;
	}
	public Integer getPregunta4() {
		return pregunta4;
	}
	public void setPregunta4(Integer pregunta4) {
		this.pregunta4 = pregunta4;
	}
	
	
	

}
