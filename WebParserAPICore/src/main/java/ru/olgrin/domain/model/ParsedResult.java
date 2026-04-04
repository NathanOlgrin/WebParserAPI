package ru.olgrin.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsedResult {

private Map<String, List<String>> fields = new HashMap<>();

    public void put(String key, List<String> value){
        fields.put(key, value);
    }

    public List<String> get(String key){
        return fields.get(key);
    }

    public Map<String, List<String>> getAll(){
        return fields;
    }
}
