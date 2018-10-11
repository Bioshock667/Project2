import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResultRow } from '../model/result-row';

@Injectable({
  providedIn: 'root'
})
export class ServletHttpService {

  constructor(private http:HttpClient) { }

  testGet():Observable<any>{
    return this.http.get("http://52.207.255.20:8080/TestingServer/go");
  }

  runTests(name:string):Observable<ResultRow[]> {
    return this.http.get<ResultRow[]>("http://52.207.255.20:8080/TestingServer/"+name);

  }
}
