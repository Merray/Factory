import {RessourceMaterielle} from '../ressourceMaterielle';

export class Salle extends RessourceMaterielle {
  constructor(private _nbPersonne: number, private _cursuss: cursus[]) {
    super();
  }

  get nbPersonne(): number {
    return this._nbPersonne;
  }

  set nbPersonne(value: number) {
    this._nbPersonne = value;
  }

  get cursuss(): cursus[] {
    return this._cursuss;
  }

  set cursuss(value: cursus[]) {
    this._cursuss = value;
  }
}
