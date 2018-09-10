import {RessourceHumaine} from '../ressource-humaine';
import {Lesson} from '../lesson';
import {Matiere} from '../matiere';

export class Formateur extends RessourceHumaine {
  constructor(private _lessons?: Lesson, private _matieres?: Matiere[]) {
    super();
  }

  get lessons(): Lesson {
    return this._lessons;
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
