package com.example.doan;

public class Vocab {
    public String word;
    public String means;
    public String spelling;
    public String examp1;
    public String examp2;

    public Vocab(){};
    public Vocab(String word, String means, String spelling, String examp1, String examp2) {
        this.word = word;
        this.means = means;
        this.spelling = spelling;
        this.examp1 = examp1;
        this.examp2 = examp2;
    }
}