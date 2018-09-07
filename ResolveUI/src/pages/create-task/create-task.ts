import { ModalContentPage } from './modal-content';
import { Component } from '@angular/core';
import { NavController, NavParams, ModalController} from 'ionic-angular';



@Component({
  selector: 'page-create-task',
  templateUrl: 'create-task.html',
})
export class CreateTaskPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public modalCtrl: ModalController) {
  }
    
    
    openModal() {
      let modal = this.modalCtrl.create(ModalContentPage);
    modal.present();
    }
  }
