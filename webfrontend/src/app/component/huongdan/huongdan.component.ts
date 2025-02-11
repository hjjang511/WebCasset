import { Component } from '@angular/core';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-huongdan',
  standalone: true,
  imports: [MatDialogModule],
  templateUrl: './huongdan.component.html',
  styleUrl: './huongdan.component.css'
})
export class HuongdanComponent {
  constructor(private dialogRef: MatDialog){}
  closeAll(){
    this.dialogRef.closeAll();
  }
}
