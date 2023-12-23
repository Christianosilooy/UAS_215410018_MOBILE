import id.utdi.christianoimanuelsilooy.models.ListPrice
import id.utdi.christianoimanuelsilooy.models.RetailPrice
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Offers (

    @SerializedName("finskyOfferType") val finskyOfferType : Int,
    @SerializedName("listPrice") val listPrice : ListPrice,
    @SerializedName("retailPrice") val retailPrice : RetailPrice
) : Serializable