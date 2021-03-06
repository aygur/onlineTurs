package com.naraikin.onlinetours.services.imp_deprecated;

import com.naraikin.onlinetours.common.exception.TravelVoucherDAOException;
import com.naraikin.onlinetours.common.exception.TravelVoucherServiceException;
import com.naraikin.onlinetours.models.dao.interfaces.TravelVoucherDAO;
import com.naraikin.onlinetours.models.pojo.Client;
import com.naraikin.onlinetours.models.pojo.TravelVoucher;
import com.naraikin.onlinetours.services.interfaces.TravelVoucherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dmitrii on 07.03.17.
 */
//@Service
@Deprecated
public class TravelVoucherServiceImpl implements TravelVoucherService {
    static Logger logger = Logger.getLogger(TravelVoucherServiceImpl.class);

    private TravelVoucherDAO travelVoucherDAO;

    //@Autowired
    //@Qualifier("TravelVoucherDAOImplH")
    public void setTravelVoucherDAO(TravelVoucherDAO travelVoucherDAO) {
        this.travelVoucherDAO = travelVoucherDAO;
    }
    

    public List<TravelVoucher> getAll() throws TravelVoucherServiceException {
        try {
            return travelVoucherDAO.getAll();
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }

    @Override
    public int createTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException {
        try {
            return travelVoucherDAO.createTravelVoucher(travelVoucher);
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }


    @Override
    public TravelVoucher getTravelVoucherById(int id) throws TravelVoucherServiceException {
        try {
            return travelVoucherDAO.getTravelVoucherById(id);
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }

    @Override
    public Integer deleteTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException{
        try {
            return travelVoucherDAO.deleteTravelVoucher(travelVoucher);
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }

    @Override
    public List<TravelVoucher> getAllByClient(Client client)  throws TravelVoucherServiceException{
        try {
            return travelVoucherDAO.getAllByClient(client);
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }

    @Override
    public Integer updateTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException {
        try {
            return travelVoucherDAO.updateTravelVoucher(travelVoucher);
        } catch (TravelVoucherDAOException e) {
            logger.error(e);
            throw new TravelVoucherServiceException();
        }
    }
}
