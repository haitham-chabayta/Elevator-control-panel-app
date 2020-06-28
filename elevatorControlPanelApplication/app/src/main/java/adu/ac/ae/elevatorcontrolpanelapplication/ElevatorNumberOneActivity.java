package adu.ac.ae.elevatorcontrolpanelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ElevatorNumberOneActivity extends AppCompatActivity {

    DatabaseReference reff;
    Button firstFloorButton;
    Button secondFloorButton;
    Button thirdFloorButton;
    Button fourthFloorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevator_number_one);
        firstFloorButton = (Button)findViewById(R.id.button1);
        secondFloorButton = (Button)findViewById(R.id.button2);
        thirdFloorButton = (Button)findViewById(R.id.button3);
        fourthFloorButton = (Button)findViewById(R.id.button4);
        final ElevatorNumberOne elevatorNumberOne = new ElevatorNumberOne();
        reff = FirebaseDatabase.getInstance().getReference().child("Elevator");
        reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
        firstFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberOne.setButton1(1);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberOne.setButton1(0);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
            }
        });

        secondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberOne.setButton2(1);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberOne.setButton2(0);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
            }
        });

        thirdFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberOne.setButton3(1);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberOne.setButton3(0);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
            }
        });

        fourthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberOne.setButton4(1);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberOne.setButton4(0);
                reff.child("ElevatorNumberOne").setValue(elevatorNumberOne);
            }
        });
    }

}
