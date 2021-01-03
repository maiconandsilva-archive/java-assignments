package com.estacionamento.fajuto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

//@Data
@EqualsAndHashCode(callSuper=false)
public class CobrancaTempo extends CalculoCobranca {

	private final double INICIO_COBRANCA;
	private final double TERMINO_COBRANCA;
	private final double MINUTOS;
	public static final double INICIO_TERMINO_COBRANCA = 0;

	CobrancaTempo(double inicioCobranca, double terminoCobranca, double minutos, double valorBase) {
		super();
		INICIO_COBRANCA = inicioCobranca;
		TERMINO_COBRANCA = terminoCobranca;
		MINUTOS = minutos;
		this.setValorBase(valorBase);
	}
	
	@Override
	public boolean regraPermiteCalculo(ContaEstacionamento conta) {
		return conta.getPeriodo() > INICIO_COBRANCA && (
			conta.getPeriodo() < TERMINO_COBRANCA || TERMINO_COBRANCA == INICIO_TERMINO_COBRANCA);
	}

	@Override
	public double calcularValor(ContaEstacionamento conta) {
		return conta.veiculo.getValorBase(this) * Math.ceil(conta.getPeriodo()/MINUTOS);
	}

}
