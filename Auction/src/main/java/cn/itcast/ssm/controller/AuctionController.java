package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.Auction;
import cn.itcast.ssm.po.Bid;
import cn.itcast.ssm.po.SysUser;
import cn.itcast.ssm.service.AuctionService;
import cn.itcast.ssm.service.SysService;
import cn.itcast.ssm.utils.CountDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GoFocus
 * @Date: 2019-08-23
 * @Time: 16:52
 * @Description:
 */


@Controller
@RequestMapping("/auction")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @Autowired
    private SysService sysService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody
    public Auction[] getAuctionHistory() {
        List<Auction> autcionHistory = auctionService.getAutcionHistory();
        Auction[] auctions = new Auction[autcionHistory.size()];

        return autcionHistory.toArray(auctions);


    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public int insert(HttpServletRequest request, Auction auction, int countDown) throws InterruptedException {
//        LinkedList<Bid> bidsList = new LinkedList<>();
        HashMap<Integer, Integer> bidsMap = new HashMap<>();
        HttpSession session = request.getSession();
//        session.setAttribute("bidsList", bidsList);
        session.setAttribute("bidsMap", bidsMap);

        auction.setAuctionTime(new Date());
        auctionService.insert(auction);

        System.out.println("计时开始");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
/*                auction.setAuctioneer("川川");
                auction.setHighestBid(200);
                auction.setSecondBid(100);
                auction.setSuccessfulBidder("川川");*/
                HashMap<Integer, Integer> bidsMap = (HashMap<Integer, Integer>) session.getAttribute("bidsMap");
                if (bidsMap.size() == 1) {
                    Iterator iter = bidsMap.entrySet().iterator();
                    while(iter.hasNext()) {
                        Map.Entry entry = (Map.Entry)iter.next();
                        int userId = (Integer)entry.getKey();
                        int highestBid = (Integer)entry.getValue();
                        auction.setHighestBid(highestBid);

                        SysUser userById = sysService.findUserById(userId);
                        String username = userById.getUsername();
                        auction.setSuccessfulBidder(username);

                    }
                }

                Object maxValue = getMaxValue(bidsMap);


                auctionService.deal(auction);
                System.out.println("倒计时结束，拍卖结束");
            }
        }, countDown * 1000);
        TimeUnit.SECONDS.sleep(countDown);
        timer.cancel();

        return auction.getId();//返回自增主键
    }


    //    出价，存放在session中
    @RequestMapping(value = "/bid", method = RequestMethod.POST)
    @ResponseBody
    public boolean bid(HttpServletRequest request, Bid bid) {
        HttpSession session = request.getSession();
        HashMap<Integer, Integer> bidsMap = (HashMap<Integer, Integer>) session.getAttribute("bidsMap");
        int userId = bid.getUserId();
        int bidPoint = bid.getBidPoint();
        if (bidsMap.containsKey(userId)) {
            bidsMap.replace(userId, bidPoint);
        } else {
            bidsMap.put(userId, bidPoint);
        }
        session.setAttribute("bidsMap", bidsMap);
        return true;
    }

    //撤销出价
    @RequestMapping(value = "/bid_remove", method = RequestMethod.POST)
    @ResponseBody
    public boolean bid_remove(HttpServletRequest request, int user_id) {
        HttpSession session = request.getSession();
        HashMap<Integer, Integer> bidsMap = (HashMap<Integer, Integer>) session.getAttribute("bidsMap");
        if (bidsMap.containsKey(user_id)) {
            bidsMap.remove(user_id);
            session.setAttribute("bidsMap", bidsMap);
        } else
            return false;

        return true;
    }


    public static Object getMaxValue(Map<Integer, Integer> map) {
        if (map == null)
            return null;
        int length = map.size();
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        return obj[length - 1];

    }
}
