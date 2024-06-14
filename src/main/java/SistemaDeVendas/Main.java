package SistemaDeVendas;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();

        // Adicionando produtos ao carrinho 1
        Produto smartphone = new Eletronico("Smartphone", 2999.0, 24, 3);
        Produto tShirt = new Roupa("T-Shirt", 89.99, "M", "Preto", 6);
        Produto arroz = new Alimento("Arroz", 9.99, "12/12/2024", 4);

        carrinho1.adicionarItem(smartphone);
        carrinho1.adicionarItem(tShirt);
        carrinho1.adicionarItem(arroz);

        // Adicionando produtos ao carrinho 2
        Produto notebook = new Eletronico("Notebook", 4999.0, 12, 2);
        Produto jeans = new Roupa("Jeans", 149.99, "L", "Azul", 3);

        carrinho2.adicionarItem(notebook);
        carrinho2.adicionarItem(jeans);

        // Exibir itens do carrinho 1 antes da remoção do smartphone
        System.out.println("Carrinho 1 antes da remoção do smartphone:");
        listarItensCarrinho(carrinho1);

        // Remover um smartphone e exibir após a remoção
        carrinho1.removerItem(smartphone);
        System.out.println("Carrinho 1 após remover o smartphone:");
        listarItensCarrinho(carrinho1);

        // Exibir itens do carrinho 2 antes da remoção do notebook
        System.out.println("\nCarrinho 2 antes da remoção do notebook:");
        listarItensCarrinho(carrinho2);

        // Remover um notebook e exibir após a remoção
        carrinho2.removerItem(notebook);
        System.out.println("Carrinho 2 após remover o notebook:");
        listarItensCarrinho(carrinho2);

        // Limpar o carrinho 1 e mostrar após limpar
        carrinho1.limparCarrinho();
        System.out.println("\nCarrinho 1 após limpar tudo:");
        listarItensCarrinho(carrinho1);
    }

    // Função auxiliar para listar itens do carrinho
    public static void listarItensCarrinho(CarrinhoDeCompras carrinho) {
        if (carrinho.getItens().isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (Produto item : carrinho.getItens()) {
                System.out.printf("Nome: %s, Preço: %.2f, Quantidade: %d, Subtotal: %.2f\n",
                        item.getNome(), item.getPreco(), item.getQuantidade(), item.getPreco() * item.getQuantidade());
            }
            System.out.printf("Total do Carrinho: %.2f\n\n", carrinho.calcularTotal());
        }
    }
}
