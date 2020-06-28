package adu.ac.ae.elevatorcontrolpanelapplication;

public class ElevatorNumberTwo{
    private int button1;
    private int button2;
    private int button3;
    private int button4;
    private int button5;
    private int button6;

    private int numberOfFloors;

    public ElevatorNumberTwo(){
        button1 = 0;
        button2 = 0;
        button3 = 0;
        button4 = 0;
        button5 = 0;
        button6 = 0;
        numberOfFloors = 3;
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

    public int getButton5() { return button5; }

    public void setButton5(int button5) { this.button5 = button5; }

    public int getButton6() { return button6; }

    public void setButton6(int button6) { this.button6 = button6; }

    public int getNumberOfFloors() { return numberOfFloors; }
}
