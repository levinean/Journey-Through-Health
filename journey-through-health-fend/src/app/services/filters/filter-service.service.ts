import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Filter, SearchFilter } from 'src/app/types/event';

@Injectable({
  providedIn: 'root',
})
export class FilterServiceService {
  filters: Filter[] = [];
  searchNameFilter: SearchFilter = '';
  searchHospitalFilter: SearchFilter = '';
  private subject = new Subject<any>();

  constructor() {}

  updateFilters(typeFilters: Filter[], priorityFilters: Filter[]) {
    const checkedTypeFilters = typeFilters.filter((filter) => filter.checked);
    const checkedPriorityFilters = priorityFilters.filter(
      (filter) => filter.checked
    );
    this.filters = checkedTypeFilters.concat(checkedPriorityFilters);
    this.subject.next({
      filters: this.filters,
      searchNameFilter: this.searchNameFilter,
      searchHospitalFilter: this.searchHospitalFilter,
    });
  }

  updateSearchNameFilter(newSearch: SearchFilter) {
    this.searchNameFilter = newSearch;
    this.subject.next({
      filters: this.filters,
      searchNameFilter: this.searchNameFilter,
      searchHospitalFilter: this.searchHospitalFilter,
    });
  }

  updateSearchHospitalFilter(newSearch: SearchFilter) {
    this.searchHospitalFilter = newSearch;
    this.subject.next({
      filters: this.filters,
      searchNameFilter: this.searchNameFilter,
      searchHospitalFilter: this.searchHospitalFilter,
    });
  }

  onFilterChange(): Observable<{
    filters: Filter[];
    searchNameFilter: SearchFilter;
    searchHospitalFilter: SearchFilter;
  }> {
    return this.subject.asObservable();
  }
}
