package com.estacionamento.fajuto;

import lombok.Data;

@Data
public class ContaEstacionamento {

	private long inicio;
	private long fim;
	private double valorFinalConta;
	private boolean finalizada;
	
	public Veiculo veiculo;

	public double calcularValorConta(CalculoCobranca cobranca) {
		return cobranca.calcularValor(this);
	}

	public long getPeriodo() {
		return fim - inicio;
	}
	
	public boolean estaFinalizada() {
		return finalizada;
	}

}
