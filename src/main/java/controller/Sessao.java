package controller;

import dao.DaoModule;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jessé
 */
@ManagedBean
@SessionScoped
public class Sessao {
    
    private HttpSession sessao;
    private static Sessao INSTANCE;
    
    private Sessao() {
        this.sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    public static Sessao getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Sessao();
        }
        return INSTANCE;
    }
    
    public void atualizaModulo() {
        String modulo = BeanPrincipal.getParametro("modulo");
        if(modulo != null && !modulo.trim().equals("")) {
            this.setAtributo("codigo_modulo", modulo);
        }
        
        String cod_modulo_sessao = this.getAtributo("codigo_modulo");
        
        if((cod_modulo_sessao == null) || (cod_modulo_sessao.trim().equals(""))) {
            this.setAtributo("codigo_modulo", String.valueOf(DaoModule.getModuloDefault().getCodigo()));
        }
    }
    
    public int getCodigoModuloAtual() {
        String cod_modulo = this.getAtributo("codigo_modulo");
        int retorno       = 0;
        if(cod_modulo != null && !cod_modulo.trim().equals("")) {
            retorno = Integer.parseInt(cod_modulo);
        }
        return retorno;
    }
    
    public void setAtributo(String nome, String valor) {
        this.sessao.setAttribute(nome, valor);
    }
    
    public String getAtributo(String nome) {
        return (String) this.sessao.getAttribute("codigo_modulo");
    }
}
