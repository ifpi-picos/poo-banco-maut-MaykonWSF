public abstract class Conta {
    private int agencia;
    private final int numero;
    protected double saldo;
    private String tipoConta;

    public Conta(int agencia, int numero, double saldo, String tipoConta) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double setSaldo(double saldo) {
        return this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }
    
    public void depositar(double valor) {
        if (valor > 0){
            this.saldo += valor;
            System.out.println("Você depositou: R$" + valor + " na sua conta.");
            System.out.println("Seu saldo atual é: R$" + this.saldo);
        }else {
            System.out.println("Valor de depósito inválido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido");
        }
    }

    public abstract void transferencia(Conta contaDestino, double valor);
}
