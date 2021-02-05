

public class Conta {

	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	public Conta(int agencia, int numero) {
		total++;
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("Criando uma conta!");
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setAgencia(int agencia) {
		if (agencia < 0) {
			System.out.println("não vale numero menor que 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setNumero(int numero) {
		if (numero < 0) {
			System.out.println("não vale numero menor que 0");
			return;
		}
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public boolean sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			System.out.println("transferencia feita com sucesso!");
			return true;
		}
		else {
			System.out.println("transferencia nao realizada!");
			return false;
		}
	}
	
	public boolean transferir(double valor, Conta destino) {
		if (sacar(valor)) {
			destino.depositar(valor);
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}
