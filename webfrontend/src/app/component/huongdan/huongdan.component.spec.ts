import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HuongdanComponent } from './huongdan.component';

describe('HuongdanComponent', () => {
  let component: HuongdanComponent;
  let fixture: ComponentFixture<HuongdanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HuongdanComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HuongdanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
