import {RessourceHumaine} from '../ressource-humaine';

export class Formateur extends RessourceHumaine {
  constructor(private _lessons?: Lesson, private _matieres?: Matiere[]) {
    super();
  }

  get lecons(): Lecon {
    return this._lecons;
  }

  set lessons(value: Lesson) {
    this._lessons = value;
  }

  get matieres(): Matiere[] {
    return this._matieres;
  }

  set matieres(value: Matiere[]) {
    this._matieres = value;
  }
}
