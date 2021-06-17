import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MglTimelineModule } from 'angular-mgl-timeline';
import { SidebarModule } from 'ng-sidebar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelineComponent } from './components/timeline/timeline.component';
import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FiltersComponent } from './components/filters/filters.component';

@NgModule({
  declarations: [AppComponent, TimelineComponent, HeaderComponent, SidebarComponent, FiltersComponent],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatIconModule,
    MatToolbarModule,
    MglTimelineModule,
    SidebarModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
