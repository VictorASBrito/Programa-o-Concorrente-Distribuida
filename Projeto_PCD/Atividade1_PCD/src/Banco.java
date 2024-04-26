import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final Lock lock= new ReentrantLock();


    public synchronized void transferir(Conta origem, Conta destino, double valorDaCompra) {
        lock.lock();
        try{
            if (origem.getSaldo() >= valorDaCompra) {
                origem.sacar(valorDaCompra);
                destino.depositar(valorDaCompra);
                System.out.println("Transferência de R$ " + valorDaCompra + " realizada da conta " + origem.getNomeConta() + "para a conta " + destino.getNomeConta());
            }
            else{
                System.out.println("Saldo insuficiente para conta: " + origem.getNomeConta());
            }
        } finally {
            lock.unlock();
        }



    }

    public void exibirSaldosFinais(Conta[] contas){
        System.out.println("O saldo final das contas é: ");
        for (Conta conta : contas) {
            System.out.println("Conta - " + conta.getNomeConta() + " / Saldo - " + conta.getSaldo());
        }
    }

}
