# MAD Assignment – Android Applications

This repository contains solutions for all four questions of the Mobile Application Development (MAD) assignment. Each question is implemented as a separate Android Studio project.

---

## Project Structure

* Q1_CurrencyConverter2 – Currency Converter App
* Q2_MediaPlayer – Audio and Video Player
* Q3_Sensors – Sensor Data Display App
* Q4_CameraGallery – Camera and Gallery App

---

## Q1 – Currency Converter

### Description

An Android application that converts currency values between different currencies such as INR, USD, EUR, and JPY.

### Features

* User input for amount
* Dropdown selection for currencies
* Conversion logic using predefined rates
* Displays converted result

### Concepts Used

* EditText, Spinner, Button, TextView
* Event handling
* Basic calculations

---

## Q2 – Media Player

### Description

An application that plays audio files from device storage and streams video from a URL.

### Features

* Play audio from local storage
* Stream video from internet URL
* Play, Pause, Stop, Restart controls

### Concepts Used

* MediaPlayer
* VideoView
* Buttons and event listeners
* Resource management

---

## Q3 – Sensors

### Description

An app that reads and displays real-time data from device sensors.

### Sensors Used

* Accelerometer
* Light Sensor
* Proximity Sensor

### Features

* Displays live sensor values
* Updates dynamically as device state changes

### Concepts Used

* SensorManager
* SensorEventListener
* Lifecycle methods

---

## Q4 – Camera and Gallery Application

### Description

A complete application that allows users to capture images, view them in a grid gallery, and manage image details.

### Features

#### a) Capture Image

* Uses device camera via intent
* Saves image to device gallery using MediaStore API

#### b) View Images

* Loads images using MediaStore
* Displays images in grid format using RecyclerView

#### c) Image Details

* Shows:

  * Image name
  * File path
  * Size
  * Last modified date
* Delete functionality with confirmation dialog
* Returns to gallery after deletion

### Concepts Used

* Camera Intent
* MediaStore API
* RecyclerView with GridLayoutManager
* File handling
* AlertDialog

---

## Permissions Used

* Camera Permission
* Read External Storage
* Write External Storage

---

## Notes

* Camera functionality may not work properly on emulator; tested using gallery picker or physical device.
* MediaStore API is used instead of manual folder selection due to Android storage restrictions.
* All applications are implemented using Java and XML layouts.

---

## How to Run

1. Open the required project (Q1, Q2, Q3, or Q4) in Android Studio
2. Allow Gradle to sync
3. Connect emulator or physical device
4. Click Run

---

## Author

Harsh Pratap Singh
B.Tech CSE – BML Munjal University

---
