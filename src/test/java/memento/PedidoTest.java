package memento;

import org.example.Pedido;
import org.example.PedidoEstadoCriado;
import org.example.PedidoEstadoEntregue;
import org.example.PedidoEstadoPago;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class PedidoTest {

    @Test
    void deveArmazenarEstados() {
        Pedido pedido = new Pedido();
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertEquals(2, pedido.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Pedido pedido = new Pedido();
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        pedido.restauraEstado(0);
        assertEquals(PedidoEstadoCriado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Pedido pedido = new Pedido();
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoPago.getInstance());
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        pedido.restauraEstado(2);
        assertEquals(PedidoEstadoCriado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Pedido pedido = new Pedido();
            pedido.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

}
