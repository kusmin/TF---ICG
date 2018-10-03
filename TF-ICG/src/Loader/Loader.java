package Loader;

public class Loader {

    //Melhorar classe indicando apenas o que o usuario deseja que seja carregado
    
    Vetor vetor;

    public Loader(){}

    public void loader(Obj obj) throws InterruptedException {

        
        Arquivos files = new Arquivos(obj.address);
        String str = files.ler(obj.name, ".obj");
        
        System.err.println("Carregando " + obj.name);
        
        String[] aux = str.split("\n");
        String[] a, buff;
        String line;
        boolean keep;

        try {

            for (int i = 0; i < aux.length; i++) {

                line = "";
                vetor = new Vetor();

                if (aux[i].length() > 5) {

                    buff = aux[i].split(" ");
                    line = buff[0];

                    if (line.equals("v") || line.equals("vt") || line.equals("vn") || line.equals("f")) {

                        if (!line.equals("f")) {

                            for (int k = 1; k < buff.length; k++) {
                                vetor.vertex3f[k - 1] = Float.parseFloat(buff[k]);
                            }

                        } else {

                            keep = false;
                            for(int m = 0; m < buff[1].length(); m++){
                                if(buff[1].charAt(m) == '/'){
                                    keep = true;
                                    break;
                                }
                            }
                            if (!keep) {
                                
                                for (int k = 1; k < buff.length; k++){
                                    vetor.faceVertex[k - 1] = Integer.parseInt(buff[k]);
                                }
                            } else {
                                for (int k = 1; k < buff.length; k++) {

                                    a = buff[k].split("/");
                                    vetor = new Vetor();
                                    vetor.faceVertex[k - 1] = Integer.parseInt(a[0]);
                                    vetor.faceTexture[k - 1] = Integer.parseInt(a[1]);
                                    vetor.faceVecNorm[k - 1] = Integer.parseInt(a[2]);

                                }
                            }
                        }
                    }
                }

                switch (line) {
                    case "v":
                        
                        obj.vertex.add(vetor);
                        break;
                    case "vt":
                        obj.texture.add(vetor);
                        break;
                    case "vn":
                        obj.normal_vector.add(vetor);
                        break;
                    case "f":
                        obj.edge.add(vetor);
                        break;
                }

            }

        } catch (Exception e) {
            System.err.println("Erro no PARSER");
        }

        System.err.println(obj.name + "Carregado ");
        
    }

}
