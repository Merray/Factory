import {Adresse} from './adresse';
import {Coordonnee} from './coordonnee';

export abstract class RessourceHumaine {
  constructor(private _id?: number, private _nom?: string, private _prenom?: string, private _coordonnee?: Coordonnee,
              private _adresse?: Adresse, private _type?: string) {

  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get coordonnee(): Coordonnee {
    return this._coordonnee;
  }

  set coordonnee(value: Coordonnee) {
    this._coordonnee = value;
  }

  get adresse(): Adresse {
    return this._adresse;
  }

  set adresse(value: Adresse) {
    this._adresse = value;
  }

  get type(): string {
    return this._type;
  }

  set type(value: string) {
    this._type = value;
  }
}
