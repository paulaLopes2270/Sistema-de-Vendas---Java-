package SistemaDeVendas;

public class Eletronico extends ProdutoBase {
    private int garantiaMeses;

    public Eletronico(String nome, double preco, int garantiaMeses, int quantidade) {
        super(nome, preco, quantidade);
        this.garantiaMeses = garantiaMeses;
    }

    public Eletronico() {}

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String exibirDetalhes() {
        return "Eletrônico [Nome=" + getNome() + ", Preço=" + getPreco() + ", Quantidade=" + getQuantidade() +
                ", Garantia=" + garantiaMeses + " meses]";
    }

    @Override
    public String getTipo() {
        return "Eletrônico";
    }
}
