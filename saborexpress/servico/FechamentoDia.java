package saborexpress.servico;

import java.util.ArrayList;
import saborexpress.destino.Destino;
import saborexpress.modelo.Pedido;
import saborexpress.modelo.Prato;

public class FechamentoDia {
    private GerenciadorPedidos gerenciador;
    private Destino destino;

    public FechamentoDia(GerenciadorPedidos gerenciador, Destino destino) {
        this.gerenciador = gerenciador;
        this.destino = destino;
    }

    public void gerarRelatorio() {
        ArrayList<Pedido> pedidos = gerenciador.getPedidos();
        String relatorio = "";
        double faturamentoTotal = 0;
        Pedido pedidoMaisCaro = null;
        double maiorValor = -1;

        relatorio = relatorio + "SABOREXPRESS";
        relatorio = relatorio + "RELATORIO DE FECHAMENTO DO DIA";

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            double totalPedido = pedido.calcularTotal();

            relatorio = relatorio + "Cliente: " + pedido.getCliente().getNome();
            relatorio = relatorio + "Endereco: " + pedido.getCliente().getEndereco();
            relatorio = relatorio + "Telefone: " + pedido.getCliente().getTelefone();
            relatorio = relatorio + "Data: " + pedido.getData();
            relatorio = relatorio + "Pratos:";

            for (int j = 0; j < pedido.getPratos().size(); j++) {
                Prato prato = pedido.getPratos().get(j);
                relatorio = relatorio + "- " + prato.getNome()
                        + " | R$ " + String.format("%.2f", prato.calcularPreco())
                        + " | Preparo: " + prato.getTempoPreparo() + " minutos";
            }

            relatorio = relatorio + "Total do pedido: R$ "
                    + String.format("%.2f", totalPedido);

            faturamentoTotal = faturamentoTotal + totalPedido;

            if (totalPedido > maiorValor) {
                maiorValor = totalPedido;
                pedidoMaisCaro = pedido;
            }
        }

        relatorio = relatorio + "\nFATURAMENTO TOTAL: R$ "
                + String.format("%.2f", faturamentoTotal);

        if (pedidoMaisCaro != null) {
            relatorio = relatorio + "PEDIDO MAIS CARO: "
                    + pedidoMaisCaro.getCliente().getNome()
                    + " - R$ " + String.format("%.2f", maiorValor);
        } else {
            relatorio = relatorio + "Nenhum pedido registrado";
        }

        destino.enviar(relatorio);
    }
}
