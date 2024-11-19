/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import domain.Partido;
import services.PartidoService;

@ManagedBean
@SessionScoped
public class PartidoBean {

	/**** SERVICIOS ***********************************/
	@ManagedProperty(value="#{partidoService}")
	private PartidoService partidoService;
	public PartidoService getPartidoService() {return partidoService;}
	public void setPartidoService(PartidoService partidoService) {this.partidoService = partidoService;}
	/**************************************************/	

	
	/**** ATRIBUTOS DE ENLACE CON VISTAS ***********************************/
	private Partido partido;
	public Partido getPartido() {return partido;}
    public void setPartido(Partido partido) {this.partido = partido;}

    private List<Partido> listaDePartidos;
    public List<Partido> getListaDePartidos() {return this.getPartidos();}
    public void setListaDePartidos(List<Partido> partidos) {this.listaDePartidos = partidos;}

    private boolean porJugar;
	public boolean isPorJugar() {return porJugar;}
	public void setPorJugar(boolean porJugar) {this.porJugar = porJugar;}
	
	private String jornada;
	public String getJornada() {return jornada;}
	public void setJornada(String jornada) {this.jornada = jornada;}
	
    private String equipo;
    public String getEquipo(){return equipo;}
	public void setEquipo(String equipo){this.equipo = equipo;}
	
	private String selectedPartido;
	public String getSelectedPartido(){return selectedPartido;	}
	public void setSelectedPartido(String selectedPartido){this.selectedPartido = selectedPartido;}
	
	/**************************************************/
	
		
	
	/******** LISTENERS Y M�TODOS DE ACCESO A DATOS***********************************/
    private boolean dirty=false;
    
	private List<Partido> getPartidos(){
		 if(listaDePartidos==null || dirty==true){
	            listaDePartidos=this.partidoService.findAll();
	            dirty=false;
	            selectedPartido=null;
	     }
		 return listaDePartidos;
	}
	  
    public void filtroJornada(){
    	listaDePartidos=this.partidoService.findByJornada(jornada);
    }
    
    public void filtroEquipo(){
    	listaDePartidos=this.partidoService.findByEquipo(equipo);
    }
	
	public String guardaPartido(){
		String equipoLocal=partido.getEquipoLocal().getNombre();
		String equipoVisitante=partido.getEquipoVisitante().getNombre();

		if(!equipoLocal.equals(equipoVisitante)){
		   guardar();
		   return "listado";
		}
		else{
		   return "error";
		}
	}
	   
	private void guardar(){
		   this.partidoService.addPartido(partido);
		   dirty=true;
	}
	
	public void eliminar(ActionEvent e){

		this.partidoService.delPartido(Integer.valueOf(selectedPartido));
		
		selectedPartido=null;
		dirty=true;
	}
	
		
	public void actualizar(ActionEvent e){
		selectedPartido=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedPartido");
		partido=this.partidoService.findById(Integer.valueOf(selectedPartido));
	}
	    
	public void crearPartido(){
    	partido=new Partido();
    }
    /*******************************************************************/
    
     
  
	
    

}
