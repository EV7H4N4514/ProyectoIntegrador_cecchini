import { Component, OnInit } from '@angular/core';
import { Proyectos } from 'src/app/model/proyectos';
import { TokenService } from 'src/app/service/token.service';
import { SProyectosService } from 'src/app/service/s-proyectos.service'

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectoComponent implements OnInit {
  
  proy: Proyectos [] = [];

  constructor(private sProyectos: SProyectosService, private tokenService: TokenService){ }

  isLogged= false;

  ngOnInit(): void {
    this.cargarProyectos();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  
  }

  cargarProyectos(): void {
    this.sProyectos.lista().subscribe(
      data => {this.proy = data;}
    )
  }

  delete(id?:number){
    if(id !== undefined) {
      this.sProyectos.delete(id).subscribe(
        data => {this.cargarProyectos();
        }, err =>{alert("No se puedo borrar el proyecto");}
      )
    }
  }

}
