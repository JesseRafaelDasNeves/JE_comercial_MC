package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ModelPessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-07T12:58:26")
@StaticMetamodel(ModelUsuario.class)
public class ModelUsuario_ { 

    public static volatile SingularAttribute<ModelUsuario, String> senha;
    public static volatile SingularAttribute<ModelUsuario, Integer> tipo;
    public static volatile SingularAttribute<ModelUsuario, String> login;
    public static volatile SingularAttribute<ModelUsuario, ModelPessoa> Pessoa;

}