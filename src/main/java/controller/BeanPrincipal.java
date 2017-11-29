package controller;

import dao.DaoModule;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.ModelModulo;

/**
 * @author jessé
 */
@ManagedBean(name = "BeanPrincipal")
public class BeanPrincipal extends BeanPadrao {
    
    public BeanPrincipal() {
        super();
    }
    
    public String getPathFormulario() {
        return getParametro("path_consulta");
    }
    
    public String getPathMenuModulo() {
        return "include/" + this.getModuloAtualBySessao().getNome() + "/menu_modulo.xhtml";
    }

    public ModelModulo getModuloAtualBySessao() {
        return DaoModule.getModuloFromCodigo(Sessao.getInstance().getCodigoModuloAtual());
    }
    
    public static String getParametro(String name, String valueDefault) {
        String Param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
        return Param != null ? Param : valueDefault;
    }
    
    public static String getParametro(String name) {
        return getParametro(name, "");
    }
}
