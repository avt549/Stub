package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;

public class Helpers {
    public Map<String,Object> user(Integer id, String name, String grade) {
        Map<String,Object> user = new HashMap<>();
        user.put("id",id);
        user.put("name",name);
        user.put("grade",grade);
        return user;
    }
    public static <T> String buildJSONFromObject(T object) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonString;
        try {
            jsonString = gson.toJson(object);
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
            jsonString = "";
        }
        return jsonString;
    }
}
