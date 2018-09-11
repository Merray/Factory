import {RessourceMaterielle} from '../ressourceMaterielle';
import {Cursus} from '../cursus';

export class Salle extends RessourceMaterielle {
  constructor(private _nbPersonne: number, private _cursus: Cursus[]) {
    super();
  }

  get nbPersonne(): number {
    return this._nbPersonne;
  }

  set nbPersonne(value: number) {
    this._nbPersonne = value;
  }

  get cursus(): Cursus[] {
    return this._cursus;
  }

  set cursus(value: Cursus[]) {
    this._cursus = value;
  }
}
