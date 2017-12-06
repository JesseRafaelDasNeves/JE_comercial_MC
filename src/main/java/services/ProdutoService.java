package services;

import dao.DaoProduto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ModelProduto;

/**
 * @author jessé
 */
@ManagedBean(name = "produtoService")
@ApplicationScoped
public class ProdutoService {
    
    
    public List<ModelProduto> getAllRegistros() {
        DaoProduto oDaoProduto    = new DaoProduto();
        List produtos             = oDaoProduto.getAll();
        List<ModelProduto> oLista = new ArrayList<>();
        
        for(int i = 0; i < produtos.size(); i ++) {
            oLista.add((ModelProduto) produtos.get(i));
        }
        
        return oLista;
    }
    
    public boolean salvar(ModelProduto oProduto) {
        DaoProduto oDaoProduto = new DaoProduto();
        return oDaoProduto.salvar(oProduto);
    }
    
    public boolean exlcuir(ModelProduto oProduto) {
        DaoProduto oDaoProduto = new DaoProduto();
        return oDaoProduto.excluir(oProduto);
    }
}
