Sample Selgp Appium Saucelabs Android Tests
---

This contains the source code for running sample [Appium](http://github.com/appium/appium) tests using [TestNG](http://www.testng.org) on [SauceLabs](http://www.saucelabs.com)

In order to run the tests, you will need to install [Apache Maven](http://maven.apache.org).

Check out this repo from GitHub:

    git clone git@github.com:guillemhs/opensauce-selgp-android.git

Go to the main folder of opensauce-selgp-android and then run the whole suite on Saucelabs using FF:

    mvn -Duser=YOUR_SAUCE_USER -Dapikey=YOUR_SAUCE_API_KEY
    -Denvironment=DEVELOPMENT -Dtests.package=com.selgp.opensauce.android
    test