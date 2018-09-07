import { Component } from '@angular/core';
import { HttpHeaders } from '@angular/common/http'
import { NavParams, Platform, ViewController } from 'ionic-angular';
import { Provider } from '../../provider/provider';

@Component({
    selector: 'page-modal-content',
    templateUrl: 'modal-content.html'
  })

export class ModalContentPage {
  task = {
    "task": "",
    "exp": -1,
    "strengthExp": -1,
    "intelligenceExp": -1,
    "constitutionExp": -1,
    "dexterityExp": -1,
    "frequency": -1,
    "timeLimit": 0,
    "timesCompleted": 0,
    "timesMissed": 0,
    "lastAssigned": "1970-01-01T23:59:59"
  }

  totalExp: number;

    constructor(
      public platform: Platform,
      public params: NavParams,
      public viewCtrl: ViewController,
      public provider: Provider
    ) {}

    async submitTask(){
      if(this.task.task.length > 1 && this.task.strengthExp > -1  && this.task.intelligenceExp > -1  && this.task.dexterityExp > -1 && this.task.constitutionExp > -1 && this.task.frequency > 0 && this.task.timeLimit > 0){
        this.task.exp = await this.getExpTotal(this.task.strengthExp , this.task.intelligenceExp, this.task.dexterityExp, this.task.constitutionExp);
        this.provider.postAllTasks(this.task);
        this.dismiss();
        }else{
             alert("Please Complete the Form!");
        }
      }

      async getExpTotal(num, num1, num2, num3){
        return parseInt(num) + parseInt(num1) + parseInt(num2) + parseInt(num3);
      }

    dismiss() {
      this.viewCtrl.dismiss();
    }
  }