package farmacia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    ProdutoVisitor calculador;

    @BeforeEach
    public void setUp() {
        calculador = new ProdutoVisitor();
    }

    // Medicamento: isento de imposto

    @Test
    public void deveCalcularImpostoMedicamento() {
        Medicamento m = new Medicamento("Dipirona", 15.0);
        System.out.println("[VISITOR] calcular(Medicamento) | preco: R$15.0");
        String resultado = calculador.calcular(m);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("isento"));
        assertTrue(resultado.contains("15.0"));
    }

    @Test
    public void deveRetornarTotalIgualAoPrecoMedicamento() {
        Medicamento m = new Medicamento("Amoxicilina", 30.0);
        System.out.println("[VISITOR] total Medicamento sem imposto | preco: R$30.0");
        String resultado = calculador.calcular(m);
        System.out.println("  -> " + resultado);
        // total == preco (isento)
        assertTrue(resultado.contains("total=30.0"));
    }

    // Cosmetico: 25% de imposto

    @Test
    public void deveCalcularImpostoCosmetico25() {
        Cosmetico c = new Cosmetico("Shampoo", 40.0);
        System.out.println("[VISITOR] calcular(Cosmetico) | preco: R$40.0 | imposto: 25%");
        String resultado = calculador.calcular(c);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("25%"));
        // 40 + 10 = 50
        assertTrue(resultado.contains("total=50.0"));
    }

    @Test
    public void deveRetornarTotalCorretoParaCosmetico() {
        Cosmetico c = new Cosmetico("Perfume", 200.0);
        System.out.println("[VISITOR] total Cosmetico | preco: R$200.0 | esperado total: R$250.0");
        String resultado = calculador.calcular(c);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("total=250.0"));
    }

    // Suplemento: 12% de imposto

    @Test
    public void deveCalcularImpostoSuplemento12() {
        Suplemento s = new Suplemento("Whey Protein", 100.0);
        System.out.println("[VISITOR] calcular(Suplemento) | preco: R$100.0 | imposto: 12%");
        String resultado = calculador.calcular(s);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("12%"));
        // 100 + 12 = 112
        assertTrue(resultado.contains("total=112.0"));
    }

    @Test
    public void deveRetornarTotalCorretoParaSuplemento() {
        Suplemento s = new Suplemento("Creatina", 50.0);
        System.out.println("[VISITOR] total Suplemento | preco: R$50.0 | esperado total: R$56.0");
        String resultado = calculador.calcular(s);
        System.out.println("  -> " + resultado);
        assertTrue(resultado.contains("total=56.0"));
    }

    // Polimorfismo: mesmo calculador, produtos diferentes

    @Test
    public void deveAplicarImpostoDiferentePorTipo() {
        Produto med = new Medicamento("Ibuprofeno", 20.0);
        Produto cos = new Cosmetico("Creme Hidratante", 20.0);
        Produto sup = new Suplemento("Vitamina C", 20.0);
        System.out.println("[VISITOR] mesmo preco R$20.0 em 3 tipos distintos");
        String rMed = calculador.calcular(med);
        String rCos = calculador.calcular(cos);
        String rSup = calculador.calcular(sup);
        System.out.println("  -> Medicamento: " + rMed);
        System.out.println("  -> Cosmetico:   " + rCos);
        System.out.println("  -> Suplemento:  " + rSup);
        assertTrue(rMed.contains("total=20.0"));
        assertTrue(rCos.contains("total=25.0"));
        assertTrue(rSup.contains("total=22.4"));
    }
}
