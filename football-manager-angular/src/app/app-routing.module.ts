import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerComponent} from "./player/player.component";
import {TeamComponent} from "./team/team.component";
import {TransferComponent} from "./transfer/transfer.component";

const routes: Routes = [
  {path: 'players', component: PlayerComponent},
  {path: 'teams', component:TeamComponent},
  {path: 'transfer', component: TransferComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
