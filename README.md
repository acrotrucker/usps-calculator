[![Travis](http://badges.herokuapp.com/travis/christian-draeger/basic-selenium-project?env=BROWSER=googlechrome&label=Chrome&branch=master)](https://travis-ci.org/christian-draeger/basic-selenium-project)

[![Travis](http://badges.herokuapp.com/travis/christian-draeger/basic-selenium-project?env=BROWSER=safari&label=Safari&branch=master)](https://travis-ci.org/christian-draeger/basic-selenium-project)

USPS Postage Calculator Selenium Java Project
===================================

This project is written in **Java** and will serve an example of implementing a 
Selenium test project to test USPS Postage Calculator.
Used Testrunner is **TestNG**.

### Prerequisites
* \>=**JDK14**
* \>=**Maven**
* \>=**TestNG**

---

#### 💻 Implemented Browsers
* Chrome and Safari (will work on OSX machines only)

---

#### 📜 Page Object Model used
Creates an object repository for storing all web elements. 
Consider each web page of an application as a class file.

---

#### 🕹️ Full control over parameters and test execution with usps-postage-calculator.xml file

---

#### 📸 Take Screenshots
On test failures screenshots will automatically be taken and stored under `./screenshots`.
The screenshot files will be named with a combination of test method name and date timestamp.

---

#### 📟 Beautiful Reports Output
All default reports are generated.
But index.html provides best representation of test execution output and is designed to create 
reports that are clear to everyone to check test execution time, 
overall test result overviews, test result history, etc. 

---

#### 🔁 Retries
Conveniently run a single Test Multiple Times with Retry Analyzer.

---

#### ⏱️ Waits
Waits helps to test web applications that are asynchroniously loading / rerendering parts of the page. 


---


#### 🚀  Test Case
A client would like to ship 25 lbs of devices equipment from Austin (ZIP code 78727) to San Francisco (ZIP code 94107)
There are 3 types of Home Depot Moving boxes that can be used for shipping:
Small - (16 in. L x 12 in. W x 12 in. D)
Medium -  (22 in. L x 16 in. W x 15 in. D)
Large - (28 in. L x 15 in. W x 16 in. D)
We “Calculate price based on Shape and Size” for the “USPS Retail Ground, Retail price” for each box type.
(Choose any shipping date in March)
If the price is higher than $80 - the test should fail. 
If the price is less than $80 - the test passes.
Validate that there are images present on the final “Mail Services” page.


#### Maintenance
#### check for dependency updates

____________________
____________________
