# Project2

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 6.2.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

# Development Roadmap
## Page Object Models
Page Models | author   
------------|--------
- [x] Navigation Bar | Seth
- [x] Home Page | Ian
- [ ] Manage Batch Page | Christian
- [ ] Access Batch Page | Seth
- [ ] Quality Audit Page |
- [ ] Panel Page |
- [ ] Reports Page |
- [ ] Settings - Trainers Page |
- [ ] Settings - Locations Page |
- [ ] Settings - Category Page |

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
    * Type **JAVA** in "Type" input
*Todo*

### ASSESS BATCH:
