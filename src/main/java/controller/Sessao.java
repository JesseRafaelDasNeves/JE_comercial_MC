package controller;

import dao.DaoModule;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.ModelUsuario;
import model.Tema;
import services.UsuarioService;

/**
 *
 * @author jessé
 */
@ManagedBean
@SessionScoped
public class Sessao {
    
    private HttpSession sessao;
    private static Sessao INSTANCE;
    private String tema;
    private List<String> temas;
    private ModelUsuario usuario;
    
    @ManagedProperty("#{usuarioService}")
    private UsuarioService serviceUsuario;
    
    public Sessao() {
        this.sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    @PostConstruct
    public void init() {
        this.temas = Tema.getAllDisponiveis();
    }
    
    public static Sessao getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Sessao();
        }
        return INSTANCE;
    }

    public String getTema() {
        if(this.tema == null) {
            this.tema = Tema.getTemaDefault();
        }
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<String> getTemas() {
        return temas;
    }
    
    public void setServiceUsuario(UsuarioService service) {
        this.serviceUsuario = service;
    }
    
    public ModelUsuario getUsuario() {
        if(this.usuario == null) {
            this.usuario = new ModelUsuario();
        }
        return usuario;
    }

    public void setUsuario(ModelUsuario usuario) {
        this.usuario = usuario;
    }
    
    public void atualizaModulo() {
        String modulo = ControllerPrincipal.getParametro("modulo");
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
    
    public String getAtributo2(String nome) {
        return (String) this.sessao.getAttribute(nome);
    }
    
    public void salvaTema() {
        ControllerPadrao.addMessageErro("Tema Alterado");
    }
    
    public void realizaAutenticacaoUsuario() {
        ModelUsuario oUsuario = this.getUsuario();
        oUsuario.setSenha(ModelUsuario.criptografaSenha(oUsuario.getSenha()));
        ModelUsuario oUsuarioAutent = this.serviceUsuario.getUsuarioAutenticado(oUsuario);
        
        if(oUsuarioAutent != null) {
            Sessao.getInstance().setUsuario(oUsuarioAutent);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/JeComerciaMt/faces/principal.xhtml");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            ControllerPadrao.addMessageErro("Login/Senha incorreto");
        }
    }
}
