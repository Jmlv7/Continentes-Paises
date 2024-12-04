package trabalho.paiscontinente;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> vizinhos;

    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.vizinhos = new ArrayList<>();
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pais outro = (Pais) obj;
        return codigoISO.equals(outro.codigoISO);
    }

    public boolean isVizinho(Pais outro) {
        return vizinhos.contains(outro);
    }

    public double getDensidadePopulacional() {
        return populacao / dimensao;
    }

    public void adicionarVizinho(Pais pais) {
        if (!this.equals(pais) && !vizinhos.contains(pais) && vizinhos.size() < 40) {
            vizinhos.add(pais);
            pais.adicionarVizinho(this);
        }
    }

    public List<Pais> getVizinhosComuns(Pais outro) {
        List<Pais> comuns = new ArrayList<>();
        for (Pais vizinho : vizinhos) {
            if (outro.vizinhos.contains(vizinho)) {
                comuns.add(vizinho);
            }
        }
        return comuns;
    }
}
