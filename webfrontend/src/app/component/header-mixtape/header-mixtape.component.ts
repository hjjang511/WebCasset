import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header-mixtape',
  standalone: true,
  imports: [RouterModule,CommonModule],
  templateUrl: './header-mixtape.component.html',
  styleUrl: './header-mixtape.component.css'
})
export class HeaderMixtapeComponent {
}
