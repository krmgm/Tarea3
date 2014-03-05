package com.example.tarea_tienda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Fotos extends FragmentActivity {
	
	ListView listv;
	ArrayAdapter<String> adaptador;
	ArrayList<Photo> tienda;
	int position;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fotos);
		listv = (ListView) findViewById(R.id.listaComentario);
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
	
		this.recicbirInfo();
        ArrayList<Comment> coment = tienda.get(tienda.size()-1).getCommentList();
        for(int i=0;i<coment.size(); i++){
            adaptador.add(coment.get(i).toString());
        }		
		listv.setAdapter(adaptador);

     //   System.out.println(tienda.get(2).getListaComent().toString());
        
		

		
		
	}

	public void recicbirInfo(){
        StringBuffer datosString = new StringBuffer();
        BufferedReader leerString = null;
        try {
        	leerString = new BufferedReader(new InputStreamReader(getAssets().open(
                    "infoTienda.json")));
            String temp;
            while ((temp = leerString.readLine()) != null)
            	datosString.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            	leerString.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myjsonstring = datosString.toString();
        Gson gson = new Gson();
        Type typeStores = new TypeToken<List<Photo>>(){}.getType();
        tienda = gson.fromJson(myjsonstring, typeStores);  
    }
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);
		Uri uri = Uri.parse("android.resource://com.example.tarea_tienda/"+R.drawable.mall1);
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		intent.setType("image/jpeg");
		startActivity(Intent.createChooser(intent, getResources().getText(R.string.action_share)));
		return true;
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
