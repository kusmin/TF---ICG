package Loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivos {

    String diretorio;

    public Arquivos(String diretorio) {

        this.diretorio = diretorio;

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

        try (PrintWriter pw = new PrintWriter(localizar(nomeArquivo, extensao))) {
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

        String ler = "";

        try (BufferedReader arquivo = new BufferedReader(new FileReader(diretorio + nomeArquivo + extensao))) {

            String aux;
            while (arquivo.ready()) {
                aux = arquivo.readLine();
                ler += aux + "\n";
                //System.out.println(ler);
            }

            arquivo.close();

        } catch (Exception e) {
            System.err.println("Erro ao criar diretorio");
        }
        return ler;
    }

    public final String lerBytes(String nomeArquivo, String extensao) {

        try {

            Path caminho = Paths.get(diretorio + nomeArquivo + extensao);
            
            byte[] text = Files.readAllBytes(caminho);
            
            String str = new String(text);
     
            text.clone();
     
            return str;
            
        } catch (FileNotFoundException fnfex) {
        } catch (IOException ioex) {
        }
        return null;

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
