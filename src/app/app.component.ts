import { Component, OnInit } from '@angular/core';
import {ServletGetService } from './servlet-get.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor (private serAcc:ServletGetService) {}
  title = 'Project2';
servResult="no response yet";
  testServlet() {
    this.serAcc.initalTest();
    this.servResult = this.serAcc.i.name;
  }
}
