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
        saldo += valor;
    }

    //Sacar valor
    public void sacar(double valor){
        saldo -= valor;
    }
}
