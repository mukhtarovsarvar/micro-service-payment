import {Component} from '@angular/core';
import {UzCardService} from "./uz-card.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  desc = '';
  amount: number;
  toCard = '';
  fromCard = '';

  constructor(private transactionService: UzCardService) {
    this.amount = 0;
  }


  public callTransaction() {

    this.transactionService.callTransaction(this.fromCard, this.toCard, this.amount).subscribe(value => {
        console.log(value);
      },
      error => {

      });
  }


}
