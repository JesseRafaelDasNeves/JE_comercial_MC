package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ModelPessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T12:58:26")
@StaticMetamodel(ModelFornecedor.class)
public class ModelFornecedor_ { 

    public static volatile SingularAttribute<ModelFornecedor, Integer> codigo;
    public static volatile SingularAttribute<ModelFornecedor, String> inscricaoEstadual;
    public static volatile SingularAttribute<ModelFornecedor, ModelPessoa> Pessoa;

}