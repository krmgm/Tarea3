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
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class DetalleTiendas extends FragmentActivity {
	String mensaje;
	public static final String DETALLE = "detalle";
	TextView detalles;
	TextView lugar;
	TextView telefono;
	TextView hora;
	TextView web;
	TextView mail;
	String tel="";
	ListView listv;
	TextView textv;
	ArrayAdapter<String> adaptador;
	Button boton;
	List<Store> tienda;
	int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalle_tiendas);
		Intent intent=getIntent();
		String string=intent.getStringExtra(DETALLE).toString();
		
		listv = (ListView) findViewById(R.id.listView1);
		textv = (TextView) findViewById(R.id.edit1);
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		listv.setAdapter(adaptador);
		boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new OnClickListener() {
           
        	@Override
            public void onClick(View arg0) {
                    adaptador.add(textv.getText().toString());
                    adaptador.notifyDataSetChanged();
            }
    });
		
	
		
		detalles=(TextView) findViewById(R.id.textView1);
		lugar=(TextView) findViewById(R.id.textView2);
		telefono=(TextView) findViewById(R.id.textView3);
		hora=(TextView) findViewById(R.id.textView4);
		web=(TextView) findViewById(R.id.textView5);
		mail=(TextView) findViewById(R.id.textView6);
		
		if (string.equals("Tienda de Ropa")){
			position = 1;
			detalles.setText(string);
			Linkify.addLinks(detalles, Linkify.ALL);
			lugar.setText("19 Interpro Road Madison, AL 35758");
			Linkify.addLinks(lugar, Linkify.ALL);
			telefono.setText("20205090");
			tel="20205090";
			Linkify.addLinks(telefono, Linkify.ALL);
			hora.setText("7:00 a 5:00");
			Linkify.addLinks(hora, Linkify.ALL);
			web.setText("www.ropa.com");
			Linkify.addLinks(web, Linkify.ALL);
			mail.setText("ropa@fina.com");
			Linkify.addLinks(mail, Linkify.ALL);
		
	
		}else {
			position = 0;
			detalles.setText(string);
			Linkify.addLinks(detalles, Linkify.ALL);
			lugar.setText("17 Road Madison, AL 35650");
			Linkify.addLinks(lugar, Linkify.ALL);
			telefono.setText("78302598");
			tel="78302598";
			Linkify.addLinks(telefono, Linkify.ALL);
			hora.setText("7:00 a 5:00");
			Linkify.addLinks(hora, Linkify.ALL);
			web.setText("www.zapatos.com");
			Linkify.addLinks(web, Linkify.ALL);
			mail.setText("zapatos@rino.com");
			Linkify.addLinks(mail, Linkify.ALL);
					
		}
		Button llamar =(Button)findViewById(R.id.button1);
		llamar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent= new Intent(Intent.ACTION_DIAL);
			intent.setData(Uri.parse("tel:" + tel));
			startActivity(intent);
			}
		});
		
		this.recicbirInfo();
        ArrayList<Comment> coment = tienda.get(position).getListaComent();
        for(int i=0;i<coment.size(); i++){
            adaptador.add(coment.get(i).toString());
        }		
			
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.action_share) {
			mensaje = getString(R.string.datos_compartidos, detalles.getText().toString(), 
					            lugar.getText().toString(), telefono.getText().toString(),
					            hora.getText().toString(), web.getText().toString(), mail.getText().toString());
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.putExtra(Intent.EXTRA_TEXT, mensaje);
			intent.setType("text/plain");
			startActivity(Intent.createChooser(intent, getString(R.string.action_share)));
			return true;
			
					
			
		}
		return super.onOptionsItemSelected(item);
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
        Type typeStores = new TypeToken<List<Store>>(){}.getType();
        tienda = gson.fromJson(myjsonstring, typeStores);  
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
