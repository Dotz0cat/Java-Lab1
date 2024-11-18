# Java-Lab 1
## Now redone for Lab 4

I implemented the stratagy and the factory patern.
I implemented the factory pattern with `Denomation`.
I made `USMoneyFactory` which makes USD denomations.
`USMoneyFactory` implments the `MoneyFactory` interface.
This allows application of the stratagy pattern later on.
I implemented the stratagy pattern with `Register`.
`Register` holds an object that implements the `ChangeMaker` interface.
When `Register.makeChange` is called it first makes a denomation collection then calls the selected changemaker method.
I also added several diffrent ChangeMakers.
Least Change which makes the least amount of change.
All coins which only uses coins.
Randomized Change which uses random denomations.

All that was needed to implement these patterns other than the affected objects was to add a combo box to select the stratagy in RegisterPanel.

