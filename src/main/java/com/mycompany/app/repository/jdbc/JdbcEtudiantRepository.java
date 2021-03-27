package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEtudiantRepository implements  EtudiantRepository{
    private DataSource dataSource;

    public JdbcEtudiantRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int add(Etudiant etudiant) {
        int ok = 0;
        String query = "INSERT INTO etudiant (nom,prenom,tel,id_classe) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getTel());
            statement.setInt(4, 1);
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("etudiant créé avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Etudiant etudiant ) {
        String query = "UPDATE  user SET nom=?, prenom=?, tel=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getTel());
            statement.setInt(4, etudiant.getIdE());
            ok = statement.executeUpdate();

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("etudiant est modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }



    @Override
    public int delete(int id) {
        String query = "DELETE FROM etudiant where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("etudiant est supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Etudiant[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM etudiant e,classe c where e.id_classe = c.id";
        //mapper le résultat
        List<Etudiant> etudiants = new ArrayList<Etudiant>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int idE = rs.getInt("idE");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String tel = rs.getString("tel");

                int IdC = rs.getInt("id_classe");
                String nomSalle = rs.getString("nomSalle");
                String numero = rs.getString("numero");
                Classe classe1 = new Classe(IdC,nomSalle,numero);
                //mapping retour db (relationnel) avec objet Offre
                Etudiant etudiant = new Etudiant( idE, nom,prenom,tel);

                etudiants.add(etudiant);
            }
            return etudiants.toArray(new Etudiant[0]);

        }
        catch (SQLException e) {
            return new Etudiant[0];
        }
        catch (Exception ex){
            return new Etudiant[0];
        }
    }
}
