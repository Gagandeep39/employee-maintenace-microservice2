import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent implements OnInit {
  public now: Date = new Date();

  constructor() {
    setInterval(() => {
      this.now = new Date();
    }, 1);
  }

  ngOnInit() {}
}
