import { NgModule } from '@angular/core';
import { ProgressBarComponent } from './progress-bar/progress-bar';
import { SubProgressBarComponent } from './subprogress-bar/subprogress-bar';
@NgModule({
	declarations: [ProgressBarComponent, SubProgressBarComponent],
	imports: [],
	exports: [ProgressBarComponent, SubProgressBarComponent]
})
export class ComponentsModule {}
