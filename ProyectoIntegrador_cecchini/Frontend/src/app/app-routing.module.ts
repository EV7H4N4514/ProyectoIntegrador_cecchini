import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectosComponent } from './components/proyecto/edit-proyectos.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { EditHardysoftskillsComponent } from './components/skills/edit-hardysoftskills.component';
import { NewSkillsComponent } from './components/skills/new-hardysoftskills.component';



const routes: Routes = [
  {path:'', component:HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent},
  { path: 'editexp/:id', component: EditExperienciaComponent},
  {path: 'nuevaedu', component: NewEducacionComponent},
  {path: 'editedu/:id', component: EditEducacionComponent},
  {path: 'nuevoproy', component:NewProyectoComponent},
  {path: 'editproy/:id', component: EditProyectosComponent},
  {path: 'nuevaskills', component: NewSkillsComponent},
  {path: 'editskills/:id', component: EditHardysoftskillsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
