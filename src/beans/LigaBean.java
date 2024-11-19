/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import domain.Equipo;
import services.EquipoService;

@ManagedBean
@RequestScoped
public class LigaBean {
	
	
	/**** SERVICIOS ***********************************/
	@ManagedProperty(value="#{equipoService}")
	private EquipoService equipoService;
	public EquipoService getEquipoService() {return equipoService;}
	public void setEquipoService(EquipoService equipoService) {this.equipoService = equipoService;}
	/**************************************************/

	/**** ATRIBUTOS DE ENLACE CON VISTAS ***********************************/
	private String[] jornadas;
	public String[] getJornadas() {return getLornadasList();}
	public void setJornadas(String[] jornadas) {this.jornadas = jornadas;}
	
	private List<SelectItem> equipos;
	public List<SelectItem> getEquipos(){return this.getEquiposList();}
	public void setEquipos(List<SelectItem> equipos) {this.equipos = equipos;}

	private String equipo;
	public String getEquipo() {return equipo;}
	public void setEquipo(String equipo) {this.equipo = equipo;}
	
	private String estadioLocation;
	public void setEstadioLocation(String estadioLocation){this.estadioLocation = estadioLocation;}
	public String getEstadioLocation() {return getLocation();}
	/**************************************************/
	
	
	
	/******** MÉTODOS DE ACCESO A DATOS***********************************/
	private int numJornadas=38;
	
	private String[] getLornadasList(){
		if(jornadas==null){
			   jornadas=new String[numJornadas];
			   for(int i=0;i<numJornadas;i++) jornadas[i]=String.valueOf(i+1);
		}
		return jornadas;
	}

	private List<SelectItem> getEquiposList(){
		if(equipos==null){
			List<Equipo> lista= equipoService.findAll();
			equipos= new ArrayList<SelectItem>();
			for(Equipo e: lista){
				equipos.add(new SelectItem(e.getIdEquipo(),e.getNombre()));
			}
		}
		return equipos;
	}
	
	private String getLocation(){
		if(equipo.toLowerCase().indexOf("valencia")>=0) return "39.4745215,-0.3581571";
		if(equipo.toLowerCase().indexOf("barcelona")>=0) return "41.381542, 2.122893";
		if(equipo.toLowerCase().indexOf("real madrid")>=0) return "40.4530417,-3.6882944";
		if(equipo.toLowerCase().indexOf("levante")>=0) return "39.4947222,-0.3641667";
		if(equipo.toLowerCase().indexOf("villareal")>=0) return "39.9439906,-0.1032031";
		if(equipo.toLowerCase().indexOf("betis")>=0) return "37.3564779,-5.9817635";
		if(equipo.toLowerCase().indexOf("at. de madrid")>=0) return "40.4008758,-3.7206801";
		if(equipo.toLowerCase().indexOf("sevilla")>=0) return "37.3832844,-5.9754693";
		return null;
	}

}
