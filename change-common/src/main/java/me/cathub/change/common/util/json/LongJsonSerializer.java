package me.cathub.change.common.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 后端传前端 Long 类型字段序列化为 json 时转为字符串类型，避免js丢失精度
 *
 * @author zhangYu
 */
public class LongJsonSerializer extends JsonSerializer<Long> {
    @Override
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        String text = (value == null ? null : String.valueOf(value));
        if (text != null) {
            jsonGenerator.writeString(text);
        }
    }
}