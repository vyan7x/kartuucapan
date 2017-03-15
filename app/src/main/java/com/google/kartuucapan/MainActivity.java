package com.google.kartuucapan;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    MediaPlayer audioBackground; //Definisi media Player
    ToggleButton myToggle; // Definisi Toogle Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToggle = (ToggleButton) findViewById(R.id.toggleSound); //Definisi On Create
        audioBackground = MediaPlayer.create(this, R.raw.lagu1);//Panggil lagu yang telah ada di raw
        audioBackground.setLooping(true); //atur supaya looping lagu
        audioBackground.setVolume(1,1); //atus supaya ada suara
        audioBackground.start();//mulai audio
    }
    public void onToggleClicked(View view) { //Definisi dengan standar if else
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            audioBackground.setVolume(0, 0);//matikan lagu
        } else {
            audioBackground.setVolume(1, 1);//hidupkan kembali audio
        }
    }
    @Override
    public void onBackPressed() {
        audioBackground.stop();
        MainActivity.this.finish();
        System.exit(0);
    }

}