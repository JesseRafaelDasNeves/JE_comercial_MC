package controller;

/**
 * @author jessé
 */
public abstract class BeanPadrao {

    public BeanPadrao() {
        Sessao oSessao = Sessao.getInstance();
        oSessao.atualizaModulo();
    }
}
