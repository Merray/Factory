import {RessourceMaterielle} from '../ressourceMaterielle';
import {Cursus} from '../cursus';


export class VideoProjecteur extends RessourceMaterielle {
  constructor(private _cursus?: Cursus[]) {
    super();
  }

  get cursus(): Cursus[] {
    return this._cursus;
  }

  set cursus(value: Cursus[]) {
    this._cursus = value;
  }
}
