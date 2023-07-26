# Web Application Automation Using Selenium & TestNG (Cross Browsers)

This project serves as a boilerplate for automating web applications across various browsers and environments using TestNG and the Selenium library.

## Prerequisites
1. Java
2. Maven
3. NodeJS

## How to run tests
1. Using IntelliJ IDEA
    * Go to Maven Profiles
    * Select `chrome`, `headless-chrome`, `firefox`, `headless-firefox`, `edge`, `ie` or `safari` Maven Profile as the browser
    * Select `dev`, `qa`, `uat`, `pre-prod` or `prod` Maven Profile as the environment
    * Select the test classes on the `src/test/java` folder
    * Right-click and click on `Run`


2. Using Command Line
    * To run tests in Firefox browser against the QA environment

      `mvn clean test -Pfirefox,qa`
    * To run tests in Safari browser against the UAT environment

      `mvn clean test -Psafari,uat`

**Note**: By default, if no Maven profiles are selected, the tests will be executed on the `chrome` browser and in the `dev` environment.

## License
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/License_icon-mit-2.svg/2000px-License_icon-mit-2.svg.png" alt="MIT License" width="100" height="100"/> [MIT License](https://opensource.org/licenses/MIT)

## Copyright
Copyright 2023 [MaxSoft](https://maxsoftlk.github.io/).
