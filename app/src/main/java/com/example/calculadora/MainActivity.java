package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNum1, txtNum2;
    TextView lblResultado;

    CheckBox chkSuma, chkResta, chkMultiplicar, chkDividir;
    CheckBox chkSi;

    Spinner spnOperaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InicializarDatos();
    }

    private void InicializarDatos()
    {
        txtNum1 =(EditText)findViewById(R.id.txtNum1);
        txtNum2= (EditText)findViewById(R.id.txtNum2);

        lblResultado = (TextView)findViewById(R.id.lblRes);

        chkSuma = (CheckBox)findViewById(R.id.chkSumar);
        chkResta = (CheckBox)findViewById(R.id.chkRestar);
        chkMultiplicar = (CheckBox)findViewById(R.id.chkMultiplicar);
        chkDividir = (CheckBox)findViewById(R.id.chkDividir);
        chkSi = (CheckBox)findViewById(R.id.chkSi);

        spnOperaciones = (Spinner)findViewById(R.id.spnOperaciones);

        String [] listaOperaciones = {"Escoge la operacion", "Suma", "Resta", "Multiplicacion","Division"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaOperaciones);
        spnOperaciones.setAdapter(adapter);



    }

    public void OperacionesCheckbox(View v)
    {
        try
        {
            float n1 = Float.parseFloat(txtNum1.getText().toString());
            float n2 = Float.parseFloat(txtNum2.getText().toString());

            String operacionSuma = "";
            String operacionResta = "";
            String operacionMultiplicacion = "";
            String operacionDivision = "";

            if (chkSuma.isChecked() == true) {
                float suma = n1 + n2;
                operacionSuma = "El valor de la suma es = " + suma + "\n";
            }
            if (chkResta.isChecked() == true) {
                float resta = n1 - n2;
                operacionResta = "El valor de la resta es = " + resta + "\n";
            }

            if (chkMultiplicar.isChecked() == true) {
                float multiplicacion = n1 * n2;
                operacionMultiplicacion = "El valor de la multiplicacion es = " + multiplicacion + "\n";
            }

            if (chkDividir.isChecked() == true) {
                float division = n1 / n2;
                operacionDivision = "El valor de la division es = " + division;
            }
            if(chkSuma.isChecked() == true || chkResta.isChecked() == true ||
               chkMultiplicar.isChecked() == true || chkDividir.isChecked() == true)
            {
                new Mensajito("Operaciones",
                        "" + operacionSuma + "" + operacionResta + "" + operacionMultiplicacion + "" + operacionDivision, "OKIS")
                        .show(getSupportFragmentManager(), "EQUIDE");
            }
            if(chkSuma.isChecked() == false && chkResta.isChecked() == false &&
               chkMultiplicar.isChecked() == false && chkDividir.isChecked() == false)
            {
                new Mensajito("Operaciones",
                        "Syntax error Stupid",  "REINTENTA")
                        .show(getSupportFragmentManager(), "EQUIDE");
            }

        }catch(Exception e)
        {

                new Mensajito("Operaciones",
                        "Syntax error Stupid",  "REINTENTA")
                        .show(getSupportFragmentManager(), "EQUIDE");



        }
    }


    public void OperacionesSpinner(View v)
    {
        try
        {
            float valor1 = Float.parseFloat(txtNum1.getText().toString());
            float valor2 = Float.parseFloat(txtNum2.getText().toString());

            String operacion = "";
            String seleccionado = spnOperaciones.getSelectedItem().toString();


            {
                if (seleccionado.equals("Escoge la operacion")) {
                    operacion = "Compa. Pa que me llamas si te faltan cosas por llenar";
                }
                if (seleccionado.equals("Suma")) {
                    float suma = valor1 + valor2;
                    operacion = "El resultado de la suma es = "+suma;
                } else if (seleccionado.equals("Resta")) {
                    float resta = valor1 - valor2;
                    operacion = "El resultado de la resta es = "+resta;
                } else if (seleccionado.equals("Multiplicacion")) {
                    float multiplicacion = valor1 * valor2;
                    operacion = "El resultado de la multiplicacion es = "+multiplicacion;
                } else if (seleccionado.equals("Division")) {
                    float division = valor1 / valor2;
                    operacion = "El resultado de la division es = "+division;
                }
            if (chkSi.isChecked()==true)
            {
                new Mensajito("Operaciones",
                        ""+operacion, "OKIS")
                        .show(getSupportFragmentManager(), "EQUIDE");

                lblResultado.setText("");
        }else {


                lblResultado.setText("Compa. Pa que me llamas si te faltan cosas por llenar");
            }
        }
        }catch(Exception e)
        {
            new Mensajito("Operaciones",
                    "Compa. Pa que me llamas si te faltan cosas por llenar", "REINTENTA")
                    .show(getSupportFragmentManager(), "EQUIDE");
        }
    }

}