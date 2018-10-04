import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServletGetService {

  constructor(private http: HttpClient) { }
i = {name:""};
  initalTest() {
    this.http.get("http://52.207.255.20:8080/TestingServer/go").subscribe((data:Config)=>this.i = {
      name: data["mainData"],
     
    });
  }
}
