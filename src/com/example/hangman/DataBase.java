package com.example.hangman;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
	private SQLiteDatabase database; 

	public DataBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	
		database=this.getWritableDatabase();	
		}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table players(name text,score int)");		
	}

	public ArrayList<User> getResults()
	{
		ArrayList<User> x=new ArrayList<User>();
		Cursor cursor=database.rawQuery("select * from players",null);
		if(cursor.getCount()==0)
		{
			cursor.close();
			return x;
		}
		int nameindex=cursor.getColumnIndex("name");
		int scoreindex=cursor.getColumnIndex("score");
		
		cursor.moveToFirst();
		do
		{
			User u;
			u=new User(cursor.getString(nameindex),
					cursor.getInt(scoreindex));
			x.add(u);
		}while(cursor.moveToNext());
		cursor.close();
		return x;
		
	}
	
	public void insert(String name,int score)
	{
		database.execSQL("insert into players(name,score) values('"+
				name+"',"+score+")");
	}
	
	public void delete(String name,int score)
	{
		database.execSQL("delete from players where name='"+name+"' and score="+score);
	}

	public void clearData()
	{
		database.execSQL("delete from players");
	}
	public void updateScore(String name,int score)
	{
		database.execSQL("update players set score=score+"+score+" where name='"+name+"'");
		
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table players");
		onCreate(db);		
	}

}
