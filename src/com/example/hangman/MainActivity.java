package com.example.hangman;
import android.R.color;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity{
	private TabHost tabs=null;
	private TabSpec playtab=null, scoretab=null;
	ImageView im1=null, im3=null;
	

	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new 
                StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.tab);
		tabs=(TabHost)findViewById(android.R.id.tabhost);       
        tabs.setup();
        //tabs.setBackgroundResource(R.drawable.bar);
        tabs.setBackgroundColor(color.background_dark);
        Display display = getWindowManager().getDefaultDisplay(); 
	    Global.width = display.getWidth();  
	    Global.height = display.getHeight();
	    Global.TabHeight=Global.height/10;
        Global.TabWidth=Global.width/3;
        im1=new ImageView(this);
        im3=new ImageView(this);
        Bitmap bm1,bm3;
        bm1=BitmapFactory.decodeResource(getResources(), R.drawable.play);
        bm1=Bitmap.createScaledBitmap(bm1, Global.TabWidth, Global.TabHeight, true);
        
        bm3=BitmapFactory.decodeResource(getResources(), R.drawable.score);
        bm3=Bitmap.createScaledBitmap(bm3, Global.TabWidth, Global.TabHeight, true);
        im1.setImageBitmap(bm1);
        im3.setImageBitmap(bm3);
        playtab = tabs.newTabSpec("PLAY");
        playtab.setIndicator(im1);
        Intent firstIntent = new Intent(this, PlayTab.class);
        playtab.setContent(firstIntent);
        scoretab = tabs.newTabSpec("SCORE");
        scoretab.setIndicator(im3);
        Intent secondIntent = new Intent(this, ScoreTab.class);
        scoretab.setContent(secondIntent);
        tabs.addTab(playtab);
        tabs.addTab(scoretab);
        
        for(int i=0;i<tabs.getTabWidget().getChildCount();i++)
        {
        	tabs.getTabWidget().getChildAt(i).getLayoutParams().height =Global.TabHeight;
   
        }
		
	}
	
	
	
}
