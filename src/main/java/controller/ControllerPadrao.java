package controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author jessé
 */
public abstract class ControllerPadrao {

    public ControllerPadrao() {
        Sessao oSessao = Sessao.getInstance();
        oSessao.atualizaModulo();
    }
    
    public void mensagemInclusaoOk() {
        addMessage("Registro Incluido Com sucesso!!");
    }
    
    public void mensagemInclusaoErro() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Incluir Registro.");
    }
    
    public void mensagemAlteracaoOk() {
        addMessage("Registro Alterado Com sucesso!!");
    }
    
    public void mensagemAlteracaoErro() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Alterar Registro.");
    }
    
    public void mensagemExclusaoOk() {
        addMessage("Registro Excluído Com sucesso!!");
    }
    
    public void mensagemExclusaoErro() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Excluir Registro.");
    }
    
    public void addMessage(String textoMsg) {
        this.addMessage(FacesMessage.SEVERITY_INFO, textoMsg);
    }

    private void addMessage(FacesMessage.Severity severity, String textoMsg) {
        FacesMessage message = new FacesMessage(severity, textoMsg,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public static void addMessageErro(String msg) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
