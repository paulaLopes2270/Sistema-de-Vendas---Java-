package SistemaDeVendas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public void listarItens() {
        for (Produto item : itens) {
            System.out.println(item.exibirDetalhes());
        }
    }

    public List<Produto> exportarListaProdutos() {
        return new ArrayList<>(itens);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void gerarArquivoTexto(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("item: Qtd: Nome: Preço: SubTotal:\n");
            int index = 1;
            for (Produto item : itens) {
                double subTotal = item.getPreco() * item.getQuantidade();
                writer.write(index + " " + item.getQuantidade() + " " + item.getNome() + " " + item.getPreco() + " " + subTotal + "\n");
                index++;
            }
            writer.write("Total: " + calcularTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
