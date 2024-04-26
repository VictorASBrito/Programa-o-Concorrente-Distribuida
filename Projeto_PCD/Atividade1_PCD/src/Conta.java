public class Conta {
    private String nomeConta;
    private int saldo;

    public Conta(String nomeConta, int saldoInicial) {
        this.nomeConta = nomeConta;
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double valor) {
        saldo+=valor;
    }

    public synchronized void sacar(double valor) {
        saldo-=valor;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public int getSaldo() {
        return saldo;
    }
}
