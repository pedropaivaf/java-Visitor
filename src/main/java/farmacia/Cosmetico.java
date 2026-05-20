package farmacia;

public class Cosmetico implements Produto {
    private String nome;
    private double preco;

    public Cosmetico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override public String aceitar(CalculadorFiscal visitor) { return visitor.calcularCosmetico(this); }
    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }
}
