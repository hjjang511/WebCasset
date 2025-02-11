import { Component } from '@angular/core';

import { MatDialog } from '@angular/material/dialog';

import { RouterModule } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';
import { HeaderComponent } from '../header/header.component';
import { HuongdanComponent } from '../huongdan/huongdan.component';

@Component({
  selector: 'app-trangchu',
  standalone: true,
  imports: [HeaderComponent,FooterComponent,RouterModule],
  templateUrl: './trangchu.component.html',
  styleUrl: './trangchu.component.css'
})
export class TrangchuComponent {
  isSlidePanelOpen = false;
  constructor(private dialogRef: MatDialog){}
  openHuongDan(){
    this.dialogRef.open(HuongdanComponent);
  }
}
