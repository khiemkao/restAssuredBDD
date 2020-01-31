# restAssuredBDD 
This is the sample project for API testing.

I use Maven for controlling the libs version.
I use CucumberBDD for driving the tests.
I use RestAssured for working with API.
I use Hamcrest for asserting the result.
 
 
#Before running the tests, we need to start the API server
1. Open folder restAssuredBDD/server in terminal.
2. Run the command: npm run server:start
--> the basic Auth API server will be started.
 
#Execute the test scrips
1. Run the CucumberRunner.java (path: restAssuredBDD\src\test\java\CucumberRunner.java).
2. Reporting is excluded from this sample project. I'm using the default report from cucumber. You can find the report following the path restAssuredBDD\target\site\cucumber-pretty. Open file Index.html using Chrome for viewing.

#Structure
 * data ---> used for storing the test data (input data, expectation).
 * features ---> used for storing the .feature files.
 * hooks --> used for storing the hook files (before / after)
 * plain_Old_Java_Objects ---> used for storing the Objects.
 * step_definitions ---> used for storing the step definitions
 * utils ---> used for storing the core files and supporting files.
 * test runner files
