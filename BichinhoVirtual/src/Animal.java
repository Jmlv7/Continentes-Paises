import java.util.Scanner;

public class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int forca;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void comer() {
        if (vivo && caloria < 100) {
            caloria = Math.min(caloria + 10, 100);
            forca = Math.max(forca - 2, 0);
            System.out.println("O animal comeu! Força: " + forca + ", Caloria: " + caloria);
        } else {
            System.out.println("O animal está cheio ou morto e não pode comer.");
        }
    }

    public void correr() {
        if (vivo && caloria > 0 && forca > 0) {
            forca = Math.max(forca - 5, 0);
            caloria = Math.max(caloria - 5, 0);
            System.out.println("O animal está correndo! Força: " + forca + ", Caloria: " + caloria);
        } else {
            System.out.println("O animal está cansado ou morto e não pode correr.");
        }
    }

    public void dormir() {
        if (vivo) {
            forca = Math.min(forca + 10, 100);
            caloria = Math.max(caloria - 2, 0);
            System.out.println("O animal está dormindo! Força: " + forca + ", Caloria: " + caloria);
        } else {
            System.out.println("O animal está morto e não pode dormir.");
        }
    }

    public void morrer() {
        vivo = false;
        forca = 0;
        System.out.println("O animal morreu! GAME OVER!");
    }

    public boolean isVivo() {
        return vivo;
    }

    public void exibirStatus() {
        System.out.println("Nome: " + nome + ", Classe: " + classe + ", Família: " + familia);
        System.out.println("Idade: " + idade + ", Vivo: " + vivo);
        System.out.println("Força: " + forca + ", Caloria: " + caloria);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        System.out.println("Crie seu novo animal:");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        System.out.println("Seu animal foi criado!");
        animal.exibirStatus();
        
        while (animal.isVivo()) {
            System.out.println("\nO que o " + animal.nome + " vai fazer agora?");
            System.out.println("1- Comer");
            System.out.println("2- Correr");
            System.out.println("3- Dormir");
            System.out.println("4- Morrer");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> animal.comer();
                case 2 -> animal.correr();
                case 3 -> animal.dormir();
                case 4 -> animal.morrer();
                default -> System.out.println("Opção inválida.");
            }

            if (animal.isVivo()) {
                animal.exibirStatus();
            }
        }

        scanner.close();
    }
}
