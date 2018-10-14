package Loader;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;
import java.io.InputStream;

public class Loader {

    static Loader loader = new Loader();

    private Loader() {
    }

    public static Loader getLoader() {
        return loader;
    }

    public void loader(Objeto obj) {

        
        int[] v = new int[3];
        int[] vt = new int[3];
        int[] vn = new int[4];

        Arquivos files = new Arquivos(obj.getAddress());
        String str = files.lerBytes(obj.getName(), ".obj");

        System.err.println("Carregando " + obj.getName());

        String[] aux = str.split("\n");
        String[] buff;
        String[] a;

        try {
            for (int i = 0; i < aux.length; i++) {

                buff = aux[i].split(" ");

                switch (buff[0]) {

                    case "v":

                        obj.addVertex(Float.parseFloat(buff[1]), Float.parseFloat(buff[2]), Float.parseFloat(buff[3]));

                        break;

                    case "vt":

                        obj.addTexture(Float.parseFloat(buff[1]), Float.parseFloat(buff[2]));

                        break;

                    case "vn":

                        obj.addNormalVector(Float.parseFloat(buff[1]), Float.parseFloat(buff[2]), Float.parseFloat(buff[3]));

                        break;

                    case "f":
                        try {

                            if (threeFaces(buff[1])) {

                                for (int k = 1; k < buff.length; k++) {

                                    a = buff[k].split("/");

                                    v[k - 1] = parseInt(a[0]);
                                    vt[k - 1] = parseInt(a[1]);
                                    vn[k - 1] = parseInt(a[1]);

                                }

                                obj.addFaceVertex(v);
                                obj.addFaceTexture(vt);
                                obj.addFaceNormalVector(vn);

                            } else { //Wireframe

                                v[0] = parseInt(buff[1]);
                                v[1] = parseInt(buff[2]);
                                v[2] = parseInt(buff[3]);

                                obj.addFaceVertex(v);

                            }

                        } catch (Exception e) {
                            System.out.println("Problemas ao add faces");
                            System.out.println(aux[i]);
                        }
                        break;

                }

            }

        } catch (Exception e) {
            System.err.println("Erro no Parser");
        }

        System.err.println(obj.getName() + " Carregado ");

    }

    public void loaderTexture(GL2 gl, Objeto obj) {

        InputStream stream;
        TextureData data;

        try {

            stream = getClass().getResourceAsStream( obj.getNameTexture());
            data = TextureIO.newTextureData(gl.getGLProfile(), stream, false, "tga");
            obj.textura = TextureIO.newTexture(data);

        } catch (Exception exc) {
            System.err.println("Erro ao Carregar Textura");
            exc.printStackTrace();
            System.exit(1);
        }

    }

    public boolean threeFaces(String buff) {

        try {

            for (int m = 0; m < buff.length(); m++) {
                if (buff.charAt(m) == '/') {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro em ThreeFaces");
            return false;
        }
        return true;
    }

    public int parseInt(String str) {
        try {
            int i = Integer.parseInt(str);
            return i;
        } catch (Exception e) {
            System.out.println("Erro em Parse Int");
            System.err.println(str);
        }
        return 0;
    }

}
