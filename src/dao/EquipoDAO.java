package dao;

import java.util.List;

import domain.Equipo;

public interface EquipoDAO {
		
		Equipo findById(Integer id);	
    
	    List<Equipo> findAll();
	    
	    List<Equipo> findByEquipo(String e);
	    
	    List<Equipo> findBySimilarEquipo(String e);

	    void save(Equipo equipo);
	    
	    void remove(Equipo equipo);
	    
	}

