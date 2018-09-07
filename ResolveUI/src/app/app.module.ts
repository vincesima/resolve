import { NgModule, ErrorHandler, enableProdMode  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { AssignedTasksPage } from '../pages/assignedtasks/assignedtasks';
import { AllTasksPage } from '../pages/alltasks/alltasks';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Provider } from '../provider/provider';
import { HttpClientModule } from '@angular/common/http';
import { ProgressBarComponent } from '../components/progress-bar/progress-bar';
import { RoundPipe } from '../pipes/round.pipe';
import { CreateTaskPage } from '../pages/create-task/create-task';
import { ModalContentPage } from '../pages/create-task/modal-content';
import { SubProgressBarComponent } from '../components/subprogress-bar/subprogress-bar';

@NgModule({
  declarations: [
    MyApp,
    AssignedTasksPage,
    AllTasksPage,
    CreateTaskPage,
    ProgressBarComponent,
    SubProgressBarComponent,
    RoundPipe,
    ModalContentPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpClientModule,

  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AssignedTasksPage,
    AllTasksPage,
    CreateTaskPage,
    ModalContentPage,
    ProgressBarComponent,
    SubProgressBarComponent

  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Provider,
  ]
})
export class AppModule {}
enableProdMode();
