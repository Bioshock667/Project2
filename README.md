# Project2

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.2.2.

# Development Roadmap
## Page Object Models
Page Models                     | author   
________________________________|__________________
- [x] Navigation Bar            | Seth
- [x] Home Page                 | Ian
- [ ] Manage Batch Page         | Christian
- [ ] Access Batch Page         | 
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

### ASSESS BATCH:
* Click New Assessment
    * 