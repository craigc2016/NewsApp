# NewsApp
This app was developed as part of The Complete Android 11 Jetpack Masterclass 2021.
The app architecture used was mvvm it uses one activity with fragments for the view.


# VIEW
It uses view binding library to get references to widgets within the view.
It uses Android's Navigation component to create and set up the linking between the views.

# NETWORKING
It uses Retrofit library/ coroutines to perform network request to the news API. It uses Glide library to load
images from the API into image views.

# STORAGE
It uses Room Database to store news headlines and information locally. Coroutines is used while making 
database queries.

# DI
Dagger2/hilt was used for dependecy injection.
