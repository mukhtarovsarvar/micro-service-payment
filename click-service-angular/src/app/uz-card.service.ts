import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CommonCons} from "./detail/CommonCons";

@Injectable({
  providedIn: 'root'
})
export class UzCardService {

  constructor(private http:HttpClient) { }


  public callTransaction(fromCard:string,toCard:string,amount:number):Observable<any>{

    let headers = new HttpHeaders({'Content-type': 'application/json'})

    const json = {
      'fromCardNumber': fromCard,
      'toCardNumber': toCard,
      'amount':amount
    }

    console.log(json);
    return this.http.post<any>(CommonCons.uzCardUrl.concat('api/v1/transaction'), json, {headers: headers});
  }
}
