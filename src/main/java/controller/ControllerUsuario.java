package controller;

import dao.DaoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Lista;
import model.ModelUsuario;
import services.UsuarioService;

@ManagedBean(name = "BeanUsuario")
@ViewScoped
public class ControllerUsuario extends ControllerPadrao implements Serializable {
    
    private List<ModelUsuario> usuarios;
    private ModelUsuario registroSelecionado;
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
    
    public ModelUsuario getRegistroSelecionado() {
        if(this.registroSelecionado == null) {
            this.registroSelecionado = new ModelUsuario();
        }
        
        return registroSelecionado;
    }

    public void setRegistroSelecionado(ModelUsuario registroSelecionado) {
        this.registroSelecionado = registroSelecionado;
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
    
    public void salvar() {
        if(this.service.salvar(this.getRegistroSelecionado())) {
            this.mensagemAlteracaoOk();
        } else {
            this.mensagemAlteracaoErro();
        }
    }
    
    public void salvarNovo() {
        ModelUsuario oPessoa = this.getRegistroNovo();
        this.setSenhaDefault(oPessoa);
        if(this.service.salvar(oPessoa)) {
            this.atualizaConsulta();
            this.limpaFormularioInclusao();
            this.mensagemInclusaoOk();
        } else {
            this.mensagemInclusaoErro();
        }
    }
    
    public void excluir() {
        if(this.service.exlcuir(this.getRegistroSelecionado())) {
            this.atualizaConsulta();
            this.mensagemExclusaoOk();
        } else {
            this.mensagemExclusaoErro();
        }
    }
    
    private void limpaFormularioInclusao() {
        this.setRegistroNovo(new ModelUsuario());
    }
    
    private void setSenhaDefault(ModelUsuario oUsuario) {
        String senhaDefault = "123";
        oUsuario.setSenha(ModelUsuario.criptografaSenha(senhaDefault));
        this.addMessage("Cadastro inicial do Usuário com senha padrão '123'.");
    }
}
