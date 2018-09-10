export class Coordonnee {
  constructor (private _telFixe?: string, private _telPortable?: string, private _mail?: string){

  }

  get telFixe(): string {
    return this._telFixe;
  }

  set telFixe(value: string) {
    this._telFixe = value;
  }

  get telPortable(): string {
    return this._telPortable;
  }

  set telPortable(value: string) {
    this._telPortable = value;
  }

  get mail(): string {
    return this._mail;
  }

  set mail(value: string) {
    this._mail = value;
  }
}
