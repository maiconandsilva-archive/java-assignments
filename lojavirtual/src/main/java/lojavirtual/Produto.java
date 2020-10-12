package lojavirtual;

public abstract class Produto implements RecebeDesconto {
	private String nome;
	private String descricao;
	private double valor;
	private Desconto desconto;
	protected CalculaPreco calc = new CalculaPreco();

	@Override
	public double getValorComDesconto() {
		return calc.calcularPrecoComDesconto(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}
}
