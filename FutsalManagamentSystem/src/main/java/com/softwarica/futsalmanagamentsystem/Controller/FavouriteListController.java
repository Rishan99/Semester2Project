/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDao;
import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDao;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishan
 */
public class FavouriteListController {
//    final FutsalDao futsalDao = new FutsalDaoImpl();
    final FavouriteDao favouriteDao = new FavouriteDaoImpl();
    public List<Futsal> futsalList = new ArrayList<>();
    final UserProvider currentUser = UserProvider.getInstance();
    
   public FavouriteListController(){
       getList();
}
   
   
   public void getList(){
    try{   
     futsalList=favouriteDao.getList();
}
catch(Exception ex){
     futsalList = new ArrayList<>(); 
    }
   }
   
   public void onRemove(int futsalId) throws Exception{
      favouriteDao.removeFromFavourite(futsalId, currentUser.getUserId());
   }
       
}
