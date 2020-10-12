package br.com.bb.processamento.remessa;

import java.math.BigDecimal;
import java.util.Date;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public abstract class MetodoPagamento {
	
	private Date data;
	private String nome;

	@XStreamAlias("CPF")
	@SerializedName("CPF")
	private String cpf;
	
	private String bancoRecebimento;
	private String bancoPagamento;
	private BigDecimal valor;
	
}
