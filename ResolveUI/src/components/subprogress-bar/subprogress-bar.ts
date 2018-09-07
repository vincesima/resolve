import { Component, Input } from '@angular/core';
 
@Component({
  selector: 'subprogress-bar',
  templateUrl: 'subprogress-bar.html'
})
export class SubProgressBarComponent {
 
  @Input('progress') progress;
  @Input('levelup') levelup;
  @Input('completed') completed;
 
  constructor() {
 
  }
 
}