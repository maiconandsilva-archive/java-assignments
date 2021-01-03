package com.estacionamento.fajuto;

import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public abstract class RegraCobrancaVeiculo {
	


	public abstract boolean isAplicavel(Veiculo veiculo);

	public abstract double getValorBase(CalculoCobranca cobranca);

}
