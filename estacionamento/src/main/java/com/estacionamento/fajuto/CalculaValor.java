package com.estacionamento.fajuto;

import java.util.List;

import lombok.Setter;

public class CalculaValor {
	
	@Setter private List<CalculoCobranca> calculos;

	/*
	 * Os calculos devem estar em ordem de prioridade
	 * Dos mais específicos para os mais gerais
	 * 
	 * Por exemplo:
	 * 
	 * 
	 */
	public double calcularCobranca(ContaEstacionamento conta) {
		double cobranca = 0;
		for (CalculoCobranca calculo : calculos) {
			if (calculo.regraPermiteCalculo(conta)) {
				cobranca = calculo.calcularValor(conta);
				break;
			}
		}
		return cobranca;
	}

}
