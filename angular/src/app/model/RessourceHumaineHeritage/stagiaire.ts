import {RessourceHumaine} from '../ressource-humaine';
import {Ordinateur} from '../RessourceMaterielle/ordinateur';
import {Cursus} from '../cursus';

export class Stagiaire extends RessourceHumaine {
  constructor(private _profil?: string, private _ordinateur?: Ordinateur, private _cursus?: Cursus) {
    super();
  }

  get profil(): string {
    return this._profil;
  }

  set profil(value: string) {
    this._profil = value;
  }

  get ordinateur(): Ordinateur {
    return this._ordinateur;
  }

  set ordinateur(value: Ordinateur) {
    this._ordinateur = value;
  }

  get cursus(): Cursus {
    return this._cursus;
  }

  set cursus(value: Cursus) {
    this._cursus = value;
  }
}
