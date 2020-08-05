
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/haitham-chabayta/Elevator-control-panel-app">
     <img src="images/logo.png" alt="Logo" width="80" height="80">
 </a>

  <h3 align="center">E-Lift</h3>

  <p align="center">
    An android application that allows users to press elevator buttons without any physical contact.
    <br />
    <a href="https://github.com/haitham-chabayta/Elevator-control-panel-app"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/haitham-chabayta/Elevator-control-panel-app/blob/master/Project_Report.pdf">View Demo</a>
    ·
    <a href="https://github.com/haitham-chabayta/Elevator-control-panel-app/issues">Report Bug</a>
    ·
    <a href="https://github.com/haitham-chabayta/Elevator-control-panel-app/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
  * [Features](#features)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Contributing](#contributing)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project

[![Screen Shot][product-screenshot]](https://github.com/haitham-chabayta/blind-spot-detection/)
[![Screen Shot 2][product-screenshot-2]](https://github.com/haitham-chabayta/blind-spot-detection/)

E-Lift is an Android native application that allows users to press elevator buttons without any physical contact. Users scan an elevator Qr code to display the elevator's control panel. The application contorls the operation of servo motors connected to a Raspberry pi by alerting the state of the button pressed in the database which is continuously monitored by the Raspberry Pi. The servo motors are used to produce a pushing mechanism to press the elevator buttons.

A list of commonly used resources that I find helpful are listed in the acknowledgements.

### Features
* Qr Code Scanner
* Dynamic contorl panel display on the app depending on the number of floors.

### Built With
* [Raspberry pi](https://www.raspberrypi.org/)
* [Android studio](https://developer.android.com/studio)
* [Google mobile vision](https://developers.google.com/vision)

## Getting Started


### Prerequisites

*Raspberry pi model 3

*Servo Motors

*Andriod studio and Java JDK 8

*Git / Check if you have Git using:
```sh
npm --version
```
If not install git from https://git-scm.com/downloads

*Python3 on the Raspberry pi
```sh
sudo apt-get install python3.6
```

*Python-firebase on the Raspberry pi
```sh
sudo pip install python-firebase
```



### Installation

1. Clone the Repo 
```sh
git clone https://github.com/haitham-chabayta/Elevator-control-panel-app.git
```
2. Connect the servo motors to the Raspberry pi GPIO pins

3. Run the python code on the Raspberry pi

4. Import the application project on Android studio

5.Bulid the APK and Install it on your Android device


<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


<!-- CONTACT -->
## Contact

Haitham Chabayta - haithamchabayta@gmail.com

LinkedIn: https://www.linkedin.com/in/haitham-chabayta-0654681b1/



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [GitHub Pages](https://pages.github.com)
* [Firebase](https://firebase.google.com/)
* [Mobile vision Barcode API](https://developers.google.com/vision/android/barcodes-overview)
* [Python-firebase](https://pypi.org/project/python-firebase/)



[contributors-shield]: https://img.shields.io/github/contributors/haitham-chabayta/Elevator-control-panel-app.svg?style=flat-square
[contributors-url]: https://github.com/haitham-chabayta/Elevator-control-panel-app/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/haitham-chabayta/Elevator-control-panel-app.svg?style=flat-square
[forks-url]: https://github.com/haitham-chabayta/Elevator-control-panel-app/network/members
[stars-shield]: https://img.shields.io/github/stars/haitham-chabayta/Elevator-control-panel-app.svg?style=flat-square
[stars-url]: https://github.com/haitham-chabayta/Elevator-control-panel-app/stargazers
[issues-shield]: https://img.shields.io/github/issues/haitham-chabayta/Elevator-control-panel-app.svg?style=flat-square
[issues-url]: https://github.com/haitham-chabayta/Elevator-control-panel-app/issues
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/haitham-chabayta-0654681b1/
[product-screenshot]: images/screenshot.png
[product-screenshot-2]: images/screenshot-2.png
