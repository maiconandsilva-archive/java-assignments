package lojavirtual;

public abstract class Desconto {
	public abstract String getNome();
	public abstract double getValorDesconto();
	public abstract double getValorComDesconto(double valor);
}
