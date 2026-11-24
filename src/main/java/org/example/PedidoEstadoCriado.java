package org.example;

public class PedidoEstadoCriado implements PedidoEstado {

    private PedidoEstadoCriado() {};
    private static PedidoEstadoCriado instance = new PedidoEstadoCriado();
    public static PedidoEstadoCriado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Criado";
    }

}
