package SistemaDeVendas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Produto> it = itens.iterator();
        while (it.hasNext()) {
            Produto item = it.next();
            if (item.equals(produto)) {
                int novaQuantidade = item.getQuantidade() - 1;
                double subTotalAntes = item.getPreco() * item.getQuantidade();
                System.out.println("Removendo " + item.getNome() + ": " +
                        "Quantidade restante antes da remoção: " + item.getQuantidade() + ", " +
                        "Subtotal: " + subTotalAntes);

                if (novaQuantidade > 0) {
                    item.setQuantidade(novaQuantidade);
                    System.out.println("Nova quantidade após remoção: " + novaQuantidade);
                } else {
                    it.remove();
                    System.out.println("Produto removido completamente: " + item.getNome());
                }
                break; // Sair após ajustar a primeira ocorrência
            }
        }
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public void listarItens() {
        for (Produto item : itens) {
            System.out.println(item.exibirDetalhes());
        }
    }

    public List<Produto> getItens() {
        return itens;
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
