package com.estacionamento.fajuto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class CobrancaTempo extends CalculoCobranca {

	private final double inicioCobranca;
	private final double terminoCobranca;
	
	public static final double INICIO_TERMINO_COBRANCA = 0;
	
	@Override
	public boolean regraPermiteCalculo(ContaEstacionamento conta) {
		return conta.getPeriodo() > getInicioCobranca() && (
			conta.getPeriodo() < getTerminoCobranca() ||
			getTerminoCobranca() == INICIO_TERMINO_COBRANCA);
	}
	
}
