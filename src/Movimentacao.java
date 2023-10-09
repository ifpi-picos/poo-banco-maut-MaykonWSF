import java.time.LocalDate;

public class Movimentacao {
    LocalDate data;
    double valor;
    String tipo;   

    public Movimentacao(LocalDate data, double valor, String tipo) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    // @Override
    public String toString(){
        return tipo + " de " + valor + " realizado " + " em " + data;
    }
}