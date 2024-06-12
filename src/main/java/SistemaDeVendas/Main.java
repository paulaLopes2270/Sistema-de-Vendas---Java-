package SistemaDeVendas;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        carrinho1.adicionarItem(new Eletronico("Smartphone", 2999.0, 24, 3));
        carrinho1.adicionarItem(new Roupa("T-Shirt", 89.99, "M", "Preto", 6));
        carrinho1.adicionarItem(new Alimento("Arroz", 9.99, "12/12/2024", 4));

        CarrinhoDeCompras carrinho2 = new CarrinhoDeCompras();
        carrinho2.adicionarItem(new Eletronico("Notebook", 4999.0, 12, 2));
        carrinho2.adicionarItem(new Roupa("Jeans", 149.99, "L", "Azul", 3));

        System.out.println("Carrinho 1:");
        carrinho1.listarItens();
        System.out.println("Total: " + carrinho1.calcularTotal());
        carrinho1.gerarArquivoTexto("carrinho1.txt");

        System.out.println("\nCarrinho 2:");
        carrinho2.listarItens();
        System.out.println("Total: " + carrinho2.calcularTotal());
        carrinho2.gerarArquivoTexto("carrinho2.txt");
    }
}
