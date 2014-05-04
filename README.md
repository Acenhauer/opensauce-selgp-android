Sample Selgp Appium Saucelabs Android Tests project
---

This contains the source code for running sample [Appium](http://github.com/appium/appium) tests using [TestNG](http://www.testng.org) on [SauceLabs](http://www.saucelabs.com)

In order to run the tests, you will need to install [Apache Maven](http://maven.apache.org).

Checkout this repo from Github

    git clone git@github.com:guillemhs/opensauce-selgp.git

Go to the folder where have checkout the code from opensauce selgp and compile it locally using this command:

    mvn -U clean install

Check out this repo from GitHub:

    git clone git@github.com:guillemhs/opensauce-selgp-android.git

Go to the main folder of opensauce-selgp-android and then run the whole suite on Saucelabs using FF:

    mvn -Duser=YOUR_SAUCE_USER -Dapikey=YOUR_SAUCE_API_KEY
    -Denvironment=DEVELOPMENT -Dtests.package=com.selgp.opensauce.android
    test