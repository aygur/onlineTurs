package com.naraikin.onlinetours.services;

import com.naraikin.onlinetours.common.exception.TravelVoucherDAOException;
import com.naraikin.onlinetours.common.exception.TravelVoucherServiceException;
import com.naraikin.onlinetours.models.dao.interfaces.TravelVoucherDAO;
import com.naraikin.onlinetours.models.entities.TravelVoucherE;
import com.naraikin.onlinetours.models.pojo.Client;
import com.naraikin.onlinetours.models.pojo.TravelVoucher;
import com.naraikin.onlinetours.models.repository.TravelVoucherRepository;
import com.naraikin.onlinetours.services.interfaces.TravelVoucherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitrii on 07.03.17.
 */
@Service
public class TravelVoucherServiceImpl implements TravelVoucherService {
    static Logger logger = Logger.getLogger(TravelVoucherServiceImpl.class);

    private TravelVoucherRepository travelVoucherDAO;

    @Autowired
    @Qualifier("TravelVoucherRepository")
    public void setTravelVoucherDAO(TravelVoucherRepository travelVoucherDAO) {
        this.travelVoucherDAO = travelVoucherDAO;
    }

    public List<TravelVoucher> getAll() throws TravelVoucherServiceException {
        logger.trace("Spring Data == > ");
        List<TravelVoucher> travelVouchers =  new ArrayList<>();
        for(TravelVoucherE travelVoucherE : travelVoucherDAO.findAll()){
            travelVouchers.add(TravelVoucher.returnTravelVoucher(travelVoucherE));
        }
        return travelVouchers;
    }

    @Override
    public int createTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException {

        return travelVoucherDAO.save(TravelVoucher.returnTravelVoucherE(travelVoucher)).getIdtravel_voucher();
    }


    @Override
    public TravelVoucher getTravelVoucherById(int id) throws TravelVoucherServiceException {
            return TravelVoucher.returnTravelVoucher(travelVoucherDAO.findOne(id));
    }

    @Override
    public Integer deleteTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException{
        travelVoucherDAO.delete(TravelVoucher.returnTravelVoucherE(travelVoucher));
        return 0;
    }

    @Override
    public List<TravelVoucher> getAllByClient(Client client)  throws TravelVoucherServiceException{
        List<TravelVoucher> travelVouchers =  new ArrayList<>();
        for(TravelVoucherE travelVoucherE : travelVoucherDAO.findByClient(Client.FromClientToClientE(client))){
            travelVouchers.add(TravelVoucher.returnTravelVoucher(travelVoucherE));
        }
        return travelVouchers;
    }

    @Override
    public Integer updateTravelVoucher(TravelVoucher travelVoucher) throws TravelVoucherServiceException {
        return travelVoucherDAO.save(TravelVoucher.returnTravelVoucherE(travelVoucher)).getIdtravel_voucher();
    }
}
