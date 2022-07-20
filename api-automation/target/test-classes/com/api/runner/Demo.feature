@SmokeTest
Feature: Validate Jira APIs
Scenario: validate get task api
Given I have Jira get task details api
When I send request to fetch task details
|TaskID|
|Test-001|
Then I should get the task details