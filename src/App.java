import java.sql.Date;

public class App {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Avenida Pedro Marques de Medeiros", 10, "Pantanal", "Picos", "PI");
        Cliente cliente1 = new Cliente("12345678910", "João", new Date(2000, 1, 1));

        Conta contaCorrente = new ContaCorrente(123, 001, 100.00, "corrente", 50.00, 2);
        Conta contaPoupanca = new ContaPoupanca(321, 002, 200.00, "poupança", 0.1);

        contaCorrente.depositar(100);
        System.out.println("\n");
        contaPoupanca.depositar(50);
        System.out.println("\n");
        contaCorrente.sacar(50);
        System.out.println("\n");
        contaPoupanca.sacar(125);
        System.out.println("\n");
        contaCorrente.transferencia(contaPoupanca, 100);
        System.out.println("\n");
        contaPoupanca.transferencia(contaCorrente, 75);
    }
}
