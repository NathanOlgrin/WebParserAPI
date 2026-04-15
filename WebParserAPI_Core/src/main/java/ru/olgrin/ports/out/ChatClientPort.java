package ru.olgrin.ports.out;

import ru.olgrin.ports.out.model.PreprocessedQuestion;

public interface ChatClientPort {

    String getAnswer(String prompt);
    PreprocessedQuestion preprocess(String question);
}
