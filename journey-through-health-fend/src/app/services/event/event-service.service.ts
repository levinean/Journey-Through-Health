import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import {
  Event,
  EVENT_PRIORITY,
  EVENT_TYPE,
  Filter,
  SearchFilter,
} from '../../types/event';

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
  private searchApiUrl = 'http://localhost:8080/events/search/';

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
    filters?: Filter[],
    searchNameFilter?: SearchFilter,
    searchHospitalFilter?: SearchFilter
  ): Observable<Event[]> {
    const queryParams = this.buildSearchParams(
      filters,
      searchNameFilter,
      searchHospitalFilter
    );
    const query =
      queryParams.length === 0
        ? this.apiUrl
        : `${this.searchApiUrl}${queryParams}`;

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
    filters?: Filter[],
    searchNameFilter?: SearchFilter,
    searchHospitalFilter?: SearchFilter
  ): string {
    let query = '';
    if (filters && filters.length > 0) {
      const filterSearchParams = filters
        .map((filter) => filter.searchParam)
        .join(',');
      query += filterSearchParams;
    }

    if (searchNameFilter && searchNameFilter.length > 0) {
      query = [query, searchNameFilter].join(',');
    }

    if (searchHospitalFilter && searchHospitalFilter.length > 0) {
      query = [query, searchHospitalFilter].join(',');
    }
    return query;
  }
}
