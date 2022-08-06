import { Component, OnInit } from '@angular/core';
import employees from './data/employees.json';
import { Employee } from './employees.model';

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  title:string = 'CosMos - Employee Management System'
  employees:Employee[] = employees;
  filteredEmployees:Employee[] = employees;
  showIcon:boolean = false;
  message:string = ''
  private _designationFilter:string=''
  
  set designationFilter(value: string){
    this._designationFilter = value;
    this.filterByDesignation()
  }

  get designationFilter():string{
    return this._designationFilter;
  }

  //constructor(private employeeService:EmployeeService) { }
  constructor() { }

  ngOnInit(): void {
    // this.subscriber =this.employeeService.getEmployees().subscribe({
    //   next: data=>{
    //   this.filteredEmployees = data;
    //   this.employees = this.filteredEmployees}
    //})
  }
 
  // ngOnDestroy(){
  //   this.subscriber.unsubscribe();
  // }

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

