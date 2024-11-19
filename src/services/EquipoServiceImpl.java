package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.EquipoDAO;
import domain.Equipo;

@Transactional
public class EquipoServiceImpl implements EquipoService {
	
	private EquipoDAO dao;
	public EquipoDAO getDao() {return dao;}
	public void setDao(EquipoDAO dao) {this.dao = dao;}


	@Transactional(readOnly=true)
	public List<Equipo> findAll() {
		return dao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Equipo findById(Integer id) {
		return dao.findById(id);
	}
	@Override
	public void addEquipo(Equipo equipo) {
		dao.save(equipo);
		
		
	}
	@Override
	public void delEquipo(Integer id) {
		Equipo e=dao.findById(id);
		dao.remove(e);
		
	}
	@Transactional(readOnly=true)
	public List<Equipo> findByNombre(String nombre) {
		if(nombre.trim().length()==0)
    		return dao.findAll();
		else
			return dao.findBySimilarEquipo(nombre);
		
	}
	

}
