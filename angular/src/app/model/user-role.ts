import {Role} from './role.enum';
import {User} from './user';

export class UserRole {
  constructor(private _id?: number, private _role?: Role, private _user?: User) {
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get role(): Role {
    return this._role;
  }

  set role(value: Role) {
    this._role = value;
  }

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }
}
