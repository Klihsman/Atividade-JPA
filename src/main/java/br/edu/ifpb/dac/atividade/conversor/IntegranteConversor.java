package br.edu.ifpb.dac.atividade.conversor;

import br.edu.ifpb.dac.atividade.entidades.Integrante;
import br.edu.ifpb.dac.atividade.repository.TesteIntegrante;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converter.Integrante")

public class IntegranteConversor implements Converter {

    TesteIntegrante is = new TesteIntegrante();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {

        if (value == null) {
            return null;
        }
        System.err.println("ad conver " + is);
        Integrante integrante = new Integrante();
        integrante = is.buscar();
        return integrante;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value == null) {
            return null;

        }

        Integrante integrante = (Integrante) value;
        return String.valueOf(integrante.getId());

    }
}
