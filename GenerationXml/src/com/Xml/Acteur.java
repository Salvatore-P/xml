package com.Xml;

public class Acteur {

    private String _id;
    private String _nom;
    private String _character;

    public Acteur(String id, String nom, String role){
        _id = id;
        _nom = nom;
        _character = role;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nom() {
        return _nom;
    }

    public void set_nom(String _nom) {
        this._nom = _nom;
    }

    public String get_character() {
        return _character;
    }

    public void set_character(String _character) {
        this._character = _character;
    }

    @Override
    public String toString(){
        return "id :\t" + _id + "\tNom :\t" + _nom + "\trole :\t" + _character;
    }
}
