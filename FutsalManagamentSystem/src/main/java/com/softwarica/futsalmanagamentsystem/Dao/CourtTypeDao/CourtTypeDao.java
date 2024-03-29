package com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao;

import java.util.List;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;

public interface CourtTypeDao {

    public List<CourtType> getList() throws Exception;

    public void insert(CourtType court) throws Exception;

    public CourtType getById(int id) throws Exception;

    public void update(int id, CourtType court) throws Exception;

    public void deleteById(int id) throws Exception;

}
