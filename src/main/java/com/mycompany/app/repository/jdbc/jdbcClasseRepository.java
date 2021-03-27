package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcClasseRepository  implements  ClasseRepository {
    private DataSource dataSource;
    private String tel;

    public jdbcClasseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int add(Classe classe) {
        int ok = 0;
        String query = "INSERT INTO classe (nomsale,numero,idE) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, classe.getnomSalle());
            statement.setString(2, classe.getnumero());
            statement.setInt(4, classe.getIdC());
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("La classe  a eté ajouté!");
            }
            return ok;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Classe classe) {
        return 0;
    }

    @Override
    public int delete(int idC) {
        String query = "DELETE FROM classe where idC=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idC);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("la Classe est supprimé!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    @Override
    public Classe[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM classe e,etudiant c where e.idC = c.id";
        //mapper le résultat
        List<Classe> classes = new ArrayList<Classe>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int idC = rs.getInt("idC");
                String nomSalle = rs.getString("nomSalle");
                String numero= rs.getString("numero");

                int IdE= rs.getInt("idE");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel = rs.getString("tel");

                Etudiant etudiant = new Etudiant( IdE, nom,prenom,tel);
                //mapping retour db (relationnel) avec objet Offre
                Classe classe1 = new Classe( idC, numero,nomSalle);

                Classe.add(classe1);
            }
            return classes.toArray(new Classe[0]);

        }
        catch (SQLException e) {
            return new Classe[0];
        }
        catch (Exception ex){
            return new Classe[0];
        }
    }
}