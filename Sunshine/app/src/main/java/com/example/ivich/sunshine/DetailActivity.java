package com.example.ivich.sunshine;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ShareActionProvider;

public class DetailActivity extends ActionBarActivity {
    String foreCastDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_detail, menu);
        MenuItem menuItem = menu.findItem(R.id.share_provider);

        ShareActionProvider sh = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        if(sh != null){
            sh.setShareIntent(createShareIntent());
        }
        return true;
    }



    private Intent createShareIntent(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        Intent intent = this.getIntent();
        foreCastDetail = intent.getStringExtra(Intent.EXTRA_TEXT);
        shareIntent.putExtra(Intent.EXTRA_TEXT,foreCastDetail + "#SunshineApp");
        return shareIntent;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent set = new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(set);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
