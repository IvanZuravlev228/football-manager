import { Component } from '@angular/core';
import {PlayerRequest} from "../model/PlayerRequest";
import {HttpClient} from "@angular/common/http";
import {PlayerResponse} from "../model/PlayerResponse";
import {environment} from "../../environment/environment";

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent {
  playerRequest: PlayerRequest = new PlayerRequest();
  playerResponse: PlayerResponse = new PlayerResponse()
  id: number = 0;
  showGetById: boolean = false;
  showAddNewPlayer: boolean = false;
  isSend: boolean = false;
  messageToUser: string = "";

  constructor(private http:HttpClient) {
  }

  showGetByIdBlock(): void {
    this.showGetById = !this.showGetById;
  }

  showAddNewPlayerBlock() {
    this.showAddNewPlayer = !this.showAddNewPlayer;
  }

  getPlayerById(): void {
    this.isSend = true;
    this.http.get<PlayerResponse>(environment.backendURL + "/players/" + this.id).subscribe({
      next: ((response: PlayerResponse) => {
        this.playerResponse = response;
        console.log(this.playerResponse);
      }),
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }

  addNewPlayer(): void {
    const body = JSON.stringify(this.playerRequest);
    console.log(body);
    this.http.post<PlayerRequest>(environment.backendURL + "/players", body, {
      headers: {
        "Content-Type": "application/json"
      }
    }).subscribe({
      next: ((response: any) => {
        this.playerRequest = response;
        console.log(this.playerRequest);
        this.clearForm();
        this.messageToUser = "You successful add a new user!"
      }),
      error: (error => {
        console.log(error);
        this.messageToUser = "Something went wrong. Try again"
      })
    })
  }

  clearForm(): void {
    this.playerRequest = {
      firstName: '',
      lastName: '',
      age: 0,
      experience: 0,
      dateOfBirth: new Date(),
      countryOfBirth: ''
    };
  }

  deletePlayer(): void {
    this.http.delete<PlayerResponse>(environment.backendURL + "/players/" + this.id).subscribe({
      next: ((response: PlayerResponse) => {
        this.playerResponse = response;
        console.log(this.playerResponse);
      }),
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }
}
