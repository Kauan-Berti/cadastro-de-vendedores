import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-seller',
  imports: [BrowserModule, FormsModule],
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css',
})
export class SellerComponent {

   @Input()
   seller : Seller = {} as Seller;

   genderSelected: string = 'M';

   convert(genderSelected: string): number {
      return genderSelected === 'M' ? 0 : 1;
   }


  constructor() { };

  @Output()
  saveEmitter = new EventEmitter();

  save(){
    this.seller.gender = this.convert(this.genderSelected);
    this.saveEmitter.emit(this.seller);
  }

}
