package Loader;

import Loader.Vetor;
import java.util.ArrayList;

public class Obj {

    public String name;
    public String address;
    
    public ArrayList<Vetor> vertex;            //vertices
    public ArrayList<Vetor> edge;              //arestas
    public ArrayList<Vetor> texture;           //textura
    public ArrayList<Vetor> normal_vector;     //vetores_normais

    public Obj() {
        vertex = new ArrayList<>();            //vertices
        edge = new ArrayList<>();              //arestas
        texture = new ArrayList<>();           //textura
        normal_vector = new ArrayList<>();     //vetores_normais
    }
    
    public Obj(String address, String name){
        this();
        this.address = address;
        this.name = name;
    }

    //transformacoes
}
