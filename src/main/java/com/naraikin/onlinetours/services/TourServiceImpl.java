package com.naraikin.onlinetours.services;

import com.naraikin.onlinetours.common.exception.TourDAOException;
import com.naraikin.onlinetours.common.exception.TourServiceException;
import com.naraikin.onlinetours.models.dao.interfaces.TourDAO;
import com.naraikin.onlinetours.models.entities.TourE;
import com.naraikin.onlinetours.models.pojo.Tour;
import com.naraikin.onlinetours.models.repository.TourRepository;
import com.naraikin.onlinetours.services.interfaces.TourService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitrii on 25.02.17.
 */
@Service
public class TourServiceImpl implements TourService {
    private static Logger logger = Logger.getLogger(TourServiceImpl.class);


    private TourRepository tourDAO;

    @Autowired
    public void setTourDAO(TourRepository tourDAO) {
        this.tourDAO = tourDAO;
    }

    public List<Tour> getAllTourForClient() throws TourServiceException{
        List<Tour> list = new ArrayList<>();
        for(TourE tourE: tourDAO.findByBookingAndDeleted(new Short((short) 0), new Short((short) 0))){
            list.add(Tour.FromTourEToTour(tourE));
        }
        return list;
    }

    public List<Tour> getAllTour() throws TourServiceException {
        List<Tour> list = new ArrayList<>();
        for(TourE tourE: tourDAO.findAll()){
            list.add(Tour.FromTourEToTour(tourE));
        }
        return list;
    }

    public Tour getTourById(int id) throws TourServiceException {
        return Tour.FromTourEToTour(tourDAO.findOne(id));
    }

    public void updateTour(Tour tour) throws TourServiceException {
        TourE tourE = Tour.toTourE(tour);
        tourDAO.save(tourE);
    }

    public void createTour(Tour tour) throws TourServiceException {
        TourE tourE = Tour.toTourE(tour);
        tourDAO.save(tourE);
    }

    public void setDeleteTour(Tour tour) throws TourServiceException {
        TourE tourE = Tour.toTourE(tour);
        tourDAO.save(tourE);
    }

    public void setBooking(Tour tour) throws TourServiceException{
        TourE tourE = Tour.toTourE(tour);
        tourDAO.save(tourE);
    }

    public boolean isBookingNow(Tour tour) throws TourServiceException {
       return tour.getBooking() > 0;
    }
}
