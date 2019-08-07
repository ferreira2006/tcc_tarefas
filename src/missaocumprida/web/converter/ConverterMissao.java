package missaocumprida.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import missaocumprida.missao.Missao;
import missaocumprida.missao.MissaoRN;

@FacesConverter(value = "converterMissao")
public class ConverterMissao implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Long codigo = Long.valueOf(value);
			try {
				MissaoRN missaoRN = new MissaoRN();
				return missaoRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o missao de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Missao) {
			Missao missao = (Missao) value;
			return String.valueOf(missao.getId());
		}
		return "";
	}
}