# Cafeteria Meal Tickets

An Android application developed to simplify the management and consultation of cafeteria meal tickets.

## Overview

The purpose of this application is to allow users to view and manage their meal tickets through a simple and intuitive interface.

The application communicates with a REST API to retrieve the required data and uses Android architecture components for data management and persistence.

## Features

* User authentication
* View available meals
* Browse meal categories
* Manage purchased meal tickets
* REST API integration
* Local data storage using Room Database

## Technologies Used

* Java
* Android Studio
* Android SDK
* Retrofit (REST API client)
* Room Database
* RecyclerView
* Gradle

## Project Structure

```text
app/
├── model/          # Data models
├── view/           # Activities and user interface
├── service/        # REST API communication
├── adapter/        # RecyclerView adapters
├── database/       # Local persistence using Room
└── utils/          # Utility classes
```

## Requirements

* Android Studio
* Android SDK
* Gradle
* Internet connection (for API communication)

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/<your-username>/Cafeteria-Meal-Tickets.git
```

2. Open the project in Android Studio.

3. Allow Gradle to synchronize the project.

4. Build and run the application on an Android emulator or a physical device.

## Architecture

The application follows a layered architecture composed of the following modules:

* **View** – User interface and Activities.
* **Model** – Application data models.
* **Service** – Communication with the REST API.
* **Database** – Local persistence using Room Database.
* **Adapter** – RecyclerView adapters for displaying lists.

## Future Improvements

* Complete user authentication and authorization.
* Purchase new meal tickets directly from the application.
* Meal history.
* QR code generation for ticket validation.
* Push notifications for available meals and reminders.
* Improved error handling and offline support.
* Modern Material Design interface.

## License

This project was developed for academic and educational purposes.
