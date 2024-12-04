package trabalho.paiscontinente;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }

    public double getDimensaoTotal() {
        return paises.stream().mapToDouble(Pais::getDimensao).sum();
    }

    public long getPopulacaoTotal() {
        return paises.stream().mapToLong(Pais::getPopulacao).sum();
    }

    public double getDensidadePopulacional() {
        return getPopulacaoTotal() / getDimensaoTotal();
    }

    public Pais getPaisMaiorPopulacao() {
        return paises.stream().max((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    public Pais getPaisMenorPopulacao() {
        return paises.stream().min((p1, p2) -> Long.compare(p1.getPopulacao(), p2.getPopulacao())).orElse(null);
    }

    public Pais getPaisMaiorDimensao() {
        return paises.stream().max((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }

    public Pais getPaisMenorDimensao() {
        return paises.stream().min((p1, p2) -> Double.compare(p1.getDimensao(), p2.getDimensao())).orElse(null);
    }


    public double getRazaoTerritorial() {
        Pais maior = getPaisMaiorDimensao();
        Pais menor = getPaisMenorDimensao();
        if (maior != null && menor != null && menor.getDimensao() > 0) {
            return maior.getDimensao() / menor.getDimensao();
        }
        return 0;
    }
}
