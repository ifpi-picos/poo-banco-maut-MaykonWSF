import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Simão Cirineu", 00, "Pantanal", "Picos", "PIauí", "00000-000", "Brasil");
        Cliente cliente1 = new Cliente("Maykon", "083.288.303-45", "08/07/2004", endereco1);

        Scanner scanner = new Scanner(System.in);

        // Adicionar n contas ao cliente
        System.out.println("Quantas contas deseja criar?");
        int n = scanner.nextInt();
        
        int i = 0;
        while (i < n) {
            System.out.println("Qual a agência da conta " + (i+1) + "?");
            String agencia = scanner.next();            
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
            System.out.println("\nO que deseja fazer, " + cliente1.getNome() + "?\n(1) Consultar saldo\n(2) Deposito\n(3) Saque\n(4) Tranferência\n(5) Exibir extrato\n(6) sair" );
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    // Mostrar saldo das contas
                    System.out.println("\n *** O seu saldo é de: ***");

                    int a = 1;
                    for (Conta conta : contas) {
                        System.out.println("--> Conta " + a + ": R$" + conta.getSaldo());
                        a++;
                    }
                    break;

                case 2:
                    // Realizar depósito
                    System.out.println("\n*** Quanto deseja depositar? ***");
                    double deposito = scanner.nextDouble();
                    System.out.println("\n*** Em que conta deseja depositar? ***");

                    int b = 1;
                    for (Conta conta : contas) {
                        System.out.println("--> Conta" + b + ": R$" + conta.getSaldo());
                        b++;
                    }

                    int numeroContaDeposito = scanner.nextInt();
                    Conta contaDeposito = contas.get(numeroContaDeposito - 1);
                    contaDeposito.depositar(deposito);
                    System.out.println("O seu saldo atual é de R$" + contaDeposito.getSaldo());

                    break;

                case 3:
                    // Realizar saque
                    System.out.println("\n*** Quanto deseja sacar? ***");
                    double saque = scanner.nextDouble();
                    System.out.println("\n*** De que conta deseja sacar? ***");

                    int c = 1;
                    for (Conta conta : contas) {
                        System.out.println("--> Conta" + c + ": R$" + conta.getSaldo());
                        c++;
                    }

                    int numeroContaSaque = scanner.nextInt();
                    Conta contaSaque = contas.get(numeroContaSaque - 1);
                    contaSaque.sacar(saque);
                    System.out.println("O seu saldo atual é de R$" + contaSaque.getSaldo());

                    break;

                case 4:
                    // Realizar tranferência
                    System.out.println("\n*** De que conta deseja realizar a tranferência? ***");
                    int d = 1;
                    for (Conta conta : contas) {
                        System.out.println("--> Conta" + d + ": R$" + conta.getSaldo());
                        d++;
                    }

                    int numeroContaOrigem = scanner.nextInt();
                    Conta contaOrigem = contas.get(numeroContaOrigem - 1);

                    System.out.println("\n*** Quanto deseja tranferir? ***");
                    double valorTranferencia = scanner.nextDouble();

                    System.out.println("\n*** Para que conta deseja tranferir? ***");
                    int e = 1;
                    for (Conta conta : contas) {
                        System.out.println("--> Conta" + e + ": R$" + conta.getSaldo());
                        e++;
                    }

                    int numeroContaDestino = scanner.nextInt();
                    Conta contaDestino = contas.get(numeroContaDestino - 1);
                    contaOrigem.transferir(contaDestino, valorTranferencia);

                    break;

                case 5:
                    //Consultar extrato
                    System.out.println("\n*** De que conta deseja consultar o extrato? ***");
                    int f = 1;
                    for (Conta conta : contas){
                        System.out.println("--> Conta" + f + ": R$" + conta.getSaldo());
                        f++;
                    }

                    int numeroContaConsulta = scanner.nextInt();
                    Conta contaConsulta = contas.get(numeroContaConsulta - 1);
                    contaConsulta.exibeExtrato();

                    break;

                case 6:
                    //Fechar programa
                    aux = 1;
                    break;

            }

        }

        scanner.close();
        System.out.println("Fim do programa.");
    }

}