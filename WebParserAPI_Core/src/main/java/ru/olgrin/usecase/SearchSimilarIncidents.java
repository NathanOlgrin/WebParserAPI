package ru.olgrin.usecase;

import java.util.List;

public interface SearchSimilarIncidents {
    List<String> execute(String query, int limit);
}
