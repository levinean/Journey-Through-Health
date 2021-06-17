import { Component, OnInit } from '@angular/core';
import { Filter, SearchFilter } from 'src/app/types/event';
import { FilterServiceService } from '../../services/filters/filter-service.service';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css'],
})
export class FiltersComponent implements OnInit {
  priorityFilters: Filter[] = [
    { checked: false, name: 'High', searchParam: 'high' },
    { checked: false, name: 'Medium', searchParam: 'medium' },
    { checked: false, name: 'Low', searchParam: 'low' },
  ];
  typeFilters: Filter[] = [
    { checked: false, name: 'Appointment', searchParam: 'appointment' },
    { checked: false, name: 'Surgery', searchParam: 'surgery' },
    { checked: false, name: 'Imaging', searchParam: 'imaging' },
    { checked: false, name: 'Exam', searchParam: 'exam' },
    { checked: false, name: 'Test', searchParam: 'test' },
  ];
  searchNameFilter: SearchFilter = '';
  searchHospitalFilter: SearchFilter = '';
  constructor(private filterService: FilterServiceService) {}

  ngOnInit(): void {}

  updateTypeFilters(filterIndex: number) {
    this.typeFilters[filterIndex].checked =
      !this.typeFilters[filterIndex].checked;
    this.filterService.updateFilters(this.typeFilters, this.priorityFilters);
  }

  updatePriorityFilters(filterIndex: number) {
    this.priorityFilters[filterIndex].checked =
      !this.priorityFilters[filterIndex].checked;
    this.filterService.updateFilters(this.typeFilters, this.priorityFilters);
  }
  updateSearchNameFilter(event: any) {
    this.searchNameFilter = event.target.value;
    this.filterService.updateSearchNameFilter(this.searchNameFilter);
  }

  updateSearchHospitalFilter(event: any) {
    this.searchHospitalFilter = event.target.value;
    this.filterService.updateSearchHospitalFilter(this.searchHospitalFilter);
  }
}
