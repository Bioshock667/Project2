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
        
    	browser.sleep(5000);
    });
    it("should go to trainers page", function(){
        element(by.css('[role="presentation"]')).click();
        browser.sleep(2000);
        element(by.xpath("/html/body/div/ui-view/nav/div/ul[2]/li[7]/ul/li[1]/a")).click();
        browser.sleep(3000);
        expect(browser.getCurrentUrl()).toEqual("https://dev-caliber.revature.tech/caliber/#/vp/trainers");
    });
});