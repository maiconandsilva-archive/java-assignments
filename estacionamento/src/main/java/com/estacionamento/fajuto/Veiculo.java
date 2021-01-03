package com.estacionamento.fajuto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
public abstract class Veiculo {

	@Setter
	@Getter 
	private static List<RegraCobrancaVeiculo> regraCobrancaVeiculo;

	private String placa;

	/*
	 * As regras devem estar em ordem de prioridade
	 * Dos mais espec�ficos para os mais gerais
	 * 
	 */
	@SneakyThrows(Exception.class)
	public double getValorBase(CalculoCobranca cobranca)  {
		double valorBase = 0;
		for (RegraCobrancaVeiculo regra : regraCobrancaVeiculo) {
			if (regra.isAplicavel(this)) {
				valorBase += regra.getValorBase(cobranca);
			}
		}
		return valorBase;
	}

} 
