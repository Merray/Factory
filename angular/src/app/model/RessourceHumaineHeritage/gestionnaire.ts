import {RessourceHumaine} from '../ressource-humaine';
import {Cursus} from '../cursus';

export class Gestionnaire extends RessourceHumaine {
  constructor(private _cursusGeres?: Cursus[]) {
    super();
  }


  get cursusGeres(): Cursus[] {
    return this._cursusGeres;
  }

  set cursusGeres(value: Cursus[]) {
    this._cursusGeres = value;
  }
}
