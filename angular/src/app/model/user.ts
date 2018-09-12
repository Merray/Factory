export class User {
  constructor(private _username?: string, private _password?: string, private _enable?: boolean, private _role?: string) {
  }


  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get enable(): boolean {
    return this._enable;
  }

  set enable(value: boolean) {
    this._enable = value;
  }

  get role(): string {
    return this._role;
  }

  set role(value: string) {
    this._role = value;
  }
}
