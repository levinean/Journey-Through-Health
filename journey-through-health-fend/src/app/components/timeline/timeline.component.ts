import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { Subscription } from 'rxjs';

import { EventServiceService } from '../../services/event/event-service.service';
import { FilterServiceService } from '../../services/filters/filter-service.service';
import { NoteServiceService } from '../../services/note/note-service.service';
import { Event, EVENT_PRIORITY } from '../../types/event';
import { Note } from '../../types/note';

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
  showAddNoteModal = false;
  subscription: Subscription;

  constructor(
    private eventService: EventServiceService,
    private noteService: NoteServiceService,
    private filterService: FilterServiceService,
    public dialog: MatDialog
  ) {
    this.subscription = this.filterService
      .onFilterChange()
      .subscribe(({ filters, searchNameFilter, searchHospitalFilter }) => {
        this.eventService
          .getAllEvents(filters, searchNameFilter, searchHospitalFilter)
          .subscribe((events: Event[]) => (this.entries = events));
      });
  }

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

  openDialog(eventId: string, eventIndex: number) {
    const dialogRef = this.dialog.open(DialogContent);

    dialogRef.afterClosed().subscribe((result) => {
      if (result !== null && result.length > 0) {
        const newNote: Note = {
          note: result,
        };
        this.noteService
          .createNote(newNote, eventId)
          .subscribe((result) => this.entries[eventIndex].notes.push(result));
      }
    });
  }
}

@Component({
  selector: 'dialog-content',
  templateUrl: 'dialog-content.html',
})
export class DialogContent {
  constructor() {}
  note: string = '';

  updateNote(event: any): void {
    this.note = event.target.value;
  }
}
