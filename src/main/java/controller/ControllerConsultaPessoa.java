package controller;

import dao.DaoPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.ModelPessoa;

@ManagedBean(name = "ControllerBeanConsultaPessoa")
public class ControllerConsultaPessoa extends BeanPadrao {

    private ModelPessoa registrosSelecionado;
    
    
    
    public ArrayList<ModelPessoa> getAllRegistros() {
        DaoPessoa oDaoPessoa          = new DaoPessoa();
        List pessoas                  = oDaoPessoa.getAll();
        ArrayList<ModelPessoa> oLista = new ArrayList<>();
        
        for(int i = 0; i < pessoas.size(); i ++) {
            oLista.add((ModelPessoa) pessoas.get(i));
        }
        
        return oLista;
    }

    public void setRegistrosSelecionados(ModelPessoa registrosSelecionado) {
        this.registrosSelecionado = registrosSelecionado;
    }

    public ModelPessoa getRegistrosSelecionado() {
        return registrosSelecionado;
    }
}
