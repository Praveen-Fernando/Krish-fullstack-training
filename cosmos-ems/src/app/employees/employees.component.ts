import { HashLocationStrategy } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { EmployeeService } from './employee.service';
// import employees from './data/employees.json';
import { Employee } from './employees.model';

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit, OnDestroy{

  title:string = 'CosMos - Employee Management System'
  employees!: Employee[];
  filteredEmployees!: Employee[];
  showIcon:boolean = false;
  message:string = ''
  subscriber!:Subscription;
  private _designationFilter:string=''
  
  set designationFilter(value: string){
    this._designationFilter = value;
    this.filterByDesignation()
  }

  get designationFilter():string{
    return this._designationFilter;
  }

  constructor(private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.subscriber =this.employeeService.getEmployees().subscribe({
      next: data=>{
      this.filteredEmployees = data;
      this.employees = this.filteredEmployees}
    })
  }
 
  ngOnDestroy(){
    this.subscriber.unsubscribe();
  }

  toggleIcon(){
    this.showIcon = !this.showIcon;
  }

  filterByDesignation(){
    return this.filteredEmployees = this.employees.filter(employee => employee.designation.includes(this.designationFilter));
  }

  onMessageRecived(value:string){
    this.message = value;
  }
}
