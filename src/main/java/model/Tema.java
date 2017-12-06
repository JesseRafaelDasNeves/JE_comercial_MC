package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jessé
 */
public class Tema {
    
    public static List<String> getAllDisponiveis() {
        List<String> lista = new ArrayList<>();
        lista.add(getTemaDefault());
        lista.add("bootstrap");
        lista.add("bluesky");
        
        return lista;
    }
    
    public static String getTemaDefault() {
        return "ui-darkness";
    }
}
