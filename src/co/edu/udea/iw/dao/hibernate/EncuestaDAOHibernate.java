package co.edu.udea.iw.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.EncuestaDAO;
import co.edu.udea.iw.dto.Encuesta;
import co.edu.udea.iw.exception.ExceptionPropia;


/**
 * DAO para acceder a los datos de la Encuesta
 *  @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class EncuestaDAOHibernate implements EncuestaDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Crea una nueva encuesta
	 * @param recibe un objeto encuesta con la informacion de la encuesta
	 * @return peticion insertada
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Encuesta insertar(Encuesta encuesta) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(encuesta);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al insertar una encuesta",e);
		}
		return encuesta;
	}

	/**
	 * Entrega los datos de una encuesta dado su codigo
	 * @param recibe el codigo de la encuesta a obtener
	 * @return una instancia de los datos de la encuesta obtenida, si no existe
	 * dicha encuesta con el codigo dado retorna null
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Encuesta obtener(Integer codigo) throws ExceptionPropia {
		Encuesta encuesta = null;
		
		try{
			Session session = sessionFactory.getCurrentSession();
			
			encuesta = (Encuesta)session.get(Encuesta.class, codigo);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtener una encuesta",e);
		}
		
		return encuesta;
	}

}
