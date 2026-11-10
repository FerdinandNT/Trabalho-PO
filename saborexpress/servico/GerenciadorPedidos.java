package saborexpress.servico;

import java.util.ArrayList;
import saborexpress.modelo.Pedido;

public class GerenciadorPedidos {
    private ArrayList<Pedido> pedidos;

    public GerenciadorPedidos() {
        pedidos = new ArrayList<Pedido>();
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
