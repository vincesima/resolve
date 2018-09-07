import { Component } from '@angular/core';
import { NavController, NavParams, Nav, Tabs } from 'ionic-angular';
import { Provider } from '../../provider/provider';
import { AlertController } from 'ionic-angular';
import { TabsPage } from '../tabs/tabs';
import { ModalContentPage } from '../create-task/modal-content';
import { ModalController } from 'ionic-angular/components/modal/modal-controller';



@Component({
  selector: 'page-assignedtasks',
  templateUrl: 'assignedtasks.html'
})
export class AssignedTasksPage {
  assignedTasks : any;
  hoursRemaining : any;
  public user : any;
  public id : number;
  public progress : number;
  public expanded : any;


  constructor(public nav: Nav, private alertCtrl: AlertController, public navCtrl: NavController, public navParams: NavParams, public provider: Provider, public modalCtrl: ModalController) {
    this.id = 1;
    this.expanded = false;

  }
  ngOnInit(){
    this.getDefaultUser();
    this.getAssignedTasks(); 
    setInterval(() => {      
      this.getAssignedTasks(); 
      this.getDefaultUser();
    },1000);
  }

  async getDefaultUser(){
    const response =  await this.provider.getUser(this.id).toPromise();
    this.user = response;
    this.progress = (this.user.expThisLevel/this.user.totalExpForNextLevelUp)*100;

    }

  async getAssignedTasks(){
    const response =  await this.provider.getOpenTasks().toPromise();
    this.assignedTasks = response;
    this.assignedTasks = await this.assignedTasks.sort(this.compare);
    await this.checkForExpired();
  }

  async completeTask(task){
    this.provider.completeTask(task.id);
  }

  async checkForExpired(){
    for(let task of this.assignedTasks){
      if(this.calcTime(task.deadline) < 0){
        this.expireTask(task);
        console.log("Task expired")
      }
    }
    console.log("Expired checked")
  }

  async expireTask(task){
    this.provider.missedTask(task.id);
  }

  confirmComplete(task) {
    let alert = this.alertCtrl.create({
      title: 'Complete Task',
      message: 'Task complete? ' + task.exp + ' exp will be awarded!',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Complete',
          handler: () => {
            this.completeTask(task);
          }
        }
      ]
    });
    alert.present();
  }
  
  calcTime(time){
    var milliDeadline = Date.parse(time);
    var now = new Date();
    var milliNow = (now.getTime());

    return (milliDeadline - milliNow);
  }

  findBgColor(time){
    var remaining = this.calcTime(time);
    var color: any;
    //48 hours
    if (remaining > 86400000){
      color = '#25B7EF';
      //36 hours
    }else if(remaining > 129600000 ) {
      color = '#49C3F1';
      //24 hours
    }else if(remaining > 86400000 ) {
      color = '#6DCFF4';
      //12 hours
    }else if(remaining > 43200000 ) {
      color = '#92DBF7';
      //6 hours
    }else if(remaining > 21600000 ) {
      color = '#B6E7F9';
      //2 hours
    } else if(remaining > 7200000) {
      color = '#DAF3FC'
    } else {
      color = '#FFFFFF';
    }
    return color;
  }

  findTextColor(time){
    var remaining = this.calcTime(time);
    var color: any;
    //48 hours
    if (remaining > 86400000){
      color = '#FFFFFF';
      //36 hours
    }else if(remaining > 129600000 ) {
      color = '#D4D4D4';
      //24 hours
    }else if(remaining > 86400000 ) {
      color = '#AAAAAA';
      //12 hours
    }else if(remaining > 43200000 ) {
      color = '#7F7F7F';
      //6 hours
    }else if(remaining > 21600000 ) {
      color = '#555555';
      //2 hours
    } else if(remaining > 7200000) {
      color = '#2A2A2A'
    } else {
      color = '#000000';
    }
    return color;
  }

  timeRemaining(ms) {
    var seconds = Math.floor(ms/1000);
    var hours = Math.floor((seconds/3600)); 
    seconds = seconds % 3600; 
    var minutes = this.pad(Math.floor(seconds / 60));
    seconds = this.pad(seconds % 60);
    this.hoursRemaining = hours;
    return (hours) + ":" + (minutes) + ":" + seconds;

    }

    pad(d) {
    return (d < 10) ? '0' + d.toString() : d.toString();
}


///LEARN ABOUT ASSERTJ
toggle() {
  if (this.expanded == false) {
      this.expanded = true;
  } else {
      this.expanded = false;
  }
}

compare(a,b){
  const taskA = a.deadline;
  const taskB = b.deadline;
  let comparison = 0;
  if (taskA > taskB) {
    comparison = 1;
  } else if (taskA < taskB) {
    comparison = -1;
  }
  return comparison * 1;
}  

openModal() {
  let modal = this.modalCtrl.create(ModalContentPage);

  modal.present();
}


}
