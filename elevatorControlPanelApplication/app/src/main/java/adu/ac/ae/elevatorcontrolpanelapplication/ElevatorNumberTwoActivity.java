package adu.ac.ae.elevatorcontrolpanelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ElevatorNumberTwoActivity extends AppCompatActivity {

    DatabaseReference reff;
    Button firstFloorButton;
    Button secondFloorButton;
    Button thirdFloorButton;
    Button fourthFloorButton;
    Button fifthFloorButton;
    Button sixthFloorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elevator_number_two);
        firstFloorButton = (Button)findViewById(R.id.button11);
        secondFloorButton = (Button)findViewById(R.id.button21);
        thirdFloorButton = (Button)findViewById(R.id.button31);
        fourthFloorButton = (Button)findViewById(R.id.button41);
        fifthFloorButton = (Button)findViewById(R.id.button51);
        sixthFloorButton = (Button)findViewById(R.id.button61);
        final ElevatorNumberTwo elevatorNumberTwo = new ElevatorNumberTwo();
        reff = FirebaseDatabase.getInstance().getReference().child("Elevator");
        reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
        firstFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton1(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton1(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });

        secondFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton2(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton2(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });

        thirdFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton3(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton3(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });

        fourthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton4(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton4(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });

        fifthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton5(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton5(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });

        sixthFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elevatorNumberTwo.setButton6(1);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                elevatorNumberTwo.setButton6(0);
                reff.child("ElevatorNumberTwo").setValue(elevatorNumberTwo);
            }
        });
    }

}
