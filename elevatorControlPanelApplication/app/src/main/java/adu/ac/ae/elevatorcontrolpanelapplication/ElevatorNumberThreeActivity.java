package adu.ac.ae.elevatorcontrolpanelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ElevatorNumberThreeActivity extends AppCompatActivity {

    DatabaseReference reff;
    Button firstFloorButton;
    Button secondFloorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevator_number_three);
        firstFloorButton = (Button)findViewById(R.id.button13);
        secondFloorButton = (Button)findViewById(R.id.button23);
        final ElevatorNumberThree elevatorNumberThree = new ElevatorNumberThree();
        reff = FirebaseDatabase.getInstance().getReference().child("Elevator");
        reff.child("ElevatorNumberThree").setValue(elevatorNumberThree);
        firstFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberThree.setButton1(1);
                reff.child("ElevatorNumberThree").setValue(elevatorNumberThree);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberThree.setButton1(0);
                reff.child("ElevatorNumberThree").setValue(elevatorNumberThree);
            }
        });

        secondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberThree.setButton2(1);
                reff.child("ElevatorNumberThree").setValue(elevatorNumberThree);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberThree.setButton2(0);
                reff.child("ElevatorNumberThree").setValue(elevatorNumberThree);
            }
        });

    }

}
