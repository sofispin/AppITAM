package com.example.android.ayudaitamita;

import android.os.Bundle;
import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Stack;

public class Servicios extends Activity {

    Button botonComunidad,botonGrace,botonMAQ,botonBDM,botonCalendario,botonMapaSTC,botonMapaITAM;
    ConstraintLayout LayoutOpciones,LayoutMapa,LayoutWebView,LayoutImagen;
    WebView paginas,mapas;
    ImageView imagen,imagenMapa;
    Stack<Integer> pilaPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        pilaPantallas=new Stack<Integer>();

        LayoutOpciones=this.findViewById(R.id.LayoutOpciones);
        LayoutMapa=this.findViewById(R.id.LayoutMapa);
        LayoutWebView=this.findViewById(R.id.LayoutWebView);
        LayoutImagen=this.findViewById(R.id.LayoutImagen);

        paginas=this.findViewById(R.id.WebViewPaginas);
        paginas.setWebViewClient(new ClienteWebView());
        paginas.getSettings().setJavaScriptEnabled(true);
        mapas=this.findViewById(R.id.WebViewMapas);
        mapas.setWebViewClient(new ClienteWebView());
        mapas.getSettings().setJavaScriptEnabled(true);

        botonComunidad=this.findViewById(R.id.buttonComunidad);
        botonGrace=this.findViewById(R.id.buttonGrace);
        botonMAQ=this.findViewById(R.id.buttonMAQ);
        botonBDM=this.findViewById(R.id.buttonBDM);
        botonCalendario=this.findViewById(R.id.buttonCalendario);
        botonMapaSTC=this.findViewById(R.id.buttonRed);
        botonMapaITAM=this.findViewById(R.id.buttonMapaITAM);

        imagen=this.findViewById(R.id.imageView);
        imagen.setImageResource(R.drawable.ayuda_itamita);
        imagenMapa=this.findViewById(R.id.imageViewMapas);


        //1 webview 2 mapa
        botonComunidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutWebView.setVisibility(View.VISIBLE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.GONE);
                LayoutImagen.setVisibility(View.GONE);
                paginas.loadUrl("https://comunidad.itam.mx");
                pilaPantallas.push(1);
            }
        });
        //2 Grace
        botonGrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutWebView.setVisibility(View.VISIBLE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.GONE);
                LayoutImagen.setVisibility(View.GONE);
                paginas.loadUrl("http://grace.itam.mx/EDSUP/twbkwbis.P_GenMenu?name=homepage");
                pilaPantallas.push(1);

            }
        });
        botonMAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutWebView.setVisibility(View.GONE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.VISIBLE);
                LayoutImagen.setVisibility(View.GONE);
                mapas.loadUrl("https://www.google.com/maps/dir/?api=1&origin=ITAM%2cMéxico&destination=Metro+Miguel+Angel+de+Quevedo&travelmode=driving");
                pilaPantallas.push(2);
            }
        });

        botonBDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutWebView.setVisibility(View.GONE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.VISIBLE);
                LayoutImagen.setVisibility(View.GONE);
                mapas.loadUrl("https://www.google.com/maps/dir/?api=1&origin=ITAM%2cMéxico&destination=Metro+Barranca+del+Muerto&travelmode=driving");
                pilaPantallas.push(2);
                    }
        });
        botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutImagen.setVisibility(View.VISIBLE);
                LayoutWebView.setVisibility(View.GONE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.GONE);
                imagenMapa.setImageResource(R.drawable.calendario_escolar);
                pilaPantallas.push(3);
            }
        });
        botonMapaSTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutImagen.setVisibility(View.VISIBLE);
                LayoutWebView.setVisibility(View.GONE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.GONE);
                imagenMapa.setImageResource(R.drawable.plano_metro);
                pilaPantallas.push(3);
            }
        });
        botonMapaITAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutImagen.setVisibility(View.VISIBLE);
                LayoutWebView.setVisibility(View.GONE);
                LayoutOpciones.setVisibility(View.GONE);
                LayoutMapa.setVisibility(View.GONE);
                imagenMapa.setImageResource(R.drawable.mapa_rio_hondo);
                pilaPantallas.push(3);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(pilaPantallas.isEmpty()){
            super.onBackPressed();
        }
        else{
            Integer anterior=pilaPantallas.pop();
            switch (anterior){
                case 1:
                    LayoutWebView.setVisibility(View.GONE);
                    LayoutOpciones.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    LayoutMapa.setVisibility(View.GONE);
                    LayoutOpciones.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    LayoutImagen.setVisibility(View.GONE);
                    LayoutOpciones.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

}

class ClienteWebView extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;
    }
}
