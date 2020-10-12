package br.com.bb.processamento.remessa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class Cartao extends MetodoPagamento {
	private  String numeroCartao;
	private  String nomeTitular;
}
