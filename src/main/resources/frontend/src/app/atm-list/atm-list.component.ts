import { Component, OnInit } from '@angular/core';
import { AtmService } from '../shared/atm/atm.service';
@Component({
  selector: 'app-atm-list',
  templateUrl: './atm-list.component.html',
  styleUrls: ['./atm-list.component.css']
})
export class AtmListComponent implements OnInit {
  atms: Array<any>;
  searchText = '';
  constructor(private atmService: AtmService) { }

  ngOnInit() {
  }

  doSearch() {
	this.atmService.getAtm(this.searchText).subscribe(data => {
		this.atms = data;
	  });
  }

}
