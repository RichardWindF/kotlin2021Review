package com.example.kotlin2022review.bean

data class CarsKotlinClass(
    val backfillCount: Int,
    val dealerNewCount: Int,
    val dealerUsedCount: Int,
    val enhancedCount: Int,
    val listings: List<Listings>,
    val page: Int,
    val pageSize: Int,
    val searchArea: SearchArea,
    val totalListingCount: Int,
    val totalPageCount: Int
)

data class Listings(
    val advantage: Boolean,
    val backfill: Boolean,
    val badge: String,
    val bedLength: String,
    val bodytype: String,
    val cabType: String,
    val certified: Boolean,
    val currentPrice: Double,
    val dealer: Dealer,
    val dealerType: String,
    val displacement: String,
    val distanceToDealer: Double,
    val drivetype: String,
    val engine: String,
    val exteriorColor: String,
    val firstSeen: String,
    val followCount: Int,
    val following: Boolean,
    val fuel: String,
    val hasViewed: Boolean,
    val id: String,
    val imageCount: Int,
    val images: Images,
    val interiorColor: String,
    val isEnriched: Boolean,
    val listPrice: Double,
    val make: String,
    val mileage: Int,
    val model: String,
    val monthlyPaymentEstimate: MonthlyPaymentEstimate,
    val mpgCity: Int,
    val mpgHighway: Int,
    val noAccidents: Boolean,
    val oneOwner: Boolean,
    val onePrice: Double,
    val onlineOnly: Boolean,
    val personalUse: Boolean,
    val recordType: String,
    val sentLead: Boolean,
    val sentLeadAt: Any,
    val serviceRecords: Boolean,
    val sortScore: Double,
    val stockNumber: String,
    val subTrim: String,
    val topOptions: List<String>,
    val transmission: String,
    val trim: String,
    val vdpUrl: String,
    val vehicleCondition: String,
    val vin: String,
    val year: Int
)

data class SearchArea(
    val city: String,
    val dynamicRadii: List<Double>,
    val dynamicRadius: Boolean,
    val latitude: Double,
    val longitude: Double,
    val radius: Double,
    val state: String,
    val zip: String
)

data class Dealer(
    val address: String,
    val carfaxId: String,
    val city: String,
    val dealerAverageRating: Double,
    val dealerInventoryUrl: String,
    val dealerReviewCount: Int,
    val dealerReviewDate: String,
    val dealerReviewRating: Int,
    val dealerReviewReviewer: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val onlineOnly: Boolean,
    val phone: String,
    val state: String,
    val zip: String
)

data class Images(
    val baseUrl: String,
    val firstPhoto: FirstPhoto,
    val large: List<String>,
    val medium: List<String>,
    val small: List<String>
)

data class MonthlyPaymentEstimate(
    val downPaymentAmount: Double,
    val downPaymentPercent: Double,
    val interestRate: Double,
    val loanAmount: Double,
    val monthlyPayment: Double,
    val price: Double,
    val termInMonths: Int
)

data class FirstPhoto(
    val large: String,
    val medium: String,
    val small: String
)

//-----------------------------------------------------------------
