import {RessourceMaterielle} from './ressourceMaterielle';
import {Stagiaire} from '../RessourceHumaineHeritage/stagiaire';


export class Ordinateur extends RessourceMaterielle {
  constructor(private _processeur?: string, private _ram?: number, private _disqueDur?: number, private _anneeAchat?: Date,
              private _stagiaires?: Stagiaire[]) {
    super();
  }
  get processeur(): string {
    return this._processeur;
  }
  set processeur(value: string) {
    this._processeur = value;
  }

  get ram(): number {
    return this._ram;
  }

  set ram(value: number) {
    this._ram = value;
  }

  get disqueDur(): number {
    return this._disqueDur;
  }

  set disqueDur(value: number) {
    this._disqueDur = value;
  }

  get anneeAchat(): Date {
    return this._anneeAchat;
  }

  set anneeAchat(value: Date) {
    this._anneeAchat = value;
  }
}
