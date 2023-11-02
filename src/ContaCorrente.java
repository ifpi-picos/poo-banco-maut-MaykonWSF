import java.time.LocalDate;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciaSemTaxa = 2;

    public ContaCorrente(int agencia, int numero, double saldo, String tipoConta, Cliente cliente,
            Notificacao notificacao, double chequeEspecial, int transacaoSemTaxa) {
        // saldo + chequeEspecial -> não deve somar o cheque especial ao saldo, não duas coisas
        // diferentes.
        // cheque especial é um limite de emprestimo que vc pode pegar junto ao banco e ficar com
        // saldo negativo
        super(agencia, numero, saldo + chequeEspecial, tipoConta, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
        this.transferenciaSemTaxa = 2;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo + this.chequeEspecial) {
            this.saldo -= valor;
            System.out.println("Você sacou: R$" + valor + " da sua conta corrente.");

            Movimentacao movimentacao = new Movimentacao(LocalDate.now(), valor, "saque");
            historicoMovimentacao.add(movimentacao);

            System.out.println("Seu saldo atual é: R$" + this.saldo);

            System.out.println("\n");
            notificacao.enviarNotificacao("saque", valor);

        } else {
            System.out.println("Limite de saque insuficiente ou valor inválido");
        }
    }

    @Override
    public void transferencia(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo + chequeEspecial) {
            this.setSaldo(this.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("Você transferiu: R$" + valor
                    + " da sua conta corrente para a sua conta poupança.");

            if (transferenciaSemTaxa <= 0) {
                double taxa = valor * 0.1;
                this.setSaldo(this.getSaldo() - taxa);
            }

            Movimentacao movimentacao = new Movimentacao(LocalDate.now(), valor, "tranferência");
            historicoMovimentacao.add(movimentacao);

            transferenciaSemTaxa--;
            System.out.println("Seu saldo atual é: R$" + this.getSaldo());

            System.out.println("\n");
            notificacao.enviarNotificacao("transferencia", valor);
        } else {
            System.out.println("Limite insuficiente ou valor de tranferencia inválido");
        }
    }
}
