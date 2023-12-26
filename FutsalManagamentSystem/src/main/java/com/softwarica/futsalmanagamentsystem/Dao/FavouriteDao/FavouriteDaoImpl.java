package com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.softwarica.futsalmanagamentsystem.database.*;
import com.softwarica.futsalmanagamentsystem.model.CourtType;
import com.softwarica.futsalmanagamentsystem.model.Favourite;
import com.softwarica.futsalmanagamentsystem.model.Futsal;

public class FavouriteDaoImpl implements FavouriteDao {

    public List<Futsal> getList() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {

            var statement = dataConnection.createStatement();
            var data = statement
                    .executeQuery("SELECT f.* from futsal f INNER JOIN favourite fab on f.id = fab.futsal_id");
            List<Futsal> listData = new ArrayList<>();
            while (data.next()) {
                listData.add(new Futsal(data));
            }
            data.close();
            statement.close();
            dataConnection.close();
            return listData;
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void addToFavourite(int futsalId, int userId) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("INSERT INTO favourtie (futsal_id,user_id) VALUES (?,?)");
            statement.setInt(1, futsalId);
            statement.setInt(2, userId);
            statement.execute();

            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void removeFromFavourite(int futsalId, int userId) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("DELETE FROM favourtie where user_id = ? & futsal_id = ?");
            statement.setInt(1, userId);
            statement.setInt(2, futsalId);
            statement.execute();

            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

}