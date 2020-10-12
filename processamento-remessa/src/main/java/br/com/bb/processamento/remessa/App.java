package br.com.bb.processamento.remessa;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

import static br.com.bb.processamento.remessa.Remessa.json;
import static br.com.bb.processamento.remessa.Remessa.xml;

/**
 * Hello world!
 *
 */
public class App 
{
	static void print(MetodoPagamento mPagamento) {
		if (mPagamento instanceof Boleto) {
			print((Boleto)mPagamento);
		}
		else if (mPagamento instanceof CartaoCredito) {
			print((CartaoCredito)mPagamento);
		}
		else if (mPagamento instanceof CartaoDebito) {
			print((CartaoDebito)mPagamento);	
		}
		System.out.println("Data: " + mPagamento.getData());
		System.out.println("Nome: " + mPagamento.getNome());
		System.out.println("Cpf: " + mPagamento.getCpf());
		System.out.println("BancoRecebimento: " + mPagamento.getBancoRecebimento());
		System.out.println("BancoPagamento: " + mPagamento.getBancoPagamento());
		System.out.println("Valor: " + mPagamento.getValor());
	}
	
	static void print(Boleto boleto) {
		System.out.println("BOLETO");
		System.out.println("Numero Boleto: " + boleto.getNumeroBoleto());
	}
	
	static void print(Cartao cartao) {
		System.out.println("Numero Cartao: " + cartao.getNumeroCartao());
		System.out.println("Nome Titular: " + cartao.getNomeTitular());
	}
	
	static void print(CartaoCredito cartaoCredito) {
		System.out.println("CARTAO CREDITO");
		print((Cartao)cartaoCredito);
		System.out.println("Numero Parcelas: " + cartaoCredito.getParcelas());
	}
	
	static void print(CartaoDebito cartaoDebito) {
		System.out.println("CARTAO DEBITO");
		print((Cartao)cartaoDebito);
	}

	static File f(String fileName) {
		return new File(System.getProperty("user.dir") + File.separator + fileName);
	}

	public static void main( String[] args ) throws IOException 
    {
//		List<MetodoPagamento> remessa = Remessa.from(xml(f("remessa.xml");
		List<MetodoPagamento> remessa = Remessa.from(json(f("remessa.json")));

		CPFValidator validator = new CPFValidator();

		System.out.println("CPFs INVALIDOS\n");

		for (MetodoPagamento mPagamento : remessa) {
			try {
				validator.assertValid(mPagamento.getCpf());
			} catch (InvalidStateException e) {
				System.out.println("-----------------------");
				print(mPagamento);
			}
		}
    }
}
