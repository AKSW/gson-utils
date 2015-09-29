package org.aksw.gson.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonRewriterBase
    implements JsonRewriter, JsonVisitor<JsonElement>
{
    @Override
    public JsonElement apply(JsonElement input) {
        return null;
    }

    @Override
    public JsonElement visit(JsonNull json) {
        return null;
    }

    @Override
    public JsonElement visit(JsonObject json) {
        return null;
    }

    @Override
    public JsonElement visit(JsonArray json) {
        return null;
    }

    @Override
    public JsonElement visit(JsonPrimitive json) {
        return null;
    }
}
