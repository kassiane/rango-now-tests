Feature: Login action
    As an user of Rango Now
    I want to be able to log in
    So I can use the features provided

Scenario: An authorized user logs in successfully
Given the Rango Now login page is displayed
When user "test.rangonow@gmail.com" logs in using password "rangonow!"
Then the login is successfull

Scenario: Unauthorized login due to wrong password
Given the Rango Now login page is displayed
When user "test.rangonow@gmail.com" logs in using password "wrong"
Then an invalid password error message is displayed

Scenario: Unauthorized login due to wrong email
Given the Rango Now login page is displayed
When user "test.rangonow@gmail.coms" logs in using password "wrong"
Then an invalid email error message is displayed
