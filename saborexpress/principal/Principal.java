package saborexpress.principal;

import java.time.LocalDate;

import saborexpress.destino.Destino;
import saborexpress.destino.DestinoConsole;
import saborexpress.destino.DestinoArquivo;
import saborexpress.excecao.PrecoBaseInvalidoException;
import saborexpress.modelo.Cliente;
import saborexpress.modelo.Pedido;
import saborexpress.modelo.PratoExecutivo;
import saborexpress.modelo.Combo;
import saborexpress.modelo.PratoEspecial;
import saborexpress.servico.FechamentoDia;
import saborexpress.servico.GerenciadorPedidos;

public class Principal {
    public static void main(String[] args) {
        try{
            Cliente cliente1 = new Cliente("Ferdinand", "Rua Muniz Ferraz, 19", "(55) 99999-1111");
            Cliente cliente2 = new Cliente("Maria", "Rua das Flores, 123", "(55) 98888-2222");

            GerenciadorPedidos gerenciador = new GerenciadorPedidos();

            Pedido pedido1 = new Pedido(cliente1, LocalDate.now());
            pedido1.adicionarPrato(new PratoExecutivo("Frango frito", 24.00, 25));
            pedido1.adicionarPrato(new Combo("Combo X-burguer", 35.00, 20));
            pedido1.adicionarPrato(new PratoEspecial("Massa com camarao", 42.00, 30, 12.00));

            Pedido pedido2 = new Pedido(cliente2, LocalDate.now());
            pedido2.adicionarPrato(new PratoExecutivo("Bife acebolado", 32.00, 25));
            pedido2.adicionarPrato(new Combo("Combo Vegetariano", 30.00, 18));

            gerenciador.adicionarPedido(pedido1);
            gerenciador.adicionarPedido(pedido2);

            try {
                PratoExecutivo pratoInvalido = new PratoExecutivo("Prato invalido", -10.00, 15);
                pedido2.adicionarPedido(pratoInvalido);
            }catch (PrecoBaseInvalidoException e) {
                System.out.println("Erro" + e.getMessage());
            }

            Destino destino = new DestinoConsole();
            FechamentoDia fechamento = new FechamentoDia(gerenciador,destino);
            fechamento.gerarRelatorio();

        }catch (PrecoBaseInvalidoException e) {
            System.out.println("Erro" + e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Erro" + e.getMessage());
        }
    }
}