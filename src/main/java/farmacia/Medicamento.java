package farmacia;

public class Medicamento implements Produto {
    private String nome;
    private double preco;

    public Medicamento(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override public String aceitar(CalculadorFiscal visitor) { return visitor.calcularMedicamento(this); }
    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }
}
