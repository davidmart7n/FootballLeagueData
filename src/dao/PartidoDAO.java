package dao;

import java.util.List;

import domain.Partido;

public interface PartidoDAO {
		 
	    Partido findById(Integer id);
	    
	    List<Partido> findAll();
	    
	    List<Partido> findByJornada(String jornada);
	    
	    List<Partido> findByEquipo(String equipo);
	 
	    List<Partido> findBySimilarEquipo(String nombre);
	 
	    void save(Partido entity);
	 
	    void remove(Partido entity);

	}

