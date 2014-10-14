package com.example.thebattleship;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	GridLayout glay;
	TextView finalscore,name;
	ArrayList<Integer> positions;
	int j=0;
	ImageView ship1, ship2, ship3, ship4, ship5, ship6;
	GridLayout.LayoutParams layoutParams;
	String[][] boxes = new String[][]{new String[]{"edit1", "edit2","edit3","edit4","edit5","edit6"}, new String[]{"edit7","edit8","edit9","edit10","edit11","edit12"},new String[]{"edit13","edit14","edit15","edit16","edit17","edi18"},new String[]{"edit19", "edit20","edit21","edit22","edit23","edi24"},new String[]{"edit25", "edit26","edit27","edit28","edit29","edit30"},new String[]{"edit31", "edit32","edit33","edit34","edit35","edit36"}};
	String[] red_boxes = new String[]{"ship1", "ship2", "ship3", "ship4", "ship5"};
	ImageView[] ids=new ImageView[36];
	ImageView[] ships = new ImageView[6];
	Boolean ini_random=false;
	int cnt=0, score=100;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		positions=new ArrayList<Integer>();
		glay = (GridLayout) findViewById(R.id.container);
		name=(TextView)findViewById(R.id.name1);
		name.setText(name.getText().toString()+getIntent().getExtras().getString("name")+",");
		finalscore = (TextView) findViewById(R.id.score);
		
		glay.setTag(R.string.exists, "notfirst");
		for(int i=0; i<36; i++){
			String res="edit"+(i+1);
			int resId=getResources().getIdentifier(res, "id", getPackageName());
			ids[i]=((ImageView) findViewById(resId));
		}
		
		for(int j=0;j<red_boxes.length;j++){
			String res="ship" + (j+1);
			int resId = getResources().getIdentifier(res, "id", getPackageName());
			ships[j]=(ImageView) findViewById(resId);
		}
		
		for(int i=0; i<red_boxes.length; i++){
			ships[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					cnt++;
					glay.setTag(R.string.exists, "first");
					if(cnt==5){
						ini_random=true;
					}
					v.setVisibility(View.GONE);
				}
			});	
		}
		
		
		for(int i=0;i<ids.length;i++){
			ids[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "Your Ship has been delployed", Toast.LENGTH_SHORT).show();
					switch(v.getId()){
					case R.id.edit1:
						positions.add(1);
						break;
						
					case R.id.edit2:
						positions.add(2);
						break;
					case R.id.edit3:
						positions.add(3);
						break;
					case R.id.edit4:
						positions.add(4);
						break;
						
					case R.id.edit5:
						positions.add(5);
						break;
					case R.id.edit6:
						positions.add(6);
						break;
						
					case R.id.edit7:
						positions.add(7);
						break;
						
					case R.id.edit8:
						positions.add(8);
						break;
						
					case R.id.edit9:
						positions.add(9);
						break;
						
					case R.id.edit10:
						positions.add(10);
						break;
						
					case R.id.edit11:
						positions.add(11);
						break;
						
					case R.id.edit12:
						positions.add(12);
						break;
						
					case R.id.edit13:
						positions.add(13);
						break;
						
					case R.id.edit14:
						positions.add(14);
						break;
						
					case R.id.edit15:
						positions.add(15);
						break;
						
					case R.id.edit16:
						positions.add(16);
						break;
						
					case R.id.edit17:
						positions.add(17);
						break;
						
					case R.id.edit18:
						positions.add(18);
						break;
					case R.id.edit19:
						positions.add(19);
						break;
					case R.id.edit20:
						positions.add(20);
						break;
					case R.id.edit21:
						positions.add(21);
						break;
					case R.id.edit22:
						positions.add(22);
						break;
					case R.id.edit23:
						positions.add(23);
					case R.id.edit24:
						positions.add(24);
						break;
					case R.id.edit25:
						positions.add(25);
						break;
					case R.id.edit26:
						positions.add(26);
						break;
					case R.id.edit27:
						positions.add(27);
						break;
					case R.id.edit28:
						positions.add(28);
						break;
					case R.id.edit29:
						positions.add(29);
						break;
					case R.id.edit30:
						positions.add(30);
						break;
					case R.id.edit31:
						positions.add(31);
						break;
					case R.id.edit32:
						positions.add(32);
						break;
					case R.id.edit33:
						positions.add(33);
						break;
					case R.id.edit34:
						positions.add(34);
						break;
					case R.id.edit35:
						positions.add(35);
						break;
					case R.id.edit36:
						positions.add(36);
						break;	
						
					}
					if((glay.getTag(R.string.exists)).equals("first")){
						v.setVisibility(View.GONE);
						v.setBackgroundResource(R.drawable.layout_ships);
						v.setVisibility(View.VISIBLE);
						glay.setTag(R.string.exists, "notfirst");
						if(positions.size() == 5 && ini_random==true){
							startFiring();
						}
					}
				}
			});
		}
	}
	public int startRandom(){
		Random rand = new Random();
		int random = rand.nextInt(35);
		return random;
	}
	
	public void startFiring(){
		score=100;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=0;i<1000;i++){
			if(positions.size()>0){
				int rand = startRandom();
				int newrand = rand+1;
				if(numbers.contains(newrand)){
					score=score-10;
				}
				numbers.add(newrand);
				ids[rand].setVisibility(View.GONE);
				ids[rand].setBackgroundResource(R.drawable.layout_block);
				ids[rand].setVisibility(View.VISIBLE);
				for(int j=0; j<positions.size();j++){
					if(positions.get(j) == newrand){
						score = score-5;
						positions.remove(j);
						break;
					}
					else{	
						score=score+10;
					}
				}
			}
			else{
				finalscore.setText(finalscore.getText() + String.valueOf(score));
				break;
			}
		}
	}
}