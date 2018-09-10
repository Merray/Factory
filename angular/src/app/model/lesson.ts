import {Formateur} from './RessourceHumaineHeritage/formateur';
import {Cursus} from './cursus';
import {Matiere} from './matiere';

export class Lesson {
  constructor(private _dateDebut?: Date, private _dateFin?: Date, private _cursus?: Cursus, private _matiere?: Matiere,
              private _formateur?: Formateur) {

  }


  get dateDebut(): Date {
    return this._dateDebut;
  }

  set dateDebut(value: Date) {
    this._dateDebut = value;
  }

  get dateFin(): Date {
    return this._dateFin;
  }

  set dateFin(value: Date) {
    this._dateFin = value;
  }

  get cursus(): Cursus {
    return this._cursus;
  }

  set cursus(value: Cursus) {
    this._cursus = value;
  }

  get matiere(): Matiere {
    return this._matiere;
  }

  set matiere(value: Matiere) {
    this._matiere = value;
  }

  get formateur(): Formateur {
    return this._formateur;
  }

  set formateur(value: Formateur) {
    this._formateur = value;
  }
}
