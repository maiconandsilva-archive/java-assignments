package com.estacionamento.fajuto;

public class CobrancaMes extends CobrancaTempo {

	public CobrancaMes(double terminoCobranca, double inicioCobranca) {
		super(terminoCobranca, inicioCobranca);
	}

	@Override
	public double calcularValor(ContaEstacionamento conta) {
		return conta.veiculo.getValorBase(this.getClass()) * Math.ceil(conta.getPeriodo()/Data.MES);
	}

}
