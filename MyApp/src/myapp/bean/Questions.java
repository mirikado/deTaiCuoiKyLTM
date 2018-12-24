/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.bean;

/**
 *
 * @author DVC_win10
 */
public class Questions {

    private String id;
    private String QuestionContent;
    private String A, B, C;
    private String result;

    public Questions() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionContent() {
        return QuestionContent;
    }

    public void setQuestionContent(String QuestionContent) {
        this.QuestionContent = QuestionContent;
    }

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Questions(String id, String QuestionContent, String A, String B, String C, String result) {
        this.id = id;
        this.QuestionContent = QuestionContent;
        this.A = A;
        this.B = B;
        this.C = C;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Questions{" + "id=" + id + ", QuestionContent=" + QuestionContent + ", A=" + A + ", B=" + B + ", C=" + C + ", result=" + result + '}';
    }

}
