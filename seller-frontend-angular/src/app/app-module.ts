import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from "./components/footer/footer.component";
import { HeaderComponent } from "./components/header/header.component";
import { SellersComponent } from "./components/sellers/sellers.component";
import { SellerComponent } from "./components/seller/seller.component";

@NgModule({
  declarations: [App],
  imports: [BrowserModule, AppRoutingModule, FormsModule, NgbModule, FooterComponent, HeaderComponent, SellersComponent, SellerComponent],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
