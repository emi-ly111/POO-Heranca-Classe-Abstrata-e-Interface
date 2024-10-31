public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String cliente, int numeroConta, double saldoInicial, double limite) {
        super(cliente, numeroConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            return true;
        }
        System.out.println("Limite insuficiente!");
        return false;
    }

    public double getLimite() {
        return limite;
    }
}
