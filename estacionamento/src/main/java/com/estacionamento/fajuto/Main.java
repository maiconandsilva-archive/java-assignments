package com.estacionamento.fajuto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static enum Operacao { EXIBIR, ADICIONAR, ATUALIZAR, REMOVER, SAIR }
	private static enum TipoVeiculoEnum { PASSEIO, CARGA }
	
	private GerenciaContas gerenciaContas;
	
	{
		CalculaValor calculaCobranca = new CalculaValor();
		calculaCobranca.setCalculos(Arrays.asList(new CalculoCobranca[] {
				new CobrancaHora(CobrancaTempo.INICIO_TERMINO_COBRANCA, 15 * Data.HORA),
				new CobrancaDia(12 * Data.HORA, 15 * Data.DIA),
				new CobrancaMes(15 * Data.DIA, CobrancaTempo.INICIO_TERMINO_COBRANCA)
		}));
		
		Map<Class<?>, Double> valores = new WeakHashMap<>();
		valores.put(CobrancaHora.class, 12.0);
		valores.put(CobrancaDia.class, 26.0);
		valores.put(CobrancaMes.class, 300.0);
		
		RegraCobrancaVeiculo regra = new RegraCobrancaVeiculoFallback();
		regra.setValoresCobrancas(valores);

		Veiculo.setRegraCobrancaVeiculo(new ArrayList<RegraCobrancaVeiculo>());
		Veiculo.getRegraCobrancaVeiculo().add(regra);
		
		Map<String, ContaEstacionamento> contas = new HashMap<>(100);
		gerenciaContas = new GerenciaContas(calculaCobranca, contas);
	}

	public void preencherVaga() {
		System.out.println("===> Preencher vaga");
		System.out.println("Tipo de veiculo~:> ");
		System.out.println("0 - Carga");
		System.out.println("1 - Passeio");
		System.out.print("~:> ");
		Veiculo veiculo = null;
		
		switch(TipoVeiculoEnum.values()[Integer.parseInt(scanner.nextLine())]) {
		case PASSEIO:
			veiculo = new VeiculoCarga();
			break;
		case CARGA:
		default:
			veiculo = new VeiculoPasseio();;
		}
		
		System.out.println("===> Digite a placa do veiculo");
		System.out.print("~:> ");
		String placa = scanner.nextLine();


		
		veiculo.setPlaca(placa);
		gerenciaContas.iniciar(veiculo.getPlaca(), veiculo);
		
		exibirInfoVaga(veiculo.getPlaca());
	}
	
	public void exibirInfoVaga(String placaVeiculo) {
		ContaEstacionamento conta = gerenciaContas.getConta(placaVeiculo);
		
		System.out.printf("\nValor ~:> %.2f\n", gerenciaContas.calcularCobranca(placaVeiculo));
		System.out.printf("periodo ~:> %d\n", conta.getPeriodo());
		System.out.printf("inicio ~:> %d\n", conta.getInicio());
		System.out.printf("fim ~:> %d\n", conta.getFim());
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		while (true) {
			System.out.println("\n\n===> Operacoes");
			System.out.println("0 - Exibir");
			System.out.println("1 - Adicionar\n");
			switch (Operacao.values()[Integer.parseInt(scanner.nextLine())]) {
			case EXIBIR:
				System.out.println("===> Digite a placa do veiculo");
				System.out.print("~:> ");
				main.exibirInfoVaga(scanner.nextLine());
				break;
			case ADICIONAR:
				main.preencherVaga();
				break;
			case ATUALIZAR:
			case REMOVER:
			case SAIR:
			default:
			}
		}

	}

}
