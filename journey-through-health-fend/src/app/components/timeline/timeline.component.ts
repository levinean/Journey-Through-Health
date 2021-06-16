import { Component, OnInit } from '@angular/core';
import { EventServiceService } from '../../services/event-service.service';
import { Event, TimelineEvent } from '../../types/event';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css'],
})
export class TimelineComponent implements OnInit {
  entries: TimelineEvent[] = [];
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
      this.entries = events.map((event: Event) => ({
        header: event.name,
        content: event.description,
        date: event.createdAt,
        hospital: event.hospital,
      }));
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
}
