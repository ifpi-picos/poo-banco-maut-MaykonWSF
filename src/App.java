import java.sql.Date;

public class App {
    public static void main(String[] args) {
        Endereco endereco1 =
                new Endereco("Avenida Pedro Marques de Medeiros", 10, "Pantanal", "Picos", "PI");
        Cliente cliente1 = new Cliente("12345678910", "João", new Date(2000, 1, 1));

        Conta cc = new ContaCorrente(123, 001, 0.00, "corrente", cliente1, new NotificacaoEmail(),
                50.00, 2);
        Conta cc2 = new ContaCorrente(123, 001, 0.00, "corrente", cliente1, new NotificacaoEmail(),
                50.00, 2);
        Conta cp =
                new ContaPoupanca(321, 002, 0.00, "poupança", cliente1, new NotificacaoSMS(), 0.1);
        System.out.println(cc.getSaldo()); // o valor do cheque especial está sendo exibido como
                                           // saldo, não deveria
        cc.depositar(50);
        System.out.println(cc.getSaldo());
        cc.sacar(100);
        // nesse exemplo era pra ficar com saldo -50, mas como o cheque especial foi somando ao
        // saldo no inicio ficou o saldo 0
        System.out.println(cc.getSaldo());
        // cc.transferencia(cc2, 10);
        // cc.transferencia(cc2, 10);
        // cc.transferencia(cc2, 10);
        // cc.transferencia(cc2, 10);
        // cc.transferencia(cc2, 10);
        // cc.transferencia(cc2, 50);
        // System.out.println(cc2.getSaldo());
        // System.out.println(cc.getSaldo());
        // cc.exibeExtrato();

        // cp.depositar(100);
        // System.out.println(cp.getSaldo());
        // cp.sacar(10);
        // System.out.println(cp.getSaldo());
        // cp.exibeExtrato();

        // só encontrei o problema com a manipulação do cheque especial, mas estruturalmente está
        // tudo certo.
    }
}
