# Description
The purpose was to design a web-based application that runs Protractor and TestNG based end-to-end tests.  These Selenium-based tests will target Revature's Caliber website for testing.  A user should be able to issue a command to run the tests and see the resulting report.
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.2.2.

# Development Roadmap
## Page Object Models
Page Models                     | author   
|--------------------------------|----------|
- [x] Navigation Bar            | Seth
- [x] Home Page                 | Ian
- [x] Manage Batch Page         | Christian
- [x] Access Batch Page         | Ian
- [x] Quality Audit Page        | Seth
- [ ] Panel Page                |
- [ ] Reports Page              |
- [ ] Settings - Trainers Page  |
- [ ] Settings - Locations Page |
- [ ] Settings - Category Page  |

## Test order

### NAV BAR:
* Click Revature Logo – Goes to home page
* Click Home – Goes to home page
* Click Manage Batch – Goes to manage batch page
* Click Access Batch – Goes to access batch page
* Click Quality Audit – Goes to quality audit page
* Click Panel – Goes to panel page
* Click Reports – Goes to reports
* Click Settings drop down
    * Click Trainers – Go to trainer page
    * Click Locations – Go to locations page
    * Click Category – Go to category page

### HOME PAGE:
* Click user guide link – Go to external GitHub page
* Click Last Quality Audit States dropdown
    * All States – Loads All States chart
    * FL – Loads Florida chart and All Cities dropdown
        All Cities dropdown – Loads Tampa option
    * VA – Loads Virginia chart and All Cities dropdown
        All Cities dropdown – Loads Reston option
    * NY – Loads New York chart and All Cities dropdown
        All Cities dropdown – Loads Queens option
* Click Weekly Progress States dropdown
    * All States – Loads All States chart
    * FL – Loads Florida chart and All Cities dropdown
       - All Cities dropdown – Loads Tampa option
    * VA – Loads Virginia chart and All Cities dropdown
       - All Cities dropdown – Loads Reston option
    * NY – Loads New York chart and All Cities dropdown
       - All Cities dropdown – Loads Queens option

### MANAGE BATCH:
* Click New Batch 
    * Assert both close buttons close modal
    * for each input filled click "Save" and assert modal is displayed
    * Type **JAVA** in "Type" input
    * select "university for Training type
    * select SDET for skill type
    * Select WVU address for location
    * select Adam for trainer
    * select an option for co-trainer
    * type any date for start date
    * type any date before and after start date for end date
    * send Positive, negative, no value for good and bade grade
* *Assured does not work* After asserting model is not displayed assert batch with our specific info is displayed
* for each option in Year dropdown assert that the first element has a start and end date that matches that option.
    * if not such element exists skip

## Bugs Found
* Everytime a week is added to a batch, the batch's start and end date increases by one day, however these changes are not visible on the front end until the page is refreshed. 
* If you update the batch's date, upon saving, the start date and end date will increase by one day, this will not be visible until the page is refreshed.
* At the Quality Audit page, clicking the Save button, despite confirmation with a green checkmark.  The feedback is gone after refreshing the page.
* At the Manage Batch page:
    * Trainees appear to be deleted after clicking delete, but reappear after refreshing the page
    * After attempting to switch trainees, the changes are not saved.
    * Import Batch button responds with HTTP Status code 500.
    * If the final employee's (or first employee's) training status becomes dropped, the entire batch becomes inaccessible (appears deleted).
* At Access Batch, 

## Unexpected Side-Effects
   if I add a week to a batch with no trainees, it will appear but dissappear on refresh.
   Then add an accessment to a week when the batch has no trainees, the assessment will not show up in the week you have selected
   When you add a trainee then click add week multiple times.  Once you get to the week you added that assessment, that assessment will appear.
   Any weeks created without a trainee will disappear on refresh.
   The newest week associated with a trainee as well as the weeks before will remain on the page after the trainee is deleted.
