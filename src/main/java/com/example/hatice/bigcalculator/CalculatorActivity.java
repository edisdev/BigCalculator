package com.example.hatice.bigcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class CalculatorActivity extends AppCompatActivity {

  Button plus,minus,multiply,split,pow,sqrt, reserve,gcd,lcm,fac,mod,prime,clear;
   EditText result;
   BigDecimal number1,number2;
   TextView digits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        plus= (Button)findViewById(R.id.plus);
        minus=(Button)findViewById(R.id.minus);
        multiply= (Button)findViewById(R.id.mutlipy);
        split=(Button)findViewById(R.id.split);
        pow= (Button)findViewById(R.id.pow);
        sqrt=(Button)findViewById(R.id.sqrt);
        reserve = (Button)findViewById(R.id.resevre);
        gcd=(Button)findViewById(R.id.gcd);
        lcm= (Button)findViewById(R.id.lcm);
        fac=(Button)findViewById(R.id.factoriel);
        mod= (Button)findViewById(R.id.mod);
        prime=(Button)findViewById(R.id.prime);
        clear=(Button)findViewById(R.id.clear);
       result=(EditText)findViewById(R.id.result);
        digits = (TextView)findViewById(R.id.digits);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());


               BigDecimal total= number1.add(number2) ;
                String res= total.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                    len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                digits.setText(len);
                result.setText(res);

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());

                BigDecimal sub= number1.subtract(number2);
                String res= sub.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                digits.setText(len);
                result.setText(res);

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());

                BigDecimal malty= number1.multiply(number2);
                String res= malty.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                    len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                digits.setText(len);
                result.setText(res);

            }
        });

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());

                BigDecimal sp= number1.divide(number2,10, RoundingMode.CEILING);

                String res= sp.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                    len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                digits.setText(len);
                result.setText(res);
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());


                BigDecimal sp= BigDecimal.valueOf(1).divide(number1,1000,RoundingMode.CEILING);

                String res= sp.toString();
                result.setText(res);
            }
        });
        gcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());


                BigDecimal bignumber=number1.max(number2),gcdnumber=null;

                BigDecimal i=BigDecimal.ONE;
                while (!i.equals(bignumber))
                {
                    if(((number1.remainder(i)).equals(BigDecimal.ZERO))&&((number2.remainder(i)).equals(BigDecimal.ZERO)))
                    {
                        gcdnumber=i;

                    }

                 i= i.add(BigDecimal.ONE);
                }


                String res= gcdnumber.toString();
                digits.setText("");
                result.setText(res);
            }
        });

        lcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2 = new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());

                BigDecimal bignumber= number1.multiply(number2);
                BigDecimal i= bignumber;
                BigDecimal a= number1.max(number2);
                BigDecimal lcm=null;
                while (!i.equals(a))
                {
                    if(((i.remainder(number1)).equals(BigDecimal.ZERO))&&((i.remainder(number2)).equals(BigDecimal.ZERO)))
                    {
                      lcm = i;
                    }

                    i=i.subtract(BigDecimal.ONE);
                }

                String res= lcm.toString();
                digits.setText("");
                result.setText(res);
            }
        });

     pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
               if((((EditText)findViewById(R.id.sayi2)).getText().toString().length())>12)
               {
                   String rs="Hesaplama Süresi Mobil İçin Çok Fazla Süreceğinden , daha küçük bir sayı giriniz";
                   result.setText(rs);
               }
                else{
                   int number2= Integer.parseInt(((EditText)findViewById(R.id.sayi2)).getText().toString());

                   Toast.makeText(getApplicationContext(),"SAYI HESAPLANDI",Toast.LENGTH_LONG).show();

                BigDecimal sr= number1.pow(number2);
                String res= sr.toString();
                   char[] s=res.toCharArray();
                   int dg1=0;
                   for(int i=0;i<res.length();i++)
                   {
                       dg1++;
                       if(s[i]=='.') {break;}

                   }
                   String len=null;
                   if(res.length()-dg1 != 0)
                   {
                       len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                   else {
                       len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                   }
                   digits.setText(len);
                result.setText(res);}
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Double  number1= Double.parseDouble(((EditText)findViewById(R.id.sayi1)).getText().toString());


                BigDecimal root= new BigDecimal(Math.sqrt(number1));
                String res= root.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                    len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                digits.setText(len);
                result.setText(res);
            }
        });

        fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                BigDecimal fac=BigDecimal.ONE;
                BigDecimal i= BigDecimal.ONE;
                while (!i.equals(number1))
                {
                    fac=fac.multiply(i);

                i=i.add(BigDecimal.ONE);
                }
                fac=fac.multiply(number1);
                String res= fac.toString();
                String len= "Sonuç " + String.valueOf(res.length())+ " Basamaklıdır";
                digits.setText(len);
                result.setText(res);
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                number2= new BigDecimal(((EditText)findViewById(R.id.sayi2)).getText().toString());


                BigDecimal sr= number1.remainder(number2);
                String res= sr.toString();
                char[] s=res.toCharArray();
                int dg1=0;
                for(int i=0;i<res.length();i++)
                {
                    dg1++;
                    if(s[i]=='.') {break;}

                }
                String len=null;
                if(res.length()-dg1 != 0)
                {
                    len= "Sonuç Virgülden önce " + String.valueOf(dg1-1)+" Virgülden sonra "+String.valueOf(res.length()-dg1)+ " Basamaklıdır";}
                else {
                    len="Sonuç " + String.valueOf(dg1)+" Basamaklıdır. ";
                }
                result.setText(res);
            }
        });
        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1= new BigDecimal(((EditText)findViewById(R.id.sayi1)).getText().toString());
                BigDecimal i= BigDecimal.valueOf(2);
                int s=0;
                String prime="";
                while (!i.equals(number1))
                {
                    if((number1.remainder(i)).equals(BigDecimal.ZERO)){

                        s++;
                        if(s==1) { prime="SAYI ASAL DEĞİLDİR";  break;}
                    }

                    if(s==0) { prime="SAYI ASALDIR"; }

                    i=i.add(BigDecimal.ONE);
                }



                result.setText(prime);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((EditText)findViewById(R.id.sayi1)).setText("");
                ((EditText)findViewById(R.id.sayi2)).setText("");
                ((EditText)findViewById(R.id.result)).setText("");
                ((TextView)findViewById(R.id.digits)).setText("");
            }
        });


    }
}
