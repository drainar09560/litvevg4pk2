package com.example.litvevg4pk2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.litvevg4pk2.Transform.parseIntOrDefault;
import static com.example.litvevg4pk2.UserStaicInfo.POSITION;
import static com.example.litvevg4pk2.UserStaicInfo.users;

public class UserActivity extends AppCompatActivity {

    private User activeUser;
    private EditText NameTextView;
    private EditText StateTextView;
    private EditText AgeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        int position = getIntent().getIntExtra(POSITION, 0);
        activeUser = users.get(position);
        Init();
        setUserInfo();
    }

    public void Back(View view){
        onBackPressed();
    }

    private void Init(){
        NameTextView = findViewById(R.id.NameTextView);
        StateTextView = findViewById(R.id.StateTextView);
        AgeTextView = findViewById(R.id.AgeTextView);
    }

    private void setUserInfo(){
        NameTextView.setText(activeUser.getName());
        StateTextView.setText(activeUser.getState());
        AgeTextView.setText(String.valueOf(activeUser.getAge()));
    }

    public void Save(View view) {
        activeUser.setName(NameTextView.getText().toString());
        activeUser.setState(StateTextView.getText().toString());
        String age = AgeTextView.getText().toString();
        activeUser.setAge(parseIntOrDefault(age, activeUser.getAge()));
        activeUser.setAge(Integer.parseInt(AgeTextView.getText().toString()));
        MainActivity.UpdateListAndUserPanel(activeUser);
        finish();
    }
}