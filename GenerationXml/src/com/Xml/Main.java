package com.Xml;

import java.io.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Film movies;
        try {
            BufferedReader br = OpenBuffRe();
            BufferedWriter bw = OpenBuffWr("XML_ModifierXSD.xml");
            ecritureEntete(bw, "InfosXSD.xsd");
            String str = "";
            while((str = br.readLine()) != null) {
                //remplace les entité
                //&
                str = str.replace("&","&amp;");
                //"
                str = str.replace("\"","&quot;");
                //<
                str = str.replace("<","&lt;");
                //>
                str = str.replace(">","&gt;");
                //'
                str = str.replace("\'","&apos;");
                movies = lectureDocument(str);
                EcritureDocument(movies, bw);
            }
            bw.write("</videotheque>\n");
            br.close();
            bw.close();
            System.out.println("Modification terminée!");
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
    public static void printTag(BufferedWriter bw, String tag, String data, int NbTab,boolean simple, boolean open, boolean close) throws IOException {
        if(simple)
            bw.write("\t".repeat(NbTab) + "<" + tag + "> " + data + " </" + tag + ">\n");
        else{
            if (open)
                bw.write("\t".repeat(NbTab) + "<" + tag + ">\n");
            //bw.write("\t".repeat(NbTab + 1) + data + "\n");
            if (close)
                bw.write("\t".repeat(NbTab) + "</" + tag + ">\n");
        }
    }
    public static BufferedWriter OpenBuffWr(String name) throws IOException {

        String FileName = "Fichier\\" + name;
        File file = new File(FileName);
        return new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
    }
    public static BufferedReader OpenBuffRe() throws IOException {

        return new BufferedReader(new FileReader("C:\\Users\\conti\\Documents\\CoursInfo\\BAC 3\\Q1\\XML & BD avancées\\xml\\Fichier\\1000movies.txt"));
    }
    public static void ecritureEntete(BufferedWriter bw, String schema) throws IOException {
        String doctype = "<!DOCTYPE videotheque SYSTEM \"" + schema + "\">\n";
        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        //bw.write(doctype);
        bw.write("<videotheque\n" +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "xsi:noNamespaceSchemaLocation=\"InfosXSD.xsd\">\n"
                );
        //bw.write("<videotheque>\n");
    }
    public static Film lectureDocument(String str) throws IllegalAccessException {
        String[] token,date;
        int i;
        Film movies = new Film();
        token = str.split("\u2023");
        if(token[3] !="") {
            date = token[3].split("-");
            token[3] = date[2] + "/" + date[1] + "/" + date[0];
        }
        i = 0;
        for (Field field : movies.getClass().getDeclaredFields()) {
            field.setAccessible(true);//Obligatoire si le field est private
            if (i < 12) {
                field.set(movies, token[i]);
            }
            i++;
        }
        if(token.length > 12 && token[12] != "")
            movies.Styles(token[12]);
        if(token.length > 13 && token[13] != "")
            movies.Director(token[13]);
        if(token.length-1 == 14)
            movies.Actor(token[14]);
        return movies;
    }
    public static void EcritureDocument(Film movies,BufferedWriter bw) throws IOException {
        printTag(bw, "Film",null, 1,false,true,false);
        printTag(bw, "Id",movies.get_id(), 2,true,false,false);
        printTag(bw, "Titre",movies.get_titre(), 2,true,false,false);
        printTag(bw, "TitreOriginal",movies.get_titreOriginal(), 2,true,false,false);
        printTag(bw, "DateSortie",movies.get_dateSortie(), 2,true,false,false);
        printTag(bw, "Status",movies.get_status(), 2,true,false,false);
        printTag(bw, "Note",movies.get_note(), 2,true,false,false);
        printTag(bw, "NbNote",movies.get_nbNote(), 2,true,false,false);
        printTag(bw, "Duree",movies.get_duree(), 2,true,false,false);
        printTag(bw, "Certification",movies.get_certification(), 2,true,false,false);
        printTag(bw, "Img",movies.get_image(), 2,true,false,false);
        printTag(bw, "Prix",movies.get_prix(), 2,true,false,false);
        printTag(bw, "Tagline",movies.get_tagline(), 2,true,false,false);

        printTag(bw, "List",null, 2,false,true,false);
        for (var item : movies.get_genres()) {
            printTag(bw, "Td", null, 3, false, true, false);
            printTag(bw, "Genre",null, 4,false,true,false);

            printTag(bw, "Id",item.get_id(), 5,true,false,false);
            printTag(bw, "Nom",item.get_nom(), 5,true,false,false);

            printTag(bw, "Genre",null, 4,false,false,true);
            printTag(bw, "Td", null, 3, false, false, true);
        }
        printTag(bw, "List",null, 2,false,false,true);

        printTag(bw, "List",null, 2,false,true,false);
        for (var item : movies.get_directeures()) {
            printTag(bw, "Td", null, 3, false, true, false);
            printTag(bw, "Directeur",null, 4,false,true,false);

            printTag(bw, "Id",item.get_id(), 5,true,false,false);
            printTag(bw, "Nom",item.get_nom(), 5,true,false,false);

            printTag(bw, "Directeur",null, 4,false,false,true);
            printTag(bw, "Td", null, 3, false, false, true);
        }
        printTag(bw, "List",null, 2,false,false,true);

        printTag(bw, "List",null, 2,false,true,false);
        for (var item : movies.get_acteures()) {
            printTag(bw, "Td", null, 3, false, true, false);
            printTag(bw, "Acteur",null, 4,false,true,false);

            printTag(bw, "Id",item.get_id(), 5,true,false,false);
            printTag(bw, "Nom",item.get_nom(), 5,true,false,false);
            printTag(bw, "Role",item.get_character(), 5,true,false,false);

            printTag(bw, "Acteur",null, 4,false,false,true);
            printTag(bw, "Td", null, 3, false, false, true);
        }
        printTag(bw, "List",null, 2,false,false,true);

        printTag(bw, "Film",null, 1,false,false,true);
    }

}
