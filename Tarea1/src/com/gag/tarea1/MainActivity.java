package com.gag.tarea1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<HashMap<String, String>> listContent = new ArrayList<HashMap<String, String>>();
		SimpleAdapter adapter = new SimpleAdapter(this, 
				listContent, 
				android.R.layout.simple_list_item_2, 
				new String[]{"title","address"}, 
				new int[]{android.R.id.text1, android.R.id.text2});
		//ListView list = (ListView) findViewById(R.id.listView1);
		setListAdapter(adapter);
		
		for (int i = 0; i < 50; i++) {
			HashMap<String, String> element = new HashMap<String, String>();
			element.put("title", "Tienda "+i);
			element.put("address", "Calle "+i+" No "+i+1+ " + Cerca de por ahi");
			listContent.add(element);
		}
		adapter.notifyDataSetChanged();
		
	}

	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent intent = new Intent(this, Content.class);		
		@SuppressWarnings("unchecked")
		HashMap<String, String> store = (HashMap<String, String>) l.getItemAtPosition(position);
		intent.putExtra("store", store);		
		startActivity(intent);		
	}
	


}
