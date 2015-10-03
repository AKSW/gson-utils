package org.aksw.gson.utils;

import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtils {
    public static JsonElement safeGet(JsonArray arr, int i) {
        JsonElement result = i < arr.size() ? arr.get(i) : null;
        return result;
    }

    public static Object safeGetObject(JsonArray arr, int i) {
        JsonElement tmp = safeGet(arr, i);
        Object result = JsonTransformerUtils.toJavaObject(tmp);
        return result;
    }

    /**
     * Add all entries of source to target. Does not perform a deep copy.
     * @param target
     * @param source
     * @return
     */
    public static JsonObject extend(JsonObject target, JsonObject source) {
        for(Entry<String, JsonElement> entry : source.entrySet()) {
            String key = entry.getKey();
            JsonElement val = entry.getValue();

            target.add(key, val);
        }

        return target;
    }

}
