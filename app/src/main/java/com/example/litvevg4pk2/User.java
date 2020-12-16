package com.example.litvevg4pk2;

public class User {
    private String Name, State;
    private int Age;

    public int getStateSignal(){
        return StateSignal;
    }

    public void setStateSignal(int stateSignal){
        StateSignal = stateSignal;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setState(String state) {
        State = state;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public String getState() {
        return State;
    }

    public int getAge() {
        return Age;
    }

    public User(String name, String state, int age, int stateSignal) {
        Name = name;
        State = state;
        Age = age;
        StateSignal = stateSignal;
    }

    private int StateSignal;
}
