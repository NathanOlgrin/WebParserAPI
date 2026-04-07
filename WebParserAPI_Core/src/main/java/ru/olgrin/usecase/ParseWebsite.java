package ru.olgrin.usecase;

import java.util.List;

public interface ParseWebsite {

    List<String> execute(String url) throws Exception;
}
