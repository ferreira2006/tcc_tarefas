package missaocumprida.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import missaocumprida.usuario.Usuario;
import missaocumprida.usuario.UsuarioRN;

@FacesConverter(value = "converterUsuario")
public class ConverterUsuario implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			Long codigo = Long.valueOf(value);
			try {
				UsuarioRN usuarioRN = new UsuarioRN();
				return usuarioRN.carregar(codigo);
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar o usuario de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Usuario) {
			Usuario usuario = (Usuario) value;
			return String.valueOf(usuario.getId());
		}
		return "";
	}
}