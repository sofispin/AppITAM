package com.example.android.ayudaitamita;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.drawable.AnimationDrawable;
import android.widget.Toast;

import java.util.Stack;


public class MainActivity extends Activity {

    Button botonDepartamentos,botonServicios,botonRecordatorio;

    AnimationDrawable animationDrawable;
    ConstraintLayout screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonDepartamentos=this.findViewById(R.id.buttonDepartamentos);
        botonServicios=this.findViewById(R.id.buttonServicios);
        botonRecordatorio=this.findViewById(R.id.buttonRecordatorios);


        screen = (ConstraintLayout) findViewById(R.id.login_screen);

        //Animate gradient login screen
        animationDrawable = (AnimationDrawable) screen.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        botonDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Departamentos.class);
                startActivity(intent);

            }
        });

        botonServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Servicios.class);
                startActivity(intent);
            }
        });

        botonRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(),Recordatorios.class);
                startActivity(intent);
            }
        });
    }

}
