package com.example.hangman;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayTab extends Activity {
	LinearLayout mainLayout=null;
	TextView t=null;
	ImageView img=null;
	EditText name=null;
	Button b=null, ok=null,insertRecordName=null;
	
	public boolean isName(String x){
		
		if(x.length()==0) 
			return false;
		
		return true;
	}
  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mainLayout=new LinearLayout(this);
        mainLayout.setBackgroundResource(R.drawable.startpage);
        setContentView(mainLayout);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        
//        ImageView img=new ImageView(this);
//        img.setImageResource(R.drawable.mainimg1);
//		mainLayout.addView(img);
		
        t=new TextView(this);
        t.setText("HangMan 👻");
        t.setTextColor(Color.RED);
        t.setTextSize(55);
        mainLayout.addView(t);
        
        name=new EditText(this);
        name.setHint("Inset your username!");
        mainLayout.addView(name);
        
        insertRecordName=new Button(this);
        insertRecordName.setText("Play");
        mainLayout.addView(insertRecordName);
     
        insertRecordName.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				if(!isName(name.getText().toString()))
				{
					name.setText("");
					Toast.makeText(PlayTab.this, "Please first insert your username!",
							   Toast.LENGTH_LONG).show();
					
				}
				else{
					System.out.println("name ok");
				Intent I=new Intent(PlayTab.this,Game.class);
				I.putExtra("name", name.getText().toString());
				startActivity(I);}
				
			}
			
		});
        
    }
}