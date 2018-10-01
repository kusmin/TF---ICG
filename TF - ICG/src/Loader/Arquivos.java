package Loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Arquivos {

    String diretorio;

    public Arquivos(String diretorio) {

        this.diretorio = diretorio;

        criarDiretorio(diretorio);

    }

    //Local onde os arquivos serao armazenados
    public final void criarDiretorio(String diretorio) {

        try {

            File dir = new File(diretorio);
            dir.mkdir();

        } catch (Exception e) {
            System.err.println("Erro ao criar diretorio");
        }

    }

    public final void criarArquivo(String nomeArquivo) {

        try {

            File arquivo = new File(diretorio + nomeArquivo + ".txt");
            arquivo.createNewFile();

        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo");
        }

    }

    public final void gravar(String nomeArquivo, String conteudo, String extensao) throws FileNotFoundException, IOException {

        try ( PrintWriter pw = new PrintWriter(localizar(nomeArquivo, extensao)) ) {
            pw.println(conteudo);
            pw.flush();
        }

    }
    
    public FileWriter localizar(String nomeArquivo, String extensao) {

        try {

            FileWriter localizar = new FileWriter(diretorio + nomeArquivo + extensao, true);
            //localizar.close();
            return localizar;

        } catch (IOException e) {
            System.err.println("Erro ao localizar arquivo");
        }

        return null;
    }

    public final String ler(String nomeArquivo, String extensao) {

        try {

            String ler = "";
            BufferedReader arquivo = new BufferedReader(new FileReader(diretorio + nomeArquivo + extensao));

            while (arquivo.ready()) {
                ler += arquivo.readLine();
            }

            return ler;

        } catch (Exception e) {
            System.err.println("Erro ao criar diretorio");
        }
        return "";
    }

    public void excluir() {

        try {

        } catch (Exception e) {
            System.err.println("Erro ao excluir");
        }

    }

    public void inicializarVeriaveis() {
    }

}