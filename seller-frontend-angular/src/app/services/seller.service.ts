import { Injectable } from '@angular/core';
import { Seller } from '../interfaces/Seller';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root',
})
export class SellerService {

  private apiUrl = 'http://localhost:8080/sellers';

  constructor(private http: HttpClient) { }

  getSellers() : Observable<Seller[]>{
    return this.http.get<Seller[]>(this.apiUrl);
  }

  saveSeller(seller: Seller): Observable<Seller>{
    return this.http.post<Seller>(this.apiUrl, seller);
  }

  deleteSeller(id: number){
    return this.http.delete<Seller>(`${this.apiUrl}/${id}`);
  }

  updateSeller(id: number, seller: Seller){
    return this.http.put<Seller>(`${this.apiUrl}/${id}`, seller);
  }
}
