# Airline-Reservation-System-Java-GUI

## Overview
This Java Swing project simulates a simple **Airline Reservation System**, allowing users to:

- Input their name, gender, age, and phone number.
- Choose an airline:
  - **Sky Airline** (Jeddah ➝ Khobar)
  - **Fly Airline** (Jeddah ➝ Riyadh)
- Pick a flight class: `First`, `Business`, or `Economy`.
- Choose available flight times (loaded from text files).
- View and save a final receipt with all booking details.

All steps are displayed in separate GUI windows, and input validation is included.

## Requirements
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (like IntelliJ, NetBeans, or Eclipse) 
- All `.java`, `.txt`, and `.jpg`/`.jpeg` files must be in the **same folder**


## Files Included            
- `AirlineReservationSystemGUI.java`: main source code (includes all GUI logic)
- `SkyTimes.txt` : Contains flight times for Sky Airline   
- `FlyTimes.txt` : Contains flight times for Fly Airline   
- `RECEIPT.txt` :Output file generated after booking      
- `Rn AirLines.jpg` :  Logo displayed on the welcome screen     
- `R1.jpeg` : Image shown in the airline menu window   
- `R2.jpeg` : Image shown in the final receipt screen


## Class Descriptions

- **Passenger**  
  First screen to enter name, gender, age, and phone. Validates input and goes to the airline menu.
  
- **AirLinesMenu**  
  Lets the user choose between two airlines: Sky (to Khobar) or Fly (to Riyadh).

- **SkyFlight**  
  Flight selection screen for Sky Airline. User picks class and time (from `SkyTimes.txt`).

- **FlyFlight**  
  Same as SkyFlight, but for Fly Airline. Reads times from `FlyTimes.txt`.

- **receipt**  
  Shows final booking details and total. Saves the info to `RECEIPT.txt`.

 
