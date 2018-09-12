import {Formateur} from './RessourceHumaineHeritage/formateur';
import {Lesson} from './lesson';

export class Matiere {
  constructor(private _id?: number, private _titre?: string, private _niveau?: string, private _duree?: number, private _objectifs?: string,
              private _prerequis?: string, private _contenu?: string, private _formateurs?: Formateur[], private _lessons?: Lesson[]) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get titre(): string {
    return this._titre;
  }

  set titre(value: string) {
    this._titre = value;
  }

  get niveau(): string {
    return this._niveau;
  }

  set niveau(value: string) {
    this._niveau = value;
  }

  get duree(): number {
    return this._duree;
  }

  set duree(value: number) {
    this._duree = value;
  }

  get objectifs(): string {
    return this._objectifs;
  }

  set objectifs(value: string) {
    this._objectifs = value;
  }

  get prerequis(): string {
    return this._prerequis;
  }

  set prerequis(value: string) {
    this._prerequis = value;
  }

  get contenu(): string {
    return this._contenu;
  }

  set contenu(value: string) {
    this._contenu = value;
  }

  get formateurs(): Formateur[] {
    return this._formateurs;
  }

  set formateurs(value: Formateur[]) {
    this._formateurs = value;
  }

  get lessons(): Lesson[] {
    return this._lessons;
  }

  set lessons(value: Lesson[]) {
    this._lessons = value;
  }
}
