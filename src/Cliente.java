import java.util.ArrayList;
import java.util.List;

public class Cliente{
    private String nome;
    private final String cpf;
    private String dataNascimento;
    private String endereco;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String dataNascimento, String endereco){
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

    public String getEndereco(){
        return endereco;
    }

    public List<Conta> getContas(){
        return contas;
    }

    //Adicionar conta
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}