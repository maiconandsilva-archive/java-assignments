package br.com.bb.processamento.remessa;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@XStreamAlias("br.com.pageseguro.RemessaBoleto")
public class Boleto extends MetodoPagamento {
	private int numeroBoleto;
}
