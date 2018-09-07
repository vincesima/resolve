import { Component } from '@angular/core';

import { AssignedTasksPage } from '../assignedtasks/assignedtasks';
import { AllTasksPage } from '../alltasks/alltasks';

@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab2Root = AssignedTasksPage;
  tab3Root = AllTasksPage;

  constructor() {

  }
}
