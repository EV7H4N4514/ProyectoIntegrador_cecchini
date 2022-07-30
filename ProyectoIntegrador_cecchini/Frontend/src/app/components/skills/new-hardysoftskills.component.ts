import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SSkillsService } from 'src/app/service/s-skills.service';

@Component({
  selector: 'app-new-skills',
  templateUrl: './new-hardysoftskills.component.html',
  styleUrls: ['./new-hardysoftskills.component.css']
})
export class NewSkillsComponent implements OnInit {
  nombreSk: string='';
  porcentaje: string = '';
  imgSkills: string = '';

  constructor(private sSkills: SSkillsService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const skills = new Skills(this.nombreSk, this.porcentaje, this.imgSkills);
    this.sSkills.save(skills).subscribe(
      data => {
        alert("Skill añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Skill existente");
        this.router.navigate(['']);
      }
    )
}}
