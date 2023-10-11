import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente{
    private String nome;
    private final String cpf;
    private String dataNascimento;
    private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String dataNascimento, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public List<Conta> getContas(){
        return contas;
    }

    //Adicionar conta
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta escolherConta(){
        int aux = 1;
        for (Conta conta : contas){
            System.out.println("--> Conta " + aux + ": R$" + conta.getSaldo());
            aux ++;
        }

        Scanner scanner1 = new Scanner(System.in);
        int numeroContaEscolhida = scanner1.nextInt();
        Conta contaEscolhida = contas.get(numeroContaEscolhida -1);
        
        return contaEscolhida;
    }
}