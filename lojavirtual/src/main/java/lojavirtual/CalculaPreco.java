package lojavirtual;

public class CalculaPreco {
	public double calcularPrecoComDesconto(RecebeDesconto passivelDeDesconto) {
		return passivelDeDesconto.getDesconto().getValorComDesconto(passivelDeDesconto.getValor());
	}
}
