package co.edu.udea.iw.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.exception.ExceptionPropia;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
/**
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
 * 
 * Clase UsuarioImplTest implementa la clase UsuarioImpl
 * 
 */
public class UsuarioImplTest {
	@Autowired
	UsuarioImpl usuarioImpl;
	
	@Test
	//test  que crea un usuario
	public void testCrearUsuario() {
		try{
			usuarioImpl.crearUsuario("Empleado4", "Peranito", "Perez", "filial", "EMP");
			
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}		
	}
	
	@Test
	//test que obtiene todos los usuarios
	public void testObtener() {
		try{
			usuarioImpl.obtener();
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}		
	}
	
	@Test
	//test que obtiene un usuario
	public void testObtenerUno() {
		try{
			usuarioImpl.obtener("Encargado");
		}catch(ExceptionPropia e){
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	//test que valida datos ingresados
	public void testValidar() {
		
		try {
			usuarioImpl.validar("Empleado4", "filial");
		} catch (ExceptionPropia e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		} 
	}

}
