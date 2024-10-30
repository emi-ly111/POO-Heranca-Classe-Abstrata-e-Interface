public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String cliente, int numeroConta, double saldoInicial, int diaRendimento) {
        super(cliente, numeroConta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        saldo += saldo * taxaRendimento / 100;
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }
}

