package Lotofacil;

import java.io.IOException;  //IOException são base para exceções geradas ao acessar informações.
import java.util.Random;    // Random são geradores de números aleatórios.
import java.util.Scanner;   // Sanner é para simplificar a leitura de diversas formas de entrada do usuário.

public class Lotofacil {
    public static void main(String[ ] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("\n " + "--Lotofacil--");
        int opcao;

        do {
            System.out.println("******************");
            System.out.println("Menu Lotofacil:");
            System.out.println("1) Aposta de 0 a 100");
            System.out.println("2) Aposta de A à Z");
            System.out.println("3) Aposta em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("*************************");
            System.out.println("Escolha uma opcao: ");
            opcao = scanner.nextInt();



            switch (opcao){      // switch ele controla o fluxo que permite executar.
                case 1:          // Os cases controla o fluxo e permite executar diferentes blocos de código com base em diferentes valores de entrada.
                    apostadorDe0a100(scanner, random);
                    break;      // Break ele interromper a execução de um dos laços de iteração.
                case 2:
                    apostadordeAaZ(scanner);
                break;
                case 3:
                    apostadorParouImpar(scanner, random);
                break;
                case 0:
                    System.out.println("Saindo da Aposta");
                break;
                default:
                    System.out.println("Aposta Invalida. Por favor, escolha um opção válida");
            }
        }
        while (opcao != 0);  //While controla a repetição com uma condição de terminação e declaração.

        scanner.close();
    }

    public static void apostadorDe0a100(Scanner scanner, Random random) {
        System.out.println("Aposta de 0 a 100...");
        System.out.print("Digite um número de 0 a 100: ");
        int aposta = scanner.nextInt();

        if (aposta < 0 || aposta > 100){
            System.out.println("Aposta inválida.");
            return;
        }

        int numeroSorteado = random.nextInt(101);
        System.out.println("Numero sorteado: " + numeroSorteado);

        if (aposta == numeroSorteado){
            System.out.println("Você ganhou R$1.000,00 reais");
        } else {
           System.out.println("Que pena! O número sorteado foi :  " + numeroSorteado);
        }
    }

    public static void apostadordeAaZ(Scanner scanner) throws IOException {
        System.out.println("Aposta de A a Z...");
        System.out.print("Digite uma letra de A à Z: ");
        char opcao = (char) System.in.read();             //
        char aposta = Character.toUpperCase(scanner.next().charAt(0));

        if (!Character.isLetter(aposta) || aposta < 'A' || aposta> 'Z'){
            System.out.println("Aposta inválida.");
            return;
        }

        char letraPremiada = 'J';
        System.out.println("Letra premiada: " + letraPremiada);

        if (aposta == letraPremiada) {
            System.out.println("Você ganhou R$500,00 reais");
        }else {
            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
        }

    }

    public static void apostadorParouImpar(Scanner scanner, Random random) {
        System.out.println("Aposta em par ou ímpar");
        System.out.print("Digite um número inteiro");
        int aposta = scanner.nextInt();

        if (aposta % 2 == 0) {
            System.out.println("Você ganhou R$100,00 reais.");
        }else {
            System.out.println("Que pena! O número digitado é impar e a premiação foi números pares.");
        }
    }

}
