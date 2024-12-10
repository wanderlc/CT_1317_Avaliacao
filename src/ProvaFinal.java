import java.util.Scanner;
//fiz as questões como classes e usei enum e switch para chamar cada uma delas.
//problemas encontrados Enum, as opções comecam em 0, então resolvi colocando SAIR no inicio
//Formulas busquei com auxilio do GPT
//Optei por trabalhar com float na questão1 por dificuldade na conversão, feito 100% a mão.

public class ProvaFinal {

    public enum Questoes {
        SAIR, QUESTAO_1, QUESTAO_2, QUESTAO_3, QUESTAO_4;

        public static Questoes fromInt(int choice) {
            if (choice >= 0 && choice < values().length) {
                return values()[choice];
            }
            return null; // Retorna null se a escolha não for válida
        }
    }

    public static void questao1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o preço do combustivel: ");
        float precoGas = scanner.nextFloat();
        float distancia = 360;
        float consumo = 12;
        float litros = distancia / consumo;
        float valorCorrida = litros * precoGas;
        System.out.printf("Sua corrida custa R$ %.2f e serão consumidos %.4f litros\n", valorCorrida, litros);
    }

    public static void questao2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a quantidade de alunos para a média: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer recomendação do gpt

        String[] nomes = new String[n];
        double[] notas = new double[n];

        for (int i = 0; i < n; i++) { //Enquanto a quantidade de insersão for menor que os alunos informados
            System.out.print("Informe o nome do " + (i + 1) + "° aluno : ");
            nomes[i] = scanner.nextLine();

            System.out.print("Informe a nota do " + nomes[i] +": ");
            notas[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer recomendação do gpt
        }

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / n;

        System.out.println("\nA média é:(" + media + ") E os alunos acima dela são:");
        for (int i = 0; i < n; i++) {//verifica a nota do aluno se ela é acima da media e imprime, if sem else
            if (notas[i] > media) {
                System.out.println(nomes[i] + " - Nota: " + notas[i]);
            }
        }
    }

    public static void questao3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantas pessoas vão comer pizza?\n");
        int membros = scanner.nextInt();

        System.out.print("Quantas fatias é a pizza que você comprou?\n");
        int fatias = scanner.nextInt();

        int fatiasPorMembro = fatias / membros;
        int sobra = fatias % membros;//Mod para calcular o resto

        System.out.println("Cada um vai ganhar " + fatiasPorMembro + " fatias.");

        if (sobra > 0) {
            System.out.println("Vai sobrar " + sobra + " fatias");
            int adicionais = membros - sobra;
            System.out.println("Para dividir igualmente, você precisa de mais " + adicionais + " fatias.");
        } else {
            System.out.println("Eba! Todos comem a mesma quantidade!");
        }
    }

    public static void questao4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Consigo adivinhar se um numero é Primo, duvida?\nDigite um numero: ");
        int numero = scanner.nextInt();

        boolean ehPrimo = true;

        if (numero <= 1) {
            ehPrimo = false;
        } else {
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }
        }

        if (ehPrimo) {
            System.out.println("O número " + numero + " é primo.");
        } else {//Sim fiz uma piada porque sou velha guarda
            System.out.println("O número " + numero + " não é primo. \nSó se for seu primo(parente)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Questoes opcao;

        do {//Tentei fazer sem o "do" mas estava dando erro então me rendi ao codigo proposto.
            System.out.println("\nEscolha uma questão para executar:");
            System.out.println("0 - Sair");
            System.out.println("1 - Questão 1");
            System.out.println("2 - Questão 2");
            System.out.println("3 - Questão 3");
            System.out.println("4 - Questão 4");

            System.out.print("Opção: ");
            int escolha = scanner.nextInt();

            opcao = Questoes.fromInt(escolha);

            if (opcao != null) {
                switch (opcao) {
                    case QUESTAO_1:
                        questao1();
                        break;
                    case QUESTAO_2:
                        questao2();
                        break;
                    case QUESTAO_3:
                        questao3();
                        break;
                    case QUESTAO_4:
                        questao4();
                        break;
                    case SAIR:
                        System.out.println("Saindo do programa...");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != Questoes.SAIR);
    }
}
