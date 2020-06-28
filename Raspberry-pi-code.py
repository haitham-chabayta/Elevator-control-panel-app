from enum import Enum
from time import sleep
import RPi.GPIO as GPIO
from firebase import firebase

ID = 2266
elevatorIdTable = {2266 : 'ElevatorNumberOne', 5544 : 'ElevatorNumberTwo',  4433 : 'ElevatorNumberThree'}

firebase = firebase.FirebaseApplication("https://elevatorcontrolpanelapplicatio.firebaseio.com/", None)

servo1=None
servo2=None
servo3=None
servo4=None
servo5=None
servo6=None

class State(Enum):
    Idle = 1
    WaitForUserInput_TwoFloors = 2
    WaitForUserInput_FourFloors = 3
    WaitForUserInput_SixFloors = 4
    UpdateFirstButton = 5
    UpdateSecondButton = 6
    UpdateThirdButton = 7
    UpdateFourthButton = 8
    UpdateFifthButton = 9
    UpdateSixthButton = 10

current = State.Idle

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

def update(angle, servo):
    duty = float(angle) / 10.0 + 2.5
    servo.ChangeDutyCycle(duty)

def setupForTwoFloors():
    GPIO.setup(17, GPIO.OUT)
    GPIO.setup(27, GPIO.OUT)
    servo1 = GPIO.PWM(17, 100)
    servo1.start(5)
    servo2 = GPIO.PWM(27, 100)
    servo2.start(5)
    update(120, servo1)
    update(120, servo2)

def setupForFourFloors():
    GPIO.setup(17, GPIO.OUT)
    GPIO.setup(27, GPIO.OUT)
    GPIO.setup(22, GPIO.OUT)
    GPIO.setup(23, GPIO.OUT)
    servo1 = GPIO.PWM(17, 100)
    servo1.start(5)
    servo2 = GPIO.PWM(27, 100)
    servo2.start(5)
    servo3 = GPIO.PWM(22, 100)
    servo3.start(5)
    servo4 = GPIO.PWM(23, 100)
    servo4.start(5)
    update(120, servo1)
    update(120, servo2)
    update(120, servo3)
    update(120, servo4)

def setupForSixFloors():
    GPIO.setup(17, GPIO.OUT)
    GPIO.setup(27, GPIO.OUT)
    GPIO.setup(22, GPIO.OUT)
    GPIO.setup(23, GPIO.OUT)
    GPIO.setup(24, GPIO.OUT)
    GPIO.setup(25, GPIO.OUT)
    servo1 = GPIO.PWM(17, 100)
    servo1.start(5)
    servo2 = GPIO.PWM(27, 100)
    servo2.start(5)
    servo3 = GPIO.PWM(22, 100)
    servo3.start(5)
    servo4 = GPIO.PWM(23, 100)
    servo4.start(5)
    servo5 = GPIO.PWM(24, 100)
    servo5.start(5)
    servo6 = GPIO.PWM(25, 100)
    servo6.start(5)
    update(120, servo1)
    update(120, servo2)
    update(120, servo3)
    update(120, servo4)
    update(120, servo5)
    update(120, servo6)

ElevatorNumber  = elevatorIdTable[ID]
getNumberOfFloorsString = '/Elevator/' + ElevatorNumber + '/numberOfFloors'
numberOfFloors = firebase.get(getNumberOfFloorsString, '')

numberOfFloorsInteger = int(numberOfFloors)

if numberOfFloorsInteger == 2:
    setupForTwoFloors()

elif numberOfFloorsInteger == 4:
    setupForFourFloors()

elif numberOfFloorsInteger == 6:
    setupForSixFloors()

getButton1StateString = '/Elevator/' + ElevatorNumber + '/button1'
getButton2StateString = '/Elevator/' + ElevatorNumber + '/button2'
getButton3StateString = '/Elevator/' + ElevatorNumber + '/button3'
getButton4StateString = '/Elevator/' + ElevatorNumber + '/button4'
getButton5StateString = '/Elevator/' + ElevatorNumber + '/button5'
getButton6StateString = '/Elevator/' + ElevatorNumber + '/button6'

def updateServo(servo):
    update(0,servo)
    sleep(2)
    update(120,servo)

while True:
    if current == State.Idle:
        if numberOfFloorsInteger == 2:
            current = State.WaitForUserInput_TwoFloors
        if numberOfFloorsInteger == 4:
            current = State.WaitForUserInput_FourthFloors
        if numberOfFloorsInteger == 6:
            current = State.WaitForUserInput_SixthFloors

    if current == State.WaitForUserInput_TwoFloors:
        button1State = int(firebase.get(getButton1StateString, ''))
        button2State = int(firebase.get(getButton2StateString, ''))
        if button1State == 1:
            current = State.UpdateFirstButton
        if button2State == 1:
            current = State.UpdateSecondButton
        sleep(0.2)

    if current == State.WaitForUserInput_FourFloors:
        button1State = int(firebase.get(getButton1StateString, ''))
        button2State = int(firebase.get(getButton2StateString, ''))
        button3State = int(firebase.get(getButton3StateString, ''))
        button4State = int(firebase.get(getButton4StateString, ''))
        if button1State == 1:
            current = State.UpdateFirstButton
        if button2State == 1:
            current = State.UpdateSecondButton
        if button3State == 1:
            current = State.UpdateThirdButton
        if button4State == 1:
            current = State.UpdateFourthButton
        sleep(0.2)

    if current == State.WaitForUserInput_SixFloors:
        button1State = int(firebase.get(getButton1StateString, ''))
        button2State = int(firebase.get(getButton2StateString, ''))
        button3State = int(firebase.get(getButton3StateString, ''))
        button4State = int(firebase.get(getButton4StateString, ''))
        button5State = int(firebase.get(getButton5StateString, ''))
        button6State = int(firebase.get(getButton6StateString, ''))
        if button1State == 1:
            current = State.UpdateFirstButton
        if button2State == 1:
            current = State.UpdateSecondButton
        if button3State == 1:
            current = State.UpdateThirdButton
        if button4State == 1:
            current = State.UpdateFourthButton
        if button5State == 1:
            current = State.UpdateFifthButton
        if button6State == 1:
            current = State.UpdateSixthButton
        sleep(0.2)

    if current == State.UpdateFirstButton:
        updateServo(servo1)
        current = State.Idle

    if current == State.UpdateSecondButton:
        updateServo(servo2)
        current = State.Idle

    if current == State.UpdateThirdButton:
        updateServo(servo3)
        current = State.Idle

    if current == State.UpdateFourthButton:
        updateServo(servo4)
        current = State.Idle

    if current == State.UpdateFifthButton:
        updateServo(servo5)
        current = State.Idle

    if current == State.UpdateSixthButton:
        updateServo(servo6)
        current = State.Idle