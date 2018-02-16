package com.example.hangman;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ScoreTab extends Activity {
	LinearLayout mainLayout=null;
	TextView t=null;
	TableLayout tableLayout=null;
	ScrollView scroll= null;
	Button orderbyname=null,orderbyscore=null,show=null,deleteall=null;
	ArrayList<User> result=new ArrayList<User>();
	DataBase db=null;
	
	public void table(){
		
		tableLayout=new TableLayout(this);
		ScrollView scroll=new ScrollView(this);
		mainLayout.addView(scroll);
		scroll.addView(tableLayout);
		TableRow r1=new TableRow(this);
		tableLayout.addView(r1);
		
		orderbyname=new Button(this);
		orderbyname.setText("Name");
		r1.addView(orderbyname);
		
		orderbyscore=new Button(this);
		orderbyscore.setText("Score");
		r1.addView(orderbyscore);
		orderbyscore.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v) {
				int i,j;
				for(i=0;i<result.size();i++)
				{
					for(j=0;j<result.size()-1;j++)
					{
						User u1=result.get(j);
						User u2=result.get(j+1);
						if(u1.score<u2.score)
						{
							result.set(j, u2);
							result.set(j+1, u1);
						}
					}
				}
				updateTable();
			}
			
		});
		orderbyname.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v) {
				int i,j;
				for(i=0;i<result.size();i++)
				{
					for(j=0;j<result.size()-1;j++)
					{
						User u1=result.get(j);
						User u2=result.get(j+1);
						if(u1.name.compareTo(u2.name)>0)
						{
							result.set(j, u2);
							result.set(j+1, u1);
						}
					}
				}
				updateTable();
				
			}
			
		});
		deleteall=new Button(this);
		deleteall.setText("Delete All Data");
		r1.addView(deleteall);
		deleteall.setOnClickListener(new OnClickListener()
		{

			public void onClick(View v) {
				db.clearData();
			
			}
		});
		
	}
	
	public void updateTable()
	{
		tableLayout.removeAllViews();
		table();
		for(int i=0;i<result.size();i++)
		{
			User u=result.get(i);
			TableRow r=new TableRow(this);
			tableLayout.addView(r);
			TextView t1,t3;
			t1=new TextView(this);
			t1.setText(u.name);
			t3=new TextView(this);
			t3.setText(""+u.score);
			r.addView(t1);
			r.addView(t3);
		}
	}
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DataBase(this, "players.db", null, 2);
        mainLayout=new LinearLayout(this);
        mainLayout.setBackgroundColor(Color.WHITE);
        setContentView(mainLayout);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
		
        t=new TextView(this);
        t.setText("The High Scores");
        t.setTextColor(Color.MAGENTA);
        t.setTextSize(45);
        mainLayout.addView(t);
       
        show=new Button(this);
		show.setText("Show Scores");
		mainLayout.addView(show);
		show.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				result=db.getResults();
				updateTable();
				
			}
			
		});
        table();
        
    }

}
