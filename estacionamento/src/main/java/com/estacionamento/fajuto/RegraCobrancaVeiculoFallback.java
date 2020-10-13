package com.estacionamento.fajuto;

public class RegraCobrancaVeiculoFallback extends RegraCobrancaVeiculo {

	@Override
	public boolean isAplicavel(Veiculo veiculo) {
		return true;
	}

	@Override
	public double getValorBase(Class<?> cobranca) {
		return valoresCobrancas.get(cobranca);
	}

}
