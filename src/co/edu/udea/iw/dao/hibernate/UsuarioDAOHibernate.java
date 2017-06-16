package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionPropia;

/**
 * DAO para acceder a los datos de un usuario
 * @author Adriana Guzman - amarcela.guzman@udea.edu.co
 * @since Java 1.8
 * @version 1.0
*/
public class UsuarioDAOHibernate implements UsuarioDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * obtiene la información de un usuario dadas su login
	 * @param login instancia del cliente a crear
	 * @return retorna los datos del usuario
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Usuario obtener(String login) throws ExceptionPropia {
		Session session = null;
		Usuario usuario = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			
			usuario = (Usuario)session.get(Usuario.class, login);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtner un usuario",e);
		}
		
		return usuario;
	}

	/**
	 * crea un nuevo usuario 
	 * @param usuario a ser creado
	 * @return usuario creado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	
	public Usuario crear(Usuario usuario) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al crear un usuario",e);
		}
		return usuario;
	}

	/**
	 * modifica un usuario 
	 * @param usuario a ser modificado
	 * @return el usuario modificado
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public Usuario modificar(Usuario usuario) throws ExceptionPropia {
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			session.update(usuario);
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al modificar un usuario",e);
		}
		
		return usuario;
	}

	
	/**
	 * Entrega la lista de usuarios existentes en el sistema
	 * @return lista de usuarios
	 * @throws ExceptionPropia cuando se produce una excepcion con la comunicación a la BD
	 */
	@Override
	public List<Usuario> obtener() throws ExceptionPropia {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(Usuario.class);
			
			usuarios = criteria.list();
			
		}catch(HibernateException e){
			throw new ExceptionPropia("Error al obtener un listado de usuarios",e);
		}
		
		return usuarios;
	}

}
