public class Conta {
    private final String agencia;
    private final int numero;
    private double saldo;
    private Cliente cliente;
    
    public Conta (String agencia, int numero, double saldo, Cliente cliente){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
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
        System.out.println("Você realizou um deposito de " + valor);
    }

    //Sacar valor
    public void sacar(double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Você realizou um saque de " + valor);

        } else {
            System.out.println("Seu saldo é insuficiente");
        }
    }

    //Realizar tranferência
    public void transferir(Conta contaDestino, double valor){
        if (this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.saldo += valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}
