package com.example.pacman;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity {

    int status =0;
    DisplayMetrics dm;
    int widht;
    int heigth;
    ImageView imgPacman;
    FrameLayout frameContenedor;
    ImageView imgFruta[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        frameContenedor = (FrameLayout)findViewById(R.id.contenedor);
        dm = getResources().getDisplayMetrics();
        widht = dm.widthPixels;
        heigth = dm.heightPixels;
        Log.e("#########", "Medidas: W: " +widht + " H: " + heigth);
        crearFrutas();
        crearPacman();
        crearBotones();
    }

    public void crearPacman(){

        int  wp = ((heigth/10)*2);
        imgPacman = new ImageView(this);
        imgPacman.setLayoutParams(new ViewGroup.LayoutParams(wp,wp)); // tamanio pacman
        imgPacman.setX((widht/2)-imgPacman.getLayoutParams().width/2);  //;
        imgPacman.setY((heigth/2)-imgPacman.getLayoutParams().height/2);
        imgPacman.setImageResource(R.drawable.pacman);
        frameContenedor.addView(imgPacman);

    }
    public void crearFrutas(){
        Random random = new Random();
        imgFruta = new ImageView[20];
        int  wf = ((heigth/10));
        int i =0;
        while (i < imgFruta.length){
            imgFruta[i] = new ImageView(this);
            imgFruta[i].setLayoutParams(new ViewGroup.LayoutParams(wf,wf)); // tamanio pacman
            int x = random.nextInt(widht);
            int y = random.nextInt(heigth);
            imgFruta[i].setX(x);
            imgFruta[i].setY(y);
            imgFruta[i].setImageResource(R.drawable.sandia);
            frameContenedor.addView(imgFruta[i]);
            imgFruta[i].setVisibility(View.INVISIBLE);
            i++;
        }
    }

    public void crearBotones(){

        int  wb = ((heigth/10)*2);
        ImageButton btnLeft = new ImageButton(this);
        btnLeft.setLayoutParams(new ViewGroup.LayoutParams(wb,wb)); // tamanio pacman
        btnLeft.setX(10);  //;
        btnLeft.setY(heigth-(btnLeft.getLayoutParams().height)*2);
        btnLeft.setImageResource(R.drawable.ic_direction);
        frameContenedor.addView(btnLeft);

        ImageButton btnRigth = new ImageButton(this);
        btnRigth.setLayoutParams(new ViewGroup.LayoutParams(wb,wb)); // tamanio pacman
        btnRigth.setX(10 + (btnRigth.getLayoutParams().width*2));  //;
        btnRigth.setY(heigth-(btnRigth.getLayoutParams().height)*2);
        btnRigth.setImageResource(R.drawable.ic_direction);
        btnRigth.setRotation(180);
        frameContenedor.addView(btnRigth);


        ImageButton btnUp = new ImageButton(this);
        btnUp.setLayoutParams(new ViewGroup.LayoutParams(wb,wb)); // tamanio pacman
        btnUp.setX(10 + (btnUp.getLayoutParams().width));  //;
        btnUp.setY(heigth-(btnUp.getLayoutParams().height)*3);
        btnUp.setImageResource(R.drawable.ic_direction);
        btnUp.setRotation(90);
        frameContenedor.addView(btnUp);


        ImageButton btnDown = new ImageButton(this);
        btnDown.setLayoutParams(new ViewGroup.LayoutParams(wb,wb)); // tamanio pacman
        btnDown.setX(10 + (btnDown.getLayoutParams().width));  //;
        btnDown.setY(heigth-(btnDown.getLayoutParams().height));
        btnDown.setImageResource(R.drawable.ic_direction);
        btnDown.setRotation(270);
        frameContenedor.addView(btnDown);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPacman.animate().translationX(0).setDuration(2000);
                imgPacman.setRotation(180);
            }
        });
        btnRigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPacman.animate().translationX(widht - imgPacman.getLayoutParams().width).setDuration(2000);
                imgPacman.setRotation(0);
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPacman.animate().translationY(0).setDuration(2000);
                imgPacman.setRotation(270);
            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPacman.animate().translationY( heigth- imgPacman.getLayoutParams().width).setDuration(2000);
                imgPacman.setRotation(90);
            }
        });

    }
}
