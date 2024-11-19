package beans;

import java.util.List;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import domain.Equipo;
import services.EquipoService;


public class EquipoBean {


    /**** SERVICIOS ***********************************/
    private EquipoService equipoService;
    public EquipoService getEquipoService() {return equipoService;}
    public void setEquipoService(EquipoService equipoService) {this.equipoService = equipoService;}
    /**************************************************/    

    /**** ATRIBUTOS DE ENLACE CON VISTAS ***********************************/
    private Equipo equipo;
    public Equipo getEquipo() {return equipo;}
    public void setEquipo(Equipo equipo) {this.equipo = equipo;}

    private List<Equipo> listaDeEquipos;
    public List<Equipo> getListaDeEquipos() {return this.getEquipos();}
    public void setListaDeEquipos(List<Equipo> equipos) {this.listaDeEquipos = equipos;}

    private String nombreEquipo;
    public String getNombreEquipo() {return nombreEquipo;}
    public void setNombreEquipo(String filtroNombre) {this.nombreEquipo = filtroNombre;}
     private Integer selectedEquipo;    public Integer getSelectedEquipo() {return selectedEquipo;}	public void setSelectedEquipo(Integer selectedEquipo) {this.selectedEquipo = selectedEquipo;}	
	 /**************************************************/
	public EquipoBean() {
	    this.equipo = new Equipo();
	    System.out.println("Usando el Constructor");
	}
	/******** LISTENERS Y M�TODOS DE ACCESO A DATOS ***********************************/
    private boolean dirty = false;

    private List<Equipo> getEquipos() {
  
        if (listaDeEquipos == null || dirty == true) {
            listaDeEquipos = this.equipoService.findAll();
            dirty = false;
            selectedEquipo=null;
        }
        return listaDeEquipos;
    }
    	
    public void filtroPorNombre() {
            listaDeEquipos = this.equipoService.findByNombre(nombreEquipo);
    }

    public void crearEquipo() {
        equipo = new Equipo();   
        System.out.println("NEW TEAM IS CREATED");
    }

    public void guardar() {
    	if (equipo == null) {
            System.out.println("Equipo es null antes de guardar");
        } else {
            System.out.println("Nombre equipo antes de guardar: "
        + equipo.getNombre());}
    	
   	 System.out.println("Guardando Equipo: " + equipo.toString());
     this.equipoService.addEquipo(equipo);
     dirty = true;
    }
    

    public void eliminar(ActionEvent e) {
        this.equipoService.delEquipo(Integer.valueOf(selectedEquipo));
        dirty = true;
     }
    
    public void preactualizar(ActionEvent e) {
    	  String selectedEquipoParam = FacesContext.getCurrentInstance().getExternalContext().
    			  getRequestParameterMap().get("selectedEquipo");
        if (selectedEquipoParam != null) {
        	selectedEquipo=Integer.valueOf(selectedEquipoParam);
            equipo = this.equipoService.findById(selectedEquipo);
            System.out.println("ID del equipo: "+selectedEquipo);
            
        	System.out.println("Nombre antiguo : "+equipo.getNombre()+" Direccion antigua: "+equipo.getDireccion());

            
            System.out.println(equipo+" actualizado");
        } else {
            System.out.println("No se ha seleccionado un equipo para editar.");
        }
    }
    

    public void actualizar(ActionEvent e) {
        if (selectedEquipo != null) {
                     
            equipoService.addEquipo(equipo);
        	System.out.println("Nombre nuevo: "+equipo.getNombre()+" Direccion nueva: "+equipo.getDireccion());

            
            System.out.println(equipo+" actualizado");
        } else {
            System.out.println("No se ha seleccionado un equipo para editar.");
        }
    }
 }

