package com.example.sharingapp;

import android.content.Context;

/**
 * Command to add a bid
 */
public class AddBidCommand extends Command {

    private Bid bid;

    public AddBidCommand( Bid bid) {
        this.bid = bid;
        }

    // Save bid remotely
    public void execute(){

       ElasticSearchManager.AddBidTask add_bid = new ElasticSearchManager.AddBidTask();
        add_bid.execute(this.bid);

        try {
            if(add_bid.get()) {
                super.setIsExecuted(true);
            }
        } 
	catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
    }
}


/*  To save bid locally

    private BidList bid_list;
    private Bid bid;
    private Context context;

    public AddBidCommand(BidList bid_list, Bid bid, Context context) {
        this.bid_list = bid_list;
        this.bid = bid;
        this.context = context;
    }

    // Save bid locally
    public void execute(){
        bid_list.addBid(bid);
        super.setIsExecuted(bid_list.saveBids(context));
    }
*/

