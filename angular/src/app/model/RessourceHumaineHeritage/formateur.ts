import {RessourceHumaine} from '../ressource-humaine';

export class Formateur extends RessourceHumaine {
  constructor(private _lecons?: Lecon, private _matieres?: Matiere[]) {
    super();
  }

  get lecons(): Lecon {
    return this._lecons;
  }

  set lecons(value: Lecon) {
    this._lecons = value;
  }

  get matieres(): Matiere[] {
    return this._matieres;
  }

  set matieres(value: Matiere[]) {
    this._matieres = value;
  }
}
