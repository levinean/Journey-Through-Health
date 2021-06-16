import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css'],
})
export class TimelineComponent implements OnInit {
  alternate: boolean = true;
  toggle: boolean = true;
  color: boolean = false;
  size: number = 40;
  expandEnabled: boolean = true;
  contentAnimation: boolean = true;
  dotAnimation: boolean = true;
  side = 'left';

  constructor() {}

  ngOnInit(): void {}

  entries = [
    {
      header: 'header',
      content: 'content',
    },
  ];

  onHeaderClick(event: MouseEvent) {
    if (!this.expandEnabled) {
      event.stopPropagation();
    }
  }

  onDotClick(event: MouseEvent) {
    if (!this.expandEnabled) {
      event.stopPropagation();
    }
  }

  onExpandEntry(expanded: boolean, index: number) {
    console.log(`Expand status of entry #${index} changed to ${expanded}`);
  }
}
