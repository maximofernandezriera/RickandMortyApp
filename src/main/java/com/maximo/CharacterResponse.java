package com.maximo;

import java.util.List;

public class CharacterResponse {
    private Info info;
    private List<Character> results;

    // Getters y setters

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}