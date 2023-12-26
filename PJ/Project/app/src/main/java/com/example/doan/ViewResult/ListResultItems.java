package com.example.doan.ViewResult;

public class ListResultItems {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String result;
    private int pos;
    public ListResultItems(String question, String ans1, String ans2, String ans3, String ans4, String result, int pos) {
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.result = result;
        this.pos = pos;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAns1() {
        return this.ans1;
    }

    public String getAns2() {
        return this.ans2;
    }

    public String getAns3() {
        return this.ans3;
    }

    public String getAns4() {
        return this.ans4;
    }

    public String getResult() {
        return this.result;
    }
    public int getPos() {
        return this.pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
}
