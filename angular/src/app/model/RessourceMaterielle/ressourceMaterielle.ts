export abstract class RessourceMaterielle {

  constructor(private _id?: number, private _code?: string, private _coutUtilisation?: number) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get code(): string {
    return this._code;
  }

  set code(value: string) {
    this._code = value;
  }

  get coutUtilisation(): number {
    return this._coutUtilisation;
  }

  set coutUtilisation(value: number) {
    this._coutUtilisation = value;
  }
}
