import { Component, OnInit } from '@angular/core';
import {ServletGetService } from './servlet-get.service'
import { Observable } from 'rxjs';
import { ServletHttpService } from './services/servlet-http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor (private serAcc:ServletHttpService) {}
  testResult:Observable<any> = this.serAcc.testGet();
  title = 'Project2';
servResult="no response yet";
  testServlet() {
   this.testResult.subscribe(resp => {
    this.servResult = resp.mainData;
   });
  }
}
