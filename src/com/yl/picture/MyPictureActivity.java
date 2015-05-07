package com.yl.picture;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TabHost;

public class MyPictureActivity extends TabActivity implements OnCheckedChangeListener{
	private TabHost mTabHost;
	private Intent mAIntent;
	private Intent mBIntent;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test", "test1");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        this.mAIntent = new Intent(MyPictureActivity.this,PingPuActivity.class);
        this.mBIntent = new Intent(MyPictureActivity.this,SuolueActivity.class);
		((RadioButton) findViewById(R.id.radio_button0))
		.setOnCheckedChangeListener(this);
		Log.i("test", "test2");
        ((RadioButton) findViewById(R.id.radio_button1))
		.setOnCheckedChangeListener(this);
        Log.i("test", "test3");
        setupIntent();
        
    }

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked){
			switch (buttonView.getId()) {
			case R.id.radio_button0:
				Log.i("test", "test9");
				this.mTabHost.setCurrentTabByTag("A_TAB");
				break;
			case R.id.radio_button1:
				Log.i("test", "test10");
				this.mTabHost.setCurrentTabByTag("B_TAB");
				break;
			
			}
		}
		
	}
	
	private void setupIntent() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;
		Log.i("test", "test5");
		localTabHost.addTab(buildTabSpec("A_TAB", R.string.pingpu,
				R.drawable.a1, this.mAIntent));
		Log.i("test", "test6");
		localTabHost.addTab(buildTabSpec("B_TAB", R.string.suolue,
				R.drawable.a2, this.mBIntent));
		Log.i("test", "test7");

	}
	
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
				getResources().getDrawable(resIcon)).setContent(content);
	}
}