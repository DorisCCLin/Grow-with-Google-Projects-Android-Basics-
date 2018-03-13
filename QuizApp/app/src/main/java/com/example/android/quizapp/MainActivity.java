package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner Adapter
        Spinner mySpinner = (Spinner) findViewById(R.id.Q3dropDown);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Q3Array));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }


    int totalScore = 0;
    /**
     * question1 checking function
     */
    public int question1(boolean checkFantasticFox, boolean checkMoonrise, boolean checkNapoleon){
        if(checkFantasticFox && checkMoonrise){
            if (!checkNapoleon){
                totalScore += 1;
                Log.v("MyActivity" , "Score: "+ totalScore);
            } else {
                totalScore += 0;
                Log.v("MyActivity" , "Q1 no score");
            }
        } else{
            totalScore += 0;
            Log.v("MyActivity" , "Q1 no score");
        }
        return totalScore;
    }

    /**
     * question2 checking function
     */

    public int question2(int selectedId) {
        RadioButton year_2006 = (RadioButton) findViewById(R.id.year_2006);
        RadioButton year_1993 = (RadioButton) findViewById(R.id.year_1993);
        RadioButton year_1967 = (RadioButton) findViewById(R.id.year_1967);
        RadioButton year_1999 = (RadioButton) findViewById(R.id.year_1999);

        if(year_1993.getId() == selectedId){
            totalScore += 1;
            Log.v("MyActivity" , "Score: "+ totalScore);
        } else {
            totalScore += 0;
            Log.v("MyActivity" , "Q2 no score");
        }
        return totalScore;
    }

    /**
     * question3 checking function
     */

    public int question3(String guessName) {
        String answer = "Norma Jeane Mortenson";
        if( guessName.equalsIgnoreCase(answer) ){
            totalScore += 1;
            Log.v("MyActivity" , "Score: "+ totalScore);
        } else {
            totalScore += 0;
            Log.v("MyActivity" , "Q3 no score");
        }
        return totalScore;
    }




    /**
     * Check final result
     */

    public void checkResult(View view) {
        CheckBox fantasticFox = (CheckBox) findViewById(R.id.fantastic_fox);
        boolean checkFantasticFox = fantasticFox.isChecked();
        CheckBox moonrise = (CheckBox) findViewById(R.id.moonrise);
        boolean checkMoonrise = moonrise.isChecked();
        CheckBox napoleon = (CheckBox) findViewById(R.id.napoleon);
        boolean checkNapoleon = napoleon.isChecked();

        if (checkFantasticFox != null)

        // question1

        question1(checkFantasticFox, checkMoonrise, checkNapoleon );

        // question2
        RadioGroup jurassicPark = (RadioGroup) findViewById(R.id.jurassic_park);
        int selectedId = jurassicPark.getCheckedRadioButtonId();
        question2(selectedId);

        // question3
        EditText guessedName = (EditText) findViewById(R.id.guess_name);
        String guessName = guessedName.getText().toString();
        Log.v("MyActivity" , "text: "+ guessName);
        question3(guessName);


    }


}
