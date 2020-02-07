package com.example.a1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;
    private Button buttonE;
    private Button buttonPrev;
    private Button buttonSubmit;
    private Button buttonNext;
    private Button answer;
    private TextView questionBank;
    private int mCurrentQuestionIndex = 0;
    private int marks = 0;
    private int arrSize = 0;
    private ArrayList<Button> buttons;
    private ArrayList<Question> mQuestions;
    char arr[] = new char[10];
    String  buttonTextA;
    String  buttonTextB;
    String  buttonTextC;
    String  buttonTextD;
    String  buttonTextE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        invoke();
        addItems();

    }
    public void reset(){
        //call this function each time clicking prev and next button => reset all 5 buttons
        buttons.forEach((b) -> b.setEnabled(true));
    }
    public void addItems(){
        mQuestions.add(new Question(getString(R.string.question1)));
        mQuestions.add(new Question(getString(R.string.question2)));
        mQuestions.add(new Question(getString(R.string.question3)));
        mQuestions.add(new Question(getString(R.string.question4)));
        mQuestions.add(new Question(getString(R.string.question5)));
        mQuestions.add(new Question(getString(R.string.question6)));
        mQuestions.add(new Question(getString(R.string.question7)));
        mQuestions.add(new Question(getString(R.string.question8)));
        mQuestions.add(new Question(getString(R.string.question9)));
        mQuestions.add(new Question(getString(R.string.question10)));
        buttons.add(buttonA);
        buttons.add(buttonB);
        buttons.add(buttonC);
        buttons.add(buttonD);
        buttons.add(buttonE);
        buttonTextA = buttonA.getText().toString();
        buttonTextB = buttonB.getText().toString();
        buttonTextC = buttonC.getText().toString();
        buttonTextD = buttonD.getText().toString();
        buttonTextE = buttonE.getText().toString();
        //these five statements will return A,B,C,D,E respectively
        colorBtn();
        answer.setText(R.string.empty);
        questionBank.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
    }
    public void colorBtn(){
        buttons.forEach(b -> b.setBackgroundColor(Color.WHITE));
        buttonPrev.setBackgroundColor(Color.WHITE);
        buttonNext.setBackgroundColor(Color.WHITE);
        buttonSubmit.setBackgroundColor(Color.WHITE);

    }
    public void invoke(){
        questionBank = findViewById(R.id.questionBank);//text view
        answer = findViewById(R.id.answered);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        buttonE = findViewById(R.id.buttonE);
        buttonPrev = findViewById(R.id.buttonPrev);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonNext = findViewById(R.id.buttonNext);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonPrev.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        mQuestions = new ArrayList<>();
        buttons = new ArrayList<>();
        for (int i = 0;i<10;i++){
            arr[i] = ' ';//fill array with all empty
        }
    }
    public int countsMark(){
        //loop through mQuestions list and compare listClick and usrSolution
        for (Question eachQuestion: mQuestions){
            if(!eachQuestion.isAddMarks() &&eachQuestion.getAnswer().compareTo(eachQuestion.getUsrSolution()) == 0){
                // if string1 to string2
                marks++;
                eachQuestion.setAddMarks(true);//only add mark once
            }
            else if(eachQuestion.isAddMarks() && eachQuestion.getAnswer().compareTo(eachQuestion.getUsrSolution()) != 0){
                //if they're answered already, but solution is wrong, we then deduct from it
                marks--;
                eachQuestion.setAddMarks(false);
            }
        }
        System.out.println("Your total mark is "+ marks+"/ 10");
        return marks;
    }
    public void buttonSwitch(Button passedInBtn){
        passedInBtn.setEnabled(false);
        //this function is meant to let users know which button he/she is clicking right now
        for (Button b : buttons){
            if (b != passedInBtn)
                b.setEnabled(true);
            //if clicked then set button disabled
        }
    }


    @Override
    public void onClick(View v) {
        //do things here
        switch (v.getId()){
            case R.id.buttonA:
                arr[mCurrentQuestionIndex] = 'A';
                buttonSwitch(buttonA);

                if(!mQuestions.get(mCurrentQuestionIndex).isAnswered() &&mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("A")){
                    mQuestions.get(mCurrentQuestionIndex).setAnswered(true);
                    mQuestions.get(mCurrentQuestionIndex).setScore(true);
                    System.out.println("If statement -> Question being set to Option A ");
                }
                //the click before , if solution == setUsrSolution then we consider it correct.
                mQuestions.get(mCurrentQuestionIndex).setUsrSolution("A");
                System.out.println("out side if statement ->The problem is answered already? A is clicked"+ "usrSelection :"+mQuestions.get(mCurrentQuestionIndex).getUsrSolution());
                System.out.println("Score: false is no, true is yes: "+mQuestions.get(mCurrentQuestionIndex).getScore());
                break;
            case R.id.buttonB:
                buttonSwitch(buttonB);
                arr[mCurrentQuestionIndex] = 'B';
                if(!mQuestions.get(mCurrentQuestionIndex).isAnswered()&&mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("B")){
                    mQuestions.get(mCurrentQuestionIndex).setAnswered(true);
                    mQuestions.get(mCurrentQuestionIndex).setScore(true);
                    System.out.println("If statement -> Question being set to Option B ");
                }
                mQuestions.get(mCurrentQuestionIndex).setUsrSolution("B");
                System.out.println("out side if statement ->The problem is answered already? B is clicked"+ "usrSelection :"+mQuestions.get(mCurrentQuestionIndex).getUsrSolution());
                System.out.println("Score: false is no, true is yes: "+mQuestions.get(mCurrentQuestionIndex).getScore());
                break;
            case R.id.buttonC:
                buttonSwitch(buttonC);
                arr[mCurrentQuestionIndex] = 'C';

                if(!mQuestions.get(mCurrentQuestionIndex).isAnswered()&&mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("C")){
                    mQuestions.get(mCurrentQuestionIndex).setAnswered(true);
                    mQuestions.get(mCurrentQuestionIndex).setScore(true);
                    System.out.println("If statement -> Question being set to Option C ");
                }
                mQuestions.get(mCurrentQuestionIndex).setUsrSolution("C");
                System.out.println("out side if statement ->The problem is answered already? C is clicked"+ "usrSelection :"+mQuestions.get(mCurrentQuestionIndex).getUsrSolution());
                System.out.println("Score: false is no, true is yes: "+mQuestions.get(mCurrentQuestionIndex).getScore());
                break;
            case R.id.buttonD:
                buttonSwitch(buttonD);
                arr[mCurrentQuestionIndex] = 'D';
                if(!mQuestions.get(mCurrentQuestionIndex).isAnswered() &&mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("D")){
                    mQuestions.get(mCurrentQuestionIndex).setAnswered(true);
                    mQuestions.get(mCurrentQuestionIndex).setScore(true);
                    System.out.println("If statement -> Question being set to Option D ");
                }
                mQuestions.get(mCurrentQuestionIndex).setUsrSolution("D");
                System.out.println("out side if statement ->The problem is answered already? D is clicked"+ "usrSelection :"+mQuestions.get(mCurrentQuestionIndex).getUsrSolution());
                System.out.println("Score: false is no, true is yes: "+mQuestions.get(mCurrentQuestionIndex).getScore());
                break;
            case R.id.buttonE:
                buttonSwitch(buttonE);
                arr[mCurrentQuestionIndex] = 'E';
                if(!mQuestions.get(mCurrentQuestionIndex).isAnswered() &&mQuestions.get(mCurrentQuestionIndex).getAnswer().equals("E")){
                    mQuestions.get(mCurrentQuestionIndex).setAnswered(true);
                    mQuestions.get(mCurrentQuestionIndex).setScore(true);
                    System.out.println("If statement -> Question being set to Option E ");
                }
                mQuestions.get(mCurrentQuestionIndex).setUsrSolution("E");
                System.out.println("out side if statement ->The problem is answered already? E is clicked"+ "usrSelection :"+mQuestions.get(mCurrentQuestionIndex).getUsrSolution());
                System.out.println("Score: false is no, true is yes: "+mQuestions.get(mCurrentQuestionIndex).getScore());
                break;
            case R.id.buttonPrev:
                buttons.forEach(b ->
                        b.setBackgroundColor(Color.WHITE));
                reset();//reset button to make it clickable every time you click next
                System.out.println(Arrays.toString(arr));
                if (mCurrentQuestionIndex == 0){
                    System.out.println("Do nothing");
                }
                else{
//                    buttons.get(mCurrentQuestionIndex-1).setBackgroundColor(Color.RED);
                    answer.setText(arr[mCurrentQuestionIndex-1]+"");
                    String a = Character.toString(arr[mCurrentQuestionIndex-1]);
                    if (a.equals(buttonTextA))
                        buttonA.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextB))
                        buttonB.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextC))
                        buttonC.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextD))
                        buttonD.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextE))
                        buttonE.setBackgroundColor(Color.RED);
                }
                mCurrentQuestionIndex--; //potential crash here when click prev on question #1
                if(mCurrentQuestionIndex < 1){
                    Toast.makeText(MainActivity.this,
                            R.string.reach_beginning,
                            Toast.LENGTH_SHORT).show();
                    mCurrentQuestionIndex = 0;
                }
                else{
                    Toast.makeText(MainActivity.this,
                            R.string.prev_problem,
                            Toast.LENGTH_SHORT).show();
                }
                questionBank.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                break;
            case R.id.buttonSubmit:
                Toast.makeText(this, String.valueOf("Your mark is: "+countsMark())+" /10",Toast.LENGTH_LONG).show();
                System.out.println("Submit is clicked");
                break;
            case R.id.buttonNext:
                buttons.forEach(b ->
                        b.setBackgroundColor(Color.WHITE));

                if (mCurrentQuestionIndex == 9)
                    System.out.println("Do nothing");
                else {
                    answer.setText(arr[mCurrentQuestionIndex + 1] + "");
                    String a = Character.toString(arr[mCurrentQuestionIndex+1]);
                    if (a.equals(buttonTextA))
                        buttonA.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextB))
                        buttonB.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextC))
                        buttonC.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextD))
                        buttonD.setBackgroundColor(Color.RED);
                    else if(a.equals(buttonTextE))
                        buttonE.setBackgroundColor(Color.RED);
                }
                reset();//reset button to make it clickable every time you click next
                System.out.println(Arrays.toString(arr));
                Toast.makeText(MainActivity.this,
                        R.string.next_problem,
                        Toast.LENGTH_SHORT).show();
                mCurrentQuestionIndex++;
                if(mCurrentQuestionIndex >= mQuestions.size()) mCurrentQuestionIndex = 0;
                questionBank.setText(mQuestions.get(mCurrentQuestionIndex).getQuestion());
                System.out.println("Next is clicked");
                break;


        }
    }
}
