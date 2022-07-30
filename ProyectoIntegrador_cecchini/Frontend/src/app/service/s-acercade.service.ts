import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Acercade } from '../model/acercade';

@Injectable({
  providedIn: 'root'
})
export class SAcercadeService {
  URL: string = 'http://localhost:8080/acercade/';

  constructor( private httpClient: HttpClient) { }

  public lista():Observable<Acercade[]>{
    return this.httpClient.get<Acercade[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<Acercade>{
    return this.httpClient.get<Acercade>(this.URL + `detail/${id}`);
  }

  public save(acercade: Acercade): Observable<any>{
    return this.httpClient.post<any>(this.URL + 'create', acercade);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }
  
}
