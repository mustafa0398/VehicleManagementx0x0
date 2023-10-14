package com.oeztuerk.vehiclemanagementx0x0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddVehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        // Find the views
        final EditText manufacturerEditText = findViewById(R.id.manufacturerEditText);
        final EditText modelNameEditText = findViewById(R.id.modelNameEditText);
        final EditText seatsEditText = findViewById(R.id.seatsEditText);
        final CheckBox electricCheckBox = findViewById(R.id.electricCheckBox);
        Button btnAddVehicle = findViewById(R.id.btnAddVehicle);
        final Spinner spinner = findViewById(R.id.spinnerVehicleType);

        btnAddVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get selected vehicle type from Spinner
                String selectedType = spinner.getSelectedItem().toString();

                // Get the manufacturer and model name from EditText fields
                String manufacturer = manufacturerEditText.getText().toString();
                String modelName = modelNameEditText.getText().toString();

                // Get the number of seats and isElectric values
                int numberOfSeats = 0;
                boolean isElectric = false;

                if (selectedType.equals("Car")) {
                    numberOfSeats = Integer.parseInt(seatsEditText.getText().toString());
                } else if (selectedType.equals("Motorbike")) {
                    isElectric = electricCheckBox.isChecked();
                }

                // Create a new Vehicle instance with the selected type and other data
                Vehicle newVehicle = createVehicle(selectedType, manufacturer, modelName, numberOfSeats, isElectric);

                // Send a broadcast with the new vehicle
                Intent broadcastIntent = new Intent("com.example.ADD_VEHICLE");

                sendBroadcast(broadcastIntent);

                // Finish the activity to return to the main activity
                finish();
            }
        });

        // Set a listener for the spinner to show/hide specific input fields
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedType = spinner.getSelectedItem().toString();

                // Show/hide specific input fields based on the selected type
                switch (selectedType) {
                    case "Car":
                        seatsEditText.setVisibility(View.VISIBLE);
                        electricCheckBox.setVisibility(View.GONE);
                        break;
                    case "Motorbike":
                        seatsEditText.setVisibility(View.GONE);
                        electricCheckBox.setVisibility(View.VISIBLE);
                        break;
                    default:
                        seatsEditText.setVisibility(View.GONE);
                        electricCheckBox.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });
    }

    // Create a new Vehicle based on the selected type and input values
    private Vehicle createVehicle(String selectedType, String manufacturer, String modelName, int numberOfSeats, boolean isElectric) {
        // Implement your logic to create a new Vehicle here
        // You can use a factory method or constructor for different vehicle types
        // Return the newly created Vehicle
        return null;
    }
}

