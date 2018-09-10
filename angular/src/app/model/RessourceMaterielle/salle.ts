import {RessourceMaterielle} from './ressourceMaterielle';

export class Salle extends RessourceMaterielle {
  constructor(private _nbPersonne: number) {
    super();
  }

  get nbPersonne(): number {
    return this._nbPersonne;
  }

  set nbPersonne(value: number) {
    this._nbPersonne = value;
  }
}
