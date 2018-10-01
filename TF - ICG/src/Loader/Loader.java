package Loader;

import java.io.IOException;
import java.util.ArrayList;

public class Loader {

    private ArrayList<String> v;        //Vertex
    private ArrayList<String> vt;       //Texture vector
    private ArrayList<String> vn;       //Normal vector
    private ArrayList<String> f;        //edge

    public Loader(String address, String name) throws InterruptedException {
        v = new ArrayList<>();
        vt = new ArrayList<>();
        vn = new ArrayList<>();
        f = new ArrayList<>();

        loader(address, name);
    }

    private void loader(String address, String name) throws InterruptedException {

        Arquivos files = new Arquivos(address);
        String str = files.ler(name, ".obj") + " \t";

        boolean keep = false;
        String buffer = "";
        int con = 0;

        //Retira o cabecalho do arquivo
        for (int i = 0; !keep; i++) {
            if (str.charAt(i) == 'v' && str.charAt(i + 1) == ' ') {
                str = str.substring(i + 2);
                keep = true;
            }
        }

        String[] aux = str.split(" ", 4);
        int tam;

        try {

            do {

                buffer += aux[0] + " " + aux[1] + " " + aux[2];

                tam = aux[2].length();

                //Lista vertices
                if (aux[2].charAt(tam - 1) == 'v' || aux[2].charAt(tam - 1) == 's') {
                    buffer = buffer.substring(0, buffer.length() - 1);
                    v.add(buffer);

                    //Lista textura
                } else if (aux[2].charAt(tam - 2) == 'v' && aux[2].charAt(tam - 1) == 't') {
                    buffer = buffer.substring(0, buffer.length() - 2);
                    vt.add(buffer);

                    //Lista vetores normais
                } else if (aux[2].charAt(tam - 2) == 'v' && aux[2].charAt(tam - 1) == 'n') {
                    buffer = buffer.substring(0, buffer.length() - 2);
                    vn.add(buffer);

                    //Lista arestas
                } else {
                    if (aux[2].charAt(tam - 1) == 'f') 
                        buffer = buffer.substring(0, buffer.length() - 1);
                        f.add(buffer);
             
                }

                
                if("\t".equals(aux[3]))
                    break;
                aux = aux[3].split(" ", 4);

                if (aux[0].equals("offf")) {
                    String a = aux[1] + " " + aux[2] + " " + aux[3];           //Retorna a string
                    aux = a.split(" ", 4);
                }

                buffer = "";                                        //Zerar o buffer
                con++;

            } while (true);

        } catch (Exception e) {
            System.err.println("Problema no PARSER");
        }

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }

        System.out.println("Aresta");
        for (int i = 0; i < f.size(); i++) {
            System.out.println(f.get(i));
        }
    }

    public ArrayList<String> getV() {
        return v;
    }

    public ArrayList<String> getF() {
        return f;
    }

    public ArrayList<String> getVt() {
        return vt;
    }

    public ArrayList<String> getEn() {
        return vn;
    }

}
