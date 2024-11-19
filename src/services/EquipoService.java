package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import domain.Equipo;
import domain.Partido;

public interface EquipoService {

	public List<Equipo> findAll();
	
	public Equipo findById(Integer id);
	
	public void addEquipo(Equipo equipo);

	public void delEquipo(Integer id);
	
	public List<Equipo> findByNombre(String nombre);

}

	

