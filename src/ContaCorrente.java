public class ContaCorrente extends Conta{
    private double chequeEspecial;
    private int transferenciaSemTaxa = 2;

    public ContaCorrente(int agencia, int numero, double saldo, String tipoConta, Cliente cliente, Notificacao notificacao, double chequeEspecial, int transacaoSemTaxa) {
        super(agencia, numero, saldo + chequeEspecial, tipoConta, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
        this.transferenciaSemTaxa = 2;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo + this.chequeEspecial) {
            this.saldo -= valor;
            System.out.println("Você sacou: R$" + valor + " da sua conta corrente.");
            System.out.println("Seu saldo atual é: R$" + this.saldo);

            System.out.println("\n");
            notificacao.enviarNotificacao("saque", valor);

        } else {
            System.out.println("Limite de saque insuficiente ou valor inválido");
        }
    }

    @Override
    public void transferencia(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo + chequeEspecial){
            this.setSaldo(this.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("Você transferiu: R$" + valor + " da sua conta corrente para a sua conta poupança.");
            transferenciaSemTaxa--;
            
            if (transferenciaSemTaxa <= 0){
                double taxa = valor * 0.1;
                this.setSaldo(this.getSaldo() - taxa);
            }

            System.out.println("Seu saldo atual é: R$" + this.getSaldo());

            System.out.println("\n");
            notificacao.enviarNotificacao("transferencia", valor);
        } else {
            System.out.println("Limite insuficiente ou valor de tranferencia inválido");
        }
    }
}