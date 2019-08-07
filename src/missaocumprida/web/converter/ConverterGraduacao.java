package missaocumprida.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import missaocumprida.graduacao.Graduacao;
import missaocumprida.graduacao.GraduacaoRN;

@FacesConverter(value = "converterGraduacao")
public class ConverterGraduacao implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Long codigo = Long.valueOf(value);
			try {
				GraduacaoRN graduacaoRN = new GraduacaoRN();
				return graduacaoRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o graduacao de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Graduacao) {
			Graduacao graduacao = (Graduacao) value;
			return String.valueOf(graduacao.getId());
		}
		return "";
	}
}