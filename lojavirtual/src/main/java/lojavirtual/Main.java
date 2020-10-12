package lojavirtual;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Produto dado = new ProdutoUnitario("DADO", new DescontoPorcentagem(0.1));
		dado.setDescricao("6 Faces");
		dado.setValor(10000);
		
		Produto dadinho = new ProdutoUnitario("DADINHO", new DescontoAbsoluto(2000));
		dadinho.setDescricao("Cubo de Chocolate");
		dadinho.setValor(10000);
		
		Produto dados = new ProdutoUnitario("DADOS", new DescontoPorcentagem(0.3));
		dados.setDescricao("CPF, E-mail e Telefone de Qualquer Brasileiro");
		dados.setValor(10000);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(dado);
		produtos.add(dadinho);
		produtos.add(dados);

		ProdutoComposto produtoComposto = new ProdutoComposto(
				"Informacao", produtos, new DescontoAbsoluto(1111111111111111.1));
		produtoComposto.setDescricao("Conjunto de dados organizados para an�lise");
		
		System.out.println("PRODUTO COMPOSTO");
		System.out.printf("Nome: %s\n", produtoComposto.getNome());
		System.out.printf("Descricao: %s\n", produtoComposto.getDescricao());
		System.out.printf("Valor a partir dos valores dos produtos: R$ %.2f\n", produtoComposto.getValor());
		System.out.printf("Valor com Desconto a partir dos valores produtos: R$ %.2f\n", produtoComposto.getValorComDesconto());
		produtoComposto.setValor(9999999999999999.9);
		System.out.printf("Valor independente: R$ %.2f\n", produtoComposto.getValor());
		System.out.printf("Valor com Desconto independente: R$ %.2f\n", produtoComposto.getValorComDesconto());
		
		System.out.println("\n\nPRODUTOS QUE COMP�EM O PRODUTO COMPOSTO");
		produtoComposto.getProdutos().forEach((p) -> {
			System.out.printf("Nome: %s\n", p.getNome());
			System.out.printf("Descricao: %s\n", p.getDescricao());
			System.out.printf("Valor: R$ %.2f\n", p.getValor());
			System.out.printf("Valor com Desconto: R$ %.2f\n", p.getValorComDesconto());
			System.out.printf("%s de: %.2f\n\n\n", p.getDesconto().getNome(), p.getDesconto().getValorDesconto());
		});
	}

}
