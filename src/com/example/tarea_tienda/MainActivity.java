package com.example.tarea_tienda;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	ArrayList<String> tiendas=null;
	ArrayAdapter<String> adapter;
	Intent intent=null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tiendas = new ArrayList<String>();
  
		tiendas.add("Tienda de Ropa");
		tiendas.add("Tienda de Zapatos");
		tiendas.add("Foto");

 		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tiendas);
        ListView lista = (ListView) findViewById(R.id.listView1);
        
        ActionBar actionbar = getSupportActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction arg1) {
				Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		for (int i = 0; i < 10; i++){
			actionbar.addTab(actionbar.newTab().setText("Tab " + i).setTabListener(tabListener));
		}
        
        lista.setAdapter(adapter);
        lista.setTextFilterEnabled(true);
        lista.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if(arg2==2){
					intent = new Intent(getApplicationContext(), Fotos.class);
					startActivity(intent);
				}else{
					intent = new Intent(getApplicationContext(), DetalleTiendas.class);
					intent.putExtra(DetalleTiendas.DETALLE, tiendas.get(arg2).toString());
					startActivity(intent);				}
			}
        });
        
      
	}

	

}