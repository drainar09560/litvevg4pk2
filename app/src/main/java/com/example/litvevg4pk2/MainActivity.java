package com.example.litvevg4pk2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.litvevg4pk2.UserStaicInfo.POSITION;
import static com.example.litvevg4pk2.UserStaicInfo.users;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    LayoutInflater layoutInflater;

    FrameLayout UserPanel;
    static TextView NameTextView;
    static TextView StateTextView;
    static TextView AgeTextView;
    



    static UserListAdapter userListAdapter;
    private int positionActiveUser;

    public static void UpdateListAndUserPanel(User user) {
        userListAdapter.notifyDataSetChanged();
        InitPanel(user);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new UserStaicInfo();
        Init();

    }



    private void Init() {
        listView = findViewById(R.id.listView);
        context = this;
        layoutInflater = LayoutInflater.from(context);
        userListAdapter = new UserListAdapter();
        listView.setAdapter(userListAdapter);

        UserPanel = findViewById(R.id.userPanel);
        NameTextView = findViewById(R.id.NameTextView);
        StateTextView = findViewById(R.id.StateTextView);
        AgeTextView = findViewById(R.id.AgeTextView);

    }

    public void GoToUserProfile(int position){
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(POSITION, position);
        startActivity(intent);

    }


    public void BackToList(View view) {
        UserVisibility(false);
    }

    private void UserVisibility(boolean visible) {
        
        if(visible){
            UserPanel.setVisibility(View.VISIBLE);
        }
        else{
            UserPanel.setVisibility(View.GONE);
        }
    }

    public void EditUser(View view) {
        GoToUserProfile(positionActiveUser);
    }

    private class UserListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public User getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            User currentUser = getItem(position);
            convertView = layoutInflater.inflate(R.layout.item_user, parent, false);

            TextView nameView = convertView.findViewById(R.id.NameTextView);
            TextView stateView = convertView.findViewById(R.id.StateTextView);
            FrameLayout StateRound = convertView.findViewById(R.id.StateRound);

            switch(currentUser.getStateSignal()){
                case 0:
                    StateRound.setBackgroundResource(R.drawable.back_offline);
                    break;
                case 1:
                    StateRound.setBackgroundResource(R.drawable.back_online);
                    break;
                case 2:
                    StateRound.setBackgroundResource(R.drawable.back_departed);
                    break;
            }

            nameView.setText(currentUser.getName());
            stateView.setText(currentUser.getState());

            convertView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    positionActiveUser = position;
                    InitPanel(getItem(position));
                    UserVisibility(true);
                }
            });

            return convertView;
        }

    }

    private static void InitPanel(User item) {
        NameTextView.setText(item.getName());
        StateTextView.setText(item.getState());
        AgeTextView.setText(String.valueOf(item.getAge()));
    }
}