import { Component } from '@angular/core';

import { RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderMixtapeComponent } from '../header-mixtape/header-mixtape.component';
import { HeaderComponent } from '../header/header.component';


@Component({
  selector: 'app-themnhac1',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,HeaderMixtapeComponent,RouterModule],
  templateUrl: './themnhac1.component.html',
  styleUrl: './themnhac1.component.css'
})
export class Themnhac1Component {

}
