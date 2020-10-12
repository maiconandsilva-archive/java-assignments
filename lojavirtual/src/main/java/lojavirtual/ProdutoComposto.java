package lojavirtual;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto {
	
	private List<Produto> produtos = new ArrayList<>();

	
	public ProdutoComposto(String nome,
			List<Produto> produtos, Desconto desconto) {
		setNome(nome);
		setProdutos(produtos);
		setDesconto(desconto);
	}
	
	public void addProdutos(List<Produto> produtos) {
		produtos.addAll(produtos);
	}
	
	public List<Produto> getProdutos() {
		return new ArrayList<>(produtos);
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = new ArrayList<>(produtos);
	}

	/*Calcular Valor Totais*/
	private double getValorAutoCalculado() {
		double valorAutoCalculado = 0;
		for (Produto produto : produtos) {
			valorAutoCalculado += produto.getValor();
		}
		return valorAutoCalculado;
	}

	private double getValorAutoCalculadoComDesconto() {
		double valorAutoCalculadoComDesconto = 0;
		for (Produto produto : produtos) {
			valorAutoCalculadoComDesconto += produto.getValorComDesconto();
		}
		return valorAutoCalculadoComDesconto;
	}
	
	private boolean isValorAutomatico() {
		return super.getValor() == 0;
	}
	
	@Override
	public double getValor() {
		if (isValorAutomatico()) {
			return getValorAutoCalculado();
		}
		return super.getValor();
	}
	
	@Override
	public double getValorComDesconto() {
		if (isValorAutomatico()) {
			return getValorAutoCalculadoComDesconto();
		}
		return super.getValorComDesconto();
	}
	
}
