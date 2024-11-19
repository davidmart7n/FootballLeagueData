package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import dao.utils.GenericHibernateDAO;
import domain.Partido;


class PartidoDAOImpl extends GenericHibernateDAO implements PartidoDAO {

	@SuppressWarnings("unchecked")
	public Partido findById(Integer id) {
		Partido entity;
		entity = (Partido) getSession().get(Partido.class, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Partido> findAll() {
		Query q = getSession().createQuery("From Partido");
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Partido> findByJornada(String jornada) {
		Criteria crit = getSession().createCriteria(Partido.class);
		crit.add(Restrictions.eq("jornada", Integer.parseInt(jornada)));
		return crit.list();
	}


	@SuppressWarnings("unchecked")
	public List<Partido> findByEquipo(String equipo) {
		Query q = getSession().createQuery("From Partido p " +
										   "where p.equipoLocal.nombre='"+equipo+
										   "' or p.equipoVisitante.nombre='"+equipo+"'");
		return q.list();
	}
	
	@SuppressWarnings("unchecked")	
	public List<Partido> findBySimilarEquipo(String nombre){
		Query q = getSession().createQuery("From Partido p " +
				   "where lower(p.equipoLocal.nombre) like ?" +
				   "or lower(p.equipoVisitante.nombre) like ?");
		
		q.setParameter(0, nombre.toLowerCase()+"%");
		q.setParameter(1, nombre.toLowerCase()+"%");
		return q.list();
	}
	
	public void save(Partido entity) {
		getSession().saveOrUpdate(entity);
	}

	public void remove(Partido entity) {
		getSession().delete(entity);
	}

}
