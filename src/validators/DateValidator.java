package validators;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object arg2) throws ValidatorException {
		
		Date fecha=(Date)arg2;
		if(fecha.compareTo(new Date())<0){
			//String msg = "ERROR: Fecha anterior a hoy";
			
			Locale locale = context.getViewRoot().getLocale();
			ResourceBundle bundle = ResourceBundle.getBundle("messages",locale);
			String msg = bundle.getString("errorFechas");
			
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);

		}


	}

}
