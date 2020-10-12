package br.com.bb.processamento.remessa;


import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;


class RemessaJson extends ProcessaRemessa {

	private final Gson gson;
	
	public RemessaJson(Reader reader,
			List<Class<? extends MetodoPagamento>> classes) {
		super(reader);
		this.gson = new GsonBuilder()
				.registerTypeAdapter(MetodoPagamento.class, initDeserializerWith(classes))
				.create();
	}
	
	@Override
	public List<MetodoPagamento> processarRemessa() {
		Type tipo = new TypeToken<ArrayList<MetodoPagamento>>(){}.getType();
		return gson.fromJson(reader, tipo);
	}
	
	private MetodoPagamentoDeserializer initDeserializerWith(
			List<Class<? extends MetodoPagamento>> classes) {
		MetodoPagamentoDeserializer deserializer = new MetodoPagamentoDeserializer();
		for (Class<? extends MetodoPagamento> klass : classes) {
			Field[] fields = klass.getDeclaredFields();
			if (fields.length != 0) {
				deserializer.registrarParametroMetodoPagamento(fields[0].getName(), klass);
			}
			else {
				deserializer.registrarParametroMetodoPagamento(
						klass.getSuperclass().getDeclaredFields()[0].getName(), klass);
			}
		}
		return deserializer;
	}
	
	private class MetodoPagamentoDeserializer 
		implements JsonDeserializer<MetodoPagamento> {

		private final Map<String, Class<? extends MetodoPagamento>>
			parametroMetodoPagamento = new LinkedHashMap<>();

		public void registrarParametroMetodoPagamento(String parametro,
				Class<?extends MetodoPagamento> metodoPagamento) {
			this.parametroMetodoPagamento.put(parametro, metodoPagamento);
		}

		@Override
		public MetodoPagamento deserialize(JsonElement json,
				Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			
			JsonObject jsonObject = json.getAsJsonObject();
			
			for (String field : parametroMetodoPagamento.keySet()) {
				if (jsonObject.has(field))
					return context.deserialize(jsonObject,
							parametroMetodoPagamento.get(field));
			}
			throw new RuntimeException("It doesn't work at all");

		}
		
	}
}
