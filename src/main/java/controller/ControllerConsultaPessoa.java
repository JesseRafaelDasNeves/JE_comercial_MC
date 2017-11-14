package controller;

import dao.DaoPessoa;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import model.ModelPessoa;

@ManagedBean(name = "ControllerBeanConsultaPessoa")
public class ControllerConsultaPessoa {

    public ArrayList<ModelPessoa> getAllRegistros() {
        
        DaoPessoa oDaoPessoa = new DaoPessoa();
        oDaoPessoa.getAll();
        
        ArrayList<ModelPessoa> oLista = new ArrayList<>();
        
        for(int i = 1; i <= 30; i ++) {
            ModelPessoa oPessoa = new ModelPessoa();
            oPessoa.setCodigo(i);
            oPessoa.setCpfCnpj("064.205.879.21");
            oPessoa.setNome("Joaquim " + i);

            oLista.add(oPessoa);
        }
        
        return oLista;
    }
}
