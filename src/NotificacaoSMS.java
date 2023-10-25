public class NotificacaoSMS implements Notificacao{

    @Override
    public void enviarNotificacao(String tipo, double valor) {
        System.out.println("----------------------------------");
        System.out.println("Enviando notificação via SMS:");
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: " + valor);
        System.out.println("----------------------------------");
    }
    
}
