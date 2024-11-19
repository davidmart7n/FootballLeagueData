package services;

import java.util.List;

import domain.Partido;

public interface PartidoService {

	
	public List<Partido> findAll();
	
	public Partido findById(Integer id);
	
	public List<Partido> findByJornada(String jornada);
	
	public List<Partido> findByEquipo(String equipo);
	
	public void addPartido(Partido p);
	
	public void delPartido(Integer id);
	
}
