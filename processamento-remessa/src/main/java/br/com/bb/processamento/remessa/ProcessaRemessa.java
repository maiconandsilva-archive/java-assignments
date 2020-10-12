package br.com.bb.processamento.remessa;

import java.io.File;
import java.io.Reader;
import java.util.List;


abstract class ProcessaRemessa {

	protected Reader reader;
	
	public ProcessaRemessa(Reader reader) {
		this.reader = reader;
	}
	
	protected String filePath(String fileName) {
		return String.format("%s%s%s",
				System.getProperty("user.dir"), File.separator, fileName);
	}
	
	public abstract List<MetodoPagamento> processarRemessa();

}
