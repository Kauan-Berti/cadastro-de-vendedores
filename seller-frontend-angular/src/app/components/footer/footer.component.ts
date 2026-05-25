import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css',
})
export class FooterComponent {
  projectName: string = 'Cadastro de Vendedores';
  developerName: string = 'Kauan Berti';
}
