
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import com.mcoolapp.sttestapp.model.Platform
import com.mcoolapp.sttestapp.model.Quote

class Datum{
    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("symbol")
    @Expose
    var symbol: String? = null

    @SerializedName("slug")
    @Expose
    var slug: String? = null

    @SerializedName("num_market_pairs")
    @Expose
    var numMarketPairs: Long = 0

    @SerializedName("date_added")
    @Expose
    var dateAdded: String? = null

    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null

    @SerializedName("max_supply")
    @Expose
    var maxSupply = 0.0

    @SerializedName("circulating_supply")
    @Expose
    var circulatingSupply = 0.0

    @SerializedName("total_supply")
    @Expose
    var totalSupply = 0.0

    @SerializedName("platform")
    @Expose
    var platform: Platform? = null

    @SerializedName("cmc_rank")
    @Expose
    var cmcRank: Long = 0

    @SerializedName("last_updated")
    @Expose
    var lastUpdated: String? = null

    @SerializedName("quote")
    @Expose
    var quote: Quote? = null

}