package saborexpress.modelo;

import saborexpress.excecao.PrecoBaseInvalidoException;

public class Combo extends Prato {
    
    public Combo(String nome, double precoBase, int tempoPreparo)
        throws PrecoBaseInvalidoException{
            super(nome,precoBase,tempoPreparo)
    }

    @Override
    public double calcularPreco(){
        return getPrecoBase()-(getPrecoBase() * 0.15);
    }
}
