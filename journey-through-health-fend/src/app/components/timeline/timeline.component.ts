import { Component, OnInit } from '@angular/core';
import { EventServiceService } from '../../services/event/event-service.service';
import { Event, EVENT_PRIORITY } from '../../types/event';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css'],
})
export class TimelineComponent implements OnInit {
  entries: Event[] = [];
  alternate: boolean = true;
  toggle: boolean = true;
  color: boolean = false;
  size: number = 40;
  expandEnabled: boolean = true;
  contentAnimation: boolean = true;
  dotAnimation: boolean = true;
  side = 'left';

  constructor(private eventService: EventServiceService) {}

  ngOnInit(): void {
    this.eventService.getAllEvents().subscribe((events: Event[]) => {
      this.entries = events;
    });
  }

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

  getColorForPriority(type: EVENT_PRIORITY): string {
    switch (type) {
      case EVENT_PRIORITY.HIGH:
        return 'red';
      case EVENT_PRIORITY.MEDIUM:
        return 'orange';
      case EVENT_PRIORITY.LOW:
        return 'yellow';
    }
  }
}
