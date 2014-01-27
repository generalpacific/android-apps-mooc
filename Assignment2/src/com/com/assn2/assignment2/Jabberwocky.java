package com.com.assn2.assignment2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

@SuppressLint("SetJavaScriptEnabled")
public class Jabberwocky extends Activity {

	private MediaPlayer mPlayer = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		
	/*	mPlayer = MediaPlayer.create(this, R.raw.mp3clip);
		mPlayer.start();*/
		
		WebView webView = (WebView)findViewById(R.id.webView1);
		webView.setWebChromeClient(new WebChromeClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setDomStorageEnabled(true);
		webView.loadUrl("file:///android_asset/jabberwocky.html");
		
		// Set action for opening the image when the second button is clicked.
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String url = "http://en.wikipedia.org/wiki/Jabberwocky";
			    Intent i = new Intent(Intent.ACTION_VIEW);
			    i.setData(Uri.parse(url));
			    startActivity(i);
			}
		});
		
		// Set action for opening the image when the second button is clicked.
		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WebView webView = (WebView)findViewById(R.id.webView1);
				webView.loadUrl("file:///android_asset/jabberwockyOnButtonClick.html");				 		
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		mPlayer = MediaPlayer.create(this, R.raw.mp3clip);
		mPlayer.setLooping(true);
		mPlayer.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		if(mPlayer == null) {
			super.onPause();
			return;
		}
		mPlayer.stop();
		mPlayer.release();
		super.onPause();
	}
	
}
