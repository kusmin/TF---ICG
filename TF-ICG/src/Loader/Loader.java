package Loader;

public class Loader {

    //Melhorar classe indicando apenas o que o usuario deseja que seja carregado
    public Loader() {
    }

    public void loader(Objeto obj) throws InterruptedException {

        Arquivos files = new Arquivos(obj.getAddress());
        String str = files.lerBytes(obj.getName(), ".obj");

        System.err.println("Carregando " + obj.getName());
        try {
            String[] aux = str.split("\n");
            String[] a, buff;
            String line;
            boolean keep;

            for (int i = 0; i < aux.length; i++) {

                //System.out.println(aux[i]);
                if (aux[i].length() > 5) {

                    buff = aux[i].split(" ");

                    line = buff[0];

                    switch (line) {
                        case "v":
                            try {
                                //System.out.println("Add V");
                                obj.addVertex(
                                        Float.parseFloat(buff[1]),
                                        Float.parseFloat(buff[2]),
                                        Float.parseFloat(buff[3]));

                            } catch (Exception e) {
                                //wwwwwwwwSystem.err.println("Falha em V");
                                //break;
                            }

                            break;

                        case "vt":

                            try {
                                //System.out.println("Add VT");
                                obj.addTexture(
                                        Float.parseFloat(buff[1]),
                                        Float.parseFloat(buff[2]));
                            } catch (Exception e) {
                                //System.err.println("Falha em VT");
                                //break;
                            }

                            break;

                        case "vn":

                            try {
                                
                            } catch (Exception e) {
                                //System.err.println("Falha em VN");
                                //break;
                            }

                        case "f":
                            try {

                                keep = true;
                                for (int m = 0; m < buff[1].length(); m++) {
                                    if (buff[1].charAt(m) == '/') {
                                        keep = false;
                                        break;
                                    }
                                }

                                if (keep) { // se as faces = v

                                    int[] v = new int[3];
                                    v[0] = Integer.parseInt(buff[1]);
                                    v[1] = Integer.parseInt(buff[2]);
                                    v[2] = Integer.parseInt(buff[3]);

                                    obj.addFaceVertex(v);

                                } else { // se as faces = v/vt/vn

                                    int[] v = new int[3];
                                    int[] vt = new int[3];
                                    int[] vn = new int[3];

                                    for (int k = 1; k < buff.length; k++) {

                                        a = buff[k].split("/");

                                        v[k - 1] = Integer.parseInt(a[0]);
                                        vt[k - 1] = Integer.parseInt(a[0]);
                                        vn[k - 1] = Integer.parseInt(a[0]);

                                    }
                                    obj.addFaceVertex(v);
                                    obj.addFaceTexture(vt);
                                    obj.addFaceNormalVector(vn);
                                }
                            } catch (Exception e) {
                               //System.err.println("Falha em FACES");
                               // break;
                            }

                            break;
                    }

                }
            }
        } catch (Exception e) {
            System.err.println("Erro no PARSER");
        }

        System.err.println(obj.getName() + " Carregado ");

    }

}
