package com.example.axbx.cuadritos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

int x,y;
int COPIA_X1,COPIA_Y1,COPIA_X2,COPIA_Y2;

int Primera=0,x1,y1,x2,y2;
int contador=0;
int Transparente=0;




    @Override
    public boolean onTouchEvent(MotionEvent event) {



        x = (int)event.getX();
        y = (int)event.getY();


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:



                if(Primera==1) {
                    Transparente=0;
                    x2 = x;
                    y2 = y;


                    Paint paint = new Paint();
                    paint.setColor(Color.parseColor("#da4747"));
                    Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);

                    Canvas canvas = new Canvas(bg);
                    //canvas.drawRect(x, y, 200, 200, paint);
                    canvas.drawRect(x1, y1, x2, y2, paint);
                    LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
                    ll.setBackground(new BitmapDrawable(bg));

                }

                    if(Primera==0){

                        x1=x;
                        y1=y;

                        Primera=1;

                    }

                    if(contador==2){


                        Paint paint = new Paint();
                        Transparente=1;
                        paint.setColor(Color.TRANSPARENT);
                        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);

                         Canvas canvas = new Canvas(bg);

                        canvas.drawRect(x1, y1,x2, y2, paint);
                      LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
                        ll.setBackground(new BitmapDrawable(bg));


                        Primera=0;
                        contador=0;


                    //    Toast.makeText(this, "x",Toast.LENGTH_SHORT).show();
                        return false;

                    }




                contador++;




break;

            case MotionEvent.ACTION_MOVE:

            case MotionEvent.ACTION_UP:


        }


        Log.d("s","Valores x1:"+ x1+ "  y1:"+y1 + "  x2:"+x2+"  y2:"+y2+"  Contador:"+contador+"  Primera:"+Primera);






        //Toast.makeText(this, "x"+x +"y"+y,Toast.LENGTH_SHORT).show();





        return true;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#da4747"));
        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bg);
        //canvas.drawRect(x, y, 200, 200, paint);

        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackground(new BitmapDrawable(bg));


        final Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (Transparente != 1) {

                    if (COPIA_X1 != 0) {

                        Paint paint = new Paint();
                        paint.setColor(Color.parseColor("#da4747"));
                        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);

                        Canvas canvas = new Canvas(bg);
                        //canvas.drawRect(x, y, 200, 200, paint);
                        canvas.drawRect(COPIA_X1, COPIA_Y1, COPIA_X2, COPIA_Y2, paint);
                        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
                        ll.setBackground(new BitmapDrawable(bg));

                        clickButton.setText("Guardar Cuadro");

                        COPIA_X1 = 0;
                        COPIA_Y1 = 0;
                        COPIA_X2 = 0;
                        COPIA_Y2 = 0;
                    } else {
                        COPIA_X1 = x1;
                        COPIA_Y1 = y1;
                        COPIA_X2 = x2;
                        COPIA_Y2 = y2;

                        clickButton.setText("Restaurar Cuadro");

                    }

                }

            }

        });

    }






}
