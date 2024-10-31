import java.util.ArrayList;
import java.util.Scanner;

public class Contas {
    private static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Calcular novo saldo de poupança");
            System.out.println("5. Mostrar dados da conta");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 0) break;

            switch (opcao) {
                case 1 -> criarConta(scanner);
                case 2 -> sacar(scanner);
                case 3 -> depositar(scanner);
                case 4 -> calcularNovoSaldo(scanner);
                case 5 -> mostrarDados(scanner);
                default -> System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void criarConta(Scanner scanner) {
        System.out.println("Escolha o tipo de conta (1 - Poupança, 2 - Especial): ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Nome do cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        if (tipoConta == 1) {
            System.out.print("Dia de rendimento: ");
            int diaRendimento = scanner.nextInt();
            contas.add(new ContaPoupanca(cliente, numeroConta, saldoInicial, diaRendimento));
            System.out.println("Conta Poupança criada com sucesso!");
        } else if (tipoConta == 2) {
            System.out.print("Limite: ");
            double limite = scanner.nextDouble();
            contas.add(new ContaEspecial(cliente, numeroConta, saldoInicial, limite));
            System.out.println("Conta Especial criada com sucesso!");
        } else {
            System.out.println("Tipo de conta inválido!");
        }
    }

    private static void sacar(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta != null) {
            System.out.print("Valor para saque: ");
            double valor = scanner.nextDouble();
            conta.sacar(valor);
        }
    }

    private static void depositar(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta != null) {
            System.out.print("Valor para depósito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        }
    }

    private static void calcularNovoSaldo(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta instanceof ContaPoupanca) {
            System.out.print("Taxa de rendimento (%): ");
            double taxaRendimento = scanner.nextDouble();
            ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
            System.out.println("Novo saldo calculado com sucesso.");
        } else {
            System.out.println("Conta não é do tipo Poupança.");
        }
    }

    private static void mostrarDados(Scanner scanner) {
        ContaBancaria conta = buscarConta(scanner);
        if (conta != null) {
            conta.mostrarDados();
        }
    }

    private static ContaBancaria buscarConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }
}
