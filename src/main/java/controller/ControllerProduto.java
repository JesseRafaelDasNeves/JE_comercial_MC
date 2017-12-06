package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.ModelProduto;
import services.ProdutoService;

@ManagedBean(name = "BeanProduto")
@ViewScoped
public class ControllerProduto extends ControllerPadrao implements Serializable {
    
    private List<ModelProduto> produtos;
    private ModelProduto registroSelecionado;
    private ModelProduto registroNovo;
    
    @ManagedProperty("#{produtoService}")
    private ProdutoService service;
     
    @PostConstruct
    public void init() {
        this.produtos = this.service.getAllRegistros();
    }

    public List<ModelProduto> getProdutos() {
        return produtos;
    }

    public void atualizaConsulta() {
        this.produtos = this.service.getAllRegistros();
    }
    
    public void setService(ProdutoService service) {
        this.service = service;
    }

    public ModelProduto getRegistroSelecionado() {
        if(this.registroSelecionado == null) {
            this.registroSelecionado = new ModelProduto();
        }
        
        return registroSelecionado;
    }

    public void setRegistroSelecionado(ModelProduto registroSelecionado) {
        this.registroSelecionado = registroSelecionado;
    }

    public ModelProduto getRegistroNovo() {
        if(this.registroNovo == null) {
            this.registroNovo = new ModelProduto();
        }
        
        return registroNovo;
    }

    public void setRegistroNovo(ModelProduto registroNovo) {
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
        ModelProduto oPessoa = this.getRegistroNovo();
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
        this.setRegistroNovo(new ModelProduto());
    }
}
