package controller;

import dao.DaoPessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Lista;
import model.ModelPessoa;
import services.PessoaService;

@ManagedBean(name = "BeanPessoa")
@ViewScoped
public class ControllerPessoa extends ControllerPadrao implements Serializable {
    
    private List<ModelPessoa> pessoas;
    private ModelPessoa registroSelecionado;
    private ModelPessoa registroNovo;
    
    @ManagedProperty("#{pessoaService}")
    private PessoaService service;
     
    @PostConstruct
    public void init() {
        this.pessoas = this.service.getAllRegistros();
    }

    public List<ModelPessoa> getPessoas() {
        return pessoas;
    }

    public void atualizaConsulta() {
        this.pessoas = this.service.getAllRegistros();
    }
    
    public void setService(PessoaService service) {
        this.service = service;
    }

    public ModelPessoa getRegistroSelecionado() {
        if(this.registroSelecionado == null) {
            this.registroSelecionado = new ModelPessoa();
        }
        
        return registroSelecionado;
    }

    public void setRegistroSelecionado(ModelPessoa registroSelecionado) {
        this.registroSelecionado = registroSelecionado;
    }

    public ModelPessoa getRegistroNovo() {
        if(this.registroNovo == null) {
            this.registroNovo = new ModelPessoa();
        }
        
        return registroNovo;
    }

    public void setRegistroNovo(ModelPessoa registroNovo) {
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
        ModelPessoa oPessoa = this.getRegistroNovo();
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
        this.setRegistroNovo(new ModelPessoa());
    }
    
    public ArrayList<Lista> getListaTipoPessoa() {
        return DaoPessoa.getTipoPessoa();
    }
}
