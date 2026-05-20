package farmacia;

public interface Produto {
    String aceitar(CalculadorFiscal visitor);
    String getNome();
    double getPreco();
}
