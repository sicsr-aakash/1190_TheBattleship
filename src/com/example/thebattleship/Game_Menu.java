package com.example.thebattleship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class Game_Menu extends ActionBarActivity {
Button new_game;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.game_menu);
	
	new_game=(Button)findViewById(R.id.new_game);
	
	new_game.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent=new Intent(getApplicationContext(),Start_Screen.class);
			startActivity(intent);
			
		}
	});
	
	

	
}

}
