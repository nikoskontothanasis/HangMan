package com.example.hangman;

public class User {
	public String name;
	public int score;
	public User(String n, int s){
		name=n;
		score=s;
	}
	public String getName(){
		return name;
	}
	public int getScore(){
		return score;
	}

}
