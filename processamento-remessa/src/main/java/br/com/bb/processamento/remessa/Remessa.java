package br.com.bb.processamento.remessa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Remessa {
	
	private static final List<Class<? extends MetodoPagamento>>
		classes = Arrays.asList(
				/*A ordem importa*/
				Boleto.class,
				CartaoCredito.class,
				CartaoDebito.class
			);
	
	private Remessa() {}
	
//	private static Remessa instancia;
//	public static Remessa getInstance() {
//		if (instancia == null)
//			instancia = new Remessa();
//		return instancia;
//	}
	
	private static ProcessaRemessa processaRemessaJson;
	private static ProcessaRemessa processaRemessaXml;
	
	public static ProcessaRemessa json(File file) throws FileNotFoundException {
		if (processaRemessaJson == null)
			processaRemessaJson = new RemessaJson(
					new BufferedReader(new FileReader(file)), classes);
		return processaRemessaJson;
	}
	
	public static ProcessaRemessa xml(File file) throws FileNotFoundException {
		if (processaRemessaXml == null)
			processaRemessaXml = new RemessaXml(
					new BufferedReader(new FileReader(file)), classes);
		return processaRemessaXml;
	}

	public static List<MetodoPagamento> from(ProcessaRemessa processaRemessa)
			throws IOException {
		return processaRemessa.processarRemessa();
	}
}
