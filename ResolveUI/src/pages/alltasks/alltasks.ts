import { Component, ViewChild } from '@angular/core';
import { NavController, Nav, Platform } from 'ionic-angular';
import { Provider } from '../../provider/provider';
import { NavParams } from 'ionic-angular/navigation/nav-params';
import { ModalController } from 'ionic-angular/components/modal/modal-controller';
import { CreateTaskPage } from '../create-task/create-task';
import { ModalContentPage } from '../create-task/modal-content';
import { AlertController } from 'ionic-angular';

@Component({
  selector: 'page-alltasks',
  templateUrl: 'alltasks.html'
})
export class AllTasksPage {
  @ViewChild(Nav) nav: Nav;
  allTasks : any;

  constructor(private alertCtrl: AlertController, public navCtrl: NavController, public navParams: NavParams, public provider: Provider, public modalCtrl: ModalController) {

  }
  ngOnInit(){
    this.getAllTasks();
  }

  async getAllTasks(){
    const response =  await this.provider.getAllTasks().toPromise();
    this.allTasks = response;
  }

  doRefresh(refresher) {
    this.getAllTasks();
    console.log('Begin async operation', refresher);

    setTimeout(() => {
      console.log('Async operation has ended');
      refresher.complete();
    }, 1000);
  }

  openModal() {
    let modal = this.modalCtrl.create(ModalContentPage);
    modal.onDidDismiss(() => {
      this.getAllTasks();
    });
    modal.present();
  }

  async assignTask(task){
    this.provider.assignTask(task.id);
    setTimeout(() => {
      console.log('Async operation has ended');
      this.getAllTasks();
    }, 100);
  }

  async deleteTask(task){
    this.provider.deleteAllTasks(task.id);
    setTimeout(() => {
      console.log('Async operation has ended');
      this.getAllTasks();
    }, 100);
  }

  confirmDelete(task) {
    let alert = this.alertCtrl.create({
      title: 'Warning',
      message: 'Are you sure you\'d like to delete this task?',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Delete',
          handler: () => {
            this.deleteTask(task);
          }
        }
      ]
    });
    alert.present();
  }

  confirmAssign(task) {
    let alert = this.alertCtrl.create({
      title: 'Assign Task',
      message: 'Are you sure you\'d like to assign this task? You will lose Exp if it is not completed!',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Assign',
          handler: () => {
            this.assignTask(task);
          }
        }
      ]
    });
    alert.present();
  }

}
