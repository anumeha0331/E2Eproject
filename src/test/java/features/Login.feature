Feature: Application Login

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And click on the "http://www.qaclickacademy.com/" site
And click on the login link on HomePage to land on Secure sign in page
When User enters <username> and <password> 	and logsIn
Then Verify that user is successfully logIn 
And close browsers


Examples:
|username									|password	|
|anumeha.gupta.0331@gmail.com				|abcd1234	|
|test123@gmail.com							|1234		|

