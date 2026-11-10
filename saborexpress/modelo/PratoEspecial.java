package saborexpress.modelo;

import saborexpress.excecao.PrecoBaseInvalidoException;

public class PratoEspecial extends Prato {
    private double custoIngredientePremium;

    public PratoEspecial(String nomw, double precoBase, int tempoPreparo, double custoIngredientePremium)
            throws PrecoBaseInvalidoException {
        super(nome,precoBase,tempoPreparo);
        this.custoIngredientePremium = custoIngredientePremium;
    }

    @Override
    public double calcularPreco(){
        return getPrecoBase() + custoIngredientePremium;
    }

    public double getCustoIngredientePremium(){
        return custoIngredientePremium;
    }
}
