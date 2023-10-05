import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Simão Cirineu", 00, "Pantanal", "Picos", "PIauí", "000000-00", "Brasil");
        Cliente cliente1 = new Cliente("Maykon", "083.288.303-45", "08/07/2004", endereco1);

        Scanner scanner = new Scanner(System.in);

        // Adicionar n contas ao cliente
        System.out.println("Quantas contas deseja criar?");
        int n = scanner.nextInt();

        int i = 0;
        while (i < n) {
            System.out.println("Qual a agência da conta " + (i+1) + "?");
            String agencia = scanner.nextLine();
            System.out.println("Qual o número da conta " + (i+1) + "?");
            int numero = scanner.nextInt();
            System.out.println("Qual o saldo incial " + (i+1) + "?");
            double saldo = scanner.nextDouble();

            Conta conta = new Conta(agencia, numero, saldo, cliente1);
            cliente1.adicionarConta(conta);

            i++;
        }

        List<Conta> contas = cliente1.getContas();

        int aux = 0;

        while (aux == 0) {
            System.out.println("O que deseja fazer," + cliente1.getNome() + "?\n(1) Consultar extrato\n(2) Deposito\n(3) Saque\n(4) Tranferência\n(5) Sair");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    // Mostrar saldo das contas
                    System.out.println("O seu saldo é de:");

                    int a = 1;
                    for (Conta conta : contas) {
                        System.out.println("Conta " + a + ": " + conta.getSaldo());
                        a++;
                    }
                    break;

                case 2:
                    // Realizar depósito
                    System.out.println("Quanto deseja depositar?");
                    double deposito = scanner.nextDouble();
                    System.out.println("Em que conta deseja depositar?");

                    int b = 1;
                    for (Conta conta : contas) {
                        System.out.println("Conta" + b + ":" + conta.getSaldo());
                        b++;
                    }

                    int numeroContaDeposito = scanner.nextInt();
                    Conta contaDeposito = contas.get(numeroContaDeposito - 1);
                    contaDeposito.depositar(deposito);

                    break;

                case 3:
                    // Realizar saque
                    System.out.println("Quanto deseja sacar?");
                    double saque = scanner.nextDouble();
                    System.out.println("De que conta deseja sacar?");

                    int c = 1;
                    for (Conta conta : contas) {
                        System.out.println("Conta" + c + ":" + conta.getSaldo());
                        c++;
                    }

                    int numeroContaSaque = scanner.nextInt();
                    Conta contaSaque = contas.get(numeroContaSaque - 1);
                    contaSaque.sacar(saque);

                    break;

                case 4:
                    // Realizar tranferência
                    System.out.println("De que conta deseja realizar a tranferência?");
                    int d = 1;
                    for (Conta conta : contas) {
                        System.out.println("Conta" + d + ":" + conta.getSaldo());
                        d++;
                    }

                    int numeroContaOrigem = scanner.nextInt();
                    Conta contaOrigem = contas.get(numeroContaOrigem - 1);

                    System.out.println("Quanto deseja tranferir?");
                    double valorTranferencia = scanner.nextDouble();

                    System.out.println("Para que conta deseja tranferir?");
                    int e = 1;
                    for (Conta conta : contas) {
                        System.out.println("Conta" + e + ":" + conta.getSaldo());
                        e++;
                    }

                    int numeroContaDestino = scanner.nextInt();
                    Conta contaDestino = contas.get(numeroContaDestino - 1);

                    contaOrigem.transferir(contaDestino, valorTranferencia);

                    break;

                case 5:
                    aux = 1;
                    break;

            }

        }

        scanner.close();
        System.out.println("Fim do programa.");
    }

}