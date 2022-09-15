### "AndroidPrefsDataStoreExample" example project by:

##       Roy Watson

rwatson@dela.com

www.dela.com

![Screenshot_1663205661](./Screenshot_1663205661.png)

This is a simple example that strips out a lot of generally accepted architectural components and other proclaimed best practices. It is using the minimum of dependencies, frameworks and libraries in order to avoid obscuring the illustration of using androidx's *PreferencesDataStore*. 

##### Branches:

"start" branch is the raw templated project created by Android Studio Chipmunk | 2021.2.1 Patch 2. This is supplied for comparison purposes.  ***It appears you are currently on this branch.***

"complete" branch is the example/tutorial application where the "magic"😀 happens. 

##### This example demonstrates/teaches:

- Preferences DataStore API

##### This example also includes/uses:

- Kotlin
- Compose
- ViewModel
- Coroutines & Flows
- Repository pattern

### How to best use this demo:

The starting point of this app was the template for a new project in Android Studio Chipmunk | 2021.2.1 Patch 2 called “Empty Compose Activity” and using Kotlin. You can create an empty project based on that template and compare it to this project to discern what needs to be done to get your project started with the Room database library. 

First, as always, we need to add the neccessary dependencies to the project. In the app level build.gradle file I hsve marked my additions with comments. These additions might in turn require version updates to other dependencies and settings. Once you have made my additions, Android Studio will help you identify the other required changes. Be patient as it might take a few iterations and pay close attention to the build output messages.	

First, in com.delasystems.prefsdatastore.data.MyPreferences.kt, I created a data class to hold the preferences and a sealed class that defines and describes the contents of the fields in the data class container.

Next I created a repository to handle the actual storing and retrieval of the preferences. The methods in the repository are called from the ViewModel in response to stimuli from the UI in MainActivity.

You can find a reference to using this API at https://developer.android.com/codelabs/android-preferences-datastore#4 .

Thank you and if you have ny comments or questions please feel free to contact me at rwatson@dela.com

## License:

    Copyright (C) 2022 Roy Watson
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of this
    software and associated documentation files (the "Software"), to deal in the Software 
    without restriction, including without limitation the rights to use, copy, modify, merge, 
    publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons 
    to whom the Software is furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all copies 
    or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
    PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
    FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
    TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
    OR OTHER DEALINGS IN THE SOFTWARE.

