import { Component } from '@angular/core';
import { SellerComponent } from "../seller/seller.component";
import { Seller } from '../../interfaces/Seller';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sellers',
  imports: [SellerComponent, CommonModule],
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css',
})
export class SellersComponent {


  seller: Seller = {} as Seller
  isUpdate: boolean = false;
  idCounter: number = 3;

  sellers: Seller[] = [
    {
      id: 1,
      name: 'João Silva',
      salary: 5000,
      bonus: 1000,
      gender: 0
    },
    {
      id: 2,
      name: 'Maria Souza',
      salary: 6000,
      bonus: 1500,
      gender: 1
    }
  ];

  constructor() { }


  saveSeller(){
      if(!this.isUpdate){
        this.seller.id = this.idCounter;
        this.idCounter++;
        this.sellers.push(this.seller);
      }

      this.seller = {} as Seller;
      this.isUpdate = false;
    }

    update(selectedSeller: Seller){
      this.seller = selectedSeller;
      this.isUpdate = true;
    }

    remove(selectedSeller: Seller){
      this.sellers = this.sellers.filter(s => s !== selectedSeller);
    }



  convertGenderToString(gender: number): string {
    return gender === 0 ? 'M' : 'F';
  }

  convertGenderToNumber(gender: string): number {
    return gender === 'M' ? 0 : 1;
  }

}
