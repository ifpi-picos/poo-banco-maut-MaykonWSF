import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private int agencia;
    private final int numero;
    protected double saldo;
    private String tipoConta;
    private Cliente cliente;
    protected Notificacao notificacao;

    List<Movimentacao> historicoMovimentacao;

    public Conta(int agencia, int numero, double saldo, String tipoConta, Cliente cliente, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.notificacao = notificacao;
        this.historicoMovimentacao = new ArrayList<>();
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

    public Cliente getCliente() {
        return cliente;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Você depositou: R$" + valor + " na sua conta.");

            Movimentacao movimentacao = new Movimentacao(LocalDate.now(), valor, "depósito");
            historicoMovimentacao.add(movimentacao);

            System.out.println("Seu saldo atual é: R$" + this.saldo);

            System.out.println("\n");
            notificacao.enviarNotificacao("depósito", valor);
        } else {
            System.out.println("Valor de depósito inválido");
        }
    }

    public abstract void sacar(double valor);

    public abstract void transferencia(Conta contaDestino, double valor);

    public void exibeExtrato() {
        System.out.println("####### Extrato #########");
        historicoMovimentacao.forEach(movimentacao -> System.out.println(movimentacao));
        System.out.println("Saldo atual: R$" + this.saldo);
        System.out.println("#########################");
    }
}
