/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.atividade.validacao;

import br.edu.ifpb.dac.atividade.entidades.Integrante;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "validator.Integrante")
public class IntegranteValidador implements Validator{
  @Override
    public void validate(
        FacesContext context,
        UIComponent component,
        Object value) throws ValidatorException {
         Integrante in = (Integrante) value;

        if (in==null) {
            FacesMessage facesMessage = new FacesMessage("valor inválido para o integrante");
            throw new ValidatorException(facesMessage);
        }
    }
   
}
