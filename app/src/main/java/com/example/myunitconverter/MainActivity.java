/* Student Name: Cynthia Yi Min Chee
Student ID: 221106626
SIT305 - Task 2.1P (My Unit Converter)
 */
package com.example.myunitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //initializing variables
    EditText myInput;   //input for conversion

    //Image buttons (length, temperature, weight)
    ImageButton myLength, myTemp, myWeight;
    //Conversion outputs
    TextView output1, output2, output3;
    //Output units
    TextView unit1, unit2, unit3;
    //drop-down menu (spinner)
    Spinner unitsSpinner;

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //linking variables to elements by ID
        myInput = findViewById(R.id.inputText);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        unit1 = findViewById(R.id.unit1);
        unit2 = findViewById(R.id.unit2);
        unit3 = findViewById(R.id.unit3);
        myLength = findViewById(R.id.lengthMeasure);
        myTemp = findViewById(R.id.tempMeasure);
        myWeight = findViewById(R.id.weightMeasure);

        //Length conversion
        myLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if "Metres" is chosen in drop-down menu
                if (adapterView.getItemAtPosition(i).equals("Metres")){
                    //output converted values based on input
                    float metresInput = Integer.parseInt(myInput.getText().toString());
                    output1.setText(String.format("%.2f", metresInput*100));
                    unit1.setText("Centimetres");
                    output2.setText(String.format("%.2f", metresInput*3.281));
                    unit2.setText("Feet");
                    output3.setText(String.format("%.2f", metresInput*39.37));
                    unit3.setText("Inches");
                }
                //show error message if "Metres" not chosen
                else{
                    Toast.makeText(getApplicationContext(),"Error: Wrong conversion unit. Please try again.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Temperature conversion
        myTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if "Celsius" is chosen in drop-down menu
                if (adapterView.getItemAtPosition(i).equals("Celsius")){
                    //output converted values based on input
                    float celsiusInput = Integer.parseInt(myInput.getText().toString());
                    output1.setText(String.format("%.2f", (celsiusInput*9/5)+32));
                    unit1.setText("Fahrenheit");
                    output2.setText(String.format("%.2f", celsiusInput+273.15));
                    unit2.setText("Kelvin");
                    //only 2 conversion units
                    output3.setText("");
                    unit3.setText("");
                }
                else{
                    //show error message if "Celsius" not chosen
                    Toast.makeText(getApplicationContext(),"Error: Wrong conversion unit. Please try again.",Toast.LENGTH_SHORT).show();
                }
            }
        });


        myWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if "Kilograms" is chosen in drop-down menu
                if (adapterView.getItemAtPosition(i).equals("Kilograms")){
                    //output converted values based on input
                    float kilosInput = Integer.parseInt(myInput.getText().toString());
                    output1.setText(String.format("%.2f", kilosInput*1000));
                    unit1.setText("Grams");
                    output2.setText(String.format("%.2f", kilosInput*35.275));
                    unit2.setText("Ounces (Oz)");
                    output3.setText(String.format("%.2f", kilosInput*2.205));
                    unit3.setText("Pounds (lb)");
                }
                else{
                    //show error message if "Kilograms" not chosen
                    Toast.makeText(getApplicationContext(),"Error: Wrong conversion unit. Please try again.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set adapter on spinner to link to units_menu array in strings.xml file
        unitsSpinner = findViewById(R.id.spinner);
        unitsSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsSpinner.setAdapter(adapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
