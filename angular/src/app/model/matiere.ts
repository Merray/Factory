import {Formateur} from './RessourceHumaineHeritage/formateur';

export class Matiere {
  constructor(private titre?: string, private niveau?: string, private duree?: number, private objectifs?: string,
              private prerequis?: string, private contenue?: string, private formateurs?: Formateur[]) {
  }
}
