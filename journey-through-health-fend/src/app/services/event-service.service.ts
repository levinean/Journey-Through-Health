import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Event, EVENT_PRIORITY, EVENT_TYPE } from '../types/event';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class EventServiceService {
  private apiUrl = 'http://localhost:8080/events';

  fakeEvent: Event = {
    id: 'fake_event_id',
    patient_id: 'fake_patient_id',
    name: 'test',
    description: 'test Description',
    hospital: 'testHospital',
    date: '05-02-2020 10:31:42',
    type: EVENT_TYPE.APPOINTMENT,
    priority: EVENT_PRIORITY.HIGH,
  };

  constructor(private http: HttpClient) {}

  getAllEvents(
    type: EVENT_TYPE,
    priority: EVENT_PRIORITY
  ): Observable<Event[]> {
    const events: Event[] = [];

    events.push(this.fakeEvent);
    this.http.get<Event[]>(this.apiUrl);
    return of(events);
  }

  createEvent(newEvent: Event): Observable<Event> {
    this.http.post<Event>(this.apiUrl, newEvent, httpOptions);
    return of(this.fakeEvent);
  }

  getEvent(eventId: string): Observable<Event> {
    this.http.get<Event>(`${this.apiUrl}/${eventId}`);
    return of(this.fakeEvent);
  }

  editEvent(eventId: string, newEvent: Event): Observable<Event> {
    this.http.put<Event>(`${this.apiUrl}/${eventId}`, newEvent, httpOptions);
    return of(this.fakeEvent);
  }

  deleteEvent(eventId: string): Observable<Event> {
    this.http.delete<Event>(`${this.apiUrl}/${eventId}`);
    return of(this.fakeEvent);
  }
}
