package org.aksw.gson.utils;

import com.google.common.base.Function;
import com.google.gson.JsonElement;

public interface JsonTransformer<T>
	extends Function<JsonElement, T>
{
}
