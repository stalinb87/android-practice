package com.gag.tarea1;

import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Content extends Activity implements android.view.View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		Intent intent = getIntent();		
		@SuppressWarnings("unchecked")
		HashMap<String, String> store = (HashMap<String, String>) intent.getSerializableExtra("store");
		
		TextView title = (TextView) findViewById(R.id.storeTitle);		
		title.setText(store.get("title"));	
		TextView address = (TextView) findViewById(R.id.storeAddress);
		address.setText(store.get("address"));
		//storeAddress
		
		TextView phonenumber = (TextView) findViewById(R.id.phonenumber);
		TextView email = (TextView) findViewById(R.id.email);
		TextView website = (TextView) findViewById(R.id.website);
		
		Button callBtn = (Button) findViewById(R.id.call);
		callBtn.setOnClickListener(this); 
		
		Button detailBtn = (Button) findViewById(R.id.detail);
		detailBtn.setOnClickListener(this);
		Linkify.addLinks(phonenumber, Linkify.ALL);
		Linkify.addLinks(email, Linkify.ALL);
		Linkify.addLinks(website, Linkify.ALL);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.call){
			String number = "tel:1809-515-2020";
			Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(number));
			startActivity(intent);
		} else if( v.getId() == R.id.detail ) {
			Intent intent = new Intent(this, DetailActivity.class);
			startActivity(intent);
		}
	}

	

	

}
