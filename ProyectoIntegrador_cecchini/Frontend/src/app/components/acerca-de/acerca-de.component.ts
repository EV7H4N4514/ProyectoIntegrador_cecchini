import { Component, OnInit } from '@angular/core';
import { Acercade } from 'src/app/model/acercade';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { SAcercadeService } from 'src/app/service/s-acercade.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","");
  acercade : Acercade[] = [];
  
  constructor(public personaService: PersonaService, private sAcercade: SAcercadeService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data})

    this.cargarAcercade();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarAcercade(): void {
    this.sAcercade.lista().subscribe(
      data => { this.acercade = data;
      }
    )
  }

  delete(id?: number){
    if( id != undefined){
      this.sAcercade.delete(id).subscribe(
        data => {
          this.cargarAcercade();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }

  }

}
