package com.estacionamento.fajuto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public abstract class RegraCobrancaVeiculo {
	
	@Getter @Setter private Map<Class<?>, Double> valoresCobrancas;

	public abstract boolean isAplicavel(Veiculo veiculo);

	public abstract double getValorBase(Class<?> cobranca);

}
