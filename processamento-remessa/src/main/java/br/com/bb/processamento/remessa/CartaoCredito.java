package br.com.bb.processamento.remessa;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@XStreamAlias("br.com.pageseguro.RemessaCartaoCredito")
public class CartaoCredito extends Cartao {
	private int parcelas;
}
