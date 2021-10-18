package com.Xml;

import java.util.ArrayList;
import java.util.List;

public class Film {

    private String _id;
    private String _titre;
    private String _titreOriginal;
    private String _dateSortie;
    private String _status;
    private String _note;
    private String _nbNote;
    private String _duree;
    private String _certification;
    private String _image;
    private String _prix;
    private String _tagline;
    private List<Genre> _genres;
    private List<Directeur> _directeures;
    private List<Acteur> _acteures;

    public Film(){
        _genres = new ArrayList<Genre>();
        _directeures = new ArrayList<Directeur>();
        _acteures = new ArrayList<Acteur>();
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_titre() {
        return _titre;
    }

    public void set_titre(String _titre) {
        this._titre = _titre;
    }

    public String get_titreOriginal() {
        return _titreOriginal;
    }

    public void set_titreOriginal(String _titreOriginal) {
        this._titreOriginal = _titreOriginal;
    }

    public String get_dateSortie() {
        return _dateSortie;
    }

    public void set_dateSortie(String _dateSortie) {
        this._dateSortie = _dateSortie;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public String get_nbNote() {
        return _nbNote;
    }

    public void set_nbNote(String _nbNote) {
        this._nbNote = _nbNote;
    }

    public String get_duree() {
        return _duree;
    }

    public void set_duree(String _duree) {
        this._duree = _duree;
    }

    public String get_certification() {
        return _certification;
    }

    public void set_certification(String _certification) {
        this._certification = _certification;
    }

    public String get_image() {
        return _image;
    }

    public void set_image(String _image) {
        this._image = _image;
    }

    public String get_prix() {
        return _prix;
    }

    public void set_prix(String _prix) {
        this._prix = _prix;
    }

    public String get_tagline() {
        return _tagline;
    }

    public void set_tagline(String _tagline) {
        this._tagline = _tagline;
    }

    public List<Genre> get_genres() {
        return _genres;
    }

    public void set_genres(List<Genre> _genres) {
        this._genres = _genres;
    }

    public List<Directeur> get_directeures() {
        return _directeures;
    }

    public void set_directeures(List<Directeur> _directeures) {
        this._directeures = _directeures;
    }

    public List<Acteur> get_acteures() {
        return _acteures;
    }

    public void set_acteures(List<Acteur> _acteures) {
        this._acteures = _acteures;
    }

    public void Styles(String str)
    {
        String[] token = str.split("\u2016");
        Genre genre = null;

        for (var item : token)
        {
            String[] tok = item.split("\u2024");
            genre = new Genre(tok[0],tok[1]);
            _genres.add(genre);
        }
    }
    public void Director(String str)
    {
        String[] token = str.split("\u2016");
        Directeur dir = null;

        for (var item : token)
        {
            String[] tok = item.split("\u2024");
            dir = new Directeur(tok[0],tok[1]);
            _directeures.add(dir);
        }
    }
    public void Actor(String str)
    {
        String[] token = str.split("\u2016");
        Acteur acteur;
        for (var item : token)
        {
            String[] tok = item.split("\u2024");
            if(tok.length <3)
                acteur = new Acteur(tok[0],tok[1],null);
            else
                acteur = new Acteur(tok[0],tok[1],tok[2]);
            _acteures.add(acteur);
        }
    }

    @Override
    public String toString(){

        return "id : " + _id + "\tTitre : " + _titre + "\tTitre original : " + _titreOriginal + "\tDate de sortie : " + _dateSortie +
                "\tStatus : " + _status + "\tNote : " + _note + "\tNombre de vote : " + _nbNote + "\tDuré : " + _duree +
                "\tCertification : " + _certification + "\tImage : " + _image + "\tCout : " + _prix +
                "\tTagline : " + _tagline + "\nGenres :\n " + _genres + "\nDirecteur :\n " + _directeures + "\nActeur :\n " + _acteures;
    }
}
