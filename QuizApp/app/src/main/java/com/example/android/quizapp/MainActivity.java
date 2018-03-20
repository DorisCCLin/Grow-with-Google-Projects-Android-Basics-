package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
     * question4 checking function
     */

    public int question4(String userAnswer) {
        String answer = "Return of the Jedi";
        if( userAnswer.equalsIgnoreCase(answer) ){
            totalScore += 1;
            Log.v("MyActivity" , "Score: "+ totalScore);
        } else {
            totalScore += 0;
            Log.v("MyActivity" , "Q4 no score");
        }
        return totalScore;
    }

    /**
     * question5 checking function
     */

    public int question5(int selectedId) {
        RadioButton toto = (RadioButton) findViewById(R.id.toto);
        RadioButton george = (RadioButton) findViewById(R.id.george);
        RadioButton abu = (RadioButton) findViewById(R.id.abu);

        if(abu.getId() == selectedId){
            totalScore += 1;
            Log.v("MyActivity" , "Score: "+ totalScore);
        } else {
            totalScore += 0;
            Log.v("MyActivity" , "Q5 no score");
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

        RadioGroup jurassicPark = (RadioGroup) findViewById(R.id.jurassic_park);
        int selectedId = jurassicPark.getCheckedRadioButtonId();
        EditText guessedName = (EditText) findViewById(R.id.guess_name);
        String guessName = guessedName.getText().toString();
        Spinner mySpinner = (Spinner) findViewById(R.id.Q3dropDown);
        String userAnswer = mySpinner.getSelectedItem().toString();
        RadioGroup aladdin = (RadioGroup) findViewById(R.id.aladdin);
        int obtainedId = aladdin.getCheckedRadioButtonId();

        if((!checkFantasticFox && !checkMoonrise && !checkNapoleon) || (selectedId == 0) ||(guessName.equals("")) || (userAnswer.equals("Select an answer"))||(obtainedId == 0)){
            Toast.makeText(MainActivity.this, "You got answer all the questions", Toast.LENGTH_LONG).show();

        } else{
            question1(checkFantasticFox, checkMoonrise, checkNapoleon );
            question2(selectedId);
            question3(guessName);
            question4(userAnswer);
            question5(obtainedId);
            LinearLayout resultArea = (LinearLayout) findViewById(R.id.result_area);
            Button submit = (Button) findViewById(R.id.submit);
            EditText userName = (EditText) findViewById(R.id.name_text);
            TextView result_text  = findViewById(R.id.result_text);
            String user_name = userName.getText().toString();
            resultArea.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);
            String msg = resultMessage(user_name);
            result_text.setText(msg);

        }
    }

    public String resultMessage (String name){
        ImageView resultImg = (ImageView) findViewById(R.id.result_image);
        String msg;
        if(totalScore <=1){
            msg = name + ", you are a movie hater, ain't you?";
            resultImg.setImageResource(R.drawable.help);
        } else if (totalScore <=3){
            msg = name + ", almost there, keep going!";
            resultImg.setImageResource(R.drawable.keep);
        } else{
            msg = name + ", you are a true expert.";
            resultImg.setImageResource(R.drawable.expert);
        }
        return msg;
    }




    public void reset (View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
