package farmacia;

public class Suplemento implements Produto {
    private String nome;
    private double preco;

    public Suplemento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override public String aceitar(CalculadorFiscal visitor) { return visitor.calcularSuplemento(this); }
    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }
}
