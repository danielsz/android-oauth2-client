# android-oauth2-client
This is a fork from ` danielsz/android-oauth2-client`. What I have done is create an empty Android Library project on Android Studio, then copy source code from original repository and config to make it can be built using gradle.


# Install

config your project's gradle
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
Add this to your app module's gradle

	dependencies {
	        compile 'com.github.IHNEL:android-oauth2-client:-SNAPSHOT'
	}
  
  
  # Using
  Please read https://github.com/danielsz/android-oauth2-client/blob/master/README.md
