package br.com.bb.processamento.remessa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
		
	private static Reader getReaderFrom(File file) throws FileNotFoundException {
		return new BufferedReader(new FileReader(file));
	}
	
	public static ProcessaRemessa json(File file) throws FileNotFoundException {
		return new RemessaJson(getReaderFrom(file), classes);
	}
	
	public static ProcessaRemessa xml(File file) throws FileNotFoundException {
		return new RemessaXml(getReaderFrom(file), classes);
	}

	public static List<MetodoPagamento> from(ProcessaRemessa processaRemessa)
			throws IOException {
		return processaRemessa.processarRemessa();
	}
}
