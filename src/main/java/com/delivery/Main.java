package com.delivery;

import com.delivery.model.*;
import com.delivery.payment.*;
import com.delivery.notification.*;
import com.delivery.service.*;
import java.util.Scanner; // Importando o Scanner para ler a entrada do usuário

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Instanciando os produtos (LSP) e populando o pedido (SRP)
        Produto pizza = new Pizza("Pizza Calabresa", 45.0, "Calabresa com cebola");
        Produto refri = new Bebida("Coca-Cola 2L", 12.0);
        Produto burguer = new Hamburguer("X-Salada", 25.0);

        Pedido pedido = new Pedido("PED-001");
        pedido.adicionarProduto(pizza);
        pedido.adicionarProduto(refri);
        pedido.adicionarProduto(burguer);

        // 2. Exibindo as informações do pedido na tela
        PedidoPrinter printer = new PedidoPrinter();
        printer.exibir(pedido);

        // 3. Preparando os serviços base
        Notificador notificador = new WhatsAppNotificador();
        PedidoRepository repository = new PedidoRepository();
        PedidoService service = new PedidoService(notificador, repository);

        // 4. CHECKOUT INTERATIVO: O usuário escolhe a forma de pagamento
        System.out.println("\n==================================");
        System.out.println("   ESCOLHA A FORMA DE PAGAMENTO   ");
        System.out.println("==================================");
        System.out.println("[1] Cartão");
        System.out.println("[2] PIX");
        System.out.println("[3] Dinheiro");
        System.out.print("Digite o número da sua escolha: ");
        
        int opcao = scanner.nextInt();
        MetodoPagamento pagamento;

        // OCP na prática: instanciamos apenas a classe correspondente à escolha
        switch (opcao) {
            case 1:
                pagamento = new PagamentoCartao();
                break;
            case 2:
                pagamento = new PagamentoPix();
                break;
            case 3:
                pagamento = new PagamentoDinheiro();
                break;
            default:
                System.out.println("\n[Aviso] Opção inválida! Selecionando pagamento em Dinheiro por padrão.");
                pagamento = new PagamentoDinheiro();
                break;
        }

        // 5. Finalizando o pedido
        System.out.println("\n--- Processando Checkout ---");
        // DIP na prática: o serviço finaliza sem se importar com QUAL foi o pagamento escolhido
        service.finalizarPedido(pedido, pagamento);
        
        scanner.close();
    }
}