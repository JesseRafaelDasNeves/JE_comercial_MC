package controller;

import dao.DaoPessoa;
import dao.DaoUsuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Lista;
import model.ModelUsuario;
import services.UsuarioService;

@ManagedBean(name = "BeanLogin")
@ViewScoped
public class ControllerLogin implements Serializable {
    
    private List<ModelUsuario> usuarios;
    private ModelUsuario registroNovo;
    private List<Lista> listaTipoUsuario;
    
    @ManagedProperty("#{usuarioService}")
    private UsuarioService service;
     
    @PostConstruct
    public void init() {
        this.usuarios = this.service.getAllRegistros();
        this.listaTipoUsuario = DaoUsuario.getListaTipo();
    }

    public List<ModelUsuario> getUsuarios() {
        return usuarios;
    }

    public void atualizaConsulta() {
        this.usuarios = this.service.getAllRegistros();
    }
    
    public void setService(UsuarioService service) {
        this.service = service;
    }

    public List<Lista> getListaTipoUsuario() {
        return listaTipoUsuario;
    }

    public ModelUsuario getRegistroNovo() {
        if(this.registroNovo == null) {
            this.registroNovo = new ModelUsuario();
        }
        
        return registroNovo;
    }

    public void setRegistroNovo(ModelUsuario registroNovo) {
        this.registroNovo = registroNovo;
    }
    
    public void salvarNovoUsuario() {
        ModelUsuario oUsuario = this.getRegistroNovo();
        oUsuario.setSenha(ModelUsuario.criptografaSenha(oUsuario.getSenha()));
        DaoPessoa oDaoPessoa  = new DaoPessoa();
        oDaoPessoa.salvar(oUsuario.getPessoa());
        this.service.salvar(oUsuario);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/JeComerciaMt/faces/structure/login.xhtml");
        } catch (IOException ex) {}
    }
    
    public ArrayList<Lista> getListaTipoPessoa() {
        return DaoPessoa.getTipoPessoa();
    }
}
