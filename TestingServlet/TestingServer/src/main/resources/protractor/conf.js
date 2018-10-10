"use strict";
let SpecReporter = require('jasmine-spec-reporter').SpecReporter;


exports.config = {
    seleniumAddress : "http://localhost:4444/wd/hub",
    	specs: ["caliber.js", "trainer.js", "location.js", "category.js"],
    	onPrepare: function(){
    		jasmine.getEnv().addReporter(new SpecReporter({
    		displayFailuresSummary: true,
    		displayFailuredSpec: true,
    		displaySuiteNumber: true,
    		displaySpecDuration: true
	    }));
	  }
}