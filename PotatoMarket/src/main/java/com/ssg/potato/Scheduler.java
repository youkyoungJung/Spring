package com.ssg.potato;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ssg.potato.dao.GroupDao;
import com.ssg.potato.domain.Auction;
import com.ssg.potato.domain.Bid;
import com.ssg.potato.service.AuctionService;
import com.ssg.potato.service.BidService;
import com.ssg.potato.service.SucbidService;

@Component
public class Scheduler {
   private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Scheduler.class);

   @Autowired
   private GroupDao groupDao;
   
   @Autowired
   private SucbidService sucbid;
   
   @Autowired
   private BidService bid;
   
   @Autowired
   private AuctionService auction;
   
   @Autowired 
   public void setSucbidService(SucbidService sucbid) {
      this.sucbid = sucbid;
   }
   
   @Autowired 
   public void setBidService(BidService bid) {
      this.bid = bid;
   }
   
   @Autowired 
   public void setAuctionService(AuctionService auction) {
      this.auction = auction;
   }

   @Scheduled(cron = "0 0 0 * * *")
   public void close() throws Exception{
      logger.info("매일 00시");
      
      Date end = new Date();
      Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DATE, -1);
        end = cal.getTime();
        
        groupDao.close(end);
        
        Date end_auction = new Date();
        Calendar cal_auction = Calendar.getInstance();
        cal_auction.setTime(end_auction);
        
        cal_auction.get(Calendar.DATE);
        end_auction = cal_auction.getTime();
        auction.closeAuction(end_auction);
        
        List<Auction> list = auction.selectCloseAuctionId();
      for (int i = 0; i < list.size(); i++) {
         int auction_id = list.get(i).getAuction_id();
         
         if (bid.dataCountBidCheck(auction_id) != 0) {
            int high_price = bid.selectBidHighBidPrice(auction_id);
            Bid b = bid.selectBid(auction_id, high_price);
            
            if (sucbid.getCountAuctionId(auction_id) == 0) {
               sucbid.insertNoConfirmSucbid(auction_id, b.getBuyer_id(), b.getBid_id(), high_price);      
               logger.info("중간 낙찰 성공 & 장바구니 추가 성공! ");
            } else {
               logger.info("이 상품은 이미 낙찰자가 존재함.");
            }
         } else {
            logger.info("이 상품은 입찰자가 없음.");
         }
               
      }   
      
   }

}