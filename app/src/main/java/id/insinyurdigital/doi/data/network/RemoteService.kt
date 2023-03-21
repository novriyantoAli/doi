package id.insinyurdigital.doi.data.network

<<<<<<< HEAD
=======
import id.insinyurdigital.doi.data.model.LoginRequest
import id.insinyurdigital.doi.data.model.LoginResponse
import id.insinyurdigital.doi.domain.model.UserDetail
>>>>>>> Insyaallah selesai karena modal saya hanya pengetahuan
import retrofit2.http.*

interface RemoteService {
//    @GET("products")
//    suspend fun products(): ProductResponse
//
//    @GET("product/{id}")
//    suspend fun productDetail(@Path("id") id: Int): ProductDetailResponse
//
//    @GET("transaction")
//    suspend fun transactions(
//        @Query("page") page: Int
//    ): OrderResponse
//
//    @GET("transaction/{id}")
//    suspend fun transactionDetail(
//        @Path("id") id: Int
//    ): PaymentHistoryResponse
//
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
//
//    @GET("member/{id}")
//    suspend fun addresses(@Path("id") id: String): MemberAddressResponse
//
//    @POST("member/cart")
//    suspend fun postCart(@Body cartRequest: CartRequest): CartResponse
//
//    @GET("member/carts/{id}")
//    suspend fun carts(@Path("id") id: String): MemberCartsResponse
//
//    @PUT("member/carts/{id}")
//    suspend fun putCart(@Path("id") id: Int, @Body cartRequest: CartRequest): MemberCartsResponse
//
//    @DELETE("member/carts/{id}")
//    suspend fun deleteCart(@Path("id") id: Int): MemberCartsResponse
//
//    @POST("ongkir")
//    suspend fun postCourierCheck(@Body courierShipmentRequest: CourierShipmentRequest): CourierShipmentResponse
//
//    @POST("member/carts/convert")
//    suspend fun postCartOrderConvert(@Body convertCartOrderRequest: ConvertCartOrderRequest): MessageResponse
//
//    @GET("member/orders/{id}")
//    suspend fun getOrders(@Path("id") id: String): MemberOrdersResponse
}