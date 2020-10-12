package lojavirtual;

public class DescontoAbsoluto extends Desconto {

	private double valorDesconto;
	
	public DescontoAbsoluto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Override
	public double getValorDesconto() {
		return valorDesconto;
	}
	
	@Override
	public double getValorComDesconto(double valor) {
		return valor - valorDesconto;
	}

	@Override
	public String getNome() {
		return "Desconto Absoluto";
	}
}
