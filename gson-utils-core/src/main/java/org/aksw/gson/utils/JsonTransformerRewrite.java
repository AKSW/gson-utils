package org.aksw.gson.utils;

import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonTransformerRewrite
	extends JsonTransformerBase<JsonElement>
{
	private JsonVisitor<? extends JsonElement> visitor;

	public JsonTransformerRewrite(JsonVisitor<? extends JsonElement> visitor) {
		this.visitor = visitor;
	}

	@Override
	public JsonElement apply(JsonElement json) {
		JsonElement repl = JsonWalker.visit(json, visitor);

		JsonElement result = super.apply(repl);
		return result;
	}

	@Override
	public JsonElement visit(JsonNull json) {
		return json;
	}

	@Override
	public JsonElement visit(JsonObject json) {
		JsonObject copy = new JsonObject();

		boolean hasChanged = false;
		for (Entry<String, JsonElement> entry : json.entrySet()) {
			String key = entry.getKey();
			JsonElement val = entry.getValue();

			JsonElement e = apply(val);
			if(e != val) {
				hasChanged = true;
			}

			copy.add(key, e);
		}

		JsonObject result = hasChanged ? copy : json;
		return result;
	}

	@Override
	public JsonElement visit(JsonArray json) {
		JsonArray copy = new JsonArray();

		boolean hasChanged = false;
		for (JsonElement item : json) {
			JsonElement e = apply(item);

			if(e != item) {
				hasChanged = true;
			}

			copy.add(e);
		}

		JsonArray result = hasChanged ? copy : json;
		return result;
	}

	@Override
	public JsonElement visit(JsonPrimitive json) {
		return json;
	}
}
