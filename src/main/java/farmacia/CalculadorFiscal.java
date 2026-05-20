package farmacia;

public interface CalculadorFiscal {
    String calcularMedicamento(Medicamento m);
    String calcularCosmetico(Cosmetico c);
    String calcularSuplemento(Suplemento s);
}
