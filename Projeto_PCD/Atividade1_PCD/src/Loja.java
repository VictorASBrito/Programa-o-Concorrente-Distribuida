public class Loja {
    private final String nomeLoja;
    private final Conta contaLoja;
    private final Funcionario[] funcionarios;


    public Loja(String nomeLoja, Conta contaLoja, Funcionario[] funcionarios) {
        this.nomeLoja = nomeLoja;
        this.contaLoja = contaLoja;
        this.funcionarios = funcionarios;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public Conta getContaLoja() {
        return contaLoja;
    }

    public void pagarFuncionarios() {
        System.out.println("Pagamento dos funcionários da loja: " + nomeLoja);
        synchronized(contaLoja){
            for (Funcionario funcionario : funcionarios) {
                if (contaLoja.getSaldo() >= Funcionario.getSalario()) {
                    contaLoja.depositar(Funcionario.getSalario());
                    System.out.println("O funcionario " + funcionario.getNome() + " da loja " + nomeLoja + "recebeu seu salário de " + Funcionario.getSalario() +"R$");
                }
            }
        }
    }
}
