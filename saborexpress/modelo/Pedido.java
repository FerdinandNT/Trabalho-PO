package saborexpress.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private LocalDate data;
    private ArrayList<Prato> pratos;

    public Pedido(Cliente cliente, LocalDate data) {
        if (cliente == null) {
            throw new IllegalArgumentException("Um pedido precisa ter um cliente");
        }
        this.cliente = cliente;
        this.data = data;
        this.pratos = new ArrayList<Prato>();
    }

    publicvoid adicionarPrato(Prato prato){
        if (prato != null) {
            pratos.add(prato);
        }
    public double calcularTotal(){
        double total = 0;

        for(int i = 0; i < pratos.size(); i++){
            total = total +pratos.get(i).calcularPreco();
        }
        return total;
    }
    public Cliente getCliente(){
        return clientes;
    }
    public LocalDate getData(){
        return data;
    }
    public ArrayList<Prato> getPratos(){
        return pratos;
    }
}
