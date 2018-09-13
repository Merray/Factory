import {UserRole} from './user-role';

export class User {
  constructor(private _username?: string, private _password?: string, private _enable?: boolean, private _roles?: UserRole[]) {
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

  get roles(): UserRole[] {
    return this._roles;
  }

  set roles(value: UserRole[]) {
    this._roles = value;
  }
}
