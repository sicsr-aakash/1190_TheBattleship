package com.example.thebattleship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Start_Screen extends Activity{

	Button start_game;
	TextView name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_screen);
		
		start_game=(Button)findViewById(R.id.start_game);
		name=(TextView)findViewById(R.id.editText2);
		
		start_game.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(getApplicationContext(),GameActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("name", name.getText().toString());
				intent.putExtras(bundle);
				startActivity(intent);
				
			}
		});
		
	}
}
