# Sistema de Delivery - Atividade SOLID

Este repositório contém a implementação de um sistema de gerenciamento de pedidos para um delivery. O código foi desenvolvido como atividade prática para demonstrar a aplicação dos 5 princípios do SOLID em uma arquitetura orientada a objetos usando Java.

## Aluno
- Matheus Roberto da Silva

## Princípios Aplicados

Abaixo explico brevemente como estruturamos o código para respeitar cada princípio:

**1. SRP (Single Responsibility Principle)**
As responsabilidades do pedido foram divididas. A classe `Pedido` guarda apenas os dados do pedido. A persistência foi isolada na classe `PedidoRepository`, e a exibição das informações na tela ficou com a `PedidoPrinter`. Nenhuma classe assumiu mais de um papel.

**2. OCP (Open/Closed Principle)**
Para as formas de pagamento, criei a interface `MetodoPagamento`. As classes `PagamentoCartao`, `PagamentoPix` e `PagamentoDinheiro` implementam essa interface. Dessa forma, se o sistema precisar aceitar um novo tipo de pagamento no futuro, basta criar uma nova classe, sem precisar alterar a lógica já existente no serviço de pedidos.

**3. LSP (Liskov Substitution Principle)**
Temos uma classe abstrata `Produto` e suas subclasses `Pizza`, `Hamburguer` e `Bebida`. Na classe principal, o pedido recebe qualquer uma dessas subclasses no lugar da classe mãe sem gerar comportamentos inesperados. O método de obter preço funciona de forma consistente para todas elas.

**4. ISP (Interface Segregation Principle)**
Em vez de criar uma interface única e inchada com todos os métodos do sistema, criei interfaces menores e focadas (como `EnviadorNotificacao`, `GerenciadorPedido` e `GerenciadorEntrega`). Assim, temos certeza de que as classes não sejam obrigadas a implementar métodos que não vão utilizar.

**5. DIP (Dependency Inversion Principle)**
A classe `PedidoService` foi construída para não depender de implementações diretas (como a classe `WhatsAppNotificador`), mas sim da abstração `Notificador`. Isso permite que o meio de notificação seja injetado e alterado facilmente sem quebrar ou modificar a lógica principal do serviço.

## Como executar o projeto
1. Clonar o repositório.
2. Abra o projeto em sua IDE de preferência.
3. Execute a classe `Main.java` localizada no pacote `com.delivery`.
