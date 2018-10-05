export class ResultRow {
    testName:string;
    testResult:string;
    //may need more properties

    constructor (n:string,r:string) {
        this.testName=n;
        this.testResult=r;
    }
}