package Loader;

public class Vetor {

    public float[] vertex3f;       //armazena vertice e vetor normal

    public int[] faceVertex;
    public int[] faceTexture;
    public int[] faceVecNorm;

    public Vetor() {
        vertex3f = new float[3];

        faceVertex = new int[3];
        faceTexture = new int[3];
        faceVecNorm = new int[3];
        
        
        //Inicialize
        
        vertex3f[0] = 0;
        vertex3f[1] = 0;
        vertex3f[2] = 0;
        
        faceVertex[0] = 0;
        faceVertex[1] = 0;
        faceVertex[2] = 0;
        
        faceTexture[0] = 0;
        faceTexture[1] = 0;
        faceTexture[2] = 0;
        
        faceVecNorm[0] = 0;
        faceVecNorm[1] = 0;
        faceVecNorm[2] = 0;

    }
    
    

}
