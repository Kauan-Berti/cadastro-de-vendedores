import { Component } from '@angular/core';
import { SellerComponent } from "../seller/seller.component";
import { Seller } from '../../interfaces/Seller';
import { CommonModule } from '@angular/common';
import { SellerService } from '../../services/seller.service';

@Component({
  selector: 'app-sellers',
  imports: [SellerComponent, CommonModule],
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css',
})
export class SellersComponent {


  seller: Seller = {} as Seller
  //isUpdate: boolean = false;

  sellers: Seller[] = [];

  constructor(private sellerService: SellerService) { }


  ngOnInit(): void {
    this.loadSellers();
    this.saveSeller();
  }

  loadSellers() {
    this.sellerService
      .getSellers()
      .subscribe({
        next: (s => (this.sellers = s))
      });
  }

  saveSeller() {
    this.sellerService
      .saveSeller(this.seller)
      .subscribe({
        next: s => {
          this.sellers.push(s);
          this.seller = {} as Seller;
        }
      })
  }



 /**update(selectedSeller: Seller) {
    this.seller = selectedSeller;
    const id: number = selectedSeller.id;
    //this.isUpdate = true;
    this.sellerService.updateSeller(selectedSeller.id, this.seller)
      .subscribe(() => {
        this.loadSellers();
      });

  }**/


  removeSeller(id: number) {
    this.sellerService.deleteSeller(id).subscribe(() => {
      this.sellers = this.sellers.filter(s => s.id !== id);
    });
  }

  convertGenderToString(gender: number): string {
    return gender === 0 ? 'M' : 'F';
  }

  convertGenderToNumber(gender: string): number {
    return gender === 'M' ? 0 : 1;
  }


}
