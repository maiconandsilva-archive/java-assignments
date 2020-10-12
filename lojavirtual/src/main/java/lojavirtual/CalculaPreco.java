package lojavirtual;

import java.util.List;

public class CalculaPreco {
	public double calcularPrecoComDesconto(List<RecebeDesconto> listaRecebeDesconto) {
		
		return 0;
	}
	
	public double calcularPrecoComDesconto(RecebeDesconto passivelDeDesconto) {
		return passivelDeDesconto.getDesconto().getValorComDesconto(passivelDeDesconto.getValor());
	}
}
