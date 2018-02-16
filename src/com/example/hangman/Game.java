package com.example.hangman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
public class Game extends Activity{
	GridLayout mainlayout=null,l2=null;
	LinearLayout infolayout=null, playlayout=null;
	ScrollView scroll=null;
	Button a=null,b=null,c=null,d=null,e=null,f=null,g=null,h=null,i=null,j=null,
			k=null,l=null,m=null,n=null,o=null,p=null,q=null,r=null,s=null,t=null,y=null,
			u=null,x=null,v=null,w=null,z=null;
	TextView trys=null,Round=null,result=null,score=null,strText=null;
	int tries=5,round=1,word=0,myscore=0,cStars=1;
	DataBase db=null;
	String jword=null,currentWord=null, myname=null, correctWord=null, hideWord=null;
	JSONObject json=null;
	ArrayList<ListItemWord> item=null;
	ArrayList<String> strWord2 = new ArrayList<String>();
	String [] strWord={};
	ListView list=null;

	public String strHide(String s1){
		StringBuilder sB= new StringBuilder(s1);
		for(int i=1;i<=s1.length()-2;i++)
		{
			sB.setCharAt(i, '*');
			cStars=s1.length()-2;
		}
		return sB.toString();
	}
	
	public void play(char strL){
		boolean b=true;
		StringBuilder s= new StringBuilder(hideWord);
        for (int i=1;i<currentWord.length()-1;i++){
        	if(currentWord.charAt(i)==strL)
        	{
        		s.setCharAt(i, strL);
        		hideWord=s.toString();
        		strText.setText(hideWord);
        		cStars--;
        		myscore++;
        		score.setText("Your Score: "+myscore);
        		b=false;
        		
        	}
        }
       
        	if (cStars==0){
        		Toast.makeText(Game.this, "You WIN!",Toast.LENGTH_LONG).show();
        		NextRound();
        		db.updateScore(myname,myscore);
        		}
        	
        	if(b)
            	{
            		tries--;
            		trys.setText("Moves left: "+tries);
            }
        		
        
		if(tries==0){
		AlertDialog alertDialog = new AlertDialog.Builder(Game.this).create();
		alertDialog.setTitle("Game Over");
		alertDialog.setMessage("Sorry,Try one more time");
		alertDialog.setButton("Try Again", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
        	Intent I=new Intent(Game.this,MainActivity.class);
        	startActivity(I);
			}
			});
		alertDialog.show();
		}
        }

	
	public void NextRound(){
		round++;
		Round.setText("Round: "+round);
		setButtonVisible();
		selectWordRand();
		tries=5;
		trys.setText("Moves left: "+tries);
		
		
	}

	public void ClickButton(){
		
		a.setOnClickListener(new OnClickListener()
        {
        	char l='A';
        	public void onClick(View v) {
        	a.setVisibility(View.INVISIBLE);
    		play(l);

        }
        });
	 b.setOnClickListener(new OnClickListener()
        {
		 char l='B';
		 public void onClick(View v) {
			 b.setVisibility(View.INVISIBLE);		
			 play(l);

		 }
        });
	 c.setOnClickListener(new OnClickListener()
	 {
		 char l='C';
		 public void onClick(View v) {
			 
        	c.setVisibility(View.INVISIBLE);
        	play(l);
			 }
        });
	 d.setOnClickListener(new OnClickListener()
        {
		 char l='D';
		 public void onClick(View v) {
			
			 d.setVisibility(View.INVISIBLE);
			 play(l);
        }
        });
	 e.setOnClickListener(new OnClickListener()
	 {
		 char l='E';
		 public void onClick(View v) {
			 
			 e.setVisibility(View.INVISIBLE);
			 play(l);
		 }
        });
	 
	 f.setOnClickListener(new OnClickListener()
	 {
		 char l='F';
		 public void onClick(View v) {
			
			f.setVisibility(View.INVISIBLE);
			 play(l);
		 }
        });
	 
      g.setOnClickListener(new OnClickListener()
        {
			 char l='G';
			 public void onClick(View v) {
				 
				 g.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        h.setOnClickListener(new OnClickListener()
        {
			 char l='H';
			 public void onClick(View v) {
				
				 h.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        i.setOnClickListener(new OnClickListener()
        {
			 char l='I';
			 public void onClick(View v) {
				 
				 i.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        j.setOnClickListener(new OnClickListener()
        {
			 char l='J';
			 public void onClick(View v) {
				 
				 j.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
        });
        k.setOnClickListener(new OnClickListener()
        {
			 char l='K';
			 public void onClick(View v) {
				 
				 k.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        l.setOnClickListener(new OnClickListener()
        {
			 char el='L';
			 public void onClick(View v) {
				 
				 l.setVisibility(View.INVISIBLE);
				 play(el);
	        	}
	        });
        m.setOnClickListener(new OnClickListener()
        {
			 char l='M';
			 public void onClick(View v) {
				 
				 m.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        n.setOnClickListener(new OnClickListener()
        {
			 char l='N';
			 public void onClick(View v) {
				 
				 n.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        o.setOnClickListener(new OnClickListener()
        {
			 char l='O';
			 public void onClick(View v) {
				 
				 o.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        p.setOnClickListener(new OnClickListener()
        {
			 char l='P';
			 public void onClick(View v) {
				 
				 p.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        q.setOnClickListener(new OnClickListener()
        {
			 char l='Q';
			 public void onClick(View v) {			
				 
				 q.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        r.setOnClickListener(new OnClickListener()
        {
			 char l='R';
			 public void onClick(View v) {
				
				 r.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        s.setOnClickListener(new OnClickListener()
        {
			 char l='S';
			 public void onClick(View v) {
				
				 s.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        t.setOnClickListener(new OnClickListener()
        {
			 char l='T';
			 public void onClick(View v) {
				
				 t.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        u.setOnClickListener(new OnClickListener()
        {
			 char l='U';
			 public void onClick(View v) {
				 
				 u.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        v.setOnClickListener(new OnClickListener()
        {
			 char l='V';
			 public void onClick(View v) {
				 
				 v.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        w.setOnClickListener(new OnClickListener()
        {
			 char l='W';
			 public void onClick(View v) {
				 
				 w.setVisibility(View.INVISIBLE);
				 play(l);
	        	}
	        });
        x.setOnClickListener(new OnClickListener()
        {
			 char l='X';
			 public void onClick(View v) {
				 
	        	x.setVisibility(View.INVISIBLE);
	        	play(l);
	        	}

	        });
        y.setOnClickListener(new OnClickListener()
        {
			 char l='Y';
			 public void onClick(View v) {
				 
	        	y.setVisibility(View.INVISIBLE);
	        	play(l);
	        	}

	        });
        z.setOnClickListener(new OnClickListener()
        {
			 char l='Z';
			 public void onClick(View v) {
				
	        	z.setVisibility(View.INVISIBLE);
	        	 play(l);
	        	}

	        });
        
	}
	
	public void setButtonVisible(){
		a.setVisibility(View.VISIBLE);
        b.setVisibility(View.VISIBLE);
		c.setVisibility(View.VISIBLE);
		d.setVisibility(View.VISIBLE);
        e.setVisibility(View.VISIBLE);
        f.setVisibility(View.VISIBLE);
        g.setVisibility(View.VISIBLE);
	    h.setVisibility(View.VISIBLE);
	    i.setVisibility(View.VISIBLE);
	    j.setVisibility(View.VISIBLE);
	    k.setVisibility(View.VISIBLE);
	    l.setVisibility(View.VISIBLE);
	    m.setVisibility(View.VISIBLE);
	    n.setVisibility(View.VISIBLE);
	    o.setVisibility(View.VISIBLE);
	    p.setVisibility(View.VISIBLE);
	    q.setVisibility(View.VISIBLE);
	    r.setVisibility(View.VISIBLE);
	    s.setVisibility(View.VISIBLE);
	    t.setVisibility(View.VISIBLE);
	    u.setVisibility(View.VISIBLE);
	    v.setVisibility(View.VISIBLE);
	    w.setVisibility(View.VISIBLE);
	    x.setVisibility(View.VISIBLE);
	    y.setVisibility(View.VISIBLE);
	    z.setVisibility(View.VISIBLE);
	   
	}
	public void makeButtons(){
		
		a=new Button(this);
        a.setText("A");
        l2.addView(a);
        
        b=new Button(this);
        b.setText("B");
        l2.addView(b);
        
        c=new Button(this);
        c.setText("C");
        l2.addView(c);
         
        d=new Button(this);
        d.setText("D");
        l2.addView(d);
        
        e=new Button(this);
        e.setText("E");
        l2.addView(e);
        
        
        f=new Button(this);
        f.setText("F");
        l2.addView(f);
        
        g=new Button(this);
        g.setText("G");
        l2.addView(g);
       
        h=new Button(this);
        h.setText("H");
        l2.addView(h);
        
        i=new Button(this);
        i.setText("I");
        l2.addView(i);    
        
        j=new Button(this);
        j.setText("J");
        l2.addView(j);
        
        k=new Button(this);
        k.setText("K");
        l2.addView(k);  
        
        l=new Button(this);
        l.setText("L");
        l2.addView(l);
        
        m=new Button(this);
        m.setText("M");
        l2.addView(m);
        
        n=new Button(this);
        n.setText("N");
        l2.addView(n);
      
        o=new Button(this);
        o.setText("O");
        l2.addView(o);
        
        p=new Button(this);
        p.setText("P");
        l2.addView(p);
        
        q=new Button(this);
        q.setText("Q");
        l2.addView(q);     
        
        r=new Button(this);
        r.setText("R");
        l2.addView(r);
        
        s=new Button(this);
        s.setText("S");
        l2.addView(s);
        
        t=new Button(this);
        t.setText("T");
        l2.addView(t);
        
        u=new Button(this);
        u.setText("U");
        l2.addView(u);
        
        v=new Button(this);
        v.setText("V");
        l2.addView(v);
        
        w=new Button(this);
        w.setText("W");
        l2.addView(w);  
        
        x=new Button(this);
        x.setText("X");
        l2.addView(x); 
        
        y=new Button(this);
        y.setText("Y");
        l2.addView(y);
        
        z=new Button(this);
        z.setText("Z");
        l2.addView(z); 
   
      
		}
		
	public void loadJson2()
	{
		String url="http://niovi.aueb.gr/~p3120077/nikos/words2.json";
		if(url.length()==0) return ;
		StringBuilder builder = new StringBuilder();
	    HttpClient client = new DefaultHttpClient();
	    HttpGet httpGet = new HttpGet(url);
	    try {
	      HttpResponse response = client.execute(httpGet);
	      StatusLine statusLine = response.getStatusLine();
	      int statusCode = statusLine.getStatusCode();
	      if (statusCode == 200) {
	        HttpEntity entity = response.getEntity();
	        InputStream content = entity.getContent();
	        BufferedReader reader = new BufferedReader(new 
				InputStreamReader(content));
	        String line;
	        while ((line = reader.readLine()) != null) {
	          builder.append(line);
	        }
	      } else {
	      }
	    } catch (ClientProtocolException e1) {
	      e1.printStackTrace();
	      return ;
	    } catch (IOException e) {
	    	
	      e.printStackTrace();
	      return ;
	    }
	    try {
			json=new JSONObject(builder.toString());
		
			JSONArray items=json.getJSONArray("items");
			item=new ArrayList<ListItemWord>();
		
			for(int i=0;i<items.length();i++)
			{
				JSONObject ob=items.getJSONObject(i);
				strWord2.add(ob.getString("name"));
				strWord=strWord2.toArray(new String[strWord2.size()]);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
 
	public String selectWordRand(){
		Random K=new Random();
        int pos=Math.abs(K.nextInt() % strWord.length);
        currentWord=strWord2.get(pos);
        correctWord=currentWord;
        hideWord=strHide(currentWord);
		strText.setText(hideWord);
		
        return currentWord;
		
	}
	public void create(){

		mainlayout=new GridLayout(this);
		setContentView(mainlayout);
        mainlayout.setBackgroundResource(R.drawable.backround);
		scroll=new ScrollView(this);
		mainlayout.addView(scroll);
		l2=new GridLayout(this);
		scroll.addView(l2);
		l2.setOrientation(LinearLayout.VERTICAL);
		
		infolayout=new LinearLayout(this);
		mainlayout.addView(infolayout);
		infolayout.setOrientation(GridLayout.VERTICAL);
		
		trys=new TextView(this);
		trys.setText("Moves left: "+tries);
        trys.setTextColor(Color.RED);
        trys.setTextSize(15);
        
        result=new TextView(this);
		result.setText("Player: "+myname);
		result.setTextColor(Color.BLUE);
        result.setTextSize(20);
        
        Round=new TextView(this);
        Round.setText("Round: "+round);
        Round.setTextColor(Color.RED);
        Round.setTextSize(15);
        
        score=new TextView(this);
        score.setText("Your Score: "+myscore);
        score.setTextColor(Color.BLUE);
        score.setTextSize(20);
        
        infolayout.addView(result);
        infolayout.addView(score);
        infolayout.addView(trys);
        infolayout.addView(Round);
        
        playlayout=new LinearLayout(this);
        infolayout.addView(playlayout);
        
		strText=new TextView(this);
		strText.setText(strHide(selectWordRand()));
		strText.setTextSize(40);
		strText.setGravity(Gravity.CENTER);	
		playlayout.addView(strText);
		
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle=getIntent().getExtras();
		myname=bundle.getString("name");
		
		db=new DataBase(this, "players.db", null, 2);
		db.insert(myname, myscore);
		loadJson2();
		create();
		makeButtons();
		ClickButton();
		
		}
}