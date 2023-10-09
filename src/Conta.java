import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Conta {
    private final String agencia;
    private final int numero;
    private double saldo;
    private Cliente cliente;

    List<Movimentacao> historicoMovimentacao;
    
    public Conta (String agencia, int numero, double saldo, Cliente cliente){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.historicoMovimentacao = new ArrayList<>();
    }

    //Getters
    public String getAgencia(){
        return agencia;
    }    

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    //Depositar valor
    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Você realizou um deposito de R$" + valor);
        addHistoricoMovimentacao(valor, "Deposito");
    }

    //Sacar valor
    public void sacar(double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Você realizou um saque de R$" + valor);
            addHistoricoMovimentacao(valor, "Saque");

        } else {
            System.out.println("Seu saldo é insuficiente");
        }
    }

    //Realizar tranferência
    public void transferir(Conta contaDestino, double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Você realizou uma tranferência de R$" + valor);
            addHistoricoMovimentacao(valor, "Tranferência");

        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void exibeExtrato(){
        System.out.println("####### Extrato #########");
        historicoMovimentacao.forEach(m -> System.out.println(m));
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("################");
    }

    private void addHistoricoMovimentacao(double valor, String tipo) {
        Movimentacao m = new Movimentacao(LocalDate.now(), valor, tipo);
        historicoMovimentacao.add(m);
    }
}
