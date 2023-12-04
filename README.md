# Walmart Country List Viewer Code Challenge
This project demonstrates a simple Android Application that fetches and displays a list of countries.
It showcases the use of modern Android development tools and practices without relying on 
Jetpack Compose or Dagger for dependency injection.

## Features
Fetches a list of countries in JSON format from a provided URL.
Displays the countries in a RecyclerView, ordered as they appear in the JSON data.
Each item in the list show the country's name, region, code and capital.
Robust implementation, with error handling and support for device rotation.

## Technical Details
Networking: Implemented using Retrofit and OkHTTP.
JSON Parsing: Utilizing Gson for handling JSON data.
Concurrency: Leveraging Kotlin Coroutines for asynchronous tasks.
Architecture: Following MVVM (Model-View-ViewModel) pattern for clean separation of concerns.
