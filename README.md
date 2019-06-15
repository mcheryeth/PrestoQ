# PrestoQ Android Coding Exercise Solution
An Android app that allows customers to see which products are on "Manager's Special"

#### App Features
* Manager's Specials change periodically; at any moment a store manager could decide to add or remove a product
* Products are displayed in the order they are provided
* The size of each product tile must be the size specified by the endpoint
* Display as many products as possible while still following sizing parameters
* If the combined width of the product frames exceeds the full width of the phone move the product frame to the next line and center any frames that do not fit in the full width frame.
* Show empty view if there are no Manager's Specials
* Cache all Manager Specials so that it loads fast in subsequent app restarts

#### App Architecture 
Based on MVVM architecture and repository pattern.
 
#### Components:

* The UI (Activity) shows a visual representation of the data in the ViewModel.
* A ViewModel that provides data specific for the UI.
* A repository that works with the database and the api service, providing a unified data interface.
* A local Room database that servers as a single source of truth for data presented to the user. 
* A web API service that connects to PrestoQ server.
* Unit tests for API service, Database, Repository and ViewModel.


#### App Packages
* <b>data</b> - contains 
    * <b>remote</b> - contains the api classes to make api calls to PrestoQ server, using Retrofit. 
    * <b>local</b> - contains the db classes to cache network data.
    * <b>repository</b> - contains the repository classes, responsible for triggering api requests and saving the response in the database.
* <b>di</b> - contains dependency injection classes, using Dagger2.   
* <b>ui</b> - contains classes needed to display UI (activity, viewholder, viewmodel, adapter).
* <b>utils</b> - contains classes needed for calculating item widths & heights based on requirements.


#### App Specs
* Minimum SDK 21
* [Java8](https://java.com/en/download/faq/java8.xml) (in master branch)
* MVVM Architecture
* Android Architecture Components (LiveData, Lifecycle, ViewModel, Room Persistence Library, Navigation Component, ConstraintLayout)
* [Flexbox Layout](https://github.com/google/flexbox-layout) for implementing layout flexibility for product items
* [RxJava2](https://github.com/ReactiveX/RxJava) for implementing Observable pattern.
* [Dagger 2](https://google.github.io/dagger/) for dependency injection.
* [Retrofit 2](https://square.github.io/retrofit/) for API integration.
* [Gson](https://github.com/google/gson) for serialisation.
* [Okhhtp3](https://github.com/square/okhttp) for implementing interceptor, logging and mocking web server.
* [Mockito](https://site.mockito.org/) for implementing unit test cases
* [Picasso](http://square.github.io/picasso/) for image loading.

#### Build Instructions
* Build via command line : <b>./gradlew assembleDebug </b>. Resulting apk can then be found in <b>app/build/outputs/apk/app-debug.apk</b>
* Or Android Studio!