import { Component, OnInit } from '@angular/core';
import {ServletGetService } from './servlet-get.service'
import { Observable } from 'rxjs';
import { ServletHttpService } from './services/servlet-http.service';
import { ResultRow } from './model/result-row';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor (private serAcc:ServletHttpService) {}
  ngOnInit() {}
  testResult:Observable<any> = this.serAcc.testGet();
  tableResult:Observable<ResultRow[]> = this.serAcc.runTests("tableGet");
  navResult:Observable<ResultRow[]> = this.serAcc.runTests("navBar");
  homeResult:Observable<ResultRow[]> = this.serAcc.runTests("homePage");
  lCukeResult:Observable<ResultRow[]> = this.serAcc.runTests("loginCuke");
  colorResult:Observable<ResultRow[]> = this.serAcc.runTests("colorFace");
  auditResult:Observable<ResultRow[]> = this.serAcc.runTests("auditTest");
  manageBatchResult:Observable<ResultRow[]> = this.serAcc.runTests("managebatchtest");
  auditYearsResult:Observable<ResultRow[]> = this.serAcc.runTests("BAYearsTest");
  trainTestResult:Observable<ResultRow[]> = this.serAcc.runTests("protractor");
  assessBatchResult:Observable<ResultRow[]> = this.serAcc.runTests("AssessBatchTest");
  title = 'Project2';
  showTable=false;
  loading = false;
  displayedColumns=["tname","tres"]
  tRows:ResultRow[];
servResult="no response yet";
  testServlet() {
   this.testResult.subscribe(resp => {
    this.servResult = resp.mainData;
   });
  }

  testTable() {
    this.showTable=false;
    this.tableResult.subscribe(resp=> {
      console.log(resp.length);
      console.log(resp[0]);
      console.log(resp[0].testName);
      this.tRows=resp;
      this.showTable=true;
    });
  }

  testNav() {
    this.showTable=false;
    this.loading = true;
    this.navResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testHome() {
    this.showTable=false;
    this.loading = true;
    this.homeResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testLCuke() {
    this.showTable=false;
    this.loading = true;
    this.lCukeResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testColor() {
    this.showTable=false;
    this.loading = true;
    this.colorResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testAudit() {
    this.showTable=false;
    this.loading = true;
    this.auditResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testAuditYears() {
    this.showTable=false;
    this.loading = true;
    this.auditYearsResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testTrain() {
    this.showTable=false;
    this.loading = true;
    this.trainTestResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testManageBatch() {
    this.showTable=false;
    this.loading = true;
    this.manageBatchResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  testAssessBatch() {
    this.showTable=false;
    this.loading = true;
    this.assessBatchResult.subscribe(resp=>{
      this.tRows=resp;
      this.loading=false;
      this.showTable=true;
    },resp=>{this.servErr(resp)});
  }

  servErr(resp) {
    this.loading=false;
    this.tRows = [new ResultRow("Error", resp.message)];//"An error occourrred retrieving data from the server")];
    this.showTable=true;
  }
}
