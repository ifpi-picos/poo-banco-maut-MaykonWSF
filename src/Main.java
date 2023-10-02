import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Maykon", "083.288.303-45", "08/07/2004", "Pantanal");
        Conta conta1 = new Conta("3630-7", 127469, 700, cliente1);
        Conta conta2 = new Conta("3630-8", 127460, 400, cliente1);
        Scanner scanner = new Scanner(System.in);
        int aux = 0;

        while (aux == 0){
            System.out.println("O que deseja fazer?\n(1) Consultar extrato\n(2) Deposito\n(3) Saque\n(4) Tranferência\n(5) Sair");
            int action = scanner.nextInt();

            switch (action){
                case 1:
                    System.out.println("Quanto deseja depositar?");

                case 2:

                case 3:

                case 4:

                case 5:

            }
            
            scanner.close();
        }
        
    }

}
