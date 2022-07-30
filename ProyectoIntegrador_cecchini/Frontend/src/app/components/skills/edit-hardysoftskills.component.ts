import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SSkillsService } from 'src/app/service/s-skills.service';

@Component({
  selector: 'app-edit-hardysoftskills',
  templateUrl: './edit-hardysoftskills.component.html',
  styleUrls: ['./edit-hardysoftskills.component.css']
})
export class EditHardysoftskillsComponent implements OnInit {
  skills: Skills = null;

  constructor(private sSkills: SSkillsService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sSkills.detail(id).subscribe(data => {
      this.skills = data;
    }, err => {
      alert("Error al modificar skills");
      this.router.navigate(['']);
    }
    )
  }

onUpdate(): void {
  const id= this.activatedRouter.snapshot.params['id'];
  this.sSkills.update(id, this.skills).subscribe(data =>{ this.router.navigate(['']);
  }, err => {
    alert("Error al modificar skill");
    this.router.navigate([''])
  }
  )
}

}
