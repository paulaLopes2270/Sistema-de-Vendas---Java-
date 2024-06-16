package SistemaDeVendas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GerarArquivoTexto {
    public static void gerarRelatorioCarrinho(CarrinhoDeCompras carrinho, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("item: Qtd: Nome: Preço: SubTotal:\n");
            int index = 1;
            List<Produto> itens = carrinho.getItens();
            for (Produto item : itens) {
                double subTotal = item.getPreco() * item.getQuantidade();
                writer.write(index + " " + item.getQuantidade() + " " + item.getNome() + " " + item.getPreco() + " " + subTotal + "\n");
                index++;
            }
            writer.write("Total: " + carrinho.calcularTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
