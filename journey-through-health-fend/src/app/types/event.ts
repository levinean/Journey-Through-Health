import { Image } from './image';
import { Note } from './note';

export enum EVENT_TYPE {
  APPOINTMENT = 'appointment',
  SURGERY = 'surgery',
  EXAM = 'exam',
  TEST = 'test',
  IMAGING = 'imaging',
}

export enum EVENT_PRIORITY {
  HIGH = 'high',
  MEDIUM = 'medium',
  LOW = 'low',
}

export type Event = {
  id: string;
  patientId: string;
  name: string;
  description: string;
  hospital: string;
  created_at: string;
  type: EVENT_TYPE;
  priority: EVENT_PRIORITY;
  notes: Note[];
  images: Image[];
};
