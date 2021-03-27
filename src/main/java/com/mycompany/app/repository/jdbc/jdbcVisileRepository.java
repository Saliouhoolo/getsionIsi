package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;

import com.mycompany.app.domain.Visile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class jdbcVisileRepository implements VisileRepository{
    private DataSource dataSource;

        public jdbcVisileRepository(DataSource dataSource){
            this.dataSource = dataSource;
        }
    @Override
    public int add(Visile visile) {
        int ok = 0;
        String query = "INSERT INTO Visile (nom,prenom,Matricule,id_classe) VALUES(?,?,?,?)";
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,visile.getNom());
            statement.setString(2, visile.getPrenom());
            statement.setString(3, visile.getMatricule());
            statement.setInt(4, 1);
            ok = statement.executeUpdate();

            if (ok > 0) {
                System.out.println("Le Visile a eté ajoutés  avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Visile visile) {
        String query = "UPDATE  user SET nom=?, prenom=?, tel=?   where id=?";
        int ok = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,visile.getNom());
            statement.setString(2, visile.getPrenom());
            statement.setString(3, visile.getMatricule());
            statement.setInt(4, visile.getIdV());
            ok = statement.executeUpdate();

            System.out.println(statement);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("Le visile a eté  modifiée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }



    @Override
    public int delete(int idV) {
        String query = "DELETE FROM visile where id=?";
        int ok =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idV);
            ok = statement.executeUpdate();
            if (ok > 0) {
                System.out.println("Le Visile a eté  supprimée avec succés!");
            }
            return ok;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Visile[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM vigile e,classe c where e.id_classe = c.id";
        //mapper le résultat
        List<Visile> visiles= new ArrayList<Visile>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int idV = rs.getInt("idV");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String Matricule = rs.getString("Matricule");

                int IdC = rs.getInt("id_classe");
                String nomSalle = rs.getString("nom");
                String numero = rs.getString("numero");
                Classe classe1 = new Classe(IdC,nomSalle,numero);
                //mapping retour db (relationnel) avec objet Offre
                Visile visile= new Visile();

                visiles.add(visile);
            }
            return visiles.toArray(new Visile[0]);

        }
        catch (SQLException e) {
            return new Visile[0];
        }
        catch (Exception ex){
            return new Visile[0];
        }
    }
}
