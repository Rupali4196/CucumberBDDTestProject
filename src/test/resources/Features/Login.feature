Feature: OrangeHRM Login
@Sanity
Scenario: Valid login
Given user is on OrangeHRM login page
When user enters username "Admin" and password "admin123"
And clicks on login button
Then user should see "dashboard"

@regression
Scenario Outline: Login validation
Given user is on OrangeHRM login page
When user enters username "<username>" and password "<password>"
And clicks on login button
Then user should see "<result>"

Examples:
| username | password  | result    |
| Admin    | admin123  | dashboard |
| admin    | admin123  | Invalid credentials|

