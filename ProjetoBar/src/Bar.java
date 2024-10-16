import java.util.Scanner;

public class Bar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do cliente
        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().toUpperCase().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int qtdCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int qtdRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int qtdEspetinhos = scanner.nextInt();

        // Definição dos preços
        double precoIngresso = (sexo == 'M') ? 10.00 : 8.00;
        double precoCerveja = 5.00;
        double precoRefrigerante = 3.00;
        double precoEspetinho = 7.00;
        double couvertArtistico = 4.00;

        // Cálculo do consumo
        double consumo = (qtdCervejas * precoCerveja) 
                        + (qtdRefrigerantes * precoRefrigerante) 
                        + (qtdEspetinhos * precoEspetinho);

        // Verificação se é isento de couvert
        if (consumo > 30.00) {
            couvertArtistico = 0.00;
        }

        // Cálculo do valor total
        double valorTotal = consumo + couvertArtistico + precoIngresso;

        // Exibição do relatório
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f%n", consumo);
        if (couvertArtistico == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvertArtistico);
        }
        System.out.printf("Ingresso = R$ %.2f%n", precoIngresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);

        scanner.close();
    }
}
