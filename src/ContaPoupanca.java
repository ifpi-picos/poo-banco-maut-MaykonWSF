public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(int agencia, int numero, double saldo, String tipoConta, Cliente cliente, Notificacao notificacao, double rendimento) {
        super(agencia, numero, saldo, tipoConta, cliente, notificacao);
        this.rendimento = 0.1;
    }

    public double setRendimento(double rendimento) {
        return this.rendimento = rendimento;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0){
            this.saldo += valor + (valor * rendimento);
            System.out.println("Você depositou: R$" + valor + " na sua conta poupança.");
            System.out.println("Seu saldo atual é: R$" + this.saldo);

            System.out.println("\n");
            notificacao.enviarNotificacao("depósito", valor);
        }else {
            System.out.println("Valor de depósito inválido");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            double taxa = valor * 0.05;
            this.saldo -= (valor + taxa);
            System.out.println("Você sacou: R$" + valor + " da sua conta poupança.");
            System.out.println("Seu saldo atual é: R$" + this.saldo);

            System.out.println("\n");
            notificacao.enviarNotificacao("saque", valor);

        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido");
        }
    }

    @Override
    public void transferencia(Conta contaDestino, double valor){
        if (valor > 0 && valor <= this.saldo) {
            double taxa = valor * 0.1;
            this.saldo -= (valor + taxa);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("Você transferiu: R$" + valor + " da sua conta poupança para a sua conta corrente.");
            System.out.println("Seu saldo atual é: R$" + this.saldo);
            System.out.println("\n");
            notificacao.enviarNotificacao("tranferencia", valor);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido");
        }
    }
}
