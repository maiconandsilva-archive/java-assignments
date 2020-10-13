package br.com.bb.processamento.remessa;

import java.io.Reader;
import java.util.List;


abstract class ProcessaRemessa {

	protected Reader reader;
	
	public ProcessaRemessa(Reader reader) {
		this.reader = reader;
	}
	
	public abstract List<MetodoPagamento> processarRemessa();

}
