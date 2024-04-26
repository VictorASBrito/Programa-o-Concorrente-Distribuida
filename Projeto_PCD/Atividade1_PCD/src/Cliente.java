import java.util.Random;

public class Cliente extends Thread {

    private final String nomeCliente;
    private final Conta conta;
    private final Loja[] lojas;
    private final Banco banco;
    private final Random random = new Random();

    public Cliente(String nomeCliente, Conta conta, Loja[] lojas, Banco banco) {
        this.nomeCliente = nomeCliente;
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    @Override
    public void run() {
        while (conta.getSaldo() > 0) {
            Loja loja = lojas[(int) (Math.random() * lojas.length)];
            double valorDaCompra = Math.random() < 0.5 ? 100 : 200;

            synchronized (loja) {
                if (conta.getSaldo()>= valorDaCompra) {
                    banco.transferir(conta, loja.getContaLoja(), valorDaCompra);
                    System.out.println(nomeCliente + " realizou uma compra de R$ " + valorDaCompra);
                } else {
                    break; // Saldo insuficiente
                }
            }
            try {
                Thread.sleep(random.nextInt(1000)); // Intervalo entre compras
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
