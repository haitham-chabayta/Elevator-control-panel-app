package adu.ac.ae.elevatorcontrolpanelapplication;

public class ElevatorNumberThree {
    private int button1;
    private int button2;

    private int numberOfFloors;

    public ElevatorNumberThree(){
        button1 = 0;
        button2 = 0;
        numberOfFloors = 1;
    }

    public int getButton1() { return button1; }

    public void setButton1(int button1) { this.button1 = button1; }

    public int getButton2() { return button2; }

    public void setButton2(int button2) { this.button2 = button2; }

    public int getNumberOfFloors() { return numberOfFloors; }
}
