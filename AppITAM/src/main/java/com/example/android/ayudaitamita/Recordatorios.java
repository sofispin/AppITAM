package com.example.android.ayudaitamita;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Stack;

public class Recordatorios extends Activity {

    Button botonAgregar,botonRegistrar;
    ListView listView;
    ConstraintLayout lista,agregar;
    Stack<Integer> pilaPantalla;
    EditText contenido;
    SimpleCursorAdapter sca;

    NotificationManager nm;
    NotificationChannel nc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorios);
        pilaPantalla=new Stack<Integer>();
        lista=this.findViewById(R.id.LayoutListView);
        agregar=this.findViewById(R.id.LayoutCreacion);
        listView=this.findViewById(R.id.ListView);
        botonAgregar = this.findViewById(R.id.buttonAgregar);
        botonRegistrar=this.findViewById(R.id.buttonRegistrar);
        contenido=this.findViewById(R.id.editTextContenido);

        nm=getSystemService(NotificationManager.class);
        nc=new NotificationChannel("canal1","Regresar",NotificationManager.IMPORTANCE_HIGH);
        nc.setDescription("Canal para regresar a la aplicación");
        nm.createNotificationChannel(nc);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.setVisibility(View.GONE);
                agregar.setVisibility(View.VISIBLE);
                pilaPantalla.push(1);
            }
        });

        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterfazBD iBD=new InterfazBD(v.getContext());
                String cont;
                cont=contenido.getText().toString();
                long res=iBD.insertarDatos(cont);
                contenido.setText("");
                String resultado="Llave primaria: "+res;
                Toast t = Toast.makeText(v.getContext(),resultado,Toast.LENGTH_LONG);
                t.show();
                cargarDatosLista(v.getContext());
                lista.setVisibility(View.VISIBLE);
                agregar.setVisibility(View.GONE);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                InterfazBD iBD=new InterfazBD(view.getContext());
                long res=iBD.borrarDato(id);
                Toast t = Toast.makeText(view.getContext(),"Se elimino elemento: "+res,Toast.LENGTH_LONG);
                t.show();
                lista.setVisibility(View.GONE);
                lista.setVisibility(View.VISIBLE);
                return false;
            }
        });

    }

    private void cargarDatosLista(Context contexto){
        String[] columnasSelect={"_id","contenido"};
        int[] columnasRenglon={R.id.textID,R.id.textContenido};
        InterfazBD iBD= new InterfazBD(contexto);
        Cursor lector=iBD.todosLosDatos();
        sca=new SimpleCursorAdapter(contexto,R.layout.formato_renglon,lector,columnasSelect,columnasRenglon,0);
        listView.setAdapter(sca);
    }

    @Override
    public void onBackPressed() {
        if(pilaPantalla.isEmpty()){
            super.onBackPressed();
        }
        else{
            Integer anterior=pilaPantalla.pop();
            switch(anterior){
                case 1:
                    lista.setVisibility(View.VISIBLE);
                    agregar.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    protected void onPause() {
        Intent intento=new Intent(this,MainActivity.class);
        intento.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendiente=PendingIntent.getActivity(this,0,intento,0);

        Notification.Builder fabrica=new Notification.Builder(this,"canal1")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Recuerda que tu puedes")
                .setContentText("La mafia del poder no descansa")
                .setAutoCancel(true)
                .setTimeoutAfter(10000)
                .setContentIntent(pendiente);
        nm.notify(500,fabrica.build());
        super.onPause();
    }
}
