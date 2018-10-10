package Loader;

import java.util.ArrayList;

public class Objeto {

    protected String name;
    protected String address;

    private ArrayList<float[]> vertex;              //vertices
    private ArrayList<float[]> texture;             //textura
    private ArrayList<float[]> normal_vector;       //vetores_normais
    private ArrayList<int[]> faceVertex;            //faces dos vertices
    private ArrayList<int[]> faceTexture;           //faces dos vertices
    private ArrayList<int[]> faceNormalVector;      //faces dos vertices

    public Objeto() {}

    public Objeto(String address, String name) {

        this.address = address;
        this.name = name;

        vertex = new ArrayList<>(3);                //vertices
        texture = new ArrayList<>(2);               //textura
        normal_vector = new ArrayList<>(3);         //vetores_normais

        faceVertex = new ArrayList<>(3);            //arestas
        faceTexture = new ArrayList<>(3);
        faceNormalVector = new ArrayList<>(3);
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
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

    public int sizeFaces() {
        return faceVertex.size();
    }

   
}
