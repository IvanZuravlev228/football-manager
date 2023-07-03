import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TeamRequest} from "../model/TeamRequest";
import {TeamResponse} from "../model/TeamResponse";
import {PlayerResponse} from "../model/PlayerResponse";

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent {
  teamRequest: TeamRequest = new TeamRequest();
  teamResponse: TeamResponse = new TeamResponse();
  teams: TeamResponse[] = [];
  players: PlayerResponse[] = [];
  playerIds: string = "";
  showAddNewTeam: boolean = false;
  showPlayers: boolean = false;

  constructor(private http:HttpClient) {
  }

  getAllTeams() {
    this.http.get<TeamResponse[]>("http://localhost:6867/teams").subscribe({

      // Успешное выполнение
      next: ((response: TeamResponse[]) => {
        this.teams = response;
        console.log(this.teamResponse);
      }),

      // Выполнение с ошибкой
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }

  deleteTeam(id: bigint) {
    this.http.delete<any>("http://localhost:6867/teams/" + id).subscribe({

      // Успешное выполнение
      next: ((response: any) => {
        console.log(response);
        this.getAllTeams();
      }),

      // Выполнение с ошибкой
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }

  addTeam() {
    // Преобразование playerIds из строки в массив чисел
    // Устанавливаем playerIds в модель команды
    this.teamRequest.playersId = this.playerIds.split(', ').map(id => +id.trim());

    const body = JSON.stringify(this.teamRequest);
    console.log(body);
    this.http.post<any>("http://localhost:6867/teams", body, {
      headers: {
        "Content-Type": "application/json"
      }
    }).subscribe({

      // Успешное выполнение
      next: ((response: any) => {
        console.log(response);
        this.teamRequest = new TeamRequest();
        this.playerIds = '';
        this.getAllTeams();
      }),

      // Выполнение с ошибкой
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }

  getAllPlayers(id: bigint) {
    this.showPlayers = true;
    this.http.get<PlayerResponse[]>("http://localhost:6867/teams/players/" + id).subscribe({

      // Успешное выполнение
      next: ((response: PlayerResponse[]) => {
        this.players = response;
        console.log(response);

      }),

      // Выполнение с ошибкой
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }

  showAddNewTeamBlock() {
    this.showAddNewTeam = !this.showAddNewTeam;
  }
}
