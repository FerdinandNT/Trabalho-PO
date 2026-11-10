package saborexpress.destino;

import java.io.FileWriter;
import java.io.IOException;

public class DestinoArquivo implements Destino {
    private String = nomeArquivo;

    public DestinoArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void enviar(String conteudo) {
        try{
            FileWriter fw = new FileWriter(nomeArquivo):
            fw.write(conteudo)
            fw.close();
            system.out.println("Arquivo" + nomeArquivo + "salvo com sucesso");
        } catch (IOException e) {
            System.out.println("Falha ao salvar: " + e.getMessage());
        }
}

