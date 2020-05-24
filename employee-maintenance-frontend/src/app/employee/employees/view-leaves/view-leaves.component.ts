/*
 @author Pranav Karmarkar
*/
import { Component, OnInit } from '@angular/core';
import { LeaveService } from 'src/app/service/leave.service';
import { LeavePage } from 'src/app/models/leave-page.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-leaves',
  templateUrl: './view-leaves.component.html',
  styleUrls: ['./view-leaves.component.css']
})
export class ViewLeavesComponent implements OnInit {

  public leavePage: LeavePage = new LeavePage();
  public currentPage: number;
  public leaveBalance: number = 0;
  public isLoading: boolean = false;
  public errorMessage: string;

  constructor(private leaveService: LeaveService, private route: Router) { }

  ngOnInit() {
    this.fetchLeaveBalance();
    this.fetchDatafromServer(0);
    this.currentPage = 0;
  }
  fetchLeaveBalance() {
    this.leaveService.getLeaveBalance().subscribe(response => this.leaveBalance = response);
  }

  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.showLoading();
    this.leaveService
      .getLeavePages(pageNo, pageSize)
      .subscribe((response) => {
        this.leavePage = response;
        this.hideLoading();
      }, error => {
        this.handleError(error);
      });
  }

  handleError(error: any) {
    this.isLoading = false;
    this.errorMessage = 'Something went wrong :(';
    console.log(error);
    setTimeout(()=>this.errorMessage=undefined, 4000)
  }

  goToPage(pageNo: number) {
    this.currentPage = pageNo;
    this.fetchDatafromServer(pageNo);
  }

  previousPage() {
    this.fetchDatafromServer(this.currentPage--);
  }

  nextPage() {
    this.fetchDatafromServer(this.currentPage++);
  }

  counter(i: number) {
    return new Array(i);
  }

  createLeave() {
    this.route.navigate(['employee/addleave']);
  }

  showLoading() {
    this.isLoading = true;
  }

  hideLoading() {
    this.isLoading = false;
  }

}
