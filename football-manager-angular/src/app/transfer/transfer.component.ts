import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent {
  fromTeamId: number = -1;
  toTeamId: number = -1;
  playerId: number = -1;

  constructor(private http: HttpClient) {
  }

  makeTransfer() {
    this.http.get<any>("http://localhost:6867/transfer?fromTeamId=" + this.fromTeamId
                                      + "&toTeamId=" + this.toTeamId
                                      + "&playerId=" + this.playerId).subscribe({
      next: ((response: any) => {
        console.log(response);
        this.fromTeamId = -1;
        this.toTeamId = -1;
        this.playerId = -1;
      }),
      error: (error => {
        console.log("Something went wrong ");
        console.log(error)
      })
    })
  }
}
