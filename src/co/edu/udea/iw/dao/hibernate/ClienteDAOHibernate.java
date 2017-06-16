package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionPropia;

/**
 * DAO de Cliente que accede a los datos de un cliente
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class ClienteDAOHibernate implements ClienteDAO {

	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Metodo que permite obtener un Cliente dada su cedula
	 * @param String con la cedula  del cliente
	 * @return un objeto del tipo Cliente con los datos del cliente
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Cliente obtener(String cedula) throws ExceptionPropia {
		Cliente cliente = null;
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			cliente = (Cliente)session.get(Cliente.class, cedula);
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error intentando obtener un cliente",e);
		}
		
		return cliente;
	}

	
	/**
	 * Metodo que entrega una lista con clientes existentes
	 * @return lista de clientes
	 * @throws ExceptionPropia cuando se produce un error con la comunicación a la BD
	 */
	@Override
	public List<Cliente> obtener() throws ExceptionPropia {
		Session session = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		Criteria criteria = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			
			criteria.addOrder(Order.asc("fechaCreacion"));
			
			clientes = criteria.list();
		}catch(HibernateException e){
			throw new ExceptionPropia("Ocurrio un error obteniendo el"
					+ "listado de los clientes",e);
		}
		
		return clientes;
	}

	/**
	 * ingresa un cliente 
	 * @param recibe un objeto cliente como parametro
	 * @return el objeto Cliente insertado
	 * @throws ExceptionPropia cuando se produce una error con la comunicación a la BD
	 */
	@Override
	public Cliente insertar(Cliente cliente) throws ExceptionPropia {
		Session session = null;	
		
		try{
			session = sessionFactory.getCurrentSession();			
			
			session.save(cliente);
			
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Ocurrio un error insertando un clientes",e);
		}
		return cliente;
	}

	
	/**
	 * Modifica la información de un cliente 
	 * @param recibe el objeto cliente que se desea modificar
	 * @return el objeto cliente modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Cliente modificar(Cliente cliente) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			session.update(cliente);
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error modificando un cliente",e);
		}
		
		return cliente;
	}
	
	
	

}
