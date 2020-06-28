package adu.ac.ae.elevatorcontrolpanelapplication;

public class ElevatorNumberOne {
    private int button1;
    private int button2;
    private int button3;
    private int button4;

    private int numberOfFloors;

    public ElevatorNumberOne(){
        button1 = 0;
        button2 = 0;
        button3 = 0;
        button4 = 0;
        numberOfFloors = 2;
    }

    public int getButton1() {
        return button1;
    }

    public void setButton1(int button1) {
        this.button1 = button1;
    }

    public int getButton2() {
        return button2;
    }

    public void setButton2(int button2) {
        this.button2 = button2;
    }

    public int getButton3() {
        return button3;
    }

    public void setButton3(int button3) {
        this.button3 = button3;
    }

    public int getButton4() {
        return button4;
    }

    public void setButton4(int button4) {
        this.button4 = button4;
    }

    public int getNumberOfFloors() { return numberOfFloors; }
}
