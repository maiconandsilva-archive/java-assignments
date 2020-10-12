package lojavirtual;

public class DescontoPorcentagem extends Desconto {
	private double porcentagem;
	
	public DescontoPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	@Override
	public double getValorComDesconto(double valor) {
		return valor - porcentagem * valor;
	}

	@Override
	public String getNome() {
		return "Desconto Porcentagem";
	}
	
	@Override
	public double getValorDesconto() {
		return porcentagem;
	}
}
