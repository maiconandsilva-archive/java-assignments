package com.estacionamento.fajuto;

public abstract class CalculoCobranca {
	
	public abstract double calcularValor(ContaEstacionamento conta);
		
	public abstract boolean regraPermiteCalculo(ContaEstacionamento conta);

}
