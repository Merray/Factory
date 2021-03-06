import {Stagiaire} from './RessourceHumaineHeritage/stagiaire';
import {Lesson} from './lesson';
import {VideoProjecteur} from './RessourceMaterielleHeritage/videoProjecteur';
import {Salle} from './RessourceMaterielleHeritage/salle';
import {Gestionnaire} from './RessourceHumaineHeritage/gestionnaire';

export class Cursus {


  constructor(private _id?: number, private _dateDebut?: Date, private _dateFin?: Date, private _nbStagiaire?: number,
              private _stagiaires?: Stagiaire[], private _gestionnaire?: Gestionnaire,
              private _salle?: Salle, private _videoProjecteur?: VideoProjecteur, private _lessons?: Lesson[]) {
  }


  get gestionnaire(): Gestionnaire {
    return this._gestionnaire;
  }

  set gestionnaire(value: Gestionnaire) {
    this._gestionnaire = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get dateDebut(): Date {
    return this._dateDebut;
  }

  set dateDebut(value: Date) {
    this._dateDebut = value;
  }

  get dateFin(): Date {
    return this._dateFin;
  }

  set dateFin(value: Date) {
    this._dateFin = value;
  }

  get nbStagiaire(): number {
    return this._nbStagiaire;
  }

  set nbStagiaire(value: number) {
    this._nbStagiaire = value;
  }

  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }

  set stagiaires(value: Stagiaire[]) {
    this._stagiaires = value;
  }

  get salle(): Salle {
    return this._salle;
  }

  set salle(value: Salle) {
    this._salle = value;
  }

  get videoProjecteur(): VideoProjecteur {
    return this._videoProjecteur;
  }

  set videoProjecteur(value: VideoProjecteur) {
    this._videoProjecteur = value;
  }

  get lessons(): Lesson[] {
    return this._lessons;
  }

  set lessons(value: Lesson[]) {
    this._lessons = value;
  }
}
