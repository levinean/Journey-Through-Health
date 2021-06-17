import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Image } from '../types/image';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class ImageServiceService {
  private apiUrl = 'http://localhost:8080/images';

  fakeImage: Image = {
    id: 'fake_note_id',
    event_id: 'fake_event_id',
    image: 'Fake Note',
    date: '05-02-2020 10:31:42',
  };

  constructor(private http: HttpClient) {}

  createImage(newImage: Image): Observable<Image> {
    this.http.post<Image>(this.apiUrl, newImage, httpOptions);
    return of(this.fakeImage);
  }

  editImage(imageId: string, newImage: Image): Observable<Image> {
    this.http.put<Image>(`${this.apiUrl}/${imageId}`, newImage, httpOptions);
    return of(this.fakeImage);
  }

  deleteImage(imageId: string): Observable<Image> {
    this.http.delete<Image>(`${this.apiUrl}/${imageId}`);
    return of(this.fakeImage);
  }
}
