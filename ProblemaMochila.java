import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProblemaMochila {
    public static void main(String[] args) {
        // Dados fornecidos
        List<Caixa> caixas = new ArrayList<>();
        caixas.add(new Caixa("Caixa 1", 4, 12));
        caixas.add(new Caixa("Caixa 2", 2, 2));
        caixas.add(new Caixa("Caixa 3", 1, 1));
        caixas.add(new Caixa("Caixa 4", 4, 10));
        caixas.add(new Caixa("Caixa 5", 1, 2));


        double pesoMaximoMochila = 15;

        // Criar tabela de caixas
        System.out.println("Tabela de caixas:");
        System.out.println("Tipo | Valor | Peso | Valor por Quilo");
        for (Caixa caixa : caixas) {
            System.out.println(caixa.getTipo() + " | " + caixa.getValor() + " | " + caixa.getPeso() + " | " + caixa.getValorPorQuilo());
        }

        // Ordenar as caixas em ordem decrescente de valor pago por quilo
        Collections.sort(caixas, Comparator.comparing(Caixa::getValorPorQuilo).reversed());

        List<Caixa> caixasUtilizadas = new ArrayList<>();
        double pesoAtualMochila = 0;
        double valorTotalMochila = 0;

        // Preencher a mochila
        for (Caixa caixa : caixas) {
            if (pesoAtualMochila + caixa.getPeso() <= pesoMaximoMochila) {
                int quantidade = (int) Math.floor((pesoMaximoMochila - pesoAtualMochila) / caixa.getPeso());
                for (int i = 0; i < quantidade; i++) {
                    caixasUtilizadas.add(caixa);
                    pesoAtualMochila += caixa.getPeso();
                    valorTotalMochila += caixa.getValor();
                }
            }
        }

        // Imprimir quantidade de caixas de cada tipo utilizadas
        System.out.println("\nQuantidade de caixas utilizadas por tipo:");
        for (Caixa caixa : caixasUtilizadas) {
            System.out.println("Tipo: " + caixa.getTipo() + ", Quantidade: " + Collections.frequency(caixasUtilizadas, caixa));
        }
    }
}
