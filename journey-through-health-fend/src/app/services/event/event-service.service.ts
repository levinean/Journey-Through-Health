import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Event, EVENT_PRIORITY, EVENT_TYPE } from '../../types/event';

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
    patientId: 'fake_patient_id',
    name: 'test',
    description: 'test Description',
    hospital: 'testHospital',
    created_at: '05-02-2020 10:31:42',
    type: EVENT_TYPE.APPOINTMENT,
    priority: EVENT_PRIORITY.HIGH,
    images: [],
    notes: [],
  };

  constructor(private http: HttpClient) {}

  getAllEvents(
    type?: EVENT_TYPE,
    priority?: EVENT_PRIORITY
  ): Observable<Event[]> {
    const events: Event[] = [];
    const queryParams = this.buildSearchParams(type, priority);
    const query =
      queryParams.length === 0 ? this.apiUrl : `${this.apiUrl}?${queryParams}`;

    events.push(this.fakeEvent);

    return this.http.get<Event[]>(query);
  }

  createEvent(newEvent: Event): Observable<Event> {
    return this.http.post<Event>(this.apiUrl, newEvent, httpOptions);
  }

  getEvent(eventId: string): Observable<Event> {
    return this.http.get<Event>(`${this.apiUrl}/${eventId}`);
  }

  editEvent(eventId: string, newEvent: Event): Observable<Event> {
    return this.http.put<Event>(
      `${this.apiUrl}/${eventId}`,
      newEvent,
      httpOptions
    );
  }

  deleteEvent(eventId: string): Observable<Event> {
    return this.http.delete<Event>(`${this.apiUrl}/${eventId}`);
  }

  private buildSearchParams(
    type?: EVENT_TYPE,
    priority?: EVENT_PRIORITY
  ): string {
    let query = '';
    const searchParams: { [searchParam: string]: string } = {};
    if (type) searchParams['type'] = type;
    if (priority) searchParams['priority'] = priority;
    const hasSearchParams = Object.entries(searchParams).length !== 0;
    if (hasSearchParams) {
      for (const [key, value] of Object.entries(searchParams)) {
        query += `${key}=${value}&`;
      }
      query.slice(query.length - 1);
    }
    return query;
  }
}
