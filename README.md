DreamF1 – Fantasy F1 Team Simulator (Java)

DreamF1 is a lightweight Java-based fantasy Formula 1 simulator inspired by Dream11.
Users can select drivers, create a custom F1 team, and earn points based on race events.

🚦 Features

Choose drivers from a predefined list

Build your fantasy F1 team

Simple points system based on race performance

Java Swing–based GUI

Beginner-friendly, modular Java code structure

🛠️ Tech Stack

Java 22

Java Swing (UI)

OOP Design (models, UI, events)

📁 Project Structure
src/
 ├── main/                # Entry point (Main.java)
 ├── ui/                  # Swing UI screens
 ├── models/              # Data models (Driver, Team, etc.)
 └── events/              # Points & race event logic

▶️ How to Run

Clone the repository:

git clone https://github.com/<username>/dreamf1.git


Navigate into the project:

cd dreamf1/src


Compile:

Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }

Run:

java main.Main

🎯 Purpose

This project is designed as a small, fun practice app for:

Learning Java

Understanding Swing UIs

Building simple event-driven applications

Exploring OOP concepts
