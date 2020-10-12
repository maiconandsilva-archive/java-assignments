package br.com.bb.processamento.remessa;

import java.io.Reader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

class RemessaXml extends ProcessaRemessa {
	
	private final XStream xstream = new XStream();
	
	public RemessaXml(Reader reader,
			List<Class<? extends MetodoPagamento>> classes) {
		super(reader);
		init(classes);
	}

	@Override
	public List<MetodoPagamento> processarRemessa() {
    	return ((MetodosPagamento) xstream.fromXML(reader)).rMetodoPagamento;
	}
	
	private void init(List<Class<? extends MetodoPagamento>> classes) {
		XStream.setupDefaultSecurity(xstream);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		
		xstream.allowTypes(new Class<?>[] {
			MetodosPagamento.class,
		});
		xstream.allowTypeHierarchy(MetodoPagamento.class);
		
		xstream.processAnnotations(MetodosPagamento.class);
		classes.forEach((klass) -> {
			xstream.processAnnotations(klass);
		});
	}

	@XStreamAlias("list")
	private static class MetodosPagamento {
		@XStreamImplicit
		List<MetodoPagamento> rMetodoPagamento;
	}

}
