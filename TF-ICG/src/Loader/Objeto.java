package Loader;

import com.jogamp.opengl.util.texture.Texture;
import java.util.ArrayList;

public class Objeto {

    public String getNameTexture() {
        return nameTexture;
    }

    public void setNameTexture(String nameTexture) {
        this.nameTexture = nameTexture;
    }

    public String getAddressTexture() {
        return addressTexture;
    }

    public void setAddressTexture(String addressTexture) {
        this.addressTexture = addressTexture;
    }

    public String getExtTexture() {
        return extTexture;
    }


    public void setExtTexture(String extTexture) {
        String ext[] = getNameTexture().split(".");
        this.extTexture = ext[ext.length - 1];
    }

    protected String nameObject;
    protected String addressObject;
    
    private String nameTexture;       //Nome Textura
    private String addressTexture;    //Endereco Textura
    private String extTexture;        //Extensao Textura
    
    protected ArrayList<float[]> vertex;              //vertices
    protected ArrayList<float[]> texture;             //textura
    protected ArrayList<float[]> normal_vector;       //vetores_normais
    protected ArrayList<int[]> faceVertex;            //faces dos vertices
    protected ArrayList<int[]> faceTexture;           //faces dos vertices
    protected ArrayList<int[]> faceNormalVector;      //faces dos vertices
    
    protected Texture textura;

    public Objeto(String address, String name) {

        this.addressObject = address;
        this.nameObject = name;

        vertex = new ArrayList<>(3);                //vertices (tam 4 = coord homogenia)
        texture = new ArrayList<>(2);               //textura
        normal_vector = new ArrayList<>(3);         //vetores_normais

        faceVertex = new ArrayList<>(3);            //arestas
        faceTexture = new ArrayList<>(3);
        faceNormalVector = new ArrayList<>(3);
    }
    
    
    
    public String getName() {
        return this.nameObject;
    }

    public String getAddress() {
        return this.addressObject;
    }

    public void addVertex(float v1, float v2, float v3) {
        this.vertex.add(new float[]{v1, v2, v3});
    }
    
    public void addTexture(float t1, float t2) {
        this.texture.add(new float[]{t1, t2});
    }

    public void addNormalVector(float v1, float v2, float v3) {
        this.normal_vector.add(new float[]{v1, v2, v3});
    }

    public void addFaceVertex(int[] fv) {
        this.faceVertex.add(new int[]{fv[0], fv[1], fv[2]});
    }

    public void addFaceTexture(int[] ft) {
        this.faceTexture.add(new int[]{ft[0], ft[1], ft[2]});
    }

    public void addFaceNormalVector(int[] fv) {
        this.faceNormalVector.add(new int[]{fv[0], fv[1], fv[2]});
    }

    public float[] getVertex(int pos) {
        return vertex.get(pos);
    }

    public float[] getTexture(int pos) {
        return texture.get(pos);
    }

    public float[] getNormalVector(int pos) {
        return normal_vector.get(pos);
    }

    public int[] getFaceVertex(int pos) {
        return faceVertex.get(pos);
    }

    public int[] getFaceTexture(int pos) {
        return faceTexture.get(pos);
    }

    public int[] getFaceNormalVector(int pos) {
        return faceNormalVector.get(pos);
    }
    
    public Texture getTexture(){
        return textura;
    }

    public int sizeFaces() {
        return faceVertex.size();
    }

    public int sizeVertex() {
        return vertex.size();
    }
   
}
