Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: NWD withParam
Given Create New NWD
When nwd <num1> i <num2>
Then equal <num3>

Examples:
|num1|num2|num3|
|2|4|2|
|1|3|1|
|6|3|3|
|9|6|3|
