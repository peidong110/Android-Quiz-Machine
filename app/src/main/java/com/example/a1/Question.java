package com.example.a1;

public class Question {
    private String mQuestion;
    private String mAnswer;
    private String usrSolution;
    private boolean score;
    private boolean isAnswered;
    private boolean addMarks;


    public Question(String aQuestionAnswerString){
        //aQuestionAnswerString is expected to be of the form:
        //"Is Java an Object-Oriented Language?[Yes]"
        int index = aQuestionAnswerString.indexOf("[");
        mQuestion = aQuestionAnswerString.substring(0,index);
        mAnswer = aQuestionAnswerString.substring(index+1,aQuestionAnswerString.length()-1);
        score = false;
        isAnswered = false;
        addMarks = false;
        usrSolution ="-1";
    }

    public boolean isAddMarks(){ return addMarks; }
    public void setAddMarks(boolean addMarks) { this.addMarks = addMarks; }
    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }
    public void setScore(boolean score) {
        this.score = score;
    }
    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }
    public boolean getScore(){
        return score;
    }
    public String getQuestion(){
        return mQuestion;
    }
    public String getAnswer(){
        return mAnswer;
    }
    public String getUsrSolution() { return usrSolution; }
    public void setUsrSolution(String usrSolution) { this.usrSolution = usrSolution; }
    public boolean isAnswered(){return isAnswered;}
    public void setAnswered(boolean answered) { isAnswered = answered; }

}