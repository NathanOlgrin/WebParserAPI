package ru.olgrin.ports.out;

import java.util.List;

public interface ParserPort {
    List<String> parse(String url);
}
