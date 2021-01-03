package com.estacionamento.fajuto;

import java.util.List;

import lombok.Setter;

public class CalculaValorCobranca {
	
	@Setter private List<CalculoCobranca> calculos;

	/*
	 * Os calculos devem estar em ordem de prioridade
	 * Dos mais especificos para os mais gerais
	 */
	public double calcularCobranca(ContaEstacionamento conta) {
		double cobranca = 0;
		for (CalculoCobranca calculo : calculos) {
			if (calculo.regraPermiteCalculo(conta)) {
				cobranca += calculo.calcularValor(conta);
			}
		}
		return cobranca;
	}

}
