import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css'],
})
export class FiltersComponent implements OnInit {
  priorityFilters = [
    { checked: false, name: 'High' },
    { checked: false, name: 'Medium' },
    { checked: false, name: 'Low' },
  ];
  typeFilters = [
    { checked: false, name: 'Appointment' },
    { checked: false, name: 'Surgery' },
    { checked: false, name: 'Imaging' },
    { checked: false, name: 'Exam' },
    { checked: false, name: 'Test' },
  ];
  constructor() {}

  ngOnInit(): void {}
}
