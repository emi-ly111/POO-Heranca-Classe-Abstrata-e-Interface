public class ContaBancaria {
    private String cliente;
    private int numeroConta;
    protected double saldo;

    public ContaBancaria(String cliente, int numeroConta, double saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void mostrarDados() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo: " + saldo);
    }
}
