package fatjar.implementations.json;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.runtime.Settings;
import fatjar.JSON;
import fatjar.Log;

import java.io.ByteArrayOutputStream;
import java.io.StringBufferInputStream;
import java.nio.charset.Charset;
import java.util.Optional;

public class DslJsonPlatform implements JSON {

    private final DslJson<Object> dslJson;

    public DslJsonPlatform() {
        dslJson = new DslJson<>(Settings.withRuntime().allowArrayFormat(true).includeServiceLoader());
    }

    public <T> Optional<T> fromJson(String json, Class<T> tClass) {
        try {
            T t = dslJson.deserialize(tClass, new StringBufferInputStream(json));
            return Optional.ofNullable(t);
        } catch (Exception e) {
            Log.error("got exception while creating object from json, exception: " + e, e);
            return Optional.empty();
        }
    }

    public Optional<String> toJson(Object object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dslJson.serialize(object, byteArrayOutputStream);
            String content = new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
            return Optional.ofNullable(content);
        } catch (Exception e) {
            System.out.println(">>> got exception while creating json string from object, exception: " + e);
            return Optional.empty();
        }
    }

}
