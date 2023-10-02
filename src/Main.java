import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Maykon", "083.288.303-45", "08/07/2004", "Pantanal");

        Scanner scanner = new Scanner(System.in);
        
        //Adicionar n contas ao cliente
        System.out.println("Quantas contas deseja criar?");
        int n = scanner.nextInt();

        int i = 0;
        while (i < n){
            System.out.println("Qual a agência?");
            String agencia = scanner.nextLine();
            System.out.println("Qual o número da conta?");
            int numero = scanner.nextInt();
            System.out.println("Qual o saldo incial?");
            double saldo = scanner.nextDouble();

            Conta conta = new Conta(agencia, numero, saldo, cliente1);
            cliente1.adicionarConta(conta);

            i++;
        }

        List<Conta> contas = cliente1.getContas();
        
        int aux = 0;

        while (aux == 0){
            System.out.println("O que deseja fazer," + cliente1.getNome() + "?\n(1) Consultar extrato\n(2) Deposito\n(3) Saque\n(4) Tranferência\n(5) Sair");
            int action = scanner.nextInt();

            switch (action){
                case 1:
                    System.out.println("O seu saldo é de:");
                    for (Conta conta : contas){
                        int a = 1;
                        System.out.println("Conta" + a + ":" + conta.getSaldo());
                        a ++;
                    }

                case 2:
                    System.out.println("Quanto deseja depositar?");
                    double deposito = scanner.nextDouble();
                    System.out.println("Em que conta deseja depositar?");

                    for (Conta conta : contas);{
                        int a = 1;
                        System.out.println("Conta" + a + ":" + conta.getSaldo());
                        a ++;
                    }

                    int numeroConta = scanner.nextInt();
                    Conta contaDeposito = contas.get(numeroConta - 1);
                    contaDeposito.depositar(deposito);
                    System.out.println("Você realizou um deposito de " + deposito);

                case 3:

                case 4:

                case 5:

            }
            
            scanner.close();
        }
        
    }

}