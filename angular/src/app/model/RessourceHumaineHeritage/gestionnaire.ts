import {RessourceHumaine} from '../ressource-humaine';

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
