package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.ModelContato;
import services.ContatoService;

@ManagedBean(name = "BeanContato")
@ViewScoped
public class ControllerContato extends ControllerPadrao implements Serializable {
    
    private List<ModelContato> contatos;
    private ModelContato registroSelecionado;
    private ModelContato registroNovo;
    
    @ManagedProperty("#{contatoService}")
    private ContatoService service;
     
    @PostConstruct
    public void init() {
        this.contatos = this.service.getAllRegistros();
    }

    public List<ModelContato> getContatos() {
        return contatos;
    }

    public void atualizaConsulta() {
        this.contatos = this.service.getAllRegistros();
    }
    
    public void setService(ContatoService service) {
        this.service = service;
    }

    public ModelContato getRegistroSelecionado() {
        if(this.registroSelecionado == null) {
            this.registroSelecionado = new ModelContato();
        }
        
        return registroSelecionado;
    }

    public void setRegistroSelecionado(ModelContato registroSelecionado) {
        this.registroSelecionado = registroSelecionado;
    }

    public ModelContato getRegistroNovo() {
        if(this.registroNovo == null) {
            this.registroNovo = new ModelContato();
        }
        
        return registroNovo;
    }

    public void setRegistroNovo(ModelContato registroNovo) {
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
        ModelContato oPessoa = this.getRegistroNovo();
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
        this.setRegistroNovo(new ModelContato());
    }
}
