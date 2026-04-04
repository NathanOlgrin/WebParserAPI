package ru.olgrin.usecase;

import java.util.List;

public interface ParseWebsiteUseCase {
    List<String> execute(String url) throws Exception;
}
