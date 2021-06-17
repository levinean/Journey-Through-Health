import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Filter, SearchFilter } from 'src/app/types/event';

@Injectable({
  providedIn: 'root',
})
export class FilterServiceService {
  filters: Filter[] = [];
  searchFilter: SearchFilter = '';
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
      searchFilter: this.searchFilter,
    });
  }

  updateSearchFilter(newSearch: SearchFilter) {
    this.searchFilter = newSearch;
    this.subject.next({
      filters: this.filters,
      searchFilter: this.searchFilter,
    });
  }

  onFilterChange(): Observable<{
    filters: Filter[];
    searchFilter: SearchFilter;
  }> {
    return this.subject.asObservable();
  }
}
