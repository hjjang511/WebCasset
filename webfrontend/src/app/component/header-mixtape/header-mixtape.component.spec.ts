import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderMixtapeComponent } from './header-mixtape.component';

describe('HeaderMixtapeComponent', () => {
  let component: HeaderMixtapeComponent;
  let fixture: ComponentFixture<HeaderMixtapeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeaderMixtapeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HeaderMixtapeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
