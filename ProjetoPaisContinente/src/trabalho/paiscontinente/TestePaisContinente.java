package trabalho.paiscontinente;

public class TestePaisContinente {
    public static void main(String[] args) {

        System.out.println("Criando países...");
        Pais brasil = new Pais("BRA", "Brasil", 8515767.049);
        brasil.setPopulacao(214000000);
        System.out.println("Brasil criado: " + brasil.getNome() + ", Código: " + brasil.getCodigoISO());

        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        argentina.setPopulacao(46000000);
        System.out.println("Argentina criada: " + argentina.getNome() + ", Código: " + argentina.getCodigoISO());

        Pais uruguai = new Pais("URY", "Uruguai", 176215);
        uruguai.setPopulacao(3500000);
        System.out.println("Uruguai criado: " + uruguai.getNome() + ", Código: " + uruguai.getCodigoISO());

        System.out.println("\nAdicionando vizinhos...");
        brasil.adicionarVizinho(argentina);
        brasil.adicionarVizinho(uruguai);
        argentina.adicionarVizinho(uruguai);
        System.out.println("Vizinhos adicionados com sucesso!");

        System.out.println("\nVizinhos comuns entre Brasil e Argentina: ");
        brasil.getVizinhosComuns(argentina).forEach(v -> System.out.println(v.getNome()));

        System.out.println("\nDensidade populacional do Brasil: " + brasil.getDensidadePopulacional());
        System.out.println("Densidade populacional da Argentina: " + argentina.getDensidadePopulacional());
        System.out.println("Densidade populacional do Uruguai: " + uruguai.getDensidadePopulacional());

        System.out.println("\nCriando continente...");
        Continente americaDoSul = new Continente("América do Sul");
        americaDoSul.adicionarPais(brasil);
        americaDoSul.adicionarPais(argentina);
        americaDoSul.adicionarPais(uruguai);
        System.out.println("Continente criado: " + americaDoSul);

        System.out.println("\nInformações do continente América do Sul:");
        System.out.println("Dimensão total do continente: " + americaDoSul.getDimensaoTotal());
        System.out.println("População total do continente: " + americaDoSul.getPopulacaoTotal());
        System.out.println("Densidade populacional do continente: " + americaDoSul.getDensidadePopulacional());
        System.out.println("País com maior população: " + americaDoSul.getPaisMaiorPopulacao().getNome());
        System.out.println("País com menor população: " + americaDoSul.getPaisMenorPopulacao().getNome());
        System.out.println("País de maior dimensão territorial: " + americaDoSul.getPaisMaiorDimensao().getNome());
        System.out.println("País de menor dimensão territorial: " + americaDoSul.getPaisMenorDimensao().getNome());
        System.out.println("Razão territorial maior/menor: " + americaDoSul.getRazaoTerritorial());
    }
}
