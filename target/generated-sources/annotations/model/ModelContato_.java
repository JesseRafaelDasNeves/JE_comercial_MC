package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ModelPessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-06T01:09:29")
@StaticMetamodel(ModelContato.class)
public class ModelContato_ { 

    public static volatile SingularAttribute<ModelContato, String> numeroTelefone;
    public static volatile SingularAttribute<ModelContato, String> email;
    public static volatile SingularAttribute<ModelContato, ModelPessoa> Pessoa;

}