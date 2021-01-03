package com.estacionamento.fajuto;

import java.util.Map;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class GerenciaContas {
	
	private final CalculaValorCobranca calculaCobranca;
	
	private Map<String, ContaEstacionamento> contas;
	
	private long now() {
		return System.currentTimeMillis();
	}
	
	public void iniciar(String placaVeiculo, Veiculo veiculo) {
		ContaEstacionamento conta = new ContaEstacionamento();
		conta.setInicio(now());
		conta.setVeiculo(veiculo);
		
		contas.put(placaVeiculo, conta);
	}
	
	public ContaEstacionamento finalizar(String placaVeiculo) {
		ContaEstacionamento conta = getConta(placaVeiculo);
		conta.setFinalizada(true);
		return conta;
	}

	public ContaEstacionamento getConta(String placaVeiculo) {
		ContaEstacionamento conta = contas.get(placaVeiculo);
		if (!conta.estaFinalizada()) {
			conta.setFim(now());
		}
		return conta;
	}
	
	public double calcularCobranca(String placaVeiculo) {
		ContaEstacionamento conta = getConta(placaVeiculo);
		conta.setValorFinalConta(calculaCobranca.calcularCobranca(conta));
		return conta.getValorFinalConta();
	}
}
