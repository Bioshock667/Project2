describe("Caliber Settings tests", function(){
    it("should go to caliber website", function(){
        browser.ignoreSynchronization = true;
        browser.get("https://dev-caliber.revature.tech/");

        browser.sleep(2000);
    });
    it("should login with right credentials", function() {
        element(by.name('username')).sendKeys("calibot@revature.com");
        element(by.name('pw')).sendKeys("*6Ak4-&kXnNTfTh6");
        element(by.className('btn')).click();
    });
    it("should go to the Location Settings page", function(){
        browser.ignoreSynchronization = false;
        browser.get("https://dev-caliber.revature.tech/caliber/#/vp/locations");
        browser.sleep(5000);
    });
    it("should change address after i edit the address", function(){
        
    })
});