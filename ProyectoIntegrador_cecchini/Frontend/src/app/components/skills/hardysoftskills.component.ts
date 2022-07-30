import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/model/skills';
import { SSkillsService } from 'src/app/service/s-skills.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hardysoftskills',
  templateUrl: './hardysoftskills.component.html',
  styleUrls: ['./hardysoftskills.component.css']
})
export class HardysoftskillsComponent implements OnInit {
  skills: Skills[] = [];
  
  constructor(private sSkills: SSkillsService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void {
    this.sSkills.lista().subscribe(data => { this.skills = data });
  }

  delete(id?: number) {
    if (id != undefined) {
      this.sSkills.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("no se pudo borrar la 'skill'");

        }
      )
    }
  }
}