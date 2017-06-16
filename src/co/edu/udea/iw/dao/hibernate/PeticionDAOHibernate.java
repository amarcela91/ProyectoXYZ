package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.PeticionDAO;
import co.edu.udea.iw.dto.Peticion;
import co.edu.udea.iw.dto.Peticion2;
import co.edu.udea.iw.exception.ExceptionPropia;

/**
 * DAO para acceder a los datos de una peticion
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class PeticionDAOHibernate implements PeticionDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * inserta una nueva peticion
	 * @param objeto peticion con la informacion de la misma
	 * @return el objeto peticion que fue insertado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Peticion insertar(Peticion peticiones) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(peticiones);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al insertar una peticion",e);
		}
		return peticiones;
	}

	/**
	 * Metodo para obtener una peticion
	 * @param objeto Peticion2 (la identificacion de la peticion a obtener)
	 * @return un objeto petición correspondiente al id enviado en el parametro
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */	
	@Override
	public Peticion obtener(Peticion2 peticion2) throws ExceptionPropia {
		Peticion peticiones = null;
		
		try{
			Session session = sessionFactory.getCurrentSession();
			
			peticiones = (Peticion)session.get(Peticion.class, peticion2);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtener una peticion",e);
		}
		
		return peticiones;
	}

	
	/**
	 * Metodo que permite obtener el listado de peticiones
	 * @return una lista de todas las peticiones
	 * @throws .ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public List<Peticion> obtener() throws ExceptionPropia {
		List<Peticion> peticiones = new ArrayList<Peticion>();
		
		try{
			Session session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(Peticion.class).add(Restrictions.eq("resuelto", false));
			
			peticiones = criteria.list();
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error obteniendo el listado de peticiones",e);
		}
		
		return peticiones;
	}

}
