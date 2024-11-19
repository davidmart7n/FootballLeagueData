package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.PartidoDAO;
import domain.Partido;

@Transactional
public class PartidoServiceImpl implements PartidoService{
	
	private PartidoDAO dao;
	public PartidoDAO getDao() {return dao;}
	public void setDao(PartidoDAO dao) {this.dao = dao;}
	
	@Transactional(readOnly=true)
	public List<Partido> findByEquipo(String equipo) {
		if(equipo.trim().length()==0)
    		return dao.findAll();
    	else
    		return dao.findBySimilarEquipo(equipo);
	}

	@Override
	public void addPartido(Partido p) {
		dao.save(p);
	}

	@Override
	public void delPartido(Integer id) {
		Partido p=dao.findById(id);
		dao.remove(p);
	}

	@Transactional(readOnly=true)
	public List<Partido> findByJornada(String jornada) {
		if(jornada.equals("Todas"))
    		return dao.findAll();
    	else
    		return dao.findByJornada(jornada);
	}

	@Transactional(readOnly=true)
	public List<Partido> findAll() {
		return dao.findAll();
	}

	@Transactional(readOnly=true)
	public Partido findById(Integer id) {
		return dao.findById(id);
	}

}
