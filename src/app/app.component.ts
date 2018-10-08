import { Component, OnInit } from '@angular/core';
import {ServletGetService } from './servlet-get.service'
import { Observable } from 'rxjs';
import { ServletHttpService } from './services/servlet-http.service';
import { ResultRow } from './model/result-row';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';



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
    })
  }
}
