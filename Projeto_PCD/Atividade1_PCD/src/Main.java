public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Conta contaL1 = new Conta("Mestre RPG", 0);
        Conta contaL2 = new Conta("AliExpress", 0);

        Funcionario funcionario1L1 = new Funcionario("Maísa", contaL1, null);
        Funcionario funcionario2L1 = new Funcionario("Marcus Vinicius", contaL1, null);
        Funcionario funcionario1L2 = new Funcionario("Victor Brito", contaL2, null);
        Funcionario funcionario2L2 = new Funcionario("Claudia Elete", contaL2, null);

        Loja L1 = new Loja("Mestre RPG", contaL1, new Funcionario[]{funcionario1L1, funcionario1L2});
        Loja L2 = new Loja("AliExpress", contaL2, new Funcionario[]{funcionario2L1, funcionario2L2});

        Conta contaF1 = new Conta("Santander - Maísa", 0);
        Conta contaF2 = new Conta("Caixa - Marcus", 0);
        Conta contaF3 = new Conta("Nubank - Victor", 0);
        Conta contaF4 = new Conta("PicPay - Claudia", 0);

        Conta contaI1 = new Conta("Poupança - Maísa", 0);
        Conta contaI2 = new Conta("Poupança - Marcus", 0);
        Conta contaI3 = new Conta("Caixinha Nubank - Victor", 0);
        Conta contaI4 = new Conta("Crypto PicPay - Claudia", 0);

        Conta contaC1 = new Conta("Banco do Brasil - Arthur", 1000);
        Conta contaC2 = new Conta("Inter - Ryan", 1000);
        Conta contaC3 = new Conta("Bradesco - Sarah", 1000);
        Conta contaC4 = new Conta("Itaú - Isabella", 1000);
        Conta contaC5 = new Conta("Sicoob - João Maminha", 1000);

        Cliente cliente1 = new Cliente("Arthur Neves", contaC1, new Loja[]{L1, L2}, banco);
        Cliente cliente2 = new Cliente("Ryan", contaC2, new Loja[]{L1, L2}, banco);
        Cliente cliente3 = new Cliente("Sarah", contaC3, new Loja[]{L1, L2}, banco);
        Cliente cliente4 = new Cliente("Isabella", contaC4, new Loja[]{L1, L2}, banco);
        Cliente cliente5 = new Cliente("João Maminha", contaC5, new Loja[]{L1, L2}, banco);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        L1.pagarFuncionarios();
        L2.pagarFuncionarios();


        Conta[] contas = {contaC1, contaC2, contaC3, contaC4, contaC5, contaF1, contaF2, contaF3, contaF4, contaI1, contaI2, contaI3, contaI4, contaL1, contaL2};
        banco.exibirSaldosFinais(contas);
    }
}
