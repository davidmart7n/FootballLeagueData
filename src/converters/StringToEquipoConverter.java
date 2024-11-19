package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import domain.Equipo;
import services.EquipoService;

public class StringToEquipoConverter implements Converter {
	
	private EquipoService equipoService;
	public EquipoService getEquipoService() {return equipoService;}
	public void setEquipoService(EquipoService equipoService) {this.equipoService = equipoService;}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		Equipo e=equipoService.findById(Integer.parseInt(id));
		return e;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}
	
}
