package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.RolDAO;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.ExceptionPropia;

/**
 * DAO para acceder a los datos del rol
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class RolDAOHibernate implements RolDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Metodo que permite obtener un rol dado su codigo
	 * @param el codigo del rol
	 * @return el objeto rol correspondiente al codigo
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Rol obtener(String codigo) throws ExceptionPropia {
		Session session = null;
		Rol rol = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			
			rol = (Rol)session.get(Rol.class, codigo);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtener un rol",e);
		}
		
		return rol;
	}

	/**
	 * Metodo que permite obtener el listado de los roles existentes
	 * @return una lista con informacion de los roles
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public List<Rol> obtener() throws ExceptionPropia {
		List<Rol> rol = new ArrayList<Rol>();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(Rol.class);
			
			rol = criteria.list();
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtener un listado de roles",e);
		}
		
		return rol;
	}

	/**
	 * Metodo que permite modificar un rol en la BD
	 * @param Un objeto Rol que se desea modifiar
	 * @return el objeto Rol modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Rol modificar(Rol rol) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			session.update(rol);
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al modificar un rol",e);
		}
		
		return rol;
	}

	/**
	 * Metodo que permite insertar un rol 
	 * @param objeto Rol con sus respectivos datos
	 * @return el objeto rol que fue insertado 
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */ 
	@Override
	public Rol insertar(Rol rol) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(rol);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al insertar un rol",e);
		}
		return rol;
	}

}
