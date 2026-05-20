package farmacia;

public class ProdutoVisitor implements CalculadorFiscal {

    public String calcular(Produto produto) {
        return produto.aceitar(this);
    }

    @Override
    public String calcularMedicamento(Medicamento m) {
        double imposto = 0.0;
        double total = m.getPreco() + imposto;
        return String.format("Medicamento{nome='%s', preco=%.1f, imposto=isento, total=%.1f}",
            m.getNome(), m.getPreco(), total);
    }

    @Override
    public String calcularCosmetico(Cosmetico c) {
        double imposto = c.getPreco() * 0.25;
        double total = c.getPreco() + imposto;
        return String.format("Cosmetico{nome='%s', preco=%.1f, imposto=25%%, total=%.1f}",
            c.getNome(), c.getPreco(), total);
    }

    @Override
    public String calcularSuplemento(Suplemento s) {
        double imposto = s.getPreco() * 0.12;
        double total = s.getPreco() + imposto;
        return String.format("Suplemento{nome='%s', preco=%.1f, imposto=12%%, total=%.1f}",
            s.getNome(), s.getPreco(), total);
    }
}
