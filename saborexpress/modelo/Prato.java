package saborexpress.modelo;

import saborexpress.excecao.PrecoBaseInvalidoException;

public abstractclass Prato {
    private String nome;
    private double precoBase;
    private int tempoPreparo;

    public Prato(String nome, double precoBase, int tempoPreparo)
            throws PrecoBaseInvalidoException{
        if(precoBase < 0){
            throw new PrecoBaseInvalidoException("O preço base não pode ser negativo");
        }

        this.nome = nome;
        this.precoBase = precoBase;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome(){
        return nome;
    }
    public double getPrecoBase(){
        return precoBase;
    }
    public inte getTempoPreparo(){
        returen tempoPreparo;
    }

    public abstract double calcularPreco();
}
