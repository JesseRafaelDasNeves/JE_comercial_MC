package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.ModelFornecedor;
import services.FornecedorService;

@ManagedBean(name = "BeanFornecedor")
@ViewScoped
public class ControllerFornecedor extends ControllerPadrao implements Serializable {
    
    private List<ModelFornecedor> fornecedores;
    private ModelFornecedor registroSelecionado;
    private ModelFornecedor registroNovo;
    
    @ManagedProperty("#{fornecedorService}")
    private FornecedorService service;
     
    @PostConstruct
    public void init() {
        this.fornecedores = this.service.getAllRegistros();
    }

    public List<ModelFornecedor> getFornecedores() {
        return fornecedores;
    }

    public void atualizaConsulta() {
        this.fornecedores = this.service.getAllRegistros();
    }
    
    public void setService(FornecedorService service) {
        this.service = service;
    }

    public ModelFornecedor getRegistroSelecionado() {
        if(this.registroSelecionado == null) {
            this.registroSelecionado = new ModelFornecedor();
        }
        
        return registroSelecionado;
    }

    public void setRegistroSelecionado(ModelFornecedor registroSelecionado) {
        this.registroSelecionado = registroSelecionado;
    }

    public ModelFornecedor getRegistroNovo() {
        if(this.registroNovo == null) {
            this.registroNovo = new ModelFornecedor();
        }
        
        return registroNovo;
    }

    public void setRegistroNovo(ModelFornecedor registroNovo) {
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
        ModelFornecedor oPessoa = this.getRegistroNovo();
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
        this.setRegistroNovo(new ModelFornecedor());
    }
}
