package com.estacionamento.fajuto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public abstract class CalculoCobranca {

	protected final UUID ID = UUID.randomUUID();
	@Getter @Setter private double valorBase;

	public abstract double calcularValor(ContaEstacionamento conta);

	public abstract boolean regraPermiteCalculo(ContaEstacionamento conta);

}
