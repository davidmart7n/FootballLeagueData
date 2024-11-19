package dao;

import java.util.List;

import org.hibernate.Query;

import dao.utils.GenericHibernateDAO;
import domain.Equipo;
import domain.Partido;


class EquipoDAOImpl extends GenericHibernateDAO implements EquipoDAO{

	@SuppressWarnings("unchecked")
	public Equipo findById(Integer id) {
		Equipo equipo;
		equipo = (Equipo) getSession().get(Equipo.class, id);
		return equipo;
	}

	@SuppressWarnings("unchecked")
	public List<Equipo> findAll() {
		Query q = getSession().createQuery("From Equipo");
		return q.list();
	}
	@SuppressWarnings("unchecked")
	public List<Equipo> findByEquipo(String equipo) {
		Query q = getSession().createQuery("From Equipo e " +
				   "where e.nombre='"+equipo+"'");
		return q.list();	
	}
	@SuppressWarnings("unchecked")	
	public List<Equipo> findBySimilarEquipo(String nombre){
		Query q = getSession().createQuery("From Equipo e " +
				   "where lower(e.nombre) like ?");
		
		q.setParameter(0, nombre.toLowerCase()+"%");
		return q.list();
	}

	
	public void save(Equipo equipo) {
		getSession().saveOrUpdate(equipo);
	}

	
	public void remove(Equipo equipo) {
		getSession().delete(equipo);
	}
	
	

}
