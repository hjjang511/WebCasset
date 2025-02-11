import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-camon',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './camon.component.html',
  styleUrl: './camon.component.css'
})
export class CamonComponent {
  constructor(private dialogRef: MatDialog){}
  closeCamOn(){
    this.dialogRef.closeAll();
  }
}
