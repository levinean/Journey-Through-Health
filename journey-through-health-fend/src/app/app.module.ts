import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MglTimelineModule } from 'angular-mgl-timeline';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelineComponent } from './components/timeline/timeline.component';

@NgModule({
  declarations: [AppComponent, TimelineComponent],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MglTimelineModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
