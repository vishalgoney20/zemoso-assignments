package com.example.sharingapp;

import android.content.Context;

/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {


	 
    private Bid bid;
    public DeleteBidCommand(Bid bi) {
      
	 this.bid = bid;
    }

    // Delete bid remotely
    public void execute(){
       ElasticSearchManager.RemoveBidTask remove_bid = new ElasticSearchManager.RemoveBidTask();
        Remove_bid.execute(this.bid);

        try {
            if(remove_bid.get()) {
                super.setIsExecuted(true);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
       
    }
    
}


/*  To delete bid locally

private BidList bid_list;
    private Bid bid;
    private Context context;

    public DeleteBidCommand(BidList bid_list, Bid bid, Context context) {
        this.bid_list = bid_list;
        this.bid = bid;
        this.context = context;
    }

    // Delete bid locally
    public void execute(){
        bid_list.removeBid(bid);
        super.setIsExecuted(bid_list.saveBids(context));
    }
*/
