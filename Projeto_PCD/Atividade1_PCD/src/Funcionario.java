public class Funcionario extends Thread{
    private final String nomeFuncionario;
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final static double salario = 1400;

    public Funcionario(String nomeFuncionario, Conta contaSalario, Conta contaInvestimento) {
        this.nomeFuncionario = nomeFuncionario;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    @Override
    public void run() {
        contaSalario.depositar(1400); // Recebe o salário
        int valorInvestimento = (int) (0.2 * salario); // 20% do salário
        contaInvestimento.depositar(valorInvestimento); // Investe 20% do salário
        System.out.println(nomeFuncionario + " recebeu o salário e investiu R$ " + valorInvestimento);
    }

    public String getNome() {
        return nomeFuncionario;
    }

    public static double getSalario() {
        return salario;
    }
}
