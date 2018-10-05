import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServletHttpService {

  constructor(private http:HttpClient) { }

  testGet():Observable<any>{
    return this.http.get("http://52.207.255.20/TestingServlet/go");
  }
}
