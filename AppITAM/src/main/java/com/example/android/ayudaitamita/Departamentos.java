package com.example.android.ayudaitamita;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Stack;

public class Departamentos extends Activity {

    ConstraintLayout botones,materias;
    Button actu,admin,cpol,com,con,der,eco,est,egn,eint,iio,len,mat,sdi;
    TextView nombre;
    Stack<Integer> pilaPantallas;
    TextView textContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos);
        pilaPantallas=new Stack<Integer>();
        textContactos=this.findViewById(R.id.textContactos);
        nombre=this.findViewById(R.id.textViewNombre);


        botones=this.findViewById(R.id.LayoutBotones);
        materias=this.findViewById(R.id.LayoutMaterias);

        actu=this.findViewById(R.id.buttonACT);
        admin=this.findViewById(R.id.buttonADMIN);
        cpol=this.findViewById(R.id.buttonCPOL);
        com=this.findViewById(R.id.buttonCOM);
        con=this.findViewById(R.id.buttonCON);
        der=this.findViewById(R.id.buttonDER);
        eco=this.findViewById(R.id.buttonECO);
        est=this.findViewById(R.id.buttonEST);
        egn=this.findViewById(R.id.buttonEGN);
        eint=this.findViewById(R.id.buttonINT);
        iio=this.findViewById(R.id.buttonIIO);
        len=this.findViewById(R.id.buttonCLE);
        mat=this.findViewById(R.id.buttonMAT);
        sdi=this.findViewById(R.id.buttonSDI);

        actu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Actuaría y Seguros");
                textContactos.setText("Mercedes Gregorio Domínguez\n" +
                        "Directora de la Licenciatura en Actuaría\n" +
                        "Correo electrónico: mercedes@itam.mx\n");
                pilaPantallas.push(1);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Administración");
                textContactos.setText("Dra. Cecilia María Ortiz Ahlf\n" +
                        "Directora de la Licenciatura en Administración\n" +
                        "Correo electrónico: cecilia.ortiz@itam.mx\n");
                pilaPantallas.push(2);
            }
        });
        cpol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Ciencia Política");
                textContactos.setText("Jeffrey A. Weldon\n" +
                        "Director de la Licenciatura en Ciencia Política\n" +
                        "Correo electrónico: jweldon@itam.mx\n");
                pilaPantallas.push(3);
            }
        });
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Computación");
                textContactos.setText("Dra. Ana Lidia Franzoni Velázquez\n" +
                        "Directora del Programa de Ingeniería en Computación, Ingeniería en Mecatrónica e Ingeniería en Telecomunicaciones\n" +
                        "Correo electrónico: analidia@itam.mx\n");
                pilaPantallas.push(4);
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Contabilidad");
                textContactos.setText("M.A. Ana María Díaz Bonnet\n" +
                        "Directora de la Licenciatura en Contaduría Pública y Administración Financiera\n" +
                        "Correo electrónico: mdiaz@itam.mx\n");
                pilaPantallas.push(5);
            }
        });
        der.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Derecho");
                textContactos.setText("Mtra. Tania Gabriela Rodríguez Huerta\n" +
                        "Directora del Programa de Licenciatura en Derecho\n" +
                        "Correo electrónico: grodri@itam.mx\n");
                pilaPantallas.push(6);
            }
        });
        eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Economía");
                textContactos.setText("Germán Rojas\n" +
                        "Director de la Licenciatura en Economía\n" +
                        "Correo electrónico: rojas@itam.mx\n");
                pilaPantallas.push(7);
            }
        });
        est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Estadística");
                textContactos.setText("Rubén Hernández Cid\n" +
                        "Jefe del Departamento Académico de Estadística\n" +
                        "Teléfono: 5628 4000 ext. 3836\n" +
                        "Correo electrónico: hernande@itam.mx\n");
                pilaPantallas.push(8);
            }
        });
        egn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Estudios Generales");
                textContactos.setText("Mtro. José Ramón Benito Alzaga\n" +
                        "Director General de la División Académica de Estudios Generales y Estudios Internacionales\n" +
                        "Correo electrónico: rcalzada@itam.mx\n" +
                        "\n" +
                        "Martha Rosalía Calzada Cárdenas\n" +
                        "Asistente del Director General de la División Académica de Estudios Generales y Estudios Internacionales\n" +
                        "Correo electrónico: rcalzada@itam.mx\n" +
                        "Teléfono: 5628 4000 ext. 3900\n");
                pilaPantallas.push(9);
            }
        });
        eint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Estudios Internacionales");
                textContactos.setText("Mtro. José Ramón Benito Alzaga\n" +
                        "Director General de la División Académica de Estudios Generales y Estudios Internacionales\n" +
                        "Correo electrónico: rcalzada@itam.mx\n" +
                        "\n" +
                        "Martha Rosalía Calzada Cárdenas\n" +
                        "Asistente del Director General de la División Académica de Estudios Generales y Estudios Internacionales\n" +
                        "Correo electrónico: rcalzada@itam.mx\n" +
                        "Teléfono: 5628 4000 ext. 3900\n");
                pilaPantallas.push(10);
            }
        });
        iio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Ingeniería Industrial y Operaciones");
                textContactos.setText("Dr. Alejandro Terán Castellanos\n" +
                        "Director del Programa de Ingeniería Industrial\n" +
                        "Correo electrónico: ateran@itam.mx\n");
                pilaPantallas.push(11);
            }
        });
        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Lenguas");
                textContactos.setText("Rosa Margarita Galán Vélez\n" +
                        "Jefa del Departamento Académico de Lenguas\n" +
                        "Teléfono: 5628 4000 ext. 4093 5628 4093\n" +
                        "Correo electrónico: mgalan@itam.mx\n" +
                        "\n" +
                        "Carle: http://carle.itam.mx/\n");
                pilaPantallas.push(12);
            }
        });
        mat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Matemáticas");
                textContactos.setText("Dra. Beatriz Rumbos Pellicer\n" +
                        "Directora General de la División Académica de Actuaría, Estadística y Matemáticas\n" +
                        "Teléfono: 5490-4676\n" +
                        "Correo electrónico: rumbos@itam.mx\n" +
                        "\n" +
                        "Dr. Carlos Bosch Giral\n" +
                        "Jefe del Departamento Académico de Matemáticas\n" +
                        "Teléfono: 5628-4082\n" +
                        "Correo electrónico: bosch@itam.mx\n" +
                        "\n" +
                        "Trinidad Martínez Cornejo\n" +
                        "Secretaria del Departamento\n" +
                        "Teléfono: 5 628-4000 ext. 3804\n" +
                        "Correo electrónico: trinidad@itam.mx\n" +
                        "\n");
                pilaPantallas.push(13);
            }
        });
        sdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones.setVisibility(View.GONE);
                materias.setVisibility(View.VISIBLE);
                nombre.setText("Departamento Académico de Sistemas Digitales");
                textContactos.setText("Dra. Ana Lidia Franzoni Velázquez\n" +
                        "Directora del Programa de Ingeniería en Computación, Ingeniería en Mecatrónica e Ingeniería en Telecomunicaciones\n" +
                        "Correo electrónico: analidia@itam.mx\n");
                pilaPantallas.push(14);
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
            switch(anterior){
                case 1:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 7:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 8:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 9:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 10:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 11:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 12:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 13:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
                case 14:
                    materias.setVisibility(View.GONE);
                    botones.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}
