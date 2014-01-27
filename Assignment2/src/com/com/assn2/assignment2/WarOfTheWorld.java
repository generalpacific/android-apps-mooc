package com.com.assn2.assignment2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WarOfTheWorld extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_war_of_the_world);
		
		WebView webView = (WebView)findViewById(R.id.webView1);
		webView.setWebChromeClient(new WebChromeClient());
		webView.getSettings().setDomStorageEnabled(true);
		webView.loadUrl("file:///android_asset/waroftheworlds.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.war_of_the_world, menu);
		return true;
	}

}
