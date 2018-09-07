import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import { Injectable } from '@angular/core';


@Injectable()
export class Provider {

    public API = 'http://167.99.52.238:9090';
    public USERS = this.API + '/users';
    public ALLTASKS = this.API + '/alltasks';
    public ASSIGNEDTASKS = this.API + '/assignedtasks';

    constructor(public http: HttpClient) {

    }
  
    getUsers(): Observable<any>{
        return this.http.get(this.USERS)
      }
     
    getUser(id): Observable<any>{
        return this.http.get(this.USERS + "/" + id)
    }  

    getAllTasks(): Observable<any>{
        return this.http.get(this.ALLTASKS)
      }

    getAssignedTasks(): Observable<any>{
        return this.http.get(this.ASSIGNEDTASKS)
      }

    getOpenTasks(): Observable<any>{
        return this.http.get(this.ASSIGNEDTASKS + "/open")
      }  

    getClosedTasks(): Observable<any>{
        return this.http.get(this.ASSIGNEDTASKS + "/closed")
      }    

    completeTask(params){
        this.http.post(this.ASSIGNEDTASKS + "/complete/" + params, params)
        .subscribe(
            (val) => {
                console.log("POST call successful value returned in body", 
                            val);
            },
            response => {
                console.log("POST call in error", response);
            },
            () => {
                console.log("The POST observable is now completed.");
            });
    }  

    missedTask(params){
        this.http.post(this.ASSIGNEDTASKS + "/expire/" + params, params)
        .subscribe(
            (val) => {
                console.log("POST call successful value returned in body", 
                            val);
            },
            response => {
                console.log("POST call in error", response);
            },
            () => {
                console.log("The POST observable is now completed.");
            });
    }  

    assignTask(params){
        this.http.post(this.ALLTASKS + "/assign/" + params, params)
        .subscribe(
            (val) => {
                console.log("POST call successful value returned in body", 
                            val);
            },
            response => {
                console.log("POST call in error", response);
            },
            () => {
                console.log("The POST observable is now completed.");
            });
    }  

    postAllTasks(params) {
        this.http.post(this.ALLTASKS, params)
        .subscribe(
            (val) => {
                console.log("POST call successful value returned in body", 
                            val);
            },
            response => {
                console.log("POST call in error", response);
            },
            () => {
                console.log("The POST observable is now completed.");
            });
    
    }  

    deleteAllTasks(id) {
        this.http.delete(this.ALLTASKS + "/" + id)
        .subscribe(
            resp => console.log('deleted'),
            error => console.log('error occur, delete fail')
        );
    }



}